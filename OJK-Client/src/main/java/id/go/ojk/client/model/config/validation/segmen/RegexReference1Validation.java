package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexAlfaNumericValidation")
public class RegexReference1Validation extends BaseRegexValidation {
	
	public RegexReference1Validation() {
		super();
	}
	
	public RegexReference1Validation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_REFERENCE_1;
	}
}