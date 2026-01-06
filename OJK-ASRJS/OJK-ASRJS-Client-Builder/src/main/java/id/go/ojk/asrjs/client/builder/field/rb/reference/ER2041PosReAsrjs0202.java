package id.go.ojk.asrjs.client.builder.field.rb.reference;

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
public enum ER2041PosReAsrjs0202 implements IObject<KeyValueString> {
//	R_02020100000000 ("02020100000000", "PENDAPATAN"),
//	R_02020101000000 ("02020101000000", "PENDAPATAN INVESTASI "),
	R_02020101010000 ("02020101010000", "Hasil Investasi"),
	R_02020101020000 ("02020101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_02020101030000 ("02020101030000", "Jumlah Hasil Investasi"),
//	R_02020102000000 ("02020102000000", "PENDAPATAN UNDERWRITING"),
	R_02020102010000 ("02020102010000", "Kontribusi Peserta (Tabarru')"),
	R_02020102020000 ("02020102020000", "Kontribusi Reasuransi/Retrosesi"),
	R_02020102030000 ("02020102030000", "Kontribusi Neto "),
//	R_02020102040000 ("02020102040000", "Penurunan (Kenaikan) Penyisihan Kontribusi dan PAKYBMP "),
	R_02020102040100 ("02020102040100", "a. Penurunan (kenaikan) Penyisihan Kontribusi"),
	R_02020102040200 ("02020102040200", "b. Penurunan (kenaikan) PAKYBMP "),
	R_02020102040300 ("02020102040300", "c. Penurunan (Kenaikan) Penyisihan atas Risiko Bencana"),
	R_02020102050000 ("02020102050000", "Jumlah Pendapatan Kontribusi Neto "),
	R_02020102060000 ("02020102060000", "JUMLAH PENDAPATAN UNDERWRITING "),
//	R_02020200000000 ("02020200000000", "BEBAN"),
//	R_02020201000000 ("02020201000000", "BEBAN UNDERWRITING"),
//	R_02020201010000 ("02020201010000", "Beban Klaim"),
	R_02020201010100 ("02020201010100", "a. Klaim Bruto"),
	R_02020201010200 ("02020201010200", "b. Klaim recovery"),
	R_02020201010300 ("02020201010300", "c. Kenaikan (Penurunan) Penyisihan Klaim "),
	R_02020201020000 ("02020201020000", "Jumlah Beban Klaim Netto "),
	R_02020201030000 ("02020201030000", "Beban Adjuster"),
	R_02020201040000 ("02020201040000", "JUMLAH BEBAN UNDERWRITING "),
	R_02020300000000 ("02020300000000", "JUMLAH SURPLUS (DEFISIT) UNDERWRITING "),
	R_02020301000000 ("02020301000000", "a. Surplus underwriting untuk dana Perusahaan"),
	R_02020302000000 ("02020302000000", "b. Surplus underwriting untuk Peserta"),
	R_02020400000000 ("02020400000000", "LABA (RUGI) USAHA ASURANSI "),
	R_02020500000000 ("02020500000000", "Pendapatan Lain"),
	R_02020600000000 ("02020600000000", "Beban Lain"),
	R_02020700000000 ("02020700000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_02020800000000 ("02020800000000", "Pajak Penghasilan"),
	R_02020900000000 ("02020900000000", "LABA SETELAH PAJAK "),
	R_02021000000000 ("02021000000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_02021100000000 ("02021100000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2041PosReAsrjs0202 eEnum : ER2041PosReAsrjs0202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2041PosReAsrjs0202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2041PosReAsrjs0202.class.getSimpleName().substring(2, 6));
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
	
	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationHasilInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020101030000.key,
				R_02020101010000.key + "-" + R_02020101020000.key, 
				"Jumlah Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020102030000.key,
				R_02020102010000.key + "-" + R_02020102020000.key, 
				"Total Kontribusi Neto|Perhitungan Kontribusi Neto");
	}

	public static SegmentValidation genValidationPendapatanKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020102050000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8), 
				"Total Pendapatan Kontribusi Neto|Perhitungan Pendapatan Kontribusi Neto");
	}

	public static SegmentValidation genValidationPendapatanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020102060000.key, R_02020102050000.key, 
				"Total Pendapatan Underwriting|Perhitungan Pendapatan Underwriting");
	}

	public static SegmentValidation genValidationBebanKlaimNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020201020000.key,
				R_02020201010100.key + "-" + R_02020201010200.key + "+" + R_02020201010300.key, 
				"Total Beban Klaim Netto|Perhitungan Beban Klaim Netto");
	}

	public static SegmentValidation genValidationBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020201040000.key,
				R_02020201020000.key + "+" + R_02020201030000.key, 
				"Total Beban Underwriting|Perhitungan Beban Underwriting");
	}

	public static SegmentValidation genValidationSurplusUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020300000000.key,
				R_02020102060000.key + "-" + R_02020201040000.key, 
				"Total Surplus (Defisit) Underwriting|Perhitungan Surplus (Defisit) Underwriting");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020400000000.key,
				R_02020101030000.key + "+" + R_02020300000000.key + "-" + R_02020301000000.key + "-" + R_02020302000000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Perhitungan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020700000000.key,
				R_02020400000000.key + "+" + R_02020500000000.key + "-" + R_02020600000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02020900000000.key,
				R_02020700000000.key + "-" + R_02020800000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02021100000000.key,
				R_02020900000000.key + "+" + R_02021000000000.key, 
				"Jumlah Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
