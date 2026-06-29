package id.go.ojk.client.model.config.validation.segmen;

import id.go.ojk.client.constant.EMacro;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.constant.Operator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public abstract class MapParamSegmentValidation extends BaseSegmentValidation {
	protected Map<String, String> parameterMap = new HashMap<>();

	protected MapParamSegmentValidation(){
		super();
	}

	protected MapParamSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public MapParamSegmentValidation setParameter(String parameter) {
		this.parameter = parameter;
		parameterMap = CollectionUtil.toMap(parameter);
		initialized();
		return this;
	}

	//~ util
	
	protected boolean getBooleanParameter(String name, boolean defValue){
		String valueString = getStringParameter(name);
		if ( StringUtils.isEmpty(valueString) )
			return defValue;
		return Boolean.parseBoolean(valueString);
	}
	
	protected Boolean getBooleanParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Boolean.parseBoolean(getStringParameter(name));
	}
	
	protected Double getDoubleParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return null;
		return Double.parseDouble(getStringParameter(name));
	}
	
	protected Double getDoubleParameter(String name, String defaultValue){
		String str = getStringParameter(name, defaultValue);
		return Double.parseDouble(str);
	}
	
	protected int[] getIntParameters(String name){
		return CollectionUtil.toIntArrayDetailOrRange(getStringParameter(name));
	}

	protected int getIntParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return 0;
		return Integer.parseInt(getStringParameter(name));
	}

	protected long getLongParameter(String name){
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return 0;
		return Long.parseLong(getStringParameter(name));
	}

    protected Operator getOperatorParameter(String operator) {
        if ( StringUtils.isEmpty(getStringParameter(operator)) )
            return null;

        return Operator.valueOf(getStringParameter(operator).toUpperCase());
    }

	protected String getStringParameter(String name){
		return this.parameterMap.get(name);
	}
	
	protected String[] getStringParameters(String name){
		return CollectionUtil.toStringArray(getStringParameter(name));
	}
	
	protected Map<String, String> getStringMapParameter(String name){
		return CollectionUtil.toMap(getStringParameter(name), "[|]", ">", true);
	}
	
	protected String getStringParameter(String name, String defaultValue){
		String result =  this.parameterMap.get(name);
		return StringUtils.isEmpty(result) ? defaultValue : result;
	}
	
	protected List<String> getStringListParameter(String name){
		String value = getStringParameter(name);
		if ( StringUtils.isEmpty(value) )
			return new ArrayList<>();
		return CollectionUtil.toStringList(value);
	}
	
	protected Set<String> getStringSetParameter(String name){
		String value = getStringParameter(name);
		if ( StringUtils.isEmpty(getStringParameter(name)) )
			return new HashSet<>();
		return CollectionUtil.toStringSet(value);
	}

	protected String getString(int idx, String[] arr, String defaultValue) {
		String res = defaultValue;
		if (arr != null && arr.length >= idx) {
			String tmp = arr[idx];
			if (StringUtils.isNotBlank(tmp)) {
				res = tmp;
			}
		}
		return res;
	}
	
	protected String initOperator(String operator) {
		String res = "==";
		switch (operator) {
		case "e":
			res = "==";
			break;
		case "ne":
			res = "!=";
			break;
		case "lt":
			res = "<";
			break;
		case "lte":
			res = "<=";
			break;
		case "gt":
			res = ">";
			break;
		case "gte":
			res = ">=";
			break;
		default:
			break;
		}
		return res;
	}
	
	protected BigDecimal toBigDecimal(String str) {
		BigDecimal res = null;
		try {
			res = new BigDecimal(str);
		} catch (Exception e) {
			res = BigDecimal.ZERO;
		}
		return res;
	}
	
	protected BigDecimal toBigDecimal(String str, int defaultValue) {
		BigDecimal res = null;
		try {
			res = new BigDecimal(str);
		} catch (Exception e) {
			res = new BigDecimal(defaultValue);
		}
		return res;
	}

	protected BigDecimal arithmeticOperation(String formula, int fieldNumber) {
		return arithmeticOperation(SubmissionFormat.mapPosValue, formula, fieldNumber);
	}

	protected BigDecimal arithmeticOperation(Map<String, Map<String, String>> savedValues, String formula, int fieldNumber) {
		Logger logger = LoggerFactory.getLogger(MapParamSegmentValidation.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] formulaSplit = formula.split("(?<=[-+/*])|(?=[-+/*])");
			if (formulaSplit != null) {
				int length = formulaSplit.length;
				String valueOperator = "+";
				for (int i = 0; i < length; i++) {
					String value = formulaSplit[i];
					if (value.length() == 1) {
						valueOperator = value;
					} else {
						BigDecimal tmp = SubmissionFormat.getSum(savedValues, value, String.valueOf(fieldNumber));
						if (valueOperator.equals("-")) {
							res = res.subtract(tmp);
						} else if (valueOperator.equals("*")) {
							res = res.multiply(tmp);
						} else if (valueOperator.equals("/")) {
							if (tmp == BigDecimal.ZERO) {
								res = BigDecimal.ZERO;
							} else {
								res = res.divide(tmp);
							}
						} else {
							res = res.add(tmp);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(parameter, e);
		}
		return res;
	}
	
	protected BigDecimal getSavedValue(String posCode, int idxField) {
		return SubmissionFormat.getSumMapPosValue(posCode, String.valueOf(idxField));
	}
	
	protected boolean isDecimal(String decimalSeparator, String text) {
		return text != null ? text.indexOf(decimalSeparator) > -1 : false;
	}
	
	protected boolean isDecimal(String text) {
		return isDecimal(".", text);
	}
	
	protected int getDecimalScale(String decimalSeparator, String text) {
		int res = 0;
		if (text != null) {
			int idx = text.indexOf(decimalSeparator);
			res = idx > -1 ? text.substring(idx + 1).length() : 0;
		}
		return res;
	}
	
	protected int getDecimalScale(String text) {
		return getDecimalScale(".", text);
	}
	
	protected String replaceMacro(String text) {
		String res = text;
		if (StringUtils.isNotEmpty(text)) {
			res = StringUtils.replaceEach(res, EMacro.getArrMacro(), EMacro.getArrReplacement());
		}
		return res;
	}
}
