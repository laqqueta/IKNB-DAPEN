package id.go.ojk.pmvk.client.builder.field.apu.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormApuRencana;

public class Kapu00 extends BaseMetadata {

	public Kapu00(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRencana eEnum = EFormApuRencana.APU_00;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, 0,
				null);
	}
}
