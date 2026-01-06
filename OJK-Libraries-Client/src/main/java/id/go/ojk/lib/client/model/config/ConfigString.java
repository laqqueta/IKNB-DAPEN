package id.go.ojk.lib.client.model.config;

import id.go.ojk.lib.client.model.constant.VariableType;

public class ConfigString extends Config<String>{

	public ConfigString(String key, String name, String defauldValue, boolean required) {
		super(key, name, VariableType.stringType, defauldValue, required);
	}

	@Override
	public String castValue(String valueString) {
		if ( valueString == null )
			return getDefauldValue();
		return valueString;
	}

	@Override
	public String getDefaultValueAsString() {
		String res = getDefauldValue();
		return res != null ? res : "";
	}
}
