package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexAlfaSpaceValidation")
public class RegexAlfaSpaceValidation extends BaseRegexValidation {
	
	public RegexAlfaSpaceValidation() {
		super();
	}
	
	public RegexAlfaSpaceValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.patternAlfaSpace;
	}
}