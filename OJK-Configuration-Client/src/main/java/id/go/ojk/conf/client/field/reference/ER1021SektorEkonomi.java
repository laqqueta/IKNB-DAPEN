package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1021SektorEkonomi implements IObject<KeyValueString> {
	R_01000 ("01000", "Pertanian"),
	R_02000 ("02000", "Pertambangan"),
	R_03000 ("03000", "Industri Dasar dan Kimia"),
	R_04000 ("04000", "Aneka Industri"),
	R_05000 ("05000", "Industri Barang Konsumsi"),
	R_06000 ("06000", "Properti dan Real Estate"),
	R_07000 ("07000", "Transportasi dan Infrastruktur"),
	R_08000 ("08000", "Keuangan"),
	R_09000 ("09000", "Perdagangan, Jasa dan Investasi"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1021SektorEkonomi eEnum : ER1021SektorEkonomi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1021SektorEkonomi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1021SektorEkonomi.class.getSimpleName().substring(2, 6));
	}
}
