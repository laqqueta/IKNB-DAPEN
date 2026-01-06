package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRb {
	private static final String REPORT_CODE = EReportRb.DPPKK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Rb0100(REPORT_CODE).get(),
					new Rb0200(REPORT_CODE).get(),
					new Rb0300(REPORT_CODE).get(),
					new Rb0400(REPORT_CODE).get(),
					new Rb0500(REPORT_CODE).get(),
					new Rb0600(REPORT_CODE).get(),
					new Rb0700(REPORT_CODE).get(),
					new Rb0800(REPORT_CODE).get(),
					new Rb0900(REPORT_CODE).get(),
					new Rb1000(REPORT_CODE).get(),
					new Rb1100(REPORT_CODE).get(),
					new Rb1200(REPORT_CODE).get(),
					new Rb1300(REPORT_CODE).get(),
					new Rb1400(REPORT_CODE).get(),
					new Rb1500(REPORT_CODE).get(),
					new Rb9001(REPORT_CODE).get(),
					new Rb9002(REPORT_CODE).get()
					);
}
