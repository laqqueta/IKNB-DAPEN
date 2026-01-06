package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2108PosRbAsruu0203 implements IObject<KeyValueString> {
	R_0203010000 ("0203010000", "Kontribusi Dana Investasi Peserta"),
	R_0203020000 ("0203020000", "Total Penarikan/Penebusan Dana Investasi Peserta"),
	R_0203030000 ("0203030000", "Rasio Likuiditas"),
	R_0203040000 ("0203040000", "Return on Investment (ROI) "),
	R_0203050000 ("0203050000", "Return on Equity (ROE)"),
	R_0203060000 ("0203060000", "dst (tambahkan indicator lain yang dianggap perlu) "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2108PosRbAsruu0203 eEnum : ER2108PosRbAsruu0203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2108PosRbAsruu0203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2108PosRbAsruu0203.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 4);
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("O", "N", R_0203060000.key);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4", UtilMetadata.genPipeRow(getObjects(),
				new int[] { 0, 1, 5 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4", UtilMetadata.genPipeRow(getObjects(), 2, 4));
	}
	
	public static FieldValidation genValidationRatioField() {
		return UtilFieldValidation.genEqualsRatio("4|3");
	}
}
