package id.go.ojk.client.model.config.validation.segmen;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("rowPatternPercent")
public class RowPatternPercent extends BaseRowValidation {

	public RowPatternPercent() {
		super();
	}

	public RowPatternPercent(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public RowPatternPercent initialized() {
		super.initialized();
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		String[] SelectField = selectField.split("[|]");
		String[] SelectPosCode = selectPosCode.split("[|]");
		String posCode = validationResult.getColumn(1);
		List<String> posCodeTmp = new ArrayList<String>();

		for (String values : SelectField) {
			Double fieldValue = ValidationUtil.validateDouble(fields.get(Integer.parseInt(values)), validationResult, false);
			String filedValueString = validationResult.getColumn(Integer.parseInt(values));
			
			if (fieldValue != null) {
				for (int i = 0; i < SelectPosCode.length; i++) {
					if(posCode.contains(SelectPosCode[i])) {
						if(!filedValueString.matches(SimpleValidation.patternNumericDotNegatif.getPattern())) {
							validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(values)), ValidationErrorCode.E50_06_PERCENT_OPTION_TRUE));
						}
						posCodeTmp.add(SelectPosCode[i]);
					}
				}
				
				if(posCodeTmp.size() == 0) {
					if(!filedValueString.matches(SimpleValidation.patternNumericNegatif.getPattern())) {
						validationResult.errors.add(new ValidationError(fields.get(Integer.parseInt(values)), ValidationErrorCode.E50_07_PERCENT_OPTION_FALSE));
					}
				}
			}
		}

	}

}