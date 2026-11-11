package id.go.ojk.client.model.config.validation.field;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@XStreamAlias("PPMPPPIPJenisManfaatValidation")
public class PPMPPPIPJenisManfaatValidation extends MapParamFieldValidation {
	private String exceptProgram;
	private String exceptPosCode;
	private String refKey;
	private int refNumber;

	public PPMPPPIPJenisManfaatValidation(String parameter) {
		setParameter(parameter);
	}

	public PPMPPPIPJenisManfaatValidation() {
		super();
	}

	public PPMPPPIPJenisManfaatValidation initialized() {
		exceptPosCode = getStringParameter("exceptPosCode");
		exceptProgram = getStringParameter("exceptProgram");
		refKey = getStringParameter("refKey");
		refNumber = getIntParameter("refNumber");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String currentPos = validationResult.getColumn(1);

		if (currentPos.equals(exceptPosCode)) return;

		String programType = validationResult.getColumn(2);
		if (programType.equals(exceptProgram)) {
			String fieldValue = validationResult.getColumn(field.getNumber());

			if (isExists(fieldValue)) {
				ReferenceService referenceService = appCtx.getService(ReferenceService.class);
				String refDesc = referenceService.getReferenceDescription(refNumber);

				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E03_40_REFERENCE, refDesc, programType));
			}
		}
	}

	private boolean isExists(String val) {
		String[] refExceptions = StringUtils.split(refKey, "|");

		for (String refException : refExceptions) {
			if (val.equals(refException)) return true;
		}

		return false;
	}
}
