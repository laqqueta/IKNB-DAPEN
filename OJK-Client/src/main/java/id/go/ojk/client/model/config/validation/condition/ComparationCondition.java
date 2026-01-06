package id.go.ojk.client.model.config.validation.condition;

import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;

public class ComparationCondition implements Condition {
	private Comparation comparation;
	private String refValue;
	
	public ComparationCondition(Comparation comparation, String refValue){
		this.comparation = comparation;
		this.refValue = refValue;
	}

	@Override
	public boolean test(ValidationResult validationResult) {
		return false;
	}

}
