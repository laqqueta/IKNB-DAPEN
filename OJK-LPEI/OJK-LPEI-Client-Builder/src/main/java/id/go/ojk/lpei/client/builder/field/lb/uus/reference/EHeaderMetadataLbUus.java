package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

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
	R7000_LB0000 (ER7000PosLbLpeiu0000.getRefNumber(), ER7000PosLbLpeiu0000.getName(), ER7000PosLbLpeiu0000.getObjects()),
	R7001_LB0020 (ER7001PosLbLpeiu0020.getRefNumber(), ER7001PosLbLpeiu0020.getName(), ER7001PosLbLpeiu0020.getObjects()),
	R7003_LB0041 (ER7003PosLbLpeiu0041.getRefNumber(), ER7003PosLbLpeiu0041.getName(), ER7003PosLbLpeiu0041.getObjects()),
	R7004_LB0043 (ER7004PosLbLpeiu0043.getRefNumber(), ER7004PosLbLpeiu0043.getName(), ER7004PosLbLpeiu0043.getObjects()),
	R7005_LB0046 (ER7005PosLbLpeiu0046.getRefNumber(), ER7005PosLbLpeiu0046.getName(), ER7005PosLbLpeiu0046.getObjects()),
	R7006_LB1000 (ER7006PosLbLpeiu1000.getRefNumber(), ER7006PosLbLpeiu1000.getName(), ER7006PosLbLpeiu1000.getObjects()),
	R7007_LB1100 (ER7007PosLbLpeiu1100.getRefNumber(), ER7007PosLbLpeiu1100.getName(), ER7007PosLbLpeiu1100.getObjects()),
	R7008_LB1110 (ER7008PosLbLpeiu1110.getRefNumber(), ER7008PosLbLpeiu1110.getName(), ER7008PosLbLpeiu1110.getObjects()),
	R7009_LB1200 (ER7009PosLbLpeiu1200.getRefNumber(), ER7009PosLbLpeiu1200.getName(), ER7009PosLbLpeiu1200.getObjects()),
	R7010_LB1300 (ER7010PosLbLpeiu1300.getRefNumber(), ER7010PosLbLpeiu1300.getName(), ER7010PosLbLpeiu1300.getObjects()),
	R7011_LB2000 (ER7011PosLbLpeiu2000.getRefNumber(), ER7011PosLbLpeiu2000.getName(), ER7011PosLbLpeiu2000.getObjects()),	
	R7012_LB2050 (ER7012PosLbLpeiu2050.getRefNumber(), ER7012PosLbLpeiu2050.getName(), ER7012PosLbLpeiu2050.getObjects()),
	R7013_LB2100 (ER7013PosLbLpeiu2100.getRefNumber(), ER7013PosLbLpeiu2100.getName(), ER7013PosLbLpeiu2100.getObjects()),
	R7014_LB2150 (ER7014PosLbLpeiu2150.getRefNumber(), ER7014PosLbLpeiu2150.getName(), ER7014PosLbLpeiu2150.getObjects()),
	R7015_LB2200 (ER7015PosLbLpeiu2200.getRefNumber(), ER7015PosLbLpeiu2200.getName(), ER7015PosLbLpeiu2200.getObjects()),
	R7017_LB2350 (ER7017PosLbLpeiu2350.getRefNumber(), ER7017PosLbLpeiu2350.getName(), ER7017PosLbLpeiu2350.getObjects()),
	R7018_LB2400 (ER7018PosLbLpeiu2400.getRefNumber(), ER7018PosLbLpeiu2400.getName(), ER7018PosLbLpeiu2400.getObjects()),
	R7019_LB2450 (ER7019PosLbLpeiu2450.getRefNumber(), ER7019PosLbLpeiu2450.getName(), ER7019PosLbLpeiu2450.getObjects()),
	R7020_LB2490 (ER7020PosLbLpeiu2490.getRefNumber(), ER7020PosLbLpeiu2490.getName(), ER7020PosLbLpeiu2490.getObjects()),
	R7021_LB2550 (ER7021PosLbLpeiu2550.getRefNumber(), ER7021PosLbLpeiu2550.getName(), ER7021PosLbLpeiu2550.getObjects()),
	R7022_LB2600 (ER7022PosLbLpeiu2600.getRefNumber(), ER7022PosLbLpeiu2600.getName(), ER7022PosLbLpeiu2600.getObjects()),
	R7023_LB2700 (ER7023PosLbLpeiu2700.getRefNumber(), ER7023PosLbLpeiu2700.getName(), ER7023PosLbLpeiu2700.getObjects()),
	R7024_LB2730 (ER7024PosLbLpeiu2730.getRefNumber(), ER7024PosLbLpeiu2730.getName(), ER7024PosLbLpeiu2730.getObjects()),
	R7025_LB2760 (ER7025PosLbLpeiu2760.getRefNumber(), ER7025PosLbLpeiu2760.getName(), ER7025PosLbLpeiu2760.getObjects()),
	R7026_LB2790 (ER7026PosLbLpeiu2790.getRefNumber(), ER7026PosLbLpeiu2790.getName(), ER7026PosLbLpeiu2790.getObjects()),
	R7027_LB5200 (ER7027PosLbLpeiu5200.getRefNumber(), ER7027PosLbLpeiu5200.getName(), ER7027PosLbLpeiu5200.getObjects()),
	R7029_LB5310 (ER7029PosLbLpeiu5310.getRefNumber(), ER7029PosLbLpeiu5310.getName(), ER7029PosLbLpeiu5310.getObjects()),
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
