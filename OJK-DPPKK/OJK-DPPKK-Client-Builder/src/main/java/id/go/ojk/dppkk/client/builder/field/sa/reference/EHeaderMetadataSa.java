package id.go.ojk.dppkk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataSa implements IObject<ReferenceMetadata> {
	R4000_SA0100 (4000, "PosSaDppk0100", ReferenceType.keyValue, "", null, false, null, ER4000PosSaDppk0100.getObjects()),
	R4001_SA0200 (4001, "PosSaDppk0200", ReferenceType.keyValue, "", null, false, null, ER4001PosSaDppk0200.getObjects()),
	R4002_SA0301 (4002, "PosSaDppk0301", ReferenceType.keyValue, "", null, false, null, ER4002PosSaDppk0301.getObjects()),
	R4003_SA0302 (4003, "PosSaDppk0302", ReferenceType.keyValue, "", null, false, null, ER4003PosSaDppk0302.getObjects()),
	R4004_SA0303 (4004, "PosSaDppk0303", ReferenceType.keyValue, "", null, false, null, ER4004PosSaDppk0303.getObjects()),
	R4005_SA0400 (4005, "PosSaDppk0400", ReferenceType.keyValue, "", null, false, null, ER4005PosSaDppk0400.getObjects()),
	R4006_SA0500 (4006, "PosSaDppk0500", ReferenceType.keyValue, "", null, false, null, ER4006PosSaDppk0500.getObjects()),
//	R4007_SA8888 (4007, "PosSaDppk8888", ReferenceType.keyValue, "", null, false, null, ER4007PosSaDppk8888.getObjects()),
//	R4008_SA9999 (4008, "PosSaDppk9999", ReferenceType.keyValue, "", null, false, null, ER4008PosSaDppk9999.getObjects()),
	;

	private int number;
	private String name;
	private ReferenceType type;
	private String description;
	private String errorDescription;
	private boolean perSegment;
	private String label1Map;
	private List<KeyValueString> references;
	
	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}
	
	public String getDescription() {
		return StringUtils.isEmpty(description) ? ("R" + number + name) : description; 
	}
	
	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, type, getDescription(), errorDescription);
		res.setPerSegment(perSegment);
		res.setLabel1Map(StringUtils.isNotBlank(label1Map) ? CollectionUtil.toMap(label1Map) : null);
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
