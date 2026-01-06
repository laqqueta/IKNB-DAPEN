package id.go.ojk.reask.client.builder.field.rb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRealisasiBisnis;

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
