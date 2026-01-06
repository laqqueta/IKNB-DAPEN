package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import id.go.ojk.asrjs.client.builder.field.EFormPengawasanBisnis;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

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
