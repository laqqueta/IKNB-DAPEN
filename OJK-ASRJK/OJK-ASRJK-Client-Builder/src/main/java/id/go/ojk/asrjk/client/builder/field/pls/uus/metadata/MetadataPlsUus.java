package id.go.ojk.asrjk.client.builder.field.pls.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.pls.EReportPls;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPlsUus {
	private static final String REPORT_CODE = EReportPls.ASRJU_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(new Pls0100(REPORT_CODE).get(),
			new Pls0200(REPORT_CODE).get(), new Pls9001(REPORT_CODE).get());
}
