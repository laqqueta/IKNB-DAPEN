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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3024PosLbAsrjs216 implements IObject<KeyValueString> {
//	R_2161010099 ("2161010099", "Aset Yang Diperkenankan"),
	R_2161010100 ("2161010100", "Deposito Berjangka"),
	R_2161010101 ("2161010101", "Sertifikat Deposito"),
	R_2161010102 ("2161010102", "Saham Syariah"),
	R_2161010103 ("2161010103", "Sukuk atau Obligasi Syariah"),
	R_2161010104 ("2161010104", "MTN Syariah"),
	R_2161010105 ("2161010105", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_2161010106 ("2161010106", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_2161010107 ("2161010107", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_2161010108 ("2161010108", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_2161010109 ("2161010109", "Reksa Dana Syariah"),
	R_2161010110 ("2161010110", "Efek Beragun Aset Syariah"),
	R_2161010111 ("2161010111", "Dana Investasi Real Estat"),
	R_2161010112 ("2161010112", "REPO"),
	R_2161010113 ("2161010113", "Penyertaan Langsung"),
	R_2161010114 ("2161010114", "Properti Investasi"),
	R_2161010115 ("2161010115", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_2161010116 ("2161010116", "Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_2161010117 ("2161010117", "Emas  murni"),
	R_2161010118 ("2161010118", "Sukuk Daerah"),
	R_2161010119 ("2161010119", "Dana Investasi Infrastruktur berbentuk Kontrak Investasi Kolektif"),
	R_2161010120 ("2161010120", "Kas dan Bank"),
	R_2161010121 ("2161010121", "Tagihan Kontribusi Penutupan Langsung"),
	R_2161010122 ("2161010122", "Tagihan Kontribusi Reasuransi"),
	R_2161010123 ("2161010123", "Aset Reasuransi"),
	R_2161010124 ("2161010124", "Tagihan Klaim Koasuransi"),
	R_2161010125 ("2161010125", "Tagihan Klaim Reasuransi"),
	R_2161010126 ("2161010126", "Tagihan Investasi"),
	R_2161010127 ("2161010127", "Tagihan Hasil Investasi"),
	R_2161010128 ("2161010128", "Property Bukan Investasi"),
	R_2161010129 ("2161010129", "Biaya Akuisisi yang Ditangguhkan"),
	R_2161010130 ("2161010130", "Jumlah Aset yang Diperkenankan"),
	R_2161010131 ("2161010131", "Liabilitas"),
//	R_2161010132 ("2161010132", "Utang klaim"),
	R_2161010133 ("2161010133", "Utang Koasuransi"),
	R_2161010134 ("2161010134", "Utang Reasuransi"),
	R_2161010135 ("2161010135", "Utang Ujroh"),
	R_2161010136 ("2161010136", "Utang Pajak"),
	R_2161010137 ("2161010137", "Biaya yang Masih Harus Dibayar"),
	R_2161010138 ("2161010138", "Utang lain"),
	R_2161010139 ("2161010139", "Penyisihan ujroh"),
	R_2161010140 ("2161010140", "Penyisihan penjaminan pokok investasi"),
	R_2161010141 ("2161010141", "Penyisihan kontribusi"),
	R_2161010142 ("2161010142", "Penyisihan atas kontribusi yang belum merupakan pendapatan"),
	R_2161010143 ("2161010143", "Penyisihan  klaim"),
	R_2161010144 ("2161010144", "Penyisihan atas risiko bencana"),
	R_2161010145 ("2161010145", "Jumlah Liabilitas"),
	R_2161010146 ("2161010146", "Kurs"),
	R_2161010147 ("2161010147", "Jumlah Aset Yang Diperkenankan Dalam Rupiah"),
	R_2161010148 ("2161010148", "Jumlah Liabilitas Dalam Rupiah"),
	R_2161010149 ("2161010149", "Selisih Aset Yang Diperkenankan atas Liabilitas"),
	R_2161010150 ("2161010150", "Faktor"),
	R_2161010151 ("2161010151", "Jumlah Deviasi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3024PosLbAsrjs216 eEnum : ER3024PosLbAsrjs216.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 28), getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 32, 33, 34 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional4() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional5() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional6() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional7() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional8() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional9() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional10() {
		return genConditional2();
	}
	
	public static ConditionalRequired genConditional11() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 15, 16, 17, 29, 30, 39, 40 }));
	}
	
	public static ConditionalRequired genConditional12() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional13() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional14() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional15() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional16() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional17() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional18() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional19() {
		return genConditional11();
	}
	
	public static ConditionalRequired genConditional20() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 15, 16, 17, 24, 29, 30, 32, 33, 34, 39, 40 }));
	}
	
	public static ConditionalRequired genConditional21() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional22() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional23() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional24() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional25() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional26() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional27() {
		return genConditional20();
	}
	
	public static ConditionalRequired genConditional28() {
		return genConditional20();
	}
	
	public static FieldValidation genValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 9), 2, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 31, 32, 33, 34, 44, 49 }));
	}
	
	public static FieldValidation genValidation19() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(11, 18), 2, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 15, 16, 17, 29, 30, 31, 39, 40, 44, 49 }));
	}
	
	public static FieldValidation genValidation28() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(20, 27), 2, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 15, 16, 17, 24, 29, 30, 31, 32, 33, 34, 39, 40, 44, 49 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 28), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 49, 50 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 28), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 49, 50 }));
	}
	
	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 28), R_2161010131.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 28), "Total Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasA() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), 
				R_2161010145.key, 
				UtilMetadata.genPlusRow(getObjects(), 35, 43), "Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(11, 19), R_2161010145.key, 
				UtilMetadata.genPlusRow(getObjects(), 32, 38) + "+" + UtilMetadata.genPlusRow(getObjects(), 41, 43), 
				"Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasC() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(20, 28), R_2161010145.key, 
				UtilMetadata.genPlusRow(getObjects(), 35, 38) + "+" + UtilMetadata.genPlusRow(getObjects(), 41, 43), 
				"Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahAsetYangDiperkenankanDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010147.key, R_2161010130.key + "*" + R_2161010146.key, "Jumlah Aset Yang Diperkenankan Dalam Rupiah|Penjumlahan Aset Yang Diperkenankan Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010148.key, R_2161010145.key + "*" + R_2161010146.key, "Jumlah Liabilitas Dalam Rupiah|Perhitungan Jumlah Liabilitas Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationSelisihAsetYangDiperkenankanAtasLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010149.key, UtilMetadata.genMinusRow(getObjects(), new int[] { 47, 46 }), 
				"Selisih Aset Yang Diperkenankan atas Liabilitas|Perhitungan Selisih Aset Yang Diperkenankan atas Liabilitas");
	}
	
	public static SegmentValidation genValidationFactorA() {
		return UtilSegmentValidation.genFixedValue("9|10|18|19|27|28", R_2161010150.key, "0.00");
	}
	
	public static SegmentValidation genValidationFactorB() {
		return UtilSegmentValidation.genFactorValidation("2|3|4|5|6|7|8|11|12|13|14|15|16|17|20|21|22|23|24|25|26", 
				R_2161010150.key, R_2161010147.key, R_2161010148.key);
	}
	
	public static SegmentValidation genValidationJumlahDeviasi() {
		return UtilSegmentValidation.genDeviationValidation("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010151.key, R_2161010147.key, R_2161010148.key, R_2161010149.key, R_2161010150.key, "Jumlah Deviasi|Perhitungan Jumlah Deviasi");
	}
}
