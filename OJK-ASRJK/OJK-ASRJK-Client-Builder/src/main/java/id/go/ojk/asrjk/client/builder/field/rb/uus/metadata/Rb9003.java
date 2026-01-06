package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb9003 extends BaseMetadata {

	public Rb9003(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_9003;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
