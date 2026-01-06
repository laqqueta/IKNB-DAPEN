package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dplks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2016PosRbDplks1201 implements IObject<KeyValueString> {
//	R_1201010000 ("1201010000", "ASET "),
//	R_1201010100 ("1201010100", "INVESTASI SYARIAH"),
	R_1201010101 ("1201010101", "Tabungan pada Bank"),
	R_1201010102 ("1201010102", "Deposito on call pada Bank"),
	R_1201010103 ("1201010103", "Deposito Berjangka pada Bank"),
	R_1201010104 ("1201010104", "Sertifikat Deposito pada Bank"),
	R_1201010105 ("1201010105", "Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_1201010106 ("1201010106", "Surat Berharga Syariah Negara"),
	R_1201010107 ("1201010107", "Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_1201010108 ("1201010108", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_1201010109 ("1201010109", "Sukuk Daerah"),
	R_1201010110 ("1201010110", "Reksa Dana Syariah"),
	R_1201010111 ("1201010111", "MTN Syariah"),
	R_1201010112 ("1201010112", "Efek Beragun Aset Syariah"),
	R_1201010113 ("1201010113", "Dana investasi real estate Syariah berbentuk kontrak investasi kolektif"),
	R_1201010114 ("1201010114", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_1201010115 ("1201010115", "Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_1201010116 ("1201010116", "REPO"),
	R_1201010117 ("1201010117", "Penyertaan langsung"),
	R_1201010118 ("1201010118", "Tanah di Indonesia"),
	R_1201010119 ("1201010119", "Bangunan di Indonesia"),
	R_1201010120 ("1201010120", "Tanah dan Bangunan di Indonesia"),
	R_1201010200 ("1201010200", "TOTAL INVESTASI"),
//	R_1201010300 ("1201010300", "ASET LANCAR DI LUAR INVESTASI"),
	R_1201010301 ("1201010301", "Kas dan Bank"),
	R_1201010302 ("1201010302", "Beban Dibayar di Muka "),
	R_1201010303 ("1201010303", "Piutang Investasi"),
	R_1201010304 ("1201010304", "Piutang Hasil Investasi"),
	R_1201010305 ("1201010305", "Piutang Lain-lain"),
	R_1201010400 ("1201010400", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
	R_1201020000 ("1201020000", "ASET TERSEDIA"),
//	R_1201030000 ("1201030000", "LIABILITAS "),
//	R_1201030100 ("1201030100", "Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_1201030101 ("1201030101", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_1201030102 ("1201030102", "Utang Manfaat Sukarela"),
	R_1201030103 ("1201030103", "Utang Investasi"),
	R_1201030104 ("1201030104", "Pendapatan Diterima di Muka"),
	R_1201030105 ("1201030105", "Beban yang Masih Harus di Bayar"),
	R_1201030106 ("1201030106", "Utang Lain"),
	R_1201030200 ("1201030200", "Total Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_1201040000 ("1201040000", "TOTAL LIABILITAS"),
	R_1201050000 ("1201050000", "ASET NETO"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2016PosRbDplks1201 eEnum : ER2016PosRbDplks1201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2016PosRbDplks1201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2016PosRbDplks1201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidationTotalInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201010200.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 19),
				"Total Investasi|Penjumlahan Investasi");
	}
	
	public static SegmentValidation genValidationTotalAsetLancarDiluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201010400.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 25),
				"Total Aset Lancar Di luar Investasi|Penjumlahan Aset Lancar Di luar Investasi");
	}
	
	public static SegmentValidation genValidationTotalAsetTersedia() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201020000.key,
				R_1201010200.key + "+" + R_1201010400.key,
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}
	
	public static SegmentValidation genValidationTotalLiabilitasDiluarLiabilitasManfaatPensiun() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201030200.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 33),
				"Total Liabilitas di Luar Liabilitas Manfaat Pensiun|Penjumlahan Liabilitas di Luar Liabilitas Manfaat Pensiun");
	}
	
	public static SegmentValidation genValidationTotalLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201040000.key,
				R_1201030200.key, "Total Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1201050000.key,
				R_1201020000.key + "-" + R_1201040000.key, "Total Aset Neto|Perhitungan Aset Neto");
	}

	public static SegmentValidation genValidationFormAsetNeto() {
		String comparatorFormCode = EFormRencanaBisnis.RB_1202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_1201050000.key, comparatorFormCode, 
				ER2017PosRbDplks1202.R_1202120000.getKey(), "Total Aset Neto|Total Aset Neto Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
