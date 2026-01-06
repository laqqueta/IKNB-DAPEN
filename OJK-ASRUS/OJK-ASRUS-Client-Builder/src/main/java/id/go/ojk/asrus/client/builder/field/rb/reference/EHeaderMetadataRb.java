package id.go.ojk.asrus.client.builder.field.rb.reference;

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
	R2000_RB0101 (ER2000PosRbAsrus0101.getRefNumber(), ER2000PosRbAsrus0101.getName(), ER2000PosRbAsrus0101.getObjects()),
	R2001_RB0102 (ER2001PosRbAsrus0102.getRefNumber(), ER2001PosRbAsrus0102.getName(), ER2001PosRbAsrus0102.getObjects()),
	R2002_RB0103 (ER2002PosRbAsrus0103.getRefNumber(), ER2002PosRbAsrus0103.getName(), ER2002PosRbAsrus0103.getObjects()),
	R2003_RB0104 (ER2003PosRbAsrus0104.getRefNumber(), ER2003PosRbAsrus0104.getName(), ER2003PosRbAsrus0104.getObjects()),
	R2004_RB0105 (ER2004PosRbAsrus0105.getRefNumber(), ER2004PosRbAsrus0105.getName(), ER2004PosRbAsrus0105.getObjects()),
	R2005_RB0106 (ER2005PosRbAsrus0106.getRefNumber(), ER2005PosRbAsrus0106.getName(), ER2005PosRbAsrus0106.getObjects()),
	R2006_RB0201 (ER2006PosRbAsrus0201.getRefNumber(), ER2006PosRbAsrus0201.getName(), ER2006PosRbAsrus0201.getObjects()),
	R2007_RB0202 (ER2007PosRbAsrus0202.getRefNumber(), ER2007PosRbAsrus0202.getName(), ER2007PosRbAsrus0202.getObjects()),
	R2008_RB0203 (ER2008PosRbAsrus0203.getRefNumber(), ER2008PosRbAsrus0203.getName(), ER2008PosRbAsrus0203.getObjects()),
	R2009_RB0401 (ER2009PosRbAsrus0401.getRefNumber(), ER2009PosRbAsrus0401.getName(), ER2009PosRbAsrus0401.getObjects()),
	R2010_RB0501 (ER2010PosRbAsrus0501.getRefNumber(), ER2010PosRbAsrus0501.getName(), ER2010PosRbAsrus0501.getObjects()),
	R2011_RB0601 (ER2011PosRbAsrus0601.getRefNumber(), ER2011PosRbAsrus0601.getName(), ER2011PosRbAsrus0601.getObjects()),
	R2012_RB0602 (ER2012PosRbAsrus0602.getRefNumber(), ER2012PosRbAsrus0602.getName(), ER2012PosRbAsrus0602.getObjects()),
	R2013_RB0603 (ER2013PosRbAsrus0603.getRefNumber(), ER2013PosRbAsrus0603.getName(), ER2013PosRbAsrus0603.getObjects()),
	R2014_RB0604 (ER2014PosRbAsrus0604.getRefNumber(), ER2014PosRbAsrus0604.getName(), ER2014PosRbAsrus0604.getObjects()),
	R2015_RB0605 (ER2015PosRbAsrus0605.getRefNumber(), ER2015PosRbAsrus0605.getName(), ER2015PosRbAsrus0605.getObjects()),
	R2016_RB0606 (ER2016PosRbAsrus0606.getRefNumber(), ER2016PosRbAsrus0606.getName(), ER2016PosRbAsrus0606.getObjects()),
	R2017_RB0701 (ER2017PosRbAsrus0701.getRefNumber(), ER2017PosRbAsrus0701.getName(), ER2017PosRbAsrus0701.getObjects()),
	R2018_RB0901 (ER2018PosRbAsrus0901.getRefNumber(), ER2018PosRbAsrus0901.getName(), ER2018PosRbAsrus0901.getObjects()),
	R2019_RB1001 (ER2019PosRbAsrus1001.getRefNumber(), ER2019PosRbAsrus1001.getName(), ER2019PosRbAsrus1001.getObjects()),
	R2020_RB1002 (ER2020PosRbAsrus1002.getRefNumber(), ER2020PosRbAsrus1002.getName(), ER2020PosRbAsrus1002.getObjects()),
	R2021_RB1003 (ER2021PosRbAsrus1003.getRefNumber(), ER2021PosRbAsrus1003.getName(), ER2021PosRbAsrus1003.getObjects()),
	R2022_RB1004 (ER2022PosRbAsrus1004.getRefNumber(), ER2022PosRbAsrus1004.getName(), ER2022PosRbAsrus1004.getObjects()),
	R2023_RB1005 (ER2023PosRbAsrus1005.getRefNumber(), ER2023PosRbAsrus1005.getName(), ER2023PosRbAsrus1005.getObjects()),
	R2024_RB1201 (ER2024PosRbAsrus1201.getRefNumber(), ER2024PosRbAsrus1201.getName(), ER2024PosRbAsrus1201.getObjects()),
	R2025_RB1202 (ER2025PosRbAsrus1202.getRefNumber(), ER2025PosRbAsrus1202.getName(), ER2025PosRbAsrus1202.getObjects()),
	R2026_RB1203 (ER2026PosRbAsrus1203.getRefNumber(), ER2026PosRbAsrus1203.getName(), ER2026PosRbAsrus1203.getObjects()),
	R2027_RB1204 (ER2027PosRbAsrus1204.getRefNumber(), ER2027PosRbAsrus1204.getName(), ER2027PosRbAsrus1204.getObjects()),
	R2028_RB1205 (ER2028PosRbAsrus1205.getRefNumber(), ER2028PosRbAsrus1205.getName(), ER2028PosRbAsrus1205.getObjects()),
	R2029_RB1206 (ER2029PosRbAsrus1206.getRefNumber(), ER2029PosRbAsrus1206.getName(), ER2029PosRbAsrus1206.getObjects()),
	R2030_RB1207 (ER2030PosRbAsrus1207.getRefNumber(), ER2030PosRbAsrus1207.getName(), ER2030PosRbAsrus1207.getObjects()),
	R2031_RB1208 (ER2031PosRbAsrus1208.getRefNumber(), ER2031PosRbAsrus1208.getName(), ER2031PosRbAsrus1208.getObjects()),
	R2032_RB1209 (ER2032PosRbAsrus1209.getRefNumber(), ER2032PosRbAsrus1209.getName(), ER2032PosRbAsrus1209.getObjects()),
	R2033_RB1210 (ER2033PosRbAsrus1210.getRefNumber(), ER2033PosRbAsrus1210.getName(), ER2033PosRbAsrus1210.getObjects()),
	R2034_RB1301 (ER2034PosRbAsrus1301.getRefNumber(), ER2034PosRbAsrus1301.getName(), ER2034PosRbAsrus1301.getObjects()),
	R2035_RB1302 (ER2035PosRbAsrus1302.getRefNumber(), ER2035PosRbAsrus1302.getName(), ER2035PosRbAsrus1302.getObjects()),
	R2036_RB1303 (ER2036PosRbAsrus1303.getRefNumber(), ER2036PosRbAsrus1303.getName(), ER2036PosRbAsrus1303.getObjects()),
	R2037_RE0101 (ER2037PosReAsrus0101.getRefNumber(), ER2037PosReAsrus0101.getName(), ER2037PosReAsrus0101.getObjects()),
	R2038_RE0102 (ER2038PosReAsrus0102.getRefNumber(), ER2038PosReAsrus0102.getName(), ER2038PosReAsrus0102.getObjects()),
	R2039_RE0103 (ER2039PosReAsrus0103.getRefNumber(), ER2039PosReAsrus0103.getName(), ER2039PosReAsrus0103.getObjects()),
	R2040_RE0201 (ER2040PosReAsrus0201.getRefNumber(), ER2040PosReAsrus0201.getName(), ER2040PosReAsrus0201.getObjects()),
	R2041_RE0202 (ER2041PosReAsrus0202.getRefNumber(), ER2041PosReAsrus0202.getName(), ER2041PosReAsrus0202.getObjects()),
	R2042_RE0203 (ER2042PosReAsrus0203.getRefNumber(), ER2042PosReAsrus0203.getName(), ER2042PosReAsrus0203.getObjects()),
	R2043_RE0301 (ER2043PosReAsrus0301.getRefNumber(), ER2043PosReAsrus0301.getName(), ER2043PosReAsrus0301.getObjects()),
	R2044_RE0302 (ER2044PosReAsrus0302.getRefNumber(), ER2044PosReAsrus0302.getName(), ER2044PosReAsrus0302.getObjects()),
	R2045_RE0303 (ER2045PosReAsrus0303.getRefNumber(), ER2045PosReAsrus0303.getName(), ER2045PosReAsrus0303.getObjects()),
	R2046_RE0401 (ER2046PosReAsrus0401.getRefNumber(), ER2046PosReAsrus0401.getName(), ER2046PosReAsrus0401.getObjects()),
	R2047_RE0402 (ER2047PosReAsrus0402.getRefNumber(), ER2047PosReAsrus0402.getName(), ER2047PosReAsrus0402.getObjects()),
	R2048_RE0403 (ER2048PosReAsrus0403.getRefNumber(), ER2048PosReAsrus0403.getName(), ER2048PosReAsrus0403.getObjects()),
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
