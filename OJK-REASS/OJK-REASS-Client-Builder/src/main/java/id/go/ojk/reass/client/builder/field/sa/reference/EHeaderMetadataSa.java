package id.go.ojk.reass.client.builder.field.sa.reference;

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
	R4000_SA0100 (4000, "PosSaReass0100", ReferenceType.keyValue, "", null, false, null, ER4000PosSaReass0100.getObjects()),
	R4001_SA0201 (4001, "PosSaReass0201", ReferenceType.keyValue, "", null, false, null, ER4001PosSaReass0201.getObjects()),
	R4002_SA0202 (4002, "PosSaReass0202", ReferenceType.keyValue, "", null, false, null, ER4002PosSaReass0202.getObjects()),
	R4003_SA0203 (4003, "PosSaReass0203", ReferenceType.keyValue, "", null, false, null, ER4003PosSaReass0203.getObjects()),
	R4004_SA0204 (4004, "PosSaReass0204", ReferenceType.keyValue, "", null, false, null, ER4004PosSaReass0204.getObjects()),
	R4005_SA0205 (4005, "PosSaReass0205", ReferenceType.keyValue, "", null, false, null, ER4005PosSaReass0205.getObjects()),
	R4006_SA0206 (4006, "PosSaReass0206", ReferenceType.keyValue, "", null, false, null, ER4006PosSaReass0206.getObjects()),
	R4007_SA0207 (4007, "PosSaReass0207", ReferenceType.keyValue, "", null, false, null, ER4007PosSaReass0207.getObjects()),
	R4008_SA0208 (4008, "PosSaReass0208", ReferenceType.keyValue, "", null, false, null, ER4008PosSaReass0208.getObjects()),
	R4009_SA0209 (4009, "PosSaReass0209", ReferenceType.keyValue, "", null, false, null, ER4009PosSaReass0209.getObjects()),
	R4010_SA0210 (4010, "PosSaReass0210", ReferenceType.keyValue, "", null, false, null, ER4010PosSaReass0210.getObjects()),
	R4011_SA0211 (4011, "PosSaReass0211", ReferenceType.keyValue, "", null, false, null, ER4011PosSaReass0211.getObjects()),
	R4012_SA0300 (4012, "PosSaReass0300", ReferenceType.keyValue, "", null, false, null, ER4012PosSaReass0300.getObjects()),
	R4013_SA0400 (4013, "PosSaReass0400", ReferenceType.keyValue, "", null, false, null, ER4013PosSaReass0400.getObjects()),
	R4014_SA0501 (4014, "PosSaReass0501", ReferenceType.keyValue, "", null, false, null, ER4014PosSaReass0501.getObjects()),
//	R4015_SA8888 (4015, "PosSaReass8888", ReferenceType.keyValue, "", null, false, null, ER4015PosSaReass8888.getObjects()),
//	R4016_SA9999 (4016, "PosSaReass9999", ReferenceType.keyValue, "", null, false, null, ER4016PosSaReass9999.getObjects()),
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
