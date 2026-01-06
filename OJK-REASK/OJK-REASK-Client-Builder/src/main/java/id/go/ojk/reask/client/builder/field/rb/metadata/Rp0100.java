package id.go.ojk.reask.client.builder.field.rb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormPengawasanBisnis;

public class Rp0100 extends BaseMetadata {

	public Rp0100(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormPengawasanBisnis eEnum = EFormPengawasanBisnis.RP_0100;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
