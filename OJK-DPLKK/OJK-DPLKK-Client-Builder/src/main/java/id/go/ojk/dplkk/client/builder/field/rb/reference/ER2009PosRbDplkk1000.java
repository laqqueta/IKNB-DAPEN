package id.go.ojk.dplkk.client.builder.field.rb.reference;

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
public enum ER2009PosRbDplkk1000 implements IObject<KeyValueString> {
	R_1001000000 ("1001000000", "Nilai tukar rupiah"),
	R_1002000000 ("1002000000", "Tingkat inflasi"),
	R_1003000000 ("1003000000", "Tingkat Hasil Investasi"),
	R_1004000000 ("1004000000", "Asumsi lain yang relevan:"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2009PosRbDplkk1000 eEnum : ER2009PosRbDplkk1000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2009PosRbDplkk1000.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2009PosRbDplkk1000.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 2);
	}
	
	public static ConditionalRequired genConditionalMustNotEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_1004000000.key + "|" + R_1004000000.key);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5|6", R_1001000000.key);
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", R_1002000000.key + "|" + R_1003000000.key);
	}
	
	public static SegmentValidation genValidationNumericMaxLength() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_1001000000.key, 16);
	}
	
	public static SegmentValidation genValidationDecimalMaxLength() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_1002000000.key + "|" + R_1003000000.key, 10);
	}
}
