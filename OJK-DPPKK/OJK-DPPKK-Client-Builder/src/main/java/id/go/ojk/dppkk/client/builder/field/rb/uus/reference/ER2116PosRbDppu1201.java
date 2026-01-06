package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2116PosRbDppu1201 implements IObject<KeyValueString> {
//	R_12010100000000 ("12010100000000", "ASET"),
//	R_12010101000000 ("12010101000000", "INVESTASI"),
	R_12010101010000 ("12010101010000", "Tabungan pada Bank"),
	R_12010101020000 ("12010101020000", "Deposito on call pada Bank"),
	R_12010101030000 ("12010101030000", "Deposito Berjangka pada Bank"),
	R_12010101040000 ("12010101040000", "Sertifikat Deposito pada Bank"),
	R_12010101050000 ("12010101050000", "Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_12010101060000 ("12010101060000", "Surat Berharga Syariah Negara "),
	R_12010101070000 ("12010101070000", "Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_12010101080000 ("12010101080000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_12010101090000 ("12010101090000", "Sukuk Daerah"),
	R_12010101100000 ("12010101100000", "Reksa Dana Syariah"),
	R_12010101110000 ("12010101110000", "MTN Syariah"),
	R_12010101120000 ("12010101120000", "Efek Beragun Aset Syariah"),
	R_12010101130000 ("12010101130000", "Dana investasi real estat syariah berbentuk kontrak investasi kolektif"),
	R_12010101140000 ("12010101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_12010101150000 ("12010101150000", "Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_12010101160000 ("12010101160000", "Repo"),
	R_12010101170000 ("12010101170000", "Penyertaan langsung"),
	R_12010101180000 ("12010101180000", "Tanah di Indonesia"),
	R_12010101190000 ("12010101190000", "Bangunan di Indonesia"),
	R_12010101200000 ("12010101200000", "Tanah dan Bangunan di Indonesia"),
	R_12010102000000 ("12010102000000", "Total Investasi"),
//	R_12010103000000 ("12010103000000", "ASET LANCAR DI LUAR INVESTASI"),
	R_12010103010000 ("12010103010000", "Kas dan Bank "),
	R_12010103020000 ("12010103020000", "Piutang Iuran"),
	R_12010103020100 ("12010103020100", "Iuran Normal Pemberi Kerja"),
	R_12010103020200 ("12010103020200", "Iuran Normal Peserta"),
	R_12010103020300 ("12010103020300", "Iuran Sukarela Peserta"),
	R_12010103020400 ("12010103020400", "Iuran Tambahan"),
	R_12010103030000 ("12010103030000", "Beban Dibayar Di Muka "),
	R_12010103040000 ("12010103040000", "Piutang Investasi"),
	R_12010103050000 ("12010103050000", "Piutang Hasil Investasi"),
	R_12010103060000 ("12010103060000", "Piutang Lain-lain"),
	R_12010104000000 ("12010104000000", "Total Aset Lancar Di Luar Investasi"),
//	R_12010105000000 ("12010105000000", "ASET OPERASIONAL"),
	R_12010105010000 ("12010105010000", "Tanah dan Bangunan"),
	R_12010105020000 ("12010105020000", "Kendaraan"),
	R_12010105030000 ("12010105030000", "Peralatan Komputer"),
	R_12010105040000 ("12010105040000", "Peralatan Kantor"),
	R_12010105050000 ("12010105050000", "Aset Operasional Lain"),
	R_12010106000000 ("12010106000000", "Total Aset Operasional"),
	R_12010107000000 ("12010107000000", "Aset Lain-Lain"),
	R_12010200000000 ("12010200000000", "Aset Tersedia"),
//	R_12010300000000 ("12010300000000", "LIABILITAS"),
	R_12010301000000 ("12010301000000", "Liabilitas di Luar Nilai Kini Aktuarial (PPMP)"),
//	R_12010302000000 ("12010302000000", "Liabilitas di Luar Liabilitas Manfaat Pensiun (PPIP)"),
	R_12010303000000 ("12010303000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
	R_12010304000000 ("12010304000000", "Utang Manfaat Sukarela"),
	R_12010305000000 ("12010305000000", "Utang Dana Ta’zir"),
	R_12010306000000 ("12010306000000", "Utang Investasi"),
	R_12010307000000 ("12010307000000", "Pendapatan Diterima di Muka"),
	R_12010308000000 ("12010308000000", "Beban Yang Masih Harus Di Bayar"),
	R_12010309000000 ("12010309000000", "Utang Lain"),
	R_12010400000000 ("12010400000000", "Total Liabilitas di luar liabilitas manfaat pensiun"),
	R_12010500000000 ("12010500000000", "Total Liabilitas"),
	R_12010600000000 ("12010600000000", "Aset Neto"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2116PosRbDppu1201 eEnum : ER2116PosRbDppu1201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2116PosRbDppu1201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2116PosRbDppu1201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidationTotalInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 19),
				"Total Investasi|Penjumlahan Investasi");
	}
	
	public static SegmentValidation genValidationPiutangIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010103020000.key,
				UtilMetadata.genPlusRow(getObjects(), 23, 26),
				"Total Piutang Iuran|Penjumlahan Piutang Iuran");
	}
	
	public static SegmentValidation genValidationTotalAsetLancarDiluarInvestasi() {
		int[] fields = new int[] { 21, 22, 27, 28, 29, 30 };
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010104000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				"Total Aset Lancar Di luar Investasi|Penjumlahan Aset Lancar Di luar Investasi");
	}
	
	public static SegmentValidation genValidationTotalAsetOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010106000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 36),
				"Total Aset Operasional|Penjumlahan Aset Operasional");
	}
	
	public static SegmentValidation genValidationTotalAsetTersedia() {
		int[] fields = new int[] { 20, 31, 37, 38 };
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				"Total Aset Tersedia|Penjumlahan Aset Tersedia");
	}
	
	public static SegmentValidation genValidationTotalLiabilitasDiluarNilaiKiniAktuarial() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 41, 47),
				"Total Liabilitas di Luar Nilai Kini Aktuarial|Penjumlahan Liabilitas di Luar Nilai Kini Aktuarial");
	}
	
	public static SegmentValidation genValidationTotalLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010500000000.key,
				R_12010301000000.key + "+" + R_12010400000000.key, "Total Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010600000000.key,
				R_12010200000000.key + "-" + R_12010500000000.key, "Total Aset Neto|Perhitungan Aset Neto");
	}

	public static SegmentValidation genValidationFormAsetNeto() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_1202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_12010600000000.key, comparatorFormCode, 
				ER2117PosRbDppu1202.R_1202070000.getKey(), "Total Aset Neto|Total Aset Neto Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
