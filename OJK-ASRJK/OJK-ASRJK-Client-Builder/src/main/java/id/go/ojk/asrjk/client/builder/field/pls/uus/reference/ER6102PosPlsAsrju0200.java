package id.go.ojk.asrjk.client.builder.field.pls.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanPolisUus;
import id.go.ojk.client.db.validation.field.EqualsNoRepeatValidation;
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
public enum ER6102PosPlsAsrju0200 implements IObject<KeyValueString> {
	R_0020010000 ("0020010000", "Detail"),
	R_0020020000 ("0020020000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER6102PosPlsAsrju0200 eEnum : ER6102PosPlsAsrju0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6102PosPlsAsrju0200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6102PosPlsAsrju0200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("7", getObjects());
	}

	public static String genFieldSaveForm() {
		return UtilMetadata.genFieldSave("3", getObjects());
	}

	public static ConditionalRequired genConditionalExistPos() {
		return UtilFieldConditional.genExistPos("O", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorNotEmptyA() {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "N", "N", R_0020010000.key, "2");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorNotEmptyB() {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "N", "N", R_0020010000.key, "3");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueA() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("M", "N", "O", "M", R_0020010000.key, "2", "200", "100");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueB() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("M", "N", "O", "N", R_0020010000.key, "2", "200", "100");
	}

	public static FieldValidation genValidationField7() {
		return UtilFieldValidation.genNotEqualsPosFixedValue("0", R_0020010000.key);
	}

	public static SegmentValidation genValidation2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(8, 10), R_0020020000.key,
				R_0020010000.key, "Total|Penjumlahan detail");
	}

	public static SegmentValidation genValidation3() {
		return UtilSegmentValidation.genIsExistsFormDb("3", R_0020010000.key, EFormLaporanPolisUus.PLS_0100.getCode(),
				ER6101PosPlsAsrju0100.R_0010010000.getObject().getKey(), "2");
//		return UtilSegmentValidation.genIsExistsForm("3", R_0020010000.key, EFormLaporanPolisUus.PLS_0100.getCode(), "2");
	}

	public static FieldValidation genValidationNIK() {
		return new EqualsNoRepeatValidation("selectPosCode=" + R_0020010000.key);
	}

	public static FieldValidation genValidationNIK3() {
		return UtilFieldValidation.genEqualsComparePosForm(R_0020010000.key, "3",
				EFormLaporanPolisUus.PLS_0100.getCode(), "7", "2");
	}

	public static SegmentValidation genValidation4() {
		return UtilSegmentValidation.genIsExistsFormDb("5", R_0020010000.key, EFormLaporanPolisUus.PLS_0100.getCode(),
				ER6101PosPlsAsrju0100.R_0010010000.getObject().getKey(), "7");
	}
}
