package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2256PosRePmvk060100 implements IObject<KeyValueString> {
	R_06010100000000 ("06010100000000", "Modal Disetor Awal"),
	R_06010200000000 ("06010200000000", "Pemegang Saham"),
	R_06010300000000 ("06010300000000", "Total Modal Disetor"),
	R_06010400000000 ("06010400000000", "Laba ditahan"),
	R_06010500000000 ("06010500000000", "Total Ekuitas"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2256PosRePmvk060100 eEnum : ER2256PosRePmvk060100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2256PosRePmvk060100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2256PosRePmvk060100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1 });
	}
	
	public static ConditionalRequired genValidationMustEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_06010200000000.key);
	}
	
	public static FieldValidation genValidationField6() {
		return UtilFieldValidation.genEqualsFormula("4-5", 0);
	}
}
