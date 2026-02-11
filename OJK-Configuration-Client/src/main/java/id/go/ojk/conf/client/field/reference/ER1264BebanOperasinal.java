package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1264BebanOperasinal implements IObject<KeyValueString> {

	R_BBOP1("BP01", "Beban Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas"),
	R_BBOP2("BP02", "Beban Kantor"),
	R_BBOP3("BP03", "Beban Pemeliharaan"),
	R_BBOP4("BP04", "Beban Penyusutan"),
	R_BBOP5("BP05", "Beban Jasa Pihak Ketiga"),
	R_BBOP6("BP06", "Beban Pendidikan dan Pelatihan"),
	R_BBOP7("BP07", "Beban Operasional Lain"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1264BebanOperasinal eEnum : ER1264BebanOperasinal.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1264BebanOperasinal.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1264BebanOperasinal.class.getSimpleName().substring(2, 6));
	}
}
