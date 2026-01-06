package id.go.ojk.ppis.client.builder.field.sa.metadata;

import java.util.ArrayList;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppis.client.builder.field.EFormSelfAssessment;

public class Sa888888 extends BaseMetadata {

	public Sa888888(String reportCode) {
		super(reportCode, ".pdf");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_888888;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);
		return res;
	}

}
