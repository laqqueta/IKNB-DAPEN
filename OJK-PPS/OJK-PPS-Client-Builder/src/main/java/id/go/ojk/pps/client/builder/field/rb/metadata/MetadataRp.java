package id.go.ojk.pps.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRp {
	private static final String REPORT_CODE = EReportRb.PPS_PENGAWASAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = 
			Arrays.asList(
					new Rp010000(REPORT_CODE).get(),
					new Rp900001(REPORT_CODE).get()
					);
}
