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

@XStreamAlias("factorSeMmbr2017Validation")
public class FactorSeMmbr2017Validation extends BaseDecimalValidation {
	private String posCodeSelisihAset;
	private String posCodeJumlahLiabilitas;

	public FactorSeMmbr2017Validation() {
		super();
	}

	public FactorSeMmbr2017Validation(String parameter) {
		super(parameter);
	}

	@Override
	public FactorSeMmbr2017Validation initialized() {
		super.initialized();
		posCodeSelisihAset = getStringParameter("posCodeSelisihAset");
		posCodeJumlahLiabilitas = getStringParameter("posCodeJumlahLiabilitas");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(FactorSeMmbr2017Validation.class);
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
						String.valueOf(expectedValue.setScale(2, RoundingMode.HALF_UP))));
			}
		}
	}

	private BigDecimal getComparatorValue(String field) {
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal selisihAset = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeSelisihAset, field));
		BigDecimal jumlahLiabilitas = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeJumlahLiabilitas, field));
		if (selisihAset.compareTo(BigDecimal.ZERO) <= 0) {
			res = new BigDecimal("0.3");
		} else if (selisihAset.compareTo(jumlahLiabilitas.divide(new BigDecimal("5"))) <= 0) {
			res = BigDecimal.ZERO;
		} else {
			res = new BigDecimal("0.1");
		}
		res.setScale(scale, RoundingMode.HALF_UP);
		return res.multiply(new BigDecimal(100));
	}
}