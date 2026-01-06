package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lb.EReportLb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLb {
	private static final String REPORT_CODE = EReportLb.ASRJK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(new Lb000(REPORT_CODE).get(),
			new Lb001(REPORT_CODE).get(), new Lb002(REPORT_CODE).get(), new Lb003(REPORT_CODE).get(),
			new Lb910(REPORT_CODE).get(), new Lb100(REPORT_CODE).get(), new Lb200(REPORT_CODE).get(),
			new Lb300(REPORT_CODE).get(), new Lb400(REPORT_CODE).get(), new Lb500(REPORT_CODE).get(),
			new Lb501(REPORT_CODE).get(), new Lb502(REPORT_CODE).get(), new Lb503(REPORT_CODE).get(),
			new Lb504(REPORT_CODE).get(), new Lb505(REPORT_CODE).get(), new Lb506(REPORT_CODE).get(),
			new Lb507(REPORT_CODE).get(), new Lb508(REPORT_CODE).get(), new Lb101(REPORT_CODE).get(),
			new Lb102(REPORT_CODE).get(), new Lb103(REPORT_CODE).get(), new Lb104(REPORT_CODE).get(),
			new Lb105(REPORT_CODE).get(), new Lb106(REPORT_CODE).get(), new Lb107(REPORT_CODE).get(),
			new Lb108(REPORT_CODE).get(), new Lb109(REPORT_CODE).get(), new Lb110(REPORT_CODE).get(),
			new Lb111(REPORT_CODE).get(), new Lb112(REPORT_CODE).get(), new Lb113(REPORT_CODE).get(),
			new Lb114(REPORT_CODE).get(), new Lb201(REPORT_CODE).get(), new Lb202(REPORT_CODE).get(),
			new Lb203(REPORT_CODE).get(), new Lb204(REPORT_CODE).get(), new Lb205(REPORT_CODE).get(),
			new Lb206(REPORT_CODE).get(), new Lb115(REPORT_CODE).get(), new Lb117(REPORT_CODE).get(),
			new Lb118(REPORT_CODE).get(), new Lb207(REPORT_CODE).get(), new Lb208(REPORT_CODE).get(),
			new Lb209(REPORT_CODE).get(), new Lb210(REPORT_CODE).get(), new Lb220(REPORT_CODE).get(),
			new Lb601(REPORT_CODE).get(), new Lb211(REPORT_CODE).get(), new Lb212(REPORT_CODE).get(),
			new Lb213(REPORT_CODE).get(), new Lb602(REPORT_CODE).get(), new Lb603(REPORT_CODE).get(),
			new Lb604(REPORT_CODE).get(), new Lb605(REPORT_CODE).get(), new Lb606(REPORT_CODE).get(),
			new Lb607(REPORT_CODE).get(), new Lb608(REPORT_CODE).get(), new Lb614(REPORT_CODE).get(),
			new Lb615(REPORT_CODE).get(), new Lb616(REPORT_CODE).get(), new Lb119(REPORT_CODE).get(),
			new Lb617(REPORT_CODE).get(), new Lb120(REPORT_CODE).get(), new Lb121(REPORT_CODE).get(),
			new Lb122(REPORT_CODE).get(), new Lb618(REPORT_CODE).get(), new Lb619(REPORT_CODE).get(),
			new Lb620(REPORT_CODE).get(), new Lb621(REPORT_CODE).get(), new Lb622(REPORT_CODE).get());
}
