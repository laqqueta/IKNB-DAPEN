package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3016PosLbAsrus110 implements IObject<KeyValueString> {
	R_1400100100 ("1400100100", "Tingkat Solvabilitas"),
	R_1400100101 ("1400100101", "A. Aset yang diperkenankan (AYD)"),
	R_1400100102 ("1400100102", "B. Liabilitas, selain Qardh dari Dana Perusahaan"),
	R_1400100103 ("1400100103", "DTMBR/MMBR"),
	R_1400100104 ("1400100104", "A. Risiko Kredit"),
	R_1400100105 ("1400100105", "B. Risiko Likuiditas"),
	R_1400100106 ("1400100106", "C. Risiko Pasar"),
	R_1400100107 ("1400100107", "D. Risiko Asuransi"),
	R_1400100108 ("1400100108", "E. Risiko Operasional"),
	R_1400100109 ("1400100109", "F. MMBR atas PAYDI Digaransi"),
	R_1400100110 ("1400100110", "1. Risiko PAYDI Digaransi"),
	R_1400100111 ("1400100111", "a. Risiko Kredit"),
	R_1400100112 ("1400100112", "b. Risiko Likuiditas"),
	R_1400100113 ("1400100113", "c. Risiko Pasar"),
	R_1400100114 ("1400100114", "2. Aset PAYDI Digaransi"),
	R_1400100115 ("1400100115", "3. Liabilitas PAYDI Digaransi"),
	R_1400100116 ("1400100116", "Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)"),
	R_1400100117 ("1400100117", "Rasio Target Tingkat Solvabilitas Internal (tahunan) (persentase sesuai POJK 72)"),
	R_1400100118 ("1400100118", "Rasio Tingkat Solvabilitas dengan DTMBR/MMBR yang Dipersyaratkan Peraturan (persentasi sesuai POJK 72)"),
	R_1400100119 ("1400100119", "Aset yang Tersedia Untuk Qardh yang Diperhitungkan sebagai Penambah AYD Dana Tabarru"),
	R_1400100120 ("1400100120", "A. kekurangan (kelebihan) tingkat solvabilitas dari target internal"),
	R_1400100121 ("1400100121", "B. Ketidakcukupan investasi, kas dan bank"),
	R_1400100122 ("1400100122", "Rasio Tingkat Solvabilitas Dana Tabarru' dan Dana Tanahud"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3016PosLbAsrus110 eEnum : ER3016PosLbAsrus110.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 9, 15));
	}
	
	public static FieldValidation genValidation3() {
		return UtilFieldValidation.genEqualsPosFormula("2", UtilMetadata.genPipeRow(getObjects(), 20, 21));
	}

	public static SegmentValidation genValidationNumericNegativeA() {
		return UtilSegmentValidation.genRegexNumericNegative("2", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 22 }));
	}

	public static SegmentValidation genValidationNumericNegativeB() {
		return UtilSegmentValidation.genRegexNumericNegative("3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 16, 17, 18, 22 }));
	}

	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 16, 17, 18, 22 }));
	}

	public static SegmentValidation genValidationMaxLength8() {
		return UtilSegmentValidation.genMaxLength("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 16, 17, 18, 22 }), 8);
	}
	
	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1400100100.key, 
				UtilMetadata.genMinusRow(getObjects(), 1, 2), "Total Tingkat Solvabilitas|Perhitungan Tingkat Solvabilitas");
	}
	
	public static SegmentValidation genValidationDTMBRAtauMMBR() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1400100103.key, 
				UtilMetadata.genPlusRow(getObjects(), 4, 9), "Total DTMBR/MMBR|Penjumlahan DTMBR/MMBR");
	}
	
	public static SegmentValidation genValidationMmbrAtasPaydiDigaransi() {
		return UtilSegmentValidation.genMaxValue2("3", R_1400100109.key, 
				R_1400100110.key + "+" + R_1400100115.key + "-" + R_1400100114.key, "1.20", "0",
				"MAX(0,1.2*( Risiko PAYDI Digaransi + Liabilitas PAYDI Digaransi - Aset PAYDI Digaransi))");
	}
	
	public static SegmentValidation genValidationRisikoPaydiDigaransi() {
		return UtilSegmentValidation.genEqualsFormula("3", R_1400100110.key, 
				UtilMetadata.genPlusRow(getObjects(), 11, 13), "Total Risiko PAYDI Digaransi|Penjumlahan Risiko PAYDI Digaransi");
	}
	
	public static SegmentValidation genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_1400100116.key, UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 3 }), 
				"Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh|Perhitungan Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh");
	}
	
	public static SegmentValidation genValidationAsetYangTersediaUntukQardhYangDiperhitungkanSebagaiPenambahAydDanaTabarruDanTanahud() {
		return UtilSegmentValidation.genMaxValue("2|3", R_1400100119.key, UtilMetadata.genPipeRow(getObjects(), 20, 21), "0",
				"MAX(0,MAX(A. Kekurangan (kelebihan) tingkat solvabilitas dari target internal, B. Ketidakcukupan investasi, kas dan bank))");
	}
	
	public static SegmentValidation genValidationKekuranganKelebihanTingkatSolvabilitasDariTargetInternal() {
		return UtilSegmentValidation.genMaxValue2("2", R_1400100120.key, 
				R_1400100117.key + "-" + R_1400100116.key + "*" + R_1400100103.key, ".01", "0",
				"MAX(0,( Rasio Target Tingkat Solvabilitas Internal (tahunan) - Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh) x DTMBR/MMBR)");
	}
	
	public static SegmentValidation genValidationRasioTingkatSolvabilitasDanaTabarruDanDanaTanahudA() {
		return UtilSegmentValidation.genEqualsRatio("2", R_1400100122.key, 
				R_1400100100.key + "+" + R_1400100119.key + "|" + R_1400100103.key, 
				"Rasio Tingkat Solvabilitas Dana Tabarru' dan Dana Tanahud|Perhitungan Rasio Tingkat Solvabilitas Dana Tabarru' dan Dana Tanahud");
	}
	
	public static SegmentValidation genValidationRasioTingkatSolvabilitasDanaTabarruDanDanaTanahudB() {
		return UtilSegmentValidation.genEqualsRatio("3", R_1400100122.key, 
				R_1400100100.key + "-" + R_1400100119.key + "|" + R_1400100103.key, 
				"Rasio Tingkat Solvabilitas Dana Tabarru' dan Dana Tanahud|Perhitungan Rasio Tingkat Solvabilitas Dana Tabarru' dan Dana Tanahud");
	}
}
