package id.go.ojk.client.model.config.validation.segmen;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("combinePosValidation")
public class CombinePosValidation extends MapParamSegmentValidation {
	private String exceptPos;
	private Comparation comparation;

	public CombinePosValidation() {
		super();
	}

	public CombinePosValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public CombinePosValidation initialized() {	
		exceptPos = getStringParameter("exceptPos");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();		
		String officeCode = validationResult.getColumn(1);
		String posCode = validationResult.getColumn(2);
		String posValue = validationResult.getColumn(3);
		List<String> listRincianKantor = SubmissionFormat.listRincianKantor;
			
		if (!listRincianKantor.contains(officeCode) && !officeCode.equals("000")) {
			validationResult.errors.add(new ValidationError(fields.get(1), ValidationErrorCode.E50_11_OFFICE_CODE, officeCode));
		}
		
		if (officeCode.equals("000")) {
			process(validationResult, fields, listRincianKantor, posCode, posValue);
		}		
	}
	
	private void process(ValidationResult validationResult, List<SubmissionField> fields, List<String> listRincianKantor, String posCode, String posValue) {
		List<String> valKantorCabList = new ArrayList<String>();
		String[] exceptPosSplit;
		String key = "";
		
		for (String rincianKantor : listRincianKantor) {
			key = rincianKantor + "-" + posCode;
			if (!SubmissionFormat.mapPosValueLBBPRK.containsKey(key)) {
				validationResult.errors.add(new ValidationError(fields.get(1), ValidationErrorCode.E50_12_POS_NOT_EXIST, rincianKantor, posCode));
			} else {
				valKantorCabList.add(SubmissionFormat.mapPosValueLBBPRK.get(key).get(3));
			}
		}
		
		if (exceptPos != null) {
			exceptPosSplit = exceptPos.split("[|]");
			List<String> exceptPosList = new ArrayList<String>();
			for (String pos : exceptPosSplit) {
				exceptPosList.add(pos);
			}
			
			if(!exceptPosList.contains(posCode) && !calculate(posValue, valKantorCabList)) {
				validationResult.errors.add(new ValidationError(fields.get(3), ValidationErrorCode.E50_13_SANDI_GABUNGAN));
			}			
		} else {
			if (!calculate(posValue, valKantorCabList)) {
				validationResult.errors.add(new ValidationError(fields.get(3), ValidationErrorCode.E50_13_SANDI_GABUNGAN));
			}
		}
	}
	
	private Boolean calculate(String valGabungan, List<String> valKantorCabList) {
		boolean result = false;
		Double leftValue = 0.00;
		Double rightValue = 0.00;
		
		try {
			leftValue = Double.parseDouble(valGabungan);
			for (String val : valKantorCabList) {
				rightValue += Double.parseDouble(val);
			}
		} catch (NumberFormatException e) {
			
		}
		
		comparation = Comparation.e;
		result = comparation.testCompareDouble(leftValue, rightValue);
		
		return result;
	}
}