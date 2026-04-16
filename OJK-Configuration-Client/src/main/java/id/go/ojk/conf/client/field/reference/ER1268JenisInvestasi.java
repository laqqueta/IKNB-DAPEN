package id.go.ojk.conf.client.field.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1268JenisInvestasi implements IObject<KeyValueString> {

	R_JIV1("JINV01", "SBN"),
	R_JIV2("JINV02", "OBLIGASI / SUKUK INFRASTRUKTUR"),
	R_JIV3("JINV03", "REKSADANA UNDERLYING SBN"),
	R_JIV4("JINV04", "REKSADANA PENYERTAAN TERBATAS"),
	R_JIV5("JINV05", "EFEK BERAGUN ASET"),
	R_JIV6("JINV06", "INVESTASI LAIN UNTUK PEMBIAYAAN PROYEK INFRASTRUKTUR PEMERINTAH"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1268JenisInvestasi eEnum : ER1268JenisInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1268JenisInvestasi.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1268JenisInvestasi.class.getSimpleName().substring(2, 6));
	}

	public static String getReferenceIndex(int index) {
		StringBuilder res = new StringBuilder();
		ER1268JenisInvestasi[] eEnums = ER1268JenisInvestasi.values();
		for (int i= 0; i < eEnums.length; i++) {
			if (i == index) {
				res.append(eEnums[i].key);
				break;
			}
		}
		return res.toString();
	}

}
