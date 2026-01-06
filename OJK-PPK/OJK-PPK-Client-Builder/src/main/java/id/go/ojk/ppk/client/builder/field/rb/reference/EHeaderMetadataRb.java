package id.go.ojk.ppk.client.builder.field.rb.reference;

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
	R2000_RB010401(ER2000PosRbPpk010401.getRefNumber(), ER2000PosRbPpk010401.getName(), ER2000PosRbPpk010401.getObjects()),
	R2001_RB040101(ER2001PosRbPpk040101.getRefNumber(), ER2001PosRbPpk040101.getName(), ER2001PosRbPpk040101.getObjects()),
	R2002_RB040201(ER2002PosRbPpk040201.getRefNumber(), ER2002PosRbPpk040201.getName(), ER2002PosRbPpk040201.getObjects()),
	R2003_RB040301(ER2003PosRbPpk040301.getRefNumber(), ER2003PosRbPpk040301.getName(), ER2003PosRbPpk040301.getObjects()),
	R2004_RB040401(ER2004PosRbPpk040401.getRefNumber(), ER2004PosRbPpk040401.getName(), ER2004PosRbPpk040401.getObjects()),
	R2005_RB040501(ER2005PosRbPpk040501.getRefNumber(), ER2005PosRbPpk040501.getName(), ER2005PosRbPpk040501.getObjects()),
	R2006_RB050101(ER2006PosRbPpk050101.getRefNumber(), ER2006PosRbPpk050101.getName(), ER2006PosRbPpk050101.getObjects()),
	R2007_RB050201(ER2007PosRbPpk050201.getRefNumber(), ER2007PosRbPpk050201.getName(), ER2007PosRbPpk050201.getObjects()),
	R2008_RB060101(ER2008PosRbPpk060101.getRefNumber(), ER2008PosRbPpk060101.getName(), ER2008PosRbPpk060101.getObjects()),
	R2009_RB060200(ER2009PosRbPpk060200.getRefNumber(), ER2009PosRbPpk060200.getName(), ER2009PosRbPpk060200.getObjects()),
	R2010_RB070101(ER2010PosRbPpk070101.getRefNumber(), ER2010PosRbPpk070101.getName(), ER2010PosRbPpk070101.getObjects()),
	R2011_RB070201(ER2011PosRbPpk070201.getRefNumber(), ER2011PosRbPpk070201.getName(), ER2011PosRbPpk070201.getObjects()),
	R2012_RB080000(ER2012PosRbPpk080000.getRefNumber(), ER2012PosRbPpk080000.getName(), ER2012PosRbPpk080000.getObjects()),
	R2013_RB090202(ER2013PosRbPpk090202.getRefNumber(), ER2013PosRbPpk090202.getName(), ER2013PosRbPpk090202.getObjects()),
	R2014_RB090203(ER2014PosRbPpk090203.getRefNumber(), ER2014PosRbPpk090203.getName(), ER2014PosRbPpk090203.getObjects()),
	R2015_RB090204(ER2015PosRbPpk090204.getRefNumber(), ER2015PosRbPpk090204.getName(), ER2015PosRbPpk090204.getObjects()),
	R2016_RB100100(ER2016PosRbPpk100100.getRefNumber(), ER2016PosRbPpk100100.getName(), ER2016PosRbPpk100100.getObjects()),
	R2017_RB100201(ER2017PosRbPpk100201.getRefNumber(), ER2017PosRbPpk100201.getName(), ER2017PosRbPpk100201.getObjects()),
	R2018_RB100301(ER2018PosRbPpk100301.getRefNumber(), ER2018PosRbPpk100301.getName(), ER2018PosRbPpk100301.getObjects()),
	R2019_RB100401(ER2019PosRbPpk100401.getRefNumber(), ER2019PosRbPpk100401.getName(), ER2019PosRbPpk100401.getObjects()),
	R2020_RB100501(ER2020PosRbPpk100501.getRefNumber(), ER2020PosRbPpk100501.getName(), ER2020PosRbPpk100501.getObjects()),
	R2021_RB110100(ER2021PosRbPpk110100.getRefNumber(), ER2021PosRbPpk110100.getName(), ER2021PosRbPpk110100.getObjects()),
	R2022_RB120100(ER2022PosRbPpk120100.getRefNumber(), ER2022PosRbPpk120100.getName(), ER2022PosRbPpk120100.getObjects()),
	R2250_RE010401(ER2250PosRePpk010401.getRefNumber(), ER2250PosRePpk010401.getName(), ER2250PosRePpk010401.getObjects()),
	R2251_RE040101(ER2251PosRePpk040101.getRefNumber(), ER2251PosRePpk040101.getName(), ER2251PosRePpk040101.getObjects()),
	R2252_RE040201(ER2252PosRePpk040201.getRefNumber(), ER2252PosRePpk040201.getName(), ER2252PosRePpk040201.getObjects()),
	R2253_RE040301(ER2253PosRePpk040301.getRefNumber(), ER2253PosRePpk040301.getName(), ER2253PosRePpk040301.getObjects()),
	R2254_RE040401(ER2254PosRePpk040401.getRefNumber(), ER2254PosRePpk040401.getName(), ER2254PosRePpk040401.getObjects()),
	R2255_RE040501(ER2255PosRePpk040501.getRefNumber(), ER2255PosRePpk040501.getName(), ER2255PosRePpk040501.getObjects()),
	R2256_RE050101(ER2256PosRePpk050101.getRefNumber(), ER2256PosRePpk050101.getName(), ER2256PosRePpk050101.getObjects()),
	R2257_RE050201(ER2257PosRePpk050201.getRefNumber(), ER2257PosRePpk050201.getName(), ER2257PosRePpk050201.getObjects()),
	R2258_RE060101(ER2258PosRePpk060101.getRefNumber(), ER2258PosRePpk060101.getName(), ER2258PosRePpk060101.getObjects()),
	R2259_RE060200(ER2259PosRePpk060200.getRefNumber(), ER2259PosRePpk060200.getName(), ER2259PosRePpk060200.getObjects()),
	R2260_RE070101(ER2260PosRePpk070101.getRefNumber(), ER2260PosRePpk070101.getName(), ER2260PosRePpk070101.getObjects()),
	R2261_RE070201(ER2261PosRePpk070201.getRefNumber(), ER2261PosRePpk070201.getName(), ER2261PosRePpk070201.getObjects()),
	R2262_RE080000(ER2262PosRePpk080000.getRefNumber(), ER2262PosRePpk080000.getName(), ER2262PosRePpk080000.getObjects()),
	R2263_RE090202(ER2263PosRePpk090202.getRefNumber(), ER2263PosRePpk090202.getName(), ER2263PosRePpk090202.getObjects()),
	R2264_RE090203(ER2264PosRePpk090203.getRefNumber(), ER2264PosRePpk090203.getName(), ER2264PosRePpk090203.getObjects()),
	R2265_RE090204(ER2265PosRePpk090204.getRefNumber(), ER2265PosRePpk090204.getName(), ER2265PosRePpk090204.getObjects()),
	R2266_RE100100(ER2266PosRePpk100100.getRefNumber(), ER2266PosRePpk100100.getName(), ER2266PosRePpk100100.getObjects()),
	R2267_RE100201(ER2267PosRePpk100201.getRefNumber(), ER2267PosRePpk100201.getName(), ER2267PosRePpk100201.getObjects()),
	R2268_RE100301(ER2268PosRePpk100301.getRefNumber(), ER2268PosRePpk100301.getName(), ER2268PosRePpk100301.getObjects()),
	R2269_RE100401(ER2269PosRePpk100401.getRefNumber(), ER2269PosRePpk100401.getName(), ER2269PosRePpk100401.getObjects()),
	R2270_RE100501(ER2270PosRePpk100501.getRefNumber(), ER2270PosRePpk100501.getName(), ER2270PosRePpk100501.getObjects()),
	R2271_RE110100(ER2271PosRePpk110100.getRefNumber(), ER2271PosRePpk110100.getName(), ER2271PosRePpk110100.getObjects()),
	R2272_RE120100(ER2272PosRePpk120100.getRefNumber(), ER2272PosRePpk120100.getName(), ER2272PosRePpk120100.getObjects()),
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
