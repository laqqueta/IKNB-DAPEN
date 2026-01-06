package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

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
public enum EHeaderMetadataRbUus implements IObject<ReferenceMetadata> {
	R2500_RB010402 (ER2500PosRbPmvu010402.getRefNumber(), ER2500PosRbPmvu010402.getName(), ER2500PosRbPmvu010402.getObjects()),
	R2501_RB040102 (ER2501PosRbPmvu040102.getRefNumber(), ER2501PosRbPmvu040102.getName(), ER2501PosRbPmvu040102.getObjects()),
	R2502_RB040201 (ER2502PosRbPmvu040201.getRefNumber(), ER2502PosRbPmvu040201.getName(), ER2502PosRbPmvu040201.getObjects()),
	R2503_RB040301 (ER2503PosRbPmvu040301.getRefNumber(), ER2503PosRbPmvu040301.getName(), ER2503PosRbPmvu040301.getObjects()),
	R2504_RB050101 (ER2504PosRbPmvu050101.getRefNumber(), ER2504PosRbPmvu050101.getName(), ER2504PosRbPmvu050101.getObjects()),
	R2505_RB050201 (ER2505PosRbPmvu050201.getRefNumber(), ER2505PosRbPmvu050201.getName(), ER2505PosRbPmvu050201.getObjects()),
	R2506_RB060100 (ER2506PosRbPmvu060100.getRefNumber(), ER2506PosRbPmvu060100.getName(), ER2506PosRbPmvu060100.getObjects()),
	R2507_RB070102 (ER2507PosRbPmvu070102.getRefNumber(), ER2507PosRbPmvu070102.getName(), ER2507PosRbPmvu070102.getObjects()),
	R2508_RB070201 (ER2508PosRbPmvu070201.getRefNumber(), ER2508PosRbPmvu070201.getName(), ER2508PosRbPmvu070201.getObjects()),
	R2509_RB080000 (ER2509PosRbPmvu080000.getRefNumber(), ER2509PosRbPmvu080000.getName(), ER2509PosRbPmvu080000.getObjects()),
	R2510_RB090202 (ER2510PosRbPmvu090202.getRefNumber(), ER2510PosRbPmvu090202.getName(), ER2510PosRbPmvu090202.getObjects()),
	R2511_RB090203 (ER2511PosRbPmvu090203.getRefNumber(), ER2511PosRbPmvu090203.getName(), ER2511PosRbPmvu090203.getObjects()),
	R2512_RB090204 (ER2512PosRbPmvu090204.getRefNumber(), ER2512PosRbPmvu090204.getName(), ER2512PosRbPmvu090204.getObjects()),
	R2513_RB100100 (ER2513PosRbPmvu100100.getRefNumber(), ER2513PosRbPmvu100100.getName(), ER2513PosRbPmvu100100.getObjects()),
	R2514_RB100202 (ER2514PosRbPmvu100202.getRefNumber(), ER2514PosRbPmvu100202.getName(), ER2514PosRbPmvu100202.getObjects()),
	R2515_RB100302 (ER2515PosRbPmvu100302.getRefNumber(), ER2515PosRbPmvu100302.getName(), ER2515PosRbPmvu100302.getObjects()),
	R2516_RB100402 (ER2516PosRbPmvu100402.getRefNumber(), ER2516PosRbPmvu100402.getName(), ER2516PosRbPmvu100402.getObjects()),
	R2517_RB100502 (ER2517PosRbPmvu100502.getRefNumber(), ER2517PosRbPmvu100502.getName(), ER2517PosRbPmvu100502.getObjects()),
	R2518_RB110100 (ER2518PosRbPmvu110100.getRefNumber(), ER2518PosRbPmvu110100.getName(), ER2518PosRbPmvu110100.getObjects()),
//	R2519_RB900001 (ER2519PosRbPmvu900001.getRefNumber(), ER2519PosRbPmvu900001.getName(), ER2519PosRbPmvu900001.getObjects()),
//	R2520_RB900002 (ER2520PosRbPmvu900002.getRefNumber(), ER2520PosRbPmvu900002.getName(), ER2520PosRbPmvu900002.getObjects()),
	R2750_RE010402 (ER2750PosRePmvu010402.getRefNumber(), ER2750PosRePmvu010402.getName(), ER2750PosRePmvu010402.getObjects()),
	R2751_RE040102 (ER2751PosRePmvu040102.getRefNumber(), ER2751PosRePmvu040102.getName(), ER2751PosRePmvu040102.getObjects()),
	R2752_RE040201 (ER2752PosRePmvu040201.getRefNumber(), ER2752PosRePmvu040201.getName(), ER2752PosRePmvu040201.getObjects()),
	R2753_RE040301 (ER2753PosRePmvu040301.getRefNumber(), ER2753PosRePmvu040301.getName(), ER2753PosRePmvu040301.getObjects()),
	R2754_RE050101 (ER2754PosRePmvu050101.getRefNumber(), ER2754PosRePmvu050101.getName(), ER2754PosRePmvu050101.getObjects()),
	R2755_RE050201 (ER2755PosRePmvu050201.getRefNumber(), ER2755PosRePmvu050201.getName(), ER2755PosRePmvu050201.getObjects()),
	R2756_RE060100 (ER2756PosRePmvu060100.getRefNumber(), ER2756PosRePmvu060100.getName(), ER2756PosRePmvu060100.getObjects()),
	R2757_RE070102 (ER2757PosRePmvu070102.getRefNumber(), ER2757PosRePmvu070102.getName(), ER2757PosRePmvu070102.getObjects()),
	R2758_RE070201 (ER2758PosRePmvu070201.getRefNumber(), ER2758PosRePmvu070201.getName(), ER2758PosRePmvu070201.getObjects()),
	R2759_RE080000 (ER2759PosRePmvu080000.getRefNumber(), ER2759PosRePmvu080000.getName(), ER2759PosRePmvu080000.getObjects()),
	R2760_RE090202 (ER2760PosRePmvu090202.getRefNumber(), ER2760PosRePmvu090202.getName(), ER2760PosRePmvu090202.getObjects()),
	R2761_RE090203 (ER2761PosRePmvu090203.getRefNumber(), ER2761PosRePmvu090203.getName(), ER2761PosRePmvu090203.getObjects()),
	R2762_RE090204 (ER2762PosRePmvu090204.getRefNumber(), ER2762PosRePmvu090204.getName(), ER2762PosRePmvu090204.getObjects()),
	R2763_RE100100 (ER2763PosRePmvu100100.getRefNumber(), ER2763PosRePmvu100100.getName(), ER2763PosRePmvu100100.getObjects()),
	R2764_RE100202 (ER2764PosRePmvu100202.getRefNumber(), ER2764PosRePmvu100202.getName(), ER2764PosRePmvu100202.getObjects()),
	R2765_RE100302 (ER2765PosRePmvu100302.getRefNumber(), ER2765PosRePmvu100302.getName(), ER2765PosRePmvu100302.getObjects()),
	R2766_RE100402 (ER2766PosRePmvu100402.getRefNumber(), ER2766PosRePmvu100402.getName(), ER2766PosRePmvu100402.getObjects()),
	R2767_RE100502 (ER2767PosRePmvu100502.getRefNumber(), ER2767PosRePmvu100502.getName(), ER2767PosRePmvu100502.getObjects()),
	R2768_RE110100 (ER2768PosRePmvu110100.getRefNumber(), ER2768PosRePmvu110100.getName(), ER2768PosRePmvu110100.getObjects()),
//	R2769_RE900001 (ER2769PosRePmvu900001.getRefNumber(), ER2769PosRePmvu900001.getName(), ER2769PosRePmvu900001.getObjects()),
//	R2770_RE900002 (ER2770PosRePmvu900002.getRefNumber(), ER2770PosRePmvu900002.getName(), ER2770PosRePmvu900002.getObjects()),
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
		for (EHeaderMetadataRbUus eEnum : EHeaderMetadataRbUus.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataRbUus eEnum : EHeaderMetadataRbUus.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
