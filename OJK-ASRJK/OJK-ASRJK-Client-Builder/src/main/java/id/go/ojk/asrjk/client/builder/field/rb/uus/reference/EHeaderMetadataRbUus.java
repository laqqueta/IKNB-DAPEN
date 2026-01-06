package id.go.ojk.asrjk.client.builder.field.rb.uus.reference;

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
	R2100_RB0101 (ER2100PosRbAsrju0101.getRefNumber(), ER2100PosRbAsrju0101.getName(), ER2100PosRbAsrju0101.getObjects()),
	R2101_RB0102 (ER2101PosRbAsrju0102.getRefNumber(), ER2101PosRbAsrju0102.getName(), ER2101PosRbAsrju0102.getObjects()),
	R2102_RB0103 (ER2102PosRbAsrju0103.getRefNumber(), ER2102PosRbAsrju0103.getName(), ER2102PosRbAsrju0103.getObjects()),
	R2103_RB0104 (ER2103PosRbAsrju0104.getRefNumber(), ER2103PosRbAsrju0104.getName(), ER2103PosRbAsrju0104.getObjects()),
	R2104_RB0105 (ER2104PosRbAsrju0105.getRefNumber(), ER2104PosRbAsrju0105.getName(), ER2104PosRbAsrju0105.getObjects()),
	R2105_RB0106 (ER2105PosRbAsrju0106.getRefNumber(), ER2105PosRbAsrju0106.getName(), ER2105PosRbAsrju0106.getObjects()),
	R2106_RB0201 (ER2106PosRbAsrju0201.getRefNumber(), ER2106PosRbAsrju0201.getName(), ER2106PosRbAsrju0201.getObjects()),
	R2107_RB0202 (ER2107PosRbAsrju0202.getRefNumber(), ER2107PosRbAsrju0202.getName(), ER2107PosRbAsrju0202.getObjects()),
	R2108_RB0203 (ER2108PosRbAsrju0203.getRefNumber(), ER2108PosRbAsrju0203.getName(), ER2108PosRbAsrju0203.getObjects()),
	R2109_RB0401 (ER2109PosRbAsrju0401.getRefNumber(), ER2109PosRbAsrju0401.getName(), ER2109PosRbAsrju0401.getObjects()),
	R2110_RB0501 (ER2110PosRbAsrju0501.getRefNumber(), ER2110PosRbAsrju0501.getName(), ER2110PosRbAsrju0501.getObjects()),
	R2111_RB0601 (ER2111PosRbAsrju0601.getRefNumber(), ER2111PosRbAsrju0601.getName(), ER2111PosRbAsrju0601.getObjects()),
	R2112_RB0602 (ER2112PosRbAsrju0602.getRefNumber(), ER2112PosRbAsrju0602.getName(), ER2112PosRbAsrju0602.getObjects()),
	R2113_RB0603 (ER2113PosRbAsrju0603.getRefNumber(), ER2113PosRbAsrju0603.getName(), ER2113PosRbAsrju0603.getObjects()),
	R2114_RB0604 (ER2114PosRbAsrju0604.getRefNumber(), ER2114PosRbAsrju0604.getName(), ER2114PosRbAsrju0604.getObjects()),
	R2115_RB0605 (ER2115PosRbAsrju0605.getRefNumber(), ER2115PosRbAsrju0605.getName(), ER2115PosRbAsrju0605.getObjects()),
	R2116_RB0606 (ER2116PosRbAsrju0606.getRefNumber(), ER2116PosRbAsrju0606.getName(), ER2116PosRbAsrju0606.getObjects()),
	R2117_RB0701 (ER2117PosRbAsrju0701.getRefNumber(), ER2117PosRbAsrju0701.getName(), ER2117PosRbAsrju0701.getObjects()),
	R2118_RB0901 (ER2118PosRbAsrju0901.getRefNumber(), ER2118PosRbAsrju0901.getName(), ER2118PosRbAsrju0901.getObjects()),
	R2119_RB1001 (ER2119PosRbAsrju1001.getRefNumber(), ER2119PosRbAsrju1001.getName(), ER2119PosRbAsrju1001.getObjects()),
	R2120_RB1002 (ER2120PosRbAsrju1002.getRefNumber(), ER2120PosRbAsrju1002.getName(), ER2120PosRbAsrju1002.getObjects()),
	R2121_RB1003 (ER2121PosRbAsrju1003.getRefNumber(), ER2121PosRbAsrju1003.getName(), ER2121PosRbAsrju1003.getObjects()),
	R2122_RB1004 (ER2122PosRbAsrju1004.getRefNumber(), ER2122PosRbAsrju1004.getName(), ER2122PosRbAsrju1004.getObjects()),
	R2123_RB1005 (ER2123PosRbAsrju1005.getRefNumber(), ER2123PosRbAsrju1005.getName(), ER2123PosRbAsrju1005.getObjects()),
	R2124_RB1201 (ER2124PosRbAsrju1201.getRefNumber(), ER2124PosRbAsrju1201.getName(), ER2124PosRbAsrju1201.getObjects()),
	R2125_RB1202 (ER2125PosRbAsrju1202.getRefNumber(), ER2125PosRbAsrju1202.getName(), ER2125PosRbAsrju1202.getObjects()),
	R2126_RB1203 (ER2126PosRbAsrju1203.getRefNumber(), ER2126PosRbAsrju1203.getName(), ER2126PosRbAsrju1203.getObjects()),
	R2127_RB1204 (ER2127PosRbAsrju1204.getRefNumber(), ER2127PosRbAsrju1204.getName(), ER2127PosRbAsrju1204.getObjects()),
	R2128_RB1205 (ER2128PosRbAsrju1205.getRefNumber(), ER2128PosRbAsrju1205.getName(), ER2128PosRbAsrju1205.getObjects()),
	R2129_RB1206 (ER2129PosRbAsrju1206.getRefNumber(), ER2129PosRbAsrju1206.getName(), ER2129PosRbAsrju1206.getObjects()),
	R2130_RB1207 (ER2130PosRbAsrju1207.getRefNumber(), ER2130PosRbAsrju1207.getName(), ER2130PosRbAsrju1207.getObjects()),
	R2131_RB1208 (ER2131PosRbAsrju1208.getRefNumber(), ER2131PosRbAsrju1208.getName(), ER2131PosRbAsrju1208.getObjects()),
	R2132_RB1209 (ER2132PosRbAsrju1209.getRefNumber(), ER2132PosRbAsrju1209.getName(), ER2132PosRbAsrju1209.getObjects()),
	R2133_RB1210 (ER2133PosRbAsrju1210.getRefNumber(), ER2133PosRbAsrju1210.getName(), ER2133PosRbAsrju1210.getObjects()),
	R2134_RB1301 (ER2134PosRbAsrju1301.getRefNumber(), ER2134PosRbAsrju1301.getName(), ER2134PosRbAsrju1301.getObjects()),
	R2135_RB1302 (ER2135PosRbAsrju1302.getRefNumber(), ER2135PosRbAsrju1302.getName(), ER2135PosRbAsrju1302.getObjects()),
	R2136_RB1303 (ER2136PosRbAsrju1303.getRefNumber(), ER2136PosRbAsrju1303.getName(), ER2136PosRbAsrju1303.getObjects()),
	R2137_RE0101 (ER2137PosReAsrju0101.getRefNumber(), ER2137PosReAsrju0101.getName(), ER2137PosReAsrju0101.getObjects()),
	R2138_RE0102 (ER2138PosReAsrju0102.getRefNumber(), ER2138PosReAsrju0102.getName(), ER2138PosReAsrju0102.getObjects()),
	R2139_RE0103 (ER2139PosReAsrju0103.getRefNumber(), ER2139PosReAsrju0103.getName(), ER2139PosReAsrju0103.getObjects()),
	R2140_RE0201 (ER2140PosReAsrju0201.getRefNumber(), ER2140PosReAsrju0201.getName(), ER2140PosReAsrju0201.getObjects()),
	R2141_RE0202 (ER2141PosReAsrju0202.getRefNumber(), ER2141PosReAsrju0202.getName(), ER2141PosReAsrju0202.getObjects()),
	R2142_RE0203 (ER2142PosReAsrju0203.getRefNumber(), ER2142PosReAsrju0203.getName(), ER2142PosReAsrju0203.getObjects()),
	R2143_RE0301 (ER2143PosReAsrju0301.getRefNumber(), ER2143PosReAsrju0301.getName(), ER2143PosReAsrju0301.getObjects()),
	R2144_RE0302 (ER2144PosReAsrju0302.getRefNumber(), ER2144PosReAsrju0302.getName(), ER2144PosReAsrju0302.getObjects()),
	R2145_RE0303 (ER2145PosReAsrju0303.getRefNumber(), ER2145PosReAsrju0303.getName(), ER2145PosReAsrju0303.getObjects()),
	R2146_RE0401 (ER2146PosReAsrju0401.getRefNumber(), ER2146PosReAsrju0401.getName(), ER2146PosReAsrju0401.getObjects()),
	R2147_RE0402 (ER2147PosReAsrju0402.getRefNumber(), ER2147PosReAsrju0402.getName(), ER2147PosReAsrju0402.getObjects()),
	R2148_RE0403 (ER2148PosReAsrju0403.getRefNumber(), ER2148PosReAsrju0403.getName(), ER2148PosReAsrju0403.getObjects()),
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
