package id.go.ojk.ppis.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSai {
	private static final String SPPISI = EReportSa.PPIS_PENGKINIAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060100(SPPISI).get(),
		new Sa060301(SPPISI).get(),
		new Sa888888(SPPISI).get(),
		new Sa999999(SPPISI).get()
	);

}
