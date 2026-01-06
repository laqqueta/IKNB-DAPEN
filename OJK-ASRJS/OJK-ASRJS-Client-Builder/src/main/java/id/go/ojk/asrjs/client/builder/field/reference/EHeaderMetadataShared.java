package id.go.ojk.asrjs.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1013JenisInvestasiSyariah;
import id.go.ojk.conf.client.field.reference.ER1064JenisReasuradur;
import id.go.ojk.conf.client.field.reference.ER1065DanaJaminan;
import id.go.ojk.conf.client.field.reference.ER1066InvestasiDalamRangkaPembiayaanInfrastruktur;
import id.go.ojk.conf.client.field.reference.ER1067KategoriBadanHukum;
import id.go.ojk.conf.client.field.reference.ER1068JenisDana;
import id.go.ojk.conf.client.field.reference.ER1069Pengawas;
import id.go.ojk.conf.client.field.reference.ER1070JenisInvestasiDanProperty;
import id.go.ojk.conf.client.field.reference.ER1071PeringkatDebitur;
import id.go.ojk.conf.client.field.reference.ER1072NamaPemeringkat;
import id.go.ojk.conf.client.field.reference.ER1073KategoriUsahaDebitur;
import id.go.ojk.conf.client.field.reference.ER1074SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1075Lokasi;
import id.go.ojk.conf.client.field.reference.ER1076Negara;
import id.go.ojk.conf.client.field.reference.ER1077StatusKeterkaitan;
import id.go.ojk.conf.client.field.reference.ER1078TujuanKepemilikan;
import id.go.ojk.conf.client.field.reference.ER1079MataUang;
import id.go.ojk.conf.client.field.reference.ER1080JenisTingkatPengembalian;
import id.go.ojk.conf.client.field.reference.ER1081Kolektibilitas;
import id.go.ojk.conf.client.field.reference.ER1082Tagihan;
import id.go.ojk.conf.client.field.reference.ER1083JenisPenilaian;
import id.go.ojk.conf.client.field.reference.ER1084JenisUtang;
import id.go.ojk.conf.client.field.reference.ER1085LiniUsahaAsuransiJiwa;
import id.go.ojk.conf.client.field.reference.ER1086SaluranDistribusiAtauPemasaran;
import id.go.ojk.conf.client.field.reference.ER1087JenisPolis;
import id.go.ojk.conf.client.field.reference.ER1088CaraBayar;
import id.go.ojk.conf.client.field.reference.ER1089MasaPertanggungan;
import id.go.ojk.conf.client.field.reference.ER1090JenisProduk;
import id.go.ojk.conf.client.field.reference.ER1091JenisReasuradurVsFactor;
import id.go.ojk.conf.client.field.reference.ER1196JenisPolis;
import id.go.ojk.conf.client.field.reference.ER1197JenisKelamin;
import id.go.ojk.conf.client.field.reference.ER1198LokasiPemegangPolis;
import id.go.ojk.conf.client.field.reference.ER1199LiniUsahaAsuransiJiwa;
import id.go.ojk.conf.client.field.reference.ER1200LiniUsahaAsuransiUmum;
import id.go.ojk.conf.client.field.reference.ER1201CaraBayar;
import id.go.ojk.conf.client.field.reference.ER1202StatusPertanggungan;
import id.go.ojk.conf.client.field.reference.ER1203JenisKlaimAsuransiJiwa;
import id.go.ojk.conf.client.field.reference.ER1204JenisKlaimAsuransiUmum;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R001(ER1013JenisInvestasiSyariah.getRefNumber(), ER1013JenisInvestasiSyariah.getName(),
			ER1013JenisInvestasiSyariah.getObjects()),
	R002(ER1064JenisReasuradur.getRefNumber(), ER1064JenisReasuradur.getName(), ER1064JenisReasuradur.getObjects()),
	R003(ER1065DanaJaminan.getRefNumber(), ER1065DanaJaminan.getName(), ER1065DanaJaminan.getObjects()),
	R004(ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.getRefNumber(),
			ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.getName(),
			ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.getObjects()),
	R005(ER1067KategoriBadanHukum.getRefNumber(), ER1067KategoriBadanHukum.getName(),
			ER1067KategoriBadanHukum.getObjects()),
	R006(ER1068JenisDana.getRefNumber(), ER1068JenisDana.getName(), ER1068JenisDana.getObjects()),
	R007(ER1069Pengawas.getRefNumber(), ER1069Pengawas.getName(), ER1069Pengawas.getObjects()),
	R008(ER1070JenisInvestasiDanProperty.getRefNumber(), ER1070JenisInvestasiDanProperty.getName(),
			ER1070JenisInvestasiDanProperty.getObjects()),
	R009(ER1071PeringkatDebitur.getRefNumber(), ER1071PeringkatDebitur.getName(), ER1071PeringkatDebitur.getObjects()),
	R010(ER1072NamaPemeringkat.getRefNumber(), ER1072NamaPemeringkat.getName(), ER1072NamaPemeringkat.getObjects()),
	R011(ER1073KategoriUsahaDebitur.getRefNumber(), ER1073KategoriUsahaDebitur.getName(),
			ER1073KategoriUsahaDebitur.getObjects()),
	R012(ER1074SektorEkonomi.getRefNumber(), ER1074SektorEkonomi.getName(), ER1074SektorEkonomi.getObjects()),
	R013(ER1075Lokasi.getRefNumber(), ER1075Lokasi.getName(), ER1075Lokasi.getObjects()),
	R014(ER1076Negara.getRefNumber(), ER1076Negara.getName(), ER1076Negara.getObjects()),
	R015(ER1077StatusKeterkaitan.getRefNumber(), ER1077StatusKeterkaitan.getName(),
			ER1077StatusKeterkaitan.getObjects()),
	R016(ER1078TujuanKepemilikan.getRefNumber(), ER1078TujuanKepemilikan.getName(),
			ER1078TujuanKepemilikan.getObjects()),
	R017(ER1079MataUang.getRefNumber(), ER1079MataUang.getName(), ER1079MataUang.getObjects()),
	R018(ER1080JenisTingkatPengembalian.getRefNumber(), ER1080JenisTingkatPengembalian.getName(),
			ER1080JenisTingkatPengembalian.getObjects()),
	R019(ER1081Kolektibilitas.getRefNumber(), ER1081Kolektibilitas.getName(), ER1081Kolektibilitas.getObjects()),
	R020(ER1082Tagihan.getRefNumber(), ER1082Tagihan.getName(), ER1082Tagihan.getObjects()),
	R021(ER1083JenisPenilaian.getRefNumber(), ER1083JenisPenilaian.getName(), ER1083JenisPenilaian.getObjects()),
	R022(ER1084JenisUtang.getRefNumber(), ER1084JenisUtang.getName(), ER1084JenisUtang.getObjects()),
	R023(ER1085LiniUsahaAsuransiJiwa.getRefNumber(), ER1085LiniUsahaAsuransiJiwa.getName(),
			ER1085LiniUsahaAsuransiJiwa.getObjects()),
	R024(ER1086SaluranDistribusiAtauPemasaran.getRefNumber(), ER1086SaluranDistribusiAtauPemasaran.getName(),
			ER1086SaluranDistribusiAtauPemasaran.getObjects()),
	R025(ER1087JenisPolis.getRefNumber(), ER1087JenisPolis.getName(), ER1087JenisPolis.getObjects()),
	R026(ER1088CaraBayar.getRefNumber(), ER1088CaraBayar.getName(), ER1088CaraBayar.getObjects()),
	R027(ER1089MasaPertanggungan.getRefNumber(), ER1089MasaPertanggungan.getName(),
			ER1089MasaPertanggungan.getObjects()),
	R028(ER1090JenisProduk.getRefNumber(), ER1090JenisProduk.getName(), ER1090JenisProduk.getObjects()),
	R029(ER1091JenisReasuradurVsFactor.getRefNumber(), ER1091JenisReasuradurVsFactor.getName(),
			ER1091JenisReasuradurVsFactor.getObjects()),
	R030(ER1196JenisPolis.getRefNumber(), ER1196JenisPolis.getName(), ER1196JenisPolis.getObjects()),
	R031(ER1197JenisKelamin.getRefNumber(), ER1197JenisKelamin.getName(), ER1197JenisKelamin.getObjects()),
	R032(ER1198LokasiPemegangPolis.getRefNumber(), ER1198LokasiPemegangPolis.getName(),
			ER1198LokasiPemegangPolis.getObjects()),
	R033(ER1199LiniUsahaAsuransiJiwa.getRefNumber(), ER1199LiniUsahaAsuransiJiwa.getName(),
			ER1199LiniUsahaAsuransiJiwa.getObjects()),
	R034(ER1200LiniUsahaAsuransiUmum.getRefNumber(), ER1200LiniUsahaAsuransiUmum.getName(),
			ER1200LiniUsahaAsuransiUmum.getObjects()),
	R035(ER1201CaraBayar.getRefNumber(), ER1201CaraBayar.getName(), ER1201CaraBayar.getObjects()),
	R036(ER1202StatusPertanggungan.getRefNumber(), ER1202StatusPertanggungan.getName(),
			ER1202StatusPertanggungan.getObjects()),
	R037(ER1203JenisKlaimAsuransiJiwa.getRefNumber(), ER1203JenisKlaimAsuransiJiwa.getName(),
			ER1203JenisKlaimAsuransiJiwa.getObjects()),
	R038(ER1204JenisKlaimAsuransiUmum.getRefNumber(), ER1204JenisKlaimAsuransiUmum.getName(),
			ER1204JenisKlaimAsuransiUmum.getObjects()),	;

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
