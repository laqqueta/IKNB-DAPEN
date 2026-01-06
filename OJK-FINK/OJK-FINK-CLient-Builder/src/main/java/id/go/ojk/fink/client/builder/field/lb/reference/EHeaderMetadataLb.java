package id.go.ojk.fink.client.builder.field.lb.reference;

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
	R3000_LB0000(ER3000PosLbFink0000.getRefNumber(), ER3000PosLbFink0000.getName(), ER3000PosLbFink0000.getObjects()),
	R3001_LB0001(ER3001PosLbFink0001.getRefNumber(), ER3001PosLbFink0001.getName(), ER3001PosLbFink0001.getObjects()),
	R3002_LB0002(ER3002PosLbFink0002.getRefNumber(), ER3002PosLbFink0002.getName(), ER3002PosLbFink0002.getObjects()),
	R3003_LB0003(ER3003PosLbFink0003.getRefNumber(), ER3003PosLbFink0003.getName(), ER3003PosLbFink0003.getObjects()),
	R3004_LB1100(ER3004PosLbFink1100.getRefNumber(), ER3004PosLbFink1100.getName(), ER3004PosLbFink1100.getObjects()),
	R3005_LB1200(ER3005PosLbFink1200.getRefNumber(), ER3005PosLbFink1200.getName(), ER3005PosLbFink1200.getObjects()),
	R3006_LB1201(ER3006PosLbFink1201.getRefNumber(), ER3006PosLbFink1201.getName(), ER3006PosLbFink1201.getObjects()),
	R3007_LB1300(ER3007PosLbFink1300.getRefNumber(), ER3007PosLbFink1300.getName(), ER3007PosLbFink1300.getObjects()),
//	R3008_LB8800(ER3008PosLbFink8800.getRefNumber(), ER3008PosLbFink8800.getName(), ER3008PosLbFink8800.getObjects()),
	R3009_LB6901(ER3009PosLbFink6901.getRefNumber(), ER3009PosLbFink6901.getName(), ER3009PosLbFink6901.getObjects()),
	R3010_LB6902(ER3010PosLbFink6902.getRefNumber(), ER3010PosLbFink6902.getName(), ER3010PosLbFink6902.getObjects()),
	R3011_LB6903(ER3011PosLbFink6903.getRefNumber(), ER3011PosLbFink6903.getName(), ER3011PosLbFink6903.getObjects()),
	R3012_LB2907(ER3012PosLbFink2907.getRefNumber(), ER3012PosLbFink2907.getName(), ER3012PosLbFink2907.getObjects()),
	R3013_LB6908(ER3013PosLbFink6908.getRefNumber(), ER3013PosLbFink6908.getName(), ER3013PosLbFink6908.getObjects()),
	R3014_LB6910(ER3014PosLbFink6910.getRefNumber(), ER3014PosLbFink6910.getName(), ER3014PosLbFink6910.getObjects()),
	R3015_LB6909(ER3015PosLbFink6909.getRefNumber(), ER3015PosLbFink6909.getName(), ER3015PosLbFink6909.getObjects()),
	R3016_LB2111(ER3016PosLbFink2111.getRefNumber(), ER3016PosLbFink2111.getName(), ER3016PosLbFink2111.getObjects()),
	R3017_LB2112(ER3017PosLbFink2112.getRefNumber(), ER3017PosLbFink2112.getName(), ER3017PosLbFink2112.getObjects()),
	R3018_LB2116(ER3018PosLbFink2116.getRefNumber(), ER3018PosLbFink2116.getName(), ER3018PosLbFink2116.getObjects()),
	R3019_LB2113(ER3019PosLbFink2113.getRefNumber(), ER3019PosLbFink2113.getName(), ER3019PosLbFink2113.getObjects()),
	R3020_LB2114(ER3020PosLbFink2114.getRefNumber(), ER3020PosLbFink2114.getName(), ER3020PosLbFink2114.getObjects()),
	R3021_LB2115(ER3021PosLbFink2115.getRefNumber(), ER3021PosLbFink2115.getName(), ER3021PosLbFink2115.getObjects()),
	R3022_LB2117(ER3022PosLbFink2117.getRefNumber(), ER3022PosLbFink2117.getName(), ER3022PosLbFink2117.getObjects()),
	R3023_LB2120(ER3023PosLbFink2120.getRefNumber(), ER3023PosLbFink2120.getName(), ER3023PosLbFink2120.getObjects()),
	R3024_LB2121(ER3024PosLbFink2121.getRefNumber(), ER3024PosLbFink2121.getName(), ER3024PosLbFink2121.getObjects()),
	R3025_LB2119(ER3025PosLbFink2119.getRefNumber(), ER3025PosLbFink2119.getName(), ER3025PosLbFink2119.getObjects()),
	R3026_LB2118(ER3026PosLbFink2118.getRefNumber(), ER3026PosLbFink2118.getName(), ER3026PosLbFink2118.getObjects()),
	R3027_LB2913(ER3027PosLbFink2913.getRefNumber(), ER3027PosLbFink2913.getName(), ER3027PosLbFink2913.getObjects()),
	R3028_LB2310(ER3028PosLbFink2310.getRefNumber(), ER3028PosLbFink2310.getName(), ER3028PosLbFink2310.getObjects()),
	R3029_LB2910(ER3029PosLbFink2910.getRefNumber(), ER3029PosLbFink2910.getName(), ER3029PosLbFink2910.getObjects()),
	R3030_LB2122(ER3030PosLbFink2122.getRefNumber(), ER3030PosLbFink2122.getName(), ER3030PosLbFink2122.getObjects()),
	R3031_LB2911(ER3031PosLbFink2911.getRefNumber(), ER3031PosLbFink2911.getName(), ER3031PosLbFink2911.getObjects()),
	R3032_LB2912(ER3032PosLbFink2912.getRefNumber(), ER3032PosLbFink2912.getName(), ER3032PosLbFink2912.getObjects()),
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
