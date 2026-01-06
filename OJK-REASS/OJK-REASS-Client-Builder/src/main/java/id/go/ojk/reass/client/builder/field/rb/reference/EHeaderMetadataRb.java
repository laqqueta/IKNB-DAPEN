package id.go.ojk.reass.client.builder.field.rb.reference;

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
	R2000_RB0101(ER2000PosRbReass0101.getRefNumber(), ER2000PosRbReass0101.getName(), ER2000PosRbReass0101.getObjects()),
	R2001_RB0102(ER2001PosRbReass0102.getRefNumber(), ER2001PosRbReass0102.getName(), ER2001PosRbReass0102.getObjects()),
	R2002_RB0103(ER2002PosRbReass0103.getRefNumber(), ER2002PosRbReass0103.getName(), ER2002PosRbReass0103.getObjects()),
	R2003_RB0104(ER2003PosRbReass0104.getRefNumber(), ER2003PosRbReass0104.getName(), ER2003PosRbReass0104.getObjects()),
	R2004_RB0201(ER2004PosRbReass0201.getRefNumber(), ER2004PosRbReass0201.getName(), ER2004PosRbReass0201.getObjects()),
	R2005_RB0202(ER2005PosRbReass0202.getRefNumber(), ER2005PosRbReass0202.getName(), ER2005PosRbReass0202.getObjects()),
	R2006_RB0401(ER2006PosRbReass0401.getRefNumber(), ER2006PosRbReass0401.getName(), ER2006PosRbReass0401.getObjects()),
	R2007_RB0501(ER2007PosRbReass0501.getRefNumber(), ER2007PosRbReass0501.getName(), ER2007PosRbReass0501.getObjects()),
	R2008_RB0601(ER2008PosRbReass0601.getRefNumber(), ER2008PosRbReass0601.getName(), ER2008PosRbReass0601.getObjects()),
	R2009_RB0602(ER2009PosRbReass0602.getRefNumber(), ER2009PosRbReass0602.getName(), ER2009PosRbReass0602.getObjects()),
	R2010_RB0603(ER2010PosRbReass0603.getRefNumber(), ER2010PosRbReass0603.getName(), ER2010PosRbReass0603.getObjects()),
	R2011_RB0604(ER2011PosRbReass0604.getRefNumber(), ER2011PosRbReass0604.getName(), ER2011PosRbReass0604.getObjects()),
	R2012_RB0701(ER2012PosRbReass0701.getRefNumber(), ER2012PosRbReass0701.getName(), ER2012PosRbReass0701.getObjects()),
	R2013_RB0901(ER2013PosRbReass0901.getRefNumber(), ER2013PosRbReass0901.getName(), ER2013PosRbReass0901.getObjects()),
	R2014_RB1001(ER2014PosRbReass1001.getRefNumber(), ER2014PosRbReass1001.getName(), ER2014PosRbReass1001.getObjects()),
	R2015_RB1002(ER2015PosRbReass1002.getRefNumber(), ER2015PosRbReass1002.getName(), ER2015PosRbReass1002.getObjects()),
	R2016_RB1003(ER2016PosRbReass1003.getRefNumber(), ER2016PosRbReass1003.getName(), ER2016PosRbReass1003.getObjects()),
	R2017_RB1004(ER2017PosRbReass1004.getRefNumber(), ER2017PosRbReass1004.getName(), ER2017PosRbReass1004.getObjects()),
	R2018_RB1005(ER2018PosRbReass1005.getRefNumber(), ER2018PosRbReass1005.getName(), ER2018PosRbReass1005.getObjects()),
	R2019_RB1201(ER2019PosRbReass1201.getRefNumber(), ER2019PosRbReass1201.getName(), ER2019PosRbReass1201.getObjects()),
	R2020_RB1202(ER2020PosRbReass1202.getRefNumber(), ER2020PosRbReass1202.getName(), ER2020PosRbReass1202.getObjects()),
	R2021_RB1203(ER2021PosRbReass1203.getRefNumber(), ER2021PosRbReass1203.getName(), ER2021PosRbReass1203.getObjects()),
	R2022_RB1204(ER2022PosRbReass1204.getRefNumber(), ER2022PosRbReass1204.getName(), ER2022PosRbReass1204.getObjects()),
	R2023_RB1205(ER2023PosRbReass1205.getRefNumber(), ER2023PosRbReass1205.getName(), ER2023PosRbReass1205.getObjects()),
	R2024_RB1206(ER2024PosRbReass1206.getRefNumber(), ER2024PosRbReass1206.getName(), ER2024PosRbReass1206.getObjects()),
	R2025_RB1207(ER2025PosRbReass1207.getRefNumber(), ER2025PosRbReass1207.getName(), ER2025PosRbReass1207.getObjects()),
	R2026_RB1301(ER2026PosRbReass1301.getRefNumber(), ER2026PosRbReass1301.getName(), ER2026PosRbReass1301.getObjects()),
	R2027_RB1302(ER2027PosRbReass1302.getRefNumber(), ER2027PosRbReass1302.getName(), ER2027PosRbReass1302.getObjects()),
	R2028_RE0101(ER2028PosReReass0101.getRefNumber(), ER2028PosReReass0101.getName(), ER2028PosReReass0101.getObjects()),
	R2029_RE0102(ER2029PosReReass0102.getRefNumber(), ER2029PosReReass0102.getName(), ER2029PosReReass0102.getObjects()),
	R2030_RE0201(ER2030PosReReass0201.getRefNumber(), ER2030PosReReass0201.getName(), ER2030PosReReass0201.getObjects()),
	R2031_RE0202(ER2031PosReReass0202.getRefNumber(), ER2031PosReReass0202.getName(), ER2031PosReReass0202.getObjects()),
	R2032_RE0301(ER2032PosReReass0301.getRefNumber(), ER2032PosReReass0301.getName(), ER2032PosReReass0301.getObjects()),
	R2033_RE0302(ER2033PosReReass0302.getRefNumber(), ER2033PosReReass0302.getName(), ER2033PosReReass0302.getObjects()),
	R2034_RE0401(ER2034PosReReass0401.getRefNumber(), ER2034PosReReass0401.getName(), ER2034PosReReass0401.getObjects()),
	R2035_RE0402(ER2035PosReReass0402.getRefNumber(), ER2035PosReReass0402.getName(), ER2035PosReReass0402.getObjects()),
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
