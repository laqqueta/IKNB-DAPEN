package id.go.ojk.dppks.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4004PosSaDpps0303 implements IObject<KeyValueString> {
	R_0303010000 ("0303010000", "Risiko Strategis"),
	R_0303020000 ("0303020000", "Risiko Operasional"),
	R_0303030000 ("0303030000", "Risiko Kredit"),
	R_0303040000 ("0303040000", "Risiko Pasar"),
	R_0303050000 ("0303050000", "Risiko Likuiditas"),
	R_0303060000 ("0303060000", "Risiko Hukum"),
	R_0303070000 ("0303070000", "Risiko Kepatuhan"),
	R_0303080000 ("0303080000", "Risiko Reputasi"),
	R_0303090000 ("0303090000", "Peringkat Komposit"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4004PosSaDpps0303 eEnum : ER4004PosSaDpps0303.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
