package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2127PosRbAsruu1204 implements IObject<KeyValueString> {
//	R_12040100000000 ("12040100000000", "PENDAPATAN"),
//	R_12040101000000 ("12040101000000", "PENDAPATAN INVESTASI DAN UJROH PENGELOLAAN INVESTASI"),
	R_12040101010000 ("12040101010000", "Hasil Investasi"),
	R_12040101020000 ("12040101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_12040101030000 ("12040101030000", "Jumlah Hasil Investasi"),
	R_12040101040000 ("12040101040000", "Jumlah Ujroh Pengelolaan Investasi"),
	R_12040101050000 ("12040101050000", "Jumlah Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi"),
//	R_12040102000000 ("12040102000000", "PENDAPATAN UNDERWRITING"),
	R_12040102010000 ("12040102010000", "Kontribusi Peserta (Ujroh)"),
	R_12040102020000 ("12040102020000", "Kontribusi Reasuransi/Retrosesi"),
	R_12040102030000 ("12040102030000", "Kontribusi Neto "),
	R_12040102040000 ("12040102040000", "Surplus underwriting untuk dana Perusahaan"),
//	R_12040200000000 ("12040200000000", "BEBAN USAHA:"),
	R_12040201000000 ("12040201000000", "a. Beban Pemasaran"),
	R_12040202000000 ("12040202000000", "b. Beban Akuisisi"),
	R_12040203000000 ("12040203000000", "c. Beban Umum dan Administrasi:"),
	R_12040203010000 ("12040203010000", "    - Beban Pegawai dan Pengurus"),
	R_12040203020000 ("12040203020000", "    - Beban Pendidikan dan Pelatihan"),
	R_12040203030000 ("12040203030000", "    - Beban Umum dan Administrasi Lainnya"),
	R_12040204000000 ("12040204000000", "Kenaikan (penurunan) Penyisihan Ujroh"),
	R_12040205000000 ("12040205000000", "JUMLAH BEBAN USAHA"),
	R_12040300000000 ("12040300000000", "LABA (RUGI) USAHA ASURANSI "),
	R_12040400000000 ("12040400000000", "Pendapatan Lain"),
	R_12040500000000 ("12040500000000", "Beban Lain"),
	R_12040600000000 ("12040600000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_12040700000000 ("12040700000000", "Pajak Penghasilan"),
	R_12040800000000 ("12040800000000", "LABA SETELAH PAJAK "),
	R_12040900000000 ("12040900000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_12041000000000 ("12041000000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2127PosRbAsruu1204 eEnum : ER2127PosRbAsruu1204.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2127PosRbAsruu1204.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2127PosRbAsruu1204.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationHasilInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040101030000.key,
				R_12040101010000.key + "+" + R_12040101020000.key, 
				"Total Hasil Investasi|Penjumlahan Hasil Investasi");
	}

	public static SegmentValidation genValidationPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040101050000.key,
				R_12040101030000.key + "+" + R_12040101040000.key, 
				"Total Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi|Penjumlahan Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi");
	}

	public static SegmentValidation genValidationKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040102030000.key,
				R_12040102010000.key + "-" + R_12040102020000.key, 
				"Total Kontribusi Neto|Perhitungan Kontribusi Neto");
	}

	public static SegmentValidation genValidationBebanUmumDanAdministrasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040203000000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 14), 
				"Total Beban Umum dan Administrasi|Penjumlahan Beban Umum dan Administrasi");
	}

	public static SegmentValidation genValidationBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040205000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 9, 10, 11, 15 }), 
				"Total Beban Usaha|Penjumlahan Beban Usaha");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040300000000.key,
				R_12040101050000.key + "+" + R_12040102030000.key + "+" + R_12040102040000.key + "-" + R_12040205000000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Penjumlahan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040600000000.key,
				R_12040300000000.key + "+" + R_12040400000000.key + "-" + R_12040500000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12040800000000.key,
				R_12040600000000.key + "-" + R_12040700000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12041000000000.key,
				R_12040800000000.key + "+" + R_12040900000000.key, 
				"Total Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
