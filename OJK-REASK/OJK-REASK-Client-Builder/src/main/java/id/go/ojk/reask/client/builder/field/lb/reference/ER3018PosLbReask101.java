package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3018PosLbReask101 implements IObject<KeyValueString> {
//	R_1400000099 ("1400000099", "Investasi"),
	R_1401000000 ("1401000000", "Deposito Berjangka"),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham"),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi / Sukuk Daerah"),
	R_1405000000 ("1405000000", "MTN"),
	R_1406000000 ("1406000000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_1407000000 ("1407000000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_1408000000 ("1408000000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_1409000000 ("1409000000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1410000000 ("1410000000", "Reksa Dana"),
	R_1411000000 ("1411000000", "Efek Beragun Aset"),
	R_1412000000 ("1412000000", "Dana Investasi Real Estat"),
	R_1421000000 ("1421000000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_1413000000 ("1413000000", "REPO"),
	R_1414000000 ("1414000000", "Penyertaan Langsung"),
	R_1415000000 ("1415000000", "Tanah, Bangunan dengan Hak Strata atau Tanah dengan Bangunan untuk Investasi"),
	R_1416000000 ("1416000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
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
	R_1000000000 ("1000000000", "JUMLAH ASET "),
	R_2400000000 ("2400000000", "Jumlah Utang"),
	R_2501000000 ("2501000000", "Cadangan Premi"),
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim"),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2000000000 ("2000000000", "JUMLAH LIABILITAS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3018PosLbReask101 eEnum : ER3018PosLbReask101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6", getObjects());
	}
	
	public static ConditionalRequired genConditionalMustEmpty3() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 21, 33, 34 }));
	}
	
	public static ConditionalRequired genConditionalMustEmpty5() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 37, 42));
	}
	
	public static ConditionalRequired genConditionalMustEmpty6() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 21, 33, 34, 37, 38, 39, 40, 41, 42 }));
	}

	public static SegmentValidation genValidationJumlahInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 21), "Total investasi|Penjumlahan investasi");
	}

	public static SegmentValidation genValidationJumlahBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 23, 34), "Total bukan investasi|Penjumlahan bukan investasi");
	}

	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 35 }), "Total aset|Penjumlahan aset");
	}

	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 37, 41), "Total liabilitas|Penjumlahan liabilitas");
	}
}
