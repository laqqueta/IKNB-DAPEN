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
import id.go.ojk.conf.client.field.reference.ER1020JenisJaminan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3024PosLbReask107 implements IObject<KeyValueString> {
	R_1400070100 ("1400070100", "Baris rincian"),
	R_1400000000 ("1400000000", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_107.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3024PosLbReask107 eEnum : ER3024PosLbReask107.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1400000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|23|24|26", getObjects());
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400000000.key);
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionalField4() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), 0, 1));
	}

	public static ConditionalRequired genConditionalField5() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionalField6() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 5, 6, 8, 17, 18, 19 }));
	}

	public static ConditionalRequired genConditionalField7() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 2, 4, 5, 9, 12, 13, 14, 17, 18 }));
	}

	public static ConditionalRequired genConditionalField8() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 2, 3, 4, 10, 13, 19, 21 }));
	}

	public static ConditionalRequired genConditionalField9() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_110.getKey());
	}

	public static ConditionalRequired genConditionalField10() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10, 19 }));
	}

	public static ConditionalRequired genConditionalField11() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10, 19 }));
	}

	public static ConditionalRequired genConditionalField12() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 13, 17 }));
	}

	public static ConditionalRequired genConditionalField13() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_116.getKey());
	}

	public static ConditionalRequired genConditionalField14() {
		return UtilFieldConditional.genIzinOjkConditional("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_114.getKey(), "12", "25.00", "2", ER1000JenisInvestasi.R_116.getKey(), 
				"kolom 3 diisi \"114\" dan kolom 13 lebih dari \"25.00\", atau  jika kolom 3 diisi \"116\"");
	}

	public static ConditionalRequired genConditionalField15() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_115.getKey());
	}

	public static ConditionalRequired genConditionalField16() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_115.getKey());
	}

	public static ConditionalRequired genConditionalField17() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField18() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField19() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 17, 18 }));
	}

	public static ConditionalRequired genConditionalField20() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField21() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				ER1000JenisInvestasi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField22() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 16, 18 }));
	}

	public static ConditionalRequired genConditionalField23() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionalField24() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionalField25() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400000000.key, "2",
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), new int[] { 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 19, 20 }));
	}

	public static ConditionalRequired genConditionalField26() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400000000.key, "2");
	}

	public static ConditionalRequired genConditionalField27() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "O", R_1400000000.key, "2");
	}
	
	public static FieldValidation genFieldValidation4a() {
		return UtilFieldValidation.genReferenceCondition2("2", 
				UtilMetadata.genPipeRow(ER1000JenisInvestasi.getObjects(), 0, 1), 
				String.valueOf(EHeaderMetadataShared.R031.getNumber()));
	}
	
	public static FieldValidation genFieldValidation4b() {
		return UtilFieldValidation.genMaxLength2("2", ER1000JenisInvestasi.R_103.getKey(),
				"3", ER1018DalamLuarNegeri.R_LO_IDN.getKey(), "4");
	}
	
	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R032.getNumber()));
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R035.getNumber()));
	}
	
	public static FieldValidation genFieldValidation17() {
		return UtilFieldValidation.genIfEqualThen("2", 
				ER1000JenisInvestasi.R_113.getKey(), UtilMetadata.genPipeRow(ER1020JenisJaminan.getObjects()));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("23|24|26", R_1400000000.key, R_1400070100.key, "Total|Penjumlahan detail");
	}
}
