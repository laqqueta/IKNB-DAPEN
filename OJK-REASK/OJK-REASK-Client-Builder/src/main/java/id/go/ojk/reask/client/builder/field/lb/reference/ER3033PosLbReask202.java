package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3033PosLbReask202 implements IObject<KeyValueString> {
//	R_4401010099 ("4401010099", "Premi Bruto"),
//	R_4401010100 ("4401010100", "a. Premi Penutupan Langsung"),
	R_4401010101 ("4401010101", "-Dalam Negeri"),
	R_4401010102 ("4401010102", "-ASEAN"),
	R_4401010199 ("4401010199", "-Lainnya"),
//	R_4401010200 ("4401010200", "b. Premi Penutupan Tidak Langsung"),
	R_4401010201 ("4401010201", "-Dalam Negeri"),
	R_4401010202 ("4401010202", "-ASEAN"),
	R_4401010299 ("4401010299", "-Lainnya"),
//	R_4401010300 ("4401010300", "c. Jumlah Pendapatan Premi"),
	R_4401010301 ("4401010301", "-Dalam Negeri"),
	R_4401010302 ("4401010302", "-ASEAN"),
	R_4401010399 ("4401010399", "-Lainnya"),
//	R_4401010400 ("4401010400", "d. Komisi Dibayar"),
	R_4401010401 ("4401010401", "-Dalam Negeri"),
	R_4401010402 ("4401010402", "-ASEAN"),
	R_4401010499 ("4401010499", "-Lainnya"),
	R_4401010000 ("4401010000", "Jumlah Premi Bruto"),
//	R_4401020099 ("4401020099", "Premi Reasuransi"),
//	R_4401020100 ("4401020100", "a. Premi Reasuransi Dibayar"),
	R_4401020101 ("4401020101", "-Dalam Negeri"),
	R_4401020102 ("4401020102", "-ASEAN"),
	R_4401020199 ("4401020199", "-Lainnya"),
//	R_4401020200 ("4401020200", "b. Komisi Reasuransi Diterima"),
	R_4401020201 ("4401020201", "-Dalam Negeri"),
	R_4401020202 ("4401020202", "-ASEAN"),
	R_4401020299 ("4401020299", "-Lainnya"),
	R_4401020000 ("4401020000", "Jumlah Premi Reasuransi "),
//	R_4401030099 ("4401030099", " Beban Klaim"),
//	R_4401030100 ("4401030100", " a. Klaim Bruto"),
	R_4401030101 ("4401030101", "-Dalam Negeri"),
	R_4401030102 ("4401030102", "-ASEAN"),
	R_4401030199 ("4401030199", "-Lainnya"),
//	R_4401030200 ("4401030200", " b. Klaim Reasuransi"),
	R_4401030201 ("4401030201", "-Dalam Negeri"),
	R_4401030202 ("4401030202", "-ASEAN"),
	R_4401030299 ("4401030299", "-Lainnya"),
	R_4401030000 ("4401030000", "Jumlah Klaim Retensi Sendiri"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3033PosLbReask202 eEnum : ER3033PosLbReask202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", getObjects());
	}
	
	public static FieldValidation genFieldValidation18() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 9, 10, 11, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25 }));
	}
	
	public static SegmentValidation genValidationJumlahPendapatanPremiDalamNegeri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401010301.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 3 }), "Total pendapatan premi dalam negeri|Penjumlahan pendapatan premi dalam negeri");
	}
	
	public static SegmentValidation genValidationJumlahPendapatanPremiAsean() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401010302.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 4 }), "Total pendapatan premi ASEAN|Penjumlahan pendapatan premi ASEAN");
	}
	
	public static SegmentValidation genValidationJumlahPendapatanPremiLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401010399.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 5 }), "Total pendapatan premi lainnya|Penjumlahan pendapatan premi lainnya");
	}
	
	public static SegmentValidation genValidationJumlahPremiBruto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 6, 8) + "-" + UtilMetadata.genMinusRow(getObjects(), 9, 11), 
				"Total premi bruto|Perhitungan premi bruto");
	}
	
	public static SegmentValidation genValidationJumlahPremiReasuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 13, 15) + "-" + UtilMetadata.genMinusRow(getObjects(), 16, 18), 
				"Total premi reasuransi|Perhitungan premi reasuransi");
	}
	
	public static SegmentValidation genValidationJumlahKlaimRetensiSendiri() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4401030000.key, 
				UtilMetadata.genPlusRow(getObjects(), 20, 22) + "-" + UtilMetadata.genMinusRow(getObjects(), 23, 25), 
				"Total klaim retensi sendiri|Perhitungan klaim retensi sendiri");
	}
}
