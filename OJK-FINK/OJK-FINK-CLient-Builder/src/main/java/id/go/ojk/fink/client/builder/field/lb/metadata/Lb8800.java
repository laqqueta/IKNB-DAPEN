package id.go.ojk.fink.client.builder.field.lb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;

public class Lb8800 extends BaseMetadata {

	public Lb8800(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_8800;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
