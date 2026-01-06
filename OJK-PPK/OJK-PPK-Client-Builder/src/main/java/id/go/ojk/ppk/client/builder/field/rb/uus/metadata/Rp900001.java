package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormPengawasanBisnisUus;

public class Rp900001 extends BaseMetadata {

	public Rp900001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormPengawasanBisnisUus eEnum = EFormPengawasanBisnisUus.RP_900001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
