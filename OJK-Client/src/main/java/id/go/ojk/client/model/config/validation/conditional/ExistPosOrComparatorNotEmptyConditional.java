package id.go.ojk.client.model.config.validation.conditional;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("ExistPosOrComparatorNotEmptyConditional")
public class ExistPosOrComparatorNotEmptyConditional extends MapParamConditionalRequired {
	private RequiredCondition defaultCondition;
	private RequiredCondition existPosCondition;
	private RequiredCondition comparatorCondition;
	private String refPosCode;
	private int comparatorFieldNumber;

	public ExistPosOrComparatorNotEmptyConditional() {
	}

	public ExistPosOrComparatorNotEmptyConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistPosOrComparatorNotEmptyConditional initialized() {
		defaultCondition = getRequiredConditionParameter("defaultCondition");
		existPosCondition = getRequiredConditionParameter("existPosCondition");
		comparatorCondition = getRequiredConditionParameter("comparatorCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorFieldNumber = getIntParameter("comparatorFieldNumber");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = defaultCondition;
		String posCode = validationResult.getColumn(1);
		String message = "";
		if (StringUtils.isNotEmpty(posCode) && refPosCode.contains(posCode)) {
			result = existPosCondition;
			message = StringUtils.isNotEmpty(posCode) ? ("kode baris " + posCode) : "";
		} else {
			String value = validationResult.getColumn(comparatorFieldNumber);
			message = "kolom ke " + (comparatorFieldNumber + 1);
			if (!StringUtils.isEmpty(value)) {
				result = comparatorCondition;
				message = message + " terisi";
			} else {
				message = message + " kosong";
			}
		}
		if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
}
