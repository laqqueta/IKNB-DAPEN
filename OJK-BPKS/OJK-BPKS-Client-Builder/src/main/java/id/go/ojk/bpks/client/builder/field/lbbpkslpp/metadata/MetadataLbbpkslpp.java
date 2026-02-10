package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbbpkslpp {
  private static final String REPORT_CODE = EReportBpjs.LBBPKSLPP_RUTIN.getReportTypeCode();

  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LbPrum(REPORT_CODE).get(),
      new LbDwas(REPORT_CODE).get(),
      new LbDir(REPORT_CODE).get(),
      new LbOrg(REPORT_CODE).get(),
      new LbKwkc(REPORT_CODE).get(),
      new LbPdk(REPORT_CODE).get(),
      new LbStr(REPORT_CODE).get(),
      new LbRkps(REPORT_CODE).get(),
      new LbRkpi(REPORT_CODE).get(),
      new LbRklm(REPORT_CODE).get(),
      new LbRfask(REPORT_CODE).get(),
      new LbRkpng(REPORT_CODE).get(),
      new LbRpkap(REPORT_CODE).get(),
      new LbSpd(REPORT_CODE).get(),
      new LbSp(REPORT_CODE).get()
  );
}
