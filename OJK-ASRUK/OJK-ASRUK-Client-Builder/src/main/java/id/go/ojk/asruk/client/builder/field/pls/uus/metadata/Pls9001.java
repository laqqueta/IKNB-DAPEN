package id.go.ojk.asruk.client.builder.field.pls.uus.metadata;

import id.go.ojk.asruk.client.builder.field.EFormLaporanPolisUus;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Pls9001 extends BaseMetadata {

	public Pls9001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanPolisUus eEnum = EFormLaporanPolisUus.PLS_9001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
