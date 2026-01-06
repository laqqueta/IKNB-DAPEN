package id.go.ojk.pnjs.client.builder.field.lb.reference;

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
public enum EHeaderMetadataLb implements IObject<ReferenceMetadata> {
	R3000_LB0000 (ER3000PosLbPnjs0000.getRefNumber(), ER3000PosLbPnjs0000.getName(), ER3000PosLbPnjs0000.getObjects()),
	R3001_LB0020 (ER3001PosLbPnjs0020.getRefNumber(), ER3001PosLbPnjs0020.getName(), ER3001PosLbPnjs0020.getObjects()),
	R3002_LB0030 (ER3002PosLbPnjs0030.getRefNumber(), ER3002PosLbPnjs0030.getName(), ER3002PosLbPnjs0030.getObjects()),
	R3003_LB1000 (ER3003PosLbPnjs1000.getRefNumber(), ER3003PosLbPnjs1000.getName(), ER3003PosLbPnjs1000.getObjects()),
	R3004_LB1100 (ER3004PosLbPnjs1100.getRefNumber(), ER3004PosLbPnjs1100.getName(), ER3004PosLbPnjs1100.getObjects()),
	R3005_LB1200 (ER3005PosLbPnjs1200.getRefNumber(), ER3005PosLbPnjs1200.getName(), ER3005PosLbPnjs1200.getObjects()),
	R3006_LB1300 (ER3006PosLbPnjs1300.getRefNumber(), ER3006PosLbPnjs1300.getName(), ER3006PosLbPnjs1300.getObjects()),
	R3007_LB2100A1 (ER3007PosLbPnjs2100A1.getRefNumber(), ER3007PosLbPnjs2100A1.getName(), ER3007PosLbPnjs2100A1.getObjects()),
	R3008_LB2100A2 (ER3008PosLbPnjs2100A2.getRefNumber(), ER3008PosLbPnjs2100A2.getName(), ER3008PosLbPnjs2100A2.getObjects()),
	R3009_LB2100B1 (ER3009PosLbPnjs2100B1.getRefNumber(), ER3009PosLbPnjs2100B1.getName(), ER3009PosLbPnjs2100B1.getObjects()),
	R3010_LB2100B2 (ER3010PosLbPnjs2100B2.getRefNumber(), ER3010PosLbPnjs2100B2.getName(), ER3010PosLbPnjs2100B2.getObjects()),
	R3011_LB2100B3 (ER3011PosLbPnjs2100B3.getRefNumber(), ER3011PosLbPnjs2100B3.getName(), ER3011PosLbPnjs2100B3.getObjects()),
	R3012_LB2100C1 (ER3012PosLbPnjs2100C1.getRefNumber(), ER3012PosLbPnjs2100C1.getName(), ER3012PosLbPnjs2100C1.getObjects()),
	R3013_LB2100C2 (ER3013PosLbPnjs2100C2.getRefNumber(), ER3013PosLbPnjs2100C2.getName(), ER3013PosLbPnjs2100C2.getObjects()),
	R3014_LB2100D1 (ER3014PosLbPnjs2100D1.getRefNumber(), ER3014PosLbPnjs2100D1.getName(), ER3014PosLbPnjs2100D1.getObjects()),
	R3015_LB2100D2 (ER3015PosLbPnjs2100D2.getRefNumber(), ER3015PosLbPnjs2100D2.getName(), ER3015PosLbPnjs2100D2.getObjects()),
	R3016_LB2200 (ER3016PosLbPnjs2200.getRefNumber(), ER3016PosLbPnjs2200.getName(), ER3016PosLbPnjs2200.getObjects()),
	R3017_LB2300 (ER3017PosLbPnjs2300.getRefNumber(), ER3017PosLbPnjs2300.getName(), ER3017PosLbPnjs2300.getObjects()),
	R3018_LB2400 (ER3018PosLbPnjs2400.getRefNumber(), ER3018PosLbPnjs2400.getName(), ER3018PosLbPnjs2400.getObjects()),
	R3019_LB2500 (ER3019PosLbPnjs2500.getRefNumber(), ER3019PosLbPnjs2500.getName(), ER3019PosLbPnjs2500.getObjects()),
	R3020_LB2600 (ER3020PosLbPnjs2600.getRefNumber(), ER3020PosLbPnjs2600.getName(), ER3020PosLbPnjs2600.getObjects()),
	R3021_LB2700 (ER3021PosLbPnjs2700.getRefNumber(), ER3021PosLbPnjs2700.getName(), ER3021PosLbPnjs2700.getObjects()),
	R3022_LB2800 (ER3022PosLbPnjs2800.getRefNumber(), ER3022PosLbPnjs2800.getName(), ER3022PosLbPnjs2800.getObjects()),
	R3023_LB2900 (ER3023PosLbPnjs2900.getRefNumber(), ER3023PosLbPnjs2900.getName(), ER3023PosLbPnjs2900.getObjects()),
	R3024_LB3000 (ER3024PosLbPnjs3000.getRefNumber(), ER3024PosLbPnjs3000.getName(), ER3024PosLbPnjs3000.getObjects()),
	R3025_LB3100 (ER3025PosLbPnjs3100.getRefNumber(), ER3025PosLbPnjs3100.getName(), ER3025PosLbPnjs3100.getObjects()),
	R3026_LB3200A (ER3026PosLbPnjs3200A.getRefNumber(), ER3026PosLbPnjs3200A.getName(), ER3026PosLbPnjs3200A.getObjects()),
	R3027_LB3200B (ER3027PosLbPnjs3200B.getRefNumber(), ER3027PosLbPnjs3200B.getName(), ER3027PosLbPnjs3200B.getObjects()),
	R3028_LB3300A (ER3028PosLbPnjs3300A.getRefNumber(), ER3028PosLbPnjs3300A.getName(), ER3028PosLbPnjs3300A.getObjects()),
	R3029_LB3300B (ER3029PosLbPnjs3300B.getRefNumber(), ER3029PosLbPnjs3300B.getName(), ER3029PosLbPnjs3300B.getObjects()),
	R3030_LB3400A (ER3030PosLbPnjs3400A.getRefNumber(), ER3030PosLbPnjs3400A.getName(), ER3030PosLbPnjs3400A.getObjects()),
	R3031_LB3400B (ER3031PosLbPnjs3400B.getRefNumber(), ER3031PosLbPnjs3400B.getName(), ER3031PosLbPnjs3400B.getObjects()),
	R3032_LB3500A (ER3032PosLbPnjs3500A.getRefNumber(), ER3032PosLbPnjs3500A.getName(), ER3032PosLbPnjs3500A.getObjects()),
	R3033_LB3500B (ER3033PosLbPnjs3500B.getRefNumber(), ER3033PosLbPnjs3500B.getName(), ER3033PosLbPnjs3500B.getObjects()),
	R3034_LB4100 (ER3034PosLbPnjs4100.getRefNumber(), ER3034PosLbPnjs4100.getName(), ER3034PosLbPnjs4100.getObjects()),
	R3035_LB5100 (ER3035PosLbPnjs5100.getRefNumber(), ER3035PosLbPnjs5100.getName(), ER3035PosLbPnjs5100.getObjects()),
	R3036_LB6100 (ER3036PosLbPnjs6100.getRefNumber(), ER3036PosLbPnjs6100.getName(), ER3036PosLbPnjs6100.getObjects()),
	R3037_LB7100 (ER3037PosLbPnjs7100.getRefNumber(), ER3037PosLbPnjs7100.getName(), ER3037PosLbPnjs7100.getObjects()),
	R3038_LB8100 (ER3038PosLbPnjs8100.getRefNumber(), ER3038PosLbPnjs8100.getName(), ER3038PosLbPnjs8100.getObjects()),
	R3039_LB9100 (ER3039PosLbPnjs9100.getRefNumber(), ER3039PosLbPnjs9100.getName(), ER3039PosLbPnjs9100.getObjects()),
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
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataLb eEnum : EHeaderMetadataLb.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
