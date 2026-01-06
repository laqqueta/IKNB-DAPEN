package id.go.ojk.ppk.client.builder.field.sa.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaaUus {
	private static final String REPORT_CODE = EReportSa.PPU_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Sa060302(REPORT_CODE).get(), 
			new Sa888888(REPORT_CODE).get(), 
			new Sa999999(REPORT_CODE).get())
			;
}
