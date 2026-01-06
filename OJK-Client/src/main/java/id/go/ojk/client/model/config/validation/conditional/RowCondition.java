package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("RowCondition")
public class RowCondition extends MapParamConditionalRequired {
	private RequiredCondition condition1;
	private String posCode1;
	private RequiredCondition condition2;
	private String posCode2;
	private RequiredCondition defaultCondition;

	public RowCondition() {
	}

	public RowCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public RowCondition initialized() {
		this.condition1 = getRequiredConditionParameter("condition1");
		this.posCode1 = getStringParameter("posCode1");
		this.condition2 = getRequiredConditionParameter("condition2");
		this.posCode2 = getStringParameter("posCode2");
		this.defaultCondition = getRequiredConditionParameter("defaultCondition");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<String> listPosCode1 = ToStringList.convert(posCode1, "|");
		List<String> listPosCode2 = ToStringList.convert(posCode2, "|");
		String rowValue = validationResult.getColumn(1);
		String message = StringUtils.isNotEmpty(rowValue) ? ("kode baris " + rowValue) : "";
		RequiredCondition result = defaultCondition;
		if (listPosCode1.contains(rowValue)) {
			result = condition1;
		} else if (listPosCode2.contains(rowValue)) {
			result = condition2;
		}
		if (result.equals(RequiredCondition.N) && StringUtils.isNotBlank(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
}
