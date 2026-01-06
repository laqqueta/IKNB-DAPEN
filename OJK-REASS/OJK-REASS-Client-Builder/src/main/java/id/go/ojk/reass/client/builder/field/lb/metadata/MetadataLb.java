package id.go.ojk.reass.client.builder.field.lb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportLb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLb {
	private static final String REPORT_CODE = EReportLb.REASS_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(new Lb000(REPORT_CODE).get(),
			new Lb001(REPORT_CODE).get(), new Lb002(REPORT_CODE).get(), new Lb003(REPORT_CODE).get(),
			new Lb004(REPORT_CODE).get(), new Lb910(REPORT_CODE).get(), new Lb100(REPORT_CODE).get(),
			new Lb200(REPORT_CODE).get(), new Lb300(REPORT_CODE).get(), new Lb400(REPORT_CODE).get(),
			new Lb500(REPORT_CODE).get(), new Lb501(REPORT_CODE).get(), new Lb600(REPORT_CODE).get(),
			new Lb601(REPORT_CODE).get(), new Lb700(REPORT_CODE).get(), new Lb701(REPORT_CODE).get(),
			new Lb110(REPORT_CODE).get(), new Lb111(REPORT_CODE).get(), new Lb210(REPORT_CODE).get(),
			new Lb211(REPORT_CODE).get(), new Lb212(REPORT_CODE).get(), new Lb213(REPORT_CODE).get(),
			new Lb214(REPORT_CODE).get(), new Lb215(REPORT_CODE).get(), new Lb216(REPORT_CODE).get(),
			new Lb217(REPORT_CODE).get(), new Lb218(REPORT_CODE).get(), new Lb219(REPORT_CODE).get(),
			new Lb220(REPORT_CODE).get(), new Lb221(REPORT_CODE).get(), new Lb222(REPORT_CODE).get(),
			new Lb223(REPORT_CODE).get(), new Lb224(REPORT_CODE).get(), new Lb225(REPORT_CODE).get(),
			new Lb226(REPORT_CODE).get(), new Lb227(REPORT_CODE).get(), new Lb228(REPORT_CODE).get(),
			new Lb229(REPORT_CODE).get(), new Lb230(REPORT_CODE).get(), new Lb231(REPORT_CODE).get(),
			new Lb232(REPORT_CODE).get(), new Lb233(REPORT_CODE).get(), new Lb234(REPORT_CODE).get(),
			new Lb235(REPORT_CODE).get(), new Lb236(REPORT_CODE).get());
}
