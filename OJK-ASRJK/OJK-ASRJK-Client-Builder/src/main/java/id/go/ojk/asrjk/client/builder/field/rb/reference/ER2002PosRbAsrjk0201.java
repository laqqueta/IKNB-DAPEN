package id.go.ojk.asrjk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2002PosRbAsrjk0201 implements IObject<KeyValueString> {
	R_4401000000 ("4401000000", "Premi Bruto"),
	R_3403020000 ("3403020000", "Laba (Rugi) Setelah Pajak"),
	R_7000000099 ("7000000099", "Rasio Pencapaian Solvabilitas"),
	R_7002000000 ("7002000000", "Rasio Kecukupan Investasi"),
	R_7001000099 ("7001000099", "Rasio Likuiditas"),
	R_7004000000 ("7004000000", "Rasio Beban Klaim, Beban Usaha dan Komisi"),
	R_7003000000 ("7003000000", "Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto"),
	R_7005000000 ("7005000000", "Return on Investment (ROI)"),
	R_7006000000 ("7006000000", "Return on Equity (ROE)"),
	R_0201100000 ("0201100000", "dst (tambahkan indicator lain yang dianggap perlu)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbAsrjk0201 eEnum : ER2002PosRbAsrjk0201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbAsrjk0201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbAsrjk0201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 8);
	}
	
	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPos("O", "N", R_0201100000.key);
	}
	
	public static FieldValidation genFieldValidationRatio() {
		return UtilFieldValidation.genEqualsRatio("4|3");
	}
}
