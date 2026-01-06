package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ComparisonFormValidation")
public class ComparisonFormValidation extends BaseRowFormulaValidation {
	protected String comparatorForm;
	protected String comparatorField;

	public ComparisonFormValidation() {
		super();
	}

	public ComparisonFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidation initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		comparatorField = getStringParameter("comparatorField");
		return this;
	}

	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		String[] arrComparatorField = StringUtils.split(comparatorField, '|');
		BigDecimal res = BigDecimal.ZERO;
		for (String field : arrComparatorField) {
			res = res.add(SubmissionFormat.getSumMapPosFormValue(comparatorForm, comparatorPosCode, field).setScale(scale, RoundingMode.HALF_UP));
		}
		return res;
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormValidation.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
					comparatorValue, genMessage()));
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