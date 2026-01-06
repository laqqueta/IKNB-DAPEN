package id.go.ojk.dppks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2005PosRbDppks0600 implements IObject<KeyValueString> {
	R_0601000000 ("0601000000", "Pengembangan Kegiatan Usaha"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2005PosRbDppks0600 eEnum : ER2005PosRbDppks0600.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2005PosRbDppks0600.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2005PosRbDppks0600.class.getSimpleName().substring(2, 6));
	}
	
	public static ConditionalRequired genConditionalAllExist() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
