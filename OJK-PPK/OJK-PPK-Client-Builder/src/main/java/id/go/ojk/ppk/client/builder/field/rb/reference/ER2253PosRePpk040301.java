package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

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
public enum ER2253PosRePpk040301 implements IObject<KeyValueString> {
	R_04030101000000 ("04030101000000", "Nama Debitur"), 
	R_04030102000000 ("04030102000000", "Total"),
	R_04030103000000 ("04030103000000", "Equitas"), 
	R_04030104000000 ("04030104000000", "%"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2253PosRePpk040301 eEnum : ER2253PosRePpk040301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2253PosRePpk040301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2253PosRePpk040301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 1, 3);
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("5|6", getObjects());
	}

	public static ConditionalRequired genConditionalFieldMustEmpty() {
		return UtilFieldConditional.genExistPos("O", "N", R_04030101000000.key);
	}

	public static ConditionalRequired genConditionalField1() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", 
				UtilMetadata.genPipeRow(getObjects(), 1, 3), "2");
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", 
				UtilMetadata.genPipeRow(getObjects(), 1, 3), "2");
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("6-5", 2);
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("5|6|7", R_04030104000000.key);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("5|6|7", UtilMetadata.genPipeRow(getObjects(), 0, 2));
	}

	public static SegmentValidation genValidationTotalPenyaluranPembiayaankepadaPihakTerkait() {
		return UtilSegmentValidation.genEqualsFormula("5|6", R_04030102000000.key, R_04030101000000.key,
				"Total Penyaluran Pembiayaan kepada Pihak Terkait|Penjumlahan Penyaluran Pembiayaan kepada Pihak Terkait");
	}

	public static SegmentValidation genValidationRasioPenyaluranPembiayaanPihakTerkaitTerhadapEkuitas() {
		return UtilSegmentValidation.genEqualsRatio("5|6|7",
				R_04030104000000.key, R_04030102000000.key + "|" + R_04030103000000.key,
				"Rasio Penyaluran Pembiayaan Pihak Terkait terhadap Ekuitas|Perhitungan Rasio Penyaluran Pembiayaan Pihak Terkait terhadap Ekuitas");
	}
}
