package id.go.ojk.asrjk.client.builder.field.apu.metadata;

import id.go.ojk.asrjk.client.builder.field.EFormApuRealisasi;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Papu88 extends BaseMetadata {

	public Papu88(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRealisasi eEnum = EFormApuRealisasi.APU_88;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
