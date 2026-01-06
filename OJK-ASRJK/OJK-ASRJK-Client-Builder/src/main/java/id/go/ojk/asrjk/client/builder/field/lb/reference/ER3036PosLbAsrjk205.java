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
public enum ER3036PosLbAsrjk205 implements IObject<KeyValueString> {
	R_4601000000 ("4601000000", "Baris rincian"),
	R_4602000000 ("4602000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3036PosLbAsrjk205 eEnum : ER3036PosLbAsrjk205.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3036PosLbAsrjk205.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3036PosLbAsrjk205.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_4602000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("5", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", R_4601000000.key);
	}
	
	public static ConditionalRequired genConditionField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_4602000000.key, "2");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("5", R_4602000000.key, 
				R_4601000000.key,  "Total|Penjumlahan detail");
	}
}
