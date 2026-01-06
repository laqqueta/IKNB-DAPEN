package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

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

@XStreamAlias("StringComparisonFormValidation")
public class StringComparisonFormValidation extends BaseRowStringValidation {
	private String comparatorForm;
	private String comparatorField;

	public StringComparisonFormValidation() {
		super();
	}

	public StringComparisonFormValidation(String parameter) {
		super(parameter);
	}

	@Override
	public StringComparisonFormValidation initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		comparatorField = getStringParameter("comparatorField");
		return this;
	}

	@Override
	protected String getComparatorValue(String idxSelectField) {
		return SubmissionFormat.getPosFormValue(comparatorForm, comparatorPosCode, comparatorField);
	}

	@Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(StringComparisonFormValidation.class);
		String selectValue = getSelectValue(validationResult, idxSelectField);
		String comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
					comparatorValue, genMessage()));
		} else {
			logger.trace("{" + parameter + "}>" + selectValue + "?" + comparatorValue);
		}
	}
	
	private String genMessage() {
		String res = "";
		if (StringUtils.isNotEmpty(msgError)) {
			res = msgError.replace("|", " " + Comparation.valueOf(operator).getDesc() + " ");
		} else {
			res = Comparation.valueOf(operator).getDesc() + " nilai form " + comparatorForm + ", kode baris "
					+ comparatorPosCode + ", kolom " + (Integer.parseInt(comparatorField) + 1);
		}
		return res;
	}
}