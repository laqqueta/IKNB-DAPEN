package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;

@XStreamAlias("asetLiabilitasOther")
public class AsetLiabilitasOther extends MapParamFieldValidation {
	
	private String selectPosCode;
	private int totalRow;
	private Comparation comparation;
	
	public AsetLiabilitasOther() {

	}

	public AsetLiabilitasOther(String parameter) {
		setParameter(parameter);
	}

	@Override
	public AsetLiabilitasOther initialized() {
		selectPosCode = getStringParameter("selectPosCode");
		comparation = Comparation.gte;
		
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Double sumVal = 0.0;
		String value = validationResult.getColumn(field.getNumber());
		String officeCode = validationResult.getColumn(1);
		totalRow = submissionFormat.getTotalRow() - 1;
		
		SubmissionFormat.tempOtherValueList.add(officeCode + "|" + value);
					
		if (validationResult.lineNumber == totalRow) {
			SubmissionFormat.tempOtherCondition = false;
			for (String valKantor : SubmissionFormat.listRincianKantor) {
				try {
					Double sumOtherValue = 0.0;
					Double posCodeValue = 0.0;
					String posCode = valKantor + "-" + selectPosCode;
					posCodeValue = Double.parseDouble(SubmissionFormat.mapPosValueLBBPRK.get(posCode).get(3));
					
					for (String valOther : SubmissionFormat.tempOtherValueList) {
						String officeCodeOther = valOther.split("[|]")[0];
						String valueOther = valOther.split("[|]")[1];
						
						if (officeCodeOther.equals(valKantor)) {
							
								sumVal = Double.parseDouble(valueOther);
								sumOtherValue += sumVal;
							
						}
					}
					
					Double percentValue = (posCodeValue * 100.0) / sumOtherValue;
					Boolean result = comparation.testCompareDouble(percentValue, 25.0);
					
					if (result) {
						SubmissionFormat.tempOtherCondition = true;
					}
					
				} catch (NumberFormatException e) {
					// TODO: handle exception
				} catch (NullPointerException e) {
					
				}
			}
		}
		
	}
}
