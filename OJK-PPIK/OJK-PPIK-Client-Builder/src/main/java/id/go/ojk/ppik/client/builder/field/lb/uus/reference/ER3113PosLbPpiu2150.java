 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1133GolonganPihakLawan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3113PosLbPpiu2150 implements IObject<KeyValueString> {
	R_2150010000 ("2150010000", "Detail"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_2150.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3113PosLbPpiu2150 eEnum : ER3113PosLbPpiu2150.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3113PosLbPpiu2150.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3113PosLbPpiu2150.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 13, 14, 18, 19, 21, 24, 39, 40, 41 }), getObjects());
	}
	
	public static ConditionalRequired genFieldConditionA() {
		return UtilFieldConditional.genEquals("O", "M", "7", ER1133GolonganPihakLawan.R_109.getKey() + "|" + ER1133GolonganPihakLawan.R_111.getKey());
	}
	
	public static ConditionalRequired genFieldConditionB() {
		return UtilFieldConditional.genEquals("O", "M", "24", ER1122JenisValuta.R_1.getKey());
	}
	
	public static ConditionalRequired genFieldCondition44() {
		return UtilFieldConditional.genAllExist("M", "N", "43");
	}
	
	public static ConditionalRequired genFieldCondition46() {
		return UtilFieldConditional.genAllExist("M", "N", "45");
	}
	
	public static FieldValidation genFieldValidation15() {
		return UtilFieldValidation.genDateLess("16");
	}
	
	public static FieldValidation genFieldValidation28() {
		return UtilFieldValidation.genEqualsFixedValue("0");
	}
	
	public static FieldValidation genFieldValidation29() {
		return UtilFieldValidation.genEqualsFixedValue("0");
	}
}
