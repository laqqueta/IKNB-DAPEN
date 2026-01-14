package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLpbptkjk implements IForm {
  RKPST("RKPST", "Rekapitulasi Kepesertaan Program JKM"),
  RPIU("RPIU", "Rekapitulasi Upah dan Iuran Program JKM"),
  RPMF("RPMF", "Rekapitulasi Manfaat Program JKM"),
  RKPIU("RKPIU", "Agregat Kepesertaan dan Iuran Program JKM"),
  RKPMF("RKPMF", "Agregat Kepesertaan dan Manfaat Program JKM"),
  INF("INF", "Informasi Pendukung Lain"),
  SP("SP", "Surat Pengantar dan Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LPBPTKJK_RUTIN.getReportTypeCode();
  }  
}
