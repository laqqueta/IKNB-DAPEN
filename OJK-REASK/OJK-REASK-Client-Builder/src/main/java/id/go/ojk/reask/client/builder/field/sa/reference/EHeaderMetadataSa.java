package id.go.ojk.reask.client.builder.field.sa.reference;

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
	R4000_SA0100 (4000, "PosSaReask0100", ReferenceType.keyValue, "", null, false, null, ER4000PosSaReask0100.getObjects()),
	R4001_SA0201 (4001, "PosSaReask0201", ReferenceType.keyValue, "", null, false, null, ER4001PosSaReask0201.getObjects()),
	R4002_SA0202 (4002, "PosSaReask0202", ReferenceType.keyValue, "", null, false, null, ER4002PosSaReask0202.getObjects()),
	R4003_SA0203 (4003, "PosSaReask0203", ReferenceType.keyValue, "", null, false, null, ER4003PosSaReask0203.getObjects()),
	R4004_SA0204 (4004, "PosSaReask0204", ReferenceType.keyValue, "", null, false, null, ER4004PosSaReask0204.getObjects()),
	R4005_SA0205 (4005, "PosSaReask0205", ReferenceType.keyValue, "", null, false, null, ER4005PosSaReask0205.getObjects()),
	R4006_SA0206 (4006, "PosSaReask0206", ReferenceType.keyValue, "", null, false, null, ER4006PosSaReask0206.getObjects()),
	R4007_SA0207 (4007, "PosSaReask0207", ReferenceType.keyValue, "", null, false, null, ER4007PosSaReask0207.getObjects()),
	R4008_SA0208 (4008, "PosSaReask0208", ReferenceType.keyValue, "", null, false, null, ER4008PosSaReask0208.getObjects()),
	R4009_SA0209 (4009, "PosSaReask0209", ReferenceType.keyValue, "", null, false, null, ER4009PosSaReask0209.getObjects()),
	R4010_SA0210 (4010, "PosSaReask0210", ReferenceType.keyValue, "", null, false, null, ER4010PosSaReask0210.getObjects()),
	R4011_SA0211 (4011, "PosSaReask0211", ReferenceType.keyValue, "", null, false, null, ER4011PosSaReask0211.getObjects()),
	R4012_SA0300 (4012, "PosSaReask0300", ReferenceType.keyValue, "", null, false, null, ER4012PosSaReask0300.getObjects()),
	R4013_SA0400 (4013, "PosSaReask0400", ReferenceType.keyValue, "", null, false, null, ER4013PosSaReask0400.getObjects()),
	R4014_SA0501 (4014, "PosSaReask0501", ReferenceType.keyValue, "", null, false, null, ER4014PosSaReask0501.getObjects()),
	R4015_SA0502 (4015, "PosSaReask0502", ReferenceType.keyValue, "", null, false, null, ER4015PosSaReask0502.getObjects()),
	R4016_SA0503 (4016, "PosSaReask0503", ReferenceType.keyValue, "", null, false, null, ER4016PosSaReask0503.getObjects()),
//	R4017_SA8888 (4017, "PosSaReask8888", ReferenceType.keyValue, "", null, false, null, ER4017PosSaReask8888.getObjects()),
//	R4018_SA9999 (4018, "PosSaReask9999", ReferenceType.keyValue, "", null, false, null, ER4018PosSaReask9999.getObjects()),
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
