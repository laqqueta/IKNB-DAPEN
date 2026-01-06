package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3040PosLbAsrjs231 implements IObject<KeyValueString> {
//	R_2310080100 ("2310080100", "Dana Tabaru dan Tanahud"),
	R_2310080101 ("2310080101", "<= 1 tahun "),
	R_2310080102 ("2310080102", "1 tahun < umur < 5 tahun"),
	R_2310080103 ("2310080103", "5 tahun = umur < 10 tahun"),
	R_2310080104 ("2310080104", ">= 10 tahun"),
	R_2310080105 ("2310080105", "Total"),
	R_2310080106 ("2310080106", "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar"),
//	R_2310080107 ("2310080107", "Dana Perusahaan"),
	R_2310080108 ("2310080108", "<= 1 tahun "),
	R_2310080109 ("2310080109", "1 tahun < umur < 5 tahun"),
	R_2310080110 ("2310080110", "5 tahun = umur < 10 tahun"),
	R_2310080111 ("2310080111", ">= 10 tahun"),
	R_2310080112 ("2310080112", "Total"),
	R_2310080113 ("2310080113", "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar"),
//	R_2310080114 ("2310080114", "Dana Investasi Perusahaan"),
	R_2310080115 ("2310080115", "<= 1 tahun "),
	R_2310080116 ("2310080116", "1 tahun < umur < 5 tahun"),
	R_2310080117 ("2310080117", "5 tahun = umur < 10 tahun"),
	R_2310080118 ("2310080118", ">= 10 tahun"),
	R_2310080119 ("2310080119", "Total"),
	R_2310080120 ("2310080120", "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3040PosLbAsrjs231 eEnum : ER3040PosLbAsrjs231.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}

	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 5, 10, 11, 16, 17 }));
	}

	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("5+6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 5, 10, 11, 16, 17 }));
	}

	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genEqualsPosRatio("2|5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 17 }));
	}

	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsPosRatio("3|6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 17 }));
	}

	public static FieldValidation genValidation10() {
		return UtilFieldValidation.genEqualsPosRatio("4|7", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 17 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 7), UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 17 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 7), UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 11, 17 }));
	}
	
	public static SegmentValidation genValidationMaxLength6() {
		return UtilSegmentValidation.genMaxLength(UtilMetadata.genPipeColumn(2, 7), UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 11, 17 }), 6);
	}
	
	public static SegmentValidation genValidationTotalDanaTabaruDanTanahud() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2310080105.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total Dana Tabaru dan Tanahud|Penjumlahan Dana Tabaru dan Tanahud");
	}
	
	public static SegmentValidation genValidationRasioAsetDanaTabaruDanTanahud() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 10), R_2310080106.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 4 }), "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar - Dana Tabaru dan Tanahud|Perhitungan Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar Dana Tabaru dan Tanahud");
	}
	
	public static SegmentValidation genValidationTotalDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2310080112.key, 
				UtilMetadata.genPlusRow(getObjects(), 6, 9), "Total Dana Perusahaan|Penjumlahan Dana Perusahaan");
	}
	
	public static SegmentValidation genValidationRasioAsetDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 10), R_2310080113.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 10 }), "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar - Dana Perusahaan|Perhitungan Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar Dana Perusahaan");
	}
	
	public static SegmentValidation genValidationTotalDanaInvestasiPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2310080119.key, 
				UtilMetadata.genPlusRow(getObjects(), 12, 15), "Total Dana Investasi Perusahaan|Penjumlahan Dana Investasi Perusahaan");
	}
	
	public static SegmentValidation genValidationRasioAsetDanaInvestasiPerusahaan() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 10), R_2310080120.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 16 }), "Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar - Dana Investasi Perusahaan|Perhitungan Rasio Aset (Liabilitas) Lancar Terhadap Aset (Liabilitas) Tidak Lancar Dana Investasi Perusahaan");
	}
}
