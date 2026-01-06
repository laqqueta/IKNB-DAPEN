package id.go.ojk.dplkk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dplkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2007PosRbDplkk0800 implements IObject<KeyValueString> {
//	R_0801000000 ("0801000000", "ASET "),
//	R_0801010000 ("0801010000", "INVESTASI"),
	R_0801010100 ("0801010100", "Tabungan pada Bank"), 
	R_0801010200 ("0801010200", "Deposito on call pada Bank"),
	R_0801010300 ("0801010300", "Deposito Berjangka pada Bank"),
	R_0801010400 ("0801010400", "Sertifikat Deposito pada Bank"),
	R_0801010500 ("0801010500", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0801010600 ("0801010600", "Surat Berharga Negara"),
	R_0801010700 ("0801010700", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0801010800 ("0801010800", "Obligasi korporasi yang tercatat di bursa efek di Indonesia"),
	R_0801010900 ("0801010900", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0801011000 ("0801011000", "Obligasi/Sukuk Daerah"), 
	R_0801011100 ("0801011100", "Reksa Dana "),
	R_0801011200 ("0801011200", "MTN"), 
	R_0801011300 ("0801011300", "Efek Beragun Aset"),
	R_0801011400 ("0801011400", "Dana investasi real estate berbentuk kontrak investasi kolektif"),
	R_0801011500 ("0801011500", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0801011600 ("0801011600", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0801011700 ("0801011700", "REPO"), 
	R_0801011800 ("0801011800", "Penyertaan langsung"),
	R_0801011900 ("0801011900", "Tanah di Indonesia"), 
	R_0801012000 ("0801012000", "Bangunan di Indonesia"),
	R_0801012100 ("0801012100", "Tanah dan Bangunan di Indonesia"), 
	R_0801012200 ("0801012200", "TOTAL INVESTASI"),
//	R_0801020000 ("0801020000", "ASET LANCAR DI LUAR INVESTASI"),
	R_0801020100 ("0801020100", "Kas dan Bank"), 
	R_0801020200 ("0801020200", "Beban Dibayar di Muka "),
	R_0801020300 ("0801020300", "Piutang Investasi"), 
	R_0801020400 ("0801020400", "Piutang Hasil Investasi"),
	R_0801020500 ("0801020500", "Piutang Lain-lain"), 
	R_0801020600 ("0801020600", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
	R_0801030000 ("0801030000", "ASET TERSEDIA"),
//	R_0802000000 ("0802000000", "LIABILITAS "),
//	R_0802010000 ("0802010000", "Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_0802020000 ("0802020000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_0802030000 ("0802030000", "Utang Manfaat Sukarela"), 
	R_0802040000 ("0802040000", "Utang Investasi"),
	R_0802050000 ("0802050000", "Pendapatan Diterima di Muka"),
	R_0802060000 ("0802060000", "Beban yang Masih Harus di Bayar"), 
	R_0802070000 ("0802070000", "Utang Lain"),
	R_0802080000 ("0802080000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_0802090000 ("0802090000", "TOTAL LIABILITAS"), 
	R_0803000000 ("0803000000", "ASET NETO"),;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2007PosRbDplkk0800 eEnum : ER2007PosRbDplkk0800.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2007PosRbDplkk0800.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2007PosRbDplkk0800.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801012200.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 20),
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationAsetLancarDiluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801020600.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 26),
				"Total Aset Lancar di luar Investasi|Penjumlahan Aset Lancar di luar Investasi");
	}

	public static SegmentValidation genValidationAsetTersedia() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801030000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 27 }),
				"Total aset tersedia|Penjumlahan total investasi dengan total aset lancar di luar investasi");
	}

	public static SegmentValidation genValidationTotalLiabilitasDiluarLiabilitasManfaatPensiun() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0802080000.key,
				UtilMetadata.genPlusRow(getObjects(), 29, 34),
				"Liabilitas di luar Liabilitas Manfaat Pensiun|Penjumlahan Liabilitas di luar Liabilitas Manfaat Pensiun");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0802090000.key, R_0802080000.key, 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0803000000.key, 
				R_0801030000.key + "-" + R_0802090000.key,
				"Total Aset Neto|Penjumlahan Aset Neto");
	}

	public static SegmentValidation genValidationFormTotalAsetNeto() {
		String comparatorFormCode = EFormRencanaBisnis.RB_0900.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_0803000000.key, comparatorFormCode, 
				ER2008PosRbDplkk0900.R_0905000000.getKey(), "Nilai Aset Neto|Nilai Aset Neto Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
