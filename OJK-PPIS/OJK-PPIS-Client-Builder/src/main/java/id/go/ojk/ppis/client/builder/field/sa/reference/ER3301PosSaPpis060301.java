package id.go.ojk.ppis.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3301PosSaPpis060301 implements IObject<KeyValueString> {
	R_0301010000("0301010000", "Risiko Strategis"), R_0301020000("0301020000", "Risiko Operasional"),
	R_0301030000("0301030000", "Risiko Kredit"), R_0301040000("0301040000", "Risiko Pasar"),
	R_0301050000("0301050000", "Risiko Likuiditas"), R_0301060000("0301060000", "Risiko Hukum"),
	R_0301070000("0301070000", "Risiko Kepatuhan"), R_0301080000("0301080000", "Risiko Reputasi"),
	R_0301090000("0301090000", "Peringkat Komposit"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3301PosSaPpis060301 eEnum : ER3301PosSaPpis060301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3301PosSaPpis060301.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3301PosSaPpis060301.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 8);
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 8);
	}

}
