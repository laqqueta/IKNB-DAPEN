package id.go.ojk.reask.client.builder.field.rb.uus.reference;

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
public enum ER2132PosReReasu0301 implements IObject<KeyValueString> {
	R_03010100000000 ("03010100000000", "1. SALDO AWAL"),
	R_03010200000000 ("03010200000000", "2. PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_03010300000000 ("03010300000000", "3. SALDO AKHIR KAS"),
	R_03010400000000 ("03010400000000", "4. ARUS KAS DARI AKTIFITAS OPERASI "),
	R_03010401000000 ("03010401000000", "a. Arus Kas Masuk "),
	R_03010401010000 ("03010401010000", "1) Ujroh yang diterima"),
	R_03010401020000 ("03010401020000", "2)    Kontribusi Peserta"),
	R_03010401030000 ("03010401030000", "3) Penerimaan Alokasi Surplus Dana Tabarru'"),
	R_03010401040000 ("03010401040000", "4) Lain - Lain"),
	R_03010402000000 ("03010402000000", "b. Arus Kas Keluar"),
	R_03010402010000 ("03010402010000", "1) Beban Akuisisi"),
	R_03010402020000 ("03010402020000", "2) Beban Pemasaran"),
	R_03010402030000 ("03010402030000", "3) Pembayaran Ujroh Reasuransi"),
	R_03010402040000 ("03010402040000", "4) Kontribusi  Reasuransi Dibayar"),
	R_03010402050000 ("03010402050000", "5) Pembayaran Sewa"),
	R_03010402060000 ("03010402060000", "6) Pembayaran Zakat"),
	R_03010402070000 ("03010402070000", "7) Pembayaran Pajak"),
	R_03010402080000 ("03010402080000", "8) Lain-lain"),
	R_03010500000000 ("03010500000000", "5. ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_03010501000000 ("03010501000000", "a. Arus Kas Masuk"),
	R_03010501010000 ("03010501010000", "1) Penerimaan Hasil Investasi"),
	R_03010501020000 ("03010501020000", "2) Penerimaan Bagi Hasil Investasi Dana Tabaru'"),
	R_03010501030000 ("03010501030000", "3) Penerimaan Bagi Hasil Investasi Dana Investasi Peserta"),
	R_03010501040000 ("03010501040000", "4) Pencairan Investasi"),
	R_03010501050000 ("03010501050000", "5) Penjualan Aktiva Tetap"),
	R_03010501060000 ("03010501060000", "6) Lain-lain"),
	R_03010502000000 ("03010502000000", "b. Arus Kas Keluar "),
	R_03010502010000 ("03010502010000", "1) Penempatan Investasi "),
	R_03010502020000 ("03010502020000", "2) Pembelian Aktiva Tetap"),
	R_03010502030000 ("03010502030000", "3) Lain-lain"),
	R_03010600000000 ("03010600000000", "6. ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_03010601000000 ("03010601000000", "a. Arus Kas Masuk "),
	R_03010601010000 ("03010601010000", "1) Setoran Modal/Modal Kerja"),
	R_03010601020000 ("03010601020000", "2) Pinjaman Subordinasi"),
	R_03010601030000 ("03010601030000", "3) Lain-lain"),
	R_03010602000000 ("03010602000000", "b. Arus Kas Keluar"),
	R_03010602010000 ("03010602010000", "1) Pembayaran Pinjaman Subordinasi"),
	R_03010602020000 ("03010602020000", "2) Pembayaran Dividen"),
	R_03010602030000 ("03010602030000", "3) Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2132PosReReasu0301 eEnum : ER2132PosReReasu0301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2132PosReReasu0301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2132PosReReasu0301.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationPeningkatanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 18, 30}), 
				"Total Peningkatan (Penurunan) Saldo Kas|Perhitungan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010300000000.key,
				R_03010100000000.key + "+" + R_03010200000000.key, 
				"Total Saldo Akhir Kas|Perhitungan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010400000000.key,
				R_03010401000000.key + "-" + R_03010402000000.key, 
				"Total Arus Kas Dari Aktifitas Operasi|Perhitungan Arus Kas Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010401000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8),
				"Total Arus Kas Masuk Dari Aktifitas Operasi|Perhitungan Arus Kas Masuk Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 17),
				"Total Arus Kas Keluar Dari Aktifitas Operasi|Perhitungan Arus Kas Keluar Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010500000000.key,
				R_03010501000000.key + "-" + R_03010502000000.key, 
				"Total Arus Kas Dari Aktifitas Investasi|Perhitungan Arus Kas Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 25),
				"Total Arus Kas Masuk Dari Aktifitas Investasi|Perhitungan Arus Kas Masuk Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 29),
				"Total Arus Kas Keluar Dari Aktifitas Investasi|Perhitungan Arus Kas Keluar Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010600000000.key,
				R_03010601000000.key + "-" + R_03010602000000.key, 
				"Total Arus Kas Dari Aktifitas Pendanaan|Perhitungan Arus Kas Dari Aktifitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010601000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 34),
				"Total Arus Kas Masuk Dari Aktifitas Pendanaan|Perhitungan Arus Kas Masuk Dari Aktifitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03010602000000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 38),
				"Total Arus Kas Keluar Dari Aktifitas Pendanaan|Perhitungan Arus Kas Keluar Dari Aktifitas Pendanaan");
	}
}
