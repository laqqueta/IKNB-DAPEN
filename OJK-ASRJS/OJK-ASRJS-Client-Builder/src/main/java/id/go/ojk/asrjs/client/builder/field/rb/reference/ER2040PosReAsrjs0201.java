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
public enum ER2040PosReAsrjs0201 implements IObject<KeyValueString> {
//	R_02010100000000 ("02010100000000", "PENDAPATAN"),
//	R_02010101000000 ("02010101000000", "PENDAPATAN INVESTASI DAN UJROH PENGELOLAAN INVESTASI"),
	R_02010101010000 ("02010101010000", "Hasil Investasi"),
	R_02010101020000 ("02010101020000", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_02010101030000 ("02010101030000", "Jumlah Hasil Investasi"),
	R_02010101040000 ("02010101040000", "Jumlah Ujroh Pengelolaan Investasi"),
	R_02010101050000 ("02010101050000", "Jumlah Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi"),
//	R_02010102000000 ("02010102000000", "PENDAPATAN UNDERWRITING"),
	R_02010102010000 ("02010102010000", "Kontribusi Peserta (Ujroh)"),
	R_02010102020000 ("02010102020000", "Kontribusi Reasuransi/Retrosesi"),
	R_02010102030000 ("02010102030000", "Kontribusi Neto "),
	R_02010102040000 ("02010102040000", "Surplus underwriting untuk dana Perusahaan"),
//	R_02010200000000 ("02010200000000", "BEBAN USAHA:"),
	R_02010201000000 ("02010201000000", "a. Beban Pemasaran"),
	R_02010202000000 ("02010202000000", "b. Beban Akuisisi"),
	R_02010203000000 ("02010203000000", "c. Beban Umum dan Administrasi:"),
	R_02010203010000 ("02010203010000", "    - Beban Pegawai dan Pengurus"),
	R_02010203020000 ("02010203020000", "    - Beban Pendidikan dan Pelatihan"),
	R_02010203030000 ("02010203030000", "    - Beban Umum dan Administrasi Lainnya"),
	R_02010204000000 ("02010204000000", "Kenaikan (penurunan) Penyisihan Ujroh"),
	R_02010205000000 ("02010205000000", "JUMLAH BEBAN USAHA"),
	R_02010300000000 ("02010300000000", "LABA (RUGI) USAHA ASURANSI "),
	R_02010400000000 ("02010400000000", "Pendapatan Lain"),
	R_02010500000000 ("02010500000000", "Beban Lain"),
	R_02010600000000 ("02010600000000", "LABA (RUGI) SEBELUM PAJAK "),
	R_02010700000000 ("02010700000000", "Pajak Penghasilan"),
	R_02010800000000 ("02010800000000", "LABA SETELAH PAJAK "),
	R_02010900000000 ("02010900000000", "PENDAPATAN KOMPREHENSIF LAIN "),
	R_02011000000000 ("02011000000000", "JUMLAH KINERJA SELURUH DANA"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2040PosReAsrjs0201 eEnum : ER2040PosReAsrjs0201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2040PosReAsrjs0201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2040PosReAsrjs0201.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010101030000.key,
				R_02010101010000.key + "+" + R_02010101020000.key, 
				"Total Hasil Investasi|Perhitungan Hasil Investasi");
	}

	public static SegmentValidation genValidationPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010101050000.key,
				R_02010101030000.key + "+" + R_02010101040000.key, 
				"Total Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi|Perhitungan Pendapatan Hasil Investasi dan Ujroh Pengelolaan Investasi");
	}

	public static SegmentValidation genValidationKontribusiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010102030000.key,
				R_02010102010000.key + "-" + R_02010102020000.key, 
				"Total Kontribusi Neto|Perhitungan Kontribusi Neto");
	}

	public static SegmentValidation genValidationBebanUmumDanAdministrasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010203000000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 14), 
				"Total Beban Umum dan Administrasi|Perhitungan Beban Umum dan Administrasi");
	}

	public static SegmentValidation genValidationBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010205000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 9, 10, 11, 15 }), 
				"Total Beban Usaha|Perhitungan Beban Usaha");
	}

	public static SegmentValidation genValidationLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010300000000.key,
				R_02010101050000.key + "+" + R_02010102030000.key + "+" + 
						R_02010102040000.key + "-" + R_02010205000000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Perhitungan Laba (Rugi) Usaha Asuransi");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010600000000.key,
				R_02010300000000.key + "+" + R_02010400000000.key + "-" + R_02010500000000.key,
				"Total Laba (Rugi) Sebelum Pajak|Perhitungan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02010800000000.key,
				R_02010600000000.key + "-" + R_02010700000000.key, 
				"Total Laba Setelah Pajak|Perhitungan Laba Setelah Pajak");
	}

	public static SegmentValidation genValidationKinerjaSeluruhDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_02011000000000.key,
				R_02010800000000.key + "+" + R_02010900000000.key, 
				"Total Kinerja Seluruh Dana|Perhitungan Kinerja Seluruh Dana");
	}
}
