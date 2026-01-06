package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2006PosRbPpk050101 implements IObject<KeyValueString> {
	R_05010101000000 ("05010101000000", "Jenis Kegiatan Usaha"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2006PosRbPpk050101 eEnum : ER2006PosRbPpk050101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2006PosRbPpk050101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2006PosRbPpk050101.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
