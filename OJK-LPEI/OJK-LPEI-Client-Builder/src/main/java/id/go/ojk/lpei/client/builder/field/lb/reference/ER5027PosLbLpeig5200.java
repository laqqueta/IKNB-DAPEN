package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5027PosLbLpeig5200 implements IObject<KeyValueString> {
	R_5200010000("5200010000", "Detail"),;
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
		for (ER5027PosLbLpeig5200 eEnum : ER5027PosLbLpeig5200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5027PosLbLpeig5200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5027PosLbLpeig5200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return ER5027PosLbLpeig5200.R_5200010000.getKey();
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 18), getObjects());
	}
	
	public static ConditionalRequired genConditionalValidation7() {
		return UtilFieldConditional.genAllExist("N", "M", "6");
	}
}