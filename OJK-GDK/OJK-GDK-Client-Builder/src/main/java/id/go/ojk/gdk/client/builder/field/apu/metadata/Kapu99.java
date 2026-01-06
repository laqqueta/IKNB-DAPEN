package id.go.ojk.gdk.client.builder.field.apu.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.gdk.client.builder.field.EFormApuRencana;

public class Kapu99 extends BaseMetadata {

	public Kapu99(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRencana eEnum = EFormApuRencana.APU_99;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
