package id.go.ojk.pps.client.builder.field.rb.reference;

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
	R2000_RB010402(ER2000PosRbPps010402.getRefNumber(), ER2000PosRbPps010402.getName(), ER2000PosRbPps010402.getObjects()),
	R2001_RB040102(ER2001PosRbPps040102.getRefNumber(), ER2001PosRbPps040102.getName(), ER2001PosRbPps040102.getObjects()),
	R2002_RB040201(ER2002PosRbPps040201.getRefNumber(), ER2002PosRbPps040201.getName(), ER2002PosRbPps040201.getObjects()),
	R2003_RB040301(ER2003PosRbPps040301.getRefNumber(), ER2003PosRbPps040301.getName(), ER2003PosRbPps040301.getObjects()),
	R2004_RB040401(ER2004PosRbPps040401.getRefNumber(), ER2004PosRbPps040401.getName(), ER2004PosRbPps040401.getObjects()),
	R2005_RB040501(ER2005PosRbPps040501.getRefNumber(), ER2005PosRbPps040501.getName(), ER2005PosRbPps040501.getObjects()),
	R2006_RB050101(ER2006PosRbPps050101.getRefNumber(), ER2006PosRbPps050101.getName(), ER2006PosRbPps050101.getObjects()),
	R2007_RB050201(ER2007PosRbPps050201.getRefNumber(), ER2007PosRbPps050201.getName(), ER2007PosRbPps050201.getObjects()),
	R2008_RB060101(ER2008PosRbPps060101.getRefNumber(), ER2008PosRbPps060101.getName(), ER2008PosRbPps060101.getObjects()),
	R2009_RB060200(ER2009PosRbPps060200.getRefNumber(), ER2009PosRbPps060200.getName(), ER2009PosRbPps060200.getObjects()),
	R2010_RB070102(ER2010PosRbPps070102.getRefNumber(), ER2010PosRbPps070102.getName(), ER2010PosRbPps070102.getObjects()),
	R2011_RB070201(ER2011PosRbPps070201.getRefNumber(), ER2011PosRbPps070201.getName(), ER2011PosRbPps070201.getObjects()),
	R2012_RB070301(ER2012PosRbPps070301.getRefNumber(), ER2012PosRbPps070301.getName(), ER2012PosRbPps070301.getObjects()),
	R2013_RB080000(ER2013PosRbPps080000.getRefNumber(), ER2013PosRbPps080000.getName(), ER2013PosRbPps080000.getObjects()),
	R2014_RB090202(ER2014PosRbPps090202.getRefNumber(), ER2014PosRbPps090202.getName(), ER2014PosRbPps090202.getObjects()),
	R2015_RB090203(ER2015PosRbPps090203.getRefNumber(), ER2015PosRbPps090203.getName(), ER2015PosRbPps090203.getObjects()),
	R2016_RB090204(ER2016PosRbPps090204.getRefNumber(), ER2016PosRbPps090204.getName(), ER2016PosRbPps090204.getObjects()),
	R2017_RB100100(ER2017PosRbPps100100.getRefNumber(), ER2017PosRbPps100100.getName(), ER2017PosRbPps100100.getObjects()),
	R2018_RB100202(ER2018PosRbPps100202.getRefNumber(), ER2018PosRbPps100202.getName(), ER2018PosRbPps100202.getObjects()),
	R2019_RB100302(ER2019PosRbPps100302.getRefNumber(), ER2019PosRbPps100302.getName(), ER2019PosRbPps100302.getObjects()),
	R2020_RB100402(ER2020PosRbPps100402.getRefNumber(), ER2020PosRbPps100402.getName(), ER2020PosRbPps100402.getObjects()),
	R2021_RB100502(ER2021PosRbPps100502.getRefNumber(), ER2021PosRbPps100502.getName(), ER2021PosRbPps100502.getObjects()),
	R2022_RB110200(ER2022PosRbPps110200.getRefNumber(), ER2022PosRbPps110200.getName(), ER2022PosRbPps110200.getObjects()),
	R2023_RB120100(ER2023PosRbPps120100.getRefNumber(), ER2023PosRbPps120100.getName(), ER2023PosRbPps120100.getObjects()),
	R2250_RE010402(ER2250PosRePps010402.getRefNumber(), ER2250PosRePps010402.getName(), ER2250PosRePps010402.getObjects()),
	R2251_RE040101(ER2251PosRePps040102.getRefNumber(), ER2251PosRePps040102.getName(), ER2251PosRePps040102.getObjects()),
	R2252_RE040201(ER2252PosRePps040201.getRefNumber(), ER2252PosRePps040201.getName(), ER2252PosRePps040201.getObjects()),
	R2253_RE040301(ER2253PosRePps040301.getRefNumber(), ER2253PosRePps040301.getName(), ER2253PosRePps040301.getObjects()),
	R2254_RE040401(ER2254PosRePps040401.getRefNumber(), ER2254PosRePps040401.getName(), ER2254PosRePps040401.getObjects()),
	R2255_RE040501(ER2255PosRePps040501.getRefNumber(), ER2255PosRePps040501.getName(), ER2255PosRePps040501.getObjects()),
	R2256_RE050101(ER2256PosRePps050101.getRefNumber(), ER2256PosRePps050101.getName(), ER2256PosRePps050101.getObjects()),
	R2257_RE050201(ER2257PosRePps050201.getRefNumber(), ER2257PosRePps050201.getName(), ER2257PosRePps050201.getObjects()),
	R2258_RE060101(ER2258PosRePps060101.getRefNumber(), ER2258PosRePps060101.getName(), ER2258PosRePps060101.getObjects()),
	R2259_RE060200(ER2259PosRePps060200.getRefNumber(), ER2259PosRePps060200.getName(), ER2259PosRePps060200.getObjects()),
	R2260_RE070101(ER2260PosRePps070102.getRefNumber(), ER2260PosRePps070102.getName(), ER2260PosRePps070102.getObjects()),
	R2261_RE070201(ER2261PosRePps070201.getRefNumber(), ER2261PosRePps070201.getName(), ER2261PosRePps070201.getObjects()),
	R2262_RE070301(ER2262PosRePps070301.getRefNumber(), ER2262PosRePps070301.getName(), ER2262PosRePps070301.getObjects()),
	R2263_RE080000(ER2263PosRePps080000.getRefNumber(), ER2263PosRePps080000.getName(), ER2263PosRePps080000.getObjects()),
	R2264_RE090202(ER2264PosRePps090202.getRefNumber(), ER2264PosRePps090202.getName(), ER2264PosRePps090202.getObjects()),
	R2265_RE090203(ER2265PosRePps090203.getRefNumber(), ER2265PosRePps090203.getName(), ER2265PosRePps090203.getObjects()),
	R2266_RE090204(ER2266PosRePps090204.getRefNumber(), ER2266PosRePps090204.getName(), ER2266PosRePps090204.getObjects()),
	R2267_RE100100(ER2267PosRePps100100.getRefNumber(), ER2267PosRePps100100.getName(), ER2267PosRePps100100.getObjects()),
	R2268_RE100202(ER2268PosRePps100202.getRefNumber(), ER2268PosRePps100202.getName(), ER2268PosRePps100202.getObjects()),
	R2269_RE100302(ER2269PosRePps100302.getRefNumber(), ER2269PosRePps100302.getName(), ER2269PosRePps100302.getObjects()),
	R2270_RE100402(ER2270PosRePps100402.getRefNumber(), ER2270PosRePps100402.getName(), ER2270PosRePps100402.getObjects()),
	R2271_RE100502(ER2271PosRePps100502.getRefNumber(), ER2271PosRePps100502.getName(), ER2271PosRePps100502.getObjects()),
	R2272_RE110200(ER2272PosRePps110200.getRefNumber(), ER2272PosRePps110200.getName(), ER2272PosRePps110200.getObjects()),
	R2273_RE120100(ER2273PosRePps120100.getRefNumber(), ER2273PosRePps120100.getName(), ER2273PosRePps120100.getObjects()),
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
