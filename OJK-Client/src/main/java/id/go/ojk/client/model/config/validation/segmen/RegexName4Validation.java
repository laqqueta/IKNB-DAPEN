package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexNumericValidation")
public class RegexName4Validation extends BaseRegexValidation {
	
	public RegexName4Validation() {
		super();
	}
	
	public RegexName4Validation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_NAME_4;
	}
}