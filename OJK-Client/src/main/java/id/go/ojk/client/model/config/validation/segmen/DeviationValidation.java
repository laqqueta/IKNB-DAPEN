package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("DeviationValidation")
public class DeviationValidation extends BaseDecimalValidation {
	private String posCodeJumlahAset;
	private String posCodeJumlahLiabilitas;
	private String posCodeSelisihAset;
	private String posCodeFactor;
	private String errorMessage;

	public DeviationValidation() {
		super();
	}

	public DeviationValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public DeviationValidation initialized() {
		super.initialized();
		posCodeJumlahAset = getStringParameter("posCodeJumlahAset");
		posCodeJumlahLiabilitas = getStringParameter("posCodeJumlahLiabilitas");
		posCodeSelisihAset = getStringParameter("posCodeSelisihAset");
		posCodeFactor = getStringParameter("posCodeFactor");
		errorMessage = getStringParameter("errorMessage");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(DeviationValidation.class);
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
			BigDecimal expectedValue = getComparatorValue(field).setScale(scale, RoundingMode.HALF_UP);
			
			if (realValue.compareTo(expectedValue) != 0) {
				logger.error("pos=" + selectPosCode + ";col=" + field + ";realValue=" + realValue + ";expectedValue=" + expectedValue);
				validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_10_FORMULA2,
						replaceMacro(errorMessage.replace("|", " = "))));
			}
		}
	}

	private BigDecimal getComparatorValue(String field) {
		BigDecimal res = BigDecimal.ZERO;
		BigDecimal jumlahAset = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeJumlahAset, field));
		BigDecimal jumlahLiabilitas = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeJumlahLiabilitas, field));
		BigDecimal selisihAset = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeSelisihAset, field));
		BigDecimal factor = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeFactor, field));
		if (factor.compareTo(new BigDecimal(".3")) == 0) {
			res = new BigDecimal(".3").multiply(selisihAset);
		} else if (factor.compareTo(new BigDecimal(".1")) == 0) {
			BigDecimal tmpJumlahLiabilitas = new BigDecimal("1.2").multiply(jumlahLiabilitas);
			BigDecimal multiplier = jumlahAset.subtract(tmpJumlahLiabilitas);
			res = new BigDecimal(".1").multiply(multiplier);
		}
		return res;
	}
}