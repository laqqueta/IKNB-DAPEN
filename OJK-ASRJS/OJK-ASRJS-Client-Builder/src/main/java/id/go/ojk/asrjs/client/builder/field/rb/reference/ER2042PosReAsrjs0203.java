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
public enum ER2042PosReAsrjs0203 implements IObject<KeyValueString> {
//	R_02030100000000 ("02030100000000", "PENDAPATAN"),
//	R_02030101000000 ("02030101000000", "PENDAPATAN INVESTASI DAN KONTRIBUSI ALOKASI INVESTASI "),
	R_02030101010000 ("02030101010000", "Hasil Investasi"),
	R_02030101020000 ("02030101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_02030101030000 ("02030101030000", "Jumlah Hasil Investasi"),
	R_02030101040000 ("02030101040000", "Kontribusi Peserta (Alokasi Investasi)"),
	R_02030101050000 ("02030101050000", "Jumlah Hasil Investasi dan Kontribusi Alokasi Investasi"),
//	R_02030102000000 ("02030102000000", "BEBAN"),
//	R_02030102010000 ("02030102010000", "Beban Klaim"),
	R_02030102010100 ("02030102010100", "a. Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_02030102010200 ("02030102010200", "b. Penarikan/Penebusan Dana Investasi Peserta (belum jt tempo)"),
	R_02030102010300 ("02030102010300", "Jumlah Beban Klaim "),
	R_02030102020000 ("02030102020000", "Surplus underwriting untuk Peserta"),
	R_02030103000000 ("02030103000000", "LABA (RUGI) USAHA ASURANSI "),
	R_02030104000000 ("02030104000000", "Beban Lain"),
	R_02030105000000 ("02030105000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_02030106000000 ("02030106000000", "Pajak Penghasilan"),
	R_02030107000000 ("02030107000000", "LABA SETELAH PAJAK "),
	R_02030108000000 ("02030108000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_02030109000000 ("02030109000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2042PosReAsrjs0203 eEnum : ER2042PosReAsrjs0203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2042PosReAsrjs0203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2042PosReAsrjs0203.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030101030000.key,
				R_02030101010000.key + "-" + R_02030101020000.key, 
				"Total Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationHasilInvestasiDanKontribusiAlokasiInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030101050000.key,
				R_02030101030000.key + "+" + R_02030101040000.key, 
				"Total Hasil Investasi dan Kontribusi Alokasi Investasi|Perhitungan Hasil Investasi dan Kontribusi Alokasi Investasi");
	}

	public static SegmentValidation genValidationBebanKlaim() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030102010300.key,
				R_02030102010100.key + "+" + R_02030102010200.key, 
				"Total Beban Klaim|Perhitungan Beban Klaim");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030103000000.key,
				R_02030101050000.key + "-" + R_02030102010300.key + "+" + R_02030102020000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Perhitungan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030105000000.key,
				R_02030103000000.key + "-" + R_02030104000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030107000000.key,
				R_02030105000000.key + "-" + R_02030106000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02030109000000.key,
				R_02030107000000.key + "+" + R_02030108000000.key, 
				"Total Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
