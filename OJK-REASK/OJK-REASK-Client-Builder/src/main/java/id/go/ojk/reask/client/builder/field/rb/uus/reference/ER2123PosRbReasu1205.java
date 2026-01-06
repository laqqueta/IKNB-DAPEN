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
public enum ER2123PosRbReasu1205 implements IObject<KeyValueString> {
	R_12050100000000 ("12050100000000", "1.    SALDO AWAL"),
	R_12050200000000 ("12050200000000", "2.    PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_12050300000000 ("12050300000000", "3.    SALDO AKHIR KAS"),
	R_12050400000000 ("12050400000000", "4.    ARUS KAS DARI AKTIFITAS OPERASI"),
	R_12050401000000 ("12050401000000", "a.    Arus Kas Masuk"),
	R_12050401010000 ("12050401010000", "1)    Ujroh yang diterima"),
	R_12050401020000 ("12050401020000", "2) Kontribusi Peserta"),
	R_12050401030000 ("12050401030000", "3)    Penerimaan Alokasi Surplus Dana Tabarru'"),
	R_12050401040000 ("12050401040000", "4)    Lain - Lain"),
	R_12050402000000 ("12050402000000", "b.    Arus Kas Keluar"),
	R_12050402010000 ("12050402010000", "1)    Beban Akuisisi"),
	R_12050402020000 ("12050402020000", "2)    Beban Pemasaran"),
	R_12050402030000 ("12050402030000", "3)    Pembayaran Ujroh Reasuransi"),
	R_12050402040000 ("12050402040000", "4) Kontribusi Reasuransi Dibayar"),
	R_12050402050000 ("12050402050000", "5) Pembayaran Sewa"),
	R_12050402060000 ("12050402060000", "6) Pembayaran Zakat"),
	R_12050402070000 ("12050402070000", "7) Pembayaran Pajak"),
	R_12050402080000 ("12050402080000", "8) Lain-lain"),
	R_12050500000000 ("12050500000000", "5.    ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_12050501000000 ("12050501000000", "a.    Arus Kas Masuk"),
	R_12050501010000 ("12050501010000", "1)    Penerimaan Hasil Investasi"),
	R_12050501020000 ("12050501020000", "2)    Penerimaan Bagi Hasil Investasi Dana Tabaru'"),
	R_12050501030000 ("12050501030000", "3)    Penerimaan Bagi Hasil Investasi Dana Investasi Peserta"),
	R_12050501040000 ("12050501040000", "4)    Pencairan Investasi"),
	R_12050501050000 ("12050501050000", "5)    Penjualan Aktiva Tetap"),
	R_12050501060000 ("12050501060000", "6)    Lain-lain"),
	R_12050502000000 ("12050502000000", "b.    Arus Kas Keluar"),
	R_12050502010000 ("12050502010000", "1)    Penempatan Investasi"),
	R_12050502020000 ("12050502020000", "2)    Pembelian Aktiva Tetap"),
	R_12050502030000 ("12050502030000", "3)    Lain-lain"),
	R_12050600000000 ("12050600000000", "6.    ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_12050601000000 ("12050601000000", "a.    Arus Kas Masuk"),
	R_12050601010000 ("12050601010000", "1)    Setoran Modal/Modal Kerja"),
	R_12050601020000 ("12050601020000", "2)    Pinjaman Subordinasi"),
	R_12050601030000 ("12050601030000", "3)    Lain-lain"),
	R_12050602000000 ("12050602000000", "b.    Arus Kas Keluar"),
	R_12050602010000 ("12050602010000", "1)    Pembayaran Pinjaman Subordinasi"),
	R_12050602020000 ("12050602020000", "2)    Pembayaran Dividen"),
	R_12050602030000 ("12050602030000", "3)    Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2123PosRbReasu1205 eEnum : ER2123PosRbReasu1205.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2123PosRbReasu1205.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2123PosRbReasu1205.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPeningkatanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050200000000.key,
				R_12050400000000.key + "+" + R_12050500000000.key + "+" + R_12050600000000.key, 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050300000000.key,
				R_12050100000000.key + "+" + R_12050200000000.key, 
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050400000000.key,
				R_12050401000000.key + "-" + R_12050402000000.key, 
				"Total Arus Kas Dari Aktivitas Operasi|Penjumlahan Arus Kas Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050401000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8), 
				"Total Arus Kas Masuk Operasi|Penjumlahan Arus Kas Masuk Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 17), 
				"Total Arus Kas Keluar Operasi|Penjumlahan Arus Kas Keluar Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050500000000.key,
				R_12050501000000.key + "-" + R_12050502000000.key, 
				"Total Arus Kas Dari Aktivitas Investasi|Perhitungan Arus Kas Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 25), 
				"Total Arus Kas Masuk Investasi|Penjumlahan Arus Kas Masuk Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 29), 
				"Total Arus Kas Keluar Investasi|Penjumlahan Arus Kas Keluar Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050600000000.key,
				R_12050601000000.key + "-" + R_12050602000000.key, 
				"Total Arus Kas Dari Aktivitas Pendanaan|Perhitungan Arus Kas Dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050601000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 34), 
				"Total Arus Kas Masuk Pendanaan|Perhitungan Arus Kas Masuk Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12050602000000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 38), 
				"Total Arus Kas Keluar Pendanaan|Perhitungan Arus Kas Keluar Pendanaan");
	}
}
