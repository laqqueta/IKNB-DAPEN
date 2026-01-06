package id.go.ojk.pps.client.builder.field.apu.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pps.client.builder.field.EFormApuRealisasi;

public class Papu99 extends BaseMetadata {

	public Papu99(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRealisasi eEnum = EFormApuRealisasi.APU_99;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
