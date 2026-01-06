package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseRowValidation extends MapParamSegmentValidation {
	protected String selectField;
	protected String selectPosCode;

	protected BaseRowValidation() {
		super();
	}

	protected BaseRowValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public BaseRowValidation initialized() {
		selectField = getStringParameter("selectField");
		selectPosCode = getStringParameter("selectPosCode");
		return this;
	}
	
	protected boolean validateSelectPosCode(String currentPosCode) {
		List<String> list = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		return list.contains(currentPosCode);
	}
}