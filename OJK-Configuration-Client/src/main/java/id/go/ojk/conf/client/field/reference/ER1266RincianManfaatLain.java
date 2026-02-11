package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1266RincianManfaatLain implements IObject<KeyValueString> {

	R_RML1("MLL01", "Dana Pendidikan"),
	R_RML2("MLL02", "Dana Perumahan"),
	R_RML3("MLL03", "Dana Ibadah Keagamaan"),
	R_RML4("MLL04", "Santunan Cacat"),
	R_RML5("MLL05", "Santunan Kematian"),
	R_RML6("MLL06", "Santunan Kesehatan"),
	R_RML7("MLL07", "Dana Pesangon"),
	R_RML8("MLL08", "Dana Manfaat Tambahan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1266RincianManfaatLain eEnum : ER1266RincianManfaatLain.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1266RincianManfaatLain.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1266RincianManfaatLain.class.getSimpleName().substring(2, 6));
	}
}
