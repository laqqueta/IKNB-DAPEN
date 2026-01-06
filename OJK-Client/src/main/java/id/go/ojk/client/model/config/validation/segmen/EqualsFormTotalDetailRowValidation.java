package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsFormTotalDetailRowValidation")
public class EqualsFormTotalDetailRowValidation extends BaseRowValidation {
	protected String comparatorForm;
	protected String msgError;

	public EqualsFormTotalDetailRowValidation() {
		super();
	}

	public EqualsFormTotalDetailRowValidation(String parameter) {
		super(parameter);
	}

	@Override
	public EqualsFormTotalDetailRowValidation initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		msgError = getStringParameter("msgError");
		return this;
	}

	protected int getComparatorValue() {
		return SubmissionFormat.getFormTotalRow(comparatorForm);
	}

	protected String getCurrentValue(ValidationResult validationResult, int idxSelectField) {
		return validationResult.getColumn(idxSelectField);
	}

	protected String genMessage() {
		return StringUtils.isNotEmpty(msgError) ? msgError.replace("|", " harus sama dengan ") : "";
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		final Logger logger = LoggerFactory.getLogger(EqualsFormTotalDetailRowValidation.class);
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {
			boolean validated = false;
			int comparator = getComparatorValue();
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (int i = 0; i < arrSelectField.length; i++) {
				int idxCurrentColumn = Integer.parseInt(arrSelectField[i]);
				int current = 0;
				try {
					current = Integer.parseInt(getCurrentValue(validationResult, idxCurrentColumn));
					validated = current == comparator;
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
				if (!validated) {
					logger.error("current={};comparator={}", current, comparator);
					List<SubmissionField> fields = submissionFormat.getFields();
					SubmissionField submissionField = fields.get(idxCurrentColumn);
					validationResult.errors.add(
							new ValidationError(submissionField, ValidationErrorCode.E50_10_FORMULA2, genMessage()));
				}
			}
		}
	}
}