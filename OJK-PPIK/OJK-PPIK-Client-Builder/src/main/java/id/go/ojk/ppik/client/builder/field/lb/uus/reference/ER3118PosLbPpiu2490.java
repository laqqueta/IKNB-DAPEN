 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3118PosLbPpiu2490 implements IObject<KeyValueString> {
	R_2490010000 ("2490010000", "Detail"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_2490.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3118PosLbPpiu2490 eEnum : ER3118PosLbPpiu2490.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3118PosLbPpiu2490.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3118PosLbPpiu2490.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 3, 4 }), getObjects());
	}
}
