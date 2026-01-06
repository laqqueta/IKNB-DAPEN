package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

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
public enum ER2118PosRbDppu1203 implements IObject<KeyValueString> {
	R_1203010000 ("1203010000", "1. Asumsi Tingkat Bagi Hasil (khusus PPMP)"),
	R_1203020000 ("1203020000", "2. Asumsi Metode Perhitungan Aktuaria"),
	R_1203030000 ("1203030000", "3. Asumsi Tingkat Mortalita"),
	R_1203040000 ("1203040000", "4. Target tingkat hasil investasi dalam Arahan Investasi"),
	R_1203050000 ("1203050000", "5. dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2118PosRbDppu1203 eEnum : ER2118PosRbDppu1203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2118PosRbDppu1203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2118PosRbDppu1203.class.getSimpleName().substring(2, 6));
	}
	
	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", R_1203050000.key);
	}
	
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", R_1203010000.key + "|" + R_1203040000.key);
	}
	
	public static SegmentValidation genValidationDecimalMaxLength10() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", R_1203010000.key + "|" + R_1203040000.key, 10);
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 3);
	}
}
