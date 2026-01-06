package id.go.ojk.asruk.client.builder.field.sa.uus.reference;

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
public enum EHeaderMetadataSaUus implements IObject<ReferenceMetadata> {
	R4100_SA0201 (4100, "PosSaAsruu0201", ReferenceType.keyValue, "", null, false, null, ER4100PosSaAsruu0201.getObjects()),
	R4101_SA0202 (4101, "PosSaAsruu0202", ReferenceType.keyValue, "", null, false, null, ER4101PosSaAsruu0202.getObjects()),
	R4102_SA0203 (4102, "PosSaAsruu0203", ReferenceType.keyValue, "", null, false, null, ER4102PosSaAsruu0203.getObjects()),
	R4103_SA0204 (4103, "PosSaAsruu0204", ReferenceType.keyValue, "", null, false, null, ER4103PosSaAsruu0204.getObjects()),
	R4104_SA0205 (4104, "PosSaAsruu0205", ReferenceType.keyValue, "", null, false, null, ER4104PosSaAsruu0205.getObjects()),
	R4105_SA0206 (4105, "PosSaAsruu0206", ReferenceType.keyValue, "", null, false, null, ER4105PosSaAsruu0206.getObjects()),
	R4106_SA0207 (4106, "PosSaAsruu0207", ReferenceType.keyValue, "", null, false, null, ER4106PosSaAsruu0207.getObjects()),
	R4107_SA0208 (4107, "PosSaAsruu0208", ReferenceType.keyValue, "", null, false, null, ER4107PosSaAsruu0208.getObjects()),
	R4108_SA0209 (4108, "PosSaAsruu0209", ReferenceType.keyValue, "", null, false, null, ER4108PosSaAsruu0209.getObjects()),
	R4109_SA0210 (4109, "PosSaAsruu0210", ReferenceType.keyValue, "", null, false, null, ER4109PosSaAsruu0210.getObjects()),
	R4110_SA0211 (4110, "PosSaAsruu0211", ReferenceType.keyValue, "", null, false, null, ER4110PosSaAsruu0211.getObjects()),
//	R4111_SA8888 (4111, "PosSaAsruu8888", ReferenceType.keyValue, "", null, false, null, ER4111PosSaAsruu8888.getObjects()),
//	R4112_SA9999 (4112, "PosSaAsruu9999", ReferenceType.keyValue, "", null, false, null, ER4112PosSaAsruu9999.getObjects()),
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
		for (EHeaderMetadataSaUus eEnum : EHeaderMetadataSaUus.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}

	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataSaUus eEnum : EHeaderMetadataSaUus.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
