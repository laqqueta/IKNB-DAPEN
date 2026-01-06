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
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3031PosLbReask201 implements IObject<KeyValueString> {
//	R_4000000099 ("4000000099", "PENDAPATAN UNDERWRITING"),
//	R_4100000099 ("4100000099", "Premi Bruto"),
	R_4101010000 ("4101010000", "a. Premi Penutupan Langsung"),
	R_4101020000 ("4101020000", "b. Premi Penutupan Tidak Langsung"),
	R_4101000000 ("4101000000", "Jumlah Pendapatan Premi"),
	R_4102000000 ("4102000000", "c. Komisi Dibayar"),
	R_4100000000 ("4100000000", "Jumlah Premi Bruto"),
//	R_4200000099 ("4200000099", "Premi Reasuransi"),
	R_4201000000 ("4201000000", "a. Premi Reasuransi Dibayar"),
	R_4202000000 ("4202000000", "b. Komisi Reasuransi Diterima"),
	R_4200000000 ("4200000000", "Jumlah Premi Reasuransi "),
	R_4300000000 ("4300000000", "Premi Neto "),
//	R_4400000099 ("4400000099", "Penurunan (Kenaikan) Cadangan Premi, CAPYBMP, dan Cadangan Catastrophic"),
	R_4401000000 ("4401000000", "a. Penurunan (kenaikan) Cadangan Premi "),
	R_4402000000 ("4402000000", "b. Penurunan (kenaikan) Cadangan CAPYBMP"),
	R_4403000000 ("4403000000", "c. Penurunan (kenaikan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_4400000000 ("4400000000", "Jumlah Penurunan (Kenaikan) Cadangan Premi, CAPYBMP, dan Cadangan Catastrophic"),
	R_4500000000 ("4500000000", "Pendapatan Premi Neto "),
	R_4600000000 ("4600000000", "Pendapatan Underwriting Lain Neto"),
	R_4000000000 ("4000000000", "Pendapatan Underwriting"),
//	R_5400000099 ("5400000099", "BEBAN UNDERWRITING"),
//	R_5401000099 ("5401000099", " Beban Klaim"),
	R_5401010000 ("5401010000", " a. Klaim Bruto"),
	R_5401020000 ("5401020000", " b. Klaim Reasuransi"),
	R_5401030000 ("5401030000", " c. Kenaikan (Penurunan) Cadangan Klaim"),
	R_5401000000 ("5401000000", "Jumlah Beban Klaim Neto "),
	R_5402000000 ("5402000000", "Beban Underwriting Lain Neto"),
	R_5400000000 ("5400000000", "Beban Underwriting"),
	R_5500000000 ("5500000000", "HASIL UNDERWRITING "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3031PosLbReask201 eEnum : ER3031PosLbReask201.values()) {
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
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 5, 6, 9, 10, 11, 14, 16, 17, 18, 20}));
	}
	
	public static SegmentValidation genValidationJumlahPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4101000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), "Total pendapatan premi|Penjumlahan pendapatan premi");
	}
	
	public static SegmentValidation genValidationJumlahPremiBruto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4100000000.key, 
				R_4101000000.key + "-" + R_4102000000.key, "Total premi bruto|Perhitungan premi bruto");
	}
	
	public static SegmentValidation genValidationJumlahPremiReasuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4200000000.key, 
				R_4201000000.key + "-" + R_4202000000.key, "Total premi reasuransi|Perhitungan premi reasuransi");
	}
	
	public static SegmentValidation genValidationPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4300000000.key, 
				R_4100000000.key + "-" + R_4200000000.key, "Total premi neto|Perhitungan premi neto");
	}
	
	public static SegmentValidation genValidationJumlahPenurunanCadanganPremiCAPYBMPCadanganCatastrophic() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 9, 11), "Total penurunan (kenaikan) cadangan premi, CAPYBMP, dan cadangan catastrophic|Penjumlahan penurunan (kenaikan) cadangan premi, CAPYBMP, dan cadangan catastrophic");
	}
	
	public static SegmentValidation genValidationPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 8, 12 }), "Total pendapatan premi neto|Penjumlahan pendapatan premi neto");
	}
	
	public static SegmentValidation genValidationPendapatanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_4000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 13, 14 }), "Total pendapatan underwriting|Penjumlahan pendapatan underwriting");
	}
	
	public static SegmentValidation genValidationJumlahBebanKlaimNeto () {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_5401000000.key, 
				R_5401010000.key + "-" + R_5401020000.key + "+" + R_5401030000.key, 
				"Total beban klaim neto|Perhitungan beban klaim neto");
	}
	
	public static SegmentValidation genValidationBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_5400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 20 }), "Total beban underwriting|Penjumlahan beban underwriting");
	}
	
	public static SegmentValidation genValidationTotalUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_5500000000.key, 
				R_4000000000.key + "-" + R_5400000000.key, "Total underwriting|Perhitungan underwriting");
	}
	
	public static SegmentValidation genFormValidationPremiPenutupanLangsung() {
		return UtilSegmentValidation.genEqualsForm("18", R_4101010000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_4101010000.getKey());
	}
	
	public static SegmentValidation genFormValidationPremiPenutupanTidakLangsung() {
		return UtilSegmentValidation.genEqualsForm("18", R_4101020000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_4101020000.getKey());
	}
	
	public static SegmentValidation genFormValidationPendapatanUnderwriting() {
		return UtilSegmentValidation.genEqualsForm("18", R_4000000000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_4000000000.getKey());
	}
	
	public static SegmentValidation genFormValidationKlaimBruto() {
		return UtilSegmentValidation.genEqualsForm("18", R_5401010000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_5401010000.getKey());
	}
	
	public static SegmentValidation genFormValidationBebanUnderwriting() {
		return UtilSegmentValidation.genEqualsForm("18", R_5400000000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_5400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationHasilUnderwriting() {
		return UtilSegmentValidation.genEqualsForm("18", R_5500000000.key, EFormLaporanBulanan.LB_200.getCode(), "5", 
				ER3006PosLbReask200.R_5500000000.getKey());
	}
}
