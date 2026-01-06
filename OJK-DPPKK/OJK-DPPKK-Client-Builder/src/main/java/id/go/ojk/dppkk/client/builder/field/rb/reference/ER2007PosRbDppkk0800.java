package id.go.ojk.dppkk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2007PosRbDppkk0800 implements IObject<KeyValueString> {
//	R_0801000000 ("0801000000", "ASET"),
//	R_0801010000 ("0801010000", "INVESTASI"),
	R_0801010100 ("0801010100", "Tabungan pada Bank"),
	R_0801010200 ("0801010200", "Deposito on call pada Bank"),
	R_0801010300 ("0801010300", "Deposito Berjangka pada Bank"),
	R_0801010400 ("0801010400", "Sertifikat Deposito pada Bank"),
	R_0801010500 ("0801010500", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0801010600 ("0801010600", "Surat Berharga Negara "),
	R_0801010700 ("0801010700", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0801010800 ("0801010800", "Obligasi korporasi yang tercatat di bursa efek di indonesia"),
	R_0801010900 ("0801010900", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0801011000 ("0801011000", "Obligasi/Sukuk Daerah"),
	R_0801011100 ("0801011100", "Reksa Dana"),
	R_0801011200 ("0801011200", "MTN"),
	R_0801011300 ("0801011300", "Efek Beragun Aset"),
	R_0801011400 ("0801011400", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_0801011500 ("0801011500", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0801011600 ("0801011600", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0801011700 ("0801011700", "REPO"),
	R_0801011800 ("0801011800", "Penyertaan langsung"),
	R_0801011900 ("0801011900", "Tanah di Indonesia"),
	R_0801012000 ("0801012000", "Bangunan di Indonesia"),
	R_0801012100 ("0801012100", "Tanah dan Bangunan di Indonesia"),
	R_0801012200 ("0801012200", "TOTAL INVESTASI"),
//	R_0801020000 ("0801020000", "ASET LANCAR DI LUAR INVESTASI"),
	R_0801020100 ("0801020100", "Kas dan Bank "),
	R_0801020200 ("0801020200", "Piutang Iuran"),
	R_0801020201 ("0801020201", "- Iuran Normal Pemberi Kerja"),
	R_0801020202 ("0801020202", "- Iuran Normal Peserta"),
	R_0801020203 ("0801020203", "- Iuran Sukarela Peserta"),
	R_0801020204 ("0801020204", "- Iuran Tambahan"),
	R_0801020300 ("0801020300", "Piutang Bunga Keterlambatan Iuran "),
	R_0801020400 ("0801020400", "Beban Dibayar Di Muka "),
	R_0801020500 ("0801020500", "Piutang Investasi"),
	R_0801020600 ("0801020600", "Piutang Hasil Investasi"),
	R_0801020700 ("0801020700", "Piutang Lain-lain"),
	R_0801030000 ("0801030000", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
//	R_0801040000 ("0801040000", "ASET OPERASIONAL"),
	R_0801040100 ("0801040100", "Tanah dan Bangunan"),
	R_0801040200 ("0801040200", "Kendaraan"),
	R_0801040300 ("0801040300", "Peralatan Komputer"),
	R_0801040400 ("0801040400", "Peralatan Kantor"),
	R_0801040500 ("0801040500", "Aset Operasional Lain"),
	R_0801050000 ("0801050000", "TOTAL ASET OPERASIONAL"),
	R_0801060000 ("0801060000", "ASET LAIN-LAIN"),
	R_0802000000 ("0802000000", "ASET TERSEDIA"),
//	R_0803000000 ("0803000000", "LIABILITAS"),
//	R_0803010000 ("0803010000", "Liabilitas di Luar Nilai Kini Aktuarial (PPMP) / Liabilitas di Luar Liabilitas Manfaat Pensiun (PPIP)"),
	R_0803010100 ("0803010100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_0803010200 ("0803010200", "Utang Manfaat Sukarela"),
	R_0803010300 ("0803010300", "Utang Investasi"),
	R_0803010400 ("0803010400", "Pendapatan Diterima di Muka"),
	R_0803010500 ("0803010500", "Beban Yang Masih Harus Di Bayar"),
	R_0803010600 ("0803010600", "Utang Lain"),
	R_0803010700 ("0803010700", "Total Liabilitas di Luar Nilai Kini Aktuarial/Liabilitas Manfaat Pensiun"),
	R_0804000000 ("0804000000", "TOTAL LIABILITAS"),
	R_0805000000 ("0805000000", "ASET NETO"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2007PosRbDppkk0800 eEnum : ER2007PosRbDppkk0800.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2007PosRbDppkk0800.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2007PosRbDppkk0800.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationPiutangIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801020200.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 27),
				"Total Piutang Iuran|Penjumlahan Piutang Iuran");
	}

	public static SegmentValidation genValidationAsetLancarDiluarInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801030000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 23, 28, 29, 30, 31, 32 }),
				"Total Aset Lancar di luar Investasi|Penjumlahan Aset Lancar di luar Investasi");
	}

	public static SegmentValidation genValidationAsetOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801050000.key, 
				UtilMetadata.genPlusRow(getObjects(), 34, 38), 
				"Total Aset Operasional|Penjumlahan Aset Operasional");
	}

	public static SegmentValidation genValidationAsetTersedia() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0802000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 33, 39, 40 }),
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}

	public static SegmentValidation genValidationLiabilitasDiLuarNilaiKiniAktuarialLiabilitasManfaatPensiun() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0803010700.key, 
				UtilMetadata.genPlusRow(getObjects(), 42, 47),
				"Total Liabilitas di Luar Nilai Kini Aktuarial/Liabilitas Manfaat Pensiun|Liabilitas di Luar Nilai Kini Aktuarial/Liabilitas Manfaat Pensiun");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0804000000.key, R_0803010700.key, 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0805000000.key, 
				R_0802000000.key + "-" + R_0804000000.key, 
				"Total Aset Neto|Penjumlahan Aset Neto");
	}

	public static SegmentValidation genValidationFormTotalAsetNeto() {
		String comparatorFormCode = EFormRencanaBisnis.RB_0900.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_0805000000.key, comparatorFormCode, 
				ER2008PosRbDppkk0900.R_0906000000.getKey(), "Nilai Aset Neto|Nilai Aset Neto Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
