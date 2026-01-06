package id.go.ojk.reass.client.builder.field.rb.reference;

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
public enum ER2035PosReReass0402 implements IObject<KeyValueString> {
//	R_04020100000000 ("04020100000000", "I.        Rasio Solvabilitas "),
	R_04020101000000 ("04020101000000", "A.   Tingkat Solvabilitas"),
	R_04020101010000 ("04020101010000", "1.    Aset yang diperkenankan (AYD)"),
	R_04020101020000 ("04020101020000", "2.    Liabilitas selain Qardh dari Dana Perusahaan"),
	R_04020102000000 ("04020102000000", "B.   Dana Tabaru Minimum Berbasis Risiko "),
	R_04020103000000 ("04020103000000", "C.   Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)"),
	R_04020104000000 ("04020104000000", "D.   Rasio Target Tingkat Solvabilitas Internal (tahunan) (persentase sesuai POJK 72)"),
	R_04020105000000 ("04020105000000", "E.   Rasio Tingkat Solvabilitas dengan MMBR yang Dipersyaratkan Peraturan (persentase sesuai POJK 72)"),
	R_04020106000000 ("04020106000000", "F.    Aset yang Tersedia Untuk Qardh yang Diperhitungkan sebagai Penambah AYD Dana Tabarru' dan Tanahud"),
	R_04020106010000 ("04020106010000", "1.    Kekurangan (kelebihan) tingkat solvabilitas dari target internal "),
	R_04020106020000 ("04020106020000", "2.    Ketidakcukupan investasi, kas dan bank"),
	R_04020107000000 ("04020107000000", "G.   Rasio Tingkat Solvabilitas Dana Perusahaan "),
//	R_04020200000000 ("04020200000000", "II.        Rasio Selain Rasio Tingkat Solvabilitas"),
//	R_04020201000000 ("04020201000000", "A.   Rasio Likuiditas"),
	R_04020201010000 ("04020201010000", "1.    Kekayaan lancar"),
	R_04020201020000 ("04020201020000", "2.    Kewajiban lancar"),
	R_04020201030000 ("04020201030000", "3.    Rasio (a:b)"),
//	R_04020202000000 ("04020202000000", "B.   Rasio perimbangan investasi dengan liabilitas"),
	R_04020202010000 ("04020202010000", "1.    Investasi, kas dan bank"),
	R_04020202020000 ("04020202020000", "2.    Penyisihan teknis"),
	R_04020202030000 ("04020202030000", "3.    Utang klaim retensi sendiri"),
	R_04020202040000 ("04020202040000", "4.    Rasio [a:(b+c)]"),
//	R_04020203000000 ("04020203000000", "C.   Rasio Pendapatan investasi neto"),
	R_04020203010000 ("04020203010000", "1.    Pendapatan investasi netto"),
	R_04020203020000 ("04020203020000", "2.    Rata-rata investasi"),
	R_04020203030000 ("04020203030000", "3.    Rasio (a:b)"),
//	R_04020204000000 ("04020204000000", "D.   Rasio beban klaim"),
	R_04020204010000 ("04020204010000", "1.    Beban klaim netto"),
	R_04020204020000 ("04020204020000", "2.    Kontribusi netto"),
	R_04020204030000 ("04020204030000", "3.    Rasio (a:b)"),
//	R_04020205000000 ("04020205000000", "E.   Rasio perubahan dana"),
	R_04020205010000 ("04020205010000", "1.    Dana Tabarru dan Tanahud Periode berjalan"),
	R_04020205020000 ("04020205020000", "2.    Dana Tabarru dan Tanahud Periode lalu"),
	R_04020205030000 ("04020205030000", "3.    Perubahan dana (a-b)"),
	R_04020205040000 ("04020205040000", "4.    Rasio (c:b)"),
//	R_04020206000000 ("04020206000000", "F.    Penghitungan Qardh yang Diperlukan Dana Tabarru"),
	R_04020206010000 ("04020206010000", "1.    Jumlah Kewajiban selain Qardh"),
	R_04020206020000 ("04020206020000", "2.    Jumlah Aset"),
	R_04020206030000 ("04020206030000", "3.    Jumlah Qardh yang Diperlukan (a-b)"),
//	R_04020207000000 ("04020207000000", "G.   Penghitungan Qardh yang Diperlukan Dana Tanahud"),
	R_04020207010000 ("04020207010000", "1.    Jumlah Kewajiban selain Qardh"),
	R_04020207020000 ("04020207020000", "2.    Jumlah Aset"),
	R_04020207030000 ("04020207030000", "3.    Jumlah Qardh yang Diperlukan (a-b)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2035PosReReass0402 eEnum : ER2035PosReReass0402.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2035PosReReass0402.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2035PosReReass0402.class.getSimpleName().substring(2, 6));
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
						new int[] { 0, 1, 2, 3, 7, 8, 9, 11, 12, 14, 15, 16, 18, 19, 21, 22, 24, 25, 26, 28, 29, 30, 31, 32, 33 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6, 10, 13, 17, 20, 23, 27 }));
	}

	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04020101000000.key,
				R_04020101010000.key + "-" + R_04020101020000.key, 
				"Total Tingkat Solvabilitas|Perhitungan Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020103000000.key,
				R_04020101000000.key + "|" + R_04020102000000.key, 
				"Total Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh|Perhitungan Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh");
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020201030000.key,
				R_04020201010000.key + "|" + R_04020201020000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioPerimbanganInvestasiDenganLiabilitas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020202040000.key,
				R_04020202010000.key + "|" + R_04020202020000.key + "+" + R_04020202030000.key, 
				"Total Rasio perimbangan investasi dengan liabilitas|Perhitungan Rasio perimbangan investasi dengan liabilitas");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020203030000.key,
				R_04020203010000.key + "|" + R_04020203020000.key, 
				"Total Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}

	public static SegmentValidation genValidationRasioBebanKlaim() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020204030000.key,
				R_04020204010000.key + "|" + R_04020204020000.key, 
				"Total Rasio beban klaim|Perhitungan Rasio beban klaim");
	}

	public static SegmentValidation genValidationPerubahanDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04020205030000.key,
				R_04020205010000.key + "-" + R_04020205020000.key, 
				"Total Perubahan Dana Perusahaan|Perhitungan Perubahan Dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04020205040000.key,
				R_04020205030000.key + "|" + R_04020205020000.key, 
				"Total Rasio perubahan dana|Perhitungan Rasio perubahan dana");
	}

	public static SegmentValidation genValidationQardhYangDiperlukanDanaTabarru() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04020206030000.key,
				R_04020206010000.key + "-" + R_04020206020000.key, 
				"Total Qardh yang Diperlukan Dana Tabarru|Perhitungan Qardh yang Diperlukan Dana Tabarru");
	}

	public static SegmentValidation genValidationQardhYangDiperlukanDanaTanahud() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04020207030000.key,
				R_04020207010000.key + "-" + R_04020207020000.key, 
				"Total Qardh yang Diperlukan Dana Tanahud|Perhitungan Qardh yang Diperlukan Dana Tanahud");
	}
}
