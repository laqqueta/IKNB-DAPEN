package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import id.go.ojk.asrjs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re9002 extends BaseMetadata {

	public Re9002(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_9002;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
