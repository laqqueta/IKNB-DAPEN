package id.go.ojk.asrjk.client.builder.field.rb.reference;

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
public enum ER2006PosRbAsrjk0602 implements IObject<KeyValueString> {
	R_0602010000 ("0602010000", "Investasi"), 
	R_0602020000 ("0602020000", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2006PosRbAsrjk0602 eEnum : ER2006PosRbAsrjk0602.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2006PosRbAsrjk0602.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2006PosRbAsrjk0602.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_0602020000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6", getObjects());
	}

	public static ConditionalRequired genConditionalFieldMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "O", R_0602020000.key);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_0602020000.key, "2");
	}

	public static SegmentValidation genValidationHasilInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6", R_0602020000.key, R_0602010000.key, 
				"Total Hasil Investasi|Penjumlahan Hasil Investasi");
	}
}
