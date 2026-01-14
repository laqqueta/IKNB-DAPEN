package id.go.ojk.bptk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbptkjht {
  DTUM("DTUM", "Data Umum"),
  LAN("LAN", "Laporan Aset Neto"),
  LPAN("LPAN", "Laporan Perubahan Aset Neto"),
  AI("AI", "Aset Investasi"),
  HAI("HAI", "Hasil Aset Investasi"),
  RAS("RAS", "Rasio Keuangan"),
  RASL("RASL", "Jatuh Tempo Aset dan Liabilitas"),
  INVDEP("INVDEP", "Rincian Jenis Investasi Deposito"),
  INVSB("INVSB", "Rincian Jenis Investasi Surat Berharga"),
  PIUT("PIUT", "Piutang Iuran"),
  ANT("ANT", "Aset Neto Tersedia JHT"),
  INF("INF", "Informasi Penting Lain"),
  SP("SP", "Surat Pengantar/Pernyataan Direksi"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
