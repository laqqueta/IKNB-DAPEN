package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.BaseRowFormulaValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@XStreamAlias("ComparisonFormValidationFilterV2")
public class ComparisonFormValidationFilterV2 extends BaseRowFormulaValidation {
	protected String comparatorForm;
	protected String comparatorField;
	private String filterColumn;
	private String filterValues;

	private final AtomicReference<String> filterVal = new AtomicReference<>();

	public ComparisonFormValidationFilterV2(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidationFilterV2 initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		comparatorField = getStringParameter("comparatorField");
		filterColumn = getStringParameter("filterColumn");
		filterValues = getStringParameter("filterValues");
		return this;
	}

	@Override
	public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {

			List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
			String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

			if (!filters.contains(filterFieldValue)) return;
			filterVal.set(filterFieldValue);

			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrSelectField.length; i++) {
				engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
				compare(engine, submissionFormat, validationResult, arrSelectField[i]);
			}
		}

	}

	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		String[] arrComparatorField = StringUtils.split(comparatorField, '|');
		BigDecimal res = BigDecimal.ZERO;
		for (String field : arrComparatorField) {
			res = res.add(SubmissionFormat.getSumTreeMapPosFormValue(
					comparatorForm, comparatorPosCode, field,
					filterColumn, filterVal.get()
			).setScale(scale, RoundingMode.HALF_UP));
		}
		return res;
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormValidationFilterV2.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			SubmissionField sfJenisProgram = fields.get(Integer.parseInt(filterColumn));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
					comparatorValue, genMessage() + " pada '" + sfJenisProgram.getName() + "' = " + filterVal.get()));
		} else {
			logger.trace("{}>{}?{}", parameter, selectValue, comparatorValue);
		}
	}

	public String genMessage() {
		List<Integer> comparatorFieldAsInt = new ArrayList<Integer>();
		for (String field : StringUtils.split(comparatorField, "|")) {
			comparatorFieldAsInt.add(Integer.parseInt(field) + 1);
		}
		String comparatorFieldAsString = comparatorFieldAsInt.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining(",", "", ""));

		String res = "";
		if (StringUtils.isNotEmpty(msgError)) {
			if (msgError.contains("|")) {
				res = msgError.replace("|", " " + Comparation.valueOf(operator).getDesc() + " ");
			} else {
				res = msgError + " " + Comparation.valueOf(operator).getDesc() + " total nilai form " + comparatorForm + ", kode baris "
						+ comparatorPosCode + ", kolom " + comparatorFieldAsString;
			}
		} else {
			res = Comparation.valueOf(operator).getDesc() + " total nilai form " + comparatorForm + ", kode baris "
					+ comparatorPosCode + ", kolom " + comparatorFieldAsString;
		}
		return res.trim();
	}
}