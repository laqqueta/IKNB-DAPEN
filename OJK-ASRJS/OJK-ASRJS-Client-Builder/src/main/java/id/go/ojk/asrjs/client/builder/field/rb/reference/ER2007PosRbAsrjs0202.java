package id.go.ojk.asrjs.client.builder.field.rb.reference;

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
public enum ER2007PosRbAsrjs0202 implements IObject<KeyValueString> {
	R_0202010000 ("0202010000", "Kontribusi Tabarru & Tanahud"),
	R_0202020000 ("0202020000", "Klaim Bruto"),
	R_0202030000 ("0202030000", "Surplus Underwriting"),
	R_0202040000 ("0202040000", "Rasio Pencapaian Solvabilitas"),
	R_0202050000 ("0202050000", "Rasio Kecukupan Investasi"),
	R_0202060000 ("0202060000", "Rasio Likuiditas"),
	R_0202070000 ("0202070000", "Rasio Beban klaim (Netto)"),
	R_0202080000 ("0202080000", "Return on Investment (ROI) "),
	R_0202090000 ("0202090000", "Return on Equity (ROE)"),
	R_0202100000 ("0202100000", "dst (tambahkan indicator lain yang dianggap perlu) "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2007PosRbAsrjs0202 eEnum : ER2007PosRbAsrjs0202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2007PosRbAsrjs0202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2007PosRbAsrjs0202.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 8);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPos("O", "N", R_0202100000.key);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 0, 1, 2, 9 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4", UtilMetadata.genPipeRow(getObjects(), 3, 8));
	}
	
	public static FieldValidation genValidationRatioField() {
		return UtilFieldValidation.genEqualsRatio("4|3");
	}
}
