package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
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
public enum ER3042PosLbAsrjk208 implements IObject<KeyValueString> {
	R_5401000001 ("5401000001", "Baris rincian"),
	R_5401000002 ("5401000002", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3042PosLbAsrjk208 eEnum : ER3042PosLbAsrjk208.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3042PosLbAsrjk208.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3042PosLbAsrjk208.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_5401000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(4, 15), getObjects());
	}
	
	public static ConditionalRequired genCondition2() {
		return UtilFieldConditional.genExistPos("N", "O", R_5401000002.key);
	}
	
	public static ConditionalRequired genCondition3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_5401000002.key, "2");
	}
	
	public static ConditionalRequired genCondition() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_5401000002.key, "3");
	}
	
	public static FieldValidation genValidationDati2() {
		return UtilFieldValidation.genPosReferenceCondition3(R_5401000001.key, "2", String.valueOf(EHeaderMetadataShared.R033.getNumber()));
	}
	
	public static FieldValidation genFieldValidation16() {
		return UtilFieldValidation.genEqualsPosFormula("4+8+12", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation17() {
		return UtilFieldValidation.genEqualsPosFormula("5+9+13", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation18() {
		return UtilFieldValidation.genEqualsPosFormula("6+10+14", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation19() {
		return UtilFieldValidation.genEqualsPosFormula("7+11+15", R_5401000001.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(4, 15), R_5401000002.key, 
				R_5401000001.key, "Total|Penjumlahan detail");
	}
}
