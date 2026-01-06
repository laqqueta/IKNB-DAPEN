package id.go.ojk.dplks.client.builder.field.rb.reference;

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
public enum ER2018PosRbDplks1203 implements IObject<KeyValueString> {
	R_1203010000 ("1203010000", "1. Nilai tukar rupiah "),
	R_1203020000 ("1203020000", "2. Tingkat inflasi "),
	R_1203030000 ("1203030000", "3. Tingkat hasil investasi "),
	R_1203040000 ("1203040000", "4. dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2018PosRbDplks1203 eEnum : ER2018PosRbDplks1203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2018PosRbDplks1203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2018PosRbDplks1203.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 2);
	}
	
	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_1203040000.key);
	}
	
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", R_1203020000.key + "|" + R_1203030000.key);
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5|6", R_1203010000.key);
	}
	
	public static SegmentValidation genValidationDecimalMaxLength10() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_1203020000.key + "|" + R_1203030000.key, 10);
	}
	
	public static SegmentValidation genValidationDecimalMaxLength16() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_1203010000.key, 16);
	}
}
