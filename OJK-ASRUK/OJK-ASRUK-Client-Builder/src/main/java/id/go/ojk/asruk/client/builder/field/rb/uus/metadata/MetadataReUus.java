package id.go.ojk.asruk.client.builder.field.rb.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataReUus {
	private static final String REPORT_CODE = EReportRb.ASRUU_REALISASI.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Re0101(REPORT_CODE).get(),
					new Re0102(REPORT_CODE).get(), 
					new Re0103(REPORT_CODE).get(), 
					new Re0201(REPORT_CODE).get(),
					new Re0202(REPORT_CODE).get(),
					new Re0203(REPORT_CODE).get(),
					new Re0301(REPORT_CODE).get(),
					new Re0302(REPORT_CODE).get(),
					new Re0303(REPORT_CODE).get(),
					new Re0401(REPORT_CODE).get(),
					new Re0402(REPORT_CODE).get(),
					new Re0403(REPORT_CODE).get(),
					new Re9001(REPORT_CODE).get(),
					new Re9002(REPORT_CODE).get()
					);
}
