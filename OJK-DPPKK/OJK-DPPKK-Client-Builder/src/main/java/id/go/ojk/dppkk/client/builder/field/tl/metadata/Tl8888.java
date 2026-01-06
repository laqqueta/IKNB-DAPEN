package id.go.ojk.dppkk.client.builder.field.tl.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormTindakLanjut;

public class Tl8888 extends BaseMetadata {

	public Tl8888(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormTindakLanjut eEnum = EFormTindakLanjut.TL_8888;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, null, null);
		return res;
	}
}
