package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum EHeaderMetadataRb implements IObject<ReferenceMetadata> {
	R2000_RB0104 (ER2000PosRbReask0104.getRefNumber(), ER2000PosRbReask0104.getName(), ER2000PosRbReask0104.getObjects()),
	R2001_RB0105 (ER2001PosRbReask0105.getRefNumber(), ER2001PosRbReask0105.getName(), ER2001PosRbReask0105.getObjects()),
	R2002_RB0201 (ER2002PosRbReask0201.getRefNumber(), ER2002PosRbReask0201.getName(), ER2002PosRbReask0201.getObjects()),
	R2003_RB0400 (ER2003PosRbReask0400.getRefNumber(), ER2003PosRbReask0400.getName(), ER2003PosRbReask0400.getObjects()),
	R2004_RB0500 (ER2004PosRbReask0500.getRefNumber(), ER2004PosRbReask0500.getName(), ER2004PosRbReask0500.getObjects()),
	R2005_RB0601 (ER2005PosRbReask0601.getRefNumber(), ER2005PosRbReask0601.getName(), ER2005PosRbReask0601.getObjects()),
	R2006_RB0602 (ER2006PosRbReask0602.getRefNumber(), ER2006PosRbReask0602.getName(), ER2006PosRbReask0602.getObjects()),
	R2007_RB0702 (ER2007PosRbReask0702.getRefNumber(), ER2007PosRbReask0702.getName(), ER2007PosRbReask0702.getObjects()),
	R2008_RB0900 (ER2008PosRbReask0900.getRefNumber(), ER2008PosRbReask0900.getName(), ER2008PosRbReask0900.getObjects()),
	R2009_RB1002 (ER2009PosRbReask1002.getRefNumber(), ER2009PosRbReask1002.getName(), ER2009PosRbReask1002.getObjects()),
	R2010_RB1003 (ER2010PosRbReask1003.getRefNumber(), ER2010PosRbReask1003.getName(), ER2010PosRbReask1003.getObjects()),
	R2011_RB1004 (ER2011PosRbReask1004.getRefNumber(), ER2011PosRbReask1004.getName(), ER2011PosRbReask1004.getObjects()),
	R2012_RB1005 (ER2012PosRbReask1005.getRefNumber(), ER2012PosRbReask1005.getName(), ER2012PosRbReask1005.getObjects()),
	R2013_RB1006 (ER2013PosRbReask1006.getRefNumber(), ER2013PosRbReask1006.getName(), ER2013PosRbReask1006.getObjects()),
	R2014_RB1301 (ER2014PosRbReask1301.getRefNumber(), ER2014PosRbReask1301.getName(), ER2014PosRbReask1301.getObjects()),
	R2015_RB1304 (ER2015PosRbReask1304.getRefNumber(), ER2015PosRbReask1304.getName(), ER2015PosRbReask1304.getObjects()),
	R2016_RB1307 (ER2016PosRbReask1307.getRefNumber(), ER2016PosRbReask1307.getName(), ER2016PosRbReask1307.getObjects()),
	R2017_RB1310 (ER2017PosRbReask1310.getRefNumber(), ER2017PosRbReask1310.getName(), ER2017PosRbReask1310.getObjects()),
	R2018_RB1313 (ER2018PosRbReask1313.getRefNumber(), ER2018PosRbReask1313.getName(), ER2018PosRbReask1313.getObjects()),
	R2250_RE0100 (ER2250PosReReask0100.getRefNumber(), ER2250PosReReask0100.getName(), ER2250PosReReask0100.getObjects()),
	R2251_RE0200 (ER2251PosReReask0200.getRefNumber(), ER2251PosReReask0200.getName(), ER2251PosReReask0200.getObjects()),
	R2252_RE0300 (ER2252PosReReask0300.getRefNumber(), ER2252PosReReask0300.getName(), ER2252PosReReask0300.getObjects()),
	R2253_RE0400 (ER2253PosReReask0400.getRefNumber(), ER2253PosReReask0400.getName(), ER2253PosReReask0400.getObjects()),
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
		for (EHeaderMetadataRb eEnum : EHeaderMetadataRb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataRb eEnum : EHeaderMetadataRb.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
