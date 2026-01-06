package id.go.ojk.asrjk.client.builder.field.rb.uus.reference;

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
public enum ER2106PosRbAsrju0201 implements IObject<KeyValueString> {
	R_0201010000 ("0201010000", "Ujroh atas kontribusi Diterima"),
	R_0201020000 ("0201020000", "Beban Usaha"),
	R_0201030000 ("0201030000", "Laba (Rugi) Setelah pajak"),
	R_0201040000 ("0201040000", "Rasio Pencapaian Solvabilitas"),
	R_0201050000 ("0201050000", "Rasio Likuiditas"),
	R_0201060000 ("0201060000", "Rasio Beban Usaha "),
	R_0201070000 ("0201070000", "Rasio Beban Komisi"),
	R_0201080000 ("0201080000", "Return on Investment (ROI) "),
	R_0201090000 ("0201090000", "Return on Equity (ROE)"),
	R_0201100000 ("0201100000", "dst (tambahkan indicator lain yang dianggap perlu) "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2106PosRbAsrju0201 eEnum : ER2106PosRbAsrju0201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2106PosRbAsrju0201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2106PosRbAsrju0201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 8);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPos("O", "N", R_0201100000.key);
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
