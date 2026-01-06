package id.go.ojk.asrus.client.builder.field.rb.reference;

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
public enum ER2032PosRbAsrus1209 implements IObject<KeyValueString> {
	R_12090100000000 ("12090100000000", "1.    SALDO AWAL"),
	R_12090200000000 ("12090200000000", "2.    PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_12090300000000 ("12090300000000", "3.    SALDO AKHIR KAS"),
	R_12090400000000 ("12090400000000", "4.    ARUS KAS DARI AKTIFITAS OPERASI "),
	R_12090401000000 ("12090401000000", "a.    Arus Kas Masuk "),
	R_12090401010000 ("12090401010000", "1)    Kontribusi Para Peserta"),
	R_12090401020000 ("12090401020000", "2)    Lain - Lain"),
	R_12090402000000 ("12090402000000", "b.    Arus Kas Keluar"),
	R_12090402010000 ("12090402010000", "1)    Klaim Dibayar"),
	R_12090402020000 ("12090402020000", "2)    Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_12090402030000 ("12090402030000", "3)    Penarikan/Penebusan Dana Investasi Peserta belum jatuh tempo"),
	R_12090402040000 ("12090402040000", "4) Lain-lain"),
	R_12090500000000 ("12090500000000", "5.    ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_12090501000000 ("12090501000000", "a.    Arus Kas Masuk (1+2+3+4+5+6)"),
	R_12090501010000 ("12090501010000", "1)    Penerimaan Hasil Investasi"),
	R_12090501020000 ("12090501020000", "2)    Pencairan Investasi"),
	R_12090501030000 ("12090501030000", "3)    Lain-lain"),
	R_12090502000000 ("12090502000000", "b.    Arus Kas Keluar (1+2+3+4+5)"),
	R_12090502010000 ("12090502010000", "1)    Penempatan Investasi "),
	R_12090502020000 ("12090502020000", "2)    Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_12090502030000 ("12090502030000", "3)    Pembayaran ujroh/fee kepada Perusahaan"),
	R_12090502040000 ("12090502040000", "4)    Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2032PosRbAsrus1209 eEnum : ER2032PosRbAsrus1209.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2032PosRbAsrus1209.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2032PosRbAsrus1209.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPeningkatanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090200000000.key,
				R_12090400000000.key + "+" + R_12090500000000.key, 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090300000000.key,
				R_12090100000000.key + "+" + R_12090200000000.key, 
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090400000000.key,
				R_12090401000000.key + "-" + R_12090402000000.key, 
				"Total Arus Kas Dari Aktivitas Operasi|Penjumlahan Arus Kas Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090401000000.key,
				R_12090401010000.key + "+" + R_12090401020000.key, 
				"Total Arus Kas Masuk Operasi|Penjumlahan Arus Kas Masuk Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 11), 
				"Total Arus Kas Keluar Operasi|Penjumlahan Arus Kas Keluar Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090500000000.key,
				R_12090501000000.key + "-" + R_12090502000000.key, 
				"Total Arus Kas Dari Aktivitas Investasi|Perhitungan Arus Kas Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 16), 
				"Total Arus Kas Masuk Investasi|Penjumlahan Arus Kas Masuk Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12090502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 21), 
				"Total Arus Kas Keluar Investasi|Penjumlahan Arus Kas Keluar Investasi");
	}
}
