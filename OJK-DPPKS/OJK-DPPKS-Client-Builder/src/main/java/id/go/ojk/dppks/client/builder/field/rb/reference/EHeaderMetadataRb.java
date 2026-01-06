package id.go.ojk.dppks.client.builder.field.rb.reference;

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
	R2000_RB0100 (ER2000PosRbDppks0100.getRefNumber(), ER2000PosRbDppks0100.getName(), ER2000PosRbDppks0100.getObjects()),
	R2001_RB0204 (ER2001PosRbDppks0204.getRefNumber(), ER2001PosRbDppks0204.getName(), ER2001PosRbDppks0204.getObjects()),
	R2002_RB0205 (ER2002PosRbDppks0205.getRefNumber(), ER2002PosRbDppks0205.getName(), ER2002PosRbDppks0205.getObjects()),
	R2003_RB0301 (ER2003PosRbDppks0301.getRefNumber(), ER2003PosRbDppks0301.getName(), ER2003PosRbDppks0301.getObjects()),
	R2004_RB0403 (ER2004PosRbDppks0403.getRefNumber(), ER2004PosRbDppks0403.getName(), ER2004PosRbDppks0403.getObjects()),
	R2005_RB0600 (ER2005PosRbDppks0600.getRefNumber(), ER2005PosRbDppks0600.getName(), ER2005PosRbDppks0600.getObjects()),
	R2006_RB0701 (ER2006PosRbDppks0701.getRefNumber(), ER2006PosRbDppks0701.getName(), ER2006PosRbDppks0701.getObjects()),
	R2007_RB0702 (ER2007PosRbDppks0702.getRefNumber(), ER2007PosRbDppks0702.getName(), ER2007PosRbDppks0702.getObjects()),
	R2008_RB0703 (ER2008PosRbDppks0703.getRefNumber(), ER2008PosRbDppks0703.getName(), ER2008PosRbDppks0703.getObjects()),
	R2009_RB0801 (ER2009PosRbDppks0801.getRefNumber(), ER2009PosRbDppks0801.getName(), ER2009PosRbDppks0801.getObjects()),
	R2010_RB0802 (ER2010PosRbDppks0802.getRefNumber(), ER2010PosRbDppks0802.getName(), ER2010PosRbDppks0802.getObjects()),
	R2011_RB0900 (ER2011PosRbDppks0900.getRefNumber(), ER2011PosRbDppks0900.getName(), ER2011PosRbDppks0900.getObjects()),
	R2012_RB1001 (ER2012PosRbDppks1001.getRefNumber(), ER2012PosRbDppks1001.getName(), ER2012PosRbDppks1001.getObjects()),
	R2013_RB1002 (ER2013PosRbDppks1002.getRefNumber(), ER2013PosRbDppks1002.getName(), ER2013PosRbDppks1002.getObjects()),
	R2014_RB1003 (ER2014PosRbDppks1003.getRefNumber(), ER2014PosRbDppks1003.getName(), ER2014PosRbDppks1003.getObjects()),
	R2015_RB1004 (ER2015PosRbDppks1004.getRefNumber(), ER2015PosRbDppks1004.getName(), ER2015PosRbDppks1004.getObjects()),
	R2016_RB1201 (ER2016PosRbDppks1201.getRefNumber(), ER2016PosRbDppks1201.getName(), ER2016PosRbDppks1201.getObjects()),
	R2017_RB1202 (ER2017PosRbDppks1202.getRefNumber(), ER2017PosRbDppks1202.getName(), ER2017PosRbDppks1202.getObjects()),
	R2018_RB1203 (ER2018PosRbDppks1203.getRefNumber(), ER2018PosRbDppks1203.getName(), ER2018PosRbDppks1203.getObjects()),
//	R2019_RB9001 (ER2019PosRbDppks9001.getRefNumber(), ER2019PosRbDppks9001.getName(), ER2019PosRbDppks9001.getObjects()),
//	R2020_RB9002 (ER2020PosRbDppks9002.getRefNumber(), ER2020PosRbDppks9002.getName(), ER2020PosRbDppks9002.getObjects()),
	R2021_RE0100 (ER2021PosReDppks0100.getRefNumber(), ER2021PosReDppks0100.getName(), ER2021PosReDppks0100.getObjects()),
	R2022_RE0200 (ER2022PosReDppks0200.getRefNumber(), ER2022PosReDppks0200.getName(), ER2022PosReDppks0200.getObjects()),
	R2023_RE0300 (ER2023PosReDppks0300.getRefNumber(), ER2023PosReDppks0300.getName(), ER2023PosReDppks0300.getObjects()),
	R2024_RE0400 (ER2024PosReDppks0400.getRefNumber(), ER2024PosReDppks0400.getName(), ER2024PosReDppks0400.getObjects()),
	R2025_RE0500 (ER2025PosReDppks0500.getRefNumber(), ER2025PosReDppks0500.getName(), ER2025PosReDppks0500.getObjects()),
//	R2026_RE9001 (ER2026PosReDppks9001.getRefNumber(), ER2026PosReDppks9001.getName(), ER2026PosReDppks9001.getObjects()),
//	R2027_RE9002 (ER2027PosReDppks9002.getRefNumber(), ER2027PosReDppks9002.getName(), ER2027PosReDppks9002.getObjects()),
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
