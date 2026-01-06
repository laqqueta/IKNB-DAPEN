package id.go.ojk.dplkk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4003PosSaDplkk0302 implements IObject<KeyValueString> {
	R_0302010000 ("0302010000", "Risiko Strategis"),
	R_0302020000 ("0302020000", "Risiko Operasional"),
	R_0302030000 ("0302030000", "Risiko Kredit"),
	R_0302040000 ("0302040000", "Risiko Pasar"),
	R_0302050000 ("0302050000", "Risiko Likuiditas"),
	R_0302060000 ("0302060000", "Risiko Hukum"),
	R_0302070000 ("0302070000", "Risiko Kepatuhan"),
	R_0302080000 ("0302080000", "Risiko Reputasi"),
	R_0302090000 ("0302090000", "Peringkat Komposit"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4003PosSaDplkk0302 eEnum : ER4003PosSaDplkk0302.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
