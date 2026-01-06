package id.go.ojk.dppks.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.conf.client.field.reference.ER1010PeriodeRealisasi;
import id.go.ojk.conf.client.field.reference.ER1011Program;
import id.go.ojk.conf.client.field.reference.ER1012KualitasPendanaan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R001 (ER1010PeriodeRealisasi.getRefNumber(), ER1010PeriodeRealisasi.getName(), ER1010PeriodeRealisasi.getObjects()),
	R002 (ER1011Program.getRefNumber(), ER1011Program.getName(), ER1011Program.getObjects()),
	R003 (ER1012KualitasPendanaan.getRefNumber(), ER1012KualitasPendanaan.getName(), ER1012KualitasPendanaan.getObjects()),
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
