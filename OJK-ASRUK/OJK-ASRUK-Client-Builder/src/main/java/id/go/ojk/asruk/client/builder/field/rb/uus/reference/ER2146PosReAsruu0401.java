package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2146PosReAsruu0401 implements IObject<KeyValueString> {
//	R_04010100000000 ("04010100000000", "I. Rasio Solvabilitas "),
	R_04010101000000 ("04010101000000", "A. Tingkat Solvabilitas"),
	R_04010101010000 ("04010101010000", "1. Aset yang diperkenankan (AYD)"),
	R_04010101020000 ("04010101020000", "2. Liabilitas "),
	R_04010102000000 ("04010102000000", "B. Modal Minimum Berbasis Risiko "),
	R_04010103000000 ("04010103000000", "C. Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)"),
	R_04010104000000 ("04010104000000", "D. Rasio Target Tingkat Solvabilitas Internal (tahunan) (persentase sesuai POJK 72)"),
	R_04010105000000 ("04010105000000", "E. Rasio Tingkat Solvabilitas dengan MMBR yang Dipersyaratkan Peraturan (persentase sesuai POJK 72)"),
	R_04010106000000 ("04010106000000", "F. Aset yang Tersedia Untuk Qardh yang Diperhitungkan sebagai Penambah AYD Dana Tabarru' dan Tanahud"),
	R_04010106010000 ("04010106010000", "1. Kekurangan (kelebihan) tingkat solvabilitas dari target internal"),
	R_04010106020000 ("04010106020000", "2. Ketidakcukupan investasi, kas dan bank"),
	R_04010107000000 ("04010107000000", "G. Rasio Tingkat Solvabilitas Dana Perusahaan "),
//	R_04010200000000 ("04010200000000", "II. Rasio Selain Rasio Tingkat Solvabilitas"),
//	R_04010201000000 ("04010201000000", "A. Rasio Likuiditas"),
	R_04010201010000 ("04010201010000", "1. Kekayaan lancar"),
	R_04010201020000 ("04010201020000", "2. Kewajiban lancar"),
	R_04010201030000 ("04010201030000", "3. Rasio (a:b)"),
//	R_04010202000000 ("04010202000000", "B. Rasio Pendapatan investasi neto"),
	R_04010202010000 ("04010202010000", "1. Pendapatan investasi netto"),
	R_04010202020000 ("04010202020000", "2. Rata-rata investasi"),
	R_04010202030000 ("04010202030000", "3. Rasio (a:b)"),
//	R_04010203000000 ("04010203000000", "C. Rasio perubahan dana"),
	R_04010203010000 ("04010203010000", "1. Dana Perusahaan Periode berjalan"),
	R_04010203020000 ("04010203020000", "2. Dana Perusahaan Periode lalu"),
	R_04010203030000 ("04010203030000", "3. Perubahan dana Perusahaan (a-b)"),
	R_04010203040000 ("04010203040000", "4. Rasio (c:b)"),
//	R_04010204000000 ("04010204000000", "D. Rasio Aset Unit Syariah"),
	R_04010204010000 ("04010204010000", "1. Aset Dana Tabarru dan Dana Tanahud"),
	R_04010204020000 ("04010204020000", "2. Aset Dana Investasi Peserta"),
	R_04010204030000 ("04010204030000", "3. Aset Dana Asuransi Perusahaan (Konvensional)"),
	R_04010204040000 ("04010204040000", "4. Rasio (a+b) : (a+b+c)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2146PosReAsruu0401 eEnum : ER2146PosReAsruu0401.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2146PosReAsruu0401.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2146PosReAsruu0401.class.getSimpleName().substring(2, 6));
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
						new int[] { 0, 1, 2, 3, 7, 8, 9, 11, 12, 14, 15, 17, 18, 19, 21, 22, 23 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6, 10, 13, 16, 20, 24 }));
	}

	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010101000000.key,
				R_04010101010000.key + "-" + R_04010101020000.key, 
				"Total Tingkat Solvabilitas|Perhitungan Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04010103000000.key,
				R_04010101000000.key + "|" + R_04010102000000.key, 
				"Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)|Tingkat Solvabilitas : Modal Minimum Berbasis Risiko");
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04010201030000.key,
				R_04010201010000.key + "|" + R_04010201020000.key, 
				"Rasio Likuiditas (a:b)|Kekayaan lancar : Kewajiban lancar");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04010202030000.key,
				R_04010202010000.key + "|" + R_04010202020000.key, 
				"Rasio Pendapatan Investasi Neto (a:b)|Pendapatan investasi netto : Rata-rata investasi");
	}

	public static SegmentValidation genValidationPerubahanDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010203030000.key,
				R_04010203010000.key + "-" + R_04010203020000.key, 
				"Total Perubahan Dana Perusahaan|Perhitungan Perubahan Dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04010203040000.key,
				R_04010203030000.key + "|" + R_04010203020000.key, 
				"Rasio Perubahan Dana (c:b)|Perubahan dana Perusahaan (a-b) : Dana Perusahaan Periode lalu");
	}

	public static SegmentValidation genValidationRasioAsetUnitSyariah() {
		return UtilSegmentValidation.genEqualsRatio("2|3", R_04010204040000.key,
				R_04010204010000.key + "+" + R_04010204020000.key + "|" + 
						R_04010204010000.key + "+" + R_04010204020000.key + "+" + R_04010204030000.key, 
				"Total Rasio Aset Unit Syariah|Perhitungan Rasio Aset Unit Syariah");
	}
}
