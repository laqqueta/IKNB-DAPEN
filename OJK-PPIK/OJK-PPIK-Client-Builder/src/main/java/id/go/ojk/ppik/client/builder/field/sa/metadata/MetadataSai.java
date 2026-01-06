package id.go.ojk.ppik.client.builder.field.sa.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSai {
	private static final String SPPIGI = EReportSa.PPIK_PENGKINIAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060100(SPPIGI).get(),
		new Sa060301(SPPIGI).get(),
		new Sa888888(SPPIGI).get(),
		new Sa999999(SPPIGI).get()
	);

}
