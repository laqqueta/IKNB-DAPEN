package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.DateUtil;

public abstract class MapParamFieldValidation extends BaseFieldValidation {

	protected Map<String, String> parameterMap;

	@Override
	public BaseFieldValidation setParameter(String parameter) {
		this.parameter = parameter;
		this.parameterMap = CollectionUtil.toMap(parameter);
		initialized();
		return this;
	}
	
	//~ util

	protected Integer getIntParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Integer.parseInt(getStringParameter(name));
	}

	protected int getIntParameter(String name, int defaultValue){
		String tmp = getStringParameter(name);
		int res = StringUtils.isNumeric(tmp) ? Integer.valueOf(tmp) : defaultValue;
		return res;
	}

	protected Long getLongParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Long.parseLong(getStringParameter(name));
	}

	protected Long getLongParameter(String name, Long defauldValue){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return defauldValue;
		return Long.parseLong(getStringParameter(name));
	}

	protected Double getDoubleParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Double.parseDouble(getStringParameter(name));
	}

	protected LocalDate getLocalDateParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return LocalDate.parse(name, DateUtil.dateTimeFormatterYYYYmmss);
	}

	protected Boolean getBooleanParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Boolean.parseBoolean(getStringParameter(name));
	}
	
	protected boolean getBooleanParameter(String name, boolean defValue){
		String valueString = getStringParameter(name);
		if ( StringUtils.isEmpty(valueString) )
			return defValue;
		return Boolean.parseBoolean(valueString);
	}

	protected String getStringParameter(String name){
		return this.parameterMap.get(name);
	}

	protected String getStringParameter(String name, String defauldValue){
		String result = this.parameterMap.get(name);
		return result == null ? defauldValue : result;
	}

	protected List<String> getStringListParameter(String name, String delimiter) {
		String[] arr = StringUtils.split(this.parameterMap.get(name), delimiter);
		return (arr != null ? Arrays.asList(arr) : new ArrayList<>());
	}
}
