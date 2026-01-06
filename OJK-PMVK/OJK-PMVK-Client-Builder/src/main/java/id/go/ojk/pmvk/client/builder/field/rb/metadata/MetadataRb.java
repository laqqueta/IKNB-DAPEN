package id.go.ojk.pmvk.client.builder.field.rb.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.rb.EReportRb;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataRb {
	private static final String REPORT_CODE = EReportRb.PMVK_PELAPORAN.getReportTypeCode();
	@Getter
	private static final List<SubmissionFormat> metadata = Arrays.asList(
			new Rb010401(REPORT_CODE).get(),
			new Rb040101(REPORT_CODE).get(),
			new Rb040201(REPORT_CODE).get(),
			new Rb040301(REPORT_CODE).get(),
			new Rb050101(REPORT_CODE).get(),
			new Rb050201(REPORT_CODE).get(),
			new Rb060100(REPORT_CODE).get(),
			new Rb070101(REPORT_CODE).get(),
			new Rb070201(REPORT_CODE).get(),
			new Rb080000(REPORT_CODE).get(),
			new Rb090202(REPORT_CODE).get(),
			new Rb090203(REPORT_CODE).get(),
			new Rb090204(REPORT_CODE).get(),
			new Rb100100(REPORT_CODE).get(),
			new Rb100201(REPORT_CODE).get(),
			new Rb100301(REPORT_CODE).get(),
			new Rb100401(REPORT_CODE).get(),
			new Rb100501(REPORT_CODE).get(),
			new Rb110100(REPORT_CODE).get(),
			new Rb900001(REPORT_CODE).get(),
			new Rb900002(REPORT_CODE).get(),
			new Rb900003(REPORT_CODE).get()
	);
}
