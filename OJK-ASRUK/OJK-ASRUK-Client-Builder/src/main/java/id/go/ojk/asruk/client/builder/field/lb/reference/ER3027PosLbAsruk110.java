package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1025JenisLiabilitas;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3027PosLbAsruk110 implements IObject<KeyValueString> {
	R_1400100100 ("1400100100", "Baris rincian"),
	R_1400100200 ("1400100200", "Total"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_110.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3027PosLbAsruk110 eEnum : ER3027PosLbAsruk110.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return R_1400100200.key;
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|7|8|9|10|11|12", getObjects());
	}

	public static ConditionalRequired genConditionalField10() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "M", "M", R_1400100200.key, "3",
				ER1025JenisLiabilitas.R_01.getKey());
	}
	public static ConditionalRequired genConditionalField11() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400100200.key, "3");
	}

	public static ConditionalRequired genConditionalField12() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400100200.key, "3");
	}
	
	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400100200.key);
	}
	
	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400100200.key);
	}

	public static ConditionalRequired genConditionalField4() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400100200.key, "3",
				UtilMetadata.genPipeRow(ER1025JenisLiabilitas.getObjects(), new int[] { 1, 2, 4, 5, 6 }));
	}
	
	public static ConditionalRequired genConditionalField5() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400100200.key, "3",
				UtilMetadata.genPipeRowExcept(ER1025JenisLiabilitas.getObjects(), new int[] { 0, 3 }));
	}
	
	public static ConditionalRequired genConditionalField6() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400100200.key, "3",
				UtilMetadata.genPipeRow(ER1025JenisLiabilitas.getObjects(), new int[] { 1, 2 }));
	}

	public static ConditionalRequired genConditionalField7() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "M", "M", R_1400100200.key, "3",
				ER1025JenisLiabilitas.R_01.getKey());
	}

	public static ConditionalRequired genConditionalField8() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "M", "M", R_1400100200.key, "3",
				ER1025JenisLiabilitas.R_01.getKey());
	}

	public static ConditionalRequired genConditionalField9() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "M", "M", R_1400100200.key, "3",
				ER1025JenisLiabilitas.R_01.getKey());
	}

	public static FieldValidation genValidationField11() {
		return UtilFieldValidation.genEqualsPosFormula("9+10", R_1400100100.key);
	}

	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genReferenceCondition("3", "5063");
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("7|8|9|10|11|12", R_1400100200.key, R_1400100100.key, "Total|Penjumlahan detail");
	}
}
