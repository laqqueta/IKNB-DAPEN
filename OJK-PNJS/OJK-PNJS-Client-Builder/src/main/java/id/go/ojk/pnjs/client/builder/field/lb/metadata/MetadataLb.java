package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportLb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLb {
	private static final String REPORT_CODE = EReportLb.PNJS_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lb0000(REPORT_CODE).get(),
			new Lb0020(REPORT_CODE).get(),
			new Lb0030(REPORT_CODE).get(),
			new Lb1000(REPORT_CODE).get(),
			new Lb1100(REPORT_CODE).get(),
			new Lb1200(REPORT_CODE).get(),
			new Lb1300(REPORT_CODE).get(),
			new Lb2100A1(REPORT_CODE).get(),
			new Lb2100A2(REPORT_CODE).get(),
			new Lb2100B1(REPORT_CODE).get(),
			new Lb2100B2(REPORT_CODE).get(),
			new Lb2100B3(REPORT_CODE).get(),
			new Lb2100C1(REPORT_CODE).get(),
			new Lb2100C2(REPORT_CODE).get(),
			new Lb2100D1(REPORT_CODE).get(),
			new Lb2100D2(REPORT_CODE).get(),
			new Lb2200(REPORT_CODE).get(),
			new Lb2300(REPORT_CODE).get(),
			new Lb2400(REPORT_CODE).get(),
			new Lb2500(REPORT_CODE).get(),
			new Lb2600(REPORT_CODE).get(),
			new Lb2700(REPORT_CODE).get(),
			new Lb2800(REPORT_CODE).get(),
			new Lb2900(REPORT_CODE).get(),
			new Lb3000(REPORT_CODE).get(),
			new Lb3100(REPORT_CODE).get(),
			new Lb3200A(REPORT_CODE).get(),
			new Lb3200B(REPORT_CODE).get(),
			new Lb3300A(REPORT_CODE).get(),
			new Lb3300B(REPORT_CODE).get(),
			new Lb3400A(REPORT_CODE).get(),
			new Lb3400B(REPORT_CODE).get(),
			new Lb3500A(REPORT_CODE).get(),
			new Lb3500B(REPORT_CODE).get(),
			new Lb4100(REPORT_CODE).get(),
			new Lb5100(REPORT_CODE).get(),
			new Lb6100(REPORT_CODE).get(),
			new Lb7100(REPORT_CODE).get(),
			new Lb8100(REPORT_CODE).get(),
			new Lb9100(REPORT_CODE).get(),
			new Lb9001(REPORT_CODE).get()
			);
}
