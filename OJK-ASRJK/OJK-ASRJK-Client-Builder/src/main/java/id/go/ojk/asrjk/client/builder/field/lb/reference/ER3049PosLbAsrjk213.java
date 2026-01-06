package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3049PosLbAsrjk213 implements IObject<KeyValueString> {
//	R_4401010099 ("4401010099", "Premi Bruto"),
	R_4401010100 ("4401010100", "a. Premi Penutupan Langsung"),
	R_4401010200 ("4401010200", "b. Premi Penutupan Tidak Langsung"),
	R_4401010300 ("4401010300", "c. Komisi Dibayar"),
	R_4401010000 ("4401010000", "Jumlah Premi Bruto"),
//	R_7004020099 ("7004020099", "Beban Klaim"),
	R_7011000000 ("7011000000", "a. Klaim Bruto"),
	R_5401030000 ("5401030000", "b. Klaim Reasuransi"),
	R_7004020000 ("7004020000", "Jumlah Beban Klaim"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3049PosLbAsrjk213 eEnum : ER3049PosLbAsrjk213.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3049PosLbAsrjk213.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3049PosLbAsrjk213.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 23), getObjects());
	}
	
	public static FieldValidation genFieldValidation23() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 22), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 6 }));
	}
	
	public static SegmentValidation genValidationPremiBruto() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 23), R_4401010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1) + "-" + R_4401010300.key, 
				"Total premi bruto|Perhitungan premi bruto");
	}
	
	public static SegmentValidation genValidationBebanKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 23), R_7004020000.key, 
				UtilMetadata.genMinusRow(getObjects(), 4, 5),  "Total beban klaim|Perhitungan beban klaim");
	}
}
