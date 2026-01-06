package id.go.ojk.asrjk.client.builder.field.rb.reference;

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
	R2000_RB0104 (ER2000PosRbAsrjk0104.getRefNumber(), ER2000PosRbAsrjk0104.getName(), ER2000PosRbAsrjk0104.getObjects()),
	R2001_RB0105 (ER2001PosRbAsrjk0105.getRefNumber(), ER2001PosRbAsrjk0105.getName(), ER2001PosRbAsrjk0105.getObjects()),
	R2002_RB0201 (ER2002PosRbAsrjk0201.getRefNumber(), ER2002PosRbAsrjk0201.getName(), ER2002PosRbAsrjk0201.getObjects()),
	R2003_RB0400 (ER2003PosRbAsrjk0400.getRefNumber(), ER2003PosRbAsrjk0400.getName(), ER2003PosRbAsrjk0400.getObjects()),
	R2004_RB0500 (ER2004PosRbAsrjk0500.getRefNumber(), ER2004PosRbAsrjk0500.getName(), ER2004PosRbAsrjk0500.getObjects()),
	R2005_RB0601 (ER2005PosRbAsrjk0601.getRefNumber(), ER2005PosRbAsrjk0601.getName(), ER2005PosRbAsrjk0601.getObjects()),
	R2006_RB0602 (ER2006PosRbAsrjk0602.getRefNumber(), ER2006PosRbAsrjk0602.getName(), ER2006PosRbAsrjk0602.getObjects()),
	R2007_RB0702 (ER2007PosRbAsrjk0702.getRefNumber(), ER2007PosRbAsrjk0702.getName(), ER2007PosRbAsrjk0702.getObjects()),
	R2008_RB0900 (ER2008PosRbAsrjk0900.getRefNumber(), ER2008PosRbAsrjk0900.getName(), ER2008PosRbAsrjk0900.getObjects()),
	R2009_RB1002 (ER2009PosRbAsrjk1002.getRefNumber(), ER2009PosRbAsrjk1002.getName(), ER2009PosRbAsrjk1002.getObjects()),
	R2010_RB1003 (ER2010PosRbAsrjk1003.getRefNumber(), ER2010PosRbAsrjk1003.getName(), ER2010PosRbAsrjk1003.getObjects()),
	R2011_RB1004 (ER2011PosRbAsrjk1004.getRefNumber(), ER2011PosRbAsrjk1004.getName(), ER2011PosRbAsrjk1004.getObjects()),
	R2012_RB1005 (ER2012PosRbAsrjk1005.getRefNumber(), ER2012PosRbAsrjk1005.getName(), ER2012PosRbAsrjk1005.getObjects()),
	R2013_RB1006 (ER2013PosRbAsrjk1006.getRefNumber(), ER2013PosRbAsrjk1006.getName(), ER2013PosRbAsrjk1006.getObjects()),
	R2014_RB1302 (ER2014PosRbAsrjk1302.getRefNumber(), ER2014PosRbAsrjk1302.getName(), ER2014PosRbAsrjk1302.getObjects()),
	R2015_RB1305 (ER2015PosRbAsrjk1305.getRefNumber(), ER2015PosRbAsrjk1305.getName(), ER2015PosRbAsrjk1305.getObjects()),
	R2016_RB1308 (ER2016PosRbAsrjk1308.getRefNumber(), ER2016PosRbAsrjk1308.getName(), ER2016PosRbAsrjk1308.getObjects()),
	R2017_RB1311 (ER2017PosRbAsrjk1311.getRefNumber(), ER2017PosRbAsrjk1311.getName(), ER2017PosRbAsrjk1311.getObjects()),
	R2018_RB1313 (ER2018PosRbAsrjk1313.getRefNumber(), ER2018PosRbAsrjk1313.getName(), ER2018PosRbAsrjk1313.getObjects()),
	R2019_RE0100 (ER2019PosReAsrjk0100.getRefNumber(), ER2019PosReAsrjk0100.getName(), ER2019PosReAsrjk0100.getObjects()),
	R2020_RE0200 (ER2020PosReAsrjk0200.getRefNumber(), ER2020PosReAsrjk0200.getName(), ER2020PosReAsrjk0200.getObjects()),
	R2021_RE0300 (ER2021PosReAsrjk0300.getRefNumber(), ER2021PosReAsrjk0300.getName(), ER2021PosReAsrjk0300.getObjects()),
	R2022_RE0400 (ER2022PosReAsrjk0400.getRefNumber(), ER2022PosReAsrjk0400.getName(), ER2022PosReAsrjk0400.getObjects()),
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
