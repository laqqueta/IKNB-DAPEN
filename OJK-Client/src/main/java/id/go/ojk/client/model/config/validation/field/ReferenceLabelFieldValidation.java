package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;
import lombok.Setter;

/**
 * referenceNumber=31&labelCode=Y
 * @author PC
 *
 */
@XStreamAlias("referenceLabelFieldValidation")
public class ReferenceLabelFieldValidation extends MapParamFieldValidation {

	@Getter @Setter private int referenceNumber;
	@Getter @Setter private int referenceLabelNumber;
	@Getter @Setter private String labelCode;

	private ReferenceService referenceService;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		super.setApplicationContext(appCtx);
		referenceService = appCtx.getService(ReferenceService.class);
	}
	
	public ReferenceLabelFieldValidation(String parameter){
		setParameter(parameter);
	}

	@Override
	public ReferenceLabelFieldValidation initialized() {
		referenceNumber = getIntParameter("referenceNumber");
		Integer tmpReferenceLabelNumber = getIntParameter("referenceLabelNumber");
		referenceLabelNumber = tmpReferenceLabelNumber == null ? 0 : tmpReferenceLabelNumber;		
		labelCode = getStringParameter("labelCode");
		
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		String value = validationResult.getColumn(field.getNumber());
		if ( StringUtils.isEmpty(value) )
			return;
		
		referenceService.validateLabel1(field, value, labelCode, referenceNumber, validationResult.errors);
	}

}
