package id.go.ojk.dppkk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2018PosReDppkk0200 implements IObject<KeyValueString> {
//	R_0201000000 ("0201000000", "ASET"),
//	R_0201010000 ("0201010000", "INVESTASI"),
	R_0201010100 ("0201010100", "Tabungan pada Bank"),
	R_0201010200 ("0201010200", "Deposito on call pada Bank"),
	R_0201010300 ("0201010300", "Deposito Berjangka pada Bank"),
	R_0201010400 ("0201010400", "Sertifikat Deposito pada Bank"),
	R_0201010500 ("0201010500", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0201010600 ("0201010600", "Surat Berharga Negara "),
	R_0201010700 ("0201010700", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0201010800 ("0201010800", "Obligasi korporasi yang tercatat di bursa efek di indonesia"),
	R_0201010900 ("0201010900", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0201011000 ("0201011000", "Obligasi/Sukuk Daerah"),
	R_0201011100 ("0201011100", "Reksa Dana"),
	R_0201011200 ("0201011200", "MTN"),
	R_0201011300 ("0201011300", "Efek Beragun Aset"),
	R_0201011400 ("0201011400", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_0201011500 ("0201011500", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0201011600 ("0201011600", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0201011700 ("0201011700", "REPO"),
	R_0201011800 ("0201011800", "Penyertaan langsung"),
	R_0201011900 ("0201011900", "Tanah di Indonesia"),
	R_0201012000 ("0201012000", "Bangunan di Indonesia"),
	R_0201012100 ("0201012100", "Tanah dan Bangunan di Indonesia"),
	R_0201012200 ("0201012200", "TOTAL INVESTASI"),
//	R_0201020000 ("0201020000", "ASET LANCAR DI LUAR INVESTASI"),
	R_0201020100 ("0201020100", "Kas dan Bank "),
	R_0201020200 ("0201020200", "Piutang Iuran"),
	R_0201020201 ("0201020201", "- Iuran Normal Pemberi Kerja"),
	R_0201020202 ("0201020202", "- Iuran Normal Peserta"),
	R_0201020203 ("0201020203", "- Iuran Sukarela Peserta"),
	R_0201020204 ("0201020204", "- Iuran Tambahan"),
	R_0201020300 ("0201020300", "Piutang Bunga Keterlambatan Iuran "),
	R_0201020400 ("0201020400", "Beban Dibayar Di Muka "),
	R_0201020500 ("0201020500", "Piutang Investasi"),
	R_0201020600 ("0201020600", "Piutang Hasil Investasi"),
	R_0201020700 ("0201020700", "Piutang Lain-lain"),
	R_0201030000 ("0201030000", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
//	R_0201040000 ("0201040000", "ASET OPERASIONAL"),
	R_0201040100 ("0201040100", "Tanah dan Bangunan"),
	R_0201040200 ("0201040200", "Kendaraan"),
	R_0201040300 ("0201040300", "Peralatan Komputer"),
	R_0201040400 ("0201040400", "Peralatan Kantor"),
	R_0201040500 ("0201040500", "Aset Operasional Lain"),
	R_0201050000 ("0201050000", "TOTAL ASET OPERASIONAL"),
	R_0201060000 ("0201060000", "ASET LAIN-LAIN"),
	R_0202000000 ("0202000000", "ASET TERSEDIA"),
//	R_0203000000 ("0203000000", "LIABILITAS"),
//	R_0203010000 ("0203010000", "Liabilitas di Luar Nilai Kini Aktuarial (PPMP) / Liabilitas di Luar Liabilitas Manfaat Pensiun (PPIP)"),
	R_0203010100 ("0203010100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_0203010200 ("0203010200", "Utang Manfaat Sukarela"),
	R_0203010300 ("0203010300", "Utang Investasi"),
	R_0203010400 ("0203010400", "Pendapatan Diterima di Muka"),
	R_0203010500 ("0203010500", "Beban Yang Masih Harus Di Bayar"),
	R_0203010600 ("0203010600", "Utang Lain"),
	R_0203010700 ("0203010700", "Total Liabilitas di Luar Nilai Kini Aktuarial/Liabilitas Manfaat Pensiun"),
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
		for (ER2018PosReDppkk0200 eEnum : ER2018PosReDppkk0200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2018PosReDppkk0200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2018PosReDppkk0200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsFormula("3-2");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201012200.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 20), 
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationPiutangIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201020200.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 27), 
				"Total Piutang Iuran|Penjumlahan Piutang Iuran");
	}

	public static SegmentValidation genValidationAsetLancarDiluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201030000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 23, 28, 29, 30, 31, 32 }), 
				"Total Aset Lancar di luar Investasi|Penjumlahan Aset Lancar di luar Investasi");
	}

	public static SegmentValidation genValidationAsetOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0201050000.key,
				UtilMetadata.genPlusRow(getObjects(), 34, 38), 
				"Total Aset Operasional|Penjumlahan Aset Operasional");
	}

	public static SegmentValidation genValidationAsetTersedia() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0202000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 33, 39, 40 }), 
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}

	public static SegmentValidation genValidationLiabilitasDiluarLiabilitasManfaatPensiun() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0203010700.key,
				UtilMetadata.genPlusRow(getObjects(), 42, 47), 
				"Total Liabilitas di luar Aktuarial/Liabilitas Manfaat Pensiun|Penjumlahan Aktuarial/Liabilitas di luar Liabilitas Manfaat Pensiun");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0204000000.key, R_0203010700.key, 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0205000000.key,
				R_0202000000.key + "-" + R_0204000000.key, 
				"Total Aset Neto|Penjumlahan Aset Neto");
	}

	public static SegmentValidation genValidationFormAsetNeto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_0300.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_0205000000.key, comparatorFormCode, 
				ER2019PosReDppkk0300.R_0306000000.getKey(), "Total Aset Neto|Total Aset Neto Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
