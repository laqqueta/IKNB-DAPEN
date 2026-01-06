package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
	R2000_RB0100 (ER2000PosRbDppkk0100.getRefNumber(), ER2000PosRbDppkk0100.getName(), ER2000PosRbDppkk0100.getObjects()),
	R2001_RB0200 (ER2001PosRbDppkk0200.getRefNumber(), ER2001PosRbDppkk0200.getName(), ER2001PosRbDppkk0200.getObjects()),
	R2002_RB0300 (ER2002PosRbDppkk0300.getRefNumber(), ER2002PosRbDppkk0300.getName(), ER2002PosRbDppkk0300.getObjects()),
	R2003_RB0400 (ER2003PosRbDppkk0400.getRefNumber(), ER2003PosRbDppkk0400.getName(), ER2003PosRbDppkk0400.getObjects()),
	R2004_RB0500 (ER2004PosRbDppkk0500.getRefNumber(), ER2004PosRbDppkk0500.getName(), ER2004PosRbDppkk0500.getObjects()),
	R2005_RB0600 (ER2005PosRbDppkk0600.getRefNumber(), ER2005PosRbDppkk0600.getName(), ER2005PosRbDppkk0600.getObjects()),
	R2006_RB0700 (ER2006PosRbDppkk0700.getRefNumber(), ER2006PosRbDppkk0700.getName(), ER2006PosRbDppkk0700.getObjects()),
	R2007_RB0800 (ER2007PosRbDppkk0800.getRefNumber(), ER2007PosRbDppkk0800.getName(), ER2007PosRbDppkk0800.getObjects()),
	R2008_RB0900 (ER2008PosRbDppkk0900.getRefNumber(), ER2008PosRbDppkk0900.getName(), ER2008PosRbDppkk0900.getObjects()),
	R2009_RB1000 (ER2009PosRbDppkk1000.getRefNumber(), ER2009PosRbDppkk1000.getName(), ER2009PosRbDppkk1000.getObjects()),
	R2010_RB1100 (ER2010PosRbDppkk1100.getRefNumber(), ER2010PosRbDppkk1100.getName(), ER2010PosRbDppkk1100.getObjects()),
	R2011_RB1200 (ER2011PosRbDppkk1200.getRefNumber(), ER2011PosRbDppkk1200.getName(), ER2011PosRbDppkk1200.getObjects()),
	R2012_RB1300 (ER2012PosRbDppkk1300.getRefNumber(), ER2012PosRbDppkk1300.getName(), ER2012PosRbDppkk1300.getObjects()),
	R2013_RB1400 (ER2013PosRbDppkk1400.getRefNumber(), ER2013PosRbDppkk1400.getName(), ER2013PosRbDppkk1400.getObjects()),
	R2014_RB1500 (ER2014PosRbDppkk1500.getRefNumber(), ER2014PosRbDppkk1500.getName(), ER2014PosRbDppkk1500.getObjects()),
//	R2015_RB9001 (ER2015PosRbDppkk9001.getRefNumber(), ER2015PosRbDppkk9001.getName(), ER2015PosRbDppkk9001.getObjects()),
//	R2016_RB9002 (ER2016PosRbDppkk9002.getRefNumber(), ER2016PosRbDppkk9002.getName(), ER2016PosRbDppkk9002.getObjects()),
	R2017_RE0100 (ER2017PosReDppkk0100.getRefNumber(), ER2017PosReDppkk0100.getName(), ER2017PosReDppkk0100.getObjects()),
	R2018_RE0200 (ER2018PosReDppkk0200.getRefNumber(), ER2018PosReDppkk0200.getName(), ER2018PosReDppkk0200.getObjects()),
	R2019_RE0300 (ER2019PosReDppkk0300.getRefNumber(), ER2019PosReDppkk0300.getName(), ER2019PosReDppkk0300.getObjects()),
	R2020_RE0400 (ER2020PosReDppkk0400.getRefNumber(), ER2020PosReDppkk0400.getName(), ER2020PosReDppkk0400.getObjects()),
	R2021_RE0500 (ER2021PosReDppkk0500.getRefNumber(), ER2021PosReDppkk0500.getName(), ER2021PosReDppkk0500.getObjects()),
//	R2022_RE9001 (ER2022PosReDppkk9001.getRefNumber(), ER2022PosReDppkk9001.getName(), ER2022PosReDppkk9001.getObjects()),
//	R2023_RE9002 (ER2023PosReDppkk9002.getRefNumber(), ER2023PosReDppkk9002.getName(), ER2023PosReDppkk9002.getObjects()),
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
