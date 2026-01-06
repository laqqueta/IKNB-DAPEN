package id.go.ojk.dppks.client.builder.field.rb.reference;

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
public enum ER2012PosRbDppks1001 implements IObject<KeyValueString> {
	R_1001010000 ("1001010000", "Detail"),
	R_1001020000 ("1001020000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2012PosRbDppks1001 eEnum : ER2012PosRbDppks1001.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2012PosRbDppks1001.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2012PosRbDppks1001.class.getSimpleName().substring(2, 6));
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("4|6", getObjects());
	}
	
	public static ConditionalRequired genConditionalExistPos() {
		return UtilFieldConditional.genExistPos("N", "M", R_1001020000.key);
	}

	public static SegmentValidation genTotal() {
		return UtilSegmentValidation.genEqualsFormula("4|6", R_1001020000.key,
				R_1001010000.key, "Total|Penjumlahan detail");
	}
}
