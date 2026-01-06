package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1000JenisInvestasi;
import id.go.ojk.conf.client.field.reference.ER1018DalamLuarNegeri;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3060PosLbReask120 implements IObject<KeyValueString> {
	R_1400080300 ("1400080300", "Rincian baris"),
	R_1400000000 ("1400000000", "Total Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3060PosLbReask120 eEnum : ER3060PosLbReask120.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1400000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("22|24", getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400000000.key);
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionField4() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField5() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField6() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField7() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField8() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), 0, 2));
	}

	public static ConditionalRequired genConditionField9() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField10() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField11() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 5, 6, 8 }));
	}

	public static ConditionalRequired genConditionField12() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 2, 4, 5, 9, 12 }));
	}

	public static ConditionalRequired genConditionalField13() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 2, 3, 4, 10 }));
	}

	public static ConditionalRequired genConditionField14() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_110.getKey());
	}

	public static ConditionalRequired genConditionField15() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10 }));
	}

	public static ConditionalRequired genConditionField16() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10 }));
	}

	public static ConditionalRequired genConditionField17() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionField18() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionField19() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionField20() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionField21() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_117.getKey());
	}

	public static ConditionalRequired genConditionField22() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionField23() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField24() {
		return genConditionField22();
	}

	public static ConditionalRequired genConditionField25() {
		return genConditionField3();
	}

	public static ConditionalRequired genConditionField26() {
		return genConditionField3();
	}
	
	public static FieldValidation genFieldValidation8a() {
		return UtilFieldValidation.genReferenceCondition2("2", 
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), 0, 1), 
				String.valueOf(EHeaderMetadataShared.R031.getNumber()));
	}
	
	public static FieldValidation genFieldValidation8b() {
		return UtilFieldValidation.genMaxLength2("2", ER1000JenisInvestasi.R_103.getKey(),
				"3", ER1018DalamLuarNegeri.R_LO_IDN.getKey(), "4");
	}
	
	public static FieldValidation genFieldValidation8c() {
		return UtilFieldValidation.genMaxLength2("2", ER1000JenisInvestasi.R_103.getKey(),
				"3", ER1018DalamLuarNegeri.R_LO_E1.getKey(), "30");
	}
	
	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R032.getNumber()));
	}
	
	public static FieldValidation genFieldValidation13() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R039.getNumber()));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("22|24", R_1400000000.key, 
				R_1400080300.key, "Total|Penjumlahan detail");
	}
}
