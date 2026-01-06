package id.go.ojk.conf.client;

import id.go.ojk.client.model.config.SubmissionMetadata;

public class FromSubmissionMetadata extends BaseObjectToXml<SubmissionMetadata> {
	
	@Override
	protected void initXStream() {
        super.initXStream();
        xstream.processAnnotations(SubmissionMetadata.class);
//        xstream.useAttributeFor(ValidationErrorCode.class, "code");
//        xstream.useAttributeFor(ValidationErrorCode.class, "subCode");
	}
}
