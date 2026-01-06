package id.go.ojk.fins.client.builder.field.lt.reference;

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
public enum EHeaderMetadataLt implements IObject<ReferenceMetadata> {
	R6000_LT0000(ER6000PosLtFins0000.getRefNumber(), ER6000PosLtFins0000.getName(), ER6000PosLtFins0000.getObjects()),
	R6001_LT1100(ER6001PosLtFins1100.getRefNumber(), ER6001PosLtFins1100.getName(), ER6001PosLtFins1100.getObjects()),
	R6002_LT1200(ER6002PosLtFins1200.getRefNumber(), ER6002PosLtFins1200.getName(), ER6002PosLtFins1200.getObjects()),
	R6003_LT1201(ER6003PosLtFins1201.getRefNumber(), ER6003PosLtFins1201.getName(), ER6003PosLtFins1201.getObjects()),
	R6004_LT1300(ER6004PosLtFins1300.getRefNumber(), ER6004PosLtFins1300.getName(), ER6004PosLtFins1300.getObjects()),
//	R6005_LT8800(ER6005PosLtFins8800.getRefNumber(), ER6005PosLtFink8800.getName(), ER6005PosLtFink8800.getObjects()),
	R6006_LT2111(ER6006PosLtFins2111.getRefNumber(), ER6006PosLtFins2111.getName(), ER6006PosLtFins2111.getObjects()),
	R6007_LT2112(ER6007PosLtFins2112.getRefNumber(), ER6007PosLtFins2112.getName(), ER6007PosLtFins2112.getObjects()),
	R6008_LT2116(ER6008PosLtFins2116.getRefNumber(), ER6008PosLtFins2116.getName(), ER6008PosLtFins2116.getObjects()),
	R6009_LT2113(ER6009PosLtFins2113.getRefNumber(), ER6009PosLtFins2113.getName(), ER6009PosLtFins2113.getObjects()),
	R6010_LT2114(ER6010PosLtFins2114.getRefNumber(), ER6010PosLtFins2114.getName(), ER6010PosLtFins2114.getObjects()),
	R6011_LT2117(ER6011PosLtFins2117.getRefNumber(), ER6011PosLtFins2117.getName(), ER6011PosLtFins2117.getObjects()),
	R6012_LT2115(ER6012PosLtFins2115.getRefNumber(), ER6012PosLtFins2115.getName(), ER6012PosLtFins2115.getObjects()),
	R6013_LT2118(ER6013PosLtFins2118.getRefNumber(), ER6013PosLtFins2118.getName(), ER6013PosLtFins2118.getObjects()),
	R6014_LT2913(ER6014PosLtFins2913.getRefNumber(), ER6014PosLtFins2913.getName(), ER6014PosLtFins2913.getObjects()),
	R6015_LT2119(ER6015PosLtFins2119.getRefNumber(), ER6015PosLtFins2119.getName(), ER6015PosLtFins2119.getObjects()),
	R6016_LT2310(ER6016PosLtFins2310.getRefNumber(), ER6016PosLtFins2310.getName(), ER6016PosLtFins2310.getObjects()),
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
		for (EHeaderMetadataLt eEnum : EHeaderMetadataLt.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataLt eEnum : EHeaderMetadataLt.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
