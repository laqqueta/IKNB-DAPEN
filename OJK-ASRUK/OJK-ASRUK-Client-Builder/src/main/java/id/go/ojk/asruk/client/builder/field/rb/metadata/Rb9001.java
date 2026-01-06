package id.go.ojk.asruk.client.builder.field.rb.metadata;

import id.go.ojk.asruk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb9001 extends BaseMetadata {

	public Rb9001(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_9001;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
