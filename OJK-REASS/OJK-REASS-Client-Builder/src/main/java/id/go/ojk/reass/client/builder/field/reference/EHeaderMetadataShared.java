package id.go.ojk.reass.client.builder.field.reference;

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
import id.go.ojk.conf.client.field.reference.ER1084JenisUtang;
import id.go.ojk.conf.client.field.reference.ER1086SaluranDistribusiAtauPemasaran;
import id.go.ojk.conf.client.field.reference.ER1087JenisPolis;
import id.go.ojk.conf.client.field.reference.ER1091JenisReasuradurVsFactor;
import id.go.ojk.conf.client.field.reference.ER1092LiniUsaha;
import id.go.ojk.conf.client.field.reference.ER1094LokasiDalamDanLuarNegeri;
import id.go.ojk.conf.client.field.reference.ER1095JenisSaluranPemasaran;
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
	R021(ER1084JenisUtang.getRefNumber(), ER1084JenisUtang.getName(), ER1084JenisUtang.getObjects()),
	R022(ER1086SaluranDistribusiAtauPemasaran.getRefNumber(), ER1086SaluranDistribusiAtauPemasaran.getName(),
			ER1086SaluranDistribusiAtauPemasaran.getObjects()),
	R023(ER1087JenisPolis.getRefNumber(), ER1087JenisPolis.getName(), ER1087JenisPolis.getObjects()),
	R024(ER1091JenisReasuradurVsFactor.getRefNumber(), ER1091JenisReasuradurVsFactor.getName(),
			ER1091JenisReasuradurVsFactor.getObjects()),
	R025(ER1092LiniUsaha.getRefNumber(), ER1092LiniUsaha.getName(), ER1092LiniUsaha.getObjects()),
	R026(ER1094LokasiDalamDanLuarNegeri.getRefNumber(), ER1094LokasiDalamDanLuarNegeri.getName(),
			ER1094LokasiDalamDanLuarNegeri.getObjects()),
	R027(ER1095JenisSaluranPemasaran.getRefNumber(), ER1095JenisSaluranPemasaran.getName(),
			ER1095JenisSaluranPemasaran.getObjects()),;

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
