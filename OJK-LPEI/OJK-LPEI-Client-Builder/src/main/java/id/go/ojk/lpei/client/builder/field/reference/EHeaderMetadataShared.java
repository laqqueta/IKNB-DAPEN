package id.go.ojk.lpei.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.conf.client.field.reference.ER1102StatusKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1103BentukBadanHukum;
import id.go.ojk.conf.client.field.reference.ER1104StatusPemegangSaham;
import id.go.ojk.conf.client.field.reference.ER1105JabatanKepengurusan;
import id.go.ojk.conf.client.field.reference.ER1106StatusPerusahaanPembiayaanInfrastruktur;
import id.go.ojk.conf.client.field.reference.ER1107StatusPerizinan;
import id.go.ojk.conf.client.field.reference.ER1108JenisKegiatanUsahaYangDilakukanKonvensional;
import id.go.ojk.conf.client.field.reference.ER1109HubunganPihakTerkait;
import id.go.ojk.conf.client.field.reference.ER1110BidangSpesialisasi;
import id.go.ojk.conf.client.field.reference.ER1111JenisTenagaKerja;
import id.go.ojk.conf.client.field.reference.ER1112TingkatPendidikan;
import id.go.ojk.conf.client.field.reference.ER1113NamaKelompokDebitur;
import id.go.ojk.conf.client.field.reference.ER1114KategoriUsahaDebitur;
import id.go.ojk.conf.client.field.reference.ER1115KategoriUsahaKeuanganBerkelanjutan;
import id.go.ojk.conf.client.field.reference.ER1116StatusKeterkaitan;
import id.go.ojk.conf.client.field.reference.ER1117SukuBungaMarginUjrahBagiHasil;
import id.go.ojk.conf.client.field.reference.ER1118KategoriPiutang;
import id.go.ojk.conf.client.field.reference.ER1119Kualitas;
import id.go.ojk.conf.client.field.reference.ER1120MetodeCadanganKerugianPenurunanNilai;
import id.go.ojk.conf.client.field.reference.ER1121JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1123ObjekPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1125TujuanKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.conf.client.field.reference.ER1127LembagaPemeringkat;
import id.go.ojk.conf.client.field.reference.ER1128PeringkatSb;
import id.go.ojk.conf.client.field.reference.ER1129RupaRupaAset;
import id.go.ojk.conf.client.field.reference.ER1130RupaRupaliabilitas;
import id.go.ojk.conf.client.field.reference.ER1131JenisInstrumenDerivatif;
import id.go.ojk.conf.client.field.reference.ER1132JenisPinjaman;
import id.go.ojk.conf.client.field.reference.ER1133GolonganPihakLawan;
import id.go.ojk.conf.client.field.reference.ER1134StatusKepemilikanGedungUnitUsaha;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1136JenisAgunan;
import id.go.ojk.conf.client.field.reference.ER1137TujuanPenerimaPinjaman;
import id.go.ojk.conf.client.field.reference.ER1138TenagaKerjaAsing;
import id.go.ojk.conf.client.field.reference.ER1139JenisAkadRincianAsetIjarah;
import id.go.ojk.conf.client.field.reference.ER1140GolonganPihakLawan2550;
import id.go.ojk.conf.client.field.reference.ER1141JenisKegiatanUsahaSyariahYangDilakukan;
import id.go.ojk.conf.client.field.reference.ER1142JenisKegiatanUsahaYangDilakukan;
import id.go.ojk.conf.client.field.reference.ER1143JenisAkadPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1144JenisAkadSyariahSuratBerhargaYangDimiliki;
import id.go.ojk.conf.client.field.reference.ER1145JenisBagiHasil;
import id.go.ojk.conf.client.field.reference.ER1146JenisAkadProyekPemulihanEkonomiNasional;
import id.go.ojk.conf.client.field.reference.ER1147JenisAkadPendanaan;
import id.go.ojk.conf.client.field.reference.ER1148JenisAkadSuratBerhargaYangDiterbitkan;
import id.go.ojk.conf.client.field.reference.ER1149JenisInstrumenDerivatifSyariah;
import id.go.ojk.conf.client.field.reference.ER1150JenisPinjamanSyariah;
import id.go.ojk.conf.client.field.reference.ER1151GolonganInvestor;
import id.go.ojk.conf.client.field.reference.ER1164PenempatanDana;
import id.go.ojk.conf.client.field.reference.ER1165KategoriUsahaKeuanganBerkelanjutan;
import id.go.ojk.conf.client.field.reference.ER1167JenisPenggunaan;
import id.go.ojk.conf.client.field.reference.ER1168MetodePenyertaanPencatatan;
import id.go.ojk.conf.client.field.reference.ER1169TujuanPenyertaan;
import id.go.ojk.conf.client.field.reference.ER1170JenisReasuransi;
import id.go.ojk.conf.client.field.reference.ER1171JenisTagihanAkseptasi;
import id.go.ojk.conf.client.field.reference.ER1172KetersediaanSinkingFund;
import id.go.ojk.conf.client.field.reference.ER1173JenisRetensiSendiriPenutupanAsuransiDanPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1174JenisAsuransi;
import id.go.ojk.conf.client.field.reference.ER1175JenisPenjaminan;
import id.go.ojk.conf.client.field.reference.ER1176JenisPembiayaanDHE;
import id.go.ojk.conf.client.field.reference.ER1177JenisSuratBerhargaLPEI;
import id.go.ojk.conf.client.field.reference.ER1205JenisPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1206LokasiDati2;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R000 (ER1102StatusKepemilikan.getRefNumber(), ER1102StatusKepemilikan.getName(), ER1102StatusKepemilikan.getObjects()),
	R001 (ER1103BentukBadanHukum.getRefNumber(), ER1103BentukBadanHukum.getName(), ER1103BentukBadanHukum.getObjects()),
	R002 (ER1104StatusPemegangSaham.getRefNumber(), ER1104StatusPemegangSaham.getName(), ER1104StatusPemegangSaham.getObjects()),
	R003 (ER1105JabatanKepengurusan.getRefNumber(), ER1105JabatanKepengurusan.getName(), ER1105JabatanKepengurusan.getObjects()),
	R004 (ER1106StatusPerusahaanPembiayaanInfrastruktur.getRefNumber(), ER1106StatusPerusahaanPembiayaanInfrastruktur.getName(), ER1106StatusPerusahaanPembiayaanInfrastruktur.getObjects()),
	R005 (ER1107StatusPerizinan.getRefNumber(), ER1107StatusPerizinan.getName(), ER1107StatusPerizinan.getObjects()),
	R006 (ER1108JenisKegiatanUsahaYangDilakukanKonvensional.getRefNumber(), ER1108JenisKegiatanUsahaYangDilakukanKonvensional.getName(), ER1108JenisKegiatanUsahaYangDilakukanKonvensional.getObjects()),
	R007 (ER1109HubunganPihakTerkait.getRefNumber(), ER1109HubunganPihakTerkait.getName(), ER1109HubunganPihakTerkait.getObjects()),
	R008 (ER1110BidangSpesialisasi.getRefNumber(), ER1110BidangSpesialisasi.getName(), ER1110BidangSpesialisasi.getObjects()),
	R009 (ER1111JenisTenagaKerja.getRefNumber(), ER1111JenisTenagaKerja.getName(), ER1111JenisTenagaKerja.getObjects()),
	R010 (ER1112TingkatPendidikan.getRefNumber(), ER1112TingkatPendidikan.getName(), ER1112TingkatPendidikan.getObjects()),
	R011 (ER1113NamaKelompokDebitur.getRefNumber(), ER1113NamaKelompokDebitur.getName(), ER1113NamaKelompokDebitur.getObjects()),
	R012 (ER1114KategoriUsahaDebitur.getRefNumber(), ER1114KategoriUsahaDebitur.getName(), ER1114KategoriUsahaDebitur.getObjects()),
	R013 (ER1115KategoriUsahaKeuanganBerkelanjutan.getRefNumber(), ER1115KategoriUsahaKeuanganBerkelanjutan.getName(), ER1115KategoriUsahaKeuanganBerkelanjutan.getObjects()),
	R014 (ER1116StatusKeterkaitan.getRefNumber(), ER1116StatusKeterkaitan.getName(), ER1116StatusKeterkaitan.getObjects()),
	R015 (ER1117SukuBungaMarginUjrahBagiHasil.getRefNumber(), ER1117SukuBungaMarginUjrahBagiHasil.getName(), ER1117SukuBungaMarginUjrahBagiHasil.getObjects()),
	R016 (ER1118KategoriPiutang.getRefNumber(), ER1118KategoriPiutang.getName(), ER1118KategoriPiutang.getObjects()),
	R017 (ER1119Kualitas.getRefNumber(), ER1119Kualitas.getName(), ER1119Kualitas.getObjects()),
	R018 (ER1120MetodeCadanganKerugianPenurunanNilai.getRefNumber(), ER1120MetodeCadanganKerugianPenurunanNilai.getName(), ER1120MetodeCadanganKerugianPenurunanNilai.getObjects()),
	R019 (ER1121JenisSuratBerharga.getRefNumber(), ER1121JenisSuratBerharga.getName(), ER1121JenisSuratBerharga.getObjects()),
	R020 (ER1122JenisValuta.getRefNumber(), ER1122JenisValuta.getName(), ER1122JenisValuta.getObjects()),
	R021 (ER1123ObjekPembiayaan.getRefNumber(), ER1123ObjekPembiayaan.getName(), ER1123ObjekPembiayaan.getObjects()),
	R022 (ER1124SektorEkonomi.getRefNumber(), ER1124SektorEkonomi.getName(), ER1124SektorEkonomi.getObjects()),
	R023 (ER1125TujuanKepemilikan.getRefNumber(), ER1125TujuanKepemilikan.getName(), ER1125TujuanKepemilikan.getObjects()),
	R024 (ER1126Negara.getRefNumber(), ER1126Negara.getName(), ER1126Negara.getObjects()),
	R025 (ER1127LembagaPemeringkat.getRefNumber(), ER1127LembagaPemeringkat.getName(), ER1127LembagaPemeringkat.getObjects()),
	R026 (ER1128PeringkatSb.getRefNumber(), ER1128PeringkatSb.getName(), ER1128PeringkatSb.getObjects()),
	R027 (ER1129RupaRupaAset.getRefNumber(), ER1129RupaRupaAset.getName(), ER1129RupaRupaAset.getObjects()),
	R028 (ER1130RupaRupaliabilitas.getRefNumber(), ER1130RupaRupaliabilitas.getName(), ER1130RupaRupaliabilitas.getObjects()),
	R029 (ER1131JenisInstrumenDerivatif.getRefNumber(), ER1131JenisInstrumenDerivatif.getName(), ER1131JenisInstrumenDerivatif.getObjects()),
	R030 (ER1132JenisPinjaman.getRefNumber(), ER1132JenisPinjaman.getName(), ER1132JenisPinjaman.getObjects()),
	R031 (ER1133GolonganPihakLawan.getRefNumber(), ER1133GolonganPihakLawan.getName(), ER1133GolonganPihakLawan.getObjects()),
	R032 (ER1134StatusKepemilikanGedungUnitUsaha.getRefNumber(), ER1134StatusKepemilikanGedungUnitUsaha.getName(), ER1134StatusKepemilikanGedungUnitUsaha.getObjects()),
	R033 (ER1206LokasiDati2.getRefNumber(), ER1206LokasiDati2.getName(), ER1206LokasiDati2.getObjects()),
	R034 (ER1136JenisAgunan.getRefNumber(), ER1136JenisAgunan.getName(), ER1136JenisAgunan.getObjects()),
	R035 (ER1137TujuanPenerimaPinjaman.getRefNumber(), ER1137TujuanPenerimaPinjaman.getName(), ER1137TujuanPenerimaPinjaman.getObjects()),
	R036 (ER1138TenagaKerjaAsing.getRefNumber(), ER1138TenagaKerjaAsing.getName(), ER1138TenagaKerjaAsing.getObjects()),
	R037 (ER1139JenisAkadRincianAsetIjarah.getRefNumber(), ER1139JenisAkadRincianAsetIjarah.getName(), ER1139JenisAkadRincianAsetIjarah.getObjects()),
	R038 (ER1140GolonganPihakLawan2550.getRefNumber(), ER1140GolonganPihakLawan2550.getName(), ER1140GolonganPihakLawan2550.getObjects()),
	R039 (ER1141JenisKegiatanUsahaSyariahYangDilakukan.getRefNumber(), ER1141JenisKegiatanUsahaSyariahYangDilakukan.getName(), ER1141JenisKegiatanUsahaSyariahYangDilakukan.getObjects()),
	R040 (ER1142JenisKegiatanUsahaYangDilakukan.getRefNumber(), ER1142JenisKegiatanUsahaYangDilakukan.getName(), ER1142JenisKegiatanUsahaYangDilakukan.getObjects()),
	R041 (ER1143JenisAkadPembiayaan.getRefNumber(), ER1143JenisAkadPembiayaan.getName(), ER1143JenisAkadPembiayaan.getObjects()),
	R042 (ER1144JenisAkadSyariahSuratBerhargaYangDimiliki.getRefNumber(), ER1144JenisAkadSyariahSuratBerhargaYangDimiliki.getName(), ER1144JenisAkadSyariahSuratBerhargaYangDimiliki.getObjects()),
	R043 (ER1145JenisBagiHasil.getRefNumber(), ER1145JenisBagiHasil.getName(), ER1145JenisBagiHasil.getObjects()),
	R044 (ER1146JenisAkadProyekPemulihanEkonomiNasional.getRefNumber(), ER1146JenisAkadProyekPemulihanEkonomiNasional.getName(), ER1146JenisAkadProyekPemulihanEkonomiNasional.getObjects()),
	R045 (ER1147JenisAkadPendanaan.getRefNumber(), ER1147JenisAkadPendanaan.getName(), ER1147JenisAkadPendanaan.getObjects()),
	R046 (ER1148JenisAkadSuratBerhargaYangDiterbitkan.getRefNumber(), ER1148JenisAkadSuratBerhargaYangDiterbitkan.getName(), ER1148JenisAkadSuratBerhargaYangDiterbitkan.getObjects()),
	R047 (ER1149JenisInstrumenDerivatifSyariah.getRefNumber(), ER1149JenisInstrumenDerivatifSyariah.getName(), ER1149JenisInstrumenDerivatifSyariah.getObjects()),
	R048 (ER1150JenisPinjamanSyariah.getRefNumber(), ER1150JenisPinjamanSyariah.getName(), ER1150JenisPinjamanSyariah.getObjects()),
	R050 (ER1151GolonganInvestor.getRefNumber(), ER1151GolonganInvestor.getName(), ER1151GolonganInvestor.getObjects()),
	R051 (ER1164PenempatanDana.getRefNumber(), ER1164PenempatanDana.getName(), ER1164PenempatanDana.getObjects()),
	R052 (ER1165KategoriUsahaKeuanganBerkelanjutan.getRefNumber(), ER1165KategoriUsahaKeuanganBerkelanjutan.getName(), ER1165KategoriUsahaKeuanganBerkelanjutan.getObjects()),
	R053 (ER1205JenisPembiayaan.getRefNumber(), ER1205JenisPembiayaan.getName(), ER1205JenisPembiayaan.getObjects()),
	R054 (ER1167JenisPenggunaan.getRefNumber(), ER1167JenisPenggunaan.getName(), ER1167JenisPenggunaan.getObjects()),
	R055 (ER1168MetodePenyertaanPencatatan.getRefNumber(), ER1168MetodePenyertaanPencatatan.getName(), ER1168MetodePenyertaanPencatatan.getObjects()),
	R056 (ER1169TujuanPenyertaan.getRefNumber(), ER1169TujuanPenyertaan.getName(), ER1169TujuanPenyertaan.getObjects()),
	R057 (ER1170JenisReasuransi.getRefNumber(), ER1170JenisReasuransi.getName(), ER1170JenisReasuransi.getObjects()),
	R058 (ER1171JenisTagihanAkseptasi.getRefNumber(), ER1171JenisTagihanAkseptasi.getName(), ER1171JenisTagihanAkseptasi.getObjects()),
	R059 (ER1172KetersediaanSinkingFund.getRefNumber(), ER1172KetersediaanSinkingFund.getName(), ER1172KetersediaanSinkingFund.getObjects()),
	R060 (ER1173JenisRetensiSendiriPenutupanAsuransiDanPenjaminan.getRefNumber(), ER1173JenisRetensiSendiriPenutupanAsuransiDanPenjaminan.getName(), ER1173JenisRetensiSendiriPenutupanAsuransiDanPenjaminan.getObjects()),
	R061 (ER1174JenisAsuransi.getRefNumber(), ER1174JenisAsuransi.getName(), ER1174JenisAsuransi.getObjects()),
	R062 (ER1175JenisPenjaminan.getRefNumber(), ER1175JenisPenjaminan.getName(), ER1175JenisPenjaminan.getObjects()),
	R063 (ER1176JenisPembiayaanDHE.getRefNumber(), ER1176JenisPembiayaanDHE.getName(), ER1176JenisPembiayaanDHE.getObjects()),
	R064 (ER1177JenisSuratBerhargaLPEI.getRefNumber(), ER1177JenisSuratBerhargaLPEI.getName(), ER1177JenisSuratBerhargaLPEI.getObjects()),
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
		if(this.number == R015.number) {
			return "Suku Bunga/Margin/Ujrah/Bagi Hasil";
		} else if(this.number == R055.number) {
			return "Metode Penyertaan/Pencatatan";
		} else if(this.number == R028.number) {
			return "Rupa-Rupa Liabilitas";
		} else {
			return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(name), " ");
		}
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
