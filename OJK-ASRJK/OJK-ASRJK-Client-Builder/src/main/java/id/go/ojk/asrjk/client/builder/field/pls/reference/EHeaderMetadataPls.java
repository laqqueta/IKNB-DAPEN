package id.go.ojk.asrjk.client.builder.field.pls.reference;

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
public enum EHeaderMetadataPls implements IObject<ReferenceMetadata> {
	R6001_PLS001 (ER6001PosPlsAsrjk0100.getRefNumber(), ER6001PosPlsAsrjk0100.getName(), ER6001PosPlsAsrjk0100.getObjects()),
	R6002_PLS002 (ER6002PosPlsAsrjk0200.getRefNumber(), ER6002PosPlsAsrjk0200.getName(), ER6002PosPlsAsrjk0200.getObjects()),
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
		for (EHeaderMetadataPls eEnum : EHeaderMetadataPls.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataPls eEnum : EHeaderMetadataPls.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}