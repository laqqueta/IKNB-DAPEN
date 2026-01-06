package id.go.ojk.asrjk.client.builder.field.sa.uus.metadata;

import id.go.ojk.asrjk.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa8888 extends BaseMetadata {

	public Sa8888(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_8888;
		return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
	}
}
