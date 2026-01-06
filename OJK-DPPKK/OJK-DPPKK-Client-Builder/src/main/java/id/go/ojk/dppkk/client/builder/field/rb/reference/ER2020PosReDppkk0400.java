package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2020PosReDppkk0400 implements IObject<KeyValueString> {
	R_0401000000 ("0401000000", "Asumsi Tingkat Bunga Aktuaria khusus PPMP (%)"),
	R_0402000000 ("0402000000", "Asumsi Metode Perhitungan Aktuaria"),
	R_0403000000 ("0403000000", "Asumsi Tingkat Mortalita"),
	R_0404000000 ("0404000000", "Target Tingkat Hasil Investasi Dalam Arahan Investasi (%)"),
	R_0405000000 ("0405000000", "dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2020PosReDppkk0400 eEnum : ER2020PosReDppkk0400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2020PosReDppkk0400.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2020PosReDppkk0400.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 3);
	}
	
	public static ConditionalRequired genConditionMustNotEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_0405000000.key);
	}
	
	public static ConditionalRequired genCondition() {
		return UtilFieldConditional.genExistPos("O", "M", R_0405000000.key);
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("4-3", 2, UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 3 }));
	}
	
	public static FieldValidation genValidation6() {
		return UtilFieldValidation.genEqualsPosRatio("4|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 3 }));
	}
	
	public static SegmentValidation genValidationDecimalNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", R_0401000000.key + "|" + R_0404000000.key);
	}
	
	public static SegmentValidation genValidationDecimalLength() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_0401000000.key + "|" + R_0404000000.key, 10);
	}
}
