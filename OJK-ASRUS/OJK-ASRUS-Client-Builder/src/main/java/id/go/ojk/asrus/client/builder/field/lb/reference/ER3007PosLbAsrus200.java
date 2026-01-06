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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3007PosLbAsrus200 implements IObject<KeyValueString> {
//	R_4000000099 ("4000000099", "PENDAPATAN"),
//	R_4100000099 ("4100000099", "PENDAPATAN INVESTASI DAN UJROH PENGELOLAAN INVESTASI"),
	R_4101010000 ("4101010000", "Hasil Investasi"),
	R_4101020000 ("4101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_4101000000 ("4101000000", "Jumlah Hasil Investasi"),
	R_4102000000 ("4102000000", "Jumlah Ujroh Pengelolaan Investasi"),
	R_4100000000 ("4100000000", "Jumlah Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi"),
//	R_4200000099 ("4200000099", "PENDAPATAN UNDERWRITING"),
//	R_4201000000 ("4201000000", "Kontribusi Bruto/Ujroh Diterima/Alokasi Investasi"),
	R_4202000000 ("4202000000", "a. Alokasi Kontribusi Langsung: Tabarru/Ujroh/Investasi"),
	R_4200000000 ("4200000000", "b. Alokasi Kontribusi Tidak Langsung: Tabarru/Ujroh"),
	R_4300000000 ("4300000000", "Jumlah Kontribusi Bruto/Ujroh Diterima/Alokasi Untuk Investasi"),
	R_4400000099 ("4400000099", "Kontribusi Reasuransi/Retrosesi"),
	R_4401000000 ("4401000000", "Kontribusi Neto "),
//	R_4402000000 ("4402000000", "Penurunan (Kenaikan) Penyisihan Kontribusi dan PAKYBMP (Net Setelah Aset Reasuransi)"),
	R_4403000000 ("4403000000", "a. Penurunan (kenaikan) Penyisihan Kontribusi"),
	R_4400000000 ("4400000000", "b. Penurunan (kenaikan) PAKYBMP "),
	R_4500000000 ("4500000000", "c. Penurunan (Kenaikan) Penyisihan atas Risiko Bencana"),
	R_4600000000 ("4600000000", "Jumlah Pendapatan Kontribusi Neto "),
	R_4000000000 ("4000000000", "PENDAPATAN UNDERWRITING "),
//	R_5400000099 ("5400000099", "BEBAN"),
//	R_5401000099 ("5401000099", "BEBAN UNDERWRITING"),
//	R_5401010000 ("5401010000", "Beban Klaim"),
	R_5401020000 ("5401020000", "a. Klaim Bruto"),
	R_5401030000 ("5401030000", "b. Klaim recovery"),
	R_5401000000 ("5401000000", "c. Kenaikan (Penurunan) Penyisihan Klaim "),
	R_5402000000 ("5402000000", "d. Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_5400000000 ("5400000000", "e. Penarikan/Penebusan Dana Investasi Peserta (belum jt tempo)"),
	R_5500000000 ("5500000000", "Jumlah Beban Klaim Netto "),
	R_5600000000 ("5600000000", "Beban Adjuster"),
	R_5700000099 ("5700000099", "JUMLAH BEBAN UNDERWRITING "),
	R_5701000000 ("5701000000", "JUMLAH SURPLUS (DEFISIT) UNDERWRITING "),
	R_5702000099 ("5702000099", "a. Surplus underwriting untuk dana Perusahaan"),
	R_5702010000 ("5702010000", "b. Surplus underwriting untuk Peserta"),
//	R_5702020000 ("5702020000", "BEBAN USAHA:"),
	R_5702030000 ("5702030000", "a. Beban Pemasaran"),
	R_5703000000 ("5703000000", "b. Beban Akuisisi"),
	R_5704000000 ("5704000000", "c. Beban Umum dan Administrasi:"),
	R_5700000000 ("5700000000", "- Beban Pegawai dan Pengurus"),
	R_5801000000 ("5801000000", "- Beban Pendidikan dan Pelatihan"),
	R_5802000000 ("5802000000", "- Beban Umum dan Administrasi Lainnya"),
	R_5803000000 ("5803000000", "Kenaikan (penurunan) Penyisihan Ujroh"),
	R_5804000000 ("5804000000", "JUMLAH BEBAN USAHA"),
	R_5805000000 ("5805000000", "LABA (RUGI) USAHA ASURANSI "),
	R_5806000000 ("5806000000", "Pendapatan Lain"),
	R_5800000000 ("5800000000", "Beban Lain"),
	R_5800000001 ("5800000001", "LABA (RUGI) SEBELUM PAJAK "),
	R_5800000002 ("5800000002", "Pajak Penghasilan"),
	R_5800000003 ("5800000003", "LABA SETELAH PAJAK "),
	R_5800000004 ("5800000004", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_5800000005 ("5800000005", "JUMLAH KINERJA SELURUH DANA"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3007PosLbAsrus200 eEnum : ER3007PosLbAsrus200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 6), getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 18, 19, 26, 27, 28, 29, 30, 31, 32, 33, 40 }));
	}
	
	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 8, 10, 11, 12, 13, 14, 15, 16, 17, 21, 22, 23, 24, 26, 27, 28, 29, 30, 31, 32, 33, 35, 40 }));
	}
	
	public static ConditionalRequired genConditional5() {
		return genConditional4();
	}
	
	public static ConditionalRequired genConditional7() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1, 23, 28 }));
	}
	
	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 5) + "-6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1, 23, 28 }));
	}

	public static SegmentValidation genValidationJumlahHasilInvestasiA() {
		return UtilSegmentValidation.genEqualsFormula("2", R_4101000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), 
				"Jumlah Hasil Investasi|Penjumlahan Hasil Investasi");
	}

	public static SegmentValidation genValidationJumlahHasilInvestasiB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_4101000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 0, 1), 
				"Jumlah Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationJumlahPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4100000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 3), 
				"Jumlah Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi|Penjumlahan Jumlah Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi");
	}

	public static SegmentValidation genValidationJumlahKontribusiBruto() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4300000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 6), 
				"Jumlah Kontribusi Bruto/Ujroh Diterima/Alokasi Untuk Investasi|Penjumlahan Kontribusi Bruto/Ujroh Diterima/Alokasi Untuk Investasi");
	}

	public static SegmentValidation genValidationKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 7, 8), 
				"Total Kontribusi Neto|Perhitungan Kontribusi Neto");
	}

	public static SegmentValidation genValidationJumlahBebanKlaimNettoA() {
		return UtilSegmentValidation.genEqualsFormula("3", R_5500000000.key, 
				R_5401020000.key + "-" + UtilMetadata.genPlusRow(getObjects(), 16, 17),
				"Jumlah Beban Klaim Netto|Perhitungan Beban Klaim Netto");
	}

	public static SegmentValidation genValidationJumlahBebanKlaimNettoB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(4, 5), R_5500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 18, 19),
				"Jumlah Beban Klaim Netto|Penjumlahan Beban Klaim Netto");
	}

	public static SegmentValidation genValidationJumlahBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("3", R_5700000099.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 21 }),
				"Jumlah Beban Underwriting|Penjumlahan Beban Underwriting");
	}

	public static SegmentValidation genValidationJumlahSurplusDefisitUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("3", R_5701000000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 14, 22 }), 
				"Jumlah Surplus (Defisit) Underwriting|Perhitungan Surplus (Defisit) Underwriting");
	}

	public static SegmentValidation genValidationBebanUmumDanAdministrasi() {
		return UtilSegmentValidation.genEqualsFormula("2", R_5704000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 29, 31), 
				"Total Beban Umum dan Administrasi|Penjumlahan Beban Umum dan Administrasi");
	}

	public static SegmentValidation genValidationJumlahBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2", R_5804000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 26, 27, 28, 32 }), 
				"Jumlah Beban Usaha|Penjumlahan Beban Usaha");
	}

	public static SegmentValidation genValidationLabaRugiUsahaAsuransiA() {
		return UtilSegmentValidation.genEqualsFormula("2", R_5805000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 14, 24 }) + "-" + R_5804000000.key,
				"Total Laba (Rugi) Usaha Asuransi|Penjumlahan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaRugiUsahaAsuransiB() {
		return UtilSegmentValidation.genEqualsFormula("3", R_5805000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 23 }) + "-" + UtilMetadata.genMinusRow(getObjects(), new int[] { 25, 26 }),
				"Total Laba (Rugi) Usaha Asuransi|Penjumlahan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaRugiUsahaAsuransiC() {
		return UtilSegmentValidation.genEqualsFormula("4|5", R_5805000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 9 }) + "-" + UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 26 }),
				"Total Laba (Rugi) Usaha Asuransi|Penjumlahan Laba (Rugi) Usaha Asuransi");
	}
	
	public static SegmentValidation genValidationLabaRugiSebelumPajakA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_5800000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 34, 35 }) + "-" + R_5800000000.key,
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}
	
	public static SegmentValidation genValidationLabaRugiSebelumPajakB() {
		return UtilSegmentValidation.genEqualsFormula("4|5", R_5800000001.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 34, 36 }),
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}
	
	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_5800000003.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 37, 38 }),
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}
	
	public static SegmentValidation genValidationJumlahKinerjaSeluruhDanaA() {
		return UtilSegmentValidation.genEqualsFormula("2|4|5", R_5800000005.key, 
				UtilMetadata.genPlusRow(getObjects(), 39, 40), "Jumlah Kinerja Seluruh Dana|Penjumlahan Kinerja Seluruh Dana");
	}
	
	public static SegmentValidation genValidationJumlahKinerjaSeluruhDanaB() {
		return UtilSegmentValidation.genEqualsFormula("3", R_5800000005.key, 
				R_4100000000.key + "+" + R_5701000000.key + "-" + R_5702000099.key + "+" + 
				R_5806000000.key + "-" + R_5800000000.key + "-" + R_5800000002.key + "+" + R_5800000004.key,
				"Jumlah Kinerja Seluruh Dana|Penjumlahan Kinerja Seluruh Dana");
	}
}
