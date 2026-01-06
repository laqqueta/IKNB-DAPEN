package id.go.ojk.lpei.client.builder.field.lb.reference;

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
	R5000_LB0000 (ER5000PosLbLpeig0000.getRefNumber(), ER5000PosLbLpeig0000.getName(), ER5000PosLbLpeig0000.getObjects()),
	R5001_LB0020 (ER5001PosLbLpeig0020.getRefNumber(), ER5001PosLbLpeig0020.getName(), ER5001PosLbLpeig0020.getObjects()),
	R5002_LB0035 (ER5002PosLbLpeig0035.getRefNumber(), ER5002PosLbLpeig0035.getName(), ER5002PosLbLpeig0035.getObjects()),
	R5003_LB0041 (ER5003PosLbLpeig0041.getRefNumber(), ER5003PosLbLpeig0041.getName(), ER5003PosLbLpeig0041.getObjects()),
	R5004_LB0043 (ER5004PosLbLpeig0043.getRefNumber(), ER5004PosLbLpeig0043.getName(), ER5004PosLbLpeig0043.getObjects()),
	R5005_LB0046 (ER5005PosLbLpeig0046.getRefNumber(), ER5005PosLbLpeig0046.getName(), ER5005PosLbLpeig0046.getObjects()),
	R5006_LB1000 (ER5006PosLbLpeig1000.getRefNumber(), ER5006PosLbLpeig1000.getName(), ER5006PosLbLpeig1000.getObjects()),
	R5007_LB1100 (ER5007PosLbLpeig1100.getRefNumber(), ER5007PosLbLpeig1100.getName(), ER5007PosLbLpeig1100.getObjects()),
	R5008_LB1110 (ER5008PosLbLpeig1110.getRefNumber(), ER5008PosLbLpeig1110.getName(), ER5008PosLbLpeig1110.getObjects()),
	R5009_LB1200 (ER5009PosLbLpeig1200.getRefNumber(), ER5009PosLbLpeig1200.getName(), ER5009PosLbLpeig1200.getObjects()),
	R5010_LB1300 (ER5010PosLbLpeig1300.getRefNumber(), ER5010PosLbLpeig1300.getName(), ER5010PosLbLpeig1300.getObjects()),
	R5011_LB2000 (ER5011PosLbLpeig2000.getRefNumber(), ER5011PosLbLpeig2000.getName(), ER5011PosLbLpeig2000.getObjects()),
	R5012_LB2050 (ER5012PosLbLpeig2050.getRefNumber(), ER5012PosLbLpeig2050.getName(), ER5012PosLbLpeig2050.getObjects()),
	R5013_LB2100 (ER5013PosLbLpeig2100.getRefNumber(), ER5013PosLbLpeig2100.getName(), ER5013PosLbLpeig2100.getObjects()),
	R5014_LB2150 (ER5014PosLbLpeig2150.getRefNumber(), ER5014PosLbLpeig2150.getName(), ER5014PosLbLpeig2150.getObjects()),
	R5015_LB2200 (ER5015PosLbLpeig2200.getRefNumber(), ER5015PosLbLpeig2200.getName(), ER5015PosLbLpeig2200.getObjects()),
	R5016_LB2300 (ER5016PosLbLpeig2300.getRefNumber(), ER5016PosLbLpeig2300.getName(), ER5016PosLbLpeig2300.getObjects()),
	R5017_LB2350 (ER5017PosLbLpeig2350.getRefNumber(), ER5017PosLbLpeig2350.getName(), ER5017PosLbLpeig2350.getObjects()),
	R5018_LB2400 (ER5018PosLbLpeig2400.getRefNumber(), ER5018PosLbLpeig2400.getName(), ER5018PosLbLpeig2400.getObjects()),
	R5019_LB2450 (ER5019PosLbLpeig2450.getRefNumber(), ER5019PosLbLpeig2450.getName(), ER5019PosLbLpeig2450.getObjects()),
	R5020_LB2490 (ER5020PosLbLpeig2490.getRefNumber(), ER5020PosLbLpeig2490.getName(), ER5020PosLbLpeig2490.getObjects()),
	R5021_LB2550 (ER5021PosLbLpeig2550.getRefNumber(), ER5021PosLbLpeig2550.getName(), ER5021PosLbLpeig2550.getObjects()),
	R5022_LB2600 (ER5022PosLbLpeig2600.getRefNumber(), ER5022PosLbLpeig2600.getName(), ER5022PosLbLpeig2600.getObjects()),
	R5023_LB2700 (ER5023PosLbLpeig2700.getRefNumber(), ER5023PosLbLpeig2700.getName(), ER5023PosLbLpeig2700.getObjects()),
	R5024_LB2730 (ER5024PosLbLpeig2730.getRefNumber(), ER5024PosLbLpeig2730.getName(), ER5024PosLbLpeig2730.getObjects()),
	R5025_LB2760 (ER5025PosLbLpeig2760.getRefNumber(), ER5025PosLbLpeig2760.getName(), ER5025PosLbLpeig2760.getObjects()),
	R5026_LB2790 (ER5026PosLbLpeig2790.getRefNumber(), ER5026PosLbLpeig2790.getName(), ER5026PosLbLpeig2790.getObjects()),
	R5027_LB5200 (ER5027PosLbLpeig5200.getRefNumber(), ER5027PosLbLpeig5200.getName(), ER5027PosLbLpeig5200.getObjects()),
	R5028_LB5250 (ER5028PosLbLpeig5250.getRefNumber(), ER5028PosLbLpeig5250.getName(), ER5028PosLbLpeig5250.getObjects()),
	R5029_LB5310 (ER5029PosLbLpeig5310.getRefNumber(), ER5029PosLbLpeig5310.getName(), ER5029PosLbLpeig5310.getObjects()),
	R5030_LBDHE01(ER5030PosLbLpeigDHE01.getRefNumber(), ER5030PosLbLpeigDHE01.getName(),
			ER5030PosLbLpeigDHE01.getObjects()),
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
