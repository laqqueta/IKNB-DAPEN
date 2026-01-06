package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3037PosLbAsruk206 implements IObject<KeyValueString> {
	R_5700000001 ("5700000001", "Rincian baris"),
	R_5700000002 ("5700000002", "Total"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3037PosLbAsruk206 eEnum : ER3037PosLbAsruk206.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_5700000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("4", getObjects());
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_5700000002.key, "2");
	}
	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_5700000002.key, "2");
	}

	public static ConditionalRequired genConditionalField4() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_5700000002.key, "2");
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("4", R_5700000002.key, R_5700000001.key, "Total|Penjumlahan detail");
	}
}
