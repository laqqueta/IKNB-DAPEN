package id.go.ojk.pmvk.client.builder.field.rb.reference;

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
	R2000_RB010401 (ER2000PosRbPmvk010401.getRefNumber(), ER2000PosRbPmvk010401.getName(), ER2000PosRbPmvk010401.getObjects()),
	R2001_RB040101 (ER2001PosRbPmvk040101.getRefNumber(), ER2001PosRbPmvk040101.getName(), ER2001PosRbPmvk040101.getObjects()),
	R2002_RB040201 (ER2002PosRbPmvk040201.getRefNumber(), ER2002PosRbPmvk040201.getName(), ER2002PosRbPmvk040201.getObjects()),
	R2003_RB040301 (ER2003PosRbPmvk040301.getRefNumber(), ER2003PosRbPmvk040301.getName(), ER2003PosRbPmvk040301.getObjects()),
	R2004_RB050101 (ER2004PosRbPmvk050101.getRefNumber(), ER2004PosRbPmvk050101.getName(), ER2004PosRbPmvk050101.getObjects()),
	R2005_RB050201 (ER2005PosRbPmvk050201.getRefNumber(), ER2005PosRbPmvk050201.getName(), ER2005PosRbPmvk050201.getObjects()),
	R2006_RB060100 (ER2006PosRbPmvk060100.getRefNumber(), ER2006PosRbPmvk060100.getName(), ER2006PosRbPmvk060100.getObjects()),
	R2007_RB070101 (ER2007PosRbPmvk070101.getRefNumber(), ER2007PosRbPmvk070101.getName(), ER2007PosRbPmvk070101.getObjects()),
	R2008_RB070201 (ER2008PosRbPmvk070201.getRefNumber(), ER2008PosRbPmvk070201.getName(), ER2008PosRbPmvk070201.getObjects()),
	R2009_RB080000 (ER2009PosRbPmvk080000.getRefNumber(), ER2009PosRbPmvk080000.getName(), ER2009PosRbPmvk080000.getObjects()),
	R2010_RB090202 (ER2010PosRbPmvk090202.getRefNumber(), ER2010PosRbPmvk090202.getName(), ER2010PosRbPmvk090202.getObjects()),
	R2011_RB090203 (ER2011PosRbPmvk090203.getRefNumber(), ER2011PosRbPmvk090203.getName(), ER2011PosRbPmvk090203.getObjects()),
	R2012_RB090204 (ER2012PosRbPmvk090204.getRefNumber(), ER2012PosRbPmvk090204.getName(), ER2012PosRbPmvk090204.getObjects()),
	R2013_RB100100 (ER2013PosRbPmvk100100.getRefNumber(), ER2013PosRbPmvk100100.getName(), ER2013PosRbPmvk100100.getObjects()),
	R2014_RB100201 (ER2014PosRbPmvk100201.getRefNumber(), ER2014PosRbPmvk100201.getName(), ER2014PosRbPmvk100201.getObjects()),
	R2015_RB100301 (ER2015PosRbPmvk100301.getRefNumber(), ER2015PosRbPmvk100301.getName(), ER2015PosRbPmvk100301.getObjects()),
	R2016_RB100401 (ER2016PosRbPmvk100401.getRefNumber(), ER2016PosRbPmvk100401.getName(), ER2016PosRbPmvk100401.getObjects()),
	R2017_RB100501 (ER2017PosRbPmvk100501.getRefNumber(), ER2017PosRbPmvk100501.getName(), ER2017PosRbPmvk100501.getObjects()),
	R2018_RB110100 (ER2018PosRbPmvk110100.getRefNumber(), ER2018PosRbPmvk110100.getName(), ER2018PosRbPmvk110100.getObjects()),
