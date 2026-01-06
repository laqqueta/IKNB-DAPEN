package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3001PosLbAsrus001 implements IObject<KeyValueString> {
	R_1201000000 ("1201000000", "Daftar rincian pemegang saham"),
	R_1202000000 ("1202000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3001PosLbAsrus001 eEnum : ER3001PosLbAsrus001.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1202000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("4|5", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", R_1201000000.key);
	}
	
	public static ConditionalRequired genConditional3() {
		return genConditional2();
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("4|5", R_1202000000.key, R_1201000000.key, "Total kepemilikan saham|Penjumlahan rincian kepemilikan saham");
	}
	
	public static SegmentValidation genValidationFixedValue() {
		return UtilSegmentValidation.genFixedValue("5", R_1202000000.key, "100.00");
	}
}
