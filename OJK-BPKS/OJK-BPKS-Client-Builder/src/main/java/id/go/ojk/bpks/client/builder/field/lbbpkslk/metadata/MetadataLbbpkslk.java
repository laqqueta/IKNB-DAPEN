package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbbpkslk {
  private static final String REPORT_CODE = EReportBpjs.LBBPKSLK_RUTIN.getReportTypeCode();

  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LbLpk(REPORT_CODE).get(),
      new LbLkk(REPORT_CODE).get(),
      new LbLpe(REPORT_CODE).get(),
      new LbLak(REPORT_CODE).get(),
      new LbAi(REPORT_CODE).get(),
      new LbHin(REPORT_CODE).get(),
      new LbAlm(REPORT_CODE).get(),
      new LbRke(REPORT_CODE).get(),
      new LbIpl(REPORT_CODE).get(),
      new LbInv(REPORT_CODE).get(),
      new LbRpri(REPORT_CODE).get(),
      new LbSbn(REPORT_CODE).get(),
      new LbSpd(REPORT_CODE).get(),
      new LbSp(REPORT_CODE).get()
  );
}
