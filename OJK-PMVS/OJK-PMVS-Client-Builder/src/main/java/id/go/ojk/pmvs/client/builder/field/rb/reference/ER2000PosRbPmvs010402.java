package id.go.ojk.pmvs.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvs.client.builder.field.EFormRencanaBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2000PosRbPmvs010402 implements IObject<KeyValueString> {
	R_01040201000000 ("01040201000000", "Total Aset"),
	R_01040202000000 ("01040202000000", "Total Investasi Modal Ventura"),
	R_01040202010000 ("01040202010000", "a.    Penyertaan Saham"),
	R_01040202020000 ("01040202020000", "b.   Pembelian Sukuk atau Obligasi Syariah Konversi"),
	R_01040202030000 ("01040202030000", "c.  Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha "),
	R_01040202040000 ("01040202040000", "d.   Pembiayaan Berdasarkan Prinsip Bagi Hasil "),
	R_01040202050000 ("01040202050000", "e.    Kegiatan Usaha Lain Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_01040203000000 ("01040203000000", "Penyertaan pada Dana Ventura"),
	R_01040204000000 ("01040204000000", "Pendanaan Dalam Negeri"),
	R_01040205000000 ("01040205000000", "Pendanaan Luar Negeri"),
	R_01040206000000 ("01040206000000", "Penerbitan Surat Berharga"),
	R_01040207000000 ("01040207000000", "Ekuitas"),
	R_01040208000000 ("01040208000000", "Laba (Rugi)"),
	R_01040209000000 ("01040209000000", "Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga"),
	R_01040209010000 ("01040209010000", "a. Pembiayaan Penerusan (Channeling)"),
	R_01040209020000 ("01040209020000", "b. Pembiayaan Bersama (Joint Financing)"),
	R_01040210000000 ("01040210000000", "Rasio Non Performing Investment and  Financing/NPIF Bruto"),
	R_01040211000000 ("01040211000000", "Rasio Non Performing Investment and  Financing/NPIF Neto"),
//	R_01040212000000 ("01040212000000", "Rentabilitas"),
	R_01040212010000 ("01040212010000", "a.    Return on Asset"),
	R_01040212020000 ("01040212020000", "b.   Return on Equity"),
	R_01040212030000 ("01040212030000", "c.    Beban Operasional terhadap Pendapatan Operasional"),
//	R_01040213000000 ("01040213000000", "Likuiditas"),
	R_01040213010000 ("01040213010000", "Current Ratio"),
	R_01040213020000 ("01040213020000", "Cash Ratio"),
	R_01040214000000 ("01040214000000", "Nilai Dana Ventura yang dikelola"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2000PosRbPmvs010402 eEnum : ER2000PosRbPmvs010402.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2000PosRbPmvs010402.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2000PosRbPmvs010402.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 16, 17, 18, 19, 20, 21, 22 }));
	}

	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 16, 22));
	}

	public static SegmentValidation genValidationTotalInvestasiModalVentura() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_01040202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 6),
				"Total Investasi Modal Ventura|Penjumlahan Investasi Modal Ventura");
	}

	public static SegmentValidation genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_01040209000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 15),
				"Total Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Penjumlahan Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga");
	}

	public static SegmentValidation genValidationFormTotalAset() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040201000000.key, comparatorFormCode, 
				ER2014PosRbPmvs100202.R_10020201110000.getKey(), 
				"Total Aset|Jumlah Aset form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormTotalInvestasiModalVentura() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040202000000.key, comparatorFormCode, 
				ER2014PosRbPmvs100202.R_10020201030000.getKey(), 
				"Total Investasi Modal Ventura|Nilai Investasi Modal Ventura berdasarkan Prinsip Syariah - Neto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenerbitanSuratBerharga() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040206000000.key, comparatorFormCode, 
				ER2014PosRbPmvs100202.R_10020202050000.getKey(), 
				"Nilai Penerbitan Surat Berharga|Nilai Surat Berharga yang Diterbitkan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormEkuitas() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040207000000.key, comparatorFormCode, 
				ER2014PosRbPmvs100202.R_10020203060000.getKey(), 
				"Nilai Ekuitas|Jumlah Ekuitas form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormLaba() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040208000000.key, comparatorFormCode, 
				ER2014PosRbPmvs100202.R_10020203040000.getKey(), 
				"Nilai Laba (Rugi)|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPembiayaanPenerusan() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100502.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040209010000.key, comparatorFormCode, 
				ER2017PosRbPmvs100502.R_10050205000000.getKey(), 
				"Nilai Pembiayaan Penerusan (Channeling)|Nilai Pembiayaan Penerusan (Channeling) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpifBruto() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040210000000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11010500000000.getKey(), 
				"Nilai Rasio NPIF Bruto|Nilai NPIF Gross (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpifNeto() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040211000000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11010600000000.getKey(), 
				"Nilai Rasio NPIF Neto|Nilai NPIF Netto (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoa() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040212010000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11010800000000.getKey(), 
				"Nilai ROA|Nilai ROA (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoe() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040212020000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11010700000000.getKey(), 
				"Nilai ROE|Nilai ROE (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormBopo() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040212030000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11010900000000.getKey(), 
				"Nilai BOPO|Nilai BOPO (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCurrentRatio() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040213010000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11011000000000.getKey(), 
				"Nilai Current Ratio|Nilai Current Ratio (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCashRatio() {
		String comparatorFormCode = EFormRencanaBisnis.RB_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040213020000.key, comparatorFormCode, 
				ER2018PosRbPmvs110100.R_11011100000000.getKey(), 
				"Nilai Cash Ratio|Nilai Cash Ratio (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormNilaiDanaVenturaYangdikelola() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100502.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_01040214000000.key, comparatorFormCode, 
				ER2017PosRbPmvs100502.R_10050203000000.getKey(), 
				"Total Nilai Dana Ventura yang dikelola|Total Nilai Dana Ventura yang dikelola form " + comparatorFormCode + " #kolom#");
	}
}
