package id.go.ojk.conf.client;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

public abstract class BaseMetadata implements IMetadata {
	protected String reportCode;
	protected String extension = ".txt";
	
	public BaseMetadata(String reportCode, String extension) {
		this.reportCode = reportCode;
		this.extension = StringUtils.isEmpty(extension) ? ".txt" : extension;
	}
	
	protected SubmissionField sf(Integer number, String code, String name, SimpleValidation simpleValidation) {
		return new SubmissionField(number, code, name, simpleValidation);
	}
	
	protected SimpleValidation sv(RequiredCondition requiredCondition, int minLength, int maxLength, DataType dataType) {
		return new SimpleValidation(requiredCondition, minLength, maxLength, dataType);
	}

}
