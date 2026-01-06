package id.go.ojk.asruk.client.builder.field.rb.reference;

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
	R2000_RB0104 (ER2000PosRbAsruk0104.getRefNumber(), ER2000PosRbAsruk0104.getName(), ER2000PosRbAsruk0104.getObjects()),
	R2001_RB0105 (ER2001PosRbAsruk0105.getRefNumber(), ER2001PosRbAsruk0105.getName(), ER2001PosRbAsruk0105.getObjects()),
	R2002_RB0201 (ER2002PosRbAsruk0201.getRefNumber(), ER2002PosRbAsruk0201.getName(), ER2002PosRbAsruk0201.getObjects()),
	R2003_RB0400 (ER2003PosRbAsruk0400.getRefNumber(), ER2003PosRbAsruk0400.getName(), ER2003PosRbAsruk0400.getObjects()),
	R2004_RB0500 (ER2004PosRbAsruk0500.getRefNumber(), ER2004PosRbAsruk0500.getName(), ER2004PosRbAsruk0500.getObjects()),
	R2005_RB0601 (ER2005PosRbAsruk0601.getRefNumber(), ER2005PosRbAsruk0601.getName(), ER2005PosRbAsruk0601.getObjects()),
	R2006_RB0602 (ER2006PosRbAsruk0602.getRefNumber(), ER2006PosRbAsruk0602.getName(), ER2006PosRbAsruk0602.getObjects()),
	R2007_RB0702 (ER2007PosRbAsruk0702.getRefNumber(), ER2007PosRbAsruk0702.getName(), ER2007PosRbAsruk0702.getObjects()),
	R2008_RB0900 (ER2008PosRbAsruk0900.getRefNumber(), ER2008PosRbAsruk0900.getName(), ER2008PosRbAsruk0900.getObjects()),
	R2009_RB1002 (ER2009PosRbAsruk1002.getRefNumber(), ER2009PosRbAsruk1002.getName(), ER2009PosRbAsruk1002.getObjects()),
	R2010_RB1003 (ER2010PosRbAsruk1003.getRefNumber(), ER2010PosRbAsruk1003.getName(), ER2010PosRbAsruk1003.getObjects()),
	R2011_RB1004 (ER2011PosRbAsruk1004.getRefNumber(), ER2011PosRbAsruk1004.getName(), ER2011PosRbAsruk1004.getObjects()),
	R2012_RB1005 (ER2012PosRbAsruk1005.getRefNumber(), ER2012PosRbAsruk1005.getName(), ER2012PosRbAsruk1005.getObjects()),
	R2013_RB1006 (ER2013PosRbAsruk1006.getRefNumber(), ER2013PosRbAsruk1006.getName(), ER2013PosRbAsruk1006.getObjects()),
	R2014_RB1301 (ER2014PosRbAsruk1301.getRefNumber(), ER2014PosRbAsruk1301.getName(), ER2014PosRbAsruk1301.getObjects()),
	R2015_RB1304 (ER2015PosRbAsruk1304.getRefNumber(), ER2015PosRbAsruk1304.getName(), ER2015PosRbAsruk1304.getObjects()),
	R2016_RB1307 (ER2016PosRbAsruk1307.getRefNumber(), ER2016PosRbAsruk1307.getName(), ER2016PosRbAsruk1307.getObjects()),
	R2017_RB1310 (ER2017PosRbAsruk1310.getRefNumber(), ER2017PosRbAsruk1310.getName(), ER2017PosRbAsruk1310.getObjects()),
	R2018_RB1313 (ER2018PosRbAsruk1313.getRefNumber(), ER2018PosRbAsruk1313.getName(), ER2018PosRbAsruk1313.getObjects()),
	R2019_RE0100 (ER2019PosReAsruk0100.getRefNumber(), ER2019PosReAsruk0100.getName(), ER2019PosReAsruk0100.getObjects()),
	R2020_RE0200 (ER2020PosReAsruk0200.getRefNumber(), ER2020PosReAsruk0200.getName(), ER2020PosReAsruk0200.getObjects()),
	R2021_RE0300 (ER2021PosReAsruk0300.getRefNumber(), ER2021PosReAsruk0300.getName(), ER2021PosReAsruk0300.getObjects()),
	R2022_RE0400 (ER2022PosReAsruk0400.getRefNumber(), ER2022PosReAsruk0400.getName(), ER2022PosReAsruk0400.getObjects()),
	;

	private int number;
	private String name;
	private List<KeyValueString> references;
	
	public String getDescription() {
		return "R" + number + name; 
	}

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataRb eEnum : EHeaderMetadataRb.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
	
	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataRb eEnum : EHeaderMetadataRb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
		res.setPerSegment(false);
		res.setLabel1Map(null);
		return res;
	}
}
