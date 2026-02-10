package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLabptkjp implements IForm {
  DTUM ("DTUM", "Data Umum Program JP"),
  RAS ("RAS", "Rasio Keuangan Program JP"),
  LAMP ("LAMP", "Lampiran Laporan Aktuaris Tahunan Program JP"),
  SP ("SP", "Surat Pengantar/Pernyataan Direksi Program JP"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LABPTKJP_RUTIN.getReportTypeCode();
  }  
}
