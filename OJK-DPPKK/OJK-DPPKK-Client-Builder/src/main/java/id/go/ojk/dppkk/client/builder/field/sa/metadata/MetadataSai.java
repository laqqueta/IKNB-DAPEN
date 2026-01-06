package id.go.ojk.dppkk.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSai {
	private static final String REPORT_CODE = EReportSa.DPPKK_PENGKINIAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Sa0100(REPORT_CODE).get(), 
			new Sa0200(REPORT_CODE).get(),
			new Sa0301(REPORT_CODE).get(), 
			new Sa0302(REPORT_CODE).get(), 
			new Sa0303(REPORT_CODE).get(), 
			new Sa0400(REPORT_CODE).get(),
			new Sa0500(REPORT_CODE).get(),
			new Sa8888(REPORT_CODE).get(), 
			new Sa9999(REPORT_CODE).get())
			;
}
