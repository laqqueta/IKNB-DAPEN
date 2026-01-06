package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum ER2005PosRbReask0601 implements IObject<KeyValueString> {
	R_0601010000 ("0601010000", "Investasi"),
	R_0601020000 ("0601020000", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2005PosRbReask0601 eEnum : ER2005PosRbReask0601.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2005PosRbReask0601.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2005PosRbReask0601.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_0601020000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6", getObjects());
	}
	
	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("O", "N", R_0601010000.key);
	}
	
	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_0601020000.key, "2");
	}
	
	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6", R_0601020000.key, R_0601010000.key, "Total Investasi|Penjumlahan Investasi");
	}
}
