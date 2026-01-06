package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexWebAddressValidation")
public class RegexWebAddressValidation extends BaseRegexValidation {
	
	public RegexWebAddressValidation() {
		super();
	}
	
	public RegexWebAddressValidation(String parameter) {
		super(parameter);
	}

	@Override
	protected Regex getRegex() {
		return SimpleValidation.PATTERN_WEB_ADDRESS;
	}
}