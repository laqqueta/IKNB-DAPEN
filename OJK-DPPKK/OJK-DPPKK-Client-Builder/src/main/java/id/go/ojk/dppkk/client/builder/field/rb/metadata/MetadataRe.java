package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRe {
	private static final String REPORT_CODE = EReportRb.DPPKK_REALISASI.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Re0100(REPORT_CODE).get(),
					new Re0200(REPORT_CODE).get(),
					new Re0300(REPORT_CODE).get(),
					new Re0400(REPORT_CODE).get(),
					new Re0500(REPORT_CODE).get(),
					new Re9001(REPORT_CODE).get(),
					new Re9002(REPORT_CODE).get()
					);
}
