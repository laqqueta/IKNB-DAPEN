package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataReUus {
	private static final String REPORT_CODE = EReportRb.PMVU_REALISASI.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Re010402(REPORT_CODE).get(),
			new Re040102(REPORT_CODE).get(), 
			new Re040201(REPORT_CODE).get(), 
			new Re040301(REPORT_CODE).get(),
			new Re050101(REPORT_CODE).get(),
			new Re050201(REPORT_CODE).get(), 
			new Re060100(REPORT_CODE).get(), 
			new Re070102(REPORT_CODE).get(), 
			new Re070201(REPORT_CODE).get(), 
			new Re080000(REPORT_CODE).get(),
			new Re090202(REPORT_CODE).get(), 
			new Re090203(REPORT_CODE).get(), 
			new Re090204(REPORT_CODE).get(),
			new Re100100(REPORT_CODE).get(), 
			new Re100202(REPORT_CODE).get(), 
			new Re100302(REPORT_CODE).get(),
			new Re100402(REPORT_CODE).get(), 
			new Re100502(REPORT_CODE).get(), 
			new Re110100(REPORT_CODE).get(),
			new Re900001(REPORT_CODE).get(),
			new Re900002(REPORT_CODE).get()
	);
}
