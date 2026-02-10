package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLpbptkjht implements IForm {
  RKPST("RKPST", "Rekapitulasi Kepesertaan Program JHT"),
  RPIU("RPIU", "Rekapitulasi Upah dan Iuran Program JHT"),
  RDJHT("RDJHT", "Rekapitulasi Dana Program JHT"),
  RPMF("RPMF", "Rekapitulasi Manfaat Program JHT"),
  RKPIU("RKPIU", "Agregat Kepesertaan dan Iuran Program JHT"),
  RKPMF("RKPMF", "Agregat Kepesertaan dan Manfaat Program JHT"),
  INF("INF", "Informasi Pendukung Lain"),
  SP("SP", "Surat Pengantar dan Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LPBPTKJHT_RUTIN.getReportTypeCode();
  }  
}
