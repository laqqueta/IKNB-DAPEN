package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3057PosLbAsrjk614 implements IObject<KeyValueString> {
	R_6140000001 ("6140000001", "Rincian baris"),
	R_6140000002 ("6140000002", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3057PosLbAsrjk614 eEnum : ER3057PosLbAsrjk614.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3057PosLbAsrjk614.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3057PosLbAsrjk614.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_6140000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(6, 18), getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_6140000002.key);
	}
	
	public static ConditionalRequired genConditionFieldA() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_6140000002.key, "2");
	}
	
	public static ConditionalRequired genConditionFieldB() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_6140000002.key, "2");
	}
	
	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genEqualsPosFormula("10+11", R_6140000001.key);
	}
	
	public static FieldValidation genFieldValidation15() {
		return UtilFieldValidation.genEqualsPosFormula("13+14", R_6140000001.key);
	}
	
	public static FieldValidation genFieldValidation18() {
		return UtilFieldValidation.genEqualsPosFormula("16+17", R_6140000001.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(6, 18), R_6140000002.key, 
				R_6140000001.key, "Total|Penjumlahan detail");
	}
}
