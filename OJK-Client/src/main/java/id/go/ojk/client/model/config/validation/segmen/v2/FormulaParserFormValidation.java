package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseRowValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
import id.go.ojk.client.model.config.validation.segmen.v2.util.constant.MessageType;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.ParsedFormula;
import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("FormulaParserFormValidation")
public class FormulaParserFormValidation extends BaseRowValidation {
	protected String comparatorForm;
	protected String operationForm;
	protected MessageType messageType;
	protected int scale;

	public FormulaParserFormValidation() {
		super();
	}

	public FormulaParserFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	public FormulaParserFormValidation initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		operationForm = getStringParameter("operationForm");
		messageType = getMessageTypeParameter("messageType");
		scale = getIntParameter("scale");

		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String currentRowCode = validationResult.getColumn(1);
		List<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
				.collect(Collectors.toList());

		if (!selectRowCodes.contains(currentRowCode)) return;

		String[] fields = StringUtils.split(selectField, "|");
		String[] operations = StringUtils.split(operationForm, "|");

		if (fields.length != operations.length)
			throw new IllegalStateException();

		final Logger logger = LoggerFactory.getLogger(FormulaParserFormValidation.class);

		for (int i = 0; i < fields.length; i++) {
			ParsedFormula parsed = parse(operations[i]);
			StringBuilder errorBuilder = new StringBuilder();
			BigDecimal selectValue = getCurrentValue(validationResult, fields[i]);
			BigDecimal result = calculateFormula(parsed, errorBuilder);

			if(selectValue.compareTo(result) != 0) {
				List<SubmissionField> field = submissionFormat.getFields();
				SubmissionField submissionField = field.get(Integer.parseInt(fields[i]));
				logger.error("{}>{}?{}", parameter, selectValue, result);
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E03_04_EQUAL_FORM, errorBuilder, comparatorForm ));

			}
		}
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
	}

	private BigDecimal calculateFormula(FormulaParser.ParsedFormula parsed, StringBuilder errBuilder) {
		BigDecimal formulaResult = BigDecimal.ZERO;
		Map<String, String> formValue;
		boolean isMultipleGroups = false;
		int ctr = 0;

		for (FormulaParser.Group g : parsed.getGroups()) {
			BigDecimal groupTotal = BigDecimal.ZERO;

			if (!g.getOperator().isEmpty()) operatorMessageBuilder(errBuilder, g.getOperator());
			if (parsed.getGroups().size() > 1 && g.getTokens().size() > 1) {
				errBuilder.append("( ");
				isMultipleGroups = true;
			}
			for (FormulaParser.RowToken t : g.getTokens()) {
				formValue = SubmissionFormat.getFormValue(comparatorForm + t.getRowCode());
				BigDecimal rowTotal = BigDecimal.ZERO;

				if (!t.getOperator().isEmpty()) errBuilder
						.append(" ")
						.append(t.getOperator())
						.append(" ");

				if (messageType == MessageType.SIMPLE) errBuilder.append("total Penjumlahan ");

				errBuilder.append("baris ")
						.append(t.getRowCode())
						.append(" ");

				for (int i = 0; i < t.getOperands().size(); i++) {
					FormulaParser.Operand o = t.getOperands().get(i);
					if (isInvalidNumeric(formValue.get(o.getField()))) return BigDecimal.ZERO;

					BigDecimal fieldValue = new BigDecimal(formValue.get(o.getField()));
					rowTotal = calculateOperand(rowTotal, fieldValue, o.getOperator());

					if (!o.getOperator().isEmpty() && messageType == MessageType.DETAIL) errBuilder
							.append(o.getOperator());

					errBuilder.append("kolom ")
							.append(o.getField());

					if (messageType == MessageType.SIMPLE) {
						if (t.getOperands().size() > 1 && i < t.getOperands().size() - 1) {
							errBuilder.append(",");
						} else if (t.getOperands().size() == 1) {
							errBuilder.append("&");
						}
					}
				}
				groupTotal = calculateOperand(groupTotal, rowTotal, t.getOperator());
			}

			if (isMultipleGroups) errBuilder.append(" )");
			if (++ctr % 2 == 0 && isMultipleGroups) errBuilder.append("\n");

			isMultipleGroups = false;

			formulaResult = calculateOperand(formulaResult, groupTotal, g.getOperator());
		}

		return formulaResult;
	}

	private BigDecimal calculateOperand(BigDecimal value, BigDecimal tmpVal, String operator) {
		if (operator.isEmpty()) {
			value = tmpVal;
		} else {
			switch (operator) {
				case "+":
					value = value.add(tmpVal);
					break;
				case "-":
					value = value.subtract(tmpVal);
					break;
				case "*":
					value = value.multiply(tmpVal);
					break;
				default:
					throw new UnsupportedOperationException();
			}
		}

		return value
				.setScale(scale, RoundingMode.HALF_UP);
	}

	private void operatorMessageBuilder(StringBuilder sb, String operator) {
		switch (operator) {
			case "+":
				sb.append(" + ");
				break;
			case "-":
				sb.append(" - ");
				break;
			case "*":
				sb.append(" * ");
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
}