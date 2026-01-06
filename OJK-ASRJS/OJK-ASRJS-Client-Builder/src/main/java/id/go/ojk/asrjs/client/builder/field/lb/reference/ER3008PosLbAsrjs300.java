package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3008PosLbAsrjs300 implements IObject<KeyValueString> {
	R_3001010000 ("3001010000", "SALDO AWAL"),
	R_3001010001 ("3001010001", "PENINGKATAN (PENURUNAN) SALDO KAS"),
	R_3001010002 ("3001010002", "SALDO AKHIR KAS"),
	R_3001010003 ("3001010003", "ARUS KAS DARI AKTIFITAS OPERASI"),
	R_3001010004 ("3001010004", "a. Arus Kas Masuk"),
	R_3001010005 ("3001010005", "Kontribusi Para Peserta"),
	R_3001010006 ("3001010006", "Ujroh yang diterima"),
	R_3001010007 ("3001010007", "Penerimaan Alokasi Surplus Dana Tabarru'"),
	R_3001010008 ("3001010008", "Klaim Reasuransi Diterima"),
	R_3001010009 ("3001010009", "Penerimaan Distribusi Surplus Underwriting Reasuransi"),
	R_3001010010 ("3001010010", "Lain - Lain"),
	R_3001010011 ("3001010011", "b. Arus Kas Keluar"),
	R_3001010012 ("3001010012", "Klaim Dibayar"),
	R_3001010013 ("3001010013", "Penarikan Dana Investasi Peserta yang telah jatuh tempo"),
	R_3001010014 ("3001010014", "Penarikan/Penebusan Dana Investasi Peserta belum jatuh tempo"),
	R_3001010015 ("3001010015", "Pembayaran Distribusi Surplus UW ke Perusahaan"),
	R_3001010016 ("3001010016", "Pembayaran Distribusi Surplus UW ke Peserta/Pemegang Polis"),
	R_3001010017 ("3001010017", "Beban Akuisisi"),
	R_3001010018 ("3001010018", "Beban Pemasaran"),
	R_3001010019 ("3001010019", "Pembayaran Ujroh Reasuransi"),
	R_3001010020 ("3001010020", "Pembayaran Ujroh Asuransi"),
	R_3001010021 ("3001010021", "Kontribusi  Reasuransi Dibayar"),
	R_3001010022 ("3001010022", "Pembayaran Sewa"),
	R_3001010023 ("3001010023", "Pembayaran Zakat"),
	R_3001010024 ("3001010024", "Pembayaran Pajak"),
	R_3001010025 ("3001010025", "Lain-lain"),
	R_3001010026 ("3001010026", "ARUS KAS DARI AKTIFITAS INVESTASI"),
	R_3001010027 ("3001010027", "a. Arus Kas Masuk"),
	R_3001010028 ("3001010028", "Penerimaan Hasil Investasi "),
	R_3001010029 ("3001010029", "Penerimaan Bagi Hasil Investasi Dana Tabaru'"),
	R_3001010030 ("3001010030", "Penerimaan Bagi Hasil Investasi Dana Investasi Peserta"),
	R_3001010031 ("3001010031", "Pencairan Investasi"),
	R_3001010032 ("3001010032", "Penjualan Aktiva Tetap"),
	R_3001010033 ("3001010033", "Lain-lain"),
	R_3001010034 ("3001010034", "b. Arus Kas Keluar"),
	R_3001010035 ("3001010035", "Penempatan Investasi "),
	R_3001010036 ("3001010036", "Hasil Investasi Yang Dibagikan ke Dana Perusahaan"),
	R_3001010037 ("3001010037", "Pembayaran ujroh/fee kepada Perusahaan"),
	R_3001010038 ("3001010038", "Pembelian Aktiva Tetap"),
	R_3001010039 ("3001010039", "Lain-lain"),
	R_3001010040 ("3001010040", "ARUS KAS DARI AKTIFITAS PENDANAAN"),
	R_3001010041 ("3001010041", "a. Arus Kas Masuk"),
	R_3001010042 ("3001010042", "Setoran Modal/Modal Kerja"),
	R_3001010043 ("3001010043", "Pinjaman Subordinasi"),
	R_3001010044 ("3001010044", "Penerimaan Qardh "),
	R_3001010045 ("3001010045", "Lain-lain"),
	R_3001010046 ("3001010046", "b. Arus Kas Keluar"),
	R_3001010047 ("3001010047", "Pembayaran Pinjaman Subordinasi"),
	R_3001010048 ("3001010048", "Pembayaran Dividen"),
	R_3001010049 ("3001010049", "Pembayaran Qardh "),
	R_3001010050 ("3001010050", "Lain-lain"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3008PosLbAsrjs300 eEnum : ER3008PosLbAsrjs300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 8, 9, 12, 13, 14, 15, 16, 20, 36, 37, 44, 49 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 6, 7, 13, 14, 17, 18, 19, 22, 23, 24, 29, 30, 32, 38, 42, 43, 47, 48 }));
	}
	
	public static ConditionalRequired genConditional4() {
		return genConditional3();
	}
	
	public static ConditionalRequired genConditional5() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 6, 7, 8, 9, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 29, 30, 32, 38, 42, 43, 44, 47, 48, 49 }));
	}
	
	public static ConditionalRequired genConditional6() {
		return genConditional5();
	}
	
	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 6), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1, 2, 3, 4, 11, 26, 27, 34, 40, 41, 46 }));
	}
	
	public static SegmentValidation genValidationPeningkatanPenurunanSaldoKas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 26, 40 }), 
				"Total Peningkatan (Penurunan) Saldo Kas|Penjumlahan Peningkatan (Penurunan) Saldo Kas");
	}

	public static SegmentValidation genValidationSaldoAkhirKas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010002.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1),
				"Total Saldo Akhir Kas|Penjumlahan Saldo Akhir Kas");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010003.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 4, 11 }),
				"Total Arus Kas Dari Aktivitas Operasi|Perhitungan Arus Kas Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010004.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 10),
				"Total Arus Kas Masuk Dari Aktivitas Operasi|Penjumlahan Arus Kas Masuk Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarDariAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010011.key, 
				UtilMetadata.genPlusRow(getObjects(), 12, 25),
				"Total Arus Kas Keluar Dari Aktivitas Operasi|Penjumlahan Arus Kas Keluar Dari Aktivitas Operasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010026.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 27, 34 }),
				"Total Arus Kas Dari Aktivitas Investasi|Perhitungan Arus Kas Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010027.key, 
				UtilMetadata.genPlusRow(getObjects(), 28, 33),
				"Total Arus Kas Masuk Dari Aktivitas Investasi|Penjumlahan Arus Kas Masuk Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarDariAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010034.key, 
				UtilMetadata.genPlusRow(getObjects(), 35, 39),
				"Total Arus Kas Keluar Dari Aktivitas Investasi|Penjumlahan Arus Kas Keluar Dari Aktivitas Investasi");
	}

	public static SegmentValidation genValidationArusKasDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010040.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 41, 46 }),
				"Total Arus Kas Dari Aktivitas Pendanaan|Perhitungan Arus Kas Dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010041.key, 
				UtilMetadata.genPlusRow(getObjects(), 42, 45),
				"Total Arus Kas Masuk Dari Aktivitas Pendanaan|Penjumlahan Arus Kas Masuk Dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_3001010046.key, 
				UtilMetadata.genPlusRow(getObjects(), 47, 50),
				"Total Arus Kas Keluar Dari Aktivitas Pendanaan|Penjumlahan Arus Kas Keluar Dari Aktivitas Pendanaan");
	}
}
