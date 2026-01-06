package id.go.ojk.asrjs.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2036PosRbAsrjs1303 implements IObject<KeyValueString> {
//	R_13030100000000 ("13030100000000", "1.    Rasio Likuiditas"),
	R_13030101000000 ("13030101000000", "a.    Kekayaan lancar"),
	R_13030102000000 ("13030102000000", "b.    Kewajiban lancar"),
	R_13030103000000 ("13030103000000", "c.    Rasio (a:b)"),
//	R_13030200000000 ("13030200000000", "2.    Rasio Pendapatan investasi neto"),
	R_13030201000000 ("13030201000000", "a.    Pendapatan investasi netto"),
	R_13030202000000 ("13030202000000", "b.    Rata-rata investasi"),
	R_13030203000000 ("13030203000000", "c.    Rasio (a:b)"),
//	R_13030300000000 ("13030300000000", "3.    Rasio perubahan dana"),
	R_13030301000000 ("13030301000000", "a.    Dana Investasi Peserta Periode berjalan"),
	R_13030302000000 ("13030302000000", "b.    Dana Investasi Peserta Periode lalu"),
	R_13030303000000 ("13030303000000", "c.    Perubahan dana (a-b)"),
	R_13030304000000 ("13030304000000", "d.    Rasio (c:b)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2036PosRbAsrjs1303 eEnum : ER2036PosRbAsrjs1303.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2036PosRbAsrjs1303.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2036PosRbAsrjs1303.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 6, 7, 8 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 5, 9 }));
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13030103000000.key,
				R_13030101000000.key + "|" + R_13030102000000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13030203000000.key,
				R_13030201000000.key + "|" + R_13030202000000.key, 
				"Total Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}

	public static SegmentValidation genValidationPerubahanDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13030303000000.key,
				R_13030301000000.key + "-" + R_13030302000000.key, 
				"Total Perubahan dana Perusahaan|Perhitungan Perubahan dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13030304000000.key,
				R_13030303000000.key + "|" + R_13030302000000.key, 
				"Total Rasio perubahan dana|Perhitungan Rasio perubahan dana");
	}
}
