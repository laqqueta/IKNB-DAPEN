package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexDateValidation")
public class RegexYearValidation extends BaseRegexValidation {
	
	public RegexYearValidation() {
		super();
	}
	
	public RegexYearValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public RegexYearValidation initialized() {
		super.initialized();
		return this;
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_YEAR;
	}
}