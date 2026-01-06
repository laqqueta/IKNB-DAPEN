package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3058PosLbAsrjk615 implements IObject<KeyValueString> {
	R_6150000001 ("6150000001", "Rincian baris"),
	R_6150000002 ("6150000002", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3058PosLbAsrjk615 eEnum : ER3058PosLbAsrjk615.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3058PosLbAsrjk615.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3058PosLbAsrjk615.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_6150000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(5, 11), getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_6150000002.key);
	}
	
	public static ConditionalRequired genConditionFieldA() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_6150000002.key, "2");
	}
	
	public static ConditionalRequired genConditionFieldB() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_6150000002.key, "2");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(5, 11), R_6150000002.key, 
				R_6150000001.key, "Total|Penjumlahan detail");
	}
}
