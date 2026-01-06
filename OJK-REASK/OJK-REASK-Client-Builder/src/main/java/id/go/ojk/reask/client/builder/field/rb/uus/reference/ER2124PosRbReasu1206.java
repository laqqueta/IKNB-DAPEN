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
public enum ER2124PosRbReasu1206 implements IObject<KeyValueString> {
	R_12060100000000 ("12060100000000", "1.    SALDO AWAL"),
	R_12060200000000 ("12060200000000", "2.    PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_12060300000000 ("12060300000000", "3.    SALDO AKHIR KAS"),
	R_12060400000000 ("12060400000000", "4.    ARUS KAS DARI AKTIFITAS OPERASI"),
	R_12060401000000 ("12060401000000", "a.    Arus Kas Masuk"),
	R_12060401010000 ("12060401010000", "1)    Kontribusi Para Peserta"),
	R_12060401020000 ("12060401020000", "2)    Klaim Reasuransi Diterima"),
	R_12060401030000 ("12060401030000", "3)    Penerimaan Distribusi Surplus Underwriting Reasuransi"),
	R_12060401040000 ("12060401040000", "4)    Lain - Lain"),
	R_12060402000000 ("12060402000000", "b.    Arus Kas Keluar"),
	R_12060402010000 ("12060402010000", "1)    Klaim Dibayar"),
	R_12060402020000 ("12060402020000", "2)    Pembayaran Distribusi Surplus UW ke Perusahaan"),
	R_12060402030000 ("12060402030000", "3)    Pembayaran Distribusi Surplus UW ke Peserta/Pemegang Polis"),
	R_12060402040000 ("12060402040000", "4)    Pembayaran Ujroh Asuransi"),
	R_12060402050000 ("12060402050000", "5) Kontribusi Reasuransi Dibayar"),
	R_12060402060000 ("12060402060000", "6) Lain-lain"),
	R_12060500000000 ("12060500000000", "5.    ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_12060501000000 ("12060501000000", "a.    Arus Kas Masuk"),
	R_12060501010000 ("12060501010000", "1)    Penerimaan Hasil Investasi"),
	R_12060501020000 ("12060501020000", "2)    Pencairan Investasi"),
	R_12060501030000 ("12060501030000", "3)    Lain-lain"),
	R_12060502000000 ("12060502000000", "b.    Arus Kas Keluar"),
	R_12060502010000 ("12060502010000", "1)    Penempatan Investasi"),
	R_12060502020000 ("12060502020000", "2)    Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_12060502030000 ("12060502030000", "3)    Pembayaran ujroh/fee kepada Perusahaan"),
	R_12060502040000 ("12060502040000", "4)    Lain-lain"),
	R_12060600000000 ("12060600000000", "6.    ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_12060601000000 ("12060601000000", "a.    Arus Kas Masuk"),
	R_12060601010000 ("12060601010000", "1)    Penerimaan Qardh"),
	R_12060601020000 ("12060601020000", "2)    Lain-lain"),
	R_12060602000000 ("12060602000000", "b.    Arus Kas Keluar"),
	R_12060602010000 ("12060602010000", "1)    Pembayaran Qardh"),
	R_12060602020000 ("12060602020000", "2)    Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2124PosRbReasu1206 eEnum : ER2124PosRbReasu1206.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2124PosRbReasu1206.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2124PosRbReasu1206.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPeningkatanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060200000000.key,
				R_12060400000000.key + "+" + R_12060500000000.key + "+" + R_12060600000000.key, 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060300000000.key,
				R_12060100000000.key + "+" + R_12060200000000.key, 
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060400000000.key,
				R_12060401000000.key + "-" + R_12060402000000.key, 
				"Total Arus Kas Dari Aktivitas Operasi|Penjumlahan Arus Kas Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060401000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8), 
				"Total Arus Kas Masuk Operasi|Penjumlahan Arus Kas Masuk Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 15), 
				"Total Arus Kas Keluar Operasi|Penjumlahan Arus Kas Keluar Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060500000000.key,
				R_12060501000000.key + "-" + R_12060502000000.key, 
				"Total Arus Kas Dari Aktivitas Investasi|Perhitungan Arus Kas Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 20), 
				"Total Arus Kas Masuk Investasi|Penjumlahan Arus Kas Masuk Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 25), 
				"Total Arus Kas Keluar Investasi|Penjumlahan Arus Kas Keluar Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060600000000.key,
				R_12060601000000.key + "-" + R_12060602000000.key, 
				"Total Arus Kas Dari Aktivitas Pendanaan|Perhitungan Arus Kas Dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060601000000.key,
				R_12060601010000.key + "+" + R_12060601020000.key, 
				"Total Arus Kas Masuk Pendanaan|Perhitungan Arus Kas Masuk Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12060602000000.key,
				R_12060602010000.key + "+" + R_12060602020000.key, 
				"Total Arus Kas Keluar Pendanaan|Perhitungan Arus Kas Keluar Pendanaan");
	}
}
