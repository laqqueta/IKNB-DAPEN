package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1066InvestasiDalamRangkaPembiayaanInfrastruktur implements IObject<KeyValueString> {
	R_3501 ("3501", "Dalam Rangka Pemenuhan Investasi Pembiayaan Infrastruktur"),
	R_3502 ("3502", "Bukan Dalam Rangka Pemenuhan Investasi Pembiayaan Infrastruktur"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1066InvestasiDalamRangkaPembiayaanInfrastruktur eEnum : ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1066InvestasiDalamRangkaPembiayaanInfrastruktur.class.getSimpleName().substring(2, 6));
	}
}
