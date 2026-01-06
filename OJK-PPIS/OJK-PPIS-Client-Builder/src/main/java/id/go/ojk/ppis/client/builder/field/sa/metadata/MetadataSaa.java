package id.go.ojk.ppis.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaa {
	private static final String SPPISA = EReportSa.PPIS_PELAPORAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060100(SPPISA).get(),
		new Sa060301(SPPISA).get(),
		new Sa888888(SPPISA).get(),
		new Sa999999(SPPISA).get()
	);

}
