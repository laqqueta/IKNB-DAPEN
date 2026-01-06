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
public enum ER3047PosLbAsrjk211 implements IObject<KeyValueString> {
	R_5502020100 ("5502020100", "Baris rincian"),
	R_5502020200 ("5502020200", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3047PosLbAsrjk211 eEnum : ER3047PosLbAsrjk211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3047PosLbAsrjk211.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3047PosLbAsrjk211.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_5502020200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 4), getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_5502020200.key);
	}
	
	public static ConditionalRequired genConditionField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_5502020200.key, "2");
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsRatio("4|3");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 4), R_5502020200.key, 
				R_5502020100.key, "Total|Penjumlahan detail");
	}
}
