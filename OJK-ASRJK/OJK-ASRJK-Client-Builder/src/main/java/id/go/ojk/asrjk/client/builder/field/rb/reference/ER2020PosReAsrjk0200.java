package id.go.ojk.asrjk.client.builder.field.rb.reference;

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
public enum ER2020PosReAsrjk0200 implements IObject<KeyValueString> {
//	R_4000000099 ("4000000099", "PENDAPATAN"),
	R_4401000000 ("4401000000", "a. Pendapatan Premi"),
	R_4402000000 ("4402000000", "b. Premi Reasuransi"),
	R_4403000000 ("4403000000", "c. Penurunan (Kenaikan) CAPYBMP"),
	R_4400000000 ("4400000000", "Jumlah Pendapatan Premi Neto"),
	R_4500000000 ("4500000000", "a. Hasil Investasi"),
	R_4600000000 ("4600000000", "b. Imbalan Jasa DPLK/Jasa manajemen lainnya"),
	R_4900000000 ("4900000000", "c. Pendapatan Lain"),
	R_4000000000 ("4000000000", "JUMLAH PENDAPATAN"),
//	R_5000000099 ("5000000099", "BEBAN"),
//	R_5400000099 ("5400000099", "Beban Asuransi"),
//	R_5401000099 ("5401000099", "a. Klaim dan Manfaat"),
	R_5401010000 ("5401010000", "(1) Klaim dan Manfaat Dibayar"),
	R_5401020000 ("5401020000", "(2) Klaim Penebusan Unit"),
	R_5401030000 ("5401030000", "(3) Klaim Reasuransi"),
	R_5401040000 ("5401040000", "(4)Kenaikan (Penurunan) Cadangan Premi"),
	R_5401050000 ("5401050000", "(5)Kenaikan (Penurunan) Cadangan Klaim"),
	R_5401060000 ("5401060000", "(6) Kenaikan (Penurunan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_5401000000 ("5401000000", "Jumlah Beban Klaim dan Manfaat"),
//	R_5402000099 ("5402000099", "b. Biaya Akuisisi"),
	R_5402010000 ("5402010000", "(1) Beban Komisi - Tahun Pertama"),
	R_5402020000 ("5402020000", "(2) Beban Komisi – Tahun Lanjutan"),
	R_5402030000 ("5402030000", "(3) Beban Komisi - Overriding"),
	R_5402990000 ("5402990000", "(4) Beban Lainnya"),
	R_5402000000 ("5402000000", "Jumlah Biaya Akuisisi"),
	R_5400000000 ("5400000000", "Jumlah Beban Asuransi"),
//	R_5500000099 ("5500000099", "Beban Usaha"),
	R_5501000000 ("5501000000", "a. Beban Pemasaran"),
//	R_5502000000 ("5502000000", "b. Beban Umum dan Administrasi:"),
	R_5502010000 ("5502010000", "- Beban Pegawai dan Pengurus"),
	R_5502020000 ("5502020000", "- Beban Pendidikan dan Pelatihan"),
	R_5502030000 ("5502030000", "- Beban Umum dan Administrasi"),
	R_5503000000 ("5503000000", "c. Beban Manajemen"),
	R_5504000000 ("5504000000", "d. Beban Mortalitas"),
	R_5505000000 ("5505000000", "e. Beban Usaha Lainnya"),
	R_5500000000 ("5500000000", "Jumlah Beban Usaha"),
	R_5000000000 ("5000000000", "JUMLAH BEBAN"),
	R_3403050000 ("3403050000", "Kenaikan (Penurunan) Nilai Aset"),
	R_3403010000 ("3403010000", "LABA (RUGI) SEBELUM PAJAK"),
	R_5600000000 ("5600000000", "Pajak Penghasilan"),
	R_3403020000 ("3403020000", "LABA SETELAH PAJAK"),
	R_3403030000 ("3403030000", "PENDAPATAN KOMPREHENSIF LAIN"),
	R_3403040000 ("3403040000", "TOTAL LABA (RUGI) KOMPREHENSIF"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2020PosReAsrjk0200 eEnum : ER2020PosReAsrjk0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2020PosReAsrjk0200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2020PosReAsrjk0200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsFormula("3-2");
	}

	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_4400000000.key, 
				R_4401000000.key + "-" + R_4402000000.key + "+" + R_4403000000.key, 
				"Total Pendapatan Premi Neto|Penjumlahan Pendapatan Premi Neto");
	}

	public static SegmentValidation genValidationPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_4000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 3, 6), 
				"Total Pendapatan|Penjumlahan Pendapatan");
	}

	public static SegmentValidation genValidationBebanKlaimManfaat() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5401000000.key, 
				R_5401010000.key + "+" + R_5401020000.key + "-" + R_5401030000.key + "+" + R_5401040000.key + 
				"+" + R_5401050000.key + "+" + R_5401060000.key, 
				"Total Beban Klaim dan Manfaat|Penjumlahan Beban Klaim dan Manfaat");
	}

	public static SegmentValidation genValidationBiayaAkuisisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5402000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 18), 
				"Total Biaya Akuisisi|Penjumlahan Biaya Akuisisi");
	}

	public static SegmentValidation genValidationBebanAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5400000000.key, 
				R_5401000000.key + "+" + R_5402000000.key,
				"Total Beban Asuransi|Penjumlahan Beban Asuransi");
	}

	public static SegmentValidation genValidationBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 21, 27), 
				"Total Beban Usaha|Penjumlahan Beban Usaha");
	}

	public static SegmentValidation genValidationBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5000000000.key, 
				R_5400000000.key + "+" + R_5500000000.key,
				"Total Beban|Penjumlahan Beban");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_3403010000.key, 
				R_4000000000.key + "-" + R_5000000000.key + "-" + R_3403050000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_3403020000.key, 
				R_3403010000.key + "-" + R_5600000000.key, 
				"Total Laba Setelah Pajak|Penjumlahan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationLabaKomprehensif() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_3403040000.key, 
				R_3403020000.key + "+" + R_3403030000.key,
				"Total Laba (Rugi) Komprehensif|Penjumlahan Laba (Rugi) Komprehensif");
	}
}
