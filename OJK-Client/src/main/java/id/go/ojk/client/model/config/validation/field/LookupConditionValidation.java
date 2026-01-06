package id.go.ojk.client.model.config.validation.field;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("LookupConditionValidation")
public class LookupConditionValidation extends MapParamFieldValidation {
	protected String keyField;
	protected String lookup;
	protected String defaultValue;

	public LookupConditionValidation(String parameter) {
		setParameter(parameter);
	}
	
	public LookupConditionValidation() {
		super();
	}

	public LookupConditionValidation initialized() {
		keyField = getStringParameter("keyField");
		lookup = getStringParameter("lookup");
		defaultValue = getStringParameter("defaultValue");
		return this;
	}
	
	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Map<String, String> mapLookup = getLookup();
		String key = getKey(validationResult);
		String value = validationResult.getColumn(field.getNumber());
		if (mapLookup.containsKey(key)) {
			String mapValue = mapLookup.get(key);
			if (!StringUtils.equals(value, mapValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_10_FORMULA2, mapValue));
			}
		} else {
			if (StringUtils.isNotEmpty(defaultValue) && !StringUtils.equals(value, defaultValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E50_10_FORMULA2, defaultValue));
			} else {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY));
			}
		}
	}
	
	private Map<String, String> getLookup() {
		Map<String, String> res = new HashMap<>();
		String[] arrKeyVal = StringUtils.split(lookup, "|");
		if (arrKeyVal != null) {
			for (int i = 0; i < arrKeyVal.length; i++) {
				String[] keyVal = StringUtils.split(arrKeyVal[i], ":");
				if (keyVal != null && keyVal.length > 1) {
					res.put(keyVal[0], keyVal[1]);
				}
			}
		}
		return res;
	}
	
	private String getKey(ValidationResult validationResult) {
		StringBuilder res = new StringBuilder();
		String[] arrKey = StringUtils.split(keyField, "|");
		if (arrKey != null) {
			for (int i = 0; i < arrKey.length; i++) {
				res.append(validationResult.getColumn(Integer.valueOf(arrKey[i])));
			}
		}
		return res.toString();
	}
}
