package id.go.ojk.bptk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbptkbdn {
  DTUM("DTUM", "Data Umum"),
  LPK("LPK", "Laporan Posisi Keuangan"),
  LKK("LKK", "Laporan Kinerja Keuangan"),
  LPE("LPE", "Laporan Perubahan Ekuitas"),
  LAK("LAK", "Laporan Arus Kas"),
  AI("AI", "Aset Investasi"),
  HAI("HAI", "Hasil Aset Investasi"),
  RAS("RAS", "Rasio Keuangan"),
  RASL("RASL", "Jatuh Tempo Aset dan Liabilitas"),
  INVDEP("INVDEP", "Rincian Jenis Investasi Deposito"),
  INVSB("INVSB", "Rincian Jenis Investasi Surat Berharga"),
  PROP("PROP", "Rincian Properti Investasi"),
  SBN("SBN", "Rincian Pemenuhan Ketentuan Investasi SBN"),
  INF("INF", "Informasi Penting Lain"),
  SP("SP", "Surat Pengantar/Pernyataan Direksi")
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
