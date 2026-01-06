package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2119PosRbAsruu1001 implements IObject<KeyValueString> {
	R_1001010000 ("1001010000", "Dst"),
	R_1001020000 ("1001020000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2119PosRbAsruu1001 eEnum : ER2119PosRbAsruu1001.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2119PosRbAsruu1001.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2119PosRbAsruu1001.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_1001020000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6|7|8|9", getObjects());
	}

	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "O", R_1001020000.key);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1001020000.key, "2");
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6|7|8|9", R_1001020000.key, R_1001010000.key, 
				"Total|Penjumlahan detail");
	}
}
