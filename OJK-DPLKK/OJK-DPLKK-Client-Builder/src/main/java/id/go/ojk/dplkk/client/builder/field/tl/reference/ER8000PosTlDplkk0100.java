package id.go.ojk.dplkk.client.builder.field.tl.reference;

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
public enum ER8000PosTlDplkk0100 implements IObject<KeyValueString> {
	R_0020010000 ("0100010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER8000PosTlDplkk0100 eEnum : ER8000PosTlDplkk0100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER8000PosTlDplkk0100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER8000PosTlDplkk0100.class.getSimpleName().substring(2, 6));
	}

	public static ConditionalRequired genConditionalExist03() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}

	public static ConditionalRequired genConditionalExist04() {
		return UtilFieldConditional.genAllExist("M", "N", "3");
	}

	public static ConditionalRequired genConditionalExist05() {
		return UtilFieldConditional.genAllExist("M", "N", "4");
	}
}
