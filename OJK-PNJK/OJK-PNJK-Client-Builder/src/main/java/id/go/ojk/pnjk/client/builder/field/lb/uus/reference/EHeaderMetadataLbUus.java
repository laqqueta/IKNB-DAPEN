package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

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
	R3100_LB0000 (ER3100PosLbPnju0000.getRefNumber(), ER3100PosLbPnju0000.getName(), ER3100PosLbPnju0000.getObjects()),
	R3101_LB0020 (ER3101PosLbPnju0020.getRefNumber(), ER3101PosLbPnju0020.getName(), ER3101PosLbPnju0020.getObjects()),
	R3102_LB0030 (ER3102PosLbPnju0030.getRefNumber(), ER3102PosLbPnju0030.getName(), ER3102PosLbPnju0030.getObjects()),
	R3103_LB1000 (ER3103PosLbPnju1000.getRefNumber(), ER3103PosLbPnju1000.getName(), ER3103PosLbPnju1000.getObjects()),
	R3104_LB1100 (ER3104PosLbPnju1100.getRefNumber(), ER3104PosLbPnju1100.getName(), ER3104PosLbPnju1100.getObjects()),
	R3105_LB1200 (ER3105PosLbPnju1200.getRefNumber(), ER3105PosLbPnju1200.getName(), ER3105PosLbPnju1200.getObjects()),
	R3106_LB1300 (ER3106PosLbPnju1300.getRefNumber(), ER3106PosLbPnju1300.getName(), ER3106PosLbPnju1300.getObjects()),
	R3107_LB2100A1 (ER3107PosLbPnju2100A1.getRefNumber(), ER3107PosLbPnju2100A1.getName(), ER3107PosLbPnju2100A1.getObjects()),
	R3108_LB2100A2 (ER3108PosLbPnju2100A2.getRefNumber(), ER3108PosLbPnju2100A2.getName(), ER3108PosLbPnju2100A2.getObjects()),
	R3109_LB2100B1 (ER3109PosLbPnju2100B1.getRefNumber(), ER3109PosLbPnju2100B1.getName(), ER3109PosLbPnju2100B1.getObjects()),
	R3110_LB2100B2 (ER3110PosLbPnju2100B2.getRefNumber(), ER3110PosLbPnju2100B2.getName(), ER3110PosLbPnju2100B2.getObjects()),
	R3111_LB2100B3 (ER3111PosLbPnju2100B3.getRefNumber(), ER3111PosLbPnju2100B3.getName(), ER3111PosLbPnju2100B3.getObjects()),
	R3112_LB2100C1 (ER3112PosLbPnju2100C1.getRefNumber(), ER3112PosLbPnju2100C1.getName(), ER3112PosLbPnju2100C1.getObjects()),
	R3113_LB2100C2 (ER3113PosLbPnju2100C2.getRefNumber(), ER3113PosLbPnju2100C2.getName(), ER3113PosLbPnju2100C2.getObjects()),
	R3114_LB2100D1 (ER3114PosLbPnju2100D1.getRefNumber(), ER3114PosLbPnju2100D1.getName(), ER3114PosLbPnju2100D1.getObjects()),
	R3115_LB2100D2 (ER3115PosLbPnju2100D2.getRefNumber(), ER3115PosLbPnju2100D2.getName(), ER3115PosLbPnju2100D2.getObjects()),
	R3116_LB2200 (ER3116PosLbPnju2200.getRefNumber(), ER3116PosLbPnju2200.getName(), ER3116PosLbPnju2200.getObjects()),
	R3117_LB2300 (ER3117PosLbPnju2300.getRefNumber(), ER3117PosLbPnju2300.getName(), ER3117PosLbPnju2300.getObjects()),
	R3118_LB2400 (ER3118PosLbPnju2400.getRefNumber(), ER3118PosLbPnju2400.getName(), ER3118PosLbPnju2400.getObjects()),
	R3119_LB2500 (ER3119PosLbPnju2500.getRefNumber(), ER3119PosLbPnju2500.getName(), ER3119PosLbPnju2500.getObjects()),
	R3120_LB2600 (ER3120PosLbPnju2600.getRefNumber(), ER3120PosLbPnju2600.getName(), ER3120PosLbPnju2600.getObjects()),
	R3121_LB2700 (ER3121PosLbPnju2700.getRefNumber(), ER3121PosLbPnju2700.getName(), ER3121PosLbPnju2700.getObjects()),
	R3122_LB2800 (ER3122PosLbPnju2800.getRefNumber(), ER3122PosLbPnju2800.getName(), ER3122PosLbPnju2800.getObjects()),
	R3123_LB2900 (ER3123PosLbPnju2900.getRefNumber(), ER3123PosLbPnju2900.getName(), ER3123PosLbPnju2900.getObjects()),
	R3124_LB3000 (ER3124PosLbPnju3000.getRefNumber(), ER3124PosLbPnju3000.getName(), ER3124PosLbPnju3000.getObjects()),
	R3125_LB3100 (ER3125PosLbPnju3100.getRefNumber(), ER3125PosLbPnju3100.getName(), ER3125PosLbPnju3100.getObjects()),
	R3126_LB3200A (ER3126PosLbPnju3200A.getRefNumber(), ER3126PosLbPnju3200A.getName(), ER3126PosLbPnju3200A.getObjects()),
	R3127_LB3200B (ER3127PosLbPnju3200B.getRefNumber(), ER3127PosLbPnju3200B.getName(), ER3127PosLbPnju3200B.getObjects()),
	R3128_LB3300A (ER3128PosLbPnju3300A.getRefNumber(), ER3128PosLbPnju3300A.getName(), ER3128PosLbPnju3300A.getObjects()),
	R3129_LB3300B (ER3129PosLbPnju3300B.getRefNumber(), ER3129PosLbPnju3300B.getName(), ER3129PosLbPnju3300B.getObjects()),
	R3130_LB3400A (ER3130PosLbPnju3400A.getRefNumber(), ER3130PosLbPnju3400A.getName(), ER3130PosLbPnju3400A.getObjects()),
	R3131_LB3400B (ER3131PosLbPnju3400B.getRefNumber(), ER3131PosLbPnju3400B.getName(), ER3131PosLbPnju3400B.getObjects()),
	R3132_LB3500A (ER3132PosLbPnju3500A.getRefNumber(), ER3132PosLbPnju3500A.getName(), ER3132PosLbPnju3500A.getObjects()),
	R3133_LB3500B (ER3133PosLbPnju3500B.getRefNumber(), ER3133PosLbPnju3500B.getName(), ER3133PosLbPnju3500B.getObjects()),
	R3134_LB4100 (ER3134PosLbPnju4100.getRefNumber(), ER3134PosLbPnju4100.getName(), ER3134PosLbPnju4100.getObjects()),
	R3135_LB5100 (ER3135PosLbPnju5100.getRefNumber(), ER3135PosLbPnju5100.getName(), ER3135PosLbPnju5100.getObjects()),
	R3136_LB6100 (ER3136PosLbPnju6100.getRefNumber(), ER3136PosLbPnju6100.getName(), ER3136PosLbPnju6100.getObjects()),
	R3137_LB7100 (ER3137PosLbPnju7100.getRefNumber(), ER3137PosLbPnju7100.getName(), ER3137PosLbPnju7100.getObjects()),
	R3138_LB8100 (ER3138PosLbPnju8100.getRefNumber(), ER3138PosLbPnju8100.getName(), ER3138PosLbPnju8100.getObjects()),
	R3139_LB9100 (ER3139PosLbPnju9100.getRefNumber(), ER3139PosLbPnju9100.getName(), ER3139PosLbPnju9100.getObjects()),
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
