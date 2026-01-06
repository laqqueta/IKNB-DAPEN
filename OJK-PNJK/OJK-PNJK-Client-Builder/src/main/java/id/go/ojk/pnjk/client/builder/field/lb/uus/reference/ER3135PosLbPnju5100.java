package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

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
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3035PosLbPnjk5100;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3135PosLbPnju5100 implements IObject<KeyValueString> {
	R_5100010000 ("5100010000", "Rasio Likuiditas", "10.00"),
	R_5100020000 ("5100020000", "Gearing Ratio", "35.00"),
//	R_5100030000 ("5100030000", "Rentabilitas", ""),
	R_5100030100 ("5100030100", "Return on Asset (ROA)", "30.00"),
	R_5100030200 ("5100030200", "Beban Operasional/ Pendapatan Operasional (BOPO)", "35.00"),
	R_5100030300 ("5100030300", "Klaim terhadap Pendapatan IJK", "35.00"),
	R_5100040000 ("5100040000", "Komposit Rentabilitas", "35.00"),
	R_5100050000 ("5100050000", "Self-assessment Good Corporate Governance (GCG)", "20.00"),
	R_5100060000 ("5100060000", "Total Komposit Kesehatan Keuangan", ""),
	R_5100070000 ("5100070000", "Kategori Kesehatan Keuangan Perusahaan", ""),
	;

	@Getter
	private String key;
	private String value;
	private String bobot;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3135PosLbPnju5100 eEnum : ER3135PosLbPnju5100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3135PosLbPnju5100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3135PosLbPnju5100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	
	public static SegmentValidation genValidationNumericDot2() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2",
				UtilMetadata.genPipeRow(getObjects(), 0, 5));
	}
	
	public static SegmentValidation genValidationNumericDot5() {
		return UtilSegmentValidation.genRegexNumericDot("5",
				UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static SegmentValidation genValidationAlpha2() {
		return UtilSegmentValidation.genRegexAlfa("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 6 }));
	}
	
	public static SegmentValidation genValidationAlpha5() {
		return UtilSegmentValidation.genRegexAlfa("5",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 8 }));
	}
	
	public static ConditionalRequired genConditionA() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 7, 8 }));
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7, 8 }),
				getLookup());
	}

	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genPosPercentage("3|4",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7, 8 }), 2);
	}

	public static SegmentValidation genValidation02() {
		return UtilSegmentValidation.genLookupRasioLikuiditas("3", R_5100010000.key, "2", R_5100010000.key, "100.00|800.00|110.00|120.00|130.00",
				"5|5|4|3|2", "1", 2);
	}

	public static SegmentValidation genValidation03() {
		return UtilSegmentValidation.genLookupGearingRatio("3", R_5100020000.key, "2", R_5100020000.key, "4.00|40.00|28.00|32.00|36.00",
				"5|5|1|2|3", "4", 2);
	}

	public static SegmentValidation genValidation04() {
		return UtilSegmentValidation.genLookupGreaterEquals("3", R_5100030100.key, "2", R_5100030100.key, "5.00|2.50|0.00|-5.00",
				"1|2|3|4", "5", 2);
	}

	public static SegmentValidation genValidation05() {
		return UtilSegmentValidation.genLookupGreaterEquals("3", R_5100030200.key, "2", R_5100030200.key, "100.00|95.00|90.00|85.00",
				"5|4|3|2", "1", 2);
	}

	public static SegmentValidation genValidation06() {
		return UtilSegmentValidation.genLookupGreaterEquals("3", R_5100030300.key, "2", R_5100030300.key, "100.00|90.00|80.00|70.00",
				"5|4|3|2", "1", 2);
	}
	
	public static SegmentValidation genValidation07A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_5100040000.key, "5", UtilMetadata.genPlusRow(getObjects(), 2, 4), 
				UtilMetadata.genMessage(R_5100040000.value, UtilMetadata.genPlusDesc(getObjects(), 2, 4) + " pada kolom 6"), 2);
	}

	public static SegmentValidation genValidation07B() {
		return UtilSegmentValidation.genLookupLess("3", R_5100040000.key, "2", R_5100040000.key, "1.80|2.60|3.40|4.20",
				"1|2|3|4", "5", 2);
	}

	public static SegmentValidation genValidation08A() {
		return UtilSegmentValidation.genFixedValue("2", R_5100050000.key, "SB|B|CB|KB|TB");
	}

	public static SegmentValidation genValidation08B() {
		return UtilSegmentValidation.genLookup("3", R_5100050000.key, "2", R_5100050000.key, "SB|B|CB|KB|TB",
				"1|2|3|4|5", "");
	}

	public static SegmentValidation genValidation09() {
		int[] row = new int[] { 0, 1, 5, 6 };
		return UtilSegmentValidation.genEqualsFormula("5", R_5100060000.key, UtilMetadata.genPlusRow(getObjects(), row), 
				UtilMetadata.genMessage(R_5100060000.value, UtilMetadata.genPlusDesc(getObjects(), row)));
	}
	
	public static SegmentValidation genValidation10() {
		return UtilSegmentValidation.genLookupLess("5", R_5100070000.key, "5", R_5100060000.key, "1.80|2.60|3.40|4.20",
				"SS|S|CS|KS", "TS", 2);
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3035PosLbPnjk5100[] eEnums = ER3035PosLbPnjk5100.values();
		int enumLength = eEnums.length;
		for (int i = 0; i < enumLength; i++) {
			ER3135PosLbPnju5100 eEnum = ER3135PosLbPnju5100.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.bobot);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
