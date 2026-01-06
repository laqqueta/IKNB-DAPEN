package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3023PosLbReask106 implements IObject<KeyValueString> {
	R_1400060100 ("1400060100", "Baris rincian"),
	R_1400060200 ("1400060200", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3023PosLbReask106 eEnum : ER3023PosLbReask106.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1400060200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("6", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400060200.key);
	}
	
	public static ConditionalRequired genConditionalField345() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400060200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField6() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400060200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField789() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400060200.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("6", R_1400060200.key, R_1400060100.key, "Total|Penjumlahan detail");
	}
}
