package id.go.ojk.asruk.client.builder.field.rb.reference;

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
public enum ER2016PosRbAsruk1307 implements IObject<KeyValueString> {
	R_1501010000 ("1501010000", "SALDO AWAL KAS DAN BANK"),
//	R_1501020000 ("1501020000", "ARUS KAS DARI AKTIVITAS OPERASI"),
//	R_1501020198 ("1501020198", "Arus Kas Masuk"),
	R_1501020101 ("1501020101", "a. Premi "),
	R_1501020102 ("1501020102", "b. Klaim Koasuransi"),
	R_1501020103 ("1501020103", "c. Klaim Reasuransi"),
	R_1501020104 ("1501020104", "d. Komisi"),
	R_1501020105 ("1501020105", "e. Piutang"),
	R_1501020199 ("1501020199", "f. Lain-lain"),
	R_1501020100 ("1501020100", "Jumlah Arus Kas Masuk"),
//	R_1501020298 ("1501020298", "Arus Kas Keluar"),
	R_1501020201 ("1501020201", "a. Premi Reasuransi"),
	R_1501020202 ("1501020202", "b. Klaim"),
	R_1501020203 ("1501020203", "c. Komisi"),
	R_1501020204 ("1501020204", "d. Biaya-biaya"),
	R_1501020299 ("1501020299", "e. Lain-lain"),
	R_1501020200 ("1501020200", "Jumlah Arus Kas Keluar"),
	R_1501020000 ("1501020000", "JUMLAH ARUS KAS DARI AKTIVITAS OPERASI"),
//	R_1501030099 ("1501030099", "ARUS KAS DARI AKTIVITAS INVESTASI"),
//	R_1501030198 ("1501030198", "Arus Kas Masuk"),
	R_1501030101 ("1501030101", "a. Penerimaan Hasil Investasi"),
	R_1501030102 ("1501030102", "b. Pencairan Investasi"),
	R_1501030103 ("1501030103", "c. Penjualan Aset Tetap"),
	R_1501030199 ("1501030199", "d. Lain-lain"),
	R_1501030100 ("1501030100", "Jumlah Arus Kas Masuk"),
//	R_1501030298 ("1501030298", "Arus Kas Keluar"),
	R_1501030201 ("1501030201", "a. Penempatan Investasi"),
	R_1501030202 ("1501030202", "b. Pembelian Aset Tetap"),
	R_1501030299 ("1501030299", "c. Lain-lain"),
	R_1501030200 ("1501030200", "Jumlah Arus Kas Keluar"),
	R_1501030000 ("1501030000", "JUMLAH ARUS KAS DARI AKTIVITAS INVESTASI"),
//	R_1501040099 ("1501040099", "ARUS KAS DARI AKTIVITAS PENDANAAN"),
//	R_1501040198 ("1501040198", "Arus Kas Masuk"),
	R_1501040101 ("1501040101", "a. Pinjaman Subordinasi"),
	R_1501040102 ("1501040102", "b. Setoran Modal"),
	R_1501040199 ("1501040199", "c. Lain-lain"),
	R_1501040100 ("1501040100", "Jumlah Arus Kas Masuk"),
//	R_1501040298 ("1501040298", "Arus Kas Keluar"),
	R_1501040201 ("1501040201", "a. Pembayaran Dividen"),
	R_1501040202 ("1501040202", "b. Pembayaran Pinjaman Subordinasi"),
	R_1501040299 ("1501040299", "c. Lain-lain"),
	R_1501040200 ("1501040200", "Jumlah Arus Kas Keluar"),
	R_1501040000 ("1501040000", "JUMLAH ARUS KAS DARI AKTIVITAS PENDANAAN"),
	R_1501000000 ("1501000000", "SALDO AKHIR KAS DAN BANK"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2016PosRbAsruk1307 eEnum : ER2016PosRbAsruk1307.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2016PosRbAsruk1307.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2016PosRbAsruk1307.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidasiArusKasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501030000.key, 
				R_1501030100.key + "-" + R_1501030200.key, 
				"Total Arus Kas Investasi|Penjumlahan Arus Kas Investasi");
	}

	public static SegmentValidation genValidasiArusKasInvestasiKeluar() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501030200.key, 
				UtilMetadata.genPlusRow(getObjects(), 20, 22), 
				"Total Arus Kas Investasi Keluar|Penjumlahan Arus Kas Investasi Keluar");
	}
	
	public static SegmentValidation genValidasiArusKasInvestasiMasuk() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501030100.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 18), 
				"Total Arus Kas Investasi Masuk|Penjumlahan Arus Kas Investasi Masuk");
	}

	public static SegmentValidation genValidasiArusKasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501020000.key, 
				R_1501020100.key + "-" + R_1501020200.key, 
				"Total Arus Kas Operasi|Penjumlahan Arus Kas Operasi");
	}
	
	public static SegmentValidation genValidasiArusKasOperasiKeluar() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501020200.key, 
				UtilMetadata.genPlusRow(getObjects(), 8, 12), 
				"Total Arus Kas Operasi Keluar|Penjumlahan Arus Kas Operasi Keluar");
	}
	
	public static SegmentValidation genValidasiArusKasOperasiMasuk() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501020100.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 6), 
				"Total Arus Kas Operasi Masuk|Penjumlahan Arus Kas Operasi Masuk");
	}

	public static SegmentValidation genValidasiArusKasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501040000.key, 
				R_1501040100.key + "-" + R_1501040200.key, 
				"Total Arus Kas Pendanaan|Penjumlahan Arus Kas Pendanaan");
	}
	
	public static SegmentValidation genValidasiArusKasPendanaanKeluar() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501040200.key, 
				UtilMetadata.genPlusRow(getObjects(), 29, 31), 
				"Total Arus Kas Pendanaan Keluar|Penjumlahan Arus Kas Pendanaan Keluar");
	}

	public static SegmentValidation genValidasiArusKasPendanaanMasuk() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501040100.key, 
				UtilMetadata.genPlusRow(getObjects(), 25, 27), 
				"Total Arus Kas Pendanaan Masuk|Penjumlahan Arus Kas Pendanaan Masuk");
	}
	
	public static SegmentValidation genValidasiSaldoAkhir() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1501000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 14, 24, 33 }), 
				"Total Saldo Akhir|Penjumlahan Saldo Akhir");
	}
}
