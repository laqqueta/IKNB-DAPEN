package id.go.ojk.bptk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbptkjp {
  DTUM("DTUM", "Data Umum"),
  LAN("LAN", "Laporan Aset Neto"),
  LPAN("LPAN", "Laporan Perubahan Aset Neto"),
  AI("AI", "Aset Investasi"),
  HAI("HAI", "Hasil Aset Investasi"),
  RAS("RAS", "Rasio Keuangan"),
  RASL("RASL", "Jatuh Tempo Aset dan Liabilitas"),
  INVDEP("INVDEP", "Rincian Jenis Investasi Deposito"),
  INVSB("INVSB", "Rincian Jenis Investasi Surat Berharga"),
  PROP("PROP", "Rincian Properti Investasi"),
  PIUT("PIUT", "Piutang Iuran"),
  NKA("NKA", "Nilai Kini Aktuarial dari Manfaat Jaminan Pensiun Terjanjikan"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
