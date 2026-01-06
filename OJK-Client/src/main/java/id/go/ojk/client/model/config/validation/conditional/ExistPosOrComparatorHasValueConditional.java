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
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("ExistPosOrComparatorHasValueConditional")
public class ExistPosOrComparatorHasValueConditional extends MapParamConditionalRequired {
	private RequiredCondition defaultCondition;
	private RequiredCondition existPosCondition;
	private RequiredCondition comparatorCondition;
	private String refPosCode;
	private int comparatorFieldNumber;
	private String comparatorFixedValue;

	public ExistPosOrComparatorHasValueConditional() {
	}

	public ExistPosOrComparatorHasValueConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ExistPosOrComparatorHasValueConditional initialized() {
		defaultCondition = getRequiredConditionParameter("defaultCondition");
		existPosCondition = getRequiredConditionParameter("existPosCondition");
		comparatorCondition = getRequiredConditionParameter("comparatorCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorFieldNumber = getIntParameter("comparatorFieldNumber");
		comparatorFixedValue = getStringParameter("comparatorFixedValue");
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
			String comparatorValue = validationResult.getColumn(comparatorFieldNumber);
			List<String> listComparatorValue = Arrays.asList(StringUtils.split(comparatorFixedValue, "|"));
			if (!StringUtils.isEmpty(comparatorValue) && listComparatorValue.contains(comparatorValue)) {
				result = comparatorCondition;
				message = "kolom ke " + (comparatorFieldNumber + 1);
				message = message + " terisi " + StringUtils.replace(comparatorFixedValue, "|", " atau ");
			} else {
				if (StringUtils.isEmpty(comparatorValue)) {
					message = "kolom ke " + (comparatorFieldNumber + 1) + " kosong ";
				} else {
					result = RequiredCondition.O;
				}
			}
		}
		if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
}
