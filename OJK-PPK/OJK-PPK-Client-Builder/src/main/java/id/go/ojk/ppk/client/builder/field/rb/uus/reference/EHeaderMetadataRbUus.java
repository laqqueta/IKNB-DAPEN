package id.go.ojk.ppk.client.builder.field.rb.uus.reference;

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
	R2500_RB010402(ER2500PosRbPpu010402.getRefNumber(), ER2500PosRbPpu010402.getName(), ER2500PosRbPpu010402.getObjects()),
	R2501_RB040102(ER2501PosRbPpu040102.getRefNumber(), ER2501PosRbPpu040102.getName(), ER2501PosRbPpu040102.getObjects()),
	R2502_RB040201(ER2502PosRbPpu040201.getRefNumber(), ER2502PosRbPpu040201.getName(), ER2502PosRbPpu040201.getObjects()),
	R2503_RB040301(ER2503PosRbPpu040301.getRefNumber(), ER2503PosRbPpu040301.getName(), ER2503PosRbPpu040301.getObjects()),
	R2504_RB040401(ER2504PosRbPpu040401.getRefNumber(), ER2504PosRbPpu040401.getName(), ER2504PosRbPpu040401.getObjects()),
	R2505_RB040501(ER2505PosRbPpu040501.getRefNumber(), ER2505PosRbPpu040501.getName(), ER2505PosRbPpu040501.getObjects()),
	R2506_RB050101(ER2506PosRbPpu050101.getRefNumber(), ER2506PosRbPpu050101.getName(), ER2506PosRbPpu050101.getObjects()),
	R2507_RB050201(ER2507PosRbPpu050201.getRefNumber(), ER2507PosRbPpu050201.getName(), ER2507PosRbPpu050201.getObjects()),
	R2508_RB060101(ER2508PosRbPpu060101.getRefNumber(), ER2508PosRbPpu060101.getName(), ER2508PosRbPpu060101.getObjects()),
	R2509_RB060200(ER2509PosRbPpu060200.getRefNumber(), ER2509PosRbPpu060200.getName(), ER2509PosRbPpu060200.getObjects()),
	R2510_RB070102(ER2510PosRbPpu070102.getRefNumber(), ER2510PosRbPpu070102.getName(), ER2510PosRbPpu070102.getObjects()),
	R2511_RB070201(ER2511PosRbPpu070201.getRefNumber(), ER2511PosRbPpu070201.getName(), ER2511PosRbPpu070201.getObjects()),
	R2512_RB070301(ER2512PosRbPpu070301.getRefNumber(), ER2512PosRbPpu070301.getName(), ER2512PosRbPpu070301.getObjects()),
	R2513_RB080000(ER2513PosRbPpu080000.getRefNumber(), ER2513PosRbPpu080000.getName(), ER2513PosRbPpu080000.getObjects()),
	R2514_RB090202(ER2514PosRbPpu090202.getRefNumber(), ER2514PosRbPpu090202.getName(), ER2514PosRbPpu090202.getObjects()),
	R2515_RB090203(ER2515PosRbPpu090203.getRefNumber(), ER2515PosRbPpu090203.getName(), ER2515PosRbPpu090203.getObjects()),
	R2516_RB090204(ER2516PosRbPpu090204.getRefNumber(), ER2516PosRbPpu090204.getName(), ER2516PosRbPpu090204.getObjects()),
	R2517_RB100100(ER2517PosRbPpu100100.getRefNumber(), ER2517PosRbPpu100100.getName(), ER2517PosRbPpu100100.getObjects()),
	R2518_RB100202(ER2518PosRbPpu100202.getRefNumber(), ER2518PosRbPpu100202.getName(), ER2518PosRbPpu100202.getObjects()),
	R2519_RB100302(ER2519PosRbPpu100302.getRefNumber(), ER2519PosRbPpu100302.getName(), ER2519PosRbPpu100302.getObjects()),
	R2520_RB100402(ER2520PosRbPpu100402.getRefNumber(), ER2520PosRbPpu100402.getName(), ER2520PosRbPpu100402.getObjects()),
	R2521_RB100502(ER2521PosRbPpu100502.getRefNumber(), ER2521PosRbPpu100502.getName(), ER2521PosRbPpu100502.getObjects()),
	R2522_RB110200(ER2522PosRbPpu110200.getRefNumber(), ER2522PosRbPpu110200.getName(), ER2522PosRbPpu110200.getObjects()),
	R2523_RB120100(ER2523PosRbPpu120100.getRefNumber(), ER2523PosRbPpu120100.getName(), ER2523PosRbPpu120100.getObjects()),
	R2750_RE010402(ER2750PosRePpu010402.getRefNumber(), ER2750PosRePpu010402.getName(), ER2750PosRePpu010402.getObjects()),
	R2751_RE040101(ER2751PosRePpu040102.getRefNumber(), ER2751PosRePpu040102.getName(), ER2751PosRePpu040102.getObjects()),
	R2752_RE040201(ER2752PosRePpu040201.getRefNumber(), ER2752PosRePpu040201.getName(), ER2752PosRePpu040201.getObjects()),
	R2753_RE040301(ER2753PosRePpu040301.getRefNumber(), ER2753PosRePpu040301.getName(), ER2753PosRePpu040301.getObjects()),
	R2754_RE040401(ER2754PosRePpu040401.getRefNumber(), ER2754PosRePpu040401.getName(), ER2754PosRePpu040401.getObjects()),
	R2755_RE040501(ER2755PosRePpu040501.getRefNumber(), ER2755PosRePpu040501.getName(), ER2755PosRePpu040501.getObjects()),
	R2756_RE050101(ER2756PosRePpu050101.getRefNumber(), ER2756PosRePpu050101.getName(), ER2756PosRePpu050101.getObjects()),
	R2757_RE050201(ER2757PosRePpu050201.getRefNumber(), ER2757PosRePpu050201.getName(), ER2757PosRePpu050201.getObjects()),
	R2758_RE060101(ER2758PosRePpu060101.getRefNumber(), ER2758PosRePpu060101.getName(), ER2758PosRePpu060101.getObjects()),
	R2759_RE060200(ER2759PosRePpu060200.getRefNumber(), ER2759PosRePpu060200.getName(), ER2759PosRePpu060200.getObjects()),
	R2760_RE070101(ER2760PosRePpu070102.getRefNumber(), ER2760PosRePpu070102.getName(), ER2760PosRePpu070102.getObjects()),
	R2761_RE070201(ER2761PosRePpu070201.getRefNumber(), ER2761PosRePpu070201.getName(), ER2761PosRePpu070201.getObjects()),
	R2762_RE070301(ER2062PosRePpu070301.getRefNumber(), ER2062PosRePpu070301.getName(), ER2062PosRePpu070301.getObjects()),
	R2763_RE080000(ER2763PosRePpu080000.getRefNumber(), ER2763PosRePpu080000.getName(), ER2763PosRePpu080000.getObjects()),
	R2764_RE090202(ER2764PosRePpu090202.getRefNumber(), ER2764PosRePpu090202.getName(), ER2764PosRePpu090202.getObjects()),
	R2765_RE090203(ER2765PosRePpu090203.getRefNumber(), ER2765PosRePpu090203.getName(), ER2765PosRePpu090203.getObjects()),
	R2766_RE090204(ER2766PosRePpu090204.getRefNumber(), ER2766PosRePpu090204.getName(), ER2766PosRePpu090204.getObjects()),
	R2767_RE100100(ER2767PosRePpu100100.getRefNumber(), ER2767PosRePpu100100.getName(), ER2767PosRePpu100100.getObjects()),
	R2768_RE100202(ER2768PosRePpu100202.getRefNumber(), ER2768PosRePpu100202.getName(), ER2768PosRePpu100202.getObjects()),
	R2769_RE100302(ER2769PosRePpu100302.getRefNumber(), ER2769PosRePpu100302.getName(), ER2769PosRePpu100302.getObjects()),
	R2770_RE100402(ER2770PosRePpu100402.getRefNumber(), ER2770PosRePpu100402.getName(), ER2770PosRePpu100402.getObjects()),
	R2771_RE100502(ER2771PosRePpu100502.getRefNumber(), ER2771PosRePpu100502.getName(), ER2771PosRePpu100502.getObjects()),
	R2772_RE110200(ER2772PosRePpu110200.getRefNumber(), ER2772PosRePpu110200.getName(), ER2772PosRePpu110200.getObjects()),
	R2773_RE120100(ER2773PosRePpu120100.getRefNumber(), ER2773PosRePpu120100.getName(), ER2773PosRePpu120100.getObjects()),
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
