package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

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
public enum EHeaderMetadataLbUus implements IObject<ReferenceMetadata> {
	R3100_LB0000(ER3100PosLbPnmu0000.getRefNumber(), ER3100PosLbPnmu0000.getName(), ER3100PosLbPnmu0000.getObjects()),
	R3101_LB0020(ER3101PosLbPnmu0020.getRefNumber(), ER3101PosLbPnmu0020.getName(), ER3101PosLbPnmu0020.getObjects()),
	R3102_LB0030(ER3102PosLbPnmu0030.getRefNumber(), ER3102PosLbPnmu0030.getName(), ER3102PosLbPnmu0030.getObjects()),
	R3103_LB1100(ER3103PosLbPnmu1100.getRefNumber(), ER3103PosLbPnmu1100.getName(), ER3103PosLbPnmu1100.getObjects()),
	R3104_LB1200(ER3104PosLbPnmu1200.getRefNumber(), ER3104PosLbPnmu1200.getName(), ER3104PosLbPnmu1200.getObjects()),
	R3105_LB1300(ER3105PosLbPnmu1300.getRefNumber(), ER3105PosLbPnmu1300.getName(), ER3105PosLbPnmu1300.getObjects()),
	R3106_LB1400(ER3106PosLbPnmu1400.getRefNumber(), ER3106PosLbPnmu1400.getName(), ER3106PosLbPnmu1400.getObjects()),
	R3107_LB2100(ER3107PosLbPnmu2100.getRefNumber(), ER3107PosLbPnmu2100.getName(), ER3107PosLbPnmu2100.getObjects()),
	R3108_LB2200(ER3108PosLbPnmu2200.getRefNumber(), ER3108PosLbPnmu2200.getName(), ER3108PosLbPnmu2200.getObjects()),
	R3109_LB2300(ER3109PosLbPnmu2300.getRefNumber(), ER3109PosLbPnmu2300.getName(), ER3109PosLbPnmu2300.getObjects()),
	R3110_LB2400(ER3110PosLbPnmu2400.getRefNumber(), ER3110PosLbPnmu2400.getName(), ER3110PosLbPnmu2400.getObjects()),
	R3111_LB2500(ER3111PosLbPnmu2500.getRefNumber(), ER3111PosLbPnmu2500.getName(), ER3111PosLbPnmu2500.getObjects()),
	R3112_LB2600(ER3112PosLbPnmu2600.getRefNumber(), ER3112PosLbPnmu2600.getName(), ER3112PosLbPnmu2600.getObjects()),
	R3113_LB2700(ER3113PosLbPnmu2700.getRefNumber(), ER3113PosLbPnmu2700.getName(), ER3113PosLbPnmu2700.getObjects()),
	R3114_LB2800(ER3114PosLbPnmu2800.getRefNumber(), ER3114PosLbPnmu2800.getName(), ER3114PosLbPnmu2800.getObjects()),
	R3115_LB2900(ER3115PosLbPnmu2900.getRefNumber(), ER3115PosLbPnmu2900.getName(), ER3115PosLbPnmu2900.getObjects()),;

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
		return "Form " + name.substring(9); 
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
		for (EHeaderMetadataLbUus eEnum : EHeaderMetadataLbUus.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataLbUus eEnum : EHeaderMetadataLbUus.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
