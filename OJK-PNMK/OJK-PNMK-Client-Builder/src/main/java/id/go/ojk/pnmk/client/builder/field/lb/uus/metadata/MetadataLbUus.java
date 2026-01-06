package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportTypeCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbUus {
	private static final String REPORT_CODE = EReportTypeCode.PNMU.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lb0000(REPORT_CODE).get(),
			new Lb0020(REPORT_CODE).get(),
			new Lb0030(REPORT_CODE).get(),
			new Lb1100(REPORT_CODE).get(),
			new Lb1200(REPORT_CODE).get(),
			new Lb1300(REPORT_CODE).get(),
			new Lb1400(REPORT_CODE).get(),
			new Lb2100(REPORT_CODE).get(),
			new Lb2200(REPORT_CODE).get(),
			new Lb2300(REPORT_CODE).get(),
			new Lb2400(REPORT_CODE).get(),
			new Lb2500(REPORT_CODE).get(),
			new Lb2600(REPORT_CODE).get(),
			new Lb2700(REPORT_CODE).get(),
			new Lb2800(REPORT_CODE).get(),
			new Lb2900(REPORT_CODE).get()
			);
}
