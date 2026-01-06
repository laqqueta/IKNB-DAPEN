package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
	R2100_RB0101 (ER2100PosRbAsruu0101.getRefNumber(), ER2100PosRbAsruu0101.getName(), ER2100PosRbAsruu0101.getObjects()),
	R2101_RB0102 (ER2101PosRbAsruu0102.getRefNumber(), ER2101PosRbAsruu0102.getName(), ER2101PosRbAsruu0102.getObjects()),
	R2102_RB0103 (ER2102PosRbAsruu0103.getRefNumber(), ER2102PosRbAsruu0103.getName(), ER2102PosRbAsruu0103.getObjects()),
	R2103_RB0104 (ER2103PosRbAsruu0104.getRefNumber(), ER2103PosRbAsruu0104.getName(), ER2103PosRbAsruu0104.getObjects()),
	R2104_RB0105 (ER2104PosRbAsruu0105.getRefNumber(), ER2104PosRbAsruu0105.getName(), ER2104PosRbAsruu0105.getObjects()),
	R2105_RB0106 (ER2105PosRbAsruu0106.getRefNumber(), ER2105PosRbAsruu0106.getName(), ER2105PosRbAsruu0106.getObjects()),
	R2106_RB0201 (ER2106PosRbAsruu0201.getRefNumber(), ER2106PosRbAsruu0201.getName(), ER2106PosRbAsruu0201.getObjects()),
	R2107_RB0202 (ER2107PosRbAsruu0202.getRefNumber(), ER2107PosRbAsruu0202.getName(), ER2107PosRbAsruu0202.getObjects()),
	R2108_RB0203 (ER2108PosRbAsruu0203.getRefNumber(), ER2108PosRbAsruu0203.getName(), ER2108PosRbAsruu0203.getObjects()),
	R2109_RB0401 (ER2109PosRbAsruu0401.getRefNumber(), ER2109PosRbAsruu0401.getName(), ER2109PosRbAsruu0401.getObjects()),
	R2110_RB0501 (ER2110PosRbAsruu0501.getRefNumber(), ER2110PosRbAsruu0501.getName(), ER2110PosRbAsruu0501.getObjects()),
	R2111_RB0601 (ER2111PosRbAsruu0601.getRefNumber(), ER2111PosRbAsruu0601.getName(), ER2111PosRbAsruu0601.getObjects()),
	R2112_RB0602 (ER2112PosRbAsruu0602.getRefNumber(), ER2112PosRbAsruu0602.getName(), ER2112PosRbAsruu0602.getObjects()),
	R2113_RB0603 (ER2113PosRbAsruu0603.getRefNumber(), ER2113PosRbAsruu0603.getName(), ER2113PosRbAsruu0603.getObjects()),
	R2114_RB0604 (ER2114PosRbAsruu0604.getRefNumber(), ER2114PosRbAsruu0604.getName(), ER2114PosRbAsruu0604.getObjects()),
	R2115_RB0605 (ER2115PosRbAsruu0605.getRefNumber(), ER2115PosRbAsruu0605.getName(), ER2115PosRbAsruu0605.getObjects()),
	R2116_RB0606 (ER2116PosRbAsruu0606.getRefNumber(), ER2116PosRbAsruu0606.getName(), ER2116PosRbAsruu0606.getObjects()),
	R2117_RB0701 (ER2117PosRbAsruu0701.getRefNumber(), ER2117PosRbAsruu0701.getName(), ER2117PosRbAsruu0701.getObjects()),
	R2118_RB0901 (ER2118PosRbAsruu0901.getRefNumber(), ER2118PosRbAsruu0901.getName(), ER2118PosRbAsruu0901.getObjects()),
	R2119_RB1001 (ER2119PosRbAsruu1001.getRefNumber(), ER2119PosRbAsruu1001.getName(), ER2119PosRbAsruu1001.getObjects()),
	R2120_RB1002 (ER2120PosRbAsruu1002.getRefNumber(), ER2120PosRbAsruu1002.getName(), ER2120PosRbAsruu1002.getObjects()),
	R2121_RB1003 (ER2121PosRbAsruu1003.getRefNumber(), ER2121PosRbAsruu1003.getName(), ER2121PosRbAsruu1003.getObjects()),
	R2122_RB1004 (ER2122PosRbAsruu1004.getRefNumber(), ER2122PosRbAsruu1004.getName(), ER2122PosRbAsruu1004.getObjects()),
	R2123_RB1005 (ER2123PosRbAsruu1005.getRefNumber(), ER2123PosRbAsruu1005.getName(), ER2123PosRbAsruu1005.getObjects()),
	R2124_RB1201 (ER2124PosRbAsruu1201.getRefNumber(), ER2124PosRbAsruu1201.getName(), ER2124PosRbAsruu1201.getObjects()),
	R2125_RB1202 (ER2125PosRbAsruu1202.getRefNumber(), ER2125PosRbAsruu1202.getName(), ER2125PosRbAsruu1202.getObjects()),
	R2126_RB1203 (ER2126PosRbAsruu1203.getRefNumber(), ER2126PosRbAsruu1203.getName(), ER2126PosRbAsruu1203.getObjects()),
	R2127_RB1204 (ER2127PosRbAsruu1204.getRefNumber(), ER2127PosRbAsruu1204.getName(), ER2127PosRbAsruu1204.getObjects()),
	R2128_RB1205 (ER2128PosRbAsruu1205.getRefNumber(), ER2128PosRbAsruu1205.getName(), ER2128PosRbAsruu1205.getObjects()),
	R2129_RB1206 (ER2129PosRbAsruu1206.getRefNumber(), ER2129PosRbAsruu1206.getName(), ER2129PosRbAsruu1206.getObjects()),
	R2130_RB1207 (ER2130PosRbAsruu1207.getRefNumber(), ER2130PosRbAsruu1207.getName(), ER2130PosRbAsruu1207.getObjects()),
	R2131_RB1208 (ER2131PosRbAsruu1208.getRefNumber(), ER2131PosRbAsruu1208.getName(), ER2131PosRbAsruu1208.getObjects()),
	R2132_RB1209 (ER2132PosRbAsruu1209.getRefNumber(), ER2132PosRbAsruu1209.getName(), ER2132PosRbAsruu1209.getObjects()),
	R2133_RB1210 (ER2133PosRbAsruu1210.getRefNumber(), ER2133PosRbAsruu1210.getName(), ER2133PosRbAsruu1210.getObjects()),
	R2134_RB1301 (ER2134PosRbAsruu1301.getRefNumber(), ER2134PosRbAsruu1301.getName(), ER2134PosRbAsruu1301.getObjects()),
	R2135_RB1302 (ER2135PosRbAsruu1302.getRefNumber(), ER2135PosRbAsruu1302.getName(), ER2135PosRbAsruu1302.getObjects()),
	R2136_RB1303 (ER2136PosRbAsruu1303.getRefNumber(), ER2136PosRbAsruu1303.getName(), ER2136PosRbAsruu1303.getObjects()),
	R2137_RE0101 (ER2137PosReAsruu0101.getRefNumber(), ER2137PosReAsruu0101.getName(), ER2137PosReAsruu0101.getObjects()),
	R2138_RE0102 (ER2138PosReAsruu0102.getRefNumber(), ER2138PosReAsruu0102.getName(), ER2138PosReAsruu0102.getObjects()),
	R2139_RE0103 (ER2139PosReAsruu0103.getRefNumber(), ER2139PosReAsruu0103.getName(), ER2139PosReAsruu0103.getObjects()),
	R2140_RE0201 (ER2140PosReAsruu0201.getRefNumber(), ER2140PosReAsruu0201.getName(), ER2140PosReAsruu0201.getObjects()),
	R2141_RE0202 (ER2141PosReAsruu0202.getRefNumber(), ER2141PosReAsruu0202.getName(), ER2141PosReAsruu0202.getObjects()),
	R2142_RE0203 (ER2142PosReAsruu0203.getRefNumber(), ER2142PosReAsruu0203.getName(), ER2142PosReAsruu0203.getObjects()),
	R2143_RE0301 (ER2143PosReAsruu0301.getRefNumber(), ER2143PosReAsruu0301.getName(), ER2143PosReAsruu0301.getObjects()),
	R2144_RE0302 (ER2144PosReAsruu0302.getRefNumber(), ER2144PosReAsruu0302.getName(), ER2144PosReAsruu0302.getObjects()),
	R2145_RE0303 (ER2145PosReAsruu0303.getRefNumber(), ER2145PosReAsruu0303.getName(), ER2145PosReAsruu0303.getObjects()),
	R2146_RE0401 (ER2146PosReAsruu0401.getRefNumber(), ER2146PosReAsruu0401.getName(), ER2146PosReAsruu0401.getObjects()),
	R2147_RE0402 (ER2147PosReAsruu0402.getRefNumber(), ER2147PosReAsruu0402.getName(), ER2147PosReAsruu0402.getObjects()),
	R2148_RE0403 (ER2148PosReAsruu0403.getRefNumber(), ER2148PosReAsruu0403.getName(), ER2148PosReAsruu0403.getObjects()),
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
