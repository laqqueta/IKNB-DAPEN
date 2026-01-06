package id.go.ojk.reask.client.builder.field.rb.uus.reference;

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
public enum EHeaderMetadataRbUus implements IObject<ReferenceMetadata> {
	R2100_RB0101 (ER2100PosRbReasu0101.getRefNumber(), ER2100PosRbReasu0101.getName(), ER2100PosRbReasu0101.getObjects()),
	R2101_RB0102 (ER2101PosRbReasu0102.getRefNumber(), ER2101PosRbReasu0102.getName(), ER2101PosRbReasu0102.getObjects()),
	R2102_RB0103 (ER2102PosRbReasu0103.getRefNumber(), ER2102PosRbReasu0103.getName(), ER2102PosRbReasu0103.getObjects()),
	R2103_RB0104 (ER2103PosRbReasu0104.getRefNumber(), ER2103PosRbReasu0104.getName(), ER2103PosRbReasu0104.getObjects()),
	R2104_RB0201 (ER2104PosRbReasu0201.getRefNumber(), ER2104PosRbReasu0201.getName(), ER2104PosRbReasu0201.getObjects()),
	R2105_RB0202 (ER2105PosRbReasu0202.getRefNumber(), ER2105PosRbReasu0202.getName(), ER2105PosRbReasu0202.getObjects()),
	R2106_RB0401 (ER2106PosRbReasu0401.getRefNumber(), ER2106PosRbReasu0401.getName(), ER2106PosRbReasu0401.getObjects()),
	R2107_RB0501 (ER2107PosRbReasu0501.getRefNumber(), ER2107PosRbReasu0501.getName(), ER2107PosRbReasu0501.getObjects()),
	R2108_RB0601 (ER2108PosRbReasu0601.getRefNumber(), ER2108PosRbReasu0601.getName(), ER2108PosRbReasu0601.getObjects()),
	R2109_RB0602 (ER2109PosRbReasu0602.getRefNumber(), ER2109PosRbReasu0602.getName(), ER2109PosRbReasu0602.getObjects()),
	R2110_RB0603 (ER2110PosRbReasu0603.getRefNumber(), ER2110PosRbReasu0603.getName(), ER2110PosRbReasu0603.getObjects()),
	R2111_RB0604 (ER2111PosRbReasu0604.getRefNumber(), ER2111PosRbReasu0604.getName(), ER2111PosRbReasu0604.getObjects()),
	R2112_RB0701 (ER2112PosRbReasu0701.getRefNumber(), ER2112PosRbReasu0701.getName(), ER2112PosRbReasu0701.getObjects()),
	R2113_RB0901 (ER2113PosRbReasu0901.getRefNumber(), ER2113PosRbReasu0901.getName(), ER2113PosRbReasu0901.getObjects()),
	R2114_RB1001 (ER2114PosRbReasu1001.getRefNumber(), ER2114PosRbReasu1001.getName(), ER2114PosRbReasu1001.getObjects()),
	R2115_RB1002 (ER2115PosRbReasu1002.getRefNumber(), ER2115PosRbReasu1002.getName(), ER2115PosRbReasu1002.getObjects()),
	R2116_RB1003 (ER2116PosRbReasu1003.getRefNumber(), ER2116PosRbReasu1003.getName(), ER2116PosRbReasu1003.getObjects()),
	R2117_RB1004 (ER2117PosRbReasu1004.getRefNumber(), ER2117PosRbReasu1004.getName(), ER2117PosRbReasu1004.getObjects()),
	R2118_RB1005 (ER2118PosRbReasu1005.getRefNumber(), ER2118PosRbReasu1005.getName(), ER2118PosRbReasu1005.getObjects()),
	R2119_RB1201 (ER2119PosRbReasu1201.getRefNumber(), ER2119PosRbReasu1201.getName(), ER2119PosRbReasu1201.getObjects()),
	R2120_RB1202 (ER2120PosRbReasu1202.getRefNumber(), ER2120PosRbReasu1202.getName(), ER2120PosRbReasu1202.getObjects()),
	R2121_RB1203 (ER2121PosRbReasu1203.getRefNumber(), ER2121PosRbReasu1203.getName(), ER2121PosRbReasu1203.getObjects()),
	R2122_RB1204 (ER2122PosRbReasu1204.getRefNumber(), ER2122PosRbReasu1204.getName(), ER2122PosRbReasu1204.getObjects()),
	R2123_RB1205 (ER2123PosRbReasu1205.getRefNumber(), ER2123PosRbReasu1205.getName(), ER2123PosRbReasu1205.getObjects()),
	R2124_RB1206 (ER2124PosRbReasu1206.getRefNumber(), ER2124PosRbReasu1206.getName(), ER2124PosRbReasu1206.getObjects()),
	R2125_RB1207 (ER2125PosRbReasu1207.getRefNumber(), ER2125PosRbReasu1207.getName(), ER2125PosRbReasu1207.getObjects()),
	R2126_RB1301 (ER2126PosRbReasu1301.getRefNumber(), ER2126PosRbReasu1301.getName(), ER2126PosRbReasu1301.getObjects()),
	R2127_RB1302 (ER2127PosRbReasu1302.getRefNumber(), ER2127PosRbReasu1302.getName(), ER2127PosRbReasu1302.getObjects()),
	R2128_RE0101 (ER2128PosReReasu0101.getRefNumber(), ER2128PosReReasu0101.getName(), ER2128PosReReasu0101.getObjects()),
	R2129_RE0102 (ER2129PosReReasu0102.getRefNumber(), ER2129PosReReasu0102.getName(), ER2129PosReReasu0102.getObjects()),
	R2130_RE0201 (ER2130PosReReasu0201.getRefNumber(), ER2130PosReReasu0201.getName(), ER2130PosReReasu0201.getObjects()),
	R2131_RE0202 (ER2131PosReReasu0202.getRefNumber(), ER2131PosReReasu0202.getName(), ER2131PosReReasu0202.getObjects()),
	R2132_RE0301 (ER2132PosReReasu0301.getRefNumber(), ER2132PosReReasu0301.getName(), ER2132PosReReasu0301.getObjects()),
	R2133_RE0302 (ER2133PosReReasu0302.getRefNumber(), ER2133PosReReasu0302.getName(), ER2133PosReReasu0302.getObjects()),
	R2134_RE0401 (ER2134PosReReasu0401.getRefNumber(), ER2134PosReReasu0401.getName(), ER2134PosReReasu0401.getObjects()),
	R2135_RE0402 (ER2135PosReReasu0402.getRefNumber(), ER2135PosReReasu0402.getName(), ER2135PosReReasu0402.getObjects()),
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
		for (EHeaderMetadataRbUus eEnum : EHeaderMetadataRbUus.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataRbUus eEnum : EHeaderMetadataRbUus.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
