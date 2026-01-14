package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLpbptkjkp implements IForm {
  RKPST("RKPST", "Rekapitulasi Kepesertaan Program JKP"),
  RPIU("RPIU", "Rekapitulasi Upah dan Iuran Program JKP"),
  RPMF("RPMF", "Rekapitulasi Manfaat Program JKP"),
  RKPIU("RKPIU", "Agregat Kepesertaan dan Iuran Program JKP"),
  RKPMF("RKPMF", "Agregat Kepesertaan dan Manfaat Program JKP"),
  INF("INF", "Informasi Pendukung Lain"),
  SP("SP", "Surat Pengantar dan Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LPBPTKJKP_RUTIN.getReportTypeCode();
  }  
}
