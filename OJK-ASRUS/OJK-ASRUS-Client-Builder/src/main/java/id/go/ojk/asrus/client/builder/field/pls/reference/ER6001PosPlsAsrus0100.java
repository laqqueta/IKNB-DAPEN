package id.go.ojk.asrus.client.builder.field.pls.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.db.validation.field.EqualsNoRepeatValidation;
import id.go.ojk.client.db.validation.field.EqualsPeriodeLaporanValidation;
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
public enum ER6001PosPlsAsrus0100 implements IObject<KeyValueString> {
	R_0010010000 ("0010010000", "Detail"),
	R_0010020000 ("0010020000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER6001PosPlsAsrus0100 eEnum : ER6001PosPlsAsrus0100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6001PosPlsAsrus0100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6001PosPlsAsrus0100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1 });
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(13, 26), getObjects());
	}

	public static String genFieldSaveForm() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static ConditionalRequired genConditionalExistPos() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorNotEmptyA() {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "O", "N", R_0010010000.key, "2");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorNotEmptyB() {
		return UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "O", "M", R_0010010000.key, "2");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueA() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M", "N", R_0010010000.key, "4", "500");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueB() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("M", "N", "N", R_0010010000.key, "4", "200|400");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueC() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("M", "N", "O", "N", R_0010010000.key, "4", "200|300", "500");
	}

	public static ConditionalRequired genConditionalExistPosAndComparatorHasValueD() {
		return UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M", "M", R_0010010000.key, "4", "500");
	}

	public static FieldValidation genValidationField06() {
		return UtilFieldValidation.genDateGreater("5");
	}

	public static FieldValidation genValidationField16() {
		return UtilFieldValidation.genGreaterValue("0");
	}

	public static FieldValidation genValidationField17() {
		return UtilFieldValidation.genGreaterValue("0");
	}

	public static FieldValidation genValidationField26A() {
		return UtilFieldValidation.genIfComparatorEquals("4", "200|300", "1");
	}

	public static FieldValidation genValidationField26B() {
		return UtilFieldValidation.genIfComparatorEquals2("4", "100|400", "1");
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(13, 17), R_0010020000.key,
				R_0010010000.key, "Total|Penjumlahan detail");
	}

	public static FieldValidation genValidationNIK() {
		return new EqualsNoRepeatValidation("selectPosCode=" + R_0010010000.key);
	}

	public static FieldValidation genValidationPeriodeLaporan() {
		return new EqualsPeriodeLaporanValidation("selectPosCode=" + R_0010010000.key);
	}

	public static FieldValidation genValidationNIK2() {
		return UtilFieldValidation.genEqualsPosLengthBetween(R_0010010000.key, "4", "100", "15", "16");
	}
}
