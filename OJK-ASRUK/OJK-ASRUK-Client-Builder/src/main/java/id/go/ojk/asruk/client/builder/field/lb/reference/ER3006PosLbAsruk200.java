package id.go.ojk.asruk.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3006PosLbAsruk200 implements IObject<KeyValueString> {
//	R_4000000099 ("4000000099", "Pendapatan Underwriting"),
//	R_4100000099 ("4100000099", "Premi Bruto"),
	R_4101010000 ("4101010000", "a. Premi Penutupan Langsung"),
	R_4101020000 ("4101020000", "b. Premi Penutupan Tidak Langsung"),
	R_4101000000 ("4101000000", "Jumlah Pendapatan Premi"),
	R_4102000000 ("4102000000", "c. Komisi Dibayar -/-"),
	R_4100000000 ("4100000000", "Jumlah Premi Bruto"),
//	R_4200000099 ("4200000099", "Premi Reasuransi"),
	R_4201000000 ("4201000000", "a. Premi Reasuransi Dibayar"),
	R_4202000000 ("4202000000", "b.Komisi Reasuransi Diterima -/-"),
	R_4200000000 ("4200000000", "Jumlah Premi Reasuransi -/-"),
	R_4300000000 ("4300000000", "Premi Netto"),
//	R_4400000099 ("4400000099", "Penurunan (Kenaikan) Cadangan Premi, CAPYBMP, dan Cadangan Catastrophic"),
	R_4401000000 ("4401000000", "a. Penurunan (Kenaikan) Cadangan Premi"),
	R_4402000000 ("4402000000", "b. Penurunan (Kenaikan) CAPYBMP"),
	R_4403000000 ("4403000000", "c. Penurunan (kenaikan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_4400000000 ("4400000000", "Jumlah Penurunan (Kenaikan) Cadangan Premi dan CAPYBMP "),
	R_4500000000 ("4500000000", "Jumlah Pendapatan Premi Neto"),
	R_4600000000 ("4600000000", "Pendapatan Underwriting Lain Neto"),
	R_4000000000 ("4000000000", "JUMLAH PENDAPATAN UNDERWRITING "),
//	R_5400000099 ("5400000099", "Beban Underwriting"),
//	R_5401000099 ("5401000099", "Beban Klaim"),
	R_5401010000 ("5401010000", "a. Klaim Bruto"),
	R_5401020000 ("5401020000", "b. Klaim Reasuransi -/-"),
	R_5401030000 ("5401030000", "c. Kenaikan (Penurunan) Cadangan Klaim"),
	R_5401000000 ("5401000000", "Jumlah Beban Klaim Neto "),
	R_5402000000 ("5402000000", "Beban Underwriting Lain Neto"),
	R_5400000000 ("5400000000", "JUMLAH BEBAN UNDERWRITING "),
	R_5500000000 ("5500000000", "HASIL UNDERWRITING "),
	R_5600000000 ("5600000000", "Hasil Investasi"),
//	R_5700000099 ("5700000099", "Beban Usaha"),
	R_5701000000 ("5701000000", "a. Beban Pemasaran"),
//	R_5702000099 ("5702000099", "b. Beban Umum dan Administrasi:"),
	R_5702010000 ("5702010000", "- Beban Pegawai dan Pengurus"),
	R_5702020000 ("5702020000", "- Beban Pendidikan dan Pelatihan"),
	R_5702030000 ("5702030000", "- Beban Umum dan Administrasi lainnya"),
	R_5703000000 ("5703000000", "c. Biaya Terkait Estimasi Kecelakaan Diri"),
	R_5704000000 ("5704000000", "d. Biaya Manajemen"),
	R_5700000000 ("5700000000", "JUMLAH BEBAN USAHA"),
	R_5801000000 ("5801000000", "LABA (RUGI) USAHA ASURANSI "),
	R_5802000000 ("5802000000", "Hasil (Beban) Lain"),
	R_5803000000 ("5803000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_5804000000 ("5804000000", "Pajak Penghasilan"),
	R_5805000000 ("5805000000", "LABA SETELAH PAJAK "),
	R_5806000000 ("5806000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_5800000000 ("5800000000", "TOTAL LABA (RUGI) KOMPREHENSIF "),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3006PosLbAsruk200 eEnum : ER3006PosLbAsruk200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static ConditionalRequired genConditionalExistPos2() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 28, 29 }));
	}
	public static ConditionalRequired genConditionalExistPos3() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 5, 6, 7, 9, 10, 11, 12, 14, 17, 18, 20, 24, 25, 26 }));
	}

	public static ConditionalRequired genConditionalExistPos4() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 4, 7, 8, 12, 13, 15, 19, 21, 22, 30, 31, 33, 35, 37 }));
	}
	
	public static SegmentValidation genValidationBebanKlaimNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5401000000.key, 
				R_5401010000.key + "-" + R_5401020000.key + "+" + R_5401030000.key, 
				"Total beban klaim netto|Perhitungan beban klaim netto");
	}

	public static SegmentValidation genValidationBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 20 }),
				"Total beban underwriting|Penjumlahan beban underwriting");
	}
	
	public static SegmentValidation genValidationBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5700000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 24, 29),
				"Total beban usaha|Penjumlahan beban usaha");
	}
	
	public static SegmentValidation genValidationCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|5", R_4400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 9, 11),
				"Total perubahan cadangan premi dan CAPYBMP|Penjumlahan perubahan cadangan premi dan CAPYBMP");
	}
	
	public static SegmentValidation genValidationLabaKomprehensif() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5800000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 35, 36 }),
				"Total laba (rugi) komprehensif|Penjumlahan laba (rugi) komprehensif");
	}
	
	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5803000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 31, 32 }),
				"Total laba (rugi) sebelum pajak|Penjumlahan laba (rugi) sebelum pajak");
	}
	
	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5805000000.key, 
				R_5803000000.key + "-" + R_5804000000.key, 
				"Total laba setelah pajak|Perhitungan laba setelah pajak");
	}
	
	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5801000000.key, 
				R_5500000000.key + "+" + R_5600000000.key + "-" + R_5700000000.key, 
				"Total laba (rugi) usaha asuransi|Perhitungan laba (rugi) usaha asuransi");
	}

	public static SegmentValidation genValidationPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_4101000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), 
				"Total pendapatan premi|Penjumlahan pendapatan premi");
	}

	public static SegmentValidation genValidationPendapatanPremiNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 8, 12 }),
				"Total pendapatan premi netto|Penjumlahan pendapatan premi netto");
	}

	public static SegmentValidation genValidationPendapatanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 13, 14 }),
				"Total pendapatan underwriting|Penjumlahan pendapatan underwriting");
	}

	public static SegmentValidation genValidationPremiBruto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4100000000.key, 
				R_4101010000.key + "+" + R_4101020000.key + "-" + R_4102000000.key, 
				"Total premi bruto|Perhitungan premi bruto");
	}

	public static SegmentValidation genValidationPremiNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_4300000000.key, 
				R_4100000000.key + "-" + R_4200000000.key, 
				"Total premi netto|Perhitungan premi netto");
	}

	public static SegmentValidation genValidationPremiReasuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|5", R_4200000000.key, 
				R_4201000000.key + "-" + R_4202000000.key, 
				"Total premi reasuransi|Perhitungan premi reasuransi");
	}

	public static FieldValidation genValidationSum5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 5, 6, 9, 10, 11, 14, 16, 17, 18, 20, 23, 24, 25, 26, 27, 28, 29, 32, 34, 36 }));
	}

	public static SegmentValidation genValidationUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_5500000000.key, 
				R_4000000000.key + "-" + R_5400000000.key, 
				"Total underwriting|Perhitungan underwriting");
	}
}
