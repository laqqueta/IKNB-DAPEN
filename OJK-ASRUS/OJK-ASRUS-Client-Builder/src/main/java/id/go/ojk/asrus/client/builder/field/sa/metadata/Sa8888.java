package id.go.ojk.asrus.client.builder.field.sa.metadata;

import id.go.ojk.asrus.client.builder.field.EFormSelfAssessment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa8888 extends BaseMetadata {

	public Sa8888(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_8888;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
