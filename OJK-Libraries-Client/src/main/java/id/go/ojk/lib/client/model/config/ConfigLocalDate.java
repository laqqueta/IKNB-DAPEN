package id.go.ojk.lib.client.model.config;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.model.constant.VariableType;

public class ConfigLocalDate extends Config<LocalDate>{

	public ConfigLocalDate(String key, String name, LocalDate defauldValue, boolean required) {
		super(key, name, VariableType.localDateType, defauldValue, required);
	}

	@Override
	public LocalDate castValue(String valueString) {
		LocalDate result = null;
		if ( StringUtils.isEmpty(valueString) ){
			result = getDefauldValue() ;
		} else {
			result = LocalDate.parse(valueString, DateUtil.dateTimeFormatterYYYYmmss);
		}
		return result;
	}

	@Override
	public String getDefaultValueAsString() {
		LocalDate res = getDefauldValue();
		return res != null ? res.format(DateUtil.dateTimeFormatterYYYYmmss) : "";
	}
}