//	R2019_RB900001 (ER2019PosRbPmvk900001.getRefNumber(), ER2019PosRbPmvk900001.getName(), ER2019PosRbPmvk900001.getObjects()),
//	R2020_RB900002 (ER2020PosRbPmvk900002.getRefNumber(), ER2020PosRbPmvk900002.getName(), ER2020PosRbPmvk900002.getObjects()),
	R2250_RE010401 (ER2250PosRePmvk010401.getRefNumber(), ER2250PosRePmvk010401.getName(), ER2250PosRePmvk010401.getObjects()),
	R2251_RE040101 (ER2251PosRePmvk040101.getRefNumber(), ER2251PosRePmvk040101.getName(), ER2251PosRePmvk040101.getObjects()),
	R2252_RE040201 (ER2252PosRePmvk040201.getRefNumber(), ER2252PosRePmvk040201.getName(), ER2252PosRePmvk040201.getObjects()),
	R2253_RE040301 (ER2253PosRePmvk040301.getRefNumber(), ER2253PosRePmvk040301.getName(), ER2253PosRePmvk040301.getObjects()),
	R2254_RE050101 (ER2254PosRePmvk050101.getRefNumber(), ER2254PosRePmvk050101.getName(), ER2254PosRePmvk050101.getObjects()),
	R2255_RE050201 (ER2255PosRePmvk050201.getRefNumber(), ER2255PosRePmvk050201.getName(), ER2255PosRePmvk050201.getObjects()),
	R2256_RE060100 (ER2256PosRePmvk060100.getRefNumber(), ER2256PosRePmvk060100.getName(), ER2256PosRePmvk060100.getObjects()),
	R2257_RE070101 (ER2257PosRePmvk070101.getRefNumber(), ER2257PosRePmvk070101.getName(), ER2257PosRePmvk070101.getObjects()),
	R2258_RE070201 (ER2258PosRePmvk070201.getRefNumber(), ER2258PosRePmvk070201.getName(), ER2258PosRePmvk070201.getObjects()),
	R2259_RE080000 (ER2259PosRePmvk080000.getRefNumber(), ER2259PosRePmvk080000.getName(), ER2259PosRePmvk080000.getObjects()),
	R2260_RE090202 (ER2260PosRePmvk090202.getRefNumber(), ER2260PosRePmvk090202.getName(), ER2260PosRePmvk090202.getObjects()),
	R2261_RE090203 (ER2261PosRePmvk090203.getRefNumber(), ER2261PosRePmvk090203.getName(), ER2261PosRePmvk090203.getObjects()),
	R2262_RE090204 (ER2262PosRePmvk090204.getRefNumber(), ER2262PosRePmvk090204.getName(), ER2262PosRePmvk090204.getObjects()),
	R2263_RE100100 (ER2263PosRePmvk100100.getRefNumber(), ER2263PosRePmvk100100.getName(), ER2263PosRePmvk100100.getObjects()),
	R2264_RE100201 (ER2264PosRePmvk100201.getRefNumber(), ER2264PosRePmvk100201.getName(), ER2264PosRePmvk100201.getObjects()),
	R2265_RE100301 (ER2265PosRePmvk100301.getRefNumber(), ER2265PosRePmvk100301.getName(), ER2265PosRePmvk100301.getObjects()),
	R2266_RE100401 (ER2266PosRePmvk100401.getRefNumber(), ER2266PosRePmvk100401.getName(), ER2266PosRePmvk100401.getObjects()),
	R2267_RE100501 (ER2267PosRePmvk100501.getRefNumber(), ER2267PosRePmvk100501.getName(), ER2267PosRePmvk100501.getObjects()),
	R2268_RE110100 (ER2268PosRePmvk110100.getRefNumber(), ER2268PosRePmvk110100.getName(), ER2268PosRePmvk110100.getObjects()),
//	R2269_RE900001 (ER2269PosRePmvk900001.getRefNumber(), ER2269PosRePmvk900001.getName(), ER2269PosRePmvk900001.getObjects()),
//	R2270_RE900002 (ER2270PosRePmvk900002.getRefNumber(), ER2270PosRePmvk900002.getName(), ER2270PosRePmvk900002.getObjects()),
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
