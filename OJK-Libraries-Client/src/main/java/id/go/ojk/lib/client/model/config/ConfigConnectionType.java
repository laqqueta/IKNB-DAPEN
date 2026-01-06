package id.go.ojk.lib.client.model.config;

import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.constant.ConnectionType;
import id.go.ojk.lib.client.model.constant.VariableType;

public class ConfigConnectionType extends Config<ConnectionType>{

	public ConfigConnectionType(String key, String name, ConnectionType defauldValue, boolean required) {
		super(key, name, VariableType.enumType, defauldValue, required);
	}

	@Override
	public ConnectionType castValue(String valueString) {
		if ( valueString == null )
			return getDefauldValue();
		return ConnectionType.valueOf(valueString);
	}

	@Override
	public String getDefaultValueAsString() {
		ConnectionType res = getDefauldValue();
		return res != null ? res.name() : "";
	}

}

