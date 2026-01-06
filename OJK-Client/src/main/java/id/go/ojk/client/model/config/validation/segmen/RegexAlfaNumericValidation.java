package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexAlfaNumericValidation")
public class RegexAlfaNumericValidation extends BaseRegexValidation {
	
	public RegexAlfaNumericValidation() {
		super();
	}
	
	public RegexAlfaNumericValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.patternAlfaNumeric;
	}
}