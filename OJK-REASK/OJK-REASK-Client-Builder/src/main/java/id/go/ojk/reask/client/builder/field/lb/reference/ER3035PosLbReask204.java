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
public enum ER3035PosLbReask204 implements IObject<KeyValueString> {
//	R_2040100099 ("2040100099", "Penurunan ( Kenaikan )  Cadangan Premi"),
	R_2040101000 ("2040101000", "a. Cadangan Premi tahun lalu"),
	R_2040102000 ("2040102000", "b. Cadangan Premi tahun berjalan"),
	R_2040100000 ("2040100000", "Jumlah Penurunan ( Kenaikan )  Cadangan Premi Gross"),
//	R_2040200099 ("2040200099", "Penurunan ( Kenaikan )  Aset Reasuransi Atas Cadangan Premi"),
	R_2040201000 ("2040201000", "a. Aset Reasuransi atas cadangan premi tahun lalu"),
	R_2040202000 ("2040202000", "b. Aset Reasuransi atas cadangan premi tahun berjalan"),
	R_2040200000 ("2040200000", "Jumlah  Penurunan ( Kenaikan )  Aset Reasuransi Atas Cadangan Premi"),
	R_2040300000 ("2040300000", "Jumlah Penurunan ( Kenaikan )  Cadangan Premi"),
//	R_2040300099 ("2040300099", "Penurunan ( Kenaikan )  CAPYBMP"),
	R_2040301000 ("2040301000", "a. CAPYBMP tahun lalu"),
	R_2040302000 ("2040302000", "b. CAPYBMP tahun berjalan"),
	R_2040300098 ("2040300098", "Jumlah  Penurunan ( Kenaikan )  CAPYBMP Gross "),
//	R_2040400099 ("2040400099", "Penurunan ( Kenaikan )  Aset Reasuransi Atas CAPYBMP"),
	R_2040401000 ("2040401000", "a. Aset Reasuransi atas CAPYBMP tahun lalu"),
	R_2040402000 ("2040402000", "b. Aset Reasuransi atas CAPYBMP tahun berjalan"),
	R_2040400000 ("2040400000", "Jumlah  Penurunan ( Kenaikan )  Aset Reasuransi Atas CAPYBMP"),
	R_2040500000 ("2040500000", "Jumlah Penurunan ( Kenaikan )  CAPYBMP"),
//	R_2040600099 ("2040600099", "Penurunan ( Kenaikan ) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2040601000 ("2040601000", "a. Cadangan atas Risiko Bencana  tahun berjalan"),
	R_2040602000 ("2040602000", "b. Cadangan atas Risiko Bencana  tahun lalu"),
	R_2040600000 ("2040600000", "Jumlah   Penurunan ( Kenaikan ) Cadangan atas Risiko Bencana (Catastrophic) Netto"),
//	R_2040700099 ("2040700099", "Kenaikan ( Penurunan )  Cadangan Klaim"),
	R_2040701000 ("2040701000", "a. Cadangan Klaim tahun berjalan"),
	R_2040702000 ("2040702000", "b. Cadangan Klaim tahun lalu"),
	R_2040700000 ("2040700000", "Jumlah  Kenaikan ( Penurunan ) Cadangan Klaim Gross"),
//	R_2040800099 ("2040800099", "Kenaikan ( Penurunan )  Aset Reasuransi Atas Cadangan Klaim"),
	R_2040801000 ("2040801000", "a. Aset Reasuransi atas Cadangan Klaim tahun berjalan"),
	R_2040802000 ("2040802000", "b. Aset Reasuransi atas Cadangan Klaim tahun lalu"),
	R_2040800000 ("2040800000", "Jumlah Kenaikan ( Penurunan )  Aset Reasuransi Atas Cadangan Klaim"),
	R_2040900000 ("2040900000", "Jumlah Kenaikan ( Penurunan )  Cadangan Klaim"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3035PosLbReask204 eEnum : ER3035PosLbReask204.values()) {
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
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 7, 8, 10, 11, 14, 15, 17, 18, 20, 21 }));
	}

	public static SegmentValidation genValidationJumlahPenurunanCadanganPremiGross() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040100000.key, 
				UtilMetadata.genMinusRow(getObjects(), 0, 1), "Total penurunan (kenaikan) cadangan premi gross|Penjumlahan penurunan (kenaikan) cadangan premi gross");
	}

	public static SegmentValidation genValidationJumlahPenurunanAsetReasuransiAtasCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040200000.key, 
				UtilMetadata.genMinusRow(getObjects(), 3, 4), "Total penurunan (kenaikan) aset reasuransi atas cadangan premi|Penjumlahan penurunan (kenaikan) aset reasuransi atas cadangan premi");
	}

	public static SegmentValidation genValidationJumlahPenurunanCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040300000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 2, 5 }), "Total penurunan (kenaikan) cadangan premi|Penjumlahan penurunan (kenaikan) cadangan premi");
	}

	public static SegmentValidation genValidationJumlahPenurunanCAPYBMPGross() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040300098.key, 
				UtilMetadata.genMinusRow(getObjects(), 7, 8), "Total penurunan (kenaikan) CAPYBMP gross|Penjumlahan penurunan (kenaikan) CAPYBMP gross");
	}

	public static SegmentValidation genValidationJumlahPenurunanAsetReasuransiAtasCAPYBMP() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040400000.key, 
				UtilMetadata.genMinusRow(getObjects(), 10, 11), "Total penurunan (kenaikan) aset reasuransi atas CAPYBMP|Penjumlahan penurunan (kenaikan) aset reasuransi atas CAPYBMP");
	}

	public static SegmentValidation genValidationJumlahPenurunanCAPYBMP() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040500000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 9, 12 }), "Total penurunan (kenaikan) CAPYBMP|Penjumlahan penurunan (kenaikan) CAPYBMP");
	}

	public static SegmentValidation genValidationJumlahPenurunanCadanganatasRisikoBencanaNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040600000.key, 
				UtilMetadata.genMinusRow(getObjects(), 14, 15), "Total penurunan (kenaikan) cadangan atas risiko bencana (catastrophic) netto|Penjumlahan penurunan (kenaikan) cadangan atas risiko bencana (catastrophic) netto");
	}

	public static SegmentValidation genValidationJumlahPenurunanCadanganKlaimGross() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040700000.key, 
				UtilMetadata.genMinusRow(getObjects(), 17, 18), "Total kenaikan (penurunan) cadangan klaim gross|Penjumlahan kenaikan (penurunan) cadangan klaim gross");
	}

	public static SegmentValidation genValidationJumlahPenurunanAsetReasuransiAtasCadanganKlaim() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040800000.key, 
				UtilMetadata.genMinusRow(getObjects(), 20, 21), "Total kenaikan (penurunan) aset reasuransi atas cadangan klaim|Penjumlahan kenaikan (penurunan) aset reasuransi atas cadangan klaim");
	}

	public static SegmentValidation genValidationJumlahPenurunanCadanganKlaim() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18", R_2040900000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 19, 22 }), "Total kenaikan (penurunan) cadangan klaim|Penjumlahan kenaikan (penurunan) cadangan klaim");
	}
}
