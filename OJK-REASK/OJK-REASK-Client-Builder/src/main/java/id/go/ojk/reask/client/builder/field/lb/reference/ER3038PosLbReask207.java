package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3038PosLbReask207 implements IObject<KeyValueString> {
	R_5802000001 ("5802000001", "Rincian baris"),
	R_5802000002 ("5802000002", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3038PosLbReask207 eEnum : ER3038PosLbReask207.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_5802000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6|7|8|9", getObjects());
	}
	
	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_5802000002.key);
	}
	
	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_5802000002.key, "2");
	}

	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("3+4+5+6", R_5802000001.key);
	}

	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsPosFormula("7-8", R_5802000001.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6|7|8|9", R_5802000002.key, R_5802000001.key, "Total|Penjumlahan detail");
	}
}
