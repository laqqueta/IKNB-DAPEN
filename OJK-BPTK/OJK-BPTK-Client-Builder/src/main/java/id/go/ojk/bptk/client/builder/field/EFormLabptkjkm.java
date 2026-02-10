package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLabptkjkm implements IForm {
  DTUM ("DTUM", "Data Umum Program JKM"),
  RAS ("RAS", "Rasio Keuangan Program JKM"),
  LAMP ("LAMP", "Lampiran Laporan Aktuaris Tahunan Program JKM"),
  SP ("SP", "Surat Pengantar/Pernyataan Direksi Program JKM"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LABPTKJK_RUTIN.getReportTypeCode();
  }  
}
