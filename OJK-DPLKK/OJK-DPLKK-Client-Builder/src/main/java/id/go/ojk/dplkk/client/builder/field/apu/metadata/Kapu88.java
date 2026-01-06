package id.go.ojk.dplkk.client.builder.field.apu.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormApuRencana;

public class Kapu88 extends BaseMetadata {

	public Kapu88(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRencana eEnum = EFormApuRencana.APU_88;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
