package id.go.ojk.dplks.client.builder.field.tl.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplks.client.builder.field.EFormTindakLanjut;

public class Tl1111 extends BaseMetadata {

	public Tl1111(String reportCode) {
		super(reportCode, ".zip");
	}

	@Override
	public SubmissionFormat get() {
		EFormTindakLanjut eEnum = EFormTindakLanjut.TL_1111;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, null, null);
		return res;
	}
}
