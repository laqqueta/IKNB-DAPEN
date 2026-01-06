package id.go.ojk.dppkk.client.builder.field.tl.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.tl.EReportTl;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataTl {
	private static final String REPORT_CODE = EReportTl.DPPKK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Tl0100(REPORT_CODE).get(),
			new Tl8888(REPORT_CODE).get(),
			new Tl9999(REPORT_CODE).get(),
			new Tl1111(REPORT_CODE).get()
			);
}
