package id.go.ojk.asrjk.client.builder.field.rb.uus.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2148PosReAsrju0403 implements IObject<KeyValueString> {
//	R_04030100000000 ("04030100000000", "I. Rasio Likuiditas"),
	R_04030101000000 ("04030101000000", "1. Kekayaan lancar"),
	R_04030102000000 ("04030102000000", "2. Kewajiban lancar"),
	R_04030103000000 ("04030103000000", "3. Rasio (a:b)"),
//	R_04030200000000 ("04030200000000", "II. Rasio Pendapatan investasi neto"),
	R_04030201000000 ("04030201000000", "1. Pendapatan investasi netto"),
	R_04030202000000 ("04030202000000", "2. Rata-rata investasi"),
	R_04030203000000 ("04030203000000", "3. Rasio (a:b)"),
//	R_04030300000000 ("04030300000000", "III. Rasio perubahan dana"),
	R_04030301000000 ("04030301000000", "1. Dana Investasi Peserta Periode berjalan"),
	R_04030302000000 ("04030302000000", "2. Dana Investasi Peserta Periode lalu"),
	R_04030303000000 ("04030303000000", "3. Perubahan dana (a-b)"),
	R_04030304000000 ("04030304000000", "4. Rasio (c:b)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2148PosReAsrju0403 eEnum : ER2148PosReAsrju0403.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2148PosReAsrju0403.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2148PosReAsrju0403.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 6, 7, 8 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 5, 9 }));
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04030103000000.key,
				R_04030101000000.key + "|" + R_04030102000000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04030203000000.key,
				R_04030201000000.key + "|" + R_04030202000000.key, 
				"Total Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}

	public static SegmentValidation genValidationPerubahanDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04030303000000.key,
				R_04030301000000.key + "-" + R_04030302000000.key, 
				"Total Perubahan Dana Perusahaan|Perhitungan Perubahan Dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04030304000000.key,
				R_04030303000000.key + "|" + R_04030302000000.key, 
				"Total Rasio perubahan dana|Perhitungan Rasio perubahan dana");
	}
}
