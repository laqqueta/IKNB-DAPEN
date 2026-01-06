package id.go.ojk.lib.client.model.config;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.model.constant.VariableType;

public class ConfigLong extends Config<Long>{

	private long multiplier;
	public ConfigLong(String key, String name, Long defauldValue, boolean required, long multiplier, Long minValue, Long maxValue) {
		super(key, name, VariableType.longType, defauldValue, required, minValue, maxValue);
		this.multiplier = multiplier;
	}

	@Override
	public Long castValue(String valueString) {
//		Long result = null;
//		if ( StringUtils.isEmpty(valueString) ){
//			result = getDefauldValue() ;
//		} else {
//			result = Long.parseLong(valueString);
//		}
		Long result = castValueNoMultiplier(valueString);
		return result == null ? null : result * multiplier;
	}
	
	public Long castValueNoMultiplier(String valueString) {
		Long result = null;
		if ( StringUtils.isEmpty(valueString) ){
			result = getDefauldValue() ;
		} else {
			result = Long.parseLong(valueString);
		}
		return result;
	}
	
	@Override
	public void validate(String valueString, List<String> errors){
		if ( StringUtils.isEmpty(valueString)  ){
			if ( isRequired() ){
				errors.add("field " + getName() + " wajib diisi");
			}
			return;
		}
		
		Long valueLong = castValueNoMultiplier(valueString);
		if ( getMinValue() > valueLong ){
			errors.add("nilai minimum " + getName() + " " + getMinValue());
		}
		if ( getMaxValue() < valueLong ){
			errors.add("nilai maksimum " + getName() + " " + getMaxValue());
		}
	}

	@Override
	public String getDefaultValueAsString() {
		Long res = getDefauldValue();
		return res != null ? res.toString() : "";
	}
}
