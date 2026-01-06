package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2013PosRbDppkk1400 implements IObject<KeyValueString> {
	R_1401000000 ("1401000000", "Detail"),
	R_1402000000 ("1402000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2013PosRbDppkk1400 eEnum : ER2013PosRbDppkk1400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2013PosRbDppkk1400.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2013PosRbDppkk1400.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 1, 1);
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 9), getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1402000000.key);
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1402000000.key, "2");
	}

	public static SegmentValidation genTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_1402000000.key,
				R_1401000000.key, "Total|Penjumlahan detail");
	}
}
