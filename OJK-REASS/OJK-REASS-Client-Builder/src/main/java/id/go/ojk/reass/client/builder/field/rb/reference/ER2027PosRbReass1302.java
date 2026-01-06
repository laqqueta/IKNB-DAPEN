package id.go.ojk.reass.client.builder.field.rb.reference;

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
public enum ER2027PosRbReass1302 implements IObject<KeyValueString> {
//	R_13020100000000 ("13020100000000", "A.   Rasio Solvabilitas "),
	R_13020101000000 ("13020101000000", "1.    Tingkat Solvabilitas"),
	R_13020101010000 ("13020101010000", "a.    Aset yang diperkenankan (AYD)"),
	R_13020101020000 ("13020101020000", "b.    Liabilitas selain Qardh dari Dana Perusahaan"),
	R_13020102000000 ("13020102000000", "2.    Dana Tabaru Minimum Berbasis Risiko "),
	R_13020103000000 ("13020103000000", "3.    Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)"),
	R_13020104000000 ("13020104000000", "4.    Rasio Target Tingkat Solvabilitas Internal (tahunan) (persentase sesuai POJK 72)"),
	R_13020105000000 ("13020105000000", "5.    Rasio Tingkat Solvabilitas dengan MMBR yang Dipersyaratkan Peraturan (persentase sesuai POJK 72)"),
	R_13020106000000 ("13020106000000", "6.    Aset yang Tersedia Untuk Qardh yang Diperhitungkan sebagai Penambah AYD Dana Tabarru' dan Tanahud"),
	R_13020106010000 ("13020106010000", "a.    Kekurangan (kelebihan) tingkat solvabilitas dari target internal "),
	R_13020106020000 ("13020106020000", "b.    Ketidakcukupan investasi, kas dan bank"),
	R_13020107000000 ("13020107000000", "7.    Rasio Tingkat Solvabilitas Dana Perusahaan "),
//	R_13020200000000 ("13020200000000", "B. Rasio Selain Rasio Tingkat Solvabilitas"),
//	R_13020201000000 ("13020201000000", "1.    Rasio Likuiditas"),
	R_13020201010000 ("13020201010000", "a.    Kekayaan lancar"),
	R_13020201020000 ("13020201020000", "b.    Kewajiban lancar"),
	R_13020201030000 ("13020201030000", "c.    Rasio (a:b)"),
//	R_13020202000000 ("13020202000000", "2.    Rasio perimbangan investasi dengan liabilitas"),
	R_13020202010000 ("13020202010000", "a.    Investasi, kas dan bank"),
	R_13020202020000 ("13020202020000", "b.    Penyisihan teknis"),
	R_13020202030000 ("13020202030000", "c.    Utang klaim retensi sendiri"),
	R_13020202040000 ("13020202040000", "d.    Rasio [a:(b+c)]"),
//	R_13020203000000 ("13020203000000", "3.    Rasio Pendapatan investasi neto"),
	R_13020203010000 ("13020203010000", "a.    Pendapatan investasi netto"),
	R_13020203020000 ("13020203020000", "b.    Rata-rata investasi"),
	R_13020203030000 ("13020203030000", "c.    Rasio (a:b)"),
//	R_13020204000000 ("13020204000000", "4.    Rasio beban klaim"),
	R_13020204010000 ("13020204010000", "a.    Beban klaim netto"),
	R_13020204020000 ("13020204020000", "b.    Kontribusi netto"),
	R_13020204030000 ("13020204030000", "c.    Rasio (a:b)"),
//	R_13020205000000 ("13020205000000", "5.    Rasio perubahan dana"),
	R_13020205010000 ("13020205010000", "a.    Dana Tabarru dan Tanahud Periode berjalan"),
	R_13020205020000 ("13020205020000", "b.    Dana Tabarru dan Tanahud Periode lalu"),
	R_13020205030000 ("13020205030000", "c.    Perubahan dana (a-b)"),
	R_13020205040000 ("13020205040000", "d.    Rasio (c:b)"),
//	R_13020206000000 ("13020206000000", "6.    Penghitungan Qardh yang Diperlukan Dana Tabarru"),
	R_13020206010000 ("13020206010000", "a.    Jumlah Kewajiban selain Qardh"),
	R_13020206020000 ("13020206020000", "b.    Jumlah Aset"),
	R_13020206030000 ("13020206030000", "c.    Jumlah Qardh yang Diperlukan (a-b)"),
//	R_13020207000000 ("13020207000000", "7.    Penghitungan Qardh yang Diperlukan Dana Tanahud"),
	R_13020207010000 ("13020207010000", "a.    Jumlah Kewajiban selain Qardh"),
	R_13020207020000 ("13020207020000", "b.    Jumlah Aset"),
	R_13020207030000 ("13020207030000", "c.    Jumlah Qardh yang Diperlukan (a-b)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2027PosRbReass1302 eEnum : ER2027PosRbReass1302.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2027PosRbReass1302.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2027PosRbReass1302.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), 
						new int[] { 0, 1, 2, 3, 7, 8, 9, 11, 12, 14, 15, 16, 18, 19, 21, 22, 24, 25, 26, 28, 29, 30, 31, 32, 33 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6, 10, 13, 17, 20, 23, 27 }));
	}

	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13020101000000.key,
				R_13020101010000.key + "-" + R_13020101020000.key, 
				"Total Tingkat Solvabilitas|Perhitungan Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020103000000.key,
				R_13020101000000.key + "|" + R_13020102000000.key, 
				"Total Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh|Perhitungan Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh");
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020201030000.key,
				R_13020201010000.key + "|" + R_13020201020000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioPerimbanganInvestasiDenganLiabilitas() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020202040000.key,
				R_13020202010000.key + "|" + R_13020202020000.key + "+" + R_13020202030000.key, 
				"Total Rasio perimbangan investasi dengan liabilitas|Perhitungan Rasio perimbangan investasi dengan liabilitas");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020203030000.key,
				R_13020203010000.key + "|" + R_13020203020000.key, 
				"Total Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}

	public static SegmentValidation genValidationRasioBebanKlaim() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020204030000.key,
				R_13020204010000.key + "|" + R_13020204020000.key, 
				"Total Rasio beban klaim|Perhitungan Rasio beban klaim");
	}

	public static SegmentValidation genValidationPerubahanDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13020205030000.key,
				R_13020205010000.key + "-" + R_13020205020000.key, 
				"Total Perubahan dana Perusahaan|Perhitungan Perubahan dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13020205040000.key,
				R_13020205030000.key + "|" + R_13020205020000.key, 
				"Total Rasio perubahan dana|Perhitungan Rasio perubahan dana");
	}

	public static SegmentValidation genValidationQardhYangDiperlukanDanaTabarru() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13020206030000.key,
				R_13020206010000.key + "-" + R_13020206020000.key, 
				"Total Qardh Yang Diperlukan Dana Tabarru|Perhitungan Qardh Yang Diperlukan Dana Tabarru");
	}

	public static SegmentValidation genValidationQardhYangDiperlukanDanaTanahud() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13020207030000.key,
				R_13020207010000.key + "-" + R_13020207020000.key, 
				"Total Qardh Yang Diperlukan Dana Tanahud|Perhitungan Qardh Yang Diperlukan Dana Tanahud");
	}
}
