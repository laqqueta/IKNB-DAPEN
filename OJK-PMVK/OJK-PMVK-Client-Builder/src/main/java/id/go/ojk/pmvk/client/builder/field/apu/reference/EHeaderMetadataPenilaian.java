package id.go.ojk.pmvk.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataPenilaian implements IObject<ReferenceMetadata> {
	R000 (ER5000PosApuPmvk01.getRefNumber(), ER5000PosApuPmvk01.getName(), ER5000PosApuPmvk01.getObjects()),
	R001 (ER5001PosApuPmvk02.getRefNumber(), ER5001PosApuPmvk02.getName(), ER5001PosApuPmvk02.getObjects()),
	R002 (ER5002PosApuPmvk03.getRefNumber(), ER5002PosApuPmvk03.getName(), ER5002PosApuPmvk03.getObjects()),
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
		for (EHeaderMetadataPenilaian eEnum : EHeaderMetadataPenilaian.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataPenilaian eEnum : EHeaderMetadataPenilaian.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
