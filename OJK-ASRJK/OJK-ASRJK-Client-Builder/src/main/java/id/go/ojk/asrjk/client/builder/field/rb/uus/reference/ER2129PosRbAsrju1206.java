package id.go.ojk.asrjk.client.builder.field.rb.uus.reference;

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
public enum ER2129PosRbAsrju1206 implements IObject<KeyValueString> {
//	R_12060100000000 ("12060100000000", "PENDAPATAN"),
//	R_12060101000000 ("12060101000000", "PENDAPATAN INVESTASI DAN KONTRIBUSI ALOKASI INVESTASI "),
	R_12060101010000 ("12060101010000", "Hasil Investasi"),
	R_12060101020000 ("12060101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_12060101030000 ("12060101030000", "Jumlah Hasil Investasi"),
	R_12060101040000 ("12060101040000", "Kontribusi Peserta (Alokasi Investasi)"),
	R_12060101050000 ("12060101050000", "Jumlah Hasil Investasi dan Kontribusi Alokasi Investasi"),
//	R_12060102000000 ("12060102000000", "BEBAN"),
//	R_12060102010000 ("12060102010000", "Beban Klaim"),
	R_12060102010100 ("12060102010100", "a. Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_12060102010200 ("12060102010200", "b. Penarikan/Penebusan Dana Investasi Peserta (belum jt tempo)"),
	R_12060102010300 ("12060102010300", "Jumlah Beban Klaim "),
	R_12060102020000 ("12060102020000", "Surplus underwriting untuk Peserta"),
	R_12060103000000 ("12060103000000", "LABA (RUGI) USAHA ASURANSI "),
	R_12060104000000 ("12060104000000", "Beban Lain"),
	R_12060105000000 ("12060105000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_12060106000000 ("12060106000000", "Pajak Penghasilan"),
	R_12060107000000 ("12060107000000", "LABA SETELAH PAJAK "),
	R_12060108000000 ("12060108000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_12060109000000 ("12060109000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2129PosRbAsrju1206 eEnum : ER2129PosRbAsrju1206.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2129PosRbAsrju1206.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2129PosRbAsrju1206.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationHasilInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060101030000.key,
				R_12060101010000.key + "-" + R_12060101020000.key, 
				"Total Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationHasilInvestasiDanKontribusiAlokasiInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060101050000.key,
				R_12060101030000.key + "+" + R_12060101040000.key, 
				"Total Hasil Investasi dan Kontribusi Alokasi Investasi|Perhitungan Hasil Investasi dan Kontribusi Alokasi Investasi");
	}

	public static SegmentValidation genValidationBebanKlaim() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060102010300.key,
				R_12060102010100.key + "+" + R_12060102010200.key, 
				"Total Beban Klaim|Penjumlahan Beban Klaim");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060103000000.key,
				R_12060101050000.key + "-" + R_12060102010300.key + "+" + R_12060102020000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Perhitungan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060105000000.key,
				R_12060103000000.key + "-" + R_12060104000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060107000000.key,
				R_12060105000000.key + "-" + R_12060106000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060109000000.key,
				R_12060107000000.key + "+" + R_12060108000000.key, 
				"Total Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
