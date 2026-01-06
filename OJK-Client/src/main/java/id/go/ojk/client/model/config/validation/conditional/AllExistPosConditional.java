package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("AllExistPosConditional")
public class AllExistPosConditional extends AllExistConditional {
	protected String selectPosCode;
	@XStreamOmitField
	protected List<String> listSelectPosCode;
	
	public AllExistPosConditional() {
	}

	public AllExistPosConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public AllExistPosConditional initialized() {
		super.initialized();
		this.selectPosCode = getStringParameter("selectPosCode");
		this.listSelectPosCode = ToStringList.convert(selectPosCode, "|");
		return this;
	}
	
	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String currentPosCode = validationResult.getColumn(1);
		return listSelectPosCode.contains(currentPosCode) ? super.analizeRequiredCondition(submissionFormat, validationResult) : 
			Tupple2.<RequiredCondition, String>builder().a(falseCondition).b("").build();
	}
}
