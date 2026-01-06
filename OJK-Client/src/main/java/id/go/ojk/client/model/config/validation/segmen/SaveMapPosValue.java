package id.go.ojk.client.model.config.validation.segmen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;

@XStreamAlias("saveMapPosValue")
public class SaveMapPosValue extends MapParamSegmentValidation {
	
	private String selectField;
	private String multiPos;

//	private Map<String, List<String>> mapPosValue = SubmissionFormat.mapPosValue;

	public SaveMapPosValue() {
		super();
	}

	public SaveMapPosValue(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public SaveMapPosValue initialized() {
		selectField = getStringParameter("selectField");
		multiPos = getStringParameter("multiPos");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		String[] selectFields = selectField.split("[|]");
		Map<String, String> mapPosValue = new HashMap<>();
		String posCode = validationResult.getColumn(1);	
		String keyCode = posCode;		
		
		for (String fieldValue : selectFields) {
			Double posValue = ValidationUtil.validateDouble(fields.get(Integer.parseInt(fieldValue)), validationResult, false);
			mapPosValue.put(fieldValue, String.valueOf(posValue));
		}
		
		if(multiPos != null) {
			keyCode = posCode.contains(multiPos) ? posCode + "-" + validationResult.lineNumber : posCode;
		}
		
		SubmissionFormat.mapPosValue.put(keyCode, mapPosValue);
	}

}