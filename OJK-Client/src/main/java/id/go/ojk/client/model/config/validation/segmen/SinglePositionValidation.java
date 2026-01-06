package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("singlePositionValidation")
public class SinglePositionValidation extends MapParamSegmentValidation{

	private String selectField;
	private String singleValue;
	private String msgError;
	int count;
	
	public SinglePositionValidation() {
		super();
	}

	public SinglePositionValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	
	@Override
	public SinglePositionValidation initialized() {
		selectField = getStringParameter("selectField");
		singleValue = getStringParameter("singleValue");	
		msgError = getStringParameter("msgError");
		count = 0;
		
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		int totalRow = submissionFormat.getTotalRow() - 1;
		
		if(validationResult.getColumn(Integer.parseInt(selectField)).equals(singleValue)){
			count++;
			if(count > 1) {
				validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(selectField)), ValidationErrorCode.E50_17_SINGLEPOSITION, msgError));
			}
		}
		
		if (validationResult.lineNumber == totalRow) {			
			//reset nilai count
			count = 0;
		}
	}
}