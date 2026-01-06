package id.go.ojk.lib.client.model.config;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.constant.VariableType;
import lombok.Getter;

public abstract class Config<V> {
	@Getter private String key;
	@Getter private String name;
	@Getter private VariableType type;
	@Getter private V defauldValue;
	@Getter private boolean required;
	
	@Getter private V minValue;
	@Getter private V maxValue;
	
	public Config(String key, String name, VariableType type, V defauldValue, boolean required, V minValue, V maxValue){
		this(key, name, type, defauldValue, required);
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public Config(String key, String name, VariableType type, V defauldValue, boolean required){
		this.key = key;
		this.name = name;
		this.type = type;
		this.defauldValue = defauldValue;
		this.required = required;
	}

	public V getValue(Properties properties){
		return castValue(getValueString(properties));
	}

	public String getValueString(Properties properties){
		String stringValue = properties.getProperty(key);
		if ( stringValue == null && defauldValue != null )
			stringValue = defauldValue.toString();
		return stringValue;
	}
	
	public V getValueMap(Map<String, String> map){
		return castValue(getValueMapString(map));
	}

	public String getValueMapString(Map<String, String> map){
		String stringValue = map.get(key);
//		if ( stringValue == null && defauldValue != null )
//			stringValue = defauldValue.toString();
		return stringValue;
	}

	public abstract V castValue(String valueString);
	
	public abstract String getDefaultValueAsString();
	
	public void validate(String valueString, List<String> errors){
		if ( StringUtils.isEmpty(valueString)  ){
			if ( isRequired() ){
				errors.add("field " + getName() + " wajib diisi");
			}
			return;
		}
	}

	public String toString(V value){
		return value == null ? null : value.toString();
	}

}
