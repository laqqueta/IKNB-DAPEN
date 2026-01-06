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

@XStreamAlias("risikoOperasionalPerusahaanValidation")
public class RisikoOperasionalPerusahaanValidation extends BaseDecimalValidation {
	private String posCodeBebanUmumDanAdministrasi;
	private String posCodeBebanPendidikanDanPelatihan;
	private String posCodeSaldoBiayaAkuisisiYangDitangguhkan;
	
	public RisikoOperasionalPerusahaanValidation() {
		super();
	}

	public RisikoOperasionalPerusahaanValidation(String parameter) {
		super(parameter);
	}

	@Override
	public RisikoOperasionalPerusahaanValidation initialized() {
		super.initialized();
		posCodeBebanUmumDanAdministrasi = getStringParameter("posCodeBebanUmumDanAdministrasi");
		posCodeBebanPendidikanDanPelatihan = getStringParameter("posCodeBebanPendidikanDanPelatihan");
		posCodeSaldoBiayaAkuisisiYangDitangguhkan = getStringParameter("posCodeSaldoBiayaAkuisisiYangDitangguhkan");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(RisikoOperasionalPerusahaanValidation.class);
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
		BigDecimal bebanUmumDanAdministrasi = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeBebanUmumDanAdministrasi, field));;
		BigDecimal bebanPendidikanDanPelatihan = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeBebanPendidikanDanPelatihan, field));;
		BigDecimal saldoBiayaAkuisisiYangDitangguhkan = toBigDecimal(SubmissionFormat.getMapPosValue(posCodeSaldoBiayaAkuisisiYangDitangguhkan, field));;
		BigDecimal tmp1 = bebanUmumDanAdministrasi.subtract(bebanPendidikanDanPelatihan);
		BigDecimal tmp2 = new BigDecimal(".01").multiply(tmp1);
		BigDecimal tmp3 = new BigDecimal(".5").multiply(saldoBiayaAkuisisiYangDitangguhkan);
		res = tmp2.add(tmp3);
		return res.setScale(scale, RoundingMode.HALF_UP);
	}
}