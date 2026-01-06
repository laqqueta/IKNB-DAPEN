package id.go.ojk.client.constant;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.config.Regex;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ERegex implements IObject<Regex>  {
	;
	
	@Getter
	private String pattern;
	@Getter
	private String desc;
	
	@Override
	public Regex getObject() {
		return new Regex(pattern, desc);
	}

}
