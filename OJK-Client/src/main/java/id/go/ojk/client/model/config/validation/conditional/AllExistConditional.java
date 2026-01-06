package id.go.ojk.client.model.config.validation.conditional;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise "falseCondition"
 *
 */
@XStreamAlias("allExistConditional")
public class AllExistConditional extends MapParamConditionalRequired {
	protected RequiredCondition trueCondition;
	protected RequiredCondition falseCondition;
	protected List<Integer> fieldNumbers;

	public AllExistConditional(){
	}

	public AllExistConditional(String parameter){
		setParameter(parameter);
	}

	@Override
	public AllExistConditional initialized() {
		trueCondition = getRequiredConditionParameter("trueCondition");
		falseCondition = getRequiredConditionParameter("falseCondition");
		Integer[] tmpFieldNumbers = getIntegerArrayParameter("fieldNumber");
		fieldNumbers = Arrays.asList(tmpFieldNumbers);
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String conditionMessage = "";
		String kolom = "";
		for (int fieldNumber : fieldNumbers) {
			String value = validationResult.getColumn(fieldNumber);
			if ( StringUtils.isEmpty(value) ){
				conditionMessage = "kolom nomor " + (fieldNumber + 1) + " kosong";
				if (falseCondition.equals(RequiredCondition.N)) {
					conditionMessage = "jika " + conditionMessage;
				}
				return Tupple2.<RequiredCondition, String>builder()
						.a(falseCondition)
						.b(conditionMessage)
						.build();
			} else {
				kolom += String.valueOf((fieldNumber + 1)) + ",";
			}
		}

		conditionMessage = "kolom nomor " + kolom.substring(0, kolom.length() - 1) + " terisi";
		if (trueCondition.equals(RequiredCondition.N) && StringUtils.isNotBlank(conditionMessage)) {
			conditionMessage = "jika " + conditionMessage;
		}
		return Tupple2.<RequiredCondition, String>builder()
				.a(trueCondition)
				.b(conditionMessage)
				.build();
	}


}
