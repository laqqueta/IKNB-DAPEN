package id.go.ojk.dplks.client.builder.field.rb.reference;

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
public enum ER2023PosReDplks0400 implements IObject<KeyValueString> {
	R_0401000000 ("0401000000", "Nilai tukar rupiah "),
	R_0402000000 ("0402000000", "Tingkat inflasi "),
	R_0403000000 ("0403000000", "Tingkat hasil investasi "),
	R_0404000000 ("0404000000", "dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2023PosReDplks0400 eEnum : ER2023PosReDplks0400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2023PosReDplks0400.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2023PosReDplks0400.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 2);
	}
	
	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsPosFormula("4-3", 2, UtilMetadata.genPipeRow(getObjects(), 0, 2));
	}
	
	public static FieldValidation genValidationField6() {
		return UtilFieldValidation.genEqualsPosRatio("4|3", UtilMetadata.genPipeRow(getObjects(), 0, 2));
	}
	
	public static SegmentValidation genValidationDecimalNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5", R_0401000000.key);
	}
	
	public static SegmentValidation genValidationDecimalDotNegatifA() {
		return UtilSegmentValidation.genRegexNumericDotNegative("6", R_0401000000.key);
	}
	
	public static SegmentValidation genValidationDecimalDotNegatifB() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", R_0402000000.key + "|" + R_0403000000.key);
	}
	
	public static SegmentValidation genValidationMaxLenght10A() {
		return UtilSegmentValidation.genMaxLength("6", R_0401000000.key, 10);
	}
	
	public static SegmentValidation genValidationMaxLenght10B() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_0402000000.key + "|" + R_0403000000.key, 10);
	}
	
	public static SegmentValidation genValidationMaxLenght16() {
		return UtilSegmentValidation.genMaxLength("3|4|5", R_0401000000.key, 16);
	}
	
	public static ConditionalRequired genConditionMustNotEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_0404000000.key);
	}
}
