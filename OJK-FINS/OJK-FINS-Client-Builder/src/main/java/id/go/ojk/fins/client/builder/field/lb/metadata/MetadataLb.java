package id.go.ojk.fins.client.builder.field.lb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lbk.EReportTypeCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLb {
	private static final String REPORT_CODE = EReportTypeCode.LB_FINS.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lb0000(REPORT_CODE).get(),
			new Lb0001(REPORT_CODE).get(),
			new Lb0002(REPORT_CODE).get(),
			new Lb0003(REPORT_CODE).get(),
			new Lb1100(REPORT_CODE).get(),
			new Lb1200(REPORT_CODE).get(),
			new Lb1201(REPORT_CODE).get(),
			new Lb1300(REPORT_CODE).get(),
			new Lb8800(REPORT_CODE).get(),
			new Lb6901(REPORT_CODE).get(),
			new Lb6902(REPORT_CODE).get(),
			new Lb6903(REPORT_CODE).get(),
			new Lb2907(REPORT_CODE).get(),
			new Lb6908(REPORT_CODE).get(),
			new Lb6910(REPORT_CODE).get(),
			new Lb6909(REPORT_CODE).get(),
			new Lb2111(REPORT_CODE).get(),
			new Lb2112(REPORT_CODE).get(),
			new Lb2116(REPORT_CODE).get(),
			new Lb2113(REPORT_CODE).get(),
			new Lb2114(REPORT_CODE).get(),
			new Lb2115(REPORT_CODE).get(),
			new Lb2117(REPORT_CODE).get(),
			new Lb2120(REPORT_CODE).get(),
			new Lb2121(REPORT_CODE).get(),
			new Lb2119(REPORT_CODE).get(),
			new Lb2118(REPORT_CODE).get(),
			new Lb2913(REPORT_CODE).get(),
			new Lb2310(REPORT_CODE).get(),
			new Lb2910(REPORT_CODE).get(),
			new Lb2122(REPORT_CODE).get(),
			new Lb2911(REPORT_CODE).get(),
			new Lb2912(REPORT_CODE).get()
			);
}
