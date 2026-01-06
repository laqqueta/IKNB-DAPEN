package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import id.go.ojk.asrjk.client.builder.field.EFormPengawasanBisnisUus;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rp0100 extends BaseMetadata {

	public Rp0100(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormPengawasanBisnisUus eEnum = EFormPengawasanBisnisUus.RP_0100;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
