package id.go.ojk.asruk.client.builder.field.sa.reference;

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
	R4000_SA0100 (4000, "PosSaAsruk0100", ReferenceType.keyValue, "", null, false, null, ER4000PosSaAsruk0100.getObjects()),
	R4001_SA0201 (4001, "PosSaAsruk0201", ReferenceType.keyValue, "", null, false, null, ER4001PosSaAsruk0201.getObjects()),
	R4002_SA0202 (4002, "PosSaAsruk0202", ReferenceType.keyValue, "", null, false, null, ER4002PosSaAsruk0202.getObjects()),
	R4003_SA0203 (4003, "PosSaAsruk0203", ReferenceType.keyValue, "", null, false, null, ER4003PosSaAsruk0203.getObjects()),
	R4004_SA0204 (4004, "PosSaAsruk0204", ReferenceType.keyValue, "", null, false, null, ER4004PosSaAsruk0204.getObjects()),
	R4005_SA0205 (4005, "PosSaAsruk0205", ReferenceType.keyValue, "", null, false, null, ER4005PosSaAsruk0205.getObjects()),
	R4006_SA0206 (4006, "PosSaAsruk0206", ReferenceType.keyValue, "", null, false, null, ER4006PosSaAsruk0206.getObjects()),
	R4007_SA0207 (4007, "PosSaAsruk0207", ReferenceType.keyValue, "", null, false, null, ER4007PosSaAsruk0207.getObjects()),
	R4008_SA0208 (4008, "PosSaAsruk0208", ReferenceType.keyValue, "", null, false, null, ER4008PosSaAsruk0208.getObjects()),
	R4009_SA0209 (4009, "PosSaAsruk0209", ReferenceType.keyValue, "", null, false, null, ER4009PosSaAsruk0209.getObjects()),
	R4010_SA0210 (4010, "PosSaAsruk0210", ReferenceType.keyValue, "", null, false, null, ER4010PosSaAsruk0210.getObjects()),
	R4011_SA0211 (4011, "PosSaAsruk0211", ReferenceType.keyValue, "", null, false, null, ER4011PosSaAsruk0211.getObjects()),
	R4012_SA0300 (4012, "PosSaAsruk0300", ReferenceType.keyValue, "", null, false, null, ER4012PosSaAsruk0300.getObjects()),
	R4013_SA0400 (4013, "PosSaAsruk0400", ReferenceType.keyValue, "", null, false, null, ER4013PosSaAsruk0400.getObjects()),
	R4014_SA0501 (4014, "PosSaAsruk0501", ReferenceType.keyValue, "", null, false, null, ER4014PosSaAsruk0501.getObjects()),
	R4015_SA0502 (4015, "PosSaAsruk0502", ReferenceType.keyValue, "", null, false, null, ER4015PosSaAsruk0502.getObjects()),
	R4016_SA0503 (4016, "PosSaAsruk0503", ReferenceType.keyValue, "", null, false, null, ER4016PosSaAsruk0503.getObjects()),
//	R4017_SA8888 (4017, "PosSaAsruk8888", ReferenceType.keyValue, "", null, false, null, ER4017PosSaAsruk8888.getObjects()),
//	R4018_SA9999 (4018, "PosSaAsruk9999", ReferenceType.keyValue, "", null, false, null, ER4018PosSaAsruk9999.getObjects()),
	;
	
	private int number;
	private String name;
	private ReferenceType type;
	private String description;
	private String errorDescription;
	private boolean perSegment;
	private String label1Map;
	private List<KeyValueString> references;
	
	public String getDescription() {
		return StringUtils.isEmpty(description) ? ("R" + number + name) : description; 
	}

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}
	
	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, type, getDescription(), errorDescription);
		res.setPerSegment(perSegment);
		res.setLabel1Map(StringUtils.isNotBlank(label1Map) ? CollectionUtil.toMap(label1Map) : null);
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataSa eEnum : EHeaderMetadataSa.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
