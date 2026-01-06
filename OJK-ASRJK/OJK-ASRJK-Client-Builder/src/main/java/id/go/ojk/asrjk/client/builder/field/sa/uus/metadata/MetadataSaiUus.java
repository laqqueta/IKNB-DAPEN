package id.go.ojk.asrjk.client.builder.field.sa.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaiUus {
	private static final String REPORT_CODE = EReportSa.ASRJU_PENGKINIAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Sa0201(REPORT_CODE).get(),
			new Sa0202(REPORT_CODE).get(), 
			new Sa0203(REPORT_CODE).get(), 
			new Sa0204(REPORT_CODE).get(),
			new Sa0205(REPORT_CODE).get(), 
			new Sa0206(REPORT_CODE).get(), 
			new Sa0207(REPORT_CODE).get(),
			new Sa0208(REPORT_CODE).get(), 
			new Sa0209(REPORT_CODE).get(), 
			new Sa0210(REPORT_CODE).get(), 
			new Sa0211(REPORT_CODE).get(), 
			new Sa8888(REPORT_CODE).get(), 
			new Sa9999(REPORT_CODE).get())
			;
}
