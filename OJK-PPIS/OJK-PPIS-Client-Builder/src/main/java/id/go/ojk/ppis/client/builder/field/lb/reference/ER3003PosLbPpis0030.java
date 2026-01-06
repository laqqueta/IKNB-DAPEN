 package id.go.ojk.ppis.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1103BentukBadanHukum;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3003PosLbPpis0030 implements IObject<KeyValueString> {
	R_0030010000 ("0030010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3003PosLbPpis0030 eEnum : ER3003PosLbPpis0030.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3003PosLbPpis0030.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3003PosLbPpis0030.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("9|10", getObjects());
	}
	
	public static ConditionalRequired genFieldConditionA() {
		return UtilFieldConditional.genEquals("M", "O", "5",
				ER1103BentukBadanHukum.getExcept(Arrays.asList(3, 5, 6)));
	}

	public static ConditionalRequired genFieldConditionB() {
		return UtilFieldConditional.genEquals("M", "O", "5",
				ER1103BentukBadanHukum.getExcept(Arrays.asList(2, 3)));
	}

	public static FieldValidation genFieldValidation08() {
		return UtilFieldValidation.genIfEqualThen("5", ER1103BentukBadanHukum.getExcept(Arrays.asList(0, 9)), "0.00");
	}

	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genSumEqualsValue("10", R_0030010000.key, "100.00");
	}
}
