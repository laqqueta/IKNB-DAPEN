package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.lib.client.model.config.Regex;

@XStreamAlias("regexNumericDotValidation")
public class RegexNumericDotValidation extends BaseRegexValidation {
	private int decDigit;
	
	public RegexNumericDotValidation() {
		super();
	}
	
	public RegexNumericDotValidation(String parameter) {
		super(parameter);
	}

	@Override
	public RegexNumericDotValidation initialized() {
		super.initialized();
		decDigit = getIntParameter("decDigit");
		return this;
	}

	@Override
	protected Regex getRegex() {
		Regex res = null;
		if (decDigit == 3) {
			res = SimpleValidation.patternNumericDotThree;
		} else if (decDigit == 4){
			res = SimpleValidation.patternNumericDotFour;
		} else {
			res = SimpleValidation.patternNumericDot;
		}
		return res;
	}

}