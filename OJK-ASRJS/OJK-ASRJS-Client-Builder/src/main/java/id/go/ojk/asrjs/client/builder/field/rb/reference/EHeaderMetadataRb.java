package id.go.ojk.asrjs.client.builder.field.rb.reference;

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
	R2000_RB0101 (ER2000PosRbAsrjs0101.getRefNumber(), ER2000PosRbAsrjs0101.getName(), ER2000PosRbAsrjs0101.getObjects()),
	R2001_RB0102 (ER2001PosRbAsrjs0102.getRefNumber(), ER2001PosRbAsrjs0102.getName(), ER2001PosRbAsrjs0102.getObjects()),
	R2002_RB0103 (ER2002PosRbAsrjs0103.getRefNumber(), ER2002PosRbAsrjs0103.getName(), ER2002PosRbAsrjs0103.getObjects()),
	R2003_RB0104 (ER2003PosRbAsrjs0104.getRefNumber(), ER2003PosRbAsrjs0104.getName(), ER2003PosRbAsrjs0104.getObjects()),
	R2004_RB0105 (ER2004PosRbAsrjs0105.getRefNumber(), ER2004PosRbAsrjs0105.getName(), ER2004PosRbAsrjs0105.getObjects()),
	R2005_RB0106 (ER2005PosRbAsrjs0106.getRefNumber(), ER2005PosRbAsrjs0106.getName(), ER2005PosRbAsrjs0106.getObjects()),
	R2006_RB0201 (ER2006PosRbAsrjs0201.getRefNumber(), ER2006PosRbAsrjs0201.getName(), ER2006PosRbAsrjs0201.getObjects()),
	R2007_RB0202 (ER2007PosRbAsrjs0202.getRefNumber(), ER2007PosRbAsrjs0202.getName(), ER2007PosRbAsrjs0202.getObjects()),
	R2008_RB0203 (ER2008PosRbAsrjs0203.getRefNumber(), ER2008PosRbAsrjs0203.getName(), ER2008PosRbAsrjs0203.getObjects()),
	R2009_RB0401 (ER2009PosRbAsrjs0401.getRefNumber(), ER2009PosRbAsrjs0401.getName(), ER2009PosRbAsrjs0401.getObjects()),
	R2010_RB0501 (ER2010PosRbAsrjs0501.getRefNumber(), ER2010PosRbAsrjs0501.getName(), ER2010PosRbAsrjs0501.getObjects()),
	R2011_RB0601 (ER2011PosRbAsrjs0601.getRefNumber(), ER2011PosRbAsrjs0601.getName(), ER2011PosRbAsrjs0601.getObjects()),
	R2012_RB0602 (ER2012PosRbAsrjs0602.getRefNumber(), ER2012PosRbAsrjs0602.getName(), ER2012PosRbAsrjs0602.getObjects()),
	R2013_RB0603 (ER2013PosRbAsrjs0603.getRefNumber(), ER2013PosRbAsrjs0603.getName(), ER2013PosRbAsrjs0603.getObjects()),
	R2014_RB0604 (ER2014PosRbAsrjs0604.getRefNumber(), ER2014PosRbAsrjs0604.getName(), ER2014PosRbAsrjs0604.getObjects()),
	R2015_RB0605 (ER2015PosRbAsrjs0605.getRefNumber(), ER2015PosRbAsrjs0605.getName(), ER2015PosRbAsrjs0605.getObjects()),
	R2016_RB0606 (ER2016PosRbAsrjs0606.getRefNumber(), ER2016PosRbAsrjs0606.getName(), ER2016PosRbAsrjs0606.getObjects()),
	R2017_RB0701 (ER2017PosRbAsrjs0701.getRefNumber(), ER2017PosRbAsrjs0701.getName(), ER2017PosRbAsrjs0701.getObjects()),
	R2018_RB0901 (ER2018PosRbAsrjs0901.getRefNumber(), ER2018PosRbAsrjs0901.getName(), ER2018PosRbAsrjs0901.getObjects()),
	R2019_RB1001 (ER2019PosRbAsrjs1001.getRefNumber(), ER2019PosRbAsrjs1001.getName(), ER2019PosRbAsrjs1001.getObjects()),
	R2020_RB1002 (ER2020PosRbAsrjs1002.getRefNumber(), ER2020PosRbAsrjs1002.getName(), ER2020PosRbAsrjs1002.getObjects()),
	R2021_RB1003 (ER2021PosRbAsrjs1003.getRefNumber(), ER2021PosRbAsrjs1003.getName(), ER2021PosRbAsrjs1003.getObjects()),
	R2022_RB1004 (ER2022PosRbAsrjs1004.getRefNumber(), ER2022PosRbAsrjs1004.getName(), ER2022PosRbAsrjs1004.getObjects()),
	R2023_RB1005 (ER2023PosRbAsrjs1005.getRefNumber(), ER2023PosRbAsrjs1005.getName(), ER2023PosRbAsrjs1005.getObjects()),
	R2024_RB1201 (ER2024PosRbAsrjs1201.getRefNumber(), ER2024PosRbAsrjs1201.getName(), ER2024PosRbAsrjs1201.getObjects()),
	R2025_RB1202 (ER2025PosRbAsrjs1202.getRefNumber(), ER2025PosRbAsrjs1202.getName(), ER2025PosRbAsrjs1202.getObjects()),
	R2026_RB1203 (ER2026PosRbAsrjs1203.getRefNumber(), ER2026PosRbAsrjs1203.getName(), ER2026PosRbAsrjs1203.getObjects()),
	R2027_RB1204 (ER2027PosRbAsrjs1204.getRefNumber(), ER2027PosRbAsrjs1204.getName(), ER2027PosRbAsrjs1204.getObjects()),
	R2028_RB1205 (ER2028PosRbAsrjs1205.getRefNumber(), ER2028PosRbAsrjs1205.getName(), ER2028PosRbAsrjs1205.getObjects()),
	R2029_RB1206 (ER2029PosRbAsrjs1206.getRefNumber(), ER2029PosRbAsrjs1206.getName(), ER2029PosRbAsrjs1206.getObjects()),
	R2030_RB1207 (ER2030PosRbAsrjs1207.getRefNumber(), ER2030PosRbAsrjs1207.getName(), ER2030PosRbAsrjs1207.getObjects()),
	R2031_RB1208 (ER2031PosRbAsrjs1208.getRefNumber(), ER2031PosRbAsrjs1208.getName(), ER2031PosRbAsrjs1208.getObjects()),
	R2032_RB1209 (ER2032PosRbAsrjs1209.getRefNumber(), ER2032PosRbAsrjs1209.getName(), ER2032PosRbAsrjs1209.getObjects()),
	R2033_RB1210 (ER2033PosRbAsrjs1210.getRefNumber(), ER2033PosRbAsrjs1210.getName(), ER2033PosRbAsrjs1210.getObjects()),
	R2034_RB1301 (ER2034PosRbAsrjs1301.getRefNumber(), ER2034PosRbAsrjs1301.getName(), ER2034PosRbAsrjs1301.getObjects()),
	R2035_RB1302 (ER2035PosRbAsrjs1302.getRefNumber(), ER2035PosRbAsrjs1302.getName(), ER2035PosRbAsrjs1302.getObjects()),
	R2036_RB1303 (ER2036PosRbAsrjs1303.getRefNumber(), ER2036PosRbAsrjs1303.getName(), ER2036PosRbAsrjs1303.getObjects()),
	R2037_RE0101 (ER2037PosReAsrjs0101.getRefNumber(), ER2037PosReAsrjs0101.getName(), ER2037PosReAsrjs0101.getObjects()),
	R2038_RE0102 (ER2038PosReAsrjs0102.getRefNumber(), ER2038PosReAsrjs0102.getName(), ER2038PosReAsrjs0102.getObjects()),
	R2039_RE0103 (ER2039PosReAsrjs0103.getRefNumber(), ER2039PosReAsrjs0103.getName(), ER2039PosReAsrjs0103.getObjects()),
	R2040_RE0201 (ER2040PosReAsrjs0201.getRefNumber(), ER2040PosReAsrjs0201.getName(), ER2040PosReAsrjs0201.getObjects()),
	R2041_RE0202 (ER2041PosReAsrjs0202.getRefNumber(), ER2041PosReAsrjs0202.getName(), ER2041PosReAsrjs0202.getObjects()),
	R2042_RE0203 (ER2042PosReAsrjs0203.getRefNumber(), ER2042PosReAsrjs0203.getName(), ER2042PosReAsrjs0203.getObjects()),
	R2043_RE0301 (ER2043PosReAsrjs0301.getRefNumber(), ER2043PosReAsrjs0301.getName(), ER2043PosReAsrjs0301.getObjects()),
	R2044_RE0302 (ER2044PosReAsrjs0302.getRefNumber(), ER2044PosReAsrjs0302.getName(), ER2044PosReAsrjs0302.getObjects()),
	R2045_RE0303 (ER2045PosReAsrjs0303.getRefNumber(), ER2045PosReAsrjs0303.getName(), ER2045PosReAsrjs0303.getObjects()),
	R2046_RE0401 (ER2046PosReAsrjs0401.getRefNumber(), ER2046PosReAsrjs0401.getName(), ER2046PosReAsrjs0401.getObjects()),
	R2047_RE0402 (ER2047PosReAsrjs0402.getRefNumber(), ER2047PosReAsrjs0402.getName(), ER2047PosReAsrjs0402.getObjects()),
	R2048_RE0403 (ER2048PosReAsrjs0403.getRefNumber(), ER2048PosReAsrjs0403.getName(), ER2048PosReAsrjs0403.getObjects()),
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
