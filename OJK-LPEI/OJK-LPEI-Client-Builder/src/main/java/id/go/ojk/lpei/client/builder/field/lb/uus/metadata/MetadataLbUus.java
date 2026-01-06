package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportTypeCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbUus {
	private static final String REPORT_CODE = EReportTypeCode.LBLPIU.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lb0000(REPORT_CODE).get(),
			new Lb0020(REPORT_CODE).get(),
			new Lb0041(REPORT_CODE).get(),
			new Lb0043(REPORT_CODE).get(),
			new Lb0046(REPORT_CODE).get(),
			new Lb1000(REPORT_CODE).get(),
			new Lb1100(REPORT_CODE).get(),
			new Lb1110(REPORT_CODE).get(),
			new Lb1200(REPORT_CODE).get(),
			new Lb1300(REPORT_CODE).get(),
			new Lb2000(REPORT_CODE).get(),
			new Lb2050(REPORT_CODE).get(),
			new Lb2100(REPORT_CODE).get(),
			new Lb2150(REPORT_CODE).get(),
			new Lb2200(REPORT_CODE).get(),
			new Lb2350(REPORT_CODE).get(),
			new Lb2400(REPORT_CODE).get(),
			new Lb2450(REPORT_CODE).get(),
			new Lb2490(REPORT_CODE).get(),
			new Lb2550(REPORT_CODE).get(),
			new Lb2600(REPORT_CODE).get(),
			new Lb2700(REPORT_CODE).get(),
			new Lb2730(REPORT_CODE).get(),
			new Lb2760(REPORT_CODE).get(),
			new Lb2790(REPORT_CODE).get(),
			new Lb5200(REPORT_CODE).get(),
			new Lb5310(REPORT_CODE).get(),
			new Lb9001(REPORT_CODE).get()
	);
}
