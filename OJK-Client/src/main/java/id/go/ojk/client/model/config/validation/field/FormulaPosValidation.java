package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("FormulaPosValidation")
public class FormulaPosValidation extends FormulaValidation {
	private String refPosCode;

	public FormulaPosValidation(String parameter) {
		super(parameter);
	}
	
	public FormulaPosValidation() {
		super();
	}

	@Override
	public FormulaPosValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		if (ToStringList.convert(refPosCode, "|").contains(validationResult.getColumn((1)))) {
			super.validate(submissionFormat, field, validationResult);
		}
	}
}
