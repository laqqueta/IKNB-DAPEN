package id.go.ojk.bpks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbpksdjs {
  LPK("LPK", "Laporan Posisi Keuangan"),
  LAV("LAV", "Laporan Aktivitas"),
  LAK("LAK", "Laporan Arus Kas"),
  LPAN("LPAN", "Laporan Perubahan Aset Neto"),
  AIN("AIN", "Aset Investasi"),
  HIN("HIN", "Hasil Aset Investasi"),
  RKU("RKU", "Rasio Keuangan"),
  ALM("ALM", "Jatuh Tempo Aset dan Liabilitas"),
  INV("INV", "Rincian Jenis Investasi"),
  RPI("RPI", "Rincian Piutang Iuran"),
  LAKD("LAKD", "Laporan Aset Kontijensi Atas Tunggakan Iuran Pemerintah Daerah"),
  LKPS("LKPS", "Laporan Kepesertaan"),
  SPD("SPD", "Surat Pernyataan Direksi"),
  SP("SP", "Surat Pengantar")
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
