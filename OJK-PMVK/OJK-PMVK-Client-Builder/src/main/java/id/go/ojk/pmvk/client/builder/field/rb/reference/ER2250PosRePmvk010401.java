package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2250PosRePmvk010401 implements IObject<KeyValueString> {
	R_01040101000000 ("01040101000000", "Total Aset"),
	R_01040102000000 ("01040102000000", "Total Pembiayaan/Penyertaan Modal Ventura"),
	R_01040102010000 ("01040102010000", "a.   Penyertaan Saham"),
	R_01040102020000 ("01040102020000", "b.   Penyertaan Melalui Pembelian Obligasi Konversi"),
	R_01040102030000 ("01040102030000", "c.   Pembiayaan Melalui Pembelian Surat Utang yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha"),
	R_01040102040000 ("01040102040000", "d.   Pembiayaan Usaha Produktif"),
	R_01040102050000 ("01040102050000", "e.   Kegiatan Usaha Berdasarkan Persetujuan Otoritas Jasa Keuangan"),
	R_01040102060000 ("01040102060000", "f.   Investasi Modal Ventura Berdasarkan Prinsip Syariah"),
	R_01040103000000 ("01040103000000", "Penyertaan pada Dana Ventura"),
	R_01040104000000 ("01040104000000", "Pinjaman Dalam Negeri"),
	R_01040105000000 ("01040105000000", "Pinjaman Luar Negeri"),
	R_01040106000000 ("01040106000000", "Penerbitan Surat Berharga"),
	R_01040107000000 ("01040107000000", "Ekuitas"),
	R_01040108000000 ("01040108000000", "Laba (Rugi)"),
	R_01040109000000 ("01040109000000", "Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga"),
	R_01040109010000 ("01040109010000", "Pembiayaan Penerusan (Channeling)"),
	R_01040109020000 ("01040109020000", "Pembiayaan Bersama (Joint Financing)"),
	R_01040110000000 ("01040110000000", "Rasio Non Performing Investment and Financing/NPIF Bruto"),
	R_01040111000000 ("01040111000000", "Rasio Non Performing Investment and Financing/NPIF Neto"),
//	R_01040112000000 ("01040112000000", "Rentabilitas"),
	R_01040112010000 ("01040112010000", "a.   Return on Asset"),
	R_01040112020000 ("01040112020000", "b.   Return on Equity"),
	R_01040112030000 ("01040112030000", "c.   Beban Operasional terhadap Pendapatan Operasional"),
//	R_01040113000000 ("01040113000000", "Likuiditas"),
	R_01040113010000 ("01040113010000", "Current Ratio"),
	R_01040113020000 ("01040113020000", "Cash Ratio"),
	R_01040114000000 ("01040114000000", "Nilai Dana Ventura yang dikelola"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2250PosRePmvk010401 eEnum : ER2250PosRePmvk010401.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2250PosRePmvk010401.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2250PosRePmvk010401.class.getSimpleName().substring(2, 6));
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
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 17, 18, 19, 20, 21, 22, 23}));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
				UtilMetadata.genPipeRow(getObjects(), 17, 23));
	}

	public static SegmentValidation genValidationTotalPembiayaanPenyertaanModalVentura() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 7),
				"Total Pembiayaan/Penyertaan Modal Ventura|Penjumlahan Pembiayaan/Penyertaan Modal Ventura");
	}

	public static SegmentValidation genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01040109000000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 16),
				"Total Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Penjumlahan Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga");
	}

	public static SegmentValidation genValidationFormTotalAset() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040101000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020101120000.getKey(), 
				"Total Aset|Jumlah Aset form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormTotalPembiayaanPenyertaanModalVentura() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040102000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020101030000.getKey(), 
				"Total Pembiayaan/Penyertaan Modal Ventura|Nilai Pembiayaan/Penyertaan Modal Ventura - Neto form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenerbitanSuratBerharga() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040106000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020102050000.getKey(), 
				"Nilai Penerbitan Surat Berharga|Nilai Surat Berharga yang Diterbitkan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormEkuitas() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040107000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020103060000.getKey(), 
				"Nilai Ekuitas|Jumlah Ekuitas form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormLaba() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040108000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020103040000.getKey(), 
				"Nilai Laba (Rugi)|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormPenyaluran() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100501.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040109000000.key, comparatorFormCode, 
				ER2267PosRePmvk100501.R_10050105000000.getKey(), 
				"Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga|Nilai Penyaluran Pembiayaan Bersama Porsi Pihak Ketiga form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpifBruto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040110000000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11010500000000.getKey(), 
				"Nilai Rasio NPIF Bruto|Nilai NPIF Gross (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRasioNpifNeto() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040111000000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11010600000000.getKey(), 
				"Nilai Rasio NPIF Neto|Nilai NPIF Netto (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoa() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112010000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11010800000000.getKey(), 
				"Nilai ROA|Nilai ROA (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormRoe() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112020000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11010700000000.getKey(), 
				"Nilai ROE|Nilai ROE (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormBopo() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040112030000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11010900000000.getKey(), 
				"Nilai BOPO|Nilai BOPO (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCurrentRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040113010000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11011000000000.getKey(), 
				"Nilai Current Ratio|Nilai Current Ratio (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormCashRatio() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_110100.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040113020000.key, comparatorFormCode, 
				ER2268PosRePmvk110100.R_11011100000000.getKey(), 
				"Nilai Cash Ratio|Nilai Cash Ratio (%) form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormNilaiDanaVenturaYangdikelola() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100501.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_01040114000000.key, comparatorFormCode, 
				ER2017PosRbPmvk100501.R_10050103000000.getKey(), 
				"Nilai Dana Ventura yang dikelola|Nilai Dana Ventura yang dikelola form " + comparatorFormCode + " #kolom#");
	}
}
