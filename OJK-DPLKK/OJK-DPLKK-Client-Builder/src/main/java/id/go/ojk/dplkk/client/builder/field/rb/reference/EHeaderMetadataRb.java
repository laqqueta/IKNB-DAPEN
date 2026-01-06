package id.go.ojk.dplkk.client.builder.field.rb.reference;

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
	R2000_RB0100 (ER2000PosRbDplkk0100.getRefNumber(), ER2000PosRbDplkk0100.getName(), ER2000PosRbDplkk0100.getObjects()),
	R2001_RB0200 (ER2001PosRbDplkk0200.getRefNumber(), ER2001PosRbDplkk0200.getName(), ER2001PosRbDplkk0200.getObjects()),
	R2002_RB0300 (ER2002PosRbDplkk0300.getRefNumber(), ER2002PosRbDplkk0300.getName(), ER2002PosRbDplkk0300.getObjects()),
	R2003_RB0400 (ER2003PosRbDplkk0400.getRefNumber(), ER2003PosRbDplkk0400.getName(), ER2003PosRbDplkk0400.getObjects()),
	R2004_RB0500 (ER2004PosRbDplkk0500.getRefNumber(), ER2004PosRbDplkk0500.getName(), ER2004PosRbDplkk0500.getObjects()),
	R2005_RB0600 (ER2005PosRbDplkk0600.getRefNumber(), ER2005PosRbDplkk0600.getName(), ER2005PosRbDplkk0600.getObjects()),
	R2006_RB0700 (ER2006PosRbDplkk0700.getRefNumber(), ER2006PosRbDplkk0700.getName(), ER2006PosRbDplkk0700.getObjects()),
	R2007_RB0800 (ER2007PosRbDplkk0800.getRefNumber(), ER2007PosRbDplkk0800.getName(), ER2007PosRbDplkk0800.getObjects()),
	R2008_RB0900 (ER2008PosRbDplkk0900.getRefNumber(), ER2008PosRbDplkk0900.getName(), ER2008PosRbDplkk0900.getObjects()),
	R2009_RB1000 (ER2009PosRbDplkk1000.getRefNumber(), ER2009PosRbDplkk1000.getName(), ER2009PosRbDplkk1000.getObjects()),
	R2010_RB1100 (ER2010PosRbDplkk1100.getRefNumber(), ER2010PosRbDplkk1100.getName(), ER2010PosRbDplkk1100.getObjects()),
	R2011_RB1200 (ER2011PosRbDplkk1200.getRefNumber(), ER2011PosRbDplkk1200.getName(), ER2011PosRbDplkk1200.getObjects()),
	R2012_RB1300 (ER2012PosRbDplkk1300.getRefNumber(), ER2012PosRbDplkk1300.getName(), ER2012PosRbDplkk1300.getObjects()),
	R2013_RB1400 (ER2013PosRbDplkk1400.getRefNumber(), ER2013PosRbDplkk1400.getName(), ER2013PosRbDplkk1400.getObjects()),
	R2014_RB1500 (ER2014PosRbDplkk1500.getRefNumber(), ER2014PosRbDplkk1500.getName(), ER2014PosRbDplkk1500.getObjects()),
//	R2015_RB9001 (ER2015PosRbDplkk9001.getRefNumber(), ER2015PosRbDplkk9001.getName(), ER2015PosRbDplkk9001.getObjects()),
//	R2016_RB9002 (ER2016PosRbDplkk9002.getRefNumber(), ER2016PosRbDplkk9002.getName(), ER2016PosRbDplkk9002.getObjects()),
	R2017_RE0100 (ER2017PosReDplkk0100.getRefNumber(), ER2017PosReDplkk0100.getName(), ER2017PosReDplkk0100.getObjects()),
	R2018_RE0200 (ER2018PosReDplkk0200.getRefNumber(), ER2018PosReDplkk0200.getName(), ER2018PosReDplkk0200.getObjects()),
	R2019_RE0300 (ER2019PosReDplkk0300.getRefNumber(), ER2019PosReDplkk0300.getName(), ER2019PosReDplkk0300.getObjects()),
	R2020_RE0400 (1020, "PosReDplkk0400", ER1020PosReDplkk0400.getObjects()),
	R2021_RE0500 (1021, "PosReDplkk0500", ER1021PosReDplkk0500.getObjects()),
//	R2022_RE9001 (1022, "PosReDplkk9001", ER1022PosReDplkk9001.getObjects()),
//	R3023_RE9002 (1023, "PosReDplkk9002", ER1023PosReDplkk9002.getObjects()),
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
