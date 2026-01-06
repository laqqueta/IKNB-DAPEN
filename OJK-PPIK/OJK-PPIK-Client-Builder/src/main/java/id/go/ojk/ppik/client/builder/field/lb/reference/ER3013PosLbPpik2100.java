 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3013PosLbPpik2100 implements IObject<KeyValueString> {
	R_2100010000 ("2100010000", "Detail"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_2100.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3013PosLbPpik2100 eEnum : ER3013PosLbPpik2100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3013PosLbPpik2100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3013PosLbPpik2100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 13, 18, 20, 21, 36, 37, 38 }), getObjects());
	}
	
	public static ConditionalRequired genFieldCondition() {
		return UtilFieldConditional.genEquals("O", "M", "21", ER1122JenisValuta.R_1.getKey());
	}
	
	public static ConditionalRequired genFieldCondition41() {
		return UtilFieldConditional.genAllExist("M", "N", "40");
	}
	
	public static ConditionalRequired genFieldCondition43() {
		return UtilFieldConditional.genAllExist("M", "N", "42");
	}
	
	public static FieldValidation genFieldValidation14() {
		return UtilFieldValidation.genDateLess("15");
	}
	
	public static SegmentValidation genRowValidation2() {
		return UtilSegmentValidation.genNotZeroField("36|37|38", R_2100010000.key);
	}
}
