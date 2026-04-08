package id.go.ojk.bpks.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1133GolonganPihakLawan;
import id.go.ojk.conf.client.field.reference.ER1191SandiBank;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1207JenisKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1208PeringkatSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1209JenisProperti;
import id.go.ojk.conf.client.field.reference.ER1210BuktiPemilikanTanahBangunan;
import id.go.ojk.conf.client.field.reference.ER1211JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1212KategoriSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1213TujuanKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1214KualitasAsetProduktif;
import id.go.ojk.conf.client.field.reference.ER1215HirarkiHargaPasar;
import id.go.ojk.conf.client.field.reference.ER1216StatusPemilikanTanahBangunan;
import id.go.ojk.conf.client.field.reference.ER1218PenurunanNilai;
import id.go.ojk.conf.client.field.reference.ER1219JenisPiutangIuran;
import id.go.ojk.conf.client.field.reference.ER1220CounterParty;
import id.go.ojk.conf.client.field.reference.ER1221SegmenKualitas;
import id.go.ojk.conf.client.field.reference.ER1222SegmenPeserta;
import id.go.ojk.conf.client.field.reference.ER1223StatusKepemilikanGedungUnitUsaha;
import id.go.ojk.conf.client.field.reference.ER1224LevelStrukturOrganisasi;
import id.go.ojk.conf.client.field.reference.ER1225JenisKantor;
import id.go.ojk.conf.client.field.reference.ER1226TingkatPendidikan;
import id.go.ojk.conf.client.field.reference.ER1227BidangKeahlian;
import id.go.ojk.conf.client.field.reference.ER1228KualifikasiTenagaAhli;
import id.go.ojk.conf.client.field.reference.ER1229Kewarganegaraan;
import id.go.ojk.conf.client.field.reference.ER1230StatusTanggungan;
import id.go.ojk.conf.client.field.reference.ER1231KelasPesertaProgramJaminan;
import id.go.ojk.conf.client.field.reference.ER1232JenisFasilitasKesehatan;
import id.go.ojk.conf.client.field.reference.ER1233JenisKlaim;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
  JENIS_KEPEMILIKAN (ER1207JenisKepemilikan.getRefNumber(), ER1207JenisKepemilikan.getName(), ER1207JenisKepemilikan.getObjects()),
  PERINGKAT_SURAT_BERHARGA (ER1208PeringkatSuratBerharga.getRefNumber(), ER1208PeringkatSuratBerharga.getName(), ER1208PeringkatSuratBerharga.getObjects()),
  JENIS_PROPERTI (ER1209JenisProperti.getRefNumber(), ER1209JenisProperti.getName(), ER1209JenisProperti.getObjects()),
  BUKTI_PEMILIKAN_TANAH_BANGUNAN (ER1210BuktiPemilikanTanahBangunan.getRefNumber(), ER1210BuktiPemilikanTanahBangunan.getName(), ER1210BuktiPemilikanTanahBangunan.getObjects()),
  JENIS_SURAT_BERHARGA (ER1211JenisSuratBerharga.getRefNumber(), ER1211JenisSuratBerharga.getName(), ER1211JenisSuratBerharga.getObjects()),
  KATEGORI_SURAT_BERHARGA (ER1212KategoriSuratBerharga.getRefNumber(), ER1212KategoriSuratBerharga.getName(), ER1212KategoriSuratBerharga.getObjects()),
  TUJUAN_KEPEMILIKAN (ER1213TujuanKepemilikan.getRefNumber(), ER1213TujuanKepemilikan.getName(), ER1213TujuanKepemilikan.getObjects()),
  KUALITAS_ASET_PRODUKTIF (ER1214KualitasAsetProduktif.getRefNumber(), ER1214KualitasAsetProduktif.getName(), ER1214KualitasAsetProduktif.getObjects()),
  HIRARKI_HARGA_PASAR (ER1215HirarkiHargaPasar.getRefNumber(), ER1215HirarkiHargaPasar.getName(), ER1215HirarkiHargaPasar.getObjects()),
  STATUS_PEMILIKAN_TANAH_BANGUNAN (ER1216StatusPemilikanTanahBangunan.getRefNumber(), ER1216StatusPemilikanTanahBangunan.getName(), ER1216StatusPemilikanTanahBangunan.getObjects()),
  SANDI_BANK (ER1191SandiBank.getRefNumber(), ER1191SandiBank.getName(), ER1191SandiBank.getObjects()),
  PENURUNAN_NILAI (ER1218PenurunanNilai.getRefNumber(), ER1218PenurunanNilai.getName(), ER1218PenurunanNilai.getObjects()),
  GOLONGAN_PIHAK_LAWAN (ER1133GolonganPihakLawan.getRefNumber(), ER1133GolonganPihakLawan.getName(), ER1133GolonganPihakLawan.getObjects()),
  SEKTOR_EKONOMI (ER1124SektorEkonomi.getRefNumber(), ER1124SektorEkonomi.getName(), ER1124SektorEkonomi.getObjects()),
  LOKASI_DATI_2 (ER1135LokasiDati2.getRefNumber(), "Lokasi Dati II", ER1135LokasiDati2.getObjects()),
  JENIS_PIUTANG_IURAN (ER1219JenisPiutangIuran.getRefNumber(), ER1219JenisPiutangIuran.getName(), ER1219JenisPiutangIuran.getObjects()),
  COUNTER_PARTY (ER1220CounterParty.getRefNumber(), ER1220CounterParty.getName(), ER1220CounterParty.getObjects()),
  SEGMEN_KUALITAS (ER1221SegmenKualitas.getRefNumber(), ER1221SegmenKualitas.getName(), ER1221SegmenKualitas.getObjects()),
  SEGMEN_PESERTA (ER1222SegmenPeserta.getRefNumber(), ER1222SegmenPeserta.getName(), ER1222SegmenPeserta.getObjects()),
  STATUS_KEPEMILIKAN_GEDUNG_UNIT_USAHA (ER1223StatusKepemilikanGedungUnitUsaha.getRefNumber(), ER1223StatusKepemilikanGedungUnitUsaha.getName(), ER1223StatusKepemilikanGedungUnitUsaha.getObjects()),
  LEVEL_STRUKTUR (ER1224LevelStrukturOrganisasi.getRefNumber(), ER1224LevelStrukturOrganisasi.getName(), ER1224LevelStrukturOrganisasi.getObjects()),
  JENIS_KANTOR (ER1225JenisKantor.getRefNumber(), ER1225JenisKantor.getName(), ER1225JenisKantor.getObjects()),
  TINGKAT_PENDIDIKAN (ER1226TingkatPendidikan.getRefNumber(), ER1226TingkatPendidikan.getName(), ER1226TingkatPendidikan.getObjects()),
  BIDANG_KEAHLIAN (ER1227BidangKeahlian.getRefNumber(), ER1227BidangKeahlian.getName(), ER1227BidangKeahlian.getObjects()),
  KUALIFIKASI_TENAGA_AHLI (ER1228KualifikasiTenagaAhli.getRefNumber(), ER1228KualifikasiTenagaAhli.getName(), ER1228KualifikasiTenagaAhli.getObjects()),
  KEWARGANEGARAAN (ER1229Kewarganegaraan.getRefNumber(), ER1229Kewarganegaraan.getName(), ER1229Kewarganegaraan.getObjects()),
  STATUS_TANGGUNGAN (ER1230StatusTanggungan.getRefNumber(), ER1230StatusTanggungan.getName(), ER1230StatusTanggungan.getObjects()),
  KELAS_PESERTA_PROGRAM_JAMINAN (ER1231KelasPesertaProgramJaminan.getRefNumber(), "Kelas Peserta Program Jaminan Kesehatan", ER1231KelasPesertaProgramJaminan.getObjects()),
  JENIS_FASILITAS_KESEHATAN (ER1232JenisFasilitasKesehatan.getRefNumber(), ER1232JenisFasilitasKesehatan.getName(), ER1232JenisFasilitasKesehatan.getObjects()),
  JENIS_KLAIM (ER1233JenisKlaim.getRefNumber(), ER1233JenisKlaim.getName(), ER1233JenisKlaim.getObjects()),
  ;

  public static final String DESC_REGEX = "([a-z])([A-Z])|([a-zA-Z])([0-9])|([0-9])([a-zA-Z])";
  public static final String DESC_REPLACEMENT = "$1$3$5 $2$4$6";

  @Getter
  private int number;
  private String name;
  private List<KeyValueString> references;

  public String getFileName() {
    StringBuilder res = new StringBuilder("R");
    res.append(number);
    res.append(name);
    res.append(".xml");
    return res.toString();
  }

  public String getDescription() {
    return name.replaceAll(DESC_REGEX, DESC_REPLACEMENT);
  }

  @Override
  public ReferenceMetadata getObject() {
    ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
    res.setPerSegment(false);
    res.setLabel1Map(null);
    return res;
  }

  public static List<ReferenceMetadata> getObjects() {
    List<ReferenceMetadata> res = new ArrayList<>();
    for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
      res.add(eEnum.getObject());
    }
    return res;
  }

  public static Map<String, List<KeyValueString>> getMap() {
    Map<String, List<KeyValueString>> res = new HashMap<>();
    for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
      res.put(eEnum.getFileName(), eEnum.references);
    }
    return res;
  }
}
