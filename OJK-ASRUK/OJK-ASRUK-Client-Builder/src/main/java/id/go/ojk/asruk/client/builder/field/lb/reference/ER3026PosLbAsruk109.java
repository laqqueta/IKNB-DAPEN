package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1022JenisNonInvestasi;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3026PosLbAsruk109 implements IObject<KeyValueString> {
	R_1400090100 ("1400090100", "Baris rincian"),
	R_1400090200 ("1400090200", "Total"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_109.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3026PosLbAsruk109 eEnum : ER3026PosLbAsruk109.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return R_1400090200.key;
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|11|12|13|14|15|16|17|18|19", getObjects());
	}

	public static ConditionalRequired genConditionalField10() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				UtilMetadata.genPipeRow(ER1022JenisNonInvestasi.getObjects(), 2, 5));
	}
	public static ConditionalRequired genConditionalField11() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField12() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField13() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField14() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField15() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField16() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}
	
	public static ConditionalRequired genConditionalField17() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField18() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField19() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "M", R_1400090200.key);
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400090200.key);
	}

	public static ConditionalRequired genConditionalField4() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400090200.key, "2");
	}

	public static ConditionalRequired genConditionalField5() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				UtilMetadata.genPipeRow(ER1022JenisNonInvestasi.getObjects(), 0, 7));
	}

	public static ConditionalRequired genConditionalField6() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				ER1022JenisNonInvestasi.R_104.getKey());
	}

	public static ConditionalRequired genConditionalField7() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				ER1022JenisNonInvestasi.R_109.getKey());
	}

	public static ConditionalRequired genConditionalField8() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				ER1022JenisNonInvestasi.R_110.getKey());
	}

	public static ConditionalRequired genConditionalField9() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400090200.key, "3",
				UtilMetadata.genPipeRow(ER1022JenisNonInvestasi.getObjects(), 2, 5));
	}

	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genReferenceCondition("3", String.valueOf(EHeaderMetadataShared.R052.getNumber()));
	}

	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("11|12|13|14|15|16|17|18|19", R_1400090200.key, R_1400090100.key, "Total|Penjumlahan detail");
	}
}
