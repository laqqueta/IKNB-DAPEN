package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2145PosReAsruu0303 implements IObject<KeyValueString> {
	R_03030100000000 ("03030100000000", "1. SALDO AWAL"),
	R_03030200000000 ("03030200000000", "2. PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_03030300000000 ("03030300000000", "3. SALDO AKHIR KAS"),
	R_03030400000000 ("03030400000000", "4. ARUS KAS DARI AKTIFITAS OPERASI "),
	R_03030401000000 ("03030401000000", "a. Arus Kas Masuk "),
	R_03030401010000 ("03030401010000", "1) Kontribusi Para Peserta"),
	R_03030401020000 ("03030401020000", "2) Lain - Lain"),
	R_03030402000000 ("03030402000000", "b. Arus Kas Keluar"),
	R_03030402010000 ("03030402010000", "1) Klaim Dibayar"),
	R_03030402020000 ("03030402020000", "2) Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_03030402030000 ("03030402030000", "3) Penarikan/Penebusan Dana Investasi Peserta belum jatuh tempo"),
	R_03030402040000 ("03030402040000", "4) Lain-lain"),
	R_03030500000000 ("03030500000000", "5. ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_03030501000000 ("03030501000000", "a. Arus Kas Masuk (1+2+3+4+5+6)"),
	R_03030501010000 ("03030501010000", "1) Penerimaan Hasil Investasi"),
	R_03030501020000 ("03030501020000", "2) Pencairan Investasi"),
	R_03030501030000 ("03030501030000", "3) Lain-lain"),
	R_03030502000000 ("03030502000000", "b. Arus Kas Keluar (1+2+3+4+5)"),
	R_03030502010000 ("03030502010000", "1) Penempatan Investasi "),
	R_03030502020000 ("03030502020000", "2) Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_03030502030000 ("03030502030000", "3) Pembayaran ujroh/fee kepada Perusahaan"),
	R_03030502040000 ("03030502040000", "4) Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2145PosReAsruu0303 eEnum : ER2145PosReAsruu0303.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2145PosReAsruu0303.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2145PosReAsruu0303.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030200000000.key,
				R_03030400000000.key + "+" + R_03030500000000.key, 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030300000000.key,
				R_03030100000000.key + "+" + R_03030200000000.key, 
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030400000000.key,
				R_03030401000000.key + "-" + R_03030402000000.key, 
				"Total Arus Kas Dari Aktifitas Operasi|Perhitungan Arus Kas Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030401000000.key,
				R_03030401010000.key + "+" + R_03030401020000.key, 
				"Total Arus Kas Masuk Dari Aktifitas Operasi|Penjumlahan Arus Kas Masuk Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 11),
				"Total Arus Kas Keluar Dari Aktifitas Operasi|Penjumlahan Arus Kas Keluar Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030500000000.key,
				R_03030501000000.key + "-" + R_03030502000000.key, 
				"Total Arus Kas Dari Aktifitas Investasi|Perhitungan Arus Kas Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 16),
				"Total Arus Kas Masuk Dari Aktifitas Investasi|Penjumlahan Arus Kas Masuk Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03030502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 21),
				"Total Arus Kas Keluar Dari Aktifitas Investasi|Penjumlahan Arus Kas Keluar Dari Aktifitas Investasi");
	}
}
