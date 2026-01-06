package id.go.ojk.asrjk.client.builder.field.sa.uus.reference;

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
public enum EHeaderMetadataSaUus implements IObject<ReferenceMetadata> {
	R4100_SA0201 (ER4100PosSaAsrju0201.getRefNumber(), ER4100PosSaAsrju0201.getName(), ER4100PosSaAsrju0201.getObjects()),
	R4101_SA0202 (ER4101PosSaAsrju0202.getRefNumber(), ER4101PosSaAsrju0202.getName(), ER4101PosSaAsrju0202.getObjects()),
	R4102_SA0203 (ER4102PosSaAsrju0203.getRefNumber(), ER4102PosSaAsrju0203.getName(), ER4102PosSaAsrju0203.getObjects()),
	R4103_SA0204 (ER4103PosSaAsrju0204.getRefNumber(), ER4103PosSaAsrju0204.getName(), ER4103PosSaAsrju0204.getObjects()),
	R4104_SA0205 (ER4104PosSaAsrju0205.getRefNumber(), ER4104PosSaAsrju0205.getName(), ER4104PosSaAsrju0205.getObjects()),
	R4105_SA0206 (ER4105PosSaAsrju0206.getRefNumber(), ER4105PosSaAsrju0206.getName(), ER4105PosSaAsrju0206.getObjects()),
	R4106_SA0207 (ER4106PosSaAsrju0207.getRefNumber(), ER4106PosSaAsrju0207.getName(), ER4106PosSaAsrju0207.getObjects()),
	R4107_SA0208 (ER4107PosSaAsrju0208.getRefNumber(), ER4107PosSaAsrju0208.getName(), ER4107PosSaAsrju0208.getObjects()),
	R4108_SA0209 (ER4108PosSaAsrju0209.getRefNumber(), ER4108PosSaAsrju0209.getName(), ER4108PosSaAsrju0209.getObjects()),
	R4109_SA0210 (ER4109PosSaAsrju0210.getRefNumber(), ER4109PosSaAsrju0210.getName(), ER4109PosSaAsrju0210.getObjects()),
	R4110_SA0211 (ER4110PosSaAsrju0211.getRefNumber(), ER4110PosSaAsrju0211.getName(), ER4110PosSaAsrju0211.getObjects()),
//	R4111_SA8888 (ER4111PosSaAsrju8888.getRefNumber(), ER4111PosSaAsrju8888.getName(), ER4111PosSaAsrju8888.getObjects()),
//	R4112_SA9999 (ER4112PosSaAsrju9999.getRefNumber(), ER4112PosSaAsrju9999.getName(), ER4112PosSaAsrju9999.getObjects()),
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
		for (EHeaderMetadataSaUus eEnum : EHeaderMetadataSaUus.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataSaUus eEnum : EHeaderMetadataSaUus.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
