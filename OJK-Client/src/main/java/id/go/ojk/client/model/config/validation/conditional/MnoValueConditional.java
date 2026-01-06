package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("mnoValueConditional")
public class MnoValueConditional extends MapParamConditionalRequired {

	private Integer fieldNumber;
	private String mandatoryValue;
	private String noneValue;
	private String optionalValue;

	public MnoValueConditional() {
	}

	public MnoValueConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public MnoValueConditional initialized() {
		this.fieldNumber = getIntParameter("fieldNumber");
		this.mandatoryValue = getStringParameter("mandatoryValue");
		this.noneValue = getStringParameter("noneValue");
		this.optionalValue = getStringParameter("optionalValue");

		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {

		String compareValue = validationResult.getColumn(fieldNumber);
		String[] mValue = mandatoryValue.split("[|]");
		String[] nValue = noneValue.split("[|]");
		String[] oValue = optionalValue.split("[|]");
		RequiredCondition requiredCondition = RequiredCondition.O;

		String conditionMessage = "karena kolom '" + submissionFormat.getFields().get(fieldNumber).getName()
				+ "' bernilai " + compareValue;

		for (String val : mValue) {
			if (compareValue.equals(val)) {
				requiredCondition = RequiredCondition.M;
			}
		}

		for (String val : nValue) {
			if (compareValue.equals(val)) {
				requiredCondition = RequiredCondition.N;
			}
		}

		for (String val : oValue) {
			if (compareValue.equals(val)) {
				requiredCondition = RequiredCondition.O;
			}
		}
		
		return Tupple2.<RequiredCondition, String>builder().a(requiredCondition).b(conditionMessage).build();

	}
}
