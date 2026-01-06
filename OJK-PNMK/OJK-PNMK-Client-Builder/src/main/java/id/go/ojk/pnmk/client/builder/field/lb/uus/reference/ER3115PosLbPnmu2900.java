package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3115PosLbPnmu2900 implements IObject<KeyValueString> {
	R_2900010000 ("2900010000", "Sumber dana Kebajikan"),
	R_2900010100 ("2900010100", "Denda (Ta'zir)"),
	R_2900010200 ("2900010200", "Pendapatan Non Halal"),
	R_2900010300 ("2900010300", "Sumber Dana Kebajikan Lainnya"),
	R_2900020000 ("2900020000", "Penggunaan Dana Kebajikan"),
	R_2900020100 ("2900020100", "Dana Kebajikan Produktif"),
	R_2900020200 ("2900020200", "Sumbangan"),
	R_2900020300 ("2900020300", "Penggunaan Lainnya untuk Kepentingan Umum"),
	R_2900030000 ("2900030000", "Kenaikan"),
	R_2900040000 ("2900040000", "Saldo Awal"),
	R_2900050000 ("2900050000", "Saldo Akhir"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3115PosLbPnmu2900 eEnum : ER3115PosLbPnmu2900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3115PosLbPnmu2900.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3115PosLbPnmu2900.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}

	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRow(getObjects(), 8, 10));
	}
	
	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2900010000.key, UtilMetadata.genPlusRow(getObjects(), 1, 3), 
				UtilMetadata.genMessage(R_2900010000.value, UtilMetadata.genPlusDesc(getObjects(), 1, 3)));
	}
	
	public static SegmentValidation genRowValidation06() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2900020000.key, UtilMetadata.genPlusRow(getObjects(), 5, 7), 
				UtilMetadata.genMessage(R_2900020000.value, UtilMetadata.genPlusDesc(getObjects(), 5, 7)));
	}
	
	public static SegmentValidation genRowValidation10() {
		int[] rows = new int[] { 0, 4 };
		return UtilSegmentValidation.genEqualsFormula("2", R_2900030000.key, UtilMetadata.genMinusRow(getObjects(), rows), 
				UtilMetadata.genMessage(R_2900030000.value, UtilMetadata.genMinusDesc(getObjects(), rows)));
	}
	
	public static SegmentValidation genRowValidation12() {
		int[] rows = new int[] { 8, 9 };
		return UtilSegmentValidation.genEqualsFormula("2", R_2900050000.key, UtilMetadata.genPlusRow(getObjects(), rows), 
				UtilMetadata.genMessage(R_2900050000.value, UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
}
