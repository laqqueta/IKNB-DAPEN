package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("BetweenCondition")
public class NotBetweenPosCondition extends NotBetweenCondition {
	private String rowCode;

	public NotBetweenPosCondition() {
	}

	public NotBetweenPosCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public NotBetweenPosCondition initialized() {
		super.initialized();
		this.rowCode = getStringParameter("rowCode");
		return this;
	}

	@Override
	protected RequiredCondition validateCondition(ValidationResult validationResult) {
		List<String> listRowCode = ToStringList.convert(rowCode, "|");
		return listRowCode.contains(validationResult.getColumn(1)) ? super.validateCondition(validationResult)
				: falseCondition;
	}
}
