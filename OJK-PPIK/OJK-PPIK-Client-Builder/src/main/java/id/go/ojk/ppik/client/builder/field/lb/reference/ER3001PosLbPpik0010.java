 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3001PosLbPpik0010 implements IObject<KeyValueString> {
	R_0010010000 ("0010010000", "Detail"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3001PosLbPpik0010 eEnum : ER3001PosLbPpik0010.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3001PosLbPpik0010.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3001PosLbPpik0010.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static ConditionalRequired genFieldConditionA() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}
	
	public static ConditionalRequired genFieldConditionalB() {
		return UtilFieldConditional.genAllExist("O", "N", "2");
	}
}
