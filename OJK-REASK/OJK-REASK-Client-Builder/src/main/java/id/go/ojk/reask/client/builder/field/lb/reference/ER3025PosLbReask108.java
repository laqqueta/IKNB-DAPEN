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
import id.go.ojk.conf.client.field.reference.ER1002JenisInvestasiPaydi;
import id.go.ojk.conf.client.field.reference.ER1018DalamLuarNegeri;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3025PosLbReask108 implements IObject<KeyValueString> {
	R_1400080100 ("1400080100", "Baris rincian"),
	R_1400080200 ("1400080200", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_108.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3025PosLbReask108 eEnum : ER3025PosLbReask108.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_1400080200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|17|18|20", getObjects());
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1400080200.key);
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400080200.key, "2");
	}

	public static ConditionalRequired genConditionalField4() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), 0, 2));
	}

	public static ConditionalRequired genConditionalField5() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1400080200.key, "2");
	}

	public static ConditionalRequired genConditionalField6() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), new int[] { 0 , 1, 3, 4, 5, 6, 8 }));
	}

	public static ConditionalRequired genConditionalField7() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), new int[] { 0, 2, 4, 5, 9, 11 }));
	}

	public static ConditionalRequired genConditionalField8() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), new int[] { 0, 1, 2, 3, 4, 10 }));
	}

	public static ConditionalRequired genConditionalField9() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_110.getKey());
	}

	public static ConditionalRequired genConditionalField10() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10 }));
	}

	public static ConditionalRequired genConditionalField11() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), new int[] { 0, 1, 3, 4, 6, 10 }));
	}

	public static ConditionalRequired genConditionalField12() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField13() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField14() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField15() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField16() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				ER1002JenisInvestasiPaydi.R_117.getKey());
	}

	public static ConditionalRequired genConditionalField17() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400080200.key, "2");
	}

	public static ConditionalRequired genConditionalField18() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400080200.key, "2");
	}

	public static ConditionalRequired genConditionalField19() {
		return UtilFieldConditional.genExistPosOrComparatorHasValue("N", "N", "M", R_1400080200.key, "2",
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), 3, 8) + 
				"|" + ER1002JenisInvestasiPaydi.R_111.getKey() + "|" + ER1002JenisInvestasiPaydi.R_113.getKey());
	}

	public static ConditionalRequired genConditionalField20() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1400080200.key, "2");
	}

	public static ConditionalRequired genConditionalField21() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "O", R_1400080200.key, "2");
	}
	
	public static FieldValidation genFieldValidation4a() {
		return UtilFieldValidation.genReferenceCondition2("2", 
				UtilMetadata.genPipeRow(ER1002JenisInvestasiPaydi.getObjects(), 0, 1), 
				String.valueOf(EHeaderMetadataShared.R031.getNumber()));
	}
	
	public static FieldValidation genFieldValidation4b() {
		return UtilFieldValidation.genMaxLength2("2", ER1002JenisInvestasiPaydi.R_103.getKey(),
				"3", ER1018DalamLuarNegeri.R_LO_IDN.getKey(), "4");
	}
	
	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R033.getNumber()));
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genReferenceCondition("2", String.valueOf(EHeaderMetadataShared.R037.getNumber()));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("17|18|20", R_1400080200.key, R_1400080100.key, "Total|Penjumlahan detail");
	}
}
