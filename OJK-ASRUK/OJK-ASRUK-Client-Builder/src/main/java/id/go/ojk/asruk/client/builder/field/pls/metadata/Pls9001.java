package id.go.ojk.asruk.client.builder.field.pls.metadata;

import id.go.ojk.asruk.client.builder.field.EFormLaporanPolis;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Pls9001 extends BaseMetadata {

	public Pls9001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanPolis eEnum = EFormLaporanPolis.PLS_9001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
