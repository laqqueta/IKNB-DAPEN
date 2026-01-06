package id.go.ojk.pnjk.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1102StatusKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1103BentukBadanHukum;
import id.go.ojk.conf.client.field.reference.ER1104StatusPemegangSaham;
import id.go.ojk.conf.client.field.reference.ER1106StatusPerusahaanPembiayaanInfrastruktur;
import id.go.ojk.conf.client.field.reference.ER1107StatusPerizinan;
import id.go.ojk.conf.client.field.reference.ER1109HubunganPihakTerkait;
import id.go.ojk.conf.client.field.reference.ER1110BidangSpesialisasi;
import id.go.ojk.conf.client.field.reference.ER1111JenisTenagaKerja;
import id.go.ojk.conf.client.field.reference.ER1112TingkatPendidikan;
import id.go.ojk.conf.client.field.reference.ER1113NamaKelompokDebitur;
import id.go.ojk.conf.client.field.reference.ER1114KategoriUsahaDebitur;
import id.go.ojk.conf.client.field.reference.ER1115KategoriUsahaKeuanganBerkelanjutan;
import id.go.ojk.conf.client.field.reference.ER1116StatusKeterkaitan;
import id.go.ojk.conf.client.field.reference.ER1118KategoriPiutang;
import id.go.ojk.conf.client.field.reference.ER1119Kualitas;
import id.go.ojk.conf.client.field.reference.ER1120MetodeCadanganKerugianPenurunanNilai;
import id.go.ojk.conf.client.field.reference.ER1121JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1123ObjekPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1125TujuanKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.conf.client.field.reference.ER1127LembagaPemeringkat;
import id.go.ojk.conf.client.field.reference.ER1128PeringkatSb;
import id.go.ojk.conf.client.field.reference.ER1129RupaRupaAset;
import id.go.ojk.conf.client.field.reference.ER1130RupaRupaliabilitas;
import id.go.ojk.conf.client.field.reference.ER1131JenisInstrumenDerivatif;
import id.go.ojk.conf.client.field.reference.ER1133GolonganPihakLawan;
import id.go.ojk.conf.client.field.reference.ER1134StatusKepemilikanGedungUnitUsaha;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1136JenisAgunan;
import id.go.ojk.conf.client.field.reference.ER1137TujuanPenerimaPinjaman;
import id.go.ojk.conf.client.field.reference.ER1138TenagaKerjaAsing;
import id.go.ojk.conf.client.field.reference.ER1139JenisAkadRincianAsetIjarah;
import id.go.ojk.conf.client.field.reference.ER1142JenisKegiatanUsahaYangDilakukan;
import id.go.ojk.conf.client.field.reference.ER1157LokasiDati1;
import id.go.ojk.conf.client.field.reference.ER1168MetodePenyertaanPencatatan;
import id.go.ojk.conf.client.field.reference.ER1178JabatanKepengurusan;
import id.go.ojk.conf.client.field.reference.ER1179SukuBungaMarginUjrahBagiHasil;
import id.go.ojk.conf.client.field.reference.ER1180JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1181JenisPinjaman;
import id.go.ojk.conf.client.field.reference.ER1182KategoriPengukuran;
import id.go.ojk.conf.client.field.reference.ER1183JenisTanahDanBangunan;
import id.go.ojk.conf.client.field.reference.ER1184StatusLegalitas;
import id.go.ojk.conf.client.field.reference.ER1185JenisPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1186ProdukPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1187SkimPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1188JenisKelamin;
import id.go.ojk.conf.client.field.reference.ER1189JenisPenerimaJaminan;
import id.go.ojk.conf.client.field.reference.ER1190YaTidak;
import id.go.ojk.conf.client.field.reference.ER1191SandiBank;
import id.go.ojk.conf.client.field.reference.ER1192SandiCounterParty;
import id.go.ojk.conf.client.field.reference.ER1193JenisPenerimaJaminan;
import id.go.ojk.conf.client.field.reference.ER1194SandiCounterparty;
import id.go.ojk.conf.client.field.reference.ER1195Kolektibilitas;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R000(ER1102StatusKepemilikan.getRefNumber(), ER1102StatusKepemilikan.getName(), ER1102StatusKepemilikan.getObjects()),
	R001(ER1103BentukBadanHukum.getRefNumber(), ER1103BentukBadanHukum.getName(), ER1103BentukBadanHukum.getObjects()),
	R005(ER1107StatusPerizinan.getRefNumber(), ER1107StatusPerizinan.getName(), ER1107StatusPerizinan.getObjects()),
	R006(ER1142JenisKegiatanUsahaYangDilakukan.getRefNumber(), ER1142JenisKegiatanUsahaYangDilakukan.getName(), ER1142JenisKegiatanUsahaYangDilakukan.getObjects()),
	R009(ER1111JenisTenagaKerja.getRefNumber(), ER1111JenisTenagaKerja.getName(), ER1111JenisTenagaKerja.getObjects()),
	R012(ER1114KategoriUsahaDebitur.getRefNumber(), ER1114KategoriUsahaDebitur.getName(), ER1114KategoriUsahaDebitur.getObjects()),
	R013(ER1115KategoriUsahaKeuanganBerkelanjutan.getRefNumber(), ER1115KategoriUsahaKeuanganBerkelanjutan.getName(), ER1115KategoriUsahaKeuanganBerkelanjutan.getObjects()),
	R014(ER1116StatusKeterkaitan.getRefNumber(), ER1116StatusKeterkaitan.getName(), ER1116StatusKeterkaitan.getObjects()),
	R015(ER1179SukuBungaMarginUjrahBagiHasil.getRefNumber(), ER1179SukuBungaMarginUjrahBagiHasil.getName(), ER1179SukuBungaMarginUjrahBagiHasil.getObjects()),
	R016(ER1118KategoriPiutang.getRefNumber(), ER1118KategoriPiutang.getName(), ER1118KategoriPiutang.getObjects()),
	R017(ER1119Kualitas.getRefNumber(), ER1119Kualitas.getName(), ER1119Kualitas.getObjects()),
	R018(ER1120MetodeCadanganKerugianPenurunanNilai.getRefNumber(), ER1120MetodeCadanganKerugianPenurunanNilai.getName(), ER1120MetodeCadanganKerugianPenurunanNilai.getObjects()),
	R019(ER1121JenisSuratBerharga.getRefNumber(), ER1121JenisSuratBerharga.getName(), ER1121JenisSuratBerharga.getObjects()),
	R020(ER1180JenisValuta.getRefNumber(), ER1180JenisValuta.getName(), ER1180JenisValuta.getObjects()),
	R021(ER1123ObjekPembiayaan.getRefNumber(), ER1123ObjekPembiayaan.getName(), ER1123ObjekPembiayaan.getObjects()),
	R022(ER1124SektorEkonomi.getRefNumber(), ER1124SektorEkonomi.getName(), ER1124SektorEkonomi.getObjects()),
	R023(ER1125TujuanKepemilikan.getRefNumber(), ER1125TujuanKepemilikan.getName(), ER1125TujuanKepemilikan.getObjects()),
	R024(ER1126Negara.getRefNumber(), ER1126Negara.getName(), ER1126Negara.getObjects()),
	R025(ER1127LembagaPemeringkat.getRefNumber(), ER1127LembagaPemeringkat.getName(), ER1127LembagaPemeringkat.getObjects()),
	R026(ER1128PeringkatSb.getRefNumber(), ER1128PeringkatSb.getName(), ER1128PeringkatSb.getObjects()),
	R027(ER1129RupaRupaAset.getRefNumber(), ER1129RupaRupaAset.getName(), ER1129RupaRupaAset.getObjects()),
	R028(ER1130RupaRupaliabilitas.getRefNumber(), ER1130RupaRupaliabilitas.getName(), ER1130RupaRupaliabilitas.getObjects()),
	R029(ER1131JenisInstrumenDerivatif.getRefNumber(), ER1131JenisInstrumenDerivatif.getName(), ER1131JenisInstrumenDerivatif.getObjects()),
	R030(ER1181JenisPinjaman.getRefNumber(), ER1181JenisPinjaman.getName(), ER1181JenisPinjaman.getObjects()),
	R031(ER1133GolonganPihakLawan.getRefNumber(), ER1133GolonganPihakLawan.getName(), ER1133GolonganPihakLawan.getObjects()),
	R032(ER1134StatusKepemilikanGedungUnitUsaha.getRefNumber(), ER1134StatusKepemilikanGedungUnitUsaha.getName(), ER1134StatusKepemilikanGedungUnitUsaha.getObjects()),
	R033(ER1135LokasiDati2.getRefNumber(), ER1135LokasiDati2.getName(), ER1135LokasiDati2.getObjects()),
	R034(ER1136JenisAgunan.getRefNumber(), ER1136JenisAgunan.getName(), ER1136JenisAgunan.getObjects()),
	R035(ER1137TujuanPenerimaPinjaman.getRefNumber(), ER1137TujuanPenerimaPinjaman.getName(), ER1137TujuanPenerimaPinjaman.getObjects()),
	R036(ER1138TenagaKerjaAsing.getRefNumber(), ER1138TenagaKerjaAsing.getName(), ER1138TenagaKerjaAsing.getObjects()),
	R037(ER1139JenisAkadRincianAsetIjarah.getRefNumber(), ER1139JenisAkadRincianAsetIjarah.getName(), ER1139JenisAkadRincianAsetIjarah.getObjects()),
	R038(ER1182KategoriPengukuran.getRefNumber(), ER1182KategoriPengukuran.getName(), ER1182KategoriPengukuran.getObjects()),
	R039(ER1183JenisTanahDanBangunan.getRefNumber(), ER1183JenisTanahDanBangunan.getName(), ER1183JenisTanahDanBangunan.getObjects()),
	R040(ER1184StatusLegalitas.getRefNumber(), ER1184StatusLegalitas.getName(), ER1184StatusLegalitas.getObjects()),
	R041(ER1168MetodePenyertaanPencatatan.getRefNumber(), ER1168MetodePenyertaanPencatatan.getName(), ER1168MetodePenyertaanPencatatan.getObjects()),
	R042(ER1185JenisPenjaminan.getRefNumber(), ER1185JenisPenjaminan.getName(), ER1185JenisPenjaminan.getObjects()),
	R043(ER1186ProdukPenjaminan.getRefNumber(), ER1186ProdukPenjaminan.getName(), ER1186ProdukPenjaminan.getObjects()),
	R044(ER1187SkimPenjaminan.getRefNumber(), ER1187SkimPenjaminan.getName(), ER1187SkimPenjaminan.getObjects()),
	R045(ER1188JenisKelamin.getRefNumber(), ER1188JenisKelamin.getName(), ER1188JenisKelamin.getObjects()),
	R046(ER1189JenisPenerimaJaminan.getRefNumber(), ER1189JenisPenerimaJaminan.getName(), ER1189JenisPenerimaJaminan.getObjects()),
	R047(ER1190YaTidak.getRefNumber(), ER1190YaTidak.getName(), ER1190YaTidak.getObjects()),
	R048(ER1157LokasiDati1.getRefNumber(), ER1157LokasiDati1.getName(), ER1157LokasiDati1.getObjects()),
	R049(ER1191SandiBank.getRefNumber(), ER1191SandiBank.getName(), ER1191SandiBank.getObjects()),
	R050(ER1192SandiCounterParty.getRefNumber(), ER1192SandiCounterParty.getName(), ER1192SandiCounterParty.getObjects()),
	R051(ER1194SandiCounterparty.getRefNumber(), ER1194SandiCounterparty.getName(), ER1194SandiCounterparty.getObjects()),
	R052(ER1195Kolektibilitas.getRefNumber(), ER1195Kolektibilitas.getName(), ER1195Kolektibilitas.getObjects()),
	R053(ER1193JenisPenerimaJaminan.getRefNumber(), ER1193JenisPenerimaJaminan.getName(), ER1193JenisPenerimaJaminan.getObjects()),
	;

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
		return "R" + number + name;
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
