package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLabptkjkk implements IForm {
  DTUM ("DTUM", "Data Umum Program JKK"),
  RAS ("RAS", "Rasio Keuangan Program JKK"),
  LAMP ("LAMP", "Lampiran Laporan Aktuaris Tahunan Program JKK"),
  SP ("SP", "Surat Pengantar/Pernyataan Direksi Program JKK"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LABPTKJKK_RUTIN.getReportTypeCode();
  }  
}
