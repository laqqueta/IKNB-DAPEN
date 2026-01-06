package id.go.ojk.asrjs.client.builder.field.rb.reference;

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
public enum ER2030PosRbAsrjs1207 implements IObject<KeyValueString> {
	R_12070100000000 ("12070100000000", "1.    SALDO AWAL"),
	R_12070200000000 ("12070200000000", "2.    PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_12070300000000 ("12070300000000", "3.    SALDO AKHIR KAS"),
	R_12070400000000 ("12070400000000", "4.    ARUS KAS DARI AKTIFITAS OPERASI "),
	R_12070401000000 ("12070401000000", "a.    Arus Kas Masuk "),
	R_12070401010000 ("12070401010000", "1)    Ujroh yang diterima"),
	R_12070401020000 ("12070401020000", "2)    Kontribusi Peserta"),
	R_12070401030000 ("12070401030000", "3)    Penerimaan Alokasi Surplus Dana Tabarru'"),
	R_12070401040000 ("12070401040000", "4)    Lain - Lain"),
	R_12070402000000 ("12070402000000", "b.    Arus Kas Keluar"),
	R_12070402010000 ("12070402010000", "1)    Beban Akuisisi"),
	R_12070402020000 ("12070402020000", "2)    Beban Pemasaran"),
	R_12070402030000 ("12070402030000", "3)    Pembayaran Ujroh Reasuransi"),
	R_12070402040000 ("12070402040000", "4) Kontribusi  Reasuransi Dibayar"),
	R_12070402050000 ("12070402050000", "5) Pembayaran Sewa"),
	R_12070402060000 ("12070402060000", "6) Pembayaran Zakat"),
	R_12070402070000 ("12070402070000", "7) Pembayaran Pajak"),
	R_12070402080000 ("12070402080000", "8) Lain-lain"),
	R_12070500000000 ("12070500000000", "5.    ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_12070501000000 ("12070501000000", "a.    Arus Kas Masuk"),
	R_12070501010000 ("12070501010000", "1)    Penerimaan Hasil Investasi"),
	R_12070501020000 ("12070501020000", "2)    Penerimaan Bagi Hasil Investasi Dana Tabaru'"),
	R_12070501030000 ("12070501030000", "3)    Penerimaan Bagi Hasil Investasi Dana Investasi Peserta"),
	R_12070501040000 ("12070501040000", "4)    Pencairan Investasi"),
	R_12070501050000 ("12070501050000", "5)    Penjualan Aktiva Tetap"),
	R_12070501060000 ("12070501060000", "6)    Lain-lain"),
	R_12070502000000 ("12070502000000", "b.    Arus Kas Keluar "),
	R_12070502010000 ("12070502010000", "1)    Penempatan Investasi "),
	R_12070502020000 ("12070502020000", "2)    Pembelian Aktiva Tetap"),
	R_12070502030000 ("12070502030000", "3)    Lain-lain"),
	R_12070600000000 ("12070600000000", "6.    ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_12070601000000 ("12070601000000", "a.    Arus Kas Masuk "),
	R_12070601010000 ("12070601010000", "1)    Setoran Modal/Modal Kerja"),
	R_12070601020000 ("12070601020000", "2)    Pinjaman Subordinasi"),
	R_12070601030000 ("12070601030000", "3)    Lain-lain"),
	R_12070602000000 ("12070602000000", "b.    Arus Kas Keluar"),
	R_12070602010000 ("12070602010000", "1)    Pembayaran Pinjaman Subordinasi"),
	R_12070602020000 ("12070602020000", "2)    Pembayaran Dividen"),
	R_12070602030000 ("12070602030000", "3)    Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2030PosRbAsrjs1207 eEnum : ER2030PosRbAsrjs1207.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2030PosRbAsrjs1207.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2030PosRbAsrjs1207.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPeningkatanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070200000000.key,
				R_12070400000000.key + "+" + R_12070500000000.key + "+" + R_12070600000000.key, 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070300000000.key,
				R_12070100000000.key + "+" + R_12070200000000.key, 
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070400000000.key,
				R_12070401000000.key + "-" + R_12070402000000.key, 
				"Total Arus Kas Dari Aktivitas Operasi|Penjumlahan Arus Kas Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070401000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8), 
				"Total Arus Kas Masuk Operasi|Penjumlahan Arus Kas Masuk Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 17), 
				"Total Arus Kas Keluar Operasi|Penjumlahan Arus Kas Keluar Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070500000000.key,
				R_12070501000000.key + "-" + R_12070502000000.key, 
				"Total Arus Kas Dari Aktivitas Investasi|Perhitungan Arus Kas Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 25), 
				"Total Arus Kas Masuk Investasi|Penjumlahan Arus Kas Masuk Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 29), 
				"Total Arus Kas Keluar Investasi|Penjumlahan Arus Kas Keluar Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070600000000.key,
				R_12070601000000.key + "-" + R_12070602000000.key, 
				"Total Arus Kas Dari Aktivitas Pendanaan|Perhitungan Arus Kas Dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070601000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 34), 
				"Total Arus Kas Masuk Pendanaan|Perhitungan Arus Kas Masuk Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12070602000000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 38), 
				"Total Arus Kas Keluar Pendanaan|Perhitungan Arus Kas Keluar Pendanaan");
	}
}
