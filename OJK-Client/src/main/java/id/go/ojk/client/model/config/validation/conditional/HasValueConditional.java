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

import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.N;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("HasValueConditional")
public class HasValueConditional extends BaseConditional {
	@XStreamAsAttribute
	private String comparatorField;

	private String exceptPos;

	public HasValueConditional() {
	}

	public HasValueConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public HasValueConditional initialized() {
		super.initialized();
		comparatorField = getStringParameter("comparatorField");
		exceptPos = getStringParameter("exceptPos");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {

		if (exceptPos != null && hasExceptPosCode(validationResult))
			return Tupple2.<RequiredCondition, String>builder().a(M).b("").build();

		RequiredCondition result = trueCondition;
		String[] arrComparatorField = StringUtils.split(comparatorField, "|");
		String kolom = "";
		String kolomName = "";
		for (int i = 0; i < arrComparatorField.length; i++) {
			int idxComparatorField = Integer.parseInt(arrComparatorField[i]);
			String comparatorRealValue = validationResult.getColumn(idxComparatorField);
			kolomName = submissionFormat.getFieldName(idxComparatorField);
			if (StringUtils.isEmpty(comparatorRealValue)) {
				result = falseCondition;
				kolom = (idxComparatorField + 1) + ", ";
				break;
			}  else {
				kolom = (idxComparatorField + 1) + ", ";
			}
		}
		String message = "kolom nomor " + kolom.substring(0, kolom.length() - 2) + " '" + kolomName + "'";
		if (StringUtils.isNotEmpty(kolom)) {
			if (result.equals(N)) {
				message = "jika " + message + " kosong";
			} else {
				message += " diisi";
			}
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean hasExceptPosCode(ValidationResult validationResult) {
		String value = validationResult.getColumn(1);
		List<String> list = Arrays.asList(StringUtils.split(exceptPos, "|"));
		return StringUtils.isNotEmpty(value) && list.contains(value);
	}
}
