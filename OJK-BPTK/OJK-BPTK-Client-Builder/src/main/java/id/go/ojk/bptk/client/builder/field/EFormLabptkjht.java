package id.go.ojk.bptk.client.builder.field;

import id.go.ojk.client.module.bpjs.EReportBpjs;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLabptkjht implements IForm {
  DTUM ("DTUM", "Data Umum Program JHT"),
  RAS ("RAS", "Rasio Keuangan Program JHT"),
  LAMP ("LAMP", "Lampiran Laporan Aktuaris Tahunan Program JHT"),
  SP ("SP", "Surat Pengantar/Pernyataan Direksi Program JHT"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;

  @Override
  public String getReportCode() {
    return EReportBpjs.LABPTKJHT_RUTIN.getReportTypeCode();
  }  
}
