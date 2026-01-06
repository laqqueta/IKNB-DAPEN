package id.go.ojk.asruk.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3012PosLbAsruk503 implements IObject<KeyValueString> {
//	R_1000000099 ("1000000099", "ASET"),
//	R_1400000099 ("1400000099", "Investasi"),
	R_1401000000 ("1401000000", "Deposito Berjangka "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham "),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi /Sukuk Daerah"),
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
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim "),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2500000000 ("2500000000", "Jumlah Cadangan Teknis"),
	R_2000000000 ("2000000000", "Jumlah Liabilitas"),
	R_9000000000 ("9000000000", "SELISIH LIABILITAS DAN ASET"),
	R_7302010000 ("7302010000", "DEVIASI (4% X (Maks (Li - AYDi), 0))"),
	R_2501020000 ("2501020000", "Jumlah Cadangan Premi PAYDI"),
	R_7302020100 ("7302020100", "Faktor PAYDI"),
	R_7302020000 ("7302020000", "Deviasi PAYDI"),
	R_7302000000 ("7302000000", "Total Deviasi untuk Risiko Likuiditas"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3012PosLbAsruk503 eEnum : ER3012PosLbAsruk503.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7", getObjects());
	}

	public static ConditionalRequired genConditionalMustEmpty23456() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 53, 56));
	}
	public static ConditionalRequired genConditionalMustEmpty7() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), 52, 56));
	}
	
	public static FieldValidation genFieldValidationSum7() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5+6", R_7302010000.key);
	}

	public static SegmentValidation genValidationAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 35 }), "Total aset|Penjumlahan aset");
	}
	
	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1500000000.key,
				UtilMetadata.genPlusRow(getObjects(), 23, 34), "Total bukan investasi|Penjumlahan bukan investasi");
	}
	
	public static SegmentValidation genValidationCadanganTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_2500000000.key,
				UtilMetadata.genPlusRow(getObjects(), 45, 48), "Total cadangan teknis|Penjumlahan cadangan teknis");
	}
	
	public static SegmentValidation genValidationDeviasi() {
		return UtilSegmentValidation.genDeviationMax("2|3|4|5|6", R_7302010000.key, R_9000000000.key, "0", "0.04", 
				"Deviasi|Perhitungan Deviasi", 0);
	}
	
	public static SegmentValidation genValidationDeviasiPaydi() {
		return UtilSegmentValidation.genPercentage("7", R_7302020000.key, 
				UtilMetadata.genPipeRow(getObjects(), 53, 54), "Total deviasi Paydi|Perhitungan deviasi Paydi");
	}
	
	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_1400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 21), "Total investasi|Penjumlahan investasi");
	}
	
	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_2000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 44, 49 }), "Total liabilitas|Penjumlahan liabilitas");
	}
	
	public static SegmentValidation genValidationLiabilitasDanAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_9000000000.key,
				R_2000000000.key + "-" + R_1000000000.key, "Selisih liabilitas dan aset|Perhitungan liabilitas dan aset");
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("7", R_7302020100.key);
	}
	
	public static SegmentValidation genValidationNumericDotLength() {
		return UtilSegmentValidation.genMaxLength("7", R_7302020100.key, 6);
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("7", UtilMetadata.genPipeRow(getObjects(), new int[] { 52, 53, 55, 56 }));
	}
	
	public static SegmentValidation genValidationTotalDeviasiUntukRisikoLikuiditas() {
		return UtilSegmentValidation.genEqualsFormula("7", R_7302000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 52, 55}), "Total Deviasi untuk Risiko Likuiditas|Perhitungan Deviasi untuk Risiko Likuiditas");
	}
	
	public static SegmentValidation genValidationUtang() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6", R_2400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 43), "Total utang|Penjumlahan utang");
	}
}
