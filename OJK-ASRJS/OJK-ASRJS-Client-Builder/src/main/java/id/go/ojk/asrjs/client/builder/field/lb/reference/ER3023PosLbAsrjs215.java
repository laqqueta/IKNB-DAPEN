package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3023PosLbAsrjs215 implements IObject<KeyValueString> {
//	R_2152010000 ("2152010000", "Investasi", "0.00"),
	R_2152010001 ("2152010001", "Saham Syariah", "0.00"),
	R_2152010002 ("2152010002", "Termasuk IDX30 atau JII", "15.00"),
	R_2152010003 ("2152010003", "Saham diperdagangkan di bursa Indonesia", "20.00"),
	R_2152010004 ("2152010004", "Saham diperdagangkan di bursa luar negeri", "30.00"),
	R_2152010005 ("2152010005", "Saham penyusun indeks utama bursa utama negara Asia Pasifik dan Eropa anggota World Federation of Exchanges ", "20.00"),
	R_2152010006 ("2152010006", "Saham Lainnya", "30.00"),
	R_2152010007 ("2152010007", "Reksa Dana Syariah", "0.00"),
	R_2152010008 ("2152010008", "Sepenuhnya berupa surat utang pemerintah", "0.00"),
	R_2152010009 ("2152010009", "Sepenuhnya berupa surat utang swasta dan atau surat  berharga pasar uang (SBPU)", "6.00"),
	R_2152010010 ("2152010010", "Sepenuhnya berupa surat berharga ekuitas", "16.00"),
	R_2152010011 ("2152010011", "Campuran*)", "0.00"),
	R_2152010012 ("2152010012", "Dana Perusahaan", "0.00"),
	R_2152010013 ("2152010013", "Dana Tabarru'", "0.00"),
	R_2152010014 ("2152010014", "PAYDI (digaransi)", "0.00"),
	R_2152010015 ("2152010015", "Efek Beragun Aset Syariah", "0.00"),
	R_2152010016 ("2152010016", "a. Peringkat klaster 1", "1.60"),
	R_2152010017 ("2152010017", "b. Peringkat klaster 2", "2.80"),
	R_2152010018 ("2152010018", "c. Peringkat klaster 3", "4.00"),
	R_2152010019 ("2152010019", "d. Peringkat klaster 4", "6.00"),
	R_2152010020 ("2152010020", "e. Peringkat klaster 5", "12.00"),
	R_2152010021 ("2152010021", "Dana Investasi Real Estat", "10.00"),
	R_2152010022 ("2152010022", "Penyertaan Langsung", "0.00"),
	R_2152010023 ("2152010023", "Dalam Pengawasan OJK", "10.00"),
	R_2152010024 ("2152010024", "Tidak Dalam Pengawasan OJK", "20.00"),
	R_2152010025 ("2152010025", "Penyertaan langsung pada Perusahaan dengan tujuan khusus (SPV)", "0.00"),
	R_2152010026 ("2152010026", "Property Investasi", "0.00"),
	R_2152010027 ("2152010027", "Hasil Investasi 4% atau lebih", "7.00"),
	R_2152010028 ("2152010028", "Hasil Investasi 2% - 4%", "15.00"),
	R_2152010029 ("2152010029", "Hasil Investasi kurang dari 2%", "40.00"),
	R_2152010030 ("2152010030", "Emas murni", "3.00"),
	R_2152010031 ("2152010031", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif", "10.00"),
//	R_2152010032 ("2152010032", "BUKAN INVESTASI", "0.00"),
	R_2152010033 ("2152010033", "Property Bukan Investasi", "4.00"),
	R_2152010034 ("2152010034", "TOTAL", "0.00"),
	;

	private String key;
	private String value;
	private String factor;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3023PosLbAsrjs215 eEnum : ER3023PosLbAsrjs215.values()) {
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
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 6, 10, 14, 21, 25, 32 }));
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genPosLookup("1", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 6, 10, 14, 21, 25, 32 }), getLookup());
	}

	public static FieldValidation genValidation6() {
		return UtilFieldValidation.genPosPercentage("2|5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 6, 10, 14, 21, 25, 32 }), 2);
	}

	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genPosPercentage("3|5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 6, 10, 14, 21, 25, 32 }), 2);
	}

	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genPosPercentage("4|5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 6, 10, 14, 21, 25, 32 }), 2);
	}
	
	public static SegmentValidation genValidationSahamSyariahA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010001.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 5), "Total Saham Syariah|Penjumlahan Saham Syariah");
	}
	
	public static SegmentValidation genValidationSahamSyariahB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010001.key, 
				UtilMetadata.genPlusRow(getObjects(), 1, 5), "Total Saham Syariah|Penjumlahan Saham Syariah", 2);
	}
	
	public static SegmentValidation genValidationReksaDanaSyariahA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010007.key, 
				UtilMetadata.genPlusRow(getObjects(), 7, 10), "Total Reksa Dana Syariah|Penjumlahan Reksa Dana Syariah");
	}
	
	public static SegmentValidation genValidationReksaDanaSyariahB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010007.key, 
				UtilMetadata.genPlusRow(getObjects(), 7, 10), "Total Reksa Dana Syariah|Penjumlahan Reksa Dana Syariah", 2);
	}
	
	public static SegmentValidation genValidationReksaDanaSyariahCampuranA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010011.key, 
				UtilMetadata.genPlusRow(getObjects(), 11, 13), "Total Reksa Dana Syariah Campuran|Penjumlahan Reksa Dana Syariah Campuran");
	}
	
	public static SegmentValidation genValidationReksaDanaSyariahCampuranB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010011.key, 
				UtilMetadata.genPlusRow(getObjects(), 11, 13), "Total Reksa Dana Syariah Campuran|Penjumlahan Reksa Dana Syariah Campuran", 2);
	}
	
	public static SegmentValidation genValidationEfekBeragunAsetSyariahA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010015.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 19), "Total Efek Beragun Aset Syariah|Penjumlahan Efek Beragun Aset Syariah");
	}
	
	public static SegmentValidation genValidationEfekBeragunAsetSyariahB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010015.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 19), "Total Efek Beragun Aset Syariah|Penjumlahan Efek Beragun Aset Syariah", 2);
	}
	
	public static SegmentValidation genValidationPenyertaanLangsungA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010022.key, 
				UtilMetadata.genPlusRow(getObjects(), 22, 24), "Total Penyertaan Langsung|Penjumlahan Penyertaan Langsung");
	}
	
	public static SegmentValidation genValidationPenyertaanLangsungB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010022.key, 
				UtilMetadata.genPlusRow(getObjects(), 22, 24), "Total Penyertaan Langsung|Penjumlahan Penyertaan Langsung", 2);
	}
	
	public static SegmentValidation genValidationPropertyInvestasiA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010026.key, 
				UtilMetadata.genPlusRow(getObjects(), 26, 28), "Total Property Investasi|Penjumlahan Property Investasi");
	}
	
	public static SegmentValidation genValidationPropertyInvestasiB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010026.key, 
				UtilMetadata.genPlusRow(getObjects(), 26, 28), "Total Property Investasi|Penjumlahan Property Investasi", 2);
	}
	
	public static SegmentValidation genValidationTotalA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2152010034.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 6, 14, 20, 21, 25, 29, 30, 31 }), "Total|Penjumlahan Detail");
	}
	
	public static SegmentValidation genValidationTotalB() {
		return UtilSegmentValidation.genEqualsFormula("6|7|8", R_2152010034.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 6, 14, 20, 21, 25, 29, 30, 31 }), "Total|Penjumlahan Detail", 2);
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3023PosLbAsrjs215[] eEnums = ER3023PosLbAsrjs215.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3023PosLbAsrjs215 eEnum = ER3023PosLbAsrjs215.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
