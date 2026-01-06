package id.go.ojk.ppis.client.builder.field.lb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportTypeCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLb {
	private static final String REPORT_CODE = EReportTypeCode.PPIS.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lb0000(REPORT_CODE).get(),
			new Lb0010(REPORT_CODE).get(),
			new Lb0020(REPORT_CODE).get(),
			new Lb0030(REPORT_CODE).get(),
			new Lb0035(REPORT_CODE).get(),
			new Lb0036(REPORT_CODE).get(),
			new Lb0041(REPORT_CODE).get(),
			new Lb0043(REPORT_CODE).get(),
			new Lb0046(REPORT_CODE).get(),
			new Lb1100(REPORT_CODE).get(),
			new Lb1110(REPORT_CODE).get(),
			new Lb1200(REPORT_CODE).get(),
			new Lb1300(REPORT_CODE).get(),
			new Lb2100(REPORT_CODE).get(),
			new Lb2150(REPORT_CODE).get(),
			new Lb2200(REPORT_CODE).get(),
			new Lb2300(REPORT_CODE).get(),
			new Lb2350(REPORT_CODE).get(),
			new Lb2380(REPORT_CODE).get(),
			new Lb2490(REPORT_CODE).get(),
			new Lb2550(REPORT_CODE).get(),
			new Lb2600(REPORT_CODE).get(),
			new Lb2790(REPORT_CODE).get(),
			new Lb3010(REPORT_CODE).get(),
			new Lb5310(REPORT_CODE).get()
			);
}
