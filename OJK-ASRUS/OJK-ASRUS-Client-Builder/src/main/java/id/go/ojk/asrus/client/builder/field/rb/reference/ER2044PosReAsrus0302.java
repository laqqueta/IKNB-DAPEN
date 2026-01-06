package id.go.ojk.asrus.client.builder.field.rb.reference;

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
public enum ER2044PosReAsrus0302 implements IObject<KeyValueString> {
	R_03020100000000 ("03020100000000", "1.    SALDO AWAL"),
	R_03020200000000 ("03020200000000", "2.    PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_03020300000000 ("03020300000000", "3.    SALDO AKHIR KAS"),
	R_03020400000000 ("03020400000000", "4.    ARUS KAS DARI AKTIFITAS OPERASI "),
	R_03020401000000 ("03020401000000", "a.    Arus Kas Masuk "),
	R_03020401010000 ("03020401010000", "1)    Kontribusi Para Peserta"),
	R_03020401020000 ("03020401020000", "2)    Klaim Reasuransi Diterima"),
	R_03020401030000 ("03020401030000", "3)    Penerimaan Distribusi Surplus Underwriting Reasuransi"),
	R_03020401040000 ("03020401040000", "4)    Lain - Lain"),
	R_03020402000000 ("03020402000000", "b.    Arus Kas Keluar"),
	R_03020402010000 ("03020402010000", "1)    Klaim Dibayar"),
	R_03020402020000 ("03020402020000", "2)    Pembayaran Distribusi Surplus UW ke Perusahaan"),
	R_03020402030000 ("03020402030000", "3)    Pembayaran Distribusi Surplus UW ke Peserta/Pemegang Polis"),
	R_03020402040000 ("03020402040000", "4)    Pembayaran Ujroh Asuransi"),
	R_03020402050000 ("03020402050000", "5) Kontribusi  Reasuransi Dibayar"),
	R_03020402060000 ("03020402060000", "6) Lain-lain"),
	R_03020500000000 ("03020500000000", "5.    ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_03020501000000 ("03020501000000", "a.    Arus Kas Masuk"),
	R_03020501010000 ("03020501010000", "1)    Penerimaan Hasil Investasi"),
	R_03020501020000 ("03020501020000", "2)    Pencairan Investasi"),
	R_03020501030000 ("03020501030000", "3)    Lain-lain"),
	R_03020502000000 ("03020502000000", "b.    Arus Kas Keluar"),
	R_03020502010000 ("03020502010000", "1)    Penempatan Investasi "),
	R_03020502020000 ("03020502020000", "2)    Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_03020502030000 ("03020502030000", "3)    Pembayaran ujroh/fee kepada Perusahaan"),
	R_03020502040000 ("03020502040000", "4)    Lain-lain"),
	R_03020600000000 ("03020600000000", "6.    ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_03020601000000 ("03020601000000", "a.    Arus Kas Masuk"),
	R_03020601010000 ("03020601010000", "1)    Penerimaan Qardh"),
	R_03020601020000 ("03020601020000", "2)    Lain-lain"),
	R_03020602000000 ("03020602000000", "b.    Arus Kas Keluar"),
	R_03020602010000 ("03020602010000", "1)    Pembayaran Qardh"),
	R_03020602020000 ("03020602020000", "2)    Lain-lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2044PosReAsrus0302 eEnum : ER2044PosReAsrus0302.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2044PosReAsrus0302.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2044PosReAsrus0302.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 16, 26}), 
				"Total Peningkatan (Penurunan) Saldo Kas|Perhitungan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020300000000.key,
				R_03020100000000.key + "+" + R_03020200000000.key, 
				"Total Saldo Akhir Kas|Perhitungan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020400000000.key,
				R_03020401000000.key + "-" + R_03020402000000.key, 
				"Total Arus Kas Dari Aktifitas Operasi|Perhitungan Arus Kas Dari Aktifitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020401000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 8),
				"Total Arus Kas Masuk Operasi|Perhitungan Arus Kas Masuk Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020402000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 15),
				"Total Arus Kas Keluar Operasi|Perhitungan Arus Kas Keluar Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020500000000.key,
				R_03020501000000.key + "-" + R_03020502000000.key, 
				"Total Arus Kas Dari Aktifitas Investasi|Perhitungan Arus Kas Dari Aktifitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020501000000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 20),
				"Total Arus Kas Masuk Investasi|Perhitungan Arus Kas Masuk Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020502000000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 25),
				"Total Arus Kas Keluar Investasi|Perhitungan Arus Kas Keluar Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktifitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020600000000.key,
				R_03020601000000.key + "-" + R_03020602000000.key, 
				"Total Arus Kas Dari Aktifitas Pendanaan|Perhitungan Arus Kas Dari Aktifitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020601000000.key,
				R_03020601010000.key + "+" + R_03020601020000.key, 
				"Total Arus Kas Masuk Pendanaan|Perhitungan Arus Kas Masuk Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_03020602000000.key,
				R_03020602010000.key + "+" + R_03020602020000.key, 
				"Total Arus Kas Keluar Pendanaan|Perhitungan Arus Kas Keluar Pendanaan");
	}
}
