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
import id.go.ojk.lib.client.model.config.PrecisionComparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("percentTotalValidation")
public class PercentTotalValidation extends MapParamSegmentValidation {
	
	private String selectField;
	
	private double percentTotal;
	private double precisionValue;
	private int totalRow;

	public PercentTotalValidation() {
		super();
	}

	public PercentTotalValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public PercentTotalValidation initialized() {	
		selectField = getStringParameter("selectField");
		percentTotal = getDoubleParameter("percentTotal");
		precisionValue = getDoubleParameter("precisionValue");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		totalRow = submissionFormat.getTotalRow() - 1;
		Double sumPercent = 0.00;
		String officeCode = submissionFormat.getHaveOfficeCode() ? validationResult.getColumn(1) : "000";
		String posCode = submissionFormat.getHavePosCode() ? validationResult.getColumn(2) : submissionFormat.getCode();
		String keyNoSeq = officeCode + "-" + posCode;
		Double fieldValue = ValidationUtil.validateDouble(fields.get(Integer.parseInt(selectField)), validationResult, false);
		
		if (fieldValue != null && validationResult.lineNumber == totalRow) {
			for (Entry<String, List<String>> entry : SubmissionFormat.mapPosValueLBBPRK.entrySet()){
				if(entry.getKey().contains(keyNoSeq)){
					Double entryValue = 0.00;
					try {
						entryValue = Double.parseDouble(entry.getValue().get(Integer.parseInt(selectField)));
					} catch (NumberFormatException e) {
						// TODO: handle exception
					}
					
					sumPercent += entryValue;
				}
			}
			
			PrecisionComparation precisionComparation = new PrecisionComparation(sumPercent, percentTotal, precisionValue);
			
			if (!precisionComparation.compare()) {
				String percentTotalString = Double.toString(BigDecimal.valueOf(percentTotal).setScale(2, RoundingMode.HALF_UP).doubleValue());
				validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_09_TOTAL_PERCENT, submissionFormat.getFieldName(Integer.parseInt(selectField)), percentTotalString));
			}
		}
	}
}