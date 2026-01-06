package id.go.ojk.asrjs.client.builder.field.rb.reference;

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
public enum ER2033PosRbAsrjs1210 implements IObject<KeyValueString> {
	R_12100100000000 ("12100100000000", "Nilai tukar rupiah "),
	R_12100200000000 ("12100200000000", "Tingkat inflasi "),
	R_12100300000000 ("12100300000000", "Kerugian katastropik (dalam awal periode)"),
	R_12100400000000 ("12100400000000", "Tingkat hasil investasi "),
	R_12100500000000 ("12100500000000", "Jumlah pertanggungan baru (dalam premi rupiah) "),
	R_12100600000000 ("12100600000000", "Tingkat penghentian polis ( polis yang dihentikan/jumlah polis di awal periode)"),
	R_12100700000000 ("12100700000000", "Tingkat klaim (klaim bruto/premi bruto)"),
	R_12100800000000 ("12100800000000", "dst (asumsi lain yang relevan)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2033PosRbAsrjs1210 eEnum : ER2033PosRbAsrjs1210.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2033PosRbAsrjs1210.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2033PosRbAsrjs1210.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 6);
	}
	
	public static ConditionalRequired genConditionField() {
		return UtilFieldConditional.genExistPos("O", "N", R_12100800000000.key);
	}

	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("3",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }));
	}

	public static SegmentValidation genValidationNumeric1() {
		return UtilSegmentValidation.genRegexNumeric("3",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 4 }));
	}

	public static SegmentValidation genValidationNumeric2() {
		return UtilSegmentValidation.genRegexNumeric("4|5|6",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 3, 5, 6 }));
	}

	public static SegmentValidation genValidationNumericMaxLength() {
		return UtilSegmentValidation.genMaxLength("3|4|5|6",
				UtilMetadata.genPipeRow(getObjects(), 0, 6), 16);
	}
}
