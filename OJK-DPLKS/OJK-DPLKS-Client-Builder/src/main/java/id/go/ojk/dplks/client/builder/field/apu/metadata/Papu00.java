package id.go.ojk.dplks.client.builder.field.apu.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplks.client.builder.field.EFormApuRealisasi;

public class Papu00 extends BaseMetadata {

	public Papu00(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuRealisasi eEnum = EFormApuRealisasi.APU_00;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, 0, null);
	}
}
