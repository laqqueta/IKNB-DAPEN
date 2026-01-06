package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5001PosLbLpeig0020 implements IObject<KeyValueString> {
	R_0020010000 ("0020010000", "Detail"),
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
		for (ER5001PosLbLpeig0020 eEnum : ER5001PosLbLpeig0020.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5001PosLbLpeig0020.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5001PosLbLpeig0020.class.getSimpleName().substring(2, 6));
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
	}
}
