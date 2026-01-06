package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("LessEqualsValidation")
public class LessEqualsValidation extends BaseRowValidation {
	private String comparatorRowCode;

	public LessEqualsValidation() {
		super();
	}

	public LessEqualsValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public LessEqualsValidation initialized() {
		super.initialized();
		comparatorRowCode = getStringParameter("comparatorRowCode");
		return this;
	}
	
	private BigDecimal getComparator1Value(String column) {
		return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparatorRowCode, column, 2);
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String posCode = validationResult.getColumn(1);
		if (selectPosCode.contains(posCode)) {
			for (String field : arrSelectField) {
				String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
				BigDecimal comparator = getComparator1Value(field);
				if (!isLessEquals(fieldValueString, comparator)) {
					SubmissionField submissionField = fields.get(Integer.parseInt(field));
					validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_09_LESS_EQUAL, comparator));
				}
			}
		}
	}
	
	private boolean isLessEquals(String value, BigDecimal comparator) {
		return StringUtils.isNotEmpty(value) && toBigDecimal(value).compareTo(comparator) < 1;
	}
}