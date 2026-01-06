package id.go.ojk.client.model.config.validation.conditional;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;

import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

public abstract class MapParamConditionalRequired extends BaseConditionalRequired {

	//@XStreamOmitField
	protected Map<String, String> parameterMap;

	@Override
	public ConditionalRequired setParameter(String parameter) {
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

	protected Boolean getBooleanParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Boolean.parseBoolean(getStringParameter(name));
	}

	protected RequiredCondition getRequiredConditionParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return RequiredCondition.valueOf(getStringParameter(name));
	}

	protected Comparation getComparationParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Comparation.valueOf(getStringParameter(name));
	}

	protected int[] getIntArrayParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return CollectionUtil.toIntArray(getStringParameter(name));
	}

	protected Integer[] getIntegerArrayParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return CollectionUtil.toIntegerArray(getStringParameter(name));
	}

	protected String[] getStringArrayParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return CollectionUtil.toStringArray(getStringParameter(name));
	}

	protected String getStringParameter(String name){
		return this.parameterMap.get(name);
	}

	protected String getStringParameter(String name, String defauldValue){
		String result =  this.parameterMap.get(name);
		return result == null ? defauldValue : result;
	}

	protected BigDecimal getAsBigDecimal(String name, int defaultValue){
		String string =  this.parameterMap.get(name);
		return ToBigDecimal.convert(string, defaultValue);
	}

	protected BigDecimal getAsBigDecimal(String name){
		return getAsBigDecimal(name, 0);
	}

}
