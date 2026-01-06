package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3024PosLbAsrus216 implements IObject<KeyValueString> {
//	R_2161010099 ("2161010099", "Aset Yang Diperkenankan"),
	R_2161010100 ("2161010100", "Deposito "),
	R_2161010101 ("2161010101", "Sertifikat Deposito"),
	R_2161010102 ("2161010102", "Saham Syariah"),
	R_2161010103 ("2161010103", "Sukuk atau Obligasi Syariah"),
	R_2161010104 ("2161010104", "MTN Syariah"),
	R_2161010105 ("2161010105", "Surat Berharga Syariah Negara"),
	R_2161010106 ("2161010106", "Surat Berharga Syariah yang Diterbitkan oleh  Bank Indonesia"),
	R_2161010107 ("2161010107", "Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_2161010108 ("2161010108", "Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_2161010109 ("2161010109", "Reksa Dana Syariah"),
	R_2161010110 ("2161010110", "Efek Beragun Aset Syariah"),
	R_2161010111 ("2161010111", "Dana Investasi Real Estate Syariah"),
	R_2161010112 ("2161010112", "REPO"),
	R_2161010113 ("2161010113", "Pembiayaan Melalui Kerjasama dengan Pihak Lain."),
	R_2161010114 ("2161010114", "Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_2161010115 ("2161010115", "Penyertaan Langsung"),
	R_2161010116 ("2161010116", "Properti Investasi"),
	R_2161010117 ("2161010117", "Emas  murni"),
	R_2161010118 ("2161010118", "Sukuk Daerah"),
	R_2161010119 ("2161010119", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_2161010120 ("2161010120", "Investasi lain"),
	R_2161010121 ("2161010121", "Kas dan Bank"),
	R_2161010122 ("2161010122", "Tagihan Kontribusi Penutupan Langsung"),
	R_2161010123 ("2161010123", "Tagihan Kontribusi Reasuransi"),
	R_2161010124 ("2161010124", "Aset Reasuransi"),
	R_2161010125 ("2161010125", "Tagihan Klaim Koasuransi"),
	R_2161010126 ("2161010126", "Tagihan Klaim Reasuransi"),
	R_2161010127 ("2161010127", "Tagihan Investasi"),
	R_2161010128 ("2161010128", "Tagihan Hasil Investasi"),
	R_2161010129 ("2161010129", "Property Bukan Investasi"),
	R_2161010130 ("2161010130", "Biaya Akuisisi yang Ditangguhkan"),
	R_2161010131 ("2161010131", "Jumlah Aset yang Diperkenankan"),
//	R_2161010132 ("2161010132", "Liabilitas"),
	R_2161010133 ("2161010133", "Utang klaim"),
	R_2161010134 ("2161010134", "Utang Koasuransi"),
	R_2161010135 ("2161010135", "Utang Reasuransi"),
	R_2161010136 ("2161010136", "Utang Ujroh"),
	R_2161010137 ("2161010137", "Utang Pajak"),
	R_2161010138 ("2161010138", "Biaya yang Masih Harus Dibayar"),
	R_2161010139 ("2161010139", "Utang lain"),
	R_2161010140 ("2161010140", "Penyisihan ujroh"),
	R_2161010141 ("2161010141", "Penyisihan penjaminan pokok investasi"),
	R_2161010142 ("2161010142", "Penyisihan kontribusi"),
	R_2161010143 ("2161010143", "Penyisihan atas kontribusi yang belum merupakan pendapatan"),
	R_2161010144 ("2161010144", "Penyisihan  klaim"),
	R_2161010145 ("2161010145", "Penyisihan atas risiko bencana"),
	R_2161010146 ("2161010146", "Jumlah Liabilitas"),
	R_2161010147 ("2161010147", "Kurs"),
	R_2161010148 ("2161010148", "Jumlah Aset Yang Diperkenankan Dalam Rupiah"),
	R_2161010149 ("2161010149", "Jumlah Liabilitas Dalam Rupiah"),
	R_2161010150 ("2161010150", "Selisih Aset Yang Diperkenankan atas Liabilitas"),
	R_2161010151 ("2161010151", "Faktor"),
	R_2161010152 ("2161010152", "Jumlah Deviasi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3024PosLbAsrus216 eEnum : ER3024PosLbAsrus216.values()) {
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

	public static ConditionalRequired genConditional10() {
		return UtilFieldConditional.genExistPos("M", "O", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 39, 40 }));
	}
	
	public static FieldValidation genValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 9), 2, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 31, 39, 40, 45, 49, 50 }));
	}
	
	public static FieldValidation genValidation19() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(11, 18), 2, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 31, 45, 49, 50 }));
	}
	
	public static FieldValidation genValidation28() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(20, 27), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 31, 39, 40, 45, 49, 50 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 28), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 50 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 28), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 50 }));
	}
	
	public static SegmentValidation genValidationJumlahAsetYangDiperkenankan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 28), R_2161010131.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 30), "Jumlah Aset yang Diperkenankan|Penjumlahan Aset yang Diperkenankan");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 28), R_2161010146.key, 
				UtilMetadata.genPlusRow(getObjects(), 32, 44), "Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahAsetYangDiperkenankanDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010148.key,  R_2161010131.key + "*" + R_2161010147.key, "Jumlah Aset Yang Diperkenankan Dalam Rupiah|Perhitungan Jumlah Aset Yang Diperkenankan Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010149.key, R_2161010146.key + "*" + R_2161010147.key, "Jumlah Liabilitas Dalam Rupiah|Perhitungan Jumlah Liabilitas Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationSelisihAsetYangDiperkenankanAtasLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 28), 
				R_2161010150.key, UtilMetadata.genMinusRow(getObjects(), new int[] { 48, 47 }), 
				"Selisih Aset Yang Diperkenankan atas Liabilitas|Perhitungan Selisih Aset Yang Diperkenankan atas Liabilitas");
	}
	
	public static SegmentValidation genValidationFactorA() {
		return UtilSegmentValidation.genFixedValue("9|10|18|19|27|28", R_2161010151.key, "0.00");
	}
	
	public static SegmentValidation genValidationFactorB() {
		return UtilSegmentValidation.genFactorValidation("2|3|4|5|6|7|8|11|12|13|14|15|16|17|20|21|22|23|24|25|26", 
				R_2161010151.key, R_2161010148.key, R_2161010149.key);
	}
	
	public static SegmentValidation genValidationJumlahDeviasi() {
		return UtilSegmentValidation.genDeviationValidation("2|3|4|5|6|7|8|9|11|12|13|14|15|16|17|18|20|21|22|23|24|25|26|27", 
				R_2161010152.key, R_2161010148.key, R_2161010149.key, R_2161010150.key, R_2161010151.key, "Jumlah Deviasi|Perhitungan Jumlah Deviasi", 0);
	}
}
