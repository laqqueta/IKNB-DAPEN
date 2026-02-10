package id.go.ojk.bpks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbpkslk {
  LPK("LPK", "Laporan Posisi Keuangan"),
  LKK("LKK", "Laporan Kinerja Keuangan Konsolidasi"),
  LPE("LPE", "Laporan Perubahan Ekuitas Badan"),
  LAK("LAK", "Laporan Arus Kas"),
  AI("AI", "Laporan Aset Investasi"),
  HIN("HIN", "Hasil Aset Investasi"),
  ALM("ALM", "Rekapitulasi Aset dan Liabilitas"),
  RKE("RKE", "Rasio Keuangan"),
  IPL("IPL", "Informasi Penting Lainnya"),
  INV("INV", "Rincian Jenis Investasi"),
  RPRI("RPRI", "Rincian Properti Investasi"),
  SBN("SBN", "Rincian Pemenuhan Ketentuan Investasi SBN Badan"),
  SPD("SPD", "Surat Pernyataan Direksi"),
  SP("SP", "Surat Pengantar")
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
