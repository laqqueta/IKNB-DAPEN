package id.go.ojk.asrus.client.builder.field.rb.reference;

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
public enum ER2034PosRbAsrus1301 implements IObject<KeyValueString> {
//	R_13010100000000 ("13010100000000", "A.   Rasio Solvabilitas "),
	R_13010101000000 ("13010101000000", "1.    Tingkat Solvabilitas"),
	R_13010101010000 ("13010101010000", "a.    Aset yang diperkenankan (AYD)"),
	R_13010101020000 ("13010101020000", "b.    Liabilitas "),
	R_13010102000000 ("13010102000000", "2.    Modal Minimum Berbasis Risiko "),
	R_13010103000000 ("13010103000000", "3.    Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh (dalam %)"),
	R_13010104000000 ("13010104000000", "4.    Rasio Target Tingkat Solvabilitas Internal (tahunan) (persentase sesuai POJK 72)"),
	R_13010105000000 ("13010105000000", "5.    Rasio Tingkat Solvabilitas dengan MMBR yang Dipersyaratkan Peraturan (persentase sesuai POJK 72)"),
	R_13010106000000 ("13010106000000", "6.    Aset yang Tersedia Untuk Qardh yang Diperhitungkan sebagai Penambah AYD Dana Tabarru' dan Tanahud"),
	R_13010106010000 ("13010106010000", "a.    Kekurangan (kelebihan) tingkat solvabilitas dari target internal "),
	R_13010106020000 ("13010106020000", "b.    Ketidakcukupan investasi, kas dan bank"),
	R_13010107000000 ("13010107000000", "7.    Rasio Tingkat Solvabilitas Dana Perusahaan "),
//	R_13010200000000 ("13010200000000", "B. Rasio Selain Rasio Tingkat Solvabilitas"),
//	R_13010201000000 ("13010201000000", "1.    Rasio Likuiditas"),
	R_13010201010000 ("13010201010000", "a.    Kekayaan lancar"),
	R_13010201020000 ("13010201020000", "b.    Kewajiban lancar"),
	R_13010201030000 ("13010201030000", "c.    Rasio (a:b)"),
//	R_13010202000000 ("13010202000000", "2.    Rasio Pendapatan investasi neto"),
	R_13010202010000 ("13010202010000", "a.    Pendapatan investasi netto"),
	R_13010202020000 ("13010202020000", "b.    Rata-rata investasi"),
	R_13010202030000 ("13010202030000", "c.    Rasio (a:b)"),
//	R_13010203000000 ("13010203000000", "3.    Rasio perubahan dana"),
	R_13010203010000 ("13010203010000", "a.    Dana Perusahaan Periode berjalan"),
	R_13010203020000 ("13010203020000", "b.    Dana Perusahaan Periode lalu"),
	R_13010203030000 ("13010203030000", "c.    Perubahan dana Perusahaan (a-b)"),
	R_13010203040000 ("13010203040000", "d.    Rasio (c:b)"),
//	R_13010204000000 ("13010204000000", "4.    Rasio Aset Unit Syariah"),
	R_13010204010000 ("13010204010000", "a.    Aset Dana Tabarru dan Dana Tanahud"),
	R_13010204020000 ("13010204020000", "b.    Aset Dana Investasi Peserta"),
	R_13010204030000 ("13010204030000", "c.    Aset Dana Asuransi Perusahaan (Konvensional)"),
	R_13010204040000 ("13010204040000", "d.    Rasio (a+b) : (a+b+c)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2034PosRbAsrus1301 eEnum : ER2034PosRbAsrus1301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2034PosRbAsrus1301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2034PosRbAsrus1301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 7, 8, 9, 11, 12, 14, 15, 17, 18, 19, 21, 22, 23 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 5, 6, 10, 13, 16, 20, 24 }));
	}

	public static SegmentValidation genValidationTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13010101000000.key,
				R_13010101010000.key + "-" + R_13010101020000.key, 
				"Total Tingkat Solvabilitas|Perhitungan Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13010103000000.key,
				R_13010101000000.key + "|" + R_13010102000000.key, 
				"Total Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh|Perhitungan Rasio Tingkat Solvabilitas sebelum memperhitungkan Aset yang Tersedia untuk Qardh");
	}

	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13010201030000.key,
				R_13010201010000.key + "|" + R_13010201020000.key, 
				"Total Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}

	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13010202030000.key,
				R_13010202010000.key + "|" + R_13010202020000.key, 
				"Total Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}

	public static SegmentValidation genValidationPerubahanDanaPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_13010203030000.key,
				R_13010203010000.key + "-" + R_13010203020000.key, 
				"Total Perubahan dana Perusahaan|Perhitungan Perubahan dana Perusahaan");
	}

	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13010203040000.key,
				R_13010203030000.key + "|" + R_13010203020000.key, 
				"Total Rasio perubahan dana|Perhitungan Rasio perubahan dana");
	}

	public static SegmentValidation genValidationRasioAsetUnitSyariah() {
		return UtilSegmentValidation.genEqualsRatio("2|3|4|5", R_13010204040000.key,
				R_13010204010000.key + "+" + R_13010204020000.key + "|" + 
						R_13010204010000.key + "+" + R_13010204020000.key + "+" + R_13010204030000.key, 
				"Total Rasio Aset Unit Syariah|Perhitungan Rasio Aset Unit Syariah");
	}
}
