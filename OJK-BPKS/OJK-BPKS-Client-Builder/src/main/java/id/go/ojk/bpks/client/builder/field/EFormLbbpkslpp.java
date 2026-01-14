package id.go.ojk.bpks.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormLbbpkslpp {
  PRUM ("PRUM", "Profil Umum Badan Penyelenggara Jaminan Sosial"),
  DWAS ("DWAS", "Profil Dewan Pengawas "),
  DIR ("DIR", "Profil Dewan Direksi "),
  ORG ("ORG", "Profil Struktur Organisasi "),
  KWKC ("KWKC", "Profil Kantor "),
  PDK ("PDK", "Profil Tingkat Pendidikan "),
  STR ("STR", "Profil Tenaga Ahli "),
  RKPS ("RKPS", "Rekapitulasi Kepesertaan "),
  RKPI ("RKPI", "Rekapitulasi Piutang Iuran "),
  RKLM ("RKLM", "Rekapitulasi Klaim "),
  RFASK ("RFASK", "Rekapitulasi Fasilitas Kesehatan  "),
  RKPNG ("RKPNG", "Rekapitulasi Penanganan Pengaduan "),
  RPKAP ("RPKAP", "Rekapitulasi Pembayaran Kapitasi "),
  SPD ("SPD", "Surat Pernyataan Direksi"),
  SP ("SP", "Surat Pengantar"),
  ;

  @Getter
  private String code;
  @Getter
  private String name;
}
