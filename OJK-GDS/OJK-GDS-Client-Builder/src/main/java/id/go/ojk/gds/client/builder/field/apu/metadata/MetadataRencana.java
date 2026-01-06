package id.go.ojk.gds.client.builder.field.apu.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.apu.EReportApu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRencana {
	private static final String REPORT_CODE = EReportApu.GDS_RENCANA_RUTIN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Kapu00(REPORT_CODE).get(), 
			new Kapu88(REPORT_CODE).get(), 
			new Kapu99(REPORT_CODE).get())
			;
}
