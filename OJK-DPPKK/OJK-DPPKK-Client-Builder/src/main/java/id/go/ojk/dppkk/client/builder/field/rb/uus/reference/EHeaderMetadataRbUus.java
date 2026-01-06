package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

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
	R2100_RB0100 (ER2100PosRbDppu0100.getRefNumber(), ER2100PosRbDppu0100.getName(), ER2100PosRbDppu0100.getObjects()),
	R2101_RB0204 (ER2101PosRbDppu0204.getRefNumber(), ER2101PosRbDppu0204.getName(), ER2101PosRbDppu0204.getObjects()),
	R2102_RB0205 (ER2102PosRbDppu0205.getRefNumber(), ER2102PosRbDppu0205.getName(), ER2102PosRbDppu0205.getObjects()),
	R2103_RB0301 (ER2103PosRbDppu0301.getRefNumber(), ER2103PosRbDppu0301.getName(), ER2103PosRbDppu0301.getObjects()),
	R2104_RB0403 (ER2104PosRbDppu0403.getRefNumber(), ER2104PosRbDppu0403.getName(), ER2104PosRbDppu0403.getObjects()),
	R2105_RB0600 (ER2105PosRbDppu0600.getRefNumber(), ER2105PosRbDppu0600.getName(), ER2105PosRbDppu0600.getObjects()),
	R2106_RB0701 (ER2106PosRbDppu0701.getRefNumber(), ER2106PosRbDppu0701.getName(), ER2106PosRbDppu0701.getObjects()),
	R2107_RB0702 (ER2107PosRbDppu0702.getRefNumber(), ER2107PosRbDppu0702.getName(), ER2107PosRbDppu0702.getObjects()),
	R2108_RB0703 (ER2108PosRbDppu0703.getRefNumber(), ER2108PosRbDppu0703.getName(), ER2108PosRbDppu0703.getObjects()),
	R2109_RB0801 (ER2109PosRbDppu0801.getRefNumber(), ER2109PosRbDppu0801.getName(), ER2109PosRbDppu0801.getObjects()),
	R2110_RB0802 (ER2110PosRbDppu0802.getRefNumber(), ER2110PosRbDppu0802.getName(), ER2110PosRbDppu0802.getObjects()),
	R2111_RB0900 (ER2111PosRbDppu0900.getRefNumber(), ER2111PosRbDppu0900.getName(), ER2111PosRbDppu0900.getObjects()),
	R2112_RB1001 (ER2112PosRbDppu1001.getRefNumber(), ER2112PosRbDppu1001.getName(), ER2112PosRbDppu1001.getObjects()),
	R2113_RB1002 (ER2113PosRbDppu1002.getRefNumber(), ER2113PosRbDppu1002.getName(), ER2113PosRbDppu1002.getObjects()),
	R2114_RB1003 (ER2114PosRbDppu1003.getRefNumber(), ER2114PosRbDppu1003.getName(), ER2114PosRbDppu1003.getObjects()),
	R2115_RB1004 (ER2115PosRbDppu1004.getRefNumber(), ER2115PosRbDppu1004.getName(), ER2115PosRbDppu1004.getObjects()),
	R2116_RB1201 (ER2116PosRbDppu1201.getRefNumber(), ER2116PosRbDppu1201.getName(), ER2116PosRbDppu1201.getObjects()),
	R2117_RB1202 (ER2117PosRbDppu1202.getRefNumber(), ER2117PosRbDppu1202.getName(), ER2117PosRbDppu1202.getObjects()),
	R2118_RB1203 (ER2118PosRbDppu1203.getRefNumber(), ER2118PosRbDppu1203.getName(), ER2118PosRbDppu1203.getObjects()),
	R2119_RE0100 (ER2119PosReDppu0100.getRefNumber(), ER2119PosReDppu0100.getName(), ER2119PosReDppu0100.getObjects()),
	R2120_RE0200 (ER2120PosReDppu0200.getRefNumber(), ER2120PosReDppu0200.getName(), ER2120PosReDppu0200.getObjects()),
	R2121_RE0300 (ER2121PosReDppu0300.getRefNumber(), ER2121PosReDppu0300.getName(), ER2121PosReDppu0300.getObjects()),
	R2122_RE0400 (ER2122PosReDppu0400.getRefNumber(), ER2122PosReDppu0400.getName(), ER2122PosReDppu0400.getObjects()),
	R2123_RE0500 (ER2123PosReDppu0500.getRefNumber(), ER2123PosReDppu0500.getName(), ER2123PosReDppu0500.getObjects()),
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
