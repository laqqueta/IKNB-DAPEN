package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2250PosRePps010402 implements IObject<KeyValueString> {
	R_01040201000000 ("01040201000000", "Total Aset"),
	R_01040202000000 ("01040202000000", "Total Piutang Pembiayaan Syariah"),
	R_01040202010000 ("01040202010000", "Pembiayaan Jual Beli"),
	R_01040202020000 ("01040202020000", "Pembiayaan Investasi"),
	R_01040202030000 ("01040202030000", "Pembiayaan Jasa"),
	R_01040203000000 ("01040203000000", "Pendanaan Dalam Negeri"),
	R_01040204000000 ("01040204000000", "Pendanaan Luar Negeri"),
	R_01040205000000 ("01040205000000", "Penerbitan Surat Berharga"),
	R_01040206000000 ("01040206000000", "Ekuitas"),
	R_01040207000000 ("01040207000000", "Laba (Rugi)"),
	R_01040208000000 ("01040208000000", "Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga"),
	R_01040208010000 ("01040208010000", "Pembiayaan Penerusan (Channeling)"),
	R_01040208020000 ("01040208020000", "Pembiayaan Bersama (Joint Financing)"),
	R_01040209000000 ("01040209000000", "Rasio Permodalan (%)"),
	R_01040210000000 ("01040210000000", "Rasio Aset Produktif Bermasalah Bruto"),
	R_01040211000000 ("01040211000000", "Rasio Aset Produktif Bermasalah Neto"),
//	R_01040212000000 ("01040212000000", "Rentabilitas"),
	R_01040212010000 ("01040212010000", "Return on Asset"),
	R_01040212020000 ("01040212020000", "Return on Equity"),
	R_01040212030000 ("01040212030000", "Beban Operasional terhadap Pendapatan Operasional"),
	R_01040212040000 ("01040212040000", "Net Interest Margin"),
//	R_01040213000000 ("01040213000000", "Likuiditas"),
	R_01040213010000 ("01040213010000", "Current Ratio"),
	R_01040213020000 ("01040213020000", "Cash Ratio"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2250PosRePps010402 eEnum : ER2250PosRePps010402.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2250PosRePps010402.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2250PosRePps010402.class.getSimpleName().substring(2, 6));
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
				UtilMetadata.genPipeRow(getObjects(), 0, 12));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), 13, 21));
	}

	public static SegmentValidation genValidationTotalPiutangPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 4),
				"Total Piutang Pembiayaan Syariah|Penjumlahan Piutang Pembiayaan Syariah");
	}

	public static SegmentValidation genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040208000000.key,
				R_01040208010000.key + "+" + R_01040208020000.key,
				"Total Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Penjumlahan Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga");
	}

	public static SegmentValidation genValidationFormTotalAset() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040201000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020201100000.getKey(), "Total Aset|Jumlah Aset form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPiutang() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040202000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020201030000.getKey(), "Total Piutang Pembiayaan Syariah|Nilai Piutang Pembiayaan - Neto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenerbitanSuratBerharga() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040205000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020202050000.getKey(), "Nilai Penerbitan Surat Berharga|Nilai Surat Berharga Syariah yang Diterbitkan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormEkuitas() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040206000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020203060000.getKey(), "Nilai Ekuitas|Jumlah Ekuitas form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormLaba() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040207000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020203040000.getKey(), "Nilai Laba (Rugi)|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenyaluran() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100502.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040208000000.key, comparatorFormCode, 
				ER2271PosRePps100502.R_10050204000000.getKey(), "Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioPermodalan() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040209000000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11020700000000.getKey(), "Nilai Rasio Permodalan|Nilai Rasio Permodalan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpfBruto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040210000000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11020800000000.getKey(), "Nilai Rasio Aset Produktif Bermasalah Bruto|Nilai Rasio Aset Produktif Bermasalah Gross form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpfNeto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040211000000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11020900000000.getKey(), "Nilai Rasio Aset Produktif Bermasalah Neto|Nilai Rasio Aset Produktif Bermasalah Netto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoa() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040212010000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021100000000.getKey(), "Nilai ROA|Nilai ROA form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoe() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040212020000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021000000000.getKey(), "Nilai ROE|Nilai ROE form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormBopo() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040212030000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021200000000.getKey(), "Nilai BOPO|Nilai BOPO form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormNim() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040212040000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021300000000.getKey(), "Nilai NIM|Nilai NIM form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCurrentRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040213010000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021400000000.getKey(), "Nilai Current Ratio|Nilai Current Ratio form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCashRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040213020000.key, comparatorFormCode, 
				ER2272PosRePps110200.R_11021500000000.getKey(), "Nilai Cash Ratio|Nilai Cash Ratio form " + comparatorFormCode + " #kolom#");
	}
}
