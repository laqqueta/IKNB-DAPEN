package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2021PosReDplks0200 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "ASET "),
//	R_0201010000 ("0201010000", "INVESTASI SYARIAH"),
	R_0201010100 ("0201010100", "Tabungan pada Bank"),
	R_0201010200 ("0201010200", "Deposito on call pada Bank"),
	R_0201010300 ("0201010300", "Deposito Berjangka pada Bank"),
	R_0201010400 ("0201010400", "Sertifikat Deposito pada Bank"),
	R_0201010500 ("0201010500", "Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_0201010600 ("0201010600", "Surat Berharga Syariah Negara"),
	R_0201010700 ("0201010700", "Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0201010800 ("0201010800", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0201010900 ("0201010900", "Sukuk Daerah"),
	R_0201011000 ("0201011000", "Reksa Dana Syariah"),
	R_0201011100 ("0201011100", "MTN Syariah"),
	R_0201011200 ("0201011200", "Efek Beragun Aset Syariah"),
	R_0201011300 ("0201011300", "Dana investasi real estate Syariah berbentuk kontrak investasi kolektif"),
	R_0201011400 ("0201011400", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0201011500 ("0201011500", "Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0201011600 ("0201011600", "REPO"),
	R_0201011700 ("0201011700", "Penyertaan langsung"),
	R_0201011800 ("0201011800", "Tanah di Indonesia"),
	R_0201011900 ("0201011900", "Bangunan di Indonesia"),
	R_0201012000 ("0201012000", "Tanah dan Bangunan di Indonesia"),
	R_0201020000 ("0201020000", "TOTAL INVESTASI"),
//	R_0201030000 ("0201030000", "ASET LANCAR DI LUAR INVESTASI"),
	R_0201030100 ("0201030100", "Kas dan Bank"),
	R_0201030200 ("0201030200", "Beban Dibayar di Muka "),
	R_0201030300 ("0201030300", "Piutang Investasi"),
	R_0201030400 ("0201030400", "Piutang Hasil Investasi"),
	R_0201030500 ("0201030500", "Piutang Lain-lain"),
	R_0201040000 ("0201040000", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
	R_0202000000 ("0202000000", "ASET TERSEDIA"),
//	R_0203000000 ("0203000000", "LIABILITAS "),
//	R_0203010000 ("0203010000", "Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_0203010100 ("0203010100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_0203010200 ("0203010200", "Utang Manfaat Sukarela"),
	R_0203010300 ("0203010300", "Utang Investasi"),
	R_0203010400 ("0203010400", "Pendapatan Diterima di Muka"),
	R_0203010500 ("0203010500", "Beban yang Masih Harus di Bayar"),
	R_0203010600 ("0203010600", "Utang Lain"),
	R_0203020000 ("0203020000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun"),
	R_0204000000 ("0204000000", "TOTAL LIABILITAS"),
	R_0205000000 ("0205000000", "ASET NETO"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2021PosReDplks0200 eEnum : ER2021PosReDplks0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2021PosReDplks0200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2021PosReDplks0200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201020000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 19), 
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationAsetLancarDiluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201040000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 25), 
				"Total Aset Lancar di luar Investasi|Penjumlahan Aset Lancar di luar Investasi");
	}

	public static SegmentValidation genValidationAsetTersedia() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0202000000.key,
				R_0201020000.key + "+" + R_0201040000.key, 
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}

	public static SegmentValidation genValidationLiabilitasDiLuarLiabilitasManfaatPensiun() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0203020000.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 33), 
				"Total Liabilitas di Luar Liabilitas Manfaat Pensiun|Penjumlahan Liabilitas di Luar Liabilitas Manfaat Pensiun");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0204000000.key, R_0203020000.key, 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0205000000.key,
				R_0202000000.key + "-" + R_0204000000.key, 
				"Total Aset Neto|Penjumlahan Aset Neto");
	}
}
