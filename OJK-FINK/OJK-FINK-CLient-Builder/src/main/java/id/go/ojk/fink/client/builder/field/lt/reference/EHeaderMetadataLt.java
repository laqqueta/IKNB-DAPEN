package id.go.ojk.fink.client.builder.field.lt.reference;

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
	R6000_LT0000(ER6000PosLtFink0000.getRefNumber(), ER6000PosLtFink0000.getName(), ER6000PosLtFink0000.getObjects()),
	R6001_LT1100(ER6001PosLtFink1100.getRefNumber(), ER6001PosLtFink1100.getName(), ER6001PosLtFink1100.getObjects()),
	R6002_LT1200(ER6002PosLtFink1200.getRefNumber(), ER6002PosLtFink1200.getName(), ER6002PosLtFink1200.getObjects()),
	R6003_LT1201(ER6003PosLtFink1201.getRefNumber(), ER6003PosLtFink1201.getName(), ER6003PosLtFink1201.getObjects()),
	R6004_LT1300(ER6004PosLtFink1300.getRefNumber(), ER6004PosLtFink1300.getName(), ER6004PosLtFink1300.getObjects()),
//	R6005_LT8800(ER6005PosLtFink8800.getRefNumber(), ER6005PosLtFink8800.getName(), ER6005PosLtFink8800.getObjects()),
	R6006_LT2111(ER6006PosLtFink2111.getRefNumber(), ER6006PosLtFink2111.getName(), ER6006PosLtFink2111.getObjects()),
	R6007_LT2112(ER6007PosLtFink2112.getRefNumber(), ER6007PosLtFink2112.getName(), ER6007PosLtFink2112.getObjects()),
	R6008_LT2116(ER6008PosLtFink2116.getRefNumber(), ER6008PosLtFink2116.getName(), ER6008PosLtFink2116.getObjects()),
	R6009_LT2113(ER6009PosLtFink2113.getRefNumber(), ER6009PosLtFink2113.getName(), ER6009PosLtFink2113.getObjects()),
	R6010_LT2114(ER6010PosLtFink2114.getRefNumber(), ER6010PosLtFink2114.getName(), ER6010PosLtFink2114.getObjects()),
	R6011_LT2117(ER6011PosLtFink2117.getRefNumber(), ER6011PosLtFink2117.getName(), ER6011PosLtFink2117.getObjects()),
	R6012_LT2115(ER6012PosLtFink2115.getRefNumber(), ER6012PosLtFink2115.getName(), ER6012PosLtFink2115.getObjects()),
	R6013_LT2118(ER6013PosLtFink2118.getRefNumber(), ER6013PosLtFink2118.getName(), ER6013PosLtFink2118.getObjects()),
	R6014_LT2913(ER6014PosLtFink2913.getRefNumber(), ER6014PosLtFink2913.getName(), ER6014PosLtFink2913.getObjects()),
	R6015_LT2119(ER6015PosLtFink2119.getRefNumber(), ER6015PosLtFink2119.getName(), ER6015PosLtFink2119.getObjects()),
	R6016_LT2310(ER6016PosLtFink2310.getRefNumber(), ER6016PosLtFink2310.getName(), ER6016PosLtFink2310.getObjects()),
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
