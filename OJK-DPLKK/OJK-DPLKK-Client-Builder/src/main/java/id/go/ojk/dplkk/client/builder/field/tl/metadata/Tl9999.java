package id.go.ojk.dplkk.client.builder.field.tl.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormTindakLanjut;

public class Tl9999 extends BaseMetadata {

	public Tl9999(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormTindakLanjut eEnum = EFormTindakLanjut.TL_9999;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, null, null);
		return res;
	}
}
