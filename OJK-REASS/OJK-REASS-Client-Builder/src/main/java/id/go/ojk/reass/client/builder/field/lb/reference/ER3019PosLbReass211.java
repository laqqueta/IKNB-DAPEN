package id.go.ojk.reass.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3019PosLbReass211 implements IObject<KeyValueString> {
	R_2111000001 ("2111000001", "Investasi", "0"),
//	R_2111000002 ("2111000002", "Deposito Berjangka dan Sertifikat Deposito", "0"),
	R_2111000003 ("2111000003", "Kategori Khusus (sampai dengan 2 milyar per bank)", "0.00"),
	R_2111000004 ("2111000004", "Kategori Lain, sesuai peringkat Bank:", "0.00"),
	R_2111000005 ("2111000005", "a. Peringkat klaster 1", "1.20"),
	R_2111000006 ("2111000006", "b. Peringkat klaster 2", "2.10"),
	R_2111000007 ("2111000007", "c. Peringkat klaster 3", "3.00"),
	R_2111000008 ("2111000008", "d. Peringkat klaster 4", "4.50"),
	R_2111000009 ("2111000009", "e. Peringkat klaster 5", "9.00"),
	R_2111000010 ("2111000010", "Sukuk / Obligasi Korporasi Syariah", "0.00"),
	R_2111000011 ("2111000011", "a. Peringkat klaster 1", "1.60"),
	R_2111000012 ("2111000012", "b. Peringkat klaster 2", "2.80"),
	R_2111000013 ("2111000013", "c. Peringkat klaster 3", "4.00"),
	R_2111000014 ("2111000014", "d. Peringkat klaster 4", "6.00"),
	R_2111000015 ("2111000015", "e. Peringkat klaster 5", "12.00"),
	R_2111000016 ("2111000016", "MTN Syariah", "0.00"),
	R_2111000017 ("2111000017", "a. Peringkat klaster 1", "1.60"),
	R_2111000018 ("2111000018", "b. Peringkat klaster 2", "2.80"),
	R_2111000019 ("2111000019", "c. Peringkat klaster 3", "4.00"),
	R_2111000020 ("2111000020", "d. Peringkat klaster 4", "6.00"),
	R_2111000021 ("2111000021", "e. Peringkat klaster 5", "12.00"),
	R_2111000022 ("2111000022", "Surat Berharga Syariah Negara", "0.00"),
	R_2111000023 ("2111000023", "Surat Berharga Yang Diterbitkan oleh Bank Indonesia", "0.00"),
	R_2111000024 ("2111000024", "Surat Berharga Yang Diterbitkan oleh Negara selain Negara RI ", "0.00"),
	R_2111000025 ("2111000025", "a. Peringkat klaster 1", "1.60"),
	R_2111000026 ("2111000026", "b. Peringkat klaster 2", "2.80"),
	R_2111000027 ("2111000027", "c. Peringkat klaster 3", "4.00"),
	R_2111000028 ("2111000028", "d. Peringkat klaster 4", "6.00"),
	R_2111000029 ("2111000029", "e. Peringkat klaster 5", "12.00"),
	R_2111000030 ("2111000030", "Surat Berharga yang diterbitkan oleh Lembaga Multinasional", "0.00"),
	R_2111000031 ("2111000031", "REPO", "1.00"),
	R_2111000032 ("2111000032", "Pembiayaan Melalui Kerjasama dengan Pihak Lain*", "0.00"),
	R_2111000033 ("2111000033", "a.Sangat sehat", "1.60"),
	R_2111000034 ("2111000034", "b.Sehat", "2.80"),
	R_2111000035 ("2111000035", "c.Kurang sehat", "4.00"),
	R_2111000036 ("2111000036", "d.Tidak sehat", "6.00"),
	R_2111000037 ("2111000037", "Pinjaman yang Dijamin dengan Hak Tanggungan", "0.00"),
	R_2111000038 ("2111000038", "Properti residensial", "0.00"),
	R_2111000039 ("2111000039", "a. LTV < 65%", "2.80"),
	R_2111000040 ("2111000040", "b. 65% < LTV < 75%", "4.00"),
	R_2111000041 ("2111000041", "Properti komersial lainnya", "0.00"),
	R_2111000042 ("2111000042", "a. LTV < 65%", "5.60"),
	R_2111000043 ("2111000043", "b. 65% < LTV < 75%", "8.00"),
	R_2111000044 ("2111000044", "Properti yang tidak digunakan", "12.00"),
	R_2111000045 ("2111000045", "Sukuk Daerah", "0.00"),
	R_2111000046 ("2111000046", "a. Peringkat klaster 1", "1.60"),
	R_2111000047 ("2111000047", "b. Peringkat klaster 2", "2.80"),
	R_2111000048 ("2111000048", "c. Peringkat klaster 3", "4.00"),
	R_2111000049 ("2111000049", "d. Peringkat klaster 4", "6.00"),
	R_2111000050 ("2111000050", "e. Peringkat klaster 5", "12.00"),
	R_2111000051 ("2111000051", "Bukan Investasi", "0.00"),
	R_2111000052 ("2111000052", "Kas dan Bank", "0.00"),
	R_2111000053 ("2111000053", "Tagihan Kontribusi Penutupan Langsung", "8.00"),
	R_2111000054 ("2111000054", "Aset Reasuransi", "0.00"),
	R_2111000055 ("2111000055", "a. aset yang bersumber dari nilai estimasi pemulihan klaim atas porsi pertanggungan ulang (dicharge dalam Risiko Kredit b)", "0.00"),
	R_2111000056 ("2111000056", "b. aset yang bersumber dari perjanjian kontrak jangka panjang program reasuransi dukungan modal (capital oriented reinsurance)", "30.00"),
	R_2111000057 ("2111000057", "Tagihan Klaim Koasuransi", "0.00"),
	R_2111000058 ("2111000058", "Dalam Negeri", "2.80"),
	R_2111000059 ("2111000059", "Luar Negeri:", "0.00"),
	R_2111000060 ("2111000060", "a. Peringkat klaster 1", "2.80"),
	R_2111000061 ("2111000061", "b. Peringkat klaster 2", "4.00"),
	R_2111000062 ("2111000062", "c. Peringkat klaster 3", "6.00"),
	R_2111000063 ("2111000063", "d. Peringkat klaster 4", "12.00"),
	R_2111000064 ("2111000064", "e. Peringkat klaster 5", "15.00"),
	R_2111000065 ("2111000065", "Tagihan Kontribusi Reasuransi", "0.00"),
	R_2111000066 ("2111000066", "Dalam Negeri", "2.80"),
	R_2111000067 ("2111000067", "Luar Negeri", "0.00"),
	R_2111000068 ("2111000068", "Peringkat Klaster 1", "2.80"),
	R_2111000069 ("2111000069", "Peringkat Klaster 2", "4.00"),
	R_2111000070 ("2111000070", "Peringkat Klaster 3", "6.00"),
	R_2111000071 ("2111000071", "Peringkat Klaster 4", "12.00"),
	R_2111000072 ("2111000072", "Peringkat Klaster 5", "15.00"),
	R_2111000073 ("2111000073", "Tagihan Klaim Reasuransi ", "0.00"),
	R_2111000074 ("2111000074", "Dalam Negeri", "2.80"),
	R_2111000075 ("2111000075", "Luar Negeri:", "0.00"),
	R_2111000076 ("2111000076", "a. Peringkat klaster 1", "2.80"),
	R_2111000077 ("2111000077", "b. Peringkat klaster 2", "4.00"),
	R_2111000078 ("2111000078", "c. Peringkat klaster 3", "6.00"),
	R_2111000079 ("2111000079", "d. Peringkat klaster 4", "12.00"),
	R_2111000080 ("2111000080", "e. Peringkat klaster 5", "15.00"),
	R_2111000081 ("2111000081", "Tagihan Investasi", "0.00"),
	R_2111000082 ("2111000082", "a. Investasi yang belum diterima pembayarannya pada tanggal jatuh tempo", "2.00"),
	R_2111000083 ("2111000083", "b. Investasi yang gagal bayar pada tanggal jatuh tempo/saat dicairkan", "25.00"),
	R_2111000084 ("2111000084", "Tagihan Hasil Investasi", "2.00"),
	R_2111000085 ("2111000085", "Total", "0.00"),
	;

	private String key;
	private String value;
	private String factor;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3019PosLbReass211 eEnum : ER3019PosLbReass211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 8), getObjects());
	}
	
	public static ConditionalRequired genConditional5() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 2, 8, 14, 22, 30, 35, 36, 39, 43, 49, 52, 55, 57, 63, 65, 71, 73, 79, 83 }));
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 2, 8, 14, 22, 30, 35, 36, 39, 43, 49, 52, 55, 57, 63, 65, 71, 73, 79, 83 }), 
				getLookup());
	}
	
	public static FieldValidation genValidation6() {
		return UtilFieldValidation.genPosPercentage("2|5", UtilMetadata.genPipeRowExcept(getObjects(), 
				new int[] { 0, 2, 8, 14, 22, 30, 35, 36, 39, 43, 49, 52, 55, 57, 63, 65, 71, 73, 79, 83 }), 0);
	}
	
	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genPosPercentage("3|5", UtilMetadata.genPipeRowExcept(getObjects(), 
				new int[] { 0, 2, 8, 14, 22, 30, 35, 36, 39, 43, 49, 52, 55, 57, 63, 65, 71, 73, 79, 83 }), 0);
	}
	
	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genPosPercentage("4|5", UtilMetadata.genPipeRowExcept(getObjects(), 
				new int[] { 0, 2, 8, 14, 22, 30, 35, 36, 39, 43, 49, 52, 55, 57, 63, 65, 71, 73, 79, 83 }), 0);
	}
	
	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000001.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 2, 8, 14, 20, 21, 22, 28, 29, 30, 35, 43}), 
				"Total Investasi|Penjumlahan Investasi");
	}
	
	public static SegmentValidation genValidationKategoriLainSesuaiPeringkatBank() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000004.key, UtilMetadata.genPlusRow(getObjects(), 3, 7), 
				"Total Kategori Lain, sesuai peringkat Bank|Penjumlahan Kategori Lain, sesuai peringkat Bank");
	}
	
	public static SegmentValidation genValidationSukukObligasiKorporasiSyariah() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000010.key, UtilMetadata.genPlusRow(getObjects(), 9, 13), 
				"Total Sukuk / Obligasi Korporasi Syariah|Penjumlahan Sukuk / Obligasi Korporasi Syariah");
	}
	
	public static SegmentValidation genValidationMTNSyariah() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000016.key, UtilMetadata.genPlusRow(getObjects(), 15, 19), 
				"Total MTN Syariah|Penjumlahan MTN Syariah");
	}
	
	public static SegmentValidation genValidationSuratBerhargaYangDiterbitkanOlehNegaraSelainNegaraRI() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000024.key, UtilMetadata.genPlusRow(getObjects(), 23, 27), 
				"Total Surat Berharga Yang Diterbitkan oleh Negara selain Negara RI|Penjumlahan Surat Berharga Yang Diterbitkan oleh Negara selain Negara RI");
	}
	
	public static SegmentValidation genValidationPembiayaanMelaluiKerjasamaDenganPihakLain() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000032.key, UtilMetadata.genPlusRow(getObjects(), 31, 34), 
				"Total Pembiayaan Melalui Kerjasama dengan Pihak Lain|Penjumlahan Pembiayaan Melalui Kerjasama dengan Pihak Lain");
	}
	
	public static SegmentValidation genValidationPinjamanYangDijaminDenganHakTanggungan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000037.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 36, 39, 42 }), 
				"Total Pinjaman yang Dijamin dengan Hak Tanggungan|Penjumlahan Pinjaman yang Dijamin dengan Hak Tanggungan");
	}
	
	public static SegmentValidation genValidationPropertiResidensial() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000038.key, UtilMetadata.genPlusRow(getObjects(), 37, 38), 
				"Total Properti residensial|Penjumlahan Properti residensial");
	}
	
	public static SegmentValidation genValidationPropertiKomersialLainnya() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000041.key, UtilMetadata.genPlusRow(getObjects(), 40, 41), 
				"Total Properti komersial lainnya|Penjumlahan Properti komersial lainnya");
	}
	
	public static SegmentValidation genValidationSukukDaerah() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000045.key, UtilMetadata.genPlusRow(getObjects(), 44, 48), 
				"Total Sukuk Daerah|Penjumlahan Sukuk Daerah");
	}
	
	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000051.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 50, 51, 52, 55, 63, 71, 79, 82 }), 
				"Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}
	
	public static SegmentValidation genValidationAsetReasuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000054.key, UtilMetadata.genPlusRow(getObjects(), 53, 54), 
				"Total Aset Reasuransi|Penjumlahan Aset Reasuransi");
	}
	
	public static SegmentValidation genValidationTagihanKlaimKoasuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000057.key, UtilMetadata.genPlusRow(getObjects(), 56, 57), 
				"Total Tagihan Klaim Koasuransi|Penjumlahan Tagihan Klaim Koasuransi");
	}
	
	public static SegmentValidation genValidationTagihanKlaimKoasuransiLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000059.key, UtilMetadata.genPlusRow(getObjects(), 58, 62), 
				"Total Tagihan Klaim Koasuransi Luar Negeri|Penjumlahan Tagihan Klaim Koasuransi Luar Negeri");
	}
	
	public static SegmentValidation genValidationTagihanKontribusiReasuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000065.key, UtilMetadata.genPlusRow(getObjects(), 64, 65), 
				"Total Tagihan Kontribusi Reasuransi|Penjumlahan Tagihan Kontribusi Reasuransi");
	}
	
	public static SegmentValidation genValidationTagihanKontribusiReasuransiLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000067.key, UtilMetadata.genPlusRow(getObjects(), 66, 70), 
				"Total Tagihan Kontribusi Reasuransi Luar Negeri|Penjumlahan Tagihan Kontribusi Reasuransi Luar Negeri");
	}
	
	public static SegmentValidation genValidationTagihanKlaimReasuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000073.key, UtilMetadata.genPlusRow(getObjects(), 72, 73), 
				"Total Tagihan Klaim Reasuransi|Penjumlahan Tagihan Klaim Reasuransi");
	}
	
	public static SegmentValidation genValidationTagihanKlaimReasuransiLuarNegeri() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000075.key, UtilMetadata.genPlusRow(getObjects(), 74, 78), 
				"Total Tagihan Klaim Reasuransi Luar Negeri|Penjumlahan Tagihan Klaim Reasuransi Luar Negeri");
	}
	
	public static SegmentValidation genValidationTagihanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000081.key, UtilMetadata.genPlusRow(getObjects(), 80, 81), 
				"Total Tagihan Investasi|Penjumlahan Tagihan Investasi");
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 6, 7, 8 }), 
				R_2111000085.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 49 }), "Total|Penjumlahan Detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3019PosLbReass211[] eEnums = ER3019PosLbReass211.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3019PosLbReass211 eEnum = ER3019PosLbReass211.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
