package id.go.ojk.reask.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRb {
	private static final String REPORT_CODE = EReportRb.REASK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Rb0104(REPORT_CODE).get(),
					new Rb0105(REPORT_CODE).get(),
					new Rb0201(REPORT_CODE).get(),
					new Rb0400(REPORT_CODE).get(),
					new Rb0500(REPORT_CODE).get(),
					new Rb0601(REPORT_CODE).get(),
					new Rb0602(REPORT_CODE).get(),
					new Rb0702(REPORT_CODE).get(),
					new Rb0900(REPORT_CODE).get(),
					new Rb1002(REPORT_CODE).get(),
					new Rb1003(REPORT_CODE).get(),
					new Rb1004(REPORT_CODE).get(),
					new Rb1005(REPORT_CODE).get(),
					new Rb1006(REPORT_CODE).get(),
					new Rb1301(REPORT_CODE).get(),
					new Rb1304(REPORT_CODE).get(),
					new Rb1307(REPORT_CODE).get(),
					new Rb1310(REPORT_CODE).get(),
					new Rb1313(REPORT_CODE).get(),
					new Rb9001(REPORT_CODE).get(),
					new Rb9002(REPORT_CODE).get(),
					new Rb9003(REPORT_CODE).get()
					);
}
