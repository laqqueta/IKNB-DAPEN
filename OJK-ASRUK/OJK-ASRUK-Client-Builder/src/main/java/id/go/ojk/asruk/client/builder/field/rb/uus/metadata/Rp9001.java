package id.go.ojk.asruk.client.builder.field.rb.uus.metadata;

import id.go.ojk.asruk.client.builder.field.EFormPengawasanBisnisUus;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rp9001 extends BaseMetadata {

	public Rp9001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormPengawasanBisnisUus eEnum = EFormPengawasanBisnisUus.RP_9001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
