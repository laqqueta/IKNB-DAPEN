package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;

/*
 * Copy from FormulaPosValidation2 with custom error message from caller
 */
@XStreamAlias("FormulaPosValidation2")
public class FormulaPosValidation2 extends FormulaValidation2 {
	private String refPosCode;

	public FormulaPosValidation2(String parameter) {
		super(parameter);
	}
	
	public FormulaPosValidation2() {
		super();
	}

	@Override
	public FormulaPosValidation2 initialized() {
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
