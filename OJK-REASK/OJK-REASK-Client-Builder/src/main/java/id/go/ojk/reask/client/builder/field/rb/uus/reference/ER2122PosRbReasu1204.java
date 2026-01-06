package id.go.ojk.reask.client.builder.field.rb.uus.reference;

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
public enum ER2122PosRbReasu1204 implements IObject<KeyValueString> {
//	R_12040100000000 ("12040100000000", "PENDAPATAN"),
//	R_12040101000000 ("12040101000000", "PENDAPATAN INVESTASI"),
	R_12040101010000 ("12040101010000", "Hasil Investasi"),
	R_12040101020000 ("12040101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_12040101030000 ("12040101030000", "Jumlah Hasil Investasi"),
//	R_12040102000000 ("12040102000000", "PENDAPATAN UNDERWRITING"),
	R_12040102010000 ("12040102010000", "Kontribusi Peserta (Tabarru')"),
	R_12040102020000 ("12040102020000", "Kontribusi Reasuransi/Retrosesi"),
	R_12040102030000 ("12040102030000", "Kontribusi Neto"),
//	R_12040102040000 ("12040102040000", "Penurunan (Kenaikan) Penyisihan Kontribusi dan PAKYBMP"),
	R_12040102040100 ("12040102040100", "a. Penurunan (kenaikan) Penyisihan Kontribusi"),
	R_12040102040200 ("12040102040200", "b. Penurunan (kenaikan) PAKYBMP"),
	R_12040102040300 ("12040102040300", "c. Penurunan (Kenaikan) Penyisihan atas Risiko Bencana"),
	R_12040102050000 ("12040102050000", "Jumlah Pendapatan Kontribusi Neto"),
	R_12040102060000 ("12040102060000", "JUMLAH PENDAPATAN UNDERWRITING"),
//	R_12040200000000 ("12040200000000", "BEBAN"),
//	R_12040201000000 ("12040201000000", "BEBAN UNDERWRITING"),
//	R_12040201010000 ("12040201010000", "Beban Klaim"),
	R_12040201010100 ("12040201010100", "a. Klaim Bruto"),
	R_12040201010200 ("12040201010200", "b. Klaim recovery"),
	R_12040201010300 ("12040201010300", "c. Kenaikan (Penurunan) Penyisihan Klaim"),
	R_12040201020000 ("12040201020000", "Jumlah Beban Klaim Netto"),
	R_12040201030000 ("12040201030000", "Beban Adjuster"),
	R_12040201040000 ("12040201040000", "JUMLAH BEBAN UNDERWRITING"),
	R_12040300000000 ("12040300000000", "JUMLAH SURPLUS (DEFISIT) UNDERWRITING"),
	R_12040301000000 ("12040301000000", "a. Surplus underwriting untuk dana Perusahaan"),
	R_12040302000000 ("12040302000000", "b. Surplus underwriting untuk Peserta"),
	R_12040400000000 ("12040400000000", "LABA (RUGI) USAHA ASURANSI"),
	R_12040500000000 ("12040500000000", "Pendapatan Lain"),
	R_12040600000000 ("12040600000000", "Beban Lain"),
	R_12040700000000 ("12040700000000", "LABA (RUGI) SEBELUM PAJAK"),
	R_12040800000000 ("12040800000000", "Pajak Penghasilan"),
	R_12040900000000 ("12040900000000", "LABA SETELAH PAJAK"),
	R_12041000000000 ("12041000000000", "PENDAPATAN KOMPREHENSIF LAIN"),
	R_12041100000000 ("12041100000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2122PosRbReasu1204 eEnum : ER2122PosRbReasu1204.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2122PosRbReasu1204.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2122PosRbReasu1204.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationHasilInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040101030000.key,
				R_12040101010000.key + "-" + R_12040101020000.key, 
				"Total Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040102030000.key,
				R_12040102010000.key + "-" + R_12040102020000.key, 
				"Total Kontribusi Neto|Perhitungan Kontribusi Neto");
	}

	public static SegmentValidation genValidationPendapatanKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040102050000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8), 
				"Total Pendapatan Kontribusi Neto|Penjumlahan Pendapatan Kontribusi Neto");
	}

	public static SegmentValidation genValidationPendapatanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040102060000.key,
				R_12040102050000.key, 
				"Total Pendapatan Underwriting|Penjumlahan Pendapatan Underwriting");
	}

	public static SegmentValidation genValidationBebanKlaimNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040201020000.key,
				R_12040201010100.key + "-" + R_12040201010200.key + "+" + R_12040201010300.key,
				"Total Beban Klaim Netto|Penjumlahan Beban Klaim Netto");
	}

	public static SegmentValidation genValidationBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040201040000.key,
				R_12040201020000.key + "+" + R_12040201030000.key, 
				"Total Beban Underwriting|Penjumlahan Beban Underwriting");
	}

	public static SegmentValidation genValidationSurplusUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040300000000.key,
				R_12040102060000.key + "-" + R_12040201040000.key, 
				"Total Surplus (Defisit) Underwriting|Perhitungan Surplus (Defisit) Underwriting");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040400000000.key,
				R_12040101030000.key + "+" + R_12040300000000.key + "-" + 
						R_12040301000000.key + "-" + R_12040302000000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Perhitungan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040700000000.key,
				R_12040400000000.key + "+" + R_12040500000000.key + "-" + R_12040600000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040900000000.key,
				R_12040700000000.key + "-" + R_12040800000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12041100000000.key,
				R_12040900000000.key + "+" + R_12041000000000.key, 
				"Total Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
