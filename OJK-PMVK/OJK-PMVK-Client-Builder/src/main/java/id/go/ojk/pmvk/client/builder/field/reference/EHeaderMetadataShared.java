package id.go.ojk.pmvk.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1006PemegangSaham;
import id.go.ojk.conf.client.field.reference.ER1009Dati2;
import id.go.ojk.conf.client.field.reference.ER1053JenisKegiatanUsahaBaru;
import id.go.ojk.conf.client.field.reference.ER1054JenisKegiatanUsaha;
import id.go.ojk.conf.client.field.reference.ER1055RencanaPengembanganKantor;
import id.go.ojk.conf.client.field.reference.ER1056JenisKantor;
import id.go.ojk.conf.client.field.reference.ER1057MetodeDiklat;
import id.go.ojk.conf.client.field.reference.ER1058JenisPembiayaanPenyertaan;
import id.go.ojk.conf.client.field.reference.ER1059RencanaPengembanganVsJenisKantor;
import id.go.ojk.conf.client.field.reference.ER1064JenisReasuradur;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R001(ER1006PemegangSaham.getRefNumber(), ER1006PemegangSaham.getName(), ER1006PemegangSaham.getObjects()),
	R002(ER1009Dati2.getRefNumber(), ER1009Dati2.getName(), ER1009Dati2.getObjects()),
	R003(ER1053JenisKegiatanUsahaBaru.getRefNumber(), ER1053JenisKegiatanUsahaBaru.getName(),
			ER1053JenisKegiatanUsahaBaru.getObjects()),
	R004(ER1054JenisKegiatanUsaha.getRefNumber(), ER1054JenisKegiatanUsaha.getName(),
			ER1054JenisKegiatanUsaha.getObjects()),
	R005(ER1055RencanaPengembanganKantor.getRefNumber(), ER1055RencanaPengembanganKantor.getName(),
			ER1055RencanaPengembanganKantor.getObjects()),
	R006(ER1056JenisKantor.getRefNumber(), ER1056JenisKantor.getName(), ER1056JenisKantor.getObjects()),
	R007(ER1057MetodeDiklat.getRefNumber(), ER1057MetodeDiklat.getName(), ER1057MetodeDiklat.getObjects()),
	R008(ER1058JenisPembiayaanPenyertaan.getRefNumber(), ER1058JenisPembiayaanPenyertaan.getName(),
			ER1058JenisPembiayaanPenyertaan.getObjects()),
	R009(ER1059RencanaPengembanganVsJenisKantor.getRefNumber(), ER1059RencanaPengembanganVsJenisKantor.getName(),
			ER1059RencanaPengembanganVsJenisKantor.getObjects()),
	R010(ER1064JenisReasuradur.getRefNumber(), ER1064JenisReasuradur.getName(), ER1064JenisReasuradur.getObjects()),;

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
