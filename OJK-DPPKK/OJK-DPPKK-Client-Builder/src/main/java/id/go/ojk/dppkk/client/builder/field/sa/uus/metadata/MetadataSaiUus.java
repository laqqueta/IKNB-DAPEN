package id.go.ojk.dppkk.client.builder.field.sa.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaiUus {
	private static final String REPORT_CODE = EReportSa.DPPKU_PENGKINIAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Sa0301(REPORT_CODE).get(), 
			new Sa0302(REPORT_CODE).get(), 
			new Sa8888(REPORT_CODE).get(), 
			new Sa9999(REPORT_CODE).get())
			;
}
