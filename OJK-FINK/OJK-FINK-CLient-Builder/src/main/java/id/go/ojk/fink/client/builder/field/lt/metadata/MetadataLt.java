package id.go.ojk.fink.client.builder.field.lt.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lbk.EReportTypeCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLt {
	private static final String REPORT_CODE = EReportTypeCode.LT_FINK.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Lt0000(REPORT_CODE).get(),
			new Lt1100(REPORT_CODE).get(),
			new Lt1200(REPORT_CODE).get(),
			new Lt1201(REPORT_CODE).get(),
			new Lt1300(REPORT_CODE).get(),
			new Lt8800(REPORT_CODE).get(),
			new Lt2111(REPORT_CODE).get(),
			new Lt2112(REPORT_CODE).get(),
			new Lt2116(REPORT_CODE).get(),
			new Lt2113(REPORT_CODE).get(),
			new Lt2114(REPORT_CODE).get(),
			new Lt2117(REPORT_CODE).get(),
			new Lt2115(REPORT_CODE).get(),
			new Lt2118(REPORT_CODE).get(),
			new Lt2913(REPORT_CODE).get(),
			new Lt2119(REPORT_CODE).get(),
			new Lt2310(REPORT_CODE).get()
			);
}
