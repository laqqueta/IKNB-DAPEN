package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum ER2014PosRbReask1301 implements IObject<KeyValueString> {
	R_1401000000 ("1401000000", "Deposito Berjangka "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham"),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi / Sukuk Daerah"),
	R_1405000000 ("1405000000", "MTN"),
	R_1406000000 ("1406000000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_1407000000 ("1407000000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI"),
	R_1408000000 ("1408000000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_1409000000 ("1409000000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1410000000 ("1410000000", "Reksa Dana"),
	R_1411000000 ("1411000000", "Efek Beragun Aset"),
	R_1412000000 ("1412000000", "Dana Investasi Real Estat"),
	R_1421000000 ("1421000000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_1413000000 ("1413000000", "REPO"),
	R_1414000000 ("1414000000", "Penyertaan Langsung"),
	R_1415000000 ("1415000000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_1416000000 ("1416000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_1417000000 ("1417000000", "Emas Murni"),
	R_1418000000 ("1418000000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_1419000000 ("1419000000", "Pinjaman Polis"),
	R_1499000000 ("1499000000", "Investasi Lain"),
	R_1400000000 ("1400000000", "Jumlah Investasi"),
//	R_1500000099 ("1500000099", "Bukan Investasi"),
	R_1501000000 ("1501000000", "Kas dan Bank"),
	R_1502000000 ("1502000000", "Tagihan Premi Penutupan Langsung"),
	R_1503000000 ("1503000000", "Tagihan Premi Reasuransi"),
	R_1504000000 ("1504000000", "Aset Reasuransi"),
	R_1505000000 ("1505000000", "Tagihan Klaim Koasuransi"),
	R_1506000000 ("1506000000", "Tagihan Klaim Reasuransi"),
	R_1507000000 ("1507000000", "Tagihan Investasi"),
	R_1508000000 ("1508000000", "Tagihan Hasil Investasi"),
	R_1509000000 ("1509000000", "Bangunan dengan Hak Strata atau Tanah dengan Bangunan untuk Dipakai Sendiri"),
	R_1510000000 ("1510000000", "Biaya Akuisisi yang Ditangguhkan"),
	R_1511000000 ("1511000000", "Aset Tetap Lain"),
	R_1599000000 ("1599000000", "Aset Lain"),
	R_1500000000 ("1500000000", "Jumlah Bukan Investasi"),
	R_1000000000 ("1000000000", "JUMLAH ASET"),
//	R_3900000000 ("3900000000", "LIABILITAS DAN EKUITAS"),
//	R_2000000099 ("2000000099", "Liabilitas"),
//	R_2400000099 ("2400000099", "Utang"),
	R_2401000000 ("2401000000", "Utang Klaim"),
	R_2402000000 ("2402000000", "Utang Koasuransi"),
	R_2403000000 ("2403000000", "Utang Reasuransi"),
	R_2404000000 ("2404000000", "Utang Komisi"),
	R_2405000000 ("2405000000", "Utang Pajak"),
	R_2406000000 ("2406000000", "Biaya yang Masih Harus Dibayar"),
	R_2407000000 ("2407000000", "Utang Lain"),
	R_2400000000 ("2400000000", "Jumlah Utang"),
//	R_2500000099 ("2500000099", "Cadangan Teknis"),
	R_2501000000 ("2501000000", "Cadangan Premi"),
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim"),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2500000000 ("2500000000", "Jumlah Cadangan Teknis"),
	R_2000000000 ("2000000000", "Jumlah Liabilitas"),
	R_2600000000 ("2600000000", "Pinjaman Subordinasi"),
//	R_3000000099 ("3000000099", "Ekuitas"),
	R_3401000000 ("3401000000", "Modal Disetor"),
	R_3402000000 ("3402000000", "Agio Saham"),
	R_3403000000 ("3403000000", "Saldo Laba"),
	R_3404000000 ("3404000000", "Komponen Ekuitas Lainnya"),
	R_3405000000 ("3405000000", "Selisih Penilaian Berdasar SAK dan SAP"),
	R_3406000000 ("3406000000", "Aset yang Tidak Termasuk AYD"),
	R_3000000000 ("3000000000", "Jumlah Ekuitas"),
	R_3999999999 ("3999999999", "JUMLAH LIABILITAS DAN EKUITAS"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2014PosRbReask1301 eEnum : ER2014PosRbReask1301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2014PosRbReask1301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2014PosRbReask1301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidasiInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 21), 
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidasiBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 23, 34), 
				"Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidasiAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1000000000.key, 
				R_1400000000.key + "+" + R_1500000000.key, 
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidasiHutang() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_2400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 37, 43), 
				"Total Hutang|Penjumlahan Hutang");
	}

	public static SegmentValidation genValidasiCadanganTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_2500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 45, 48), 
				"Total Cadangan Teknis|Penjumlahan Cadangan Teknis");
	}

	public static SegmentValidation genValidasiLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_2000000000.key, 
				R_2400000000.key + "+" + R_2500000000.key, 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidasiEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_3000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 52, 57), 
				"Total Ekuitas|Penjumlahan Ekuitas");
	}

	public static SegmentValidation genValidasiLiabilitasEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_3999999999.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 50, 51, 58 }), 
				"Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
