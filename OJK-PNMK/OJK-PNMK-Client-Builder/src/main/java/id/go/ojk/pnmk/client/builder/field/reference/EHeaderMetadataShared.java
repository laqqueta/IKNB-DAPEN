package id.go.ojk.pnmk.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.conf.client.field.reference.ER1124SektorEkonomi;
import id.go.ojk.conf.client.field.reference.ER1127LembagaPemeringkat;
import id.go.ojk.conf.client.field.reference.ER1128PeringkatSb;
import id.go.ojk.conf.client.field.reference.ER1135LokasiDati2;
import id.go.ojk.conf.client.field.reference.ER1143JenisAkadPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1147JenisAkadPendanaan;
import id.go.ojk.conf.client.field.reference.ER1152JenisKantorSelainKantorPusat;
import id.go.ojk.conf.client.field.reference.ER1153UmurAsetAtauLiabilitas;
import id.go.ojk.conf.client.field.reference.ER1154JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1155JenisKreditur;
import id.go.ojk.conf.client.field.reference.ER1156Kualitas;
import id.go.ojk.conf.client.field.reference.ER1157LokasiDati1;
import id.go.ojk.conf.client.field.reference.ER1158KepemilikanGedungKantor;
import id.go.ojk.conf.client.field.reference.ER1159JenisIjarah;
import id.go.ojk.conf.client.field.reference.ER1160JenisPendanaan;
import id.go.ojk.conf.client.field.reference.ER1161JenisSuratBerhargaSyariah;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R000 (ER1152JenisKantorSelainKantorPusat.getRefNumber(), ER1152JenisKantorSelainKantorPusat.getName(), ER1152JenisKantorSelainKantorPusat.getObjects()),
	R001 (ER1153UmurAsetAtauLiabilitas.getRefNumber(), ER1153UmurAsetAtauLiabilitas.getName(), ER1153UmurAsetAtauLiabilitas.getObjects()),
	R002 (ER1154JenisSuratBerharga.getRefNumber(), ER1154JenisSuratBerharga.getName(), ER1154JenisSuratBerharga.getObjects()),
	R003 (ER1155JenisKreditur.getRefNumber(), ER1155JenisKreditur.getName(), ER1155JenisKreditur.getObjects()),
	R004 (ER1128PeringkatSb.getRefNumber(), ER1128PeringkatSb.getName(), ER1128PeringkatSb.getObjects()),
	R005 (ER1127LembagaPemeringkat.getRefNumber(), ER1127LembagaPemeringkat.getName(), ER1127LembagaPemeringkat.getObjects()),
	R006 (ER1156Kualitas.getRefNumber(), ER1156Kualitas.getName(), ER1156Kualitas.getObjects()),
	R007 (ER1157LokasiDati1.getRefNumber(), ER1157LokasiDati1.getName(), ER1157LokasiDati1.getObjects()),
	R008 (ER1135LokasiDati2.getRefNumber(), ER1135LokasiDati2.getName(), ER1135LokasiDati2.getObjects()),
	R009 (ER1124SektorEkonomi.getRefNumber(), ER1124SektorEkonomi.getName(), ER1124SektorEkonomi.getObjects()),
	R010 (ER1158KepemilikanGedungKantor.getRefNumber(), ER1158KepemilikanGedungKantor.getName(), ER1158KepemilikanGedungKantor.getObjects()),
	R011 (ER1143JenisAkadPembiayaan.getRefNumber(), ER1143JenisAkadPembiayaan.getName(), ER1143JenisAkadPembiayaan.getObjects()),
	R012 (ER1159JenisIjarah.getRefNumber(), ER1159JenisIjarah.getName(), ER1159JenisIjarah.getObjects()),
	R013 (ER1147JenisAkadPendanaan.getRefNumber(), ER1147JenisAkadPendanaan.getName(), ER1147JenisAkadPendanaan.getObjects()),
	R014 (ER1160JenisPendanaan.getRefNumber(), ER1160JenisPendanaan.getName(), ER1160JenisPendanaan.getObjects()),
	R015 (ER1161JenisSuratBerhargaSyariah.getRefNumber(), ER1161JenisSuratBerhargaSyariah.getName(), ER1161JenisSuratBerhargaSyariah.getObjects()),
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
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(name), " ");
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
