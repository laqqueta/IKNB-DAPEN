package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("RegexPhoneValidation2")
public class RegexPhone2Validation extends BaseRegexValidation {
	
	public RegexPhone2Validation() {
		super();
	}
	
	public RegexPhone2Validation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_PHONE;
	}
}