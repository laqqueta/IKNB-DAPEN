package id.go.ojk.dplks.client.builder.field.rb.reference;

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
	R2000_RB0100 (ER2000PosRbDplks0100.getRefNumber(), ER2000PosRbDplks0100.getName(), ER2000PosRbDplks0100.getObjects()),
	R2001_RB0204 (ER2001PosRbDplks0204.getRefNumber(), ER2001PosRbDplks0204.getName(), ER2001PosRbDplks0204.getObjects()),
	R2002_RB0205 (ER2002PosRbDplks0205.getRefNumber(), ER2002PosRbDplks0205.getName(), ER2002PosRbDplks0205.getObjects()),
	R2003_RB0301 (ER2003PosRbDplks0301.getRefNumber(), ER2003PosRbDplks0301.getName(), ER2003PosRbDplks0301.getObjects()),
	R2004_RB0403 (ER2004PosRbDplks0403.getRefNumber(), ER2004PosRbDplks0403.getName(), ER2004PosRbDplks0403.getObjects()),
	R2005_RB0600 (ER2005PosRbDplks0600.getRefNumber(), ER2005PosRbDplks0600.getName(), ER2005PosRbDplks0600.getObjects()),
	R2006_RB0701 (ER2006PosRbDplks0701.getRefNumber(), ER2006PosRbDplks0701.getName(), ER2006PosRbDplks0701.getObjects()),
	R2007_RB0702 (ER2007PosRbDplks0702.getRefNumber(), ER2007PosRbDplks0702.getName(), ER2007PosRbDplks0702.getObjects()),
	R2008_RB0703 (ER2008PosRbDplks0703.getRefNumber(), ER2008PosRbDplks0703.getName(), ER2008PosRbDplks0703.getObjects()),
	R2009_RB0801 (ER2009PosRbDplks0801.getRefNumber(), ER2009PosRbDplks0801.getName(), ER2009PosRbDplks0801.getObjects()),
	R2010_RB0802 (ER2010PosRbDplks0802.getRefNumber(), ER2010PosRbDplks0802.getName(), ER2010PosRbDplks0802.getObjects()),
	R2011_RB0900 (ER2011PosRbDplks0900.getRefNumber(), ER2011PosRbDplks0900.getName(), ER2011PosRbDplks0900.getObjects()),
	R2012_RB1001 (ER2012PosRbDplks1001.getRefNumber(), ER2012PosRbDplks1001.getName(), ER2012PosRbDplks1001.getObjects()),
	R2013_RB1002 (ER2013PosRbDplks1002.getRefNumber(), ER2013PosRbDplks1002.getName(), ER2013PosRbDplks1002.getObjects()),
	R2014_RB1003 (ER2014PosRbDplks1003.getRefNumber(), ER2014PosRbDplks1003.getName(), ER2014PosRbDplks1003.getObjects()),
	R2015_RB1004 (ER2015PosRbDplks1004.getRefNumber(), ER2015PosRbDplks1004.getName(), ER2015PosRbDplks1004.getObjects()),
	R2016_RB1201 (ER2016PosRbDplks1201.getRefNumber(), ER2016PosRbDplks1201.getName(), ER2016PosRbDplks1201.getObjects()),
	R2017_RB1202 (ER2017PosRbDplks1202.getRefNumber(), ER2017PosRbDplks1202.getName(), ER2017PosRbDplks1202.getObjects()),
	R2018_RB1203 (ER2018PosRbDplks1203.getRefNumber(), ER2018PosRbDplks1203.getName(), ER2018PosRbDplks1203.getObjects()),
//	R2019_RB9001 (ER2019PosRbDplks9001.getRefNumber(), ER2019PosRbDplks9001.getName(), ER2019PosRbDplks9001.getObjects()),
//	R2020_RB9002 (ER2020PosRbDplks9002.getRefNumber(), ER2020PosRbDplks9002.getName(), ER2020PosRbDplks9002.getObjects()),
	R2020_RE0100 (ER2020PosReDplks0100.getRefNumber(), ER2020PosReDplks0100.getName(), ER2020PosReDplks0100.getObjects()),
	R2021_RE0200 (ER2021PosReDplks0200.getRefNumber(), ER2021PosReDplks0200.getName(), ER2021PosReDplks0200.getObjects()),
	R2022_RE0300 (ER2022PosReDplks0300.getRefNumber(), ER2022PosReDplks0300.getName(), ER2022PosReDplks0300.getObjects()),
	R2023_RE0400 (ER2023PosReDplks0400.getRefNumber(), ER2023PosReDplks0400.getName(), ER2023PosReDplks0400.getObjects()),
	R2024_RE0500 (ER2024PosReDplks0500.getRefNumber(), ER2024PosReDplks0500.getName(), ER2024PosReDplks0500.getObjects()),
//	R2025_RE9001 (ER2025PosReDplks9001.getRefNumber(), ER2025PosReDplks9001.getName(), ER2025PosReDplks9001.getObjects()),
//	R2026_RE9002 (ER2026PosReDplks9002.getRefNumber(), ER2026PosReDplks9002.getName(), ER2026PosReDplks9002.getObjects()),
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
