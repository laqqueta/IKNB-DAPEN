package id.go.ojk.dppks.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRb {
	private static final String REPORT_CODE = EReportRb.DPPKS_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Rb0100(REPORT_CODE).get(),
					new Rb0204(REPORT_CODE).get(),
					new Rb0205(REPORT_CODE).get(),
					new Rb0301(REPORT_CODE).get(),
					new Rb0403(REPORT_CODE).get(),
					new Rb0600(REPORT_CODE).get(),
					new Rb0701(REPORT_CODE).get(),
					new Rb0702(REPORT_CODE).get(),
					new Rb0703(REPORT_CODE).get(),
					new Rb0801(REPORT_CODE).get(),
					new Rb0802(REPORT_CODE).get(),
					new Rb0900(REPORT_CODE).get(),
					new Rb1001(REPORT_CODE).get(),
					new Rb1002(REPORT_CODE).get(),
					new Rb1003(REPORT_CODE).get(),
					new Rb1004(REPORT_CODE).get(),
					new Rb1201(REPORT_CODE).get(),
					new Rb1202(REPORT_CODE).get(),
					new Rb1203(REPORT_CODE).get(),
					new Rb9001(REPORT_CODE).get(),
					new Rb9002(REPORT_CODE).get()
					);
}
