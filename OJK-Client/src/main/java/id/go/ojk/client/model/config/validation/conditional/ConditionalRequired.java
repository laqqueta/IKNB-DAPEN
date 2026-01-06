package id.go.ojk.client.model.config.validation.conditional;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public interface ConditionalRequired {

	ConditionalRequired setParameter(String parameter);
	
	String getParameter();

	ConditionalRequired initialized();
	
	void setApplicationContext(ApplicationContext appCtx);

	/**
	 *
	 * @param submissionFormat
	 * @param validationResult
	 * @return RequiredCondition and condition message
	 */
	Tupple2<RequiredCondition, String>  analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult);
}
