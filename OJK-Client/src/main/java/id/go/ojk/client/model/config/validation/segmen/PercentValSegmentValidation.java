package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map.Entry;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.config.PrecisionComparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("percentValSegmentValidation")
public class PercentValSegmentValidation extends MapParamSegmentValidation {
	
	private Integer percentField;
	private Integer nominalField;
	private Double precisionValue;
	private Double sumNominal;
	private int totalRow;

	public PercentValSegmentValidation() {
		super();
	}

	public PercentValSegmentValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public PercentValSegmentValidation initialized() {	
		this.percentField = getIntParameter("percentField");	
		this.nominalField = getIntParameter("nominalField");
		this.precisionValue = getDoubleParameter("precisionValue");
		sumNominal = 0.00;

		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String officeCode = submissionFormat.getHaveOfficeCode() ? validationResult.getColumn(1) : "000";
		String posCode = submissionFormat.getHavePosCode() ? validationResult.getColumn(2) : submissionFormat.getCode();
		String keyNoSeq = officeCode + "-" + posCode;
		totalRow = submissionFormat.getTotalRow() - 1;
		
		if(sumNominal == 0.00){
			for (Entry<String, List<String>> entryVal : SubmissionFormat.mapPosValueLBBPRK.entrySet()) {		
				if(entryVal.getKey().contains(keyNoSeq)){
					try {
						sumNominal += Double.parseDouble(entryVal.getValue().get(nominalField));	
					} catch (NumberFormatException e) {
						
					}
				}
			}
		}
		
		validatePercent(validationResult, fields, percentField, nominalField, sumNominal);
		
		// reset variable sumNominal
		if (validationResult.lineNumber == totalRow) {
			sumNominal = 0.00;
		}		
	}

	private void validatePercent(ValidationResult validationResult, List<SubmissionField> fields, int percentField, int nominalField, Double sumNominal) {
		Double percentValueFormulasi = null;

		Double percentValue = ValidationUtil.validateDouble(fields.get(percentField), validationResult, false);
		Double nominalValue = ValidationUtil.validateDouble(fields.get(nominalField), validationResult, false);
	
		if (CollectionUtil.isAllNotNull(percentValue, nominalValue)){ 
			percentValue = BigDecimal.valueOf(percentValue).setScale(2, RoundingMode.HALF_UP).doubleValue();// Nisa modif: pengganti DecimalFormat ("#.##") yg menyebabkan user harus ganti Region -> English (US)
			nominalValue = BigDecimal.valueOf(nominalValue).setScale(2, RoundingMode.HALF_UP).doubleValue();// Nisa modif: sda
			if(nominalValue != 0.00){
				percentValueFormulasi = BigDecimal.valueOf(nominalValue/sumNominal* 100).setScale(2, RoundingMode.HALF_UP).doubleValue();// Nisa modif: sda	
				
				PrecisionComparation precisionComparation = new PrecisionComparation(percentValueFormulasi, percentValue, precisionValue);
				
				if (!precisionComparation.compare()) {
					validationResult.errors.add(new ValidationError(fields.get(percentField), ValidationErrorCode.E50_01_PERCENT, percentValue));
				}
			}	
		}
	}
}