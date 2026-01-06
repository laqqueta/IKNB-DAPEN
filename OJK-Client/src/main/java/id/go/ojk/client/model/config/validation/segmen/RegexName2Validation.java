package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexNumericValidation")
public class RegexName2Validation extends BaseRegexValidation {
	
	public RegexName2Validation() {
		super();
	}
	
	public RegexName2Validation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_NAME_2;
	}
}