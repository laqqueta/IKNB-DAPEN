package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3046PosLbAsrjk601 implements IObject<KeyValueString> {
//	R_7001000099 ("7001000099", "Rasio Likuiditas"),
	R_7001010000 ("7001010000", "a. Aset Lancar"),
	R_7001020000 ("7001020000", "b. Liabilitas Lancar"),
	R_7001000000 ("7001000000", "c. Rasio (a : b)"),
//	R_7002000099 ("7002000099", "Rasio Kecukupan Investasi"),
	R_7002010000 ("7002010000", "a. Investasi + Kas & Bank (Lihat Neraca SAP)"),
	R_7002020000 ("7002020000", "b. Cadangan Teknis Retensi Sendiri"),
	R_7002030000 ("7002030000", "c. Utang Klaim Retensi Sendiri + Utang Lain Kepada Tertanggung"),
	R_7002000000 ("7002000000", "d. Rasio (a : (b + c))"),
//	R_7003000099 ("7003000099", "Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto"),
	R_7003010000 ("7003010000", "a. Hasil Investasi"),
	R_7003020000 ("7003020000", "b. Pendapatan Premi Neto"),
	R_7003000000 ("7003000000", "c. Rasio (a : b)"),
//	R_7004000099 ("7004000099", "Rasio Beban Klaim, Beban Usaha, dan Komisi"),
	R_7004010000 ("7004010000", "a. Beban Klaim Neto"),
	R_7004020000 ("7004020000", "b. Beban Usaha"),
	R_7004030000 ("7004030000", "c. Komisi Neto"),
	R_7004040000 ("7004040000", "d. Pendapatan Premi Neto"),
	R_7004050000 ("7004050000", "e. Rasio a : d (rasio I)"),
	R_7004060000 ("7004060000", "f.  Rasio b : d (rasio II) "),
	R_7004070000 ("7004070000", "g. Rasio c : d (rasio III)"),
	R_7004000000 ("7004000000", "h. Rasio I + Rasio II + Rasio III"),
//	R_7005000000 ("7005000000", "Pertumbuhan Investasi"),
	R_1400000000 ("1400000000", "a. Jumlah investasi bulan ini (Mo)"),
	R_7005010000 ("7005010000", "b. Jumlah investasi bulan lalu (M-1)"),
	R_7005030000 ("7005030000", "c. Pertumbuhan Investasi = (a-b)/b"),
//	R_7006000099 ("7006000099", "Pertumbuhan Ekuitas"),
	R_3000000000 ("3000000000", "a. Jumlah ekuitas bulan ini (Mo)"),
	R_7006010000 ("7006010000", "b. Jumlah ekuitas bulan lalu (M-1)"),
	R_7006000000 ("7006000000", "c. Pertumbuhan ekuitas = (a-b)/b"),
//	R_7007000099 ("7007000099", "Pertumbuhan RKI"),
	R_7002000098 ("7002000098", "a. RKI bulan ini (Mo)"),
	R_7007010000 ("7007010000", "b. RKI bulan lalu (M-1)"),
	R_7007000000 ("7007000000", "c. Pertumbuhan RKI = (a - b)"),
//	R_7008000099 ("7008000099", "Pertumbuhan RBC"),
	R_7000000000 ("7000000000", "a. RBC bulan ini (Mo)"),
	R_7008010000 ("7008010000", "b. RBC bulan lalu (M-1)"),
	R_7008000000 ("7008000000", "c. Pertumbuhan RBC = (a - b)"),
//	R_7009000099 ("7009000099", "Pertumbuhan Aset"),
	R_1000000000 ("1000000000", "a. Jumlah aset bulan ini (Mo)"),
	R_7009010000 ("7009010000", "b. Jumlah aset bulan lalu (M-1)"),
	R_7009000000 ("7009000000", "c. Pertumbuhan aset = (a-b)/b"),
//	R_7010000099 ("7010000099", "Pertumbuhan (delta) Premi "),
	R_7010010000 ("7010010000", "a. Jumlah (delta) Premi  bulan ini (Mo)"),
	R_7010020000 ("7010020000", "b. Jumlah (delta) Premi  bulan lalu (M-1)"),
	R_7010000000 ("7010000000", "c. Pertumbuhan (delta) Premi  = (a-b)/b"),
//	R_7011000099 ("7011000099", "Pertumbuhan(delta) Klaim "),
	R_7011010000 ("7011010000", "a. Jumlah (delta) klaim bulan ini (Mo)"),
	R_7011020000 ("7011020000", "b. Jumlah (delta) klaim bulan lalu (M-1)"),
	R_7011000000 ("7011000000", "c. Pertumbuhan (delta) klaim  = (a-b)/b"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3046PosLbAsrjk601 eEnum : ER3046PosLbAsrjk601.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3046PosLbAsrjk601.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3046PosLbAsrjk601.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genValueCheckPos("M", "O", "2", UtilMetadata.genPipeRow(getObjects(), new int[] { 26, 29, 32, 35, 38 }), -5, 5, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 23 }), -5, UtilMetadata.genPipeRow(getObjects(), new int[] { 27 }), 180, 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 20, 23, 26, 27, 29, 32, 35, 38 }));
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 4, 5, 7, 8, 10, 11, 12, 13, 18, 19, 21, 22, 30, 31, 33, 34, 36, 37 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 6, 9, 14, 15, 16, 17, 20, 23, 24, 25, 26, 27, 28, 29, 32, 35, 38 }));
	}
	
	public static SegmentValidation genValidationRasioLikuiditas() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7001000000.key, 
				UtilMetadata.genPipeRow(getObjects(), 0, 1), "Rasio likuiditas|Perhitungan rasio likuiditas");
	}
	
	public static SegmentValidation genValidationRasioKecukupanInvestasi() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7002000000.key, 
				R_7002010000.key + "|" + UtilMetadata.genPlusRow(getObjects(), 4, 5), "Rasio kecukupan investasi|Perhitungan rasio kecukupan investasi");
	}
	
	public static SegmentValidation genValidationRasioPerimbanganHasilInvestasiDenganPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7003000000.key, 
				UtilMetadata.genPipeRow(getObjects(), 7, 8), "Rasio perimbangan hasil investasi dengan pendapatan premi neto|Perhitungan rasio perimbangan hasil investasi dengan pendapatan premi neto");
	}
	
	public static SegmentValidation genValidationRasioI() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7004050000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 10, 13 }), "Rasio I|Perhitungan rasio I");
	}
	
	public static SegmentValidation genValidationRasioII() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7004060000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 13 }), "Rasio II|Perhitungan rasio II");
	}
	
	public static SegmentValidation genValidationRasioIII() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7004070000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 13 }), "Rasio III|Perhitungan rasio III");
	}
	
	public static SegmentValidation genValidationTotalRasio123() {
		return UtilSegmentValidation.genEqualsFormula("2", R_7004000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 14, 16), "Total rasio|Penjumlahan rasio I,  rasio II, rasio III", 2);
	}
	
	public static SegmentValidation genValidationPertumbuhanInvestasi() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7005030000.key, 
				UtilMetadata.genMinusRow(getObjects(), 18, 19) + "|" + R_7005010000.key, "Pertumbuhan investasi|Perhitungan pertumbuhan investasi");
	}
	
	public static SegmentValidation genValidationPertumbuhanEkuitas() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7006000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 21, 22) + "|" + R_7006010000.key, "Pertumbuhan ekuitas|Perhitungan pertumbuhan ekuitas");
	}
	
	public static SegmentValidation genValidationPertumbuhanRKI() {
		return UtilSegmentValidation.genEqualsFormula("2", R_7007000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 24, 25), "Pertumbuhan RKI|Perhitungan pertumbuhan RKI");
	}
	
	public static SegmentValidation genValidationPertumbuhanRBC() {
		return UtilSegmentValidation.genEqualsFormula("2", R_7008000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 27, 28), "Pertumbuhan RBC|Perhitungan pertumbuhan RBC");
	}
	
	public static SegmentValidation genValidationPertumbuhanAset() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7009000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 30, 31) + "|" + R_7009010000.key, "Pertumbuhan aset|Perhitungan pertumbuhan aset");
	}
	
	public static SegmentValidation genValidationPertumbuhanPremi() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7010000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 33, 34) + "|" + R_7010020000.key, "Pertumbuhan (delta) premi|Perhitungan pertumbuhan (delta) premi");
	}
	
	public static SegmentValidation genValidationPertumbuhanKlaim() {
		return UtilSegmentValidation.genEqualsRatio("2", R_7011000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 36, 37) + "|" + R_7011020000.key, "Pertumbuhan (delta) klaim|Perhitungan pertumbuhan (delta) klaim");
	}
}
