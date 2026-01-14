package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata.LbInv;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbbpksdjs {
  public static final String REPORT_CODE = EReportBpjs.LBBPKSDJS_RUTIN.getReportTypeCode();

  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LbLpk(REPORT_CODE).get(),
      new LbLav(REPORT_CODE).get(),
      new LbLak(REPORT_CODE).get(),
      new LbLpan(REPORT_CODE).get(),
      new LbAin(REPORT_CODE).get(),
      new LbHin(REPORT_CODE).get(),
      new LbRku(REPORT_CODE).get(),
      new LbAlm(REPORT_CODE).get(),
      new LbInv(REPORT_CODE).get(),
      new LbRpi(REPORT_CODE).get(),
      new LbLakd(REPORT_CODE).get(),
      new LbLkps(REPORT_CODE).get(),
      new LbSpd(REPORT_CODE).get(),
      new LbSp(REPORT_CODE).get()
  );
}
