package id.go.ojk.ppik.client.builder.field.sa.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaiUus {
	private static final String SPPIUI = EReportSa.PPIU_PENGKINIAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060302(SPPIUI).get(),
		new Sa888888(SPPIUI).get(),
		new Sa999999(SPPIUI).get()
	);

}
