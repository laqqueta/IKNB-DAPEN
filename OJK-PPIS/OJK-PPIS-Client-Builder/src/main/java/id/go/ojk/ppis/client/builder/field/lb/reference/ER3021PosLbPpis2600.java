 package id.go.ojk.ppis.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1121JenisSuratBerharga;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppis.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3021PosLbPpis2600 implements IObject<KeyValueString> {
	R_2600010000 ("2600010000", "Detail"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_2600.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3021PosLbPpis2600 eEnum : ER3021PosLbPpis2600.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3021PosLbPpis2600.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3021PosLbPpis2600.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 5, 14 }), getObjects());
	}
	
	public static ConditionalRequired genFieldConditionA() {
		return UtilFieldConditional.genEquals("O", "M", "3", ER1121JenisSuratBerharga.getPipedKey(new int[] { 4, 8}));
	}
	
	public static ConditionalRequired genFieldConditionB() {
		return UtilFieldConditional.genEquals("O", "M", "5", ER1122JenisValuta.R_1.getKey());
	}
	
	public static ConditionalRequired genFieldConditionC() {
		return UtilFieldConditional.genEquals("M", "O", "3", ER1121JenisSuratBerharga.getPipedKey(new int[] { 0, 12, 13, 15 }));
	}
	
	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genDateLess("7");
	}
}
