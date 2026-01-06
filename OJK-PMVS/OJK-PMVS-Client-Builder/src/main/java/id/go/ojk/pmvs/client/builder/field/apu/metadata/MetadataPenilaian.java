package id.go.ojk.pmvs.client.builder.field.apu.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.apu.EReportApu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPenilaian {
	private static final String REPORT_CODE = EReportApu.PMVS_PENILAIAN_RUTIN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Tapu01(REPORT_CODE).get(), 
			new Tapu02(REPORT_CODE).get(),
			new Tapu03(REPORT_CODE).get())
			;
}
