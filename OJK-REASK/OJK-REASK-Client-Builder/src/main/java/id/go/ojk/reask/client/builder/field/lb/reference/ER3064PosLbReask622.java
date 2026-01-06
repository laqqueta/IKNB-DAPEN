package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3064PosLbReask622 implements IObject<KeyValueString> {
	R_4401010010 ("4401010010", "Direct Marketing"),
	R_4401010020 ("4401010020", "Agen"),
	R_4401010030 ("4401010030", "Bancassurance"),
	R_4401010040 ("4401010040", "Badan Usaha Selain Bank"),
	R_4401010041 ("4401010041", "a. Agen Laku Pandai"),
	R_4401010042 ("4401010042", "b. Selain Agen Laku Pandai"),
	R_4401010050 ("4401010050", "Tenaga Pemasar"),
	R_4401010051 ("4401010051", "a. Agen Laku Pandai"),
	R_4401010052 ("4401010052", "b. Selain Agen Laku Pandai"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3064PosLbReask622 eEnum : ER3064PosLbReask622.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("4|5|7|8", getObjects());
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPos("N", "O", UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 6 }));
	}
	
	public static ConditionalRequired genConditionField4() {
		return UtilFieldConditional.genExistPos("N", "O", UtilMetadata.genPipeRow(getObjects(), 6, 8));
	}

	public static SegmentValidation genValidationBadanUsahaSelainBank() {
		return UtilSegmentValidation.genEqualsFormula("4|7|8", R_4401010040.key, UtilMetadata.genPlusRow(getObjects(), 4, 5), 
				"Total Badan Usaha Selain Bank|Penjumlahan Badan Usaha Selain Bank", 0);
	}

	public static SegmentValidation genValidationTenagaPemasar() {
		return UtilSegmentValidation.genEqualsFormula("7|8", R_4401010050.key, UtilMetadata.genPlusRow(getObjects(), 7, 8), 
				"Total Tenaga Pemasar|Penjumlahan Tenaga Pemasar", 0);
	}
}
