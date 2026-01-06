package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3006PosLbAsrjk200 implements IObject<KeyValueString> {
//	R_4000000099 ("4000000099", "Pendapatan"),
	R_4401000000 ("4401000000", "Pendapatan premi"),
	R_4402000000 ("4402000000", "Premi Reasuransi -/-"),
	R_4403000000 ("4403000000", "Penurunan (kenaikan) CAPYBMP"),
	R_4400000000 ("4400000000", "Jumlah Pendapatan Premi Neto"),
	R_4500000000 ("4500000000", "Hasil Investasi"),
	R_4600000000 ("4600000000", "Imbalan Jasa DPLK/ Jasa Manajemen Lainnya"),
	R_4900000000 ("4900000000", "Pendapatan Lain"),
	R_4000000000 ("4000000000", "Jumlah Pendapatan"),
//	R_5000000099 ("5000000099", "Beban"),
//	R_5400000099 ("5400000099", "Beban Asuransi"),
//	R_5401000099 ("5401000099", "a. Klaim dan Manfaat"),
	R_5401010000 ("5401010000", "(1) Klaim dan Manfaat Dibayar"),
	R_5401020000 ("5401020000", "(2) Klaim Penebusan Unit"),
	R_5401030000 ("5401030000", "(3) Klaim Reasuransi -/-"),
	R_5401040000 ("5401040000", "(4) Kenaikan (Penurunan) Cadangan Premi"),
	R_5401050000 ("5401050000", "(5) Kenaikan (Penurunan) Cadangan Klaim"),
	R_5401060000 ("5401060000", "(6) Kenaikan (Penurunan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_5401000000 ("5401000000", "Jumlah Beban Klaim dan Manfaat"),
//	R_5402000099 ("5402000099", "b. Biaya Akuisisi"),
	R_5402010000 ("5402010000", "(1) Beban Komisi - Tahun Pertama"),
	R_5402020000 ("5402020000", "(2) Beban Komisi - Tahun Lanjutan"),
	R_5402030000 ("5402030000", "(3) Beban Komisi - Overriding"),
	R_5402990000 ("5402990000", "(4) Beban Lainnya"),
	R_5402000000 ("5402000000", "Jumlah Biaya Akuisisi"),
	R_5400000000 ("5400000000", "Jumlah Beban Asuransi"),
//	R_5500000099 ("5500000099", "Beban Usaha"),
	R_5501000000 ("5501000000", "a. Beban Pemasaran"),
//	R_5502000000 ("5502000000", "b. Beban Umum dan Administrasi"),
	R_5502010000 ("5502010000", "- Beban Pegawai dan Pengurus"),
	R_5502020000 ("5502020000", "- Beban Pendidikan dan Pelatihan"),
	R_5502030000 ("5502030000", "- Beban Umum dan Administrasi Lainnya"),
	R_5503000000 ("5503000000", "c. Beban Manajemen"),
	R_5504000000 ("5504000000", "d. Beban Mortalitas"),
	R_5505000000 ("5505000000", "e. Beban Usaha Lainnya"),
	R_5500000000 ("5500000000", "Jumlah Beban Usaha"),
	R_5000000000 ("5000000000", "Jumlah Beban "),
	R_3403050000 ("3403050000", "Kenaikan (Penurunan) Nilai Aset"),
	R_3403010000 ("3403010000", "Laba (Rugi) Sebelum Pajak"),
	R_5600000000 ("5600000000", "Pajak Penghasilan"),
	R_3403020000 ("3403020000", "Laba (Rugi) Setelah Pajak"),
	R_3403030000 ("3403030000", "Pendapatan Komprehensif Lain"),
	R_3403040000 ("3403040000", "Total Laba (Rugi) Komprehensif"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3006PosLbAsrjk200 eEnum : ER3006PosLbAsrjk200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3006PosLbAsrjk200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3006PosLbAsrjk200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static ConditionalRequired genConditionalExistPos2() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 25, 26, 30 }));
	}
	
	public static ConditionalRequired genConditionalExistPos3() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2, 5, 6, 8, 10, 11, 12, 13, 15, 16, 17, 21, 31, 32, 33, 34, 35 }));
	}
	
	public static ConditionalRequired genConditionalExistPos4() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 7, 19, 20, 28, 29, 31, 33, 35 }));
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 4, 5, 6, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 21, 22, 23, 24, 25, 26, 27, 30, 31, 32, 34 }));
	}

	public static SegmentValidation genValidationPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4400000000.key, 
				R_4401000000.key + "-" + R_4402000000.key + "+" + R_4403000000.key, 
				"Jumlah pendapatan premi neto|Perhitungan pendapatan premi neto");
	}

	public static SegmentValidation genValidationPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 3, 6), 
				"Jumlah pendapatan|Penjumlahan pendapatan");
	}

	public static SegmentValidation genValidationBebanKlaimDanManfaat() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5401000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 8, 9) + "-" + R_5401030000.key + "+" + 
						UtilMetadata.genPlusRow(getObjects(), 11, 13), 
				"Jumlah beban klaim dan manfaat|Perhitungan beban klaim dan manfaat");
	}

	public static SegmentValidation genValidationBiayaAkuisisi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5402000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 18), 
				"Jumlah biaya akuisisi|Perhitungan biaya akuisisi");
	}

	public static SegmentValidation genValidationBebanAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 14, 19 }),
				"Jumlah beban asuransi|Penjumlahan beban asuransi");
	}

	public static SegmentValidation genValidationBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 21, 27),
				"Jumlah beban usaha|Penjumlahan beban usaha");
	}

	public static SegmentValidation genValidationBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 28 }),
				"Jumlah beban|Penjumlahan beban");
	}

	public static SegmentValidation genValidationKenaikanNilaiAset() {
		return UtilSegmentValidation.genEqualsFormula("3", R_3403050000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 7, 29 }), 
				"Total kenaikan (penurunan) nilai aset|Perhitungan kenaikan (penurunan) nilai aset");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2", R_3403010000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 7, 29 }), 
				"Total laba (rugi) sebelum pajak|Perhitungan laba (rugi) sebelum pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|5", R_3403020000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 31, 32 }), 
				"Total laba (rugi) setelah pajak|Perhitungan laba (rugi) setelah pajak");
	}

	public static SegmentValidation genValidationLabaKomprehensif() {
		return UtilSegmentValidation.genEqualsFormula("2|5", R_3403040000.key, 
				UtilMetadata.genPlusRow(getObjects(), 33, 34),
				"Total laba (rugi) komprehensif|Penjumlahan laba (rugi) komprehensif");
	}
	
	public static SegmentValidation genFormValidationPendapatanPremiTradisional() {
		return UtilSegmentValidation.genEqualsForm("2", R_4401000000.key, EFormLaporanBulanan.LB_201.getCode(), "10", 
				ER3032PosLbAsrjk201.R_4401990000.getKey());
	}
	
	public static SegmentValidation genFormValidationPendapatanPremiNetoTradisional() {
		return UtilSegmentValidation.genEqualsForm("2", R_4400000000.key, EFormLaporanBulanan.LB_201.getCode(), "10", 
				ER3032PosLbAsrjk201.R_4400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationPendapatanPremiPaydi() {
		return UtilSegmentValidation.genEqualsForm("3", R_4401000000.key, EFormLaporanBulanan.LB_201.getCode(), "13", 
				ER3032PosLbAsrjk201.R_4401990000.getKey());
	}
	
	public static SegmentValidation genFormValidationPendapatanPremiNetoPaydi() {
		return UtilSegmentValidation.genEqualsForm("3", R_4400000000.key, EFormLaporanBulanan.LB_201.getCode(), "13", 
				ER3032PosLbAsrjk201.R_4400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationHasilInvestasiTradisional() {
		return UtilSegmentValidation.genEqualsForm("2", R_4500000000.key, EFormLaporanBulanan.LB_204.getCode(), "5", 
				ER3035PosLbAsrjk204.R_4505000000.getKey());
	}
	
	public static SegmentValidation genFormValidationHasilInvestasiPaydi() {
		return UtilSegmentValidation.genEqualsForm("3", R_4500000000.key, EFormLaporanBulanan.LB_117.getCode(), "5", 
				ER3039PosLbAsrjk117.R_4505000000.getKey());
	}
	
	public static SegmentValidation genFormValidationKlaimPenebusanUnit() {
		return UtilSegmentValidation.genEqualsForm("3", R_5401020000.key, EFormLaporanBulanan.LB_118.getCode(), "5", 
				ER3040PosLbAsrjk118.R_5401020000.getKey());
	}
}
