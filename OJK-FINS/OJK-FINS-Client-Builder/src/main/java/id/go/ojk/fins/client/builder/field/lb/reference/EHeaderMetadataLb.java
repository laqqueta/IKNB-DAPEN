package id.go.ojk.fins.client.builder.field.lb.reference;

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
	R3000_LB0000(ER3000PosLbFins0000.getRefNumber(), ER3000PosLbFins0000.getName(), ER3000PosLbFins0000.getObjects()),
	R3001_LB0001(ER3001PosLbFins0001.getRefNumber(), ER3001PosLbFins0001.getName(), ER3001PosLbFins0001.getObjects()),
	R3002_LB0002(ER3002PosLbFins0002.getRefNumber(), ER3002PosLbFins0002.getName(), ER3002PosLbFins0002.getObjects()),
	R3003_LB0003(ER3003PosLbFins0003.getRefNumber(), ER3003PosLbFins0003.getName(), ER3003PosLbFins0003.getObjects()),
	R3004_LB1100(ER3004PosLbFins1100.getRefNumber(), ER3004PosLbFins1100.getName(), ER3004PosLbFins1100.getObjects()),
	R3005_LB1200(ER3005PosLbFins1200.getRefNumber(), ER3005PosLbFins1200.getName(), ER3005PosLbFins1200.getObjects()),
	R3006_LB1201(ER3006PosLbFins1201.getRefNumber(), ER3006PosLbFins1201.getName(), ER3006PosLbFins1201.getObjects()),
	R3007_LB1300(ER3007PosLbFins1300.getRefNumber(), ER3007PosLbFins1300.getName(), ER3007PosLbFins1300.getObjects()),
//	R3008_LB8800(ER3008PosLbFins8800.getRefNumber(), ER3008PosLbFink8800.getName(), ER3008PosLbFink8800.getObjects()),
	R3009_LB6901(ER3009PosLbFins6901.getRefNumber(), ER3009PosLbFins6901.getName(), ER3009PosLbFins6901.getObjects()),
	R3010_LB6902(ER3010PosLbFins6902.getRefNumber(), ER3010PosLbFins6902.getName(), ER3010PosLbFins6902.getObjects()),
	R3011_LB6903(ER3011PosLbFins6903.getRefNumber(), ER3011PosLbFins6903.getName(), ER3011PosLbFins6903.getObjects()),
	R3012_LB2907(ER3012PosLbFins2907.getRefNumber(), ER3012PosLbFins2907.getName(), ER3012PosLbFins2907.getObjects()),
	R3013_LB6908(ER3013PosLbFins6908.getRefNumber(), ER3013PosLbFins6908.getName(), ER3013PosLbFins6908.getObjects()),
	R3014_LB6910(ER3014PosLbFins6910.getRefNumber(), ER3014PosLbFins6910.getName(), ER3014PosLbFins6910.getObjects()),
	R3015_LB6909(ER3015PosLbFins6909.getRefNumber(), ER3015PosLbFins6909.getName(), ER3015PosLbFins6909.getObjects()),
	R3016_LB2111(ER3016PosLbFins2111.getRefNumber(), ER3016PosLbFins2111.getName(), ER3016PosLbFins2111.getObjects()),
	R3017_LB2112(ER3017PosLbFins2112.getRefNumber(), ER3017PosLbFins2112.getName(), ER3017PosLbFins2112.getObjects()),
	R3018_LB2116(ER3018PosLbFins2116.getRefNumber(), ER3018PosLbFins2116.getName(), ER3018PosLbFins2116.getObjects()),
	R3019_LB2113(ER3019PosLbFins2113.getRefNumber(), ER3019PosLbFins2113.getName(), ER3019PosLbFins2113.getObjects()),
	R3020_LB2114(ER3020PosLbFins2114.getRefNumber(), ER3020PosLbFins2114.getName(), ER3020PosLbFins2114.getObjects()),
	R3021_LB2115(ER3021PosLbFins2115.getRefNumber(), ER3021PosLbFins2115.getName(), ER3021PosLbFins2115.getObjects()),
	R3022_LB2117(ER3022PosLbFins2117.getRefNumber(), ER3022PosLbFins2117.getName(), ER3022PosLbFins2117.getObjects()),
	R3023_LB2120(ER3023PosLbFins2120.getRefNumber(), ER3023PosLbFins2120.getName(), ER3023PosLbFins2120.getObjects()),
	R3024_LB2121(ER3024PosLbFins2121.getRefNumber(), ER3024PosLbFins2121.getName(), ER3024PosLbFins2121.getObjects()),
	R3025_LB2119(ER3025PosLbFins2119.getRefNumber(), ER3025PosLbFins2119.getName(), ER3025PosLbFins2119.getObjects()),
	R3026_LB2118(ER3026PosLbFins2118.getRefNumber(), ER3026PosLbFins2118.getName(), ER3026PosLbFins2118.getObjects()),
	R3027_LB2913(ER3027PosLbFins2913.getRefNumber(), ER3027PosLbFins2913.getName(), ER3027PosLbFins2913.getObjects()),
	R3028_LB2310(ER3028PosLbFins2310.getRefNumber(), ER3028PosLbFins2310.getName(), ER3028PosLbFins2310.getObjects()),
	R3029_LB2910(ER3029PosLbFins2910.getRefNumber(), ER3029PosLbFins2910.getName(), ER3029PosLbFins2910.getObjects()),
	R3030_LB2122(ER3030PosLbFins2122.getRefNumber(), ER3030PosLbFins2122.getName(), ER3030PosLbFins2122.getObjects()),
	R3031_LB2911(ER3031PosLbFins2911.getRefNumber(), ER3031PosLbFins2911.getName(), ER3031PosLbFins2911.getObjects()),
	R3032_LB2912(ER3032PosLbFins2912.getRefNumber(), ER3032PosLbFins2912.getName(), ER3032PosLbFins2912.getObjects()),
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
