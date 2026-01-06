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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3038PosLbAsrjk115 implements IObject<KeyValueString> {
//	R_1000000099 ("1000000099", "ASET"),
//	R_1400000099 ("1400000099", "Investasi"),
	R_1401000000 ("1401000000", "Deposito Berjangka "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham "),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi / Sukuk Daerah"),
	R_1405000000 ("1405000000", "MTN"),
	R_1406000000 ("1406000000", "Surat Berharga yang Diterbitkan oleh Negara RI "),
	R_1407000000 ("1407000000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
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
//	R_1501000099 ("1501000099", "Bukan Investasi"),
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
	R_1501000001 ("1501000001", "Jumlah Bukan Investasi"),
	R_1100000000 ("1100000000", "JUMLAH ASET LANCAR"),
//	R_2000000099 ("2000000099", "LIABILITAS"),
//	R_2500000099 ("2500000099", "Cadangan Teknis"),
	R_2501000000 ("2501000000", "Cadangan Premi"),
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim "),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2500000000 ("2500000000", "Jumlah Cadangan Teknis"),
//	R_2400000099 ("2400000099", "Utang"),
	R_2401000000 ("2401000000", "Utang Klaim"),
	R_2402000000 ("2402000000", "Utang Koasuransi"),
	R_2403000000 ("2403000000", "Utang Reasuransi"),
	R_2404000000 ("2404000000", "Utang Komisi"),
	R_2405000000 ("2405000000", "Utang Pajak"),
	R_2406000000 ("2406000000", "Biaya yang Masih Harus Dibayar"),
	R_2407000000 ("2407000000", "Utang Lain"),
	R_2400000000 ("2400000000", "Jumlah Utang"),
	R_2000000000 ("2000000000", "Jumlah LIABILITAS LANCAR"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3038PosLbAsrjk115 eEnum : ER3038PosLbAsrjk115.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3038PosLbAsrjk115.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3038PosLbAsrjk115.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1400000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 21), 
				"Total investasi|Penjumlahan investasi");
	}
	
	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1501000001.key, UtilMetadata.genPlusRow(getObjects(), 23, 34), 
				"Total bukan investasi|Penjumlahan bukan investasi");
	}
	
	public static SegmentValidation genValidationAsetLancar() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1100000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 35 }), 
				"Total aset lancar|Penjumlahan aset lancar");
	}
	
	public static SegmentValidation genValidationCadanganTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2500000000.key, UtilMetadata.genPlusRow(getObjects(), 37, 40), 
				"Total cadangan teknis|Penjumlahan cadangan teknis");
	}
	
	public static SegmentValidation genValidationUtang() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2400000000.key, UtilMetadata.genPlusRow(getObjects(), 42, 48), 
				"Total utang|Penjumlahan utang");
	}
	
	public static SegmentValidation genValidationLiabilitasLancar() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2000000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 41, 49 }), 
				"Total liabilitas lancar|Penjumlahan liabilitas lancar");
	}
}
