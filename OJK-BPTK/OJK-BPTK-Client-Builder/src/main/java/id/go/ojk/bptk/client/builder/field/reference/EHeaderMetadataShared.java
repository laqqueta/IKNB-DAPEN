package id.go.ojk.bptk.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1127LembagaPemeringkat;
import id.go.ojk.conf.client.field.reference.ER1133GolonganPihakLawan;
import id.go.ojk.conf.client.field.reference.ER1157LokasiDati1;
import id.go.ojk.conf.client.field.reference.ER1191SandiBank;
import id.go.ojk.conf.client.field.reference.ER1192SandiCounterParty;
import id.go.ojk.conf.client.field.reference.ER1194SandiCounterparty;
import id.go.ojk.conf.client.field.reference.ER1206LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1207JenisKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1212KategoriSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1214KualitasAsetProduktif;
import id.go.ojk.conf.client.field.reference.ER1219JenisPiutangIuran;
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
import id.go.ojk.conf.client.field.reference.ER1234JenisProgram;
import id.go.ojk.conf.client.field.reference.ER1235JenisDeposito;
import id.go.ojk.conf.client.field.reference.ER1236SyariahKonvensional;
import id.go.ojk.conf.client.field.reference.ER1237KeteranganARO;
import id.go.ojk.conf.client.field.reference.ER1238JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1240PeringkatSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1241TujuanKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1242HirarkiHargaPasar;
import id.go.ojk.conf.client.field.reference.ER1243JenisProperti;
import id.go.ojk.conf.client.field.reference.ER1244BuktiPemilikanTanahBangunan;
import id.go.ojk.conf.client.field.reference.ER1245StatusPemilikanTanahBangunan;
import id.go.ojk.conf.client.field.reference.ER1246PenurunanNilai;
import id.go.ojk.conf.client.field.reference.ER1247SegmenPeserta;
import id.go.ojk.conf.client.field.reference.ER1248SegmenKualitas;
import id.go.ojk.conf.client.field.reference.ER1249SegmenPeserta;
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
  PERINGKAT_SURAT_BERHARGA (ER1240PeringkatSuratBerharga.getRefNumber(), ER1240PeringkatSuratBerharga.getName(), ER1240PeringkatSuratBerharga.getObjects()),
  JENIS_PROPERTI (ER1243JenisProperti.getRefNumber(), ER1243JenisProperti.getName(), ER1243JenisProperti.getObjects()),
  BUKTI_PEMILIKAN_TANAH_BANGUNAN (ER1244BuktiPemilikanTanahBangunan.getRefNumber(), "Bukti Pemilikan", ER1244BuktiPemilikanTanahBangunan.getObjects()),
  JENIS_SURAT_BERHARGA (ER1238JenisSuratBerharga.getRefNumber(), ER1238JenisSuratBerharga.getName(), ER1238JenisSuratBerharga.getObjects()),
  KATEGORI_SURAT_BERHARGA (ER1212KategoriSuratBerharga.getRefNumber(), ER1212KategoriSuratBerharga.getName(), ER1212KategoriSuratBerharga.getObjects()),
  TUJUAN_KEPEMILIKAN (ER1241TujuanKepemilikan.getRefNumber(), "Tujuan Pemilikan", ER1241TujuanKepemilikan.getObjects()),
  KUALITAS_ASET_PRODUKTIF (ER1214KualitasAsetProduktif.getRefNumber(), ER1214KualitasAsetProduktif.getName(), ER1214KualitasAsetProduktif.getObjects()),
  HIRARKI_HARGA_PASAR (ER1242HirarkiHargaPasar.getRefNumber(), "Hierarki Harga Pasar", ER1242HirarkiHargaPasar.getObjects()),
  STATUS_PEMILIKAN_TANAH_BANGUNAN (ER1245StatusPemilikanTanahBangunan.getRefNumber(), "Status Pemilikan Tanah & Bangunan", ER1245StatusPemilikanTanahBangunan.getObjects()),
  SANDI_BANK (ER1191SandiBank.getRefNumber(), ER1191SandiBank.getName(), ER1191SandiBank.getObjects()),
  PENURUNAN_NILAI (ER1246PenurunanNilai.getRefNumber(), ER1246PenurunanNilai.getName(), ER1246PenurunanNilai.getObjects()),
  GOLONGAN_PIHAK_LAWAN (ER1133GolonganPihakLawan.getRefNumber(), ER1133GolonganPihakLawan.getName(), ER1133GolonganPihakLawan.getObjects()),
  SEKTOR_EKONOMI (ER1124SektorEkonomi.getRefNumber(), ER1124SektorEkonomi.getName(), ER1124SektorEkonomi.getObjects()),
  LOKASI_DATI_1 (ER1157LokasiDati1.getRefNumber(), "Lokasi DATI I", ER1157LokasiDati1.getObjects()),
  LOKASI_DATI_2 (ER1206LokasiDati2.getRefNumber(), "Lokasi DATI II", ER1206LokasiDati2.getObjects()),
  JENIS_PIUTANG_IURAN (ER1219JenisPiutangIuran.getRefNumber(), ER1219JenisPiutangIuran.getName(), ER1219JenisPiutangIuran.getObjects()),
  COUNTER_PARTY (ER1194SandiCounterparty.getRefNumber(), ER1194SandiCounterparty.getName(), ER1194SandiCounterparty.getObjects()),
  COUNTER_PARTY_MAPPING (ER1192SandiCounterParty.getRefNumber(), ER1192SandiCounterParty.getName(), ER1192SandiCounterParty.getObjects()),
  SEGMEN_KUALITAS (ER1248SegmenKualitas.getRefNumber(), ER1248SegmenKualitas.getName(), ER1248SegmenKualitas.getObjects()),
  SEGMEN_PESERTA (ER1247SegmenPeserta.getRefNumber(), ER1247SegmenPeserta.getName(), ER1247SegmenPeserta.getObjects()),
  SEGMEN_PESERTA_LPP (ER1249SegmenPeserta.getRefNumber(), ER1249SegmenPeserta.getName(), ER1249SegmenPeserta.getObjects()),
  STATUS_KEPEMILIKAN_GEDUNG_UNIT_USAHA (ER1223StatusKepemilikanGedungUnitUsaha.getRefNumber(), ER1223StatusKepemilikanGedungUnitUsaha.getName(), ER1223StatusKepemilikanGedungUnitUsaha.getObjects()),
  LEVEL_STRUKTUR (ER1224LevelStrukturOrganisasi.getRefNumber(), ER1224LevelStrukturOrganisasi.getName(), ER1224LevelStrukturOrganisasi.getObjects()),
  JENIS_KANTOR (ER1225JenisKantor.getRefNumber(), ER1225JenisKantor.getName(), ER1225JenisKantor.getObjects()),
  TINGKAT_PENDIDIKAN (ER1226TingkatPendidikan.getRefNumber(), ER1226TingkatPendidikan.getName(), ER1226TingkatPendidikan.getObjects()),
  BIDANG_KEAHLIAN (ER1227BidangKeahlian.getRefNumber(), ER1227BidangKeahlian.getName(), ER1227BidangKeahlian.getObjects()),
  KUALIFIKASI_TENAGA_AHLI (ER1228KualifikasiTenagaAhli.getRefNumber(), ER1228KualifikasiTenagaAhli.getName(), ER1228KualifikasiTenagaAhli.getObjects()),
  KEWARGANEGARAAN (ER1229Kewarganegaraan.getRefNumber(), ER1229Kewarganegaraan.getName(), ER1229Kewarganegaraan.getObjects()),
  STATUS_TANGGUNGAN (ER1230StatusTanggungan.getRefNumber(), ER1230StatusTanggungan.getName(), ER1230StatusTanggungan.getObjects()),
  KELAS_PESERTA_PROGRAM_JAMINAN (ER1231KelasPesertaProgramJaminan.getRefNumber(), ER1231KelasPesertaProgramJaminan.getName(), ER1231KelasPesertaProgramJaminan.getObjects()),
  JENIS_FASILITAS_KESEHATAN (ER1232JenisFasilitasKesehatan.getRefNumber(), ER1232JenisFasilitasKesehatan.getName(), ER1232JenisFasilitasKesehatan.getObjects()),
  JENIS_KLAIM (ER1233JenisKlaim.getRefNumber(), ER1233JenisKlaim.getName(), ER1233JenisKlaim.getObjects()),
  JENIS_PROGRAM (ER1234JenisProgram.getRefNumber(), ER1234JenisProgram.getName(), ER1234JenisProgram.getObjects()),
  JENIS_DEPOSITO (ER1235JenisDeposito.getRefNumber(), ER1235JenisDeposito.getName(), ER1235JenisDeposito.getObjects()),
  SYARIAH_KONVENSIONAL (ER1236SyariahKonvensional.getRefNumber(), ER1236SyariahKonvensional.getName(), ER1236SyariahKonvensional.getObjects()),
  KETERANGAN_ARO (ER1237KeteranganARO.getRefNumber(), ER1237KeteranganARO.getName(), ER1237KeteranganARO.getObjects()),
  LEMBAGA_PEMERINGKAT (ER1127LembagaPemeringkat.getRefNumber(), ER1127LembagaPemeringkat.getName(), ER1127LembagaPemeringkat.getObjects()),
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
    if(number == ER1236SyariahKonvensional.getRefNumber()) {
      return "Syariah/Non Syariah"; // tanda "/" tidak dapat digunakan sebagai nama file
    }
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
