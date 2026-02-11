package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1253SektorEkonomi implements IObject<KeyValueString> {

	R_SE1("SE01", "Pertanian"),
	R_SE2("SE02", "Pertambangan"),
	R_SE3("SE03", "Industri Dasar & Kimia"),
	R_SE4("SE04", "Aneka Industri"),
	R_SE5("SE05", "Industri Barang Konsumsi"),
	R_SE6("SE06", "Properti, Real Estate dan Konstruksi Bangunan"),
	R_SE7("SE07", "Infrastruktur, Utilitas & Transportasi"),
	R_SE8("SE08", "Keuangan"),
	R_SE9("SE09", "Perdagangan, Jasa & Investasi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1253SektorEkonomi eEnum : ER1253SektorEkonomi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1253SektorEkonomi.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1253SektorEkonomi.class.getSimpleName().substring(2, 6));
	}
}
