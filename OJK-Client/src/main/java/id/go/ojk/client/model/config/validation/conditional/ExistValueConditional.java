package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("existValueConditional")
public class ExistValueConditional extends MapParamConditionalRequired {

	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private Integer fieldNumber;
	private String trueValue;
	private String operator;
	private Comparation comparation;
	private String customErrorMsg;

	public ExistValueConditional() {
	}

	public ExistValueConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistValueConditional initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		this.fieldNumber = getIntParameter("fieldNumber");
		this.trueValue = getStringParameter("trueValue");
		this.operator = getStringParameter("operator");
		this.customErrorMsg = getStringParameter("customErrorMsg");
		
		if (operator == null) {
			operator = "e";
		}
		
		switch (operator) {
		case "e":
			comparation = Comparation.e;
			break;
		case "ne":
			comparation = Comparation.ne;
			break;
		case "lt":
			comparation = Comparation.lt;
			break;
		case "lte":
			comparation = Comparation.lte;
			break;
		case "gt":
			comparation = Comparation.gt;
			break;
		case "gte":
			comparation = Comparation.gte;
			break;
		default:
			break;
		}

		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Boolean evaluateResult = false;
		String value = validationResult.getColumn(fieldNumber);
		String[] trueValueSplit = trueValue.split("[|]");
		String msgValue = customErrorMsg == null ? value : customErrorMsg;
		String conditionMessage = "Kolom '" + submissionFormat.getFields().get(fieldNumber).getName() + "' " + comparation.getCode()+ " " + msgValue;

		for (String val : trueValueSplit) {
			if (operator.equals("e")) {
				if (value.equals(val)) {
					evaluateResult = true;					
				}
			} else {
				try {
					if(comparation.testCompareDouble(Double.parseDouble(value), Double.parseDouble(val))) {
						evaluateResult = true;
					}
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}	
		}

		RequiredCondition requiredCondition = evaluateResult ? trueCondition : falseCondition;
		return Tupple2.<RequiredCondition, String>builder().a(requiredCondition).b(conditionMessage).build();

	}
}
