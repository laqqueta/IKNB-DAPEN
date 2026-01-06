package id.go.ojk.asruk.client.builder.field.rb.reference;

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
public enum ER2018PosRbAsruk1313 implements IObject<KeyValueString> {
	R_1313010000 ("1313010000", "1.Nilai tukar rupiah "),
	R_1313020000 ("1313020000", "2.Tingkat inflasi "),
	R_1313030000 ("1313030000", "3.Kerugian katastropik (dalam rupiah)"),
	R_1313040000 ("1313040000", "4.Tingkat hasil investasi "),
	R_1313050000 ("1313050000", "5.Jumlah pertanggungan baru (dalam premi rupiah) "),
	R_1313060000 ("1313060000", "6.Tingkat penghentian polis ( polis yang dihentikan/ jumlah polis di awal periode)"),
	R_1313070000 ("1313070000", "7.Tingkat klaim (klaim bruto/premi bruto)"),
	R_1313080000 ("1313080000", "8.dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2018PosRbAsruk1313 eEnum : ER2018PosRbAsruk1313.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2018PosRbAsruk1313.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2018PosRbAsruk1313.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 6);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPos("O", "N", R_1313080000.key);
	}

	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6", UtilMetadata.genPipeRow(getObjects(), 0, 6), 16);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5|6", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 3, 5, 6 }));
	}
}
