package id.go.ojk.pnjs.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3038PosLbPnjs8100 implements IObject<KeyValueString> {
	R_8100010000 ("8100010000", "Lancar"),
	R_8100020000 ("8100020000", "Dalam Perhatian Khusus"),
	R_8100030000 ("8100030000", "Kurang Lancar"),
	R_8100040000 ("8100040000", "Diragukan"),
	R_8100050000 ("8100050000", "Macet"),
	R_8100060000 ("8100060000", "Jumlah"),
	R_8100070000 ("8100070000", "Non-Performing Guarantee/NPG"),
	R_8100080000 ("8100080000", "Rasio NPG"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3038PosLbPnjs8100 eEnum : ER3038PosLbPnjs8100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3038PosLbPnjs8100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3038PosLbPnjs8100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }));
	}

	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 6, 7 }));
	}
	
	public static SegmentValidation genValidation7() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_8100060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				UtilMetadata.genMessage(R_8100060000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 4)));
	}
	
	public static SegmentValidation genValidation8() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_8100070000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 4),
				UtilMetadata.genMessage(R_8100070000.value, UtilMetadata.genPlusDesc(getObjects(), 2, 4)));
	}
	
	public static SegmentValidation genValidation9() {
		int[] field = new int[] { 6, 5 };
		return UtilSegmentValidation.genEqualsPercentage("2|3|4", R_8100080000.key, R_8100070000.key, R_8100060000.key,
				UtilMetadata.genMessage(R_8100080000.value, UtilMetadata.genDevideDesc(getObjects(), field)), 2);
	}
}
