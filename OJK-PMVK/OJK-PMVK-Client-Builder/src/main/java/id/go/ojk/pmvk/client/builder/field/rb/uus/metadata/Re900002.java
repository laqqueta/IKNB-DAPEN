package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnisUus;

public class Re900002 extends BaseMetadata {

	public Re900002(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_900002;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
