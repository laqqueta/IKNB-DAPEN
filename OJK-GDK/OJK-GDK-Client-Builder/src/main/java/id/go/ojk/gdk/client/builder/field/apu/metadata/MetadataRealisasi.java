package id.go.ojk.gdk.client.builder.field.apu.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.apu.EReportApu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRealisasi {
	private static final String REPORT_CODE = EReportApu.GDK_REALISASI_RUTIN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Papu00(REPORT_CODE).get(), 
			new Papu88(REPORT_CODE).get(), 
			new Papu99(REPORT_CODE).get())
			;
}
