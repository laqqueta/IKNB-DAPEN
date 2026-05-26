package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import org.apache.commons.net.util.ToStringList;

@XStreamAlias("FormulaPosValidation3")
public class FormulaPosValidation3 extends FormulaValidation4 {
	private String refPosCode;

	public FormulaPosValidation3(String parameter) {
		super(parameter);
	}

	public FormulaPosValidation3() {
		super();
	}

	@Override
	public FormulaPosValidation3 initialized() {
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
