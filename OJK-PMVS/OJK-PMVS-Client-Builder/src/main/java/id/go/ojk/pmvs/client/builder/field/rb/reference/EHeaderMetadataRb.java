package id.go.ojk.pmvs.client.builder.field.rb.reference;

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
	R2000_RB010402(ER2000PosRbPmvs010402.getRefNumber(), ER2000PosRbPmvs010402.getName(), ER2000PosRbPmvs010402.getObjects()),
	R2001_RB040102(ER2001PosRbPmvs040102.getRefNumber(), ER2001PosRbPmvs040102.getName(), ER2001PosRbPmvs040102.getObjects()),
	R2002_RB040201(ER2002PosRbPmvs040201.getRefNumber(), ER2002PosRbPmvs040201.getName(), ER2002PosRbPmvs040201.getObjects()),
	R2003_RB040301(ER2003PosRbPmvs040301.getRefNumber(), ER2003PosRbPmvs040301.getName(), ER2003PosRbPmvs040301.getObjects()),
	R2004_RB050101(ER2004PosRbPmvs050101.getRefNumber(), ER2004PosRbPmvs050101.getName(), ER2004PosRbPmvs050101.getObjects()),
	R2005_RB050201(ER2005PosRbPmvs050201.getRefNumber(), ER2005PosRbPmvs050201.getName(), ER2005PosRbPmvs050201.getObjects()),
	R2006_RB060100(ER2006PosRbPmvs060100.getRefNumber(), ER2006PosRbPmvs060100.getName(), ER2006PosRbPmvs060100.getObjects()),
	R2007_RB070102(ER2007PosRbPmvs070102.getRefNumber(), ER2007PosRbPmvs070102.getName(), ER2007PosRbPmvs070102.getObjects()),
	R2008_RB070201(ER2008PosRbPmvs070201.getRefNumber(), ER2008PosRbPmvs070201.getName(), ER2008PosRbPmvs070201.getObjects()),
	R2009_RB080000(ER2009PosRbPmvs080000.getRefNumber(), ER2009PosRbPmvs080000.getName(), ER2009PosRbPmvs080000.getObjects()),
	R2010_RB090202(ER2010PosRbPmvs090202.getRefNumber(), ER2010PosRbPmvs090202.getName(), ER2010PosRbPmvs090202.getObjects()),
	R2011_RB090203(ER2011PosRbPmvs090203.getRefNumber(), ER2011PosRbPmvs090203.getName(), ER2011PosRbPmvs090203.getObjects()),
	R2012_RB090204(ER2012PosRbPmvs090204.getRefNumber(), ER2012PosRbPmvs090204.getName(), ER2012PosRbPmvs090204.getObjects()),
	R2013_RB100100(ER2013PosRbPmvs100100.getRefNumber(), ER2013PosRbPmvs100100.getName(), ER2013PosRbPmvs100100.getObjects()),
	R2014_RB100202(ER2014PosRbPmvs100202.getRefNumber(), ER2014PosRbPmvs100202.getName(), ER2014PosRbPmvs100202.getObjects()),
	R2015_RB100302(ER2015PosRbPmvs100302.getRefNumber(), ER2015PosRbPmvs100302.getName(), ER2015PosRbPmvs100302.getObjects()),
	R2016_RB100402(ER2016PosRbPmvs100402.getRefNumber(), ER2016PosRbPmvs100402.getName(), ER2016PosRbPmvs100402.getObjects()),
	R2017_RB100502(ER2017PosRbPmvs100502.getRefNumber(), ER2017PosRbPmvs100502.getName(), ER2017PosRbPmvs100502.getObjects()),
	R2018_RB110100(ER2018PosRbPmvs110100.getRefNumber(), ER2018PosRbPmvs110100.getName(), ER2018PosRbPmvs110100.getObjects()),
	R2250_RE010402(ER2250PosRePmvs010402.getRefNumber(), ER2250PosRePmvs010402.getName(), ER2250PosRePmvs010402.getObjects()),
	R2251_RE040102(ER2251PosRePmvs040102.getRefNumber(), ER2251PosRePmvs040102.getName(), ER2251PosRePmvs040102.getObjects()),
	R2252_RE040201(ER2252PosRePmvs040201.getRefNumber(), ER2252PosRePmvs040201.getName(), ER2252PosRePmvs040201.getObjects()),
	R2253_RE040301(ER2253PosRePmvs040301.getRefNumber(), ER2253PosRePmvs040301.getName(), ER2253PosRePmvs040301.getObjects()),
	R2254_RE050101(ER2254PosRePmvs050101.getRefNumber(), ER2254PosRePmvs050101.getName(), ER2254PosRePmvs050101.getObjects()),
	R2255_RE050201(ER2255PosRePmvs050201.getRefNumber(), ER2255PosRePmvs050201.getName(), ER2255PosRePmvs050201.getObjects()),
	R2256_RE060100(ER2256PosRePmvs060100.getRefNumber(), ER2256PosRePmvs060100.getName(), ER2256PosRePmvs060100.getObjects()),
	R2257_RE070102(ER2257PosRePmvs070102.getRefNumber(), ER2257PosRePmvs070102.getName(), ER2257PosRePmvs070102.getObjects()),
	R2258_RE070201(ER2258PosRePmvs070201.getRefNumber(), ER2258PosRePmvs070201.getName(), ER2258PosRePmvs070201.getObjects()),
	R2259_RE080000(ER2259PosRePmvs080000.getRefNumber(), ER2259PosRePmvs080000.getName(), ER2259PosRePmvs080000.getObjects()),
	R2260_RE090202(ER2260PosRePmvs090202.getRefNumber(), ER2260PosRePmvs090202.getName(), ER2260PosRePmvs090202.getObjects()),
	R2261_RE090203(ER2261PosRePmvs090203.getRefNumber(), ER2261PosRePmvs090203.getName(), ER2261PosRePmvs090203.getObjects()),
	R2262_RE090204(ER2262PosRePmvs090204.getRefNumber(), ER2262PosRePmvs090204.getName(), ER2262PosRePmvs090204.getObjects()),
	R2263_RE100100(ER2263PosRePmvs100100.getRefNumber(), ER2263PosRePmvs100100.getName(), ER2263PosRePmvs100100.getObjects()),
	R2264_RE100202(ER2264PosRePmvs100202.getRefNumber(), ER2264PosRePmvs100202.getName(), ER2264PosRePmvs100202.getObjects()),
	R2265_RE100302(ER2265PosRePmvs100302.getRefNumber(), ER2265PosRePmvs100302.getName(), ER2265PosRePmvs100302.getObjects()),
	R2266_RE100402(ER2266PosRePmvs100402.getRefNumber(), ER2266PosRePmvs100402.getName(), ER2266PosRePmvs100402.getObjects()),
	R2267_RE100502(ER2267PosRePmvs100502.getRefNumber(), ER2267PosRePmvs100502.getName(), ER2267PosRePmvs100502.getObjects()),
	R2268_RE110100(ER2268PosRePmvs110100.getRefNumber(), ER2268PosRePmvs110100.getName(), ER2268PosRePmvs110100.getObjects()),
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
