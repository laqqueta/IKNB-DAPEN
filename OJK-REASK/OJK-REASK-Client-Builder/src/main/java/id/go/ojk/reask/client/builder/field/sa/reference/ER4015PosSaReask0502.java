package id.go.ojk.reask.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4015PosSaReask0502 implements IObject<KeyValueString> {
	R_0502010000 ("0502010000", "Risiko Strategis"),
	R_0502020000 ("0502020000", "Risiko Operasional"),
	R_0502030000 ("0502030000", "Risiko Asuransi"),
	R_0502040000 ("0502040000", "Risiko Kredit"),
	R_0502050000 ("0502050000", "Risiko Pasar"),
	R_0502060000 ("0502060000", "Risiko Likuiditas"),
	R_0502070000 ("0502070000", "Risiko Hukum"),
	R_0502080000 ("0502080000", "Risiko Kepatuhan"),
	R_0502090000 ("0502090000", "Risiko Reputasi"),
	R_0502100000 ("0502100000", "Peringkat Komposit"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4015PosSaReask0502 eEnum : ER4015PosSaReask0502.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}
}
