package id.go.ojk.lib.client.model.config;

import java.util.regex.Pattern;

public class Regex {
	private String pattern;
	private String desc;
	private final Pattern patternObject;

	public Regex(String pattern, String desc){
		this.pattern = pattern;
		this.desc = desc;
		this.patternObject = Pattern.compile(pattern);
	}

	public String getPattern() {
		return pattern;
	};
	public String getDesc() {
		return desc;
	};

	public Regex c() {
		return new Regex(pattern, desc);
	}

	@Override
	public Regex clone() throws CloneNotSupportedException {
		return new Regex(pattern, desc);
	}
	
	public boolean matches(String value) {
	  return patternObject.matcher(value).matches();
	}

}
