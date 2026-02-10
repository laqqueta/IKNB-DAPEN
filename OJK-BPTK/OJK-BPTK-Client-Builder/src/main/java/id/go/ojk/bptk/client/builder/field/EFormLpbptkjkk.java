package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLpbptkjkk implements IForm {
  RKPST("RKPST", "Rekapitulasi Kepesertaan Program JKK"),
  RPIU("RPIU", "Rekapitulasi Upah dan Iuran Program JKK"),
  RPMF("RPMF", "Rekapitulasi Manfaat Program JKK"),
  RKPIU("RKPIU", "Agregat Kepesertaan dan Iuran Program JKK"),
  RKPMF("RKPMF", "Agregat Kepesertaan dan Manfaat Program JKK"),
  INF("INF", "Informasi Pendukung Lain"),
  SP("SP", "Surat Pengantar dan Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LPBPTKJKK_RUTIN.getReportTypeCode();
  }  
}
