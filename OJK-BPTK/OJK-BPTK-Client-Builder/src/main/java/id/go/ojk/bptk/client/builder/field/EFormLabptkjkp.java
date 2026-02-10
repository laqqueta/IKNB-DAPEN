package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLabptkjkp implements IForm {
  DTUM ("DTUM", "Data Umum Program JKP"),
  RAS ("RAS", "Rasio Keuangan Program JKP"),
  LAMP ("LAMP", "Lampiran Laporan Aktuaris Tahunan Program JKP"),
  SP ("SP", "Surat Pengantar/Pernyataan Direksi Program JKP"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LABPTKJKP_RUTIN.getReportTypeCode();
  }  
}
