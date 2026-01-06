package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

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
public enum ER2120PosReDppu0200 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "ASET"),
//	R_0201010000 ("0201010000", "INVESTASI"),
	R_0201010100 ("0201010100", "Tabungan pada Bank"),
	R_0201010200 ("0201010200", "Deposito on call pada Bank"),
	R_0201010300 ("0201010300", "Deposito Berjangka pada Bank"),
	R_0201010400 ("0201010400", "Sertifikat Deposito pada Bank"),
	R_0201010500 ("0201010500", "Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_0201010600 ("0201010600", "Surat Berharga Syariah Negara "),
	R_0201010700 ("0201010700", "Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0201010800 ("0201010800", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0201010900 ("0201010900", "Sukuk Daerah"),
	R_0201011000 ("0201011000", "Reksa Dana Syariah"),
	R_0201011100 ("0201011100", "MTN Syariah"),
	R_0201011200 ("0201011200", "Efek Beragun Aset Syariah"),
	R_0201011300 ("0201011300", "Dana investasi real estat syariah berbentuk kontrak investasi kolektif"),
	R_0201011400 ("0201011400", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0201011500 ("0201011500", "Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0201011600 ("0201011600", "REPO"),
	R_0201011700 ("0201011700", "Penyertaan langsung"),
	R_0201011800 ("0201011800", "Tanah di Indonesia"),
	R_0201011900 ("0201011900", "Bangunan di Indonesia"),
	R_0201012000 ("0201012000", "Tanah dan Bangunan di Indonesia"),
	R_0201020000 ("0201020000", "Total Investasi"),
//	R_0201030000 ("0201030000", "ASET LANCAR DI LUAR INVESTASI"),
	R_0201030100 ("0201030100", "Kas dan Bank "),
	R_0201030200 ("0201030200", "Piutang Iuran"),
	R_0201030201 ("0201030201", "Iuran Normal Pemberi Kerja"),
	R_0201030202 ("0201030202", "Iuran Normal Peserta"),
	R_0201030203 ("0201030203", "Iuran Sukarela Peserta"),
	R_0201030204 ("0201030204", "Iuran Tambahan"),
	R_0201030300 ("0201030300", "Beban Dibayar Di Muka "),
	R_0201030400 ("0201030400", "Piutang Investasi"),
	R_0201030500 ("0201030500", "Piutang Hasil Investasi"),
	R_0201030600 ("0201030600", "Piutang Lain-lain"),
	R_0201040000 ("0201040000", "Total Aset Lancar Di Luar Investasi"),
//	R_0201050000 ("0201050000", "ASET OPERASIONAL"),
	R_0201050100 ("0201050100", "Tanah dan Bangunan"),
	R_0201050200 ("0201050200", "Kendaraan"),
	R_0201050300 ("0201050300", "Peralatan Komputer"),
	R_0201050400 ("0201050400", "Peralatan Kantor"),
	R_0201050500 ("0201050500", "Aset Operasional Lain"),
	R_0201060000 ("0201060000", "Total Aset Operasional"),
	R_0201070000 ("0201070000", "Aset Lain-Lain"),
	R_0202000000 ("0202000000", "Aset Tersedia"),
//	R_0203000000 ("0203000000", "LIABILITAS"),
	R_0203010000 ("0203010000", "Liabilitas di Luar Nilai Kini Aktuarial (PPMP)"),
	R_0203020000 ("0203020000", "Liabilitas di Luar Liabilitas Manfaat Pensiun (PPIP)"),
	R_0203030000 ("0203030000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_0203040000 ("0203040000", "Utang Manfaat Sukarela"),
	R_0203050000 ("0203050000", "Utang Dana Ta’zir"),
	R_0203060000 ("0203060000", "Utang Investasi"),
	R_0203070000 ("0203070000", "Pendapatan Diterima di Muka"),
	R_0203080000 ("0203080000", "Beban Yang Masih Harus Di Bayar"),
	R_0203090000 ("0203090000", "Utang Lain"),
	R_0204000000 ("0204000000", "Total Liabilitas di luar liabilitas manfaat pensiun"),
	R_0205000000 ("0205000000", "Total Liabilitas"),
	R_0206000000 ("0206000000", "Aset Neto"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2120PosReDppu0200 eEnum : ER2120PosReDppu0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2120PosReDppu0200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2120PosReDppu0200.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationPiutangIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201030200.key,
				UtilMetadata.genPlusRow(getObjects(), 23, 26), 
				"Total Piutang Iuran|Penjumlahan Piutang Iuran");
	}

	public static SegmentValidation genValidationAsetLancarDiluarInvestasi() {
		int[] fields = new int[] { 21, 22, 27, 28, 29, 30 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201040000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				"Total Aset Lancar di luar Investasi|Penjumlahan Aset Lancar di luar Investasi");
	}

	public static SegmentValidation genValidationAsetOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201060000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 36), 
				"Total Aset Operasional|Penjumlahan Aset Operasional");
	}

	public static SegmentValidation genValidationAsetTersedia() {
		int[] fields = new int[] { 20, 31, 37, 38 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0202000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}

	public static SegmentValidation genValidationLiabilitasDiLuarNilaiKiniAktuarial() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0204000000.key,
				UtilMetadata.genPlusRow(getObjects(), 42, 48), 
				"Total Liabilitas di Luar Nilai Kini Aktuarial|Penjumlahan Liabilitas di Luar Nilai Kini Aktuarial");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0205000000.key, R_0204000000.key, 
				"Total Liabilitas|Total Liabilitas di Luar Nilai Kini Aktuarial");
	}

	public static SegmentValidation genValidationAsetNeto() {
		int[] fields = new int[] { 39, 50 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0206000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields), 
				"Total Aset Neto|Penjumlahan Aset Neto");
	}
}
