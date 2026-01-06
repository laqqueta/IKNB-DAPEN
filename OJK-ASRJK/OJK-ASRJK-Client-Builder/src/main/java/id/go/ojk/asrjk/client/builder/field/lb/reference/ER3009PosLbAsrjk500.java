package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3009PosLbAsrjk500 implements IObject<KeyValueString> {
//	R_7000000098 ("7000000098", "Tingkat Solvabilitas"),
	R_7100000000 ("7100000000", "Aset Yang Diperkenankan"),
	R_7200000000 ("7200000000", "Liabilitas (kecuali Pinjaman Subordinasi) -/-"),
	R_7000000000 ("7000000000", "Jumlah Tingkat Solvabilitas"),
//	R_7300000099 ("7300000099", "Modal Minimum Berbasis Risiko (MMBR)"),
//	R_7301000099 ("7301000099", "Risiko Kredit"),
	R_7301010000 ("7301010000", "a. Risiko Kredit a (Risiko Kegagalan Debitur)"),
	R_7301020000 ("7301020000", "b. Risiko Kredit b (Risiko Kegagalan Reasuradur)"),
	R_7301000000 ("7301000000", "Jumlah Risiko Kredit"),
	R_7302000000 ("7302000000", "Risiko Likuiditas"),
//	R_7303000099 ("7303000099", "Risiko Pasar"),
	R_7303010000 ("7303010000", "a. Risiko pasar a (Risiko Perubahan Harga Pasar)"),
	R_7303020000 ("7303020000", "b. Risiko pasar b (Risiko Perubahan Nilai Tukar Mata Uang Asing)"),
	R_7303030000 ("7303030000", "c. Risiko pasar c  (Risiko Perubahan Tingkat Bunga)"),
	R_7303000000 ("7303000000", "Jumlah Risiko Pasar"),
	R_7304000000 ("7304000000", "Risiko Asuransi"),
	R_7305000000 ("7305000000", "Risiko Operasional"),
	R_7300000000 ("7300000000", "Jumlah MBBR"),
	R_7400000000 ("7400000000", "Kelebihan (Kekurangan) Batas Tingkat Solvabilitas"),
	R_7000000099 ("7000000099", "Rasio Pencapaian Solvabilitas (dalam %)"),
	R_7501000000 ("7501000000", "Dalam hal Perusahaan mengalami kekurangan solvabilitas, jumlah dana yang dibutuhkan untuk mencapai rasio RBC 100%"),
	R_7502000000 ("7502000000", "Dalam hal Perusahaan mengalami kekurangan solvabilitas, jumlah dana yang dibutuhkan untuk mencapai target solvabilitas"),
	R_7601000000 ("7601000000", "Target RBC"),
	R_7602000000 ("7602000000", "Realisasi RBC"),
	R_7701000000 ("7701000000", "Penyebab tidak tercapainya target rasio solvabilitas triwulan/tahun berjalan:"),
	R_7702000000 ("7702000000", "Penyebab penurunan tingkat solvabilitas >50% meskipun masih memenuhi ketentuan:"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3009PosLbAsrjk500 eEnum : ER3009PosLbAsrjk500.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3009PosLbAsrjk500.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3009PosLbAsrjk500.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5", getObjects());
	}
	
	public static ConditionalRequired genConditionalExistPos2() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 21 }));
	}
	
	public static ConditionalRequired genConditionalExistPos3() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 14, 15, 20, 21 }));
	}
	
	public static ConditionalRequired genConditionalExistPos4() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 12, 14, 15, 16, 17, 20, 21 }));
	}
	
	public static ConditionalRequired genConditionalExistPos5() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 16, 17, 20, 21 }));
	}
	
	public static ConditionalRequired genConditionalExistPos6() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 18, 19 }));
	}
	
	public static ConditionalRequired genConditionalExistPos7() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 18, 19 }));
	}
	
	public static FieldValidation genValidationField5a() {
		return UtilFieldValidation.genEqualsPosFormula("3", 
				UtilMetadata.genPipeRow(getObjects(), 11, 12));
	}
	
	public static FieldValidation genValidationField5b() {
		return UtilFieldValidation.genEqualsPosFormula("3+4", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 6, 7, 8, 9 }));
	}
	
	public static SegmentValidation genValidationNumericNegative1() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 0, 14));
	}
	
	public static SegmentValidation genValidationNumericDotNegative1() {
		return UtilSegmentValidation.genRegexNumericDotNegative("5", R_7000000099.key);
	}
	
//	public static SegmentValidation genValidationNumericDotNegativeLength1() {
//		return UtilSegmentValidation.genMaxLength("5", R_7000000099.key, 16);
//	}
//	
	public static SegmentValidation genValidationNumericNegative2() {
		return UtilSegmentValidation.genRegexNumericNegative("3", 
				UtilMetadata.genPipeRow(getObjects(), 16, 17));
	}
	
	public static SegmentValidation genValidationNumericDotNegative3() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 18, 19));
	}
	
	public static SegmentValidation genValidationNumericDotNegativeLength3() {
		return UtilSegmentValidation.genMaxLength("3|4|5", UtilMetadata.genPipeRow(getObjects(), 18, 19), 6);
	}

	public static SegmentValidation genValidationTingkatSovabilitas() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_7000000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 0, 1),
				"Jumlah tingkat solvabilitas|Perhitungan tingkat solvabilitas");
	}

	public static SegmentValidation genValidationResikoKredit() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_7301000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 3, 4),
				"Jumlah resiko kredit|Penjumlahan resiko kredit");
	}

	public static SegmentValidation genValidationResikoPasar() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_7303000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 7, 9),
				"Total resiko pasar|Penjumlahan resiko pasar");
	}

	public static SegmentValidation genValidationMbbr() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_7300000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 6, 10, 11, 12 }),
				"Jumlah MBBR|Penjumlahan MBBR");
	}

	public static SegmentValidation genValidationBatasTingkatSolvabilitas() {
		return UtilSegmentValidation.genEqualsFormula("5", R_7400000000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 2, 13}),
				"Total Kelebihan (Kekurangan) Batas Tingkat Solvabilitas|Perhitungan Kelebihan (Kekurangan) Batas Tingkat Solvabilitas");
	}

	public static SegmentValidation genValidationPencapaianSolvabilitas() {
		return UtilSegmentValidation.genEqualsRatio("5", R_7000000099.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 13 }),
				"Rasio pencapaian solvabilitas|Perhitungan rasio pencapaian solvabilitas");
	}
}
