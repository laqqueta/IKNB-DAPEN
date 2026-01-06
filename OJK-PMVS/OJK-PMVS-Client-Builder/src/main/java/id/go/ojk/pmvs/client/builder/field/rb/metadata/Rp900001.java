package id.go.ojk.pmvs.client.builder.field.rb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvs.client.builder.field.EFormPengawasanBisnis;

public class Rp900001 extends BaseMetadata {

	public Rp900001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormPengawasanBisnis eEnum = EFormPengawasanBisnis.RP_900001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
