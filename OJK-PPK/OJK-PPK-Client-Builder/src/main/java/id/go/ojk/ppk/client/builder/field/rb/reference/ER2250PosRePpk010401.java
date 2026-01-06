package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2250PosRePpk010401 implements IObject<KeyValueString> {
	R_01040101000000 ("01040101000000", "Total Aset"), 
	R_01040102000000 ("01040102000000", "Total Piutang Pembiayaan"),
	R_01040102010000 ("01040102010000", "Pembiayaan Investasi"),
	R_01040102020000 ("01040102020000", "Pembiayaan Modal Kerja"),
	R_01040102030000 ("01040102030000", "Pembiayaan Multiguna"),
	R_01040102040000 ("01040102040000",
			"Kegiatan Usaha Pembiayaan Lainnya Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_01040102050000 ("01040102050000", "Pembiayaan Berdasarkan Prinsip Syariah"),
	R_01040103000000 ("01040103000000", "Pinjaman Dalam Negeri"),
	R_01040104000000 ("01040104000000", "Pinjaman Luar Negeri"),
	R_01040105000000 ("01040105000000", "Penerbitan Surat Berharga"), 
	R_01040106000000 ("01040106000000", "Ekuitas"),
	R_01040107000000 ("01040107000000", "Laba (Rugi)"),
	R_01040108000000 ("01040108000000", "Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga"),
	R_01040108010000 ("01040108010000", "Pembiayaan Penerusan (Channeling)"),
	R_01040108020000 ("01040108020000", "Pembiayaan Bersama (Joint Financing)"),
	R_01040109000000 ("01040109000000", "Rasio Permodalan (%)"), 
	R_01040110000000 ("01040110000000", "Rasio NPF Bruto"),
	R_01040111000000 ("01040111000000", "Rasio NPF Neto"),
//	R_01040112000000 ("01040112000000", "Rentabilitas"),
	R_01040112010000 ("01040112010000", "Return on Asset"), 
	R_01040112020000 ("01040112020000", "Return on Equity"),
	R_01040112030000 ("01040112030000", "Beban Operasional terhadap Pendapatan Operasional"),
	R_01040112040000 ("01040112040000", "Net Interest Margin"),
//	R_01040113000000 ("01040113000000", "Likuiditas"),
	R_01040113010000 ("01040113010000", "Current Ratio"), 
	R_01040113020000 ("01040113020000", "Cash Ratio"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2250PosRePpk010401 eEnum : ER2250PosRePpk010401.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2250PosRePpk010401.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2250PosRePpk010401.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), 0, 14));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), 15, 23));
	}

	public static SegmentValidation genValidationTotalPiutangPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 6),
				"Total Piutang Pembiayaan|Penjumlahan Piutang Pembiayaan");
	}

	public static SegmentValidation genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040108000000.key,
				R_01040108010000.key + "+" + R_01040108020000.key,
				"Total Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Penjumlahan Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga");
	}

	public static SegmentValidation genValidationFormTotalAset() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040101000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020101100000.getKey(), 
				"Total Aset|Jumlah Aset form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPiutang() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040102000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020101030000.getKey(), 
				"Total Piutang Pembiayaan|Nilai Piutang Pembiayaan - Neto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenerbitanSuratBerharga() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040105000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020102050000.getKey(), 
				"Nilai Penerbitan Surat Berharga|Nilai Surat Berharga yang Diterbitkan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormEkuitas() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040106000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020103060000.getKey(), 
				"Nilai Ekuitas|Nilai Ekuitas form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormLaba() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040107000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020103040000.getKey(), 
				"Nilai Laba (Rugi)|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenyaluran() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100501.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040108000000.key, comparatorFormCode, 
				ER2270PosRePpk100501.R_10050104000000.getKey(), 
				"Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioPermodalan() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040109000000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11010700000000.getKey(), 
				"Nilai Rasio Permodalan|Nilai Rasio Permodalan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpfBruto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040110000000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11010800000000.getKey(), 
				"Nilai Rasio NPF Bruto|Nilai NPF Gross form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpfNeto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040111000000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11010900000000.getKey(), 
				"Nilai Rasio NPF Neto|Nilai NPF Netto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoa() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112010000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011100000000.getKey(), 
				"Nilai ROA|Nilai ROA form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoe() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112020000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011000000000.getKey(), 
				"Nilai ROE|Nilai ROE form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormBopo() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112030000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011200000000.getKey(), 
				"Nilai BOPO|Nilai BOPO form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormNim() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112040000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011300000000.getKey(), 
				"Nilai NIM|Nilai NIM form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCurrentRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040113010000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011400000000.getKey(), 
				"Nilai Current Ratio|Nilai Current Ratio form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCashRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040113020000.key, comparatorFormCode, 
				ER2271PosRePpk110100.R_11011500000000.getKey(), 
				"Nilai Cash Ratio|Nilai Cash Ratio form " + comparatorFormCode + " #kolom#");
	}
}
