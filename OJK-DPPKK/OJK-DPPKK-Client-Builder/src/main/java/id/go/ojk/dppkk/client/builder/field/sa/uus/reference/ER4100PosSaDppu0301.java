package id.go.ojk.dppkk.client.builder.field.sa.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4100PosSaDppu0301 implements IObject<KeyValueString> {
	R_0301010000 ("0301010000", "Risiko Strategis"),
	R_0301020000 ("0301020000", "Risiko Operasional"),
	R_0301030000 ("0301030000", "Risiko Kredit"),
	R_0301040000 ("0301040000", "Risiko Pasar"),
	R_0301050000 ("0301050000", "Risiko Likuiditas"),
	R_0301060000 ("0301060000", "Risiko Hukum"),
	R_0301070000 ("0301070000", "Risiko Kepatuhan"),
	R_0301080000 ("0301080000", "Risiko Reputasi"),
	R_0301090000 ("0301090000", "Peringkat Komposit"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4100PosSaDppu0301 eEnum : ER4100PosSaDppu0301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
