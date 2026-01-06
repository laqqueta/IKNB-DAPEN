 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3107PosLbPpiu0046 implements IObject<KeyValueString> {
	R_0046010000 ("0046010000", "Detail"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3107PosLbPpiu0046 eEnum : ER3107PosLbPpiu0046.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3107PosLbPpiu0046.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3107PosLbPpiu0046.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static ConditionalRequired genFieldCondition() {
		return UtilFieldConditional.genEquals("N", "M", "4", ER1126Negara.R_1.getKey());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genNotEqualsFixedValue(ER1126Negara.R_1.getKey());
	}
	
	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genDateLess("11");
	}
}
