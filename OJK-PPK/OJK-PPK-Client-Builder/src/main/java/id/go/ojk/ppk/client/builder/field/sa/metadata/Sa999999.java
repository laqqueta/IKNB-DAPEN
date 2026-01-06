package id.go.ojk.ppk.client.builder.field.sa.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormSelfAssessment;

public class Sa999999 extends BaseMetadata {

	public Sa999999(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_999999;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
