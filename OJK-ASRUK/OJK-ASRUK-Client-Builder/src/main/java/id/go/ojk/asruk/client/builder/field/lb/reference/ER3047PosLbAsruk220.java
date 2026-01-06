package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3047PosLbAsruk220 implements IObject<KeyValueString> {
	R_6301000000 ("6301000000", "Rincian Evaluasi Konerja Produk"),
	R_6300000000 ("6300000000", "Total"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3047PosLbAsruk220 eEnum : ER3047PosLbAsruk220.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_6300000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(10, 16), getObjects());
	}

	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_6300000000.key);
	}
	public static ConditionalRequired genConditionFieldA() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_6300000000.key, "2");
	}

	public static ConditionalRequired genConditionFieldB() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_6300000000.key, "2");
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(10, 16), R_6300000000.key, R_6301000000.key, "Total|Penjumlahan detail");
	}
}
