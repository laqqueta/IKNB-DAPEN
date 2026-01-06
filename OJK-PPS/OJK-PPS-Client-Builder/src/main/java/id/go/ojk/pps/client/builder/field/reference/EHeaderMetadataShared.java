package id.go.ojk.pps.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1004JenisPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1005SkemaPembiayaan;
import id.go.ojk.conf.client.field.reference.ER1006PemegangSaham;
import id.go.ojk.conf.client.field.reference.ER1007RencanaPengembanganKantor;
import id.go.ojk.conf.client.field.reference.ER1008JenisKantor;
import id.go.ojk.conf.client.field.reference.ER1009Dati2;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R001(ER1004JenisPembiayaan.getRefNumber(), ER1004JenisPembiayaan.getName(), ER1004JenisPembiayaan.getObjects()),
	R002(ER1005SkemaPembiayaan.getRefNumber(), ER1005SkemaPembiayaan.getName(), ER1005SkemaPembiayaan.getObjects()),
	R003(ER1006PemegangSaham.getRefNumber(), ER1006PemegangSaham.getName(), ER1006PemegangSaham.getObjects()),
	R004(ER1007RencanaPengembanganKantor.getRefNumber(), ER1007RencanaPengembanganKantor.getName(), ER1007RencanaPengembanganKantor.getObjects()),
	R005(ER1008JenisKantor.getRefNumber(), ER1008JenisKantor.getName(), ER1008JenisKantor.getObjects()),
	R006(ER1009Dati2.getRefNumber(), ER1009Dati2.getName(), ER1009Dati2.getObjects()),
	;

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
