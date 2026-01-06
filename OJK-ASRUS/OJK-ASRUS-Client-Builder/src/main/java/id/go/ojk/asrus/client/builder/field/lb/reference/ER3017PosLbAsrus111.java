package id.go.ojk.asrus.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3017PosLbAsrus111 implements IObject<KeyValueString> {
//	R_2501000099 ("2501000099", "Rasio Likuiditas"),
	R_2501010000 ("2501010000", "A. Kekayaan lancar"),
	R_2501020000 ("2501020000", "B. Kewajiban lancar"),
	R_2501030000 ("2501030000", "C. Rasio (a:b)"),
//	R_2501040000 ("2501040000", "Rasio perimbangan investasi dengan liabilitas"),
	R_2501050000 ("2501050000", "A. Investasi, kas dan bank"),
	R_2501060000 ("2501060000", "B. Penyisihan teknis"),
	R_2501070000 ("2501070000", "C. Utang klaim retensi sendiri"),
	R_2501080000 ("2501080000", "D. Rasio [a:(b+c)]"),
//	R_2501090000 ("2501090000", "Rasio Pendapatan investasi neto"),
	R_2501100000 ("2501100000", "A. Pendapatan investasi netto"),
	R_2501110000 ("2501110000", "B. Rata-rata investasi"),
	R_2501120000 ("2501120000", "C. Rasio (a:b)"),
//	R_2501130000 ("2501130000", "Rasio beban klaim"),
	R_2501140000 ("2501140000", "A. Beban klaim netto"),
	R_2501150000 ("2501150000", "B. Kontribusi netto"),
	R_2501160000 ("2501160000", "C. Rasio (a:b)"),
//	R_2501000000 ("2501000000", "Rasio perubahan dana"),
	R_2502000099 ("2502000099", "A. Dana tahun/triwulan/bulan berjalan"),
	R_2502010000 ("2502010000", "B. Dana tahun/triwulan/bulan lalu"),
	R_2502020000 ("2502020000", "C. Perubahan dana (a-b)"),
	R_2502030000 ("2502030000", "D. Rasio (c:b)"),
//	R_2502040000 ("2502040000", "Rasio Aset Unit Syariah"),
	R_2502050000 ("2502050000", "A. Aset Dana Tabarru"),
	R_2502060000 ("2502060000", "B. Aset Dana Investasi Peserta"),
	R_2502070000 ("2502070000", "C. Aset Dana Asuransi Perusahaan (Konvensional)"),
	R_2502080000 ("2502080000", "D. Rasio (a+b) : (a+b+c)"),
//	R_2502090000 ("2502090000", "Penghitungan Qardh yang Diperlukan Dana Tabarru"),
	R_2502100000 ("2502100000", "A. Jumlah Kewajiban selain Qardh"),
	R_2502110000 ("2502110000", "B. Jumlah Aset"),
	R_2502120000 ("2502120000", "Jumlah Qardh yang Diperlukan (a-b)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3017PosLbAsrus111 eEnum : ER3017PosLbAsrus111.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 4, 5, 6, 10, 11, 12, 21, 22 }));
	}
	
	public static ConditionalRequired genConditional4() {
		return genConditional3();
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 4), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 2, 6, 9, 12, 15, 16, 20, 23 }));
	}
	
	public static SegmentValidation genValidationNumericNegativeA() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 5), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 7, 8, 13, 14, 15, 17, 18, 19, 23 }));
	}
	
	public static SegmentValidation genValidationNumericNegativeB() {
		return UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(new int[] { 2, 5 }), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 4, 5, 10, 11, 21, 22 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegativeA() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(2, 5), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 9, 16, 20 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegativeB() {
		return UtilSegmentValidation.genRegexNumericDotNegative(UtilMetadata.genPipeColumn(new int[] { 2, 5 }), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 12 }));
	}
	
	public static SegmentValidation genValidationMaxLength8() {
		return UtilSegmentValidation.genMaxLength(UtilMetadata.genPipeColumn(2, 5), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 6, 9, 12, 16, 20 }), 8);
	}
	
	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), R_2501030000.key, 
				UtilMetadata.genPipeRow(getObjects(), 0, 1), 
				"Rasio Likuiditas|Perhitungan Rasio Likuiditas");
	}
	
	public static SegmentValidation genValidationRasioPerimbanganInvestasiDenganliabilitas() {
		return UtilSegmentValidation.genEqualsRatio("2|5", R_2501080000.key, 
				R_2501050000.key + "|" + UtilMetadata.genPlusRow(getObjects(), 4, 5), 
				"Rasio perimbangan investasi dengan liabilitas|Perhitungan Rasio perimbangan investasi dengan liabilitas");
	}
	
	public static SegmentValidation genValidationRasioPendapatanInvestasiNeto() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), R_2501120000.key, 
				UtilMetadata.genPipeRow(getObjects(), 7, 8), 
				"Rasio Pendapatan investasi neto|Perhitungan Rasio Pendapatan investasi neto");
	}
	
	public static SegmentValidation genValidationRasioBebanKlaim() {
		return UtilSegmentValidation.genEqualsRatio("2|5", R_2501160000.key, 
				UtilMetadata.genPipeRow(getObjects(), 10, 11), 
				"Rasio beban klaim|Perhitungan Rasio beban klaim");
	}
	
	public static SegmentValidation genValidationPerubahanDana() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_2502020000.key, 
				UtilMetadata.genMinusRow(getObjects(), 13, 14), 
				"Total Perubahan Dana|Perhitungan Perubahan Dana");
	}
	
	public static SegmentValidation genValidationRasioPerubahanDana() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), R_2502030000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 15, 14 }), 
				"Rasio Perubahan Dana|Perhitungan Rasio Perubahan Dana");
	}
	
	public static SegmentValidation genValidationRasioAsetUnitSyariah() {
		return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), R_2502080000.key, 
				UtilMetadata.genPlusRow(getObjects(), 17, 18) + "|" + UtilMetadata.genPlusRow(getObjects(), 17, 19), 
				"Rasio Aset Unit Syariah|Perhitungan Rasio Aset Unit Syariah");
	}
	
	public static SegmentValidation genValidationPenghitunganQardhYangDiperlukanDanaTabarru() {
		return UtilSegmentValidation.genMaxValue(UtilMetadata.genPipeColumn(2, 5), R_2502120000.key, 
				UtilMetadata.genMinusRow(getObjects(), 21, 22), "0", 
				"jumlah Qardh yang Diperlukan max(0,(a-b))");
	}
}
