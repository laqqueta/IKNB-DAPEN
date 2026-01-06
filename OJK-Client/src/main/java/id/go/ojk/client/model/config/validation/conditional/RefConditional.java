package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("refConditional")
public class RefConditional extends MapParamConditionalRequired {

	private int refNumber;

	public RefConditional(){
	}

	public RefConditional(String parameter){
		setParameter(parameter);
	}

	@Override
	public RefConditional initialized() {
		this.refNumber = getIntParameter("refNumber");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		return validationResult.refRequiredConditions.get(refNumber);
	}


}
