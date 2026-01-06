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
@XStreamAlias("ComparatorHasValueConditional")
public class ComparatorHasValueConditional extends BaseConditional {
	@XStreamAsAttribute
	protected RequiredCondition emptyCondition;
	private String comparatorField;
	private String comparatorValue;

	public ComparatorHasValueConditional() {
	}

	public ComparatorHasValueConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ComparatorHasValueConditional initialized() {
		super.initialized();
		emptyCondition = getRequiredConditionParameter("emptyCondition");
		comparatorField = getStringParameter("comparatorField");
		comparatorValue = getStringParameter("comparatorValue");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = trueCondition;
		String[] arrComparatorField = StringUtils.split(comparatorField, "|");
		List<String> listComparatorValue = Arrays.asList(StringUtils.split(comparatorValue, "|"));
		String kolom = "";
		for (int i = 0; i < arrComparatorField.length; i++) {
			int idxComparatorField = Integer.parseInt(arrComparatorField[i]);
			String comparatorRealValue = validationResult.getColumn(idxComparatorField);
			if (StringUtils.isEmpty(comparatorRealValue)) {
				result = emptyCondition;
				kolom = (idxComparatorField + 1) + ", ";
				break;
			} else if (!listComparatorValue.contains(comparatorRealValue)) {
				result = falseCondition;
				kolom = "";
				break;
			} else {
				kolom = (idxComparatorField + 1) + ", ";
			}
		}
		String message = "";
		if (StringUtils.isNotEmpty(kolom)) {
			message = "kolom nomor " + kolom.substring(0, kolom.length() - 2);
			if (result.equals(RequiredCondition.N)) {
				message = "jika " + message + " kosong";
			} else {
				message = "jika " + message + " terisi " + StringUtils.replace(comparatorValue, "|", " atau ");
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
}
