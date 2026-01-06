package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ValueDeviationValidation")
public class ValueDeviationValidation extends MapParamSegmentValidation {
	private String selectField;
	private String selectPosCode;
	private String value;
	private String deviation;

	public ValueDeviationValidation() {
		super();
	}

	public ValueDeviationValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ValueDeviationValidation initialized() {
		selectField = getStringParameter("selectField");
		selectPosCode = getStringParameter("selectPosCode");
		value = getStringParameter("value");
		deviation = getStringParameter("deviation");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		BigDecimal expectedValue = toBigDecimal(value, 0);
		BigDecimal deviationValue = toBigDecimal(deviation);
		String posCode = validationResult.getColumn(1);
		BigDecimal min = expectedValue.subtract(deviationValue);
		BigDecimal max = expectedValue.add(deviationValue);

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				if (posCode.contains(arrSelectPosCode[i]) && !validateValue(min, max, fieldValueString)) {
					SubmissionField submissionField = fields.get(Integer.parseInt(field));
					validationResult.errors.add(new ValidationError(submissionField,
							ValidationErrorCode.E11_07_EQUAL, value));
				}
			}
		}
	}

	private boolean validateValue(BigDecimal min, BigDecimal max, String realValue) {
		BigDecimal tmp = toBigDecimal(realValue, 0);
		return tmp.compareTo(min) > -1 && tmp.compareTo(max) < 1;
	}
}