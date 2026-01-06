package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3007PosLbAsrjk300 implements IObject<KeyValueString> {
	R_1501010000 ("1501010000", "SALDO AWAL KAS DAN BANK"),
//	R_1501020099 ("1501020099", "ARUS KAS DARI AKTIVITAS OPERASI"),
//	R_1501020198 ("1501020198", "Arus Kas Masuk"),
	R_1501020101 ("1501020101", "a. Premi"),
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
	R_1501020200 ("1501020200", "Jumlah Arus Kas Keluar -/-"),
	R_1501020000 ("1501020000", "JUMLAH ARUS KAS DARI AKTIVITAS OPERASI"),
//	R_1501030099 ("1501030099", "ARUS KAS DARI AKTIVITAS INVESTASI"),
//	R_1501030198 ("1501030198", "Arus Kas Masuk"),
	R_1501030101 ("1501030101", "a. Penerimaan Hasil Investasi"),
	R_1501030102 ("1501030102", "b. Pencairan Investasi"),
	R_1501030103 ("1501030103", "c. Penjualan Aset Tetap"),
	R_1501030199 ("1501030199", "d. Lain-lain"),
	R_1501030100 ("1501030100", " Jumlah Arus Kas Masuk"),
//	R_1501030298 ("1501030298", "Arus Kas Keluar"),
	R_1501030201 ("1501030201", "a. Penempatan Investasi"),
	R_1501030202 ("1501030202", "b. Pembelian Aset Tetap"),
	R_1501030299 ("1501030299", "c. Lain-lain"),
	R_1501030200 ("1501030200", "Jumlah Arus Kas Keluar -/-"),
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
	R_1501040200 ("1501040200", "Jumlah Arus Kas Keluar -/-"),
	R_1501040000 ("1501040000", "JUMLAH ARUS KAS DARI AKTIVITAS PENDANAAN"),
	R_1501000000 ("1501000000", "SALDO AKHIR KAS DAN BANK"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3007PosLbAsrjk300 eEnum : ER3007PosLbAsrjk300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3007PosLbAsrjk300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3007PosLbAsrjk300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genValidationSaldoAwalEqualAkhir() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_1501010000.key, "3", R_1501000000.key, 
				"Saldo awal kas dan bank tahun berjalan|Saldo akhir kas dan bank tahun sebelumnya");
	}

	public static SegmentValidation genValidationArusKasMasukAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501020100.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 6),
				"Total arus kas masuk dari aktivitas operasi|Penjumlahan arus kas masuk dari aktivitas operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501020200.key, 
				UtilMetadata.genPlusRow(getObjects(), 8, 12),
				"Total arus kas keluar dari aktivitas operasi|Penjumlahan arus kas keluar dari aktivitas operasi");
	}

	public static SegmentValidation genValidationArusKasAktivitasOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501020000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 7, 13 }),
				"Total arus kas dari aktivitas operasi|Perhitungan arus kas dari aktivitas operasi");
	}

	public static SegmentValidation genValidationArusKasMasukAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501030100.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 18),
				"Total arus kas masuk dari aktivitas investasi|Penjumlahan arus kas masuk dari aktivitas investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501030200.key, 
				UtilMetadata.genPlusRow(getObjects(), 20, 22),
				"Total arus kas keluar dari aktivitas investasi|Penjumlahan arus kas keluar dari aktivitas investasi");
	}

	public static SegmentValidation genValidationArusKasAktivitasInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501030000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 19, 23 }),
				"Total arus kas dari aktivitas investasi|Perhitungan arus kas dari aktivitas investasi");
	}

	public static SegmentValidation genValidationArusKasMasukAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501040100.key, 
				UtilMetadata.genPlusRow(getObjects(), 25, 27),
				"Total arus kas masuk dari aktivitas pendanaan|Penjumlahan arus kas masuk dari aktivitas pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501040200.key, 
				UtilMetadata.genPlusRow(getObjects(), 29, 31),
				"Total arus kas keluar dari aktivitas pendanaan|Penjumlahan arus kas keluar dari aktivitas pendanaan");
	}

	public static SegmentValidation genValidationArusKasAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501040000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 28, 32 }),
				"Total arus kas dari aktivitas pendanaan|Perhitungan arus kas dari aktivitas pendanaan");
	}

	public static SegmentValidation genValidationSaldoAkhirKasDanBank() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 14, 24, 33 }),
				"Total saldo akhir kas dan bank|Penjumlahan saldo akhir kas dan bank");
	}
}
