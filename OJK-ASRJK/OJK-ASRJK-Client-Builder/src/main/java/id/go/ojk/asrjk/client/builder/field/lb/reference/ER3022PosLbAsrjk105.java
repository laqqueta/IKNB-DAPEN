package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3022PosLbAsrjk105 implements IObject<KeyValueString> {
	R_1400050100 ("1400050100", "Baris rincian"),
	R_1400050200 ("1400050200", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3022PosLbAsrjk105 eEnum : ER3022PosLbAsrjk105.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3022PosLbAsrjk105.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3022PosLbAsrjk105.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_1400050200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("5|6|7|8", getObjects());
	}
	
	public static ConditionalRequired genConditionalMustEmpty2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400050200.key);
	}
	
	public static ConditionalRequired genConditionalField34() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400050200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400050200.key, "2");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("5|6|7|8", R_1400050200.key, R_1400050100.key, "Total|Penjumlahan detail");
	}
}
