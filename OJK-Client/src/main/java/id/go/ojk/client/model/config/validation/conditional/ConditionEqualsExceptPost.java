package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static id.go.ojk.lib.client.model.constant.RequiredCondition.N;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("ConditionEqualsExceptPost")
public class ConditionEqualsExceptPost extends BaseConditional {
	@XStreamAsAttribute
	private String comparatorField;
	private String comparatorValue;
	private String exceptPos;

	public ConditionEqualsExceptPost() {
	}

	public ConditionEqualsExceptPost(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ConditionEqualsExceptPost initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		comparatorValue = getStringParameter("comparatorValue");
		exceptPos = getStringParameter("exceptPos");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {

		if (hasExceptPosCode(validationResult))
			return Tupple2.<RequiredCondition, String>builder().a(N).b("Kolom Total Harus di Kosongkan.").build();

		String[] arrComparatorField = StringUtils.split(comparatorField, "|");
		String[] arrComparatorColumnNo = getAsColumnNo(arrComparatorField);
		List<String> listComparatorValue = Arrays.asList(StringUtils.split(comparatorValue, "|"));
		boolean res = true;
		for (int i = 0; i < arrComparatorField.length; i++) {
			int idxComparatorField = Integer.parseInt(arrComparatorField[i]);
			String comparatorRealValue = validationResult.getColumn(idxComparatorField);
			if (!listComparatorValue.contains(comparatorRealValue)) {
				res = false;
				break;
			}
		}
		RequiredCondition result = res ? trueCondition : falseCondition;
		String message = "";
		if (result != RequiredCondition.O) {
			message = "kolom " + StringUtils.join(arrComparatorColumnNo, ", ");
			message = message + " terisi " + (!res ? "selain " : "");
			message = message + StringUtils.replace(comparatorValue, "|", " atau ");
			if (result == RequiredCondition.N) {
				message = "jika " + message;
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
	
	private String[] getAsColumnNo(String[] arrField) {
		int length = arrField.length;
		String[] res = new String[length];
		for (int i = 0; i < length; i++) {
			res[i] = String.valueOf(Integer.parseInt(arrField[i]) + 1);
		}
		return res;
	}

	private boolean hasExceptPosCode(ValidationResult validationResult) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(exceptPos, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}
}
