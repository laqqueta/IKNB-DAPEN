package id.go.ojk.pnmk.client.builder.field.lb.reference;

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
	R3000_LB0000(ER3000PosLbPnmk0000.getRefNumber(), ER3000PosLbPnmk0000.getName(), ER3000PosLbPnmk0000.getObjects()),
	R3001_LB0020(ER3001PosLbPnmk0020.getRefNumber(), ER3001PosLbPnmk0020.getName(), ER3001PosLbPnmk0020.getObjects()),
	R3002_LB0030(ER3002PosLbPnmk0030.getRefNumber(), ER3002PosLbPnmk0030.getName(), ER3002PosLbPnmk0030.getObjects()),
	R3003_LB1100(ER3003PosLbPnmk1100.getRefNumber(), ER3003PosLbPnmk1100.getName(), ER3003PosLbPnmk1100.getObjects()),
	R3004_LB1200(ER3004PosLbPnmk1200.getRefNumber(), ER3004PosLbPnmk1200.getName(), ER3004PosLbPnmk1200.getObjects()),
	R3005_LB1300(ER3005PosLbPnmk1300.getRefNumber(), ER3005PosLbPnmk1300.getName(), ER3005PosLbPnmk1300.getObjects()),
	R3006_LB1400(ER3006PosLbPnmk1400.getRefNumber(), ER3006PosLbPnmk1400.getName(), ER3006PosLbPnmk1400.getObjects()),
	R3007_LB2100(ER3007PosLbPnmk2100.getRefNumber(), ER3007PosLbPnmk2100.getName(), ER3007PosLbPnmk2100.getObjects()),
	R3008_LB2200(ER3008PosLbPnmk2200.getRefNumber(), ER3008PosLbPnmk2200.getName(), ER3008PosLbPnmk2200.getObjects()),
	R3009_LB2300(ER3009PosLbPnmk2300.getRefNumber(), ER3009PosLbPnmk2300.getName(), ER3009PosLbPnmk2300.getObjects()),
	R3010_LB2400(ER3010PosLbPnmk2400.getRefNumber(), ER3010PosLbPnmk2400.getName(), ER3010PosLbPnmk2400.getObjects()),
	R3011_LB2500(ER3011PosLbPnmk2500.getRefNumber(), ER3011PosLbPnmk2500.getName(), ER3011PosLbPnmk2500.getObjects()),
	R3012_LB2600(ER3012PosLbPnmk2600.getRefNumber(), ER3012PosLbPnmk2600.getName(), ER3012PosLbPnmk2600.getObjects()),
	R3013_LB2700(ER3013PosLbPnmk2700.getRefNumber(), ER3013PosLbPnmk2700.getName(), ER3013PosLbPnmk2700.getObjects()),
	R3014_LB2800(ER3014PosLbPnmk2800.getRefNumber(), ER3014PosLbPnmk2800.getName(), ER3014PosLbPnmk2800.getObjects()),;

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
