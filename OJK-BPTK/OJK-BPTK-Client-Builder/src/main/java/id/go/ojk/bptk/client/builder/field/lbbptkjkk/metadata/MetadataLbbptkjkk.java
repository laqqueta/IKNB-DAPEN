package id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbDtum;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbInf;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbInvdep;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbInvsb;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbProp;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbSbn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata.LbSp;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLbbptkjkk {
  public static final String REPORT_CODE = EReportBpjs.LBBPTKJKK_RUTIN.getReportTypeCode();
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LbDtum(REPORT_CODE).get(),
      new LbLpk(REPORT_CODE).get(),
      new LbLpkomp(REPORT_CODE).get(),
      new LbLpan(REPORT_CODE).get(),
      new LbLak(REPORT_CODE).get(),
      new LbAi(REPORT_CODE).get(),
      new LbHai(REPORT_CODE).get(),
      new LbRas(REPORT_CODE).get(),
      new LbRasl(REPORT_CODE).get(),
      new LbInvdep(REPORT_CODE).get(),
      new LbInvsb(REPORT_CODE).get(),
      new LbProp(REPORT_CODE).get(),
      new LbSbn(REPORT_CODE).get(),
      new LbPiut(REPORT_CODE).get(),
      new LbInf(REPORT_CODE).get(),
      new LbSp(REPORT_CODE).get()
  );
}
