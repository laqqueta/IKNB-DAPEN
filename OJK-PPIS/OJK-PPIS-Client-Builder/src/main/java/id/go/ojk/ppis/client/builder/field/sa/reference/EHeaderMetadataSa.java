package id.go.ojk.ppis.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;

public enum EHeaderMetadataSa implements IObject<ReferenceMetadata> {
	R3300_SA060100 (ER3300PosSaPpis060100.getRefNumber(), ER3300PosSaPpis060100.getName(), ER3300PosSaPpis060100.getObjects()),
	R3301_SA060301 (ER3301PosSaPpis060301.getRefNumber(), ER3301PosSaPpis060301.getName(), ER3301PosSaPpis060301.getObjects()),
	;

	private int number;
	private String name;
	private List<KeyValueString> references;

	private EHeaderMetadataSa(int number, String name, List<KeyValueString> references) {
		this.number = number;
		this.name = name;
		this.references = references;
	}
	
	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}
	
	public String getDescription() {
		return "Kode komponen Form " + name.substring(9); 
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
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
