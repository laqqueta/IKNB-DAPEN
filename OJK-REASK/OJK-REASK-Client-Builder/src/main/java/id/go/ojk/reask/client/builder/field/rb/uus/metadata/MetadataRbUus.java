package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRbUus {
	private static final String REPORT_CODE = EReportRb.REASU_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Rb0101(REPORT_CODE).get(),
					new Rb0102(REPORT_CODE).get(),
					new Rb0103(REPORT_CODE).get(), 
					new Rb0104(REPORT_CODE).get(), 
					new Rb0201(REPORT_CODE).get(), 
					new Rb0202(REPORT_CODE).get(),
					new Rb0401(REPORT_CODE).get(), 
					new Rb0501(REPORT_CODE).get(),
					new Rb0601(REPORT_CODE).get(), 
					new Rb0602(REPORT_CODE).get(), 
					new Rb0603(REPORT_CODE).get(),
					new Rb0604(REPORT_CODE).get(), 
					new Rb0701(REPORT_CODE).get(), 
					new Rb0901(REPORT_CODE).get(), 
					new Rb1001(REPORT_CODE).get(),
					new Rb1002(REPORT_CODE).get(),
					new Rb1003(REPORT_CODE).get(),
					new Rb1004(REPORT_CODE).get(),
					new Rb1005(REPORT_CODE).get(),
					new Rb1201(REPORT_CODE).get(),
					new Rb1202(REPORT_CODE).get(),
					new Rb1203(REPORT_CODE).get(),
					new Rb1204(REPORT_CODE).get(),
					new Rb1205(REPORT_CODE).get(),
					new Rb1206(REPORT_CODE).get(),
					new Rb1207(REPORT_CODE).get(),
					new Rb1301(REPORT_CODE).get(),
					new Rb1302(REPORT_CODE).get(),
					new Rb9001(REPORT_CODE).get(),
					new Rb9002(REPORT_CODE).get(),
					new Rb9003(REPORT_CODE).get()
					);
}
