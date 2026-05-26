package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseRowValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.ParsedFormula;
import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("FormulaParserFormValidationFixed")
public class FormulaParserFormValidationFixed extends BaseRowValidation {
	protected String comparatorForm;
	protected String operationForm;
	protected String operationErrMsg;
	protected int scale;

	public FormulaParserFormValidationFixed() {
		super();
	}

	public FormulaParserFormValidationFixed(String parameter) {
		super(parameter);
	}

	@Override
	public FormulaParserFormValidationFixed initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		operationForm = getStringParameter("operationForm");
		operationErrMsg = getStringParameter("operationErrMsg");
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
		String[] operationErrMsgs = StringUtils.split(operationErrMsg, "|");

		if (fields.length != operations.length || operationErrMsgs.length != operations.length)
			throw new IllegalStateException();

		final Logger logger = LoggerFactory.getLogger(FormulaParserFormValidationFixed.class);

		for (int i = 0; i < fields.length; i++) {
			ParsedFormula parsed = parse(operations[i]);
			BigDecimal selectValue = getCurrentValue(validationResult, fields[i]);
			BigDecimal result = calculateFormula(parsed);

			if(selectValue.compareTo(result) != 0) {
				List<SubmissionField> field = submissionFormat.getFields();
				SubmissionField submissionField = field.get(Integer.parseInt(fields[i]));
				logger.error("{}>{}?{} :: Ops {}", parameter, selectValue, result, i);
				validationResult.errors.add(new ValidationError(submissionField,
						ValidationErrorCode.E03_35_EQUAL_FORM, operationErrMsgs[i] ));

			}
		}
	}

	private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
		return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
	}

	private BigDecimal calculateFormula(ParsedFormula parsed) {
		BigDecimal formulaResult = BigDecimal.ZERO;
		Map<String, String> formValue;

		for (FormulaParser.Group g : parsed.getGroups()) {
			BigDecimal groupTotal = BigDecimal.ZERO;

			for (FormulaParser.RowToken t : g.getTokens()) {
				formValue = SubmissionFormat.getFormValue(comparatorForm + t.getRowCode());
				BigDecimal rowTotal = BigDecimal.ZERO;
				for (int i = 0; i < t.getOperands().size(); i++) {
					FormulaParser.Operand o = t.getOperands().get(i);
					if (isInvalidNumeric(formValue.get(o.getField()))) return BigDecimal.ZERO;

					BigDecimal fieldValue = new BigDecimal(formValue.get(o.getField()));
					rowTotal = calculateOperand(rowTotal, fieldValue, o.getOperator());
				}
				groupTotal = calculateOperand(groupTotal, rowTotal, t.getOperator());
			}
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