 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1121JenisSuratBerharga;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3114PosLbPpiu2200 implements IObject<KeyValueString> {
	R_2200010000 ("2200010000", "Detail"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_2200.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3114PosLbPpiu2200 eEnum : ER3114PosLbPpiu2200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3114PosLbPpiu2200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3114PosLbPpiu2200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("7|13", getObjects());
	}
	
	public static ConditionalRequired genFieldConditionA() {
		return UtilFieldConditional.genEquals("O", "M", "3", ER1121JenisSuratBerharga.getPipedKey(new int[] { 4, 8}));
	}
	
	public static ConditionalRequired genFieldConditionB() {
		return UtilFieldConditional.genEquals("M", "O", "3", ER1121JenisSuratBerharga.getPipedKey(new int[] { 0, 12, 13, 15 }));
	}
	
	public static FieldValidation genFieldValidation04() {
		return UtilFieldValidation.genDateLess("5");
	}
}
