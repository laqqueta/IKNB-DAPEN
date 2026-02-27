package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import org.apache.commons.net.util.ToStringList;

/*
 * Copy from FormulaPosValidation2 with custom error message from caller
 */
@XStreamAlias("FormulaFixedValuePosValidation")
public class FormulaFixedRatioPosValidation extends FormulaValidation3 {
	private String refPosCode;

	public FormulaFixedRatioPosValidation(String parameter) {
		super(parameter);
	}

	public FormulaFixedRatioPosValidation() {
		super();
	}

	@Override
	public FormulaFixedRatioPosValidation initialized() {
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
