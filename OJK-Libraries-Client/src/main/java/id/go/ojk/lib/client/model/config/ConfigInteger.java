package id.go.ojk.lib.client.model.config;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.config.Config;
import id.go.ojk.lib.client.model.constant.VariableType;

public class ConfigInteger extends Config<Integer>{

	public ConfigInteger(String key, String name, Integer defauldValue, boolean required, Integer minValue, Integer maxValue) {
		super(key, name, VariableType.intType, defauldValue, required, minValue, maxValue);
	}

	@Override
	public Integer castValue(String valueString) {
		if ( StringUtils.isEmpty(valueString) )
			return getDefauldValue();
		return Integer.parseInt(valueString);
	}
	
	@Override
	public void validate(String valueString, List<String> errors){
		if ( StringUtils.isEmpty(valueString)  ){
			if ( isRequired() ){
				errors.add("field " + getName() + " wajib diisi");
			}
			return;
		}

		Integer valueInt = castValue(valueString);
		if ( getMinValue() > valueInt ){
			errors.add("nilai minimum " + getName() + " " + getMinValue());
		}
		if ( getMaxValue() < valueInt ){
			errors.add("nilai maksimum " + getName() + " " + getMaxValue());
		}
	}

	@Override
	public String getDefaultValueAsString() {
		Integer res = getDefauldValue();
		return res != null ? res.toString() : "";
	}
}
