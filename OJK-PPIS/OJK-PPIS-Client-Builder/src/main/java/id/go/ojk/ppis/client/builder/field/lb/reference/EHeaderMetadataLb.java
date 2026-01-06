package id.go.ojk.ppis.client.builder.field.lb.reference;

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
	R3000_LB0000 (ER3000PosLbPpis0000.getRefNumber(), ER3000PosLbPpis0000.getName(), ER3000PosLbPpis0000.getObjects()),
	R3001_LB0010 (ER3001PosLbPpis0010.getRefNumber(), ER3001PosLbPpis0010.getName(), ER3001PosLbPpis0010.getObjects()),
	R3002_LB0020 (ER3002PosLbPpis0020.getRefNumber(), ER3002PosLbPpis0020.getName(), ER3002PosLbPpis0020.getObjects()),
	R3003_LB0030 (ER3003PosLbPpis0030.getRefNumber(), ER3003PosLbPpis0030.getName(), ER3003PosLbPpis0030.getObjects()),
	R3004_LB0035 (ER3004PosLbPpis0035.getRefNumber(), ER3004PosLbPpis0035.getName(), ER3004PosLbPpis0035.getObjects()),
	R3005_LB0036 (ER3005PosLbPpis0036.getRefNumber(), ER3005PosLbPpis0036.getName(), ER3005PosLbPpis0036.getObjects()),
	R3006_LB0041 (ER3006PosLbPpis0041.getRefNumber(), ER3006PosLbPpis0041.getName(), ER3006PosLbPpis0041.getObjects()),
	R3007_LB0043 (ER3007PosLbPpis0043.getRefNumber(), ER3007PosLbPpis0043.getName(), ER3007PosLbPpis0043.getObjects()),
	R3008_LB0046 (ER3008PosLbPpis0046.getRefNumber(), ER3008PosLbPpis0046.getName(), ER3008PosLbPpis0046.getObjects()),
	R3009_LB1100 (ER3009PosLbPpis1100.getRefNumber(), ER3009PosLbPpis1100.getName(), ER3009PosLbPpis1100.getObjects()),
	R3010_LB1110 (ER3010PosLbPpis1110.getRefNumber(), ER3010PosLbPpis1110.getName(), ER3010PosLbPpis1110.getObjects()),
	R3011_LB1200 (ER3011PosLbPpis1200.getRefNumber(), ER3011PosLbPpis1200.getName(), ER3011PosLbPpis1200.getObjects()),
	R3012_LB1300 (ER3012PosLbPpis1300.getRefNumber(), ER3012PosLbPpis1300.getName(), ER3012PosLbPpis1300.getObjects()),
	R3013_LB2100 (ER3013PosLbPpis2100.getRefNumber(), ER3013PosLbPpis2100.getName(), ER3013PosLbPpis2100.getObjects()),
	R3014_LB2150 (ER3014PosLbPpis2150.getRefNumber(), ER3014PosLbPpis2150.getName(), ER3014PosLbPpis2150.getObjects()),
	R3015_LB2200 (ER3015PosLbPpis2200.getRefNumber(), ER3015PosLbPpis2200.getName(), ER3015PosLbPpis2200.getObjects()),
	R3016_LB2300 (ER3016PosLbPpis2300.getRefNumber(), ER3016PosLbPpis2300.getName(), ER3016PosLbPpis2300.getObjects()),
	R3017_LB2350 (ER3017PosLbPpis2350.getRefNumber(), ER3017PosLbPpis2350.getName(), ER3017PosLbPpis2350.getObjects()),
	R3018_LB2380 (ER3018PosLbPpis2380.getRefNumber(), ER3018PosLbPpis2380.getName(), ER3018PosLbPpis2380.getObjects()),
	R3019_LB2490 (ER3019PosLbPpis2490.getRefNumber(), ER3019PosLbPpis2490.getName(), ER3019PosLbPpis2490.getObjects()),
	R3020_LB2550 (ER3020PosLbPpis2550.getRefNumber(), ER3020PosLbPpis2550.getName(), ER3020PosLbPpis2550.getObjects()),
	R3021_LB2600 (ER3021PosLbPpis2600.getRefNumber(), ER3021PosLbPpis2600.getName(), ER3021PosLbPpis2600.getObjects()),
	R3022_LB2790 (ER3022PosLbPpis2790.getRefNumber(), ER3022PosLbPpis2790.getName(), ER3022PosLbPpis2790.getObjects()),
	R3023_LB3010 (ER3023PosLbPpis3010.getRefNumber(), ER3023PosLbPpis3010.getName(), ER3023PosLbPpis3010.getObjects()),
	R3024_LB5310 (ER3024PosLbPpis5310.getRefNumber(), ER3024PosLbPpis5310.getName(), ER3024PosLbPpis5310.getObjects()),
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
