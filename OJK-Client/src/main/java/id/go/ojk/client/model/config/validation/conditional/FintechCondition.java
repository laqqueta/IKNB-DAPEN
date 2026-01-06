package id.go.ojk.client.model.config.validation.conditional;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("FintechCondition")
public class FintechCondition extends MapParamConditionalRequired {
	@XStreamAsAttribute
	private RequiredCondition defaultCondition;
	private String selectPosCode1;
	private RequiredCondition conditionPosCode1;
	private String selectPosCode2;
	private String comparatorPosCode2;
	private String valueComparatorPosCode2;
	private RequiredCondition trueConditionPosCode2;
	private RequiredCondition falseConditionPosCode2;

	public FintechCondition() {
	}

	public FintechCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public FintechCondition initialized() {
		defaultCondition = getRequiredConditionParameter("defaultCondition");
		selectPosCode1 = getStringParameter("selectPosCode1");
		conditionPosCode1 = getRequiredConditionParameter("conditionPosCode1");
		selectPosCode2 = getStringParameter("selectPosCode2");
		comparatorPosCode2 = getStringParameter("comparatorPosCode2");
		valueComparatorPosCode2 = getStringParameter("valueComparatorPosCode2");
		trueConditionPosCode2 = getRequiredConditionParameter("trueConditionPosCode2");
		falseConditionPosCode2 = getRequiredConditionParameter("falseConditionPosCode2");
		return this;
	}

	private boolean checkPosCode1(String posCode) {
		List<String> arrPosCode1 = Arrays.asList(StringUtils.split(selectPosCode1, "|"));
		return arrPosCode1.contains(posCode);
	}

	private RequiredCondition checkPosCode2() {
		String valueComparator = SubmissionFormat.getMapPosValue(comparatorPosCode2, "2");
		return valueComparator.equals(valueComparatorPosCode2) ? trueConditionPosCode2 : falseConditionPosCode2;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = defaultCondition;
		String posCode = validationResult.getColumn(1);
		String message = "";
		if (checkPosCode1(posCode)) {
			result = conditionPosCode1;
		} else if (posCode.equals(selectPosCode2)) {
			result = checkPosCode2();
			message = "kode baris " + comparatorPosCode2 + " berisi "
					+ SubmissionFormat.getMapPosValue(comparatorPosCode2, "2");
			if (result == RequiredCondition.N) {
				message = "jika " + message;
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
}
