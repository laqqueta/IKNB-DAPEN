package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.constant.EMacro;
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
public enum ER3031PosLbAsrjs223 implements IObject<KeyValueString> {
//	R_2235010000 ("2235010000", "I.Risiko Operasional Perusahaan"),
	R_2235010001 ("2235010001", "a. Beban Umum dan Administrasi "),
	R_2235010002 ("2235010002", "b. Beban Pendidikan dan Pelatihan"),
	R_2235010003 ("2235010003", "c. Risiko Operasional = (1%*(a-b))"),
	R_2235010004 ("2235010004", "d. Saldo Biaya Akuisisi yang Ditangguhkan"),
	R_2235010005 ("2235010005", "e. Risiko Operasional =(50%*d)"),
	R_2235010006 ("2235010006", "f. Sub Total Risiko Operasional Perusahaan (c+e)"),
//	R_2235010007 ("2235010007", "II.Risiko Operasional PAYDI (ROPAYDI)"),
	R_2235010008 ("2235010008", "g. Aset Dana PAYDI "),
	R_2235010009 ("2235010009", "h. Sub Total Risiko Operasional PAYDI (ROPAYDI = (1‰*g))"),
//	R_2235010010 ("2235010010", "III.Risiko Operasional Dana Tabarru' (RODT)"),
	R_2235010011 ("2235010011", "i. Investasi Dana Tabarru' dan Dana Tanahud"),
	R_2235010012 ("2235010012", "j. Sub Total RODT = (1‰*i)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3031PosLbAsrjs223 eEnum : ER3031PosLbAsrjs223.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), 8, 9));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8, 9 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 6, 8 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 4, 5, 7, 9 }));
	}
	
	public static SegmentValidation genValidationRisikoOperasional1() {
		return UtilSegmentValidation.genMultiply("3", R_2235010003.key, UtilMetadata.genMinusRow(getObjects(), 0, 1), 
				".01", 2, "perhitungan Risiko Operasional " + EMacro.EQUALS.getMacro() + " (1%*(a-b))");
	}
	
	public static SegmentValidation genValidationRisikoOperasional2() {
		return UtilSegmentValidation.genMultiply("3", R_2235010005.key, R_2235010004.key, 
				".5", 2, "perhitungan Risiko Operasional " + EMacro.EQUALS.getMacro() + " (50%*d)");
	}
	
	public static SegmentValidation genValidationSubTotalRisikoOperasionalPerusahaan() {
		return UtilSegmentValidation.genEqualsFormula("3", R_2235010006.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 4 }), 
				"Sub Total Risiko Operasional Perusahaan|Penjumlahan Sub Total Risiko Operasional Perusahaan", 2);
	}
	
	public static SegmentValidation genValidationSubTotalRisikoOperasionalPAYDI() {
		return UtilSegmentValidation.genMultiply("3", R_2235010009.key, R_2235010008.key, 
				".001", 2, "perhitungan Sub Total Risiko Operasional PAYDI (ROPAYDI " + EMacro.EQUALS.getMacro() + " (1‰*g))");
	}
	
	public static SegmentValidation genValidationSubTotalRODT() {
		return UtilSegmentValidation.genMultiply("2", R_2235010012.key, R_2235010011.key, 
				".001", 2, "perhitungan Sub Total RODT " + EMacro.EQUALS.getMacro() + " (1‰*i)");
	}
}
