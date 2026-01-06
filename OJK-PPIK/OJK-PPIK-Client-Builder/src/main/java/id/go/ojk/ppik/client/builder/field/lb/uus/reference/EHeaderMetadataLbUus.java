package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;

public enum EHeaderMetadataLbUus implements IObject<ReferenceMetadata> {
	R3100_LB0000 (ER3100PosLbPpiu0000.getRefNumber(), ER3100PosLbPpiu0000.getName(), ER3100PosLbPpiu0000.getObjects()),
	R3101_LB0010 (ER3101PosLbPpiu0010.getRefNumber(), ER3101PosLbPpiu0010.getName(), ER3101PosLbPpiu0010.getObjects()),
	R3102_LB0020 (ER3102PosLbPpiu0020.getRefNumber(), ER3102PosLbPpiu0020.getName(), ER3102PosLbPpiu0020.getObjects()),
	R3104_LB0035 (ER3103PosLbPpiu0035.getRefNumber(), ER3103PosLbPpiu0035.getName(), ER3103PosLbPpiu0035.getObjects()),
	R3105_LB0036 (ER3104PosLbPpiu0036.getRefNumber(), ER3104PosLbPpiu0036.getName(), ER3104PosLbPpiu0036.getObjects()),
	R3106_LB0041 (ER3105PosLbPpiu0041.getRefNumber(), ER3105PosLbPpiu0041.getName(), ER3105PosLbPpiu0041.getObjects()),
	R3107_LB0043 (ER3106PosLbPpiu0043.getRefNumber(), ER3106PosLbPpiu0043.getName(), ER3106PosLbPpiu0043.getObjects()),
	R3108_LB0046 (ER3107PosLbPpiu0046.getRefNumber(), ER3107PosLbPpiu0046.getName(), ER3107PosLbPpiu0046.getObjects()),
	R3109_LB1100 (ER3108PosLbPpiu1100.getRefNumber(), ER3108PosLbPpiu1100.getName(), ER3108PosLbPpiu1100.getObjects()),
	R3110_LB1110 (ER3109PosLbPpiu1110.getRefNumber(), ER3109PosLbPpiu1110.getName(), ER3109PosLbPpiu1110.getObjects()),
	R3111_LB1200 (ER3110PosLbPpiu1200.getRefNumber(), ER3110PosLbPpiu1200.getName(), ER3110PosLbPpiu1200.getObjects()),
	R3112_LB1300 (ER3111PosLbPpiu1300.getRefNumber(), ER3111PosLbPpiu1300.getName(), ER3111PosLbPpiu1300.getObjects()),
	R3113_LB2100 (ER3112PosLbPpiu2100.getRefNumber(), ER3112PosLbPpiu2100.getName(), ER3112PosLbPpiu2100.getObjects()),
	R3114_LB2150 (ER3113PosLbPpiu2150.getRefNumber(), ER3113PosLbPpiu2150.getName(), ER3113PosLbPpiu2150.getObjects()),
	R3115_LB2200 (ER3114PosLbPpiu2200.getRefNumber(), ER3114PosLbPpiu2200.getName(), ER3114PosLbPpiu2200.getObjects()),
	R3116_LB2300 (ER3115PosLbPpiu2300.getRefNumber(), ER3115PosLbPpiu2300.getName(), ER3115PosLbPpiu2300.getObjects()),
	R3117_LB2350 (ER3116PosLbPpiu2350.getRefNumber(), ER3116PosLbPpiu2350.getName(), ER3116PosLbPpiu2350.getObjects()),
	R3118_LB2380 (ER3117PosLbPpiu2380.getRefNumber(), ER3117PosLbPpiu2380.getName(), ER3117PosLbPpiu2380.getObjects()),
	R3119_LB2490 (ER3118PosLbPpiu2490.getRefNumber(), ER3118PosLbPpiu2490.getName(), ER3118PosLbPpiu2490.getObjects()),
	R3120_LB2550 (ER3119PosLbPpiu2550.getRefNumber(), ER3119PosLbPpiu2550.getName(), ER3119PosLbPpiu2550.getObjects()),
	R3121_LB2600 (ER3120PosLbPpiu2600.getRefNumber(), ER3120PosLbPpiu2600.getName(), ER3120PosLbPpiu2600.getObjects()),
	R3122_LB2790 (ER3121PosLbPpiu2790.getRefNumber(), ER3121PosLbPpiu2790.getName(), ER3121PosLbPpiu2790.getObjects()),
	R3123_LB3010 (ER3122PosLbPpiu3010.getRefNumber(), ER3122PosLbPpiu3010.getName(), ER3122PosLbPpiu3010.getObjects()),
	R3124_LB5310 (ER3123PosLbPpiu5310.getRefNumber(), ER3123PosLbPpiu5310.getName(), ER3123PosLbPpiu5310.getObjects()),
	;

	private int number;
	private String name;
	private List<KeyValueString> references;

	private EHeaderMetadataLbUus(int number, String name, List<KeyValueString> references) {
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
