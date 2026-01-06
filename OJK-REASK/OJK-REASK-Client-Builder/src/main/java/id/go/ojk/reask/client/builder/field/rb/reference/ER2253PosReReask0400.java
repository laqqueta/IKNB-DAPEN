package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum ER2253PosReReask0400 implements IObject<KeyValueString> {
	R_7100000000 ("7100000000", "Aset Yang Diperkenankan"),
	R_7200000000 ("7200000000", "Liabilitas (kecuali Pinjaman Subordinasi) "),
	R_7000000099 ("7000000099", "Jumlah Tingkat Solvabilitas (a) "),
//	R_7300000000 ("7300000000", "Modal Minimum Berbasis Risiko (MMBR) "),
	R_7300000099 ("7300000099", "Jumlah MMBR (b) "),
	R_7400000000 ("7400000000", "Kelebihan (Kekurangan) Batas Tingkat Solvabilitas"),
	R_7000000098 ("7000000098", "Rasio Pencapaian Solvabilitas (a:b)"),
//	R_7000000097 ("7000000097", "B. RASIO TINGKAT KESEHATAN KEUANGAN SELAIN MMBR "),
//	R_7001000099 ("7001000099", "i. Rasio Likuiditas "),
	R_7001010000 ("7001010000", "a. Aset Lancar"),
	R_7001020000 ("7001020000", "b. Liabilitas Lancar"),
	R_7001000000 ("7001000000", "c. Rasio (a : b)"),
//	R_7002000099 ("7002000099", "ii.Rasio Kecukupan Investasi"),
	R_7002010000 ("7002010000", "a. Investasi + Kas & Bank (Lihat Neraca SAP)"),
	R_7002020000 ("7002020000", "b. Cadangan Teknis Retensi Sendiri"),
	R_7002030000 ("7002030000", "c. Utang Klaim Retensi Sendiri + Utang Lain Kepada Tertanggung"),
	R_7002000000 ("7002000000", "d. Rasio (a : (b + c))"),
//	R_7003000099 ("7003000099", "iii.Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto"),
	R_7003010000 ("7003010000", "a. Hasil Investasi"),
	R_7003020000 ("7003020000", "b. Pendapatan Premi Neto"),
	R_7003000000 ("7003000000", "c. Rasio (a : b)"),
//	R_7004000099 ("7004000099", "iv.Rasio Beban Klaim, Beban Usaha, dan Komisi"),
	R_7004010000 ("7004010000", "a. Beban Klaim Neto"),
	R_7004020000 ("7004020000", "b. Beban Usaha"),
	R_7004030000 ("7004030000", "c. Komisi Neto"),
	R_7004040000 ("7004040000", "d. Pendapatan Premi Neto"),
	R_7004050000 ("7004050000", "e. Rasio a : d (rasio I)"),
	R_7004060000 ("7004060000", "f. Rasio b : d (rasio II)"),
	R_7004070000 ("7004070000", "g. Rasio c : d (rasio III)"),
	R_7004000000 ("7004000000", "h. Rasio I + Rasio II + Rasio III"),
//	R_7005000099 ("7005000099", "v. Return of Investment (ROI)"),
	R_7005010000 ("7005010000", "a. Hasil Investasi Setelah Pajak"),
	R_7005020000 ("7005020000", "b. Rata-rata Investasi"),
	R_7005000000 ("7005000000", "c. Rasio a:b"),
//	R_7006000099 ("7006000099", "vi. Return on Equity (ROE)"),
	R_7006010000 ("7006010000", "a. Laba (Rugi) Setelah Pajak"),
	R_7006020000 ("7006020000", "b. Ekuitas"),
	R_7006000000 ("7006000000", "c. Rasio a:b"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2253PosReReask0400 eEnum : ER2253PosReReask0400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2253PosReReask0400.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2253PosReReask0400.class.getSimpleName().substring(2, 6));
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
				UtilMetadata.genPipeRow(getObjects(), 
						new int[] { 0, 1, 2, 3, 4, 6, 7, 9, 10, 11, 13, 14, 16, 17, 18, 19, 24, 25, 27, 28 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4", 
				UtilMetadata.genPipeRow(getObjects(), 
						new int[] { 5, 8, 12, 15, 20, 21, 22, 23, 26, 29 }));
	}

	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_7000000099.key, 
				R_7100000000.key + "-" + R_7200000000.key, 
				"Total Tingkat Solvabilitas|Penjumlahan Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationKelebihanTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_7400000000.key, 
				R_7000000099.key + "-" + R_7300000099.key, 
				"Total Kelebihan (Kekurangan) Batas Tingkat Solvabilitas|Penjumlahan Kelebihan (Kekurangan) Batas Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationRasioPencapaianSolvabilitas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7000000098.key, 
				R_7000000099.key + "|" + R_7300000099.key, 
				"Total Rasio Pencapaian Solvabilitas|Perhitungan Rasio Pencapaian Solvabilitas");
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7001000000.key, 
				R_7001010000.key + "|" + R_7001020000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioInvestasi() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7002000000.key, 
				R_7002010000.key + "|" + R_7002020000.key + "+" + R_7002030000.key, 
				"Total Rasio Kecukupan Investasi|Perhitungan Rasio Kecukupan Investasi");
	}

	public static SegmentValidation genValidationPerimbangan() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7003000000.key, 
				R_7003010000.key + "|" + R_7003020000.key, 
				"Total Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto|Perhitungan Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto");
	}

	public static SegmentValidation genValidationRasioAD() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7004050000.key, 
				R_7004010000.key + "|" + R_7004040000.key, 
				"Total Rasio I|Perhitungan Rasio I");
	}

	public static SegmentValidation genValidationRasioBD() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7004060000.key, 
				R_7004020000.key + "|" + R_7004040000.key, 
				"Total Rasio II|Perhitungan Rasio II");
	}

	public static SegmentValidation genValidationRasioCD() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7004070000.key, 
				R_7004030000.key + "|" + R_7004040000.key, 
				"Total Rasio III|Perhitungan Rasio III");
	}

	public static SegmentValidation genValidationJumlatRasioABCD() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_7004000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 20, 22), 
				"Total Rasio I + II + III|Perhitungan Rasio I + II + III");
	}

	public static SegmentValidation genValidationRasioRoi() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7005000000.key, 
				R_7005010000.key + "|" + R_7005020000.key, 
				"Total Rasio ROI|Perhitungan Rasio ROI");
	}

	public static SegmentValidation genValidationRasioRoe() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_7006000000.key, 
				R_7006010000.key + "|" + R_7006020000.key, 
				"Total Rasio ROE|Perhitungan Rasio ROE");
	}
}
