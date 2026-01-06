package id.go.ojk.asrjs.client.builder.field.sa.reference;

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
	R4000_SA0100 (4000, "PosSaAsrjs0100", ReferenceType.keyValue, "", null, false, null, ER4000PosSaAsrjs0100.getObjects()),
	R4001_SA0201 (4001, "PosSaAsrjs0201", ReferenceType.keyValue, "", null, false, null, ER4001PosSaAsrjs0201.getObjects()),
	R4002_SA0202 (4002, "PosSaAsrjs0202", ReferenceType.keyValue, "", null, false, null, ER4002PosSaAsrjs0202.getObjects()),
	R4003_SA0203 (4003, "PosSaAsrjs0203", ReferenceType.keyValue, "", null, false, null, ER4003PosSaAsrjs0203.getObjects()),
	R4004_SA0204 (4004, "PosSaAsrjs0204", ReferenceType.keyValue, "", null, false, null, ER4004PosSaAsrjs0204.getObjects()),
	R4005_SA0205 (4005, "PosSaAsrjs0205", ReferenceType.keyValue, "", null, false, null, ER4005PosSaAsrjs0205.getObjects()),
	R4006_SA0206 (4006, "PosSaAsrjs0206", ReferenceType.keyValue, "", null, false, null, ER4006PosSaAsrjs0206.getObjects()),
	R4007_SA0207 (4007, "PosSaAsrjs0207", ReferenceType.keyValue, "", null, false, null, ER4007PosSaAsrjs0207.getObjects()),
	R4008_SA0208 (4008, "PosSaAsrjs0208", ReferenceType.keyValue, "", null, false, null, ER4008PosSaAsrjs0208.getObjects()),
	R4009_SA0209 (4009, "PosSaAsrjs0209", ReferenceType.keyValue, "", null, false, null, ER4009PosSaAsrjs0209.getObjects()),
	R4010_SA0210 (4010, "PosSaAsrjs0210", ReferenceType.keyValue, "", null, false, null, ER4010PosSaAsrjs0210.getObjects()),
	R4011_SA0211 (4011, "PosSaAsrjs0211", ReferenceType.keyValue, "", null, false, null, ER4011PosSaAsrjs0211.getObjects()),
	R4012_SA0300 (4012, "PosSaAsrjs0300", ReferenceType.keyValue, "", null, false, null, ER4012PosSaAsrjs0300.getObjects()),
	R4013_SA0400 (4013, "PosSaAsrjs0400", ReferenceType.keyValue, "", null, false, null, ER4013PosSaAsrjs0400.getObjects()),
	R4014_SA0501 (4014, "PosSaAsrjs0501", ReferenceType.keyValue, "", null, false, null, ER4014PosSaAsrjs0501.getObjects()),
//	R4015_SA8888 (4015, "PosSaAsrjs8888", ReferenceType.keyValue, "", null, false, null, ER4015PosSaAsrjs8888.getObjects()),
//	R4016_SA9999 (4016, "PosSaAsrjs9999", ReferenceType.keyValue, "", null, false, null, ER4016PosSaAsrjs9999.getObjects()),
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
