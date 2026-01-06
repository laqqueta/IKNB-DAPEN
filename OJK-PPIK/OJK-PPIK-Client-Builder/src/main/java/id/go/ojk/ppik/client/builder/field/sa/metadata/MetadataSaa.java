package id.go.ojk.ppik.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaa {
	private static final String SPPIGA = EReportSa.PPIK_PELAPORAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060100(SPPIGA).get(),
		new Sa060301(SPPIGA).get(),
		new Sa888888(SPPIGA).get(),
		new Sa999999(SPPIGA).get()
	);

}
