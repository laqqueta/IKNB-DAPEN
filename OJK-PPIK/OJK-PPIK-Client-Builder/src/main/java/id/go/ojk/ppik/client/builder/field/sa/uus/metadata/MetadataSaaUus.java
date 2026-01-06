package id.go.ojk.ppik.client.builder.field.sa.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.sa.EReportSa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataSaaUus {
	private static final String SPPIUA = EReportSa.PPIU_PELAPORAN.getReportTypeCode();

	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
		new Sa060302(SPPIUA).get(),
		new Sa888888(SPPIUA).get(),
		new Sa999999(SPPIUA).get()
	);

}
