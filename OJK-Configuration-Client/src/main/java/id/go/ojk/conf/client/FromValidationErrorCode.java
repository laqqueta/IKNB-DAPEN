package id.go.ojk.conf.client;

import java.util.Map;

import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class FromValidationErrorCode extends BaseObjectToXml<Map<String, ValidationErrorCode>> {
	
	@Override
	protected void initXStream() {
        super.initXStream();
        xstream.processAnnotations(ValidationErrorCode.class);
//        xstream.useAttributeFor(ValidationErrorCode.class, "code");
//        xstream.useAttributeFor(ValidationErrorCode.class, "subCode");
	}
}
