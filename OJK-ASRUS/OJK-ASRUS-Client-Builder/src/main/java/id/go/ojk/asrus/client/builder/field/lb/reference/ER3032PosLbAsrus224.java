package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3032PosLbAsrus224 implements IObject<KeyValueString> {
	R_2240030100 ("2240030100", "Baris rincian"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3032PosLbAsrus224 eEnum : ER3032PosLbAsrus224.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
}
