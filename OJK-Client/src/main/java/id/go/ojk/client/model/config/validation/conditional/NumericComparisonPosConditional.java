package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.validation.ValidationResult;

@XStreamAlias("NumericComparisonPosConditional")
public class NumericComparisonPosConditional extends NumericComparisonConditional {
	protected String selectPosCode;
	@XStreamOmitField
	protected List<String> listSelectPosCode;
	
	public NumericComparisonPosConditional() {
	}

	public NumericComparisonPosConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public NumericComparisonPosConditional initialized() {
		super.initialized();
		this.selectPosCode = getStringParameter("selectPosCode");
		this.listSelectPosCode = ToStringList.convert(selectPosCode, "|");
		return this;
	}
	
	@Override
	protected boolean evaluate(ValidationResult validationResult, String[] arrComparatorField) {
		String currentPosCode = validationResult.getColumn(1);
		return listSelectPosCode.contains(currentPosCode) ? super.evaluate(validationResult, arrComparatorField) : false;
	}
}
