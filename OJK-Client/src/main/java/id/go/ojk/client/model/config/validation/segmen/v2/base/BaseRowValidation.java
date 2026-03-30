package id.go.ojk.client.model.config.validation.segmen.v2.base;

import id.go.ojk.client.model.config.validation.segmen.MapParamSegmentValidation;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

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

	protected boolean isInvalidNumeric(String s) {
		if (s == null || s.isEmpty()) return true;

		boolean isDot = false;
		boolean isNumeric = false;
		int i = 0;

		if (s.charAt(0) == '-') {
			if (s.length() == 1) return true;
			i = 1;
		}

		for (; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				isNumeric = true;
			} else if (c == '.') {
				if (isDot) return true;
				isDot = true;
			} else {
				return true;
			}
		}

		return !isNumeric;
	}
}