package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

@XStreamAlias("FactorValidation")
public class FactorValidation extends BaseDecimalValidation {
	private String posCodeJumlahAset;
	private String posCodeJumlahLiabilitas;

	public FactorValidation() {
		super();
	}

	public FactorValidation(String parameter) {
		super(parameter);
	}

	@Override
	public FactorValidation initialized() {
		super.initialized();
		posCodeJumlahAset = getStringParameter("posCodeJumlahAset");
		posCodeJumlahLiabilitas = getStringParameter("posCodeJumlahLiabilitas");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(FactorValidation.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrSelectField = StringUtils.split(selectField, "|");
		String[] arrSelectPosCode = StringUtils.split(selectPosCode, "|");
		String posCode = validationResult.getColumn(1);

		for (String field : arrSelectField) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			for (int i = 0; i < arrSelectPosCode.length; i++) {
				validateValue(logger, field, arrSelectPosCode[i], posCode, fieldValueString, fields.get(Integer.parseInt(field)),
						validationResult);
			}
		}
	}

	private void validateValue(Logger logger, String field, String selectPosCode, String posCode, 
			String fieldValueString, SubmissionField submissionField, ValidationResult validationResult) {
		if (posCode.equals(selectPosCode)) {
			BigDecimal realValue = toBigDecimal(fieldValueString);
			BigDecimal expectedValue = getComparatorValue(field);
			if (realValue.compareTo(expectedValue) != 0) {
				logger.error("pos=" + selectPosCode + ";col=" + field + ";realValue=" + realValue + ";expectedValue=" + expectedValue);
				validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL,
						String.valueOf(expectedValue)));
			}
		}
	}

	private BigDecimal getComparatorValue(String field) {
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal selisihAset = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeJumlahAset, field));
		BigDecimal jumlahLiabilitas = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeJumlahLiabilitas, field));
		if (jumlahLiabilitas.compareTo(selisihAset) > 0) {
			res = new BigDecimal("0.3");
		} else if (selisihAset.compareTo(jumlahLiabilitas.multiply(new BigDecimal("1.2"))) > 0) {
			res = new BigDecimal("0.1");
		}
		return res.setScale(scale, RoundingMode.HALF_UP);
	}
}