package id.go.ojk.asrjk.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaa {
	private static final String REPORT_CODE = EReportSa.ASRJK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Sa0100(REPORT_CODE).get(), 
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
			new Sa0300(REPORT_CODE).get(), 
			new Sa0400(REPORT_CODE).get(),
			new Sa0501(REPORT_CODE).get(), 
			new Sa0502(REPORT_CODE).get(), 
			new Sa0503(REPORT_CODE).get(),
			new Sa8888(REPORT_CODE).get(), 
			new Sa9999(REPORT_CODE).get())
			;
}
