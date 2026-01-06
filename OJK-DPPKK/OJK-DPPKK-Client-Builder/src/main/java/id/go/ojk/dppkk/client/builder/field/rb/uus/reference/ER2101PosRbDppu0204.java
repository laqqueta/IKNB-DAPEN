package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2101PosRbDppu0204 implements IObject<KeyValueString> {
	R_0204010000 ("0204010000", "Aset Neto"),
	R_0204020000 ("0204020000", "Aset Investasi"),
	R_0204030000 ("0204030000", "Pendapatan Investasi"),
	R_0204040000 ("0204040000", "Beban Investasi"),
	R_0204050000 ("0204050000", "Beban Operasional"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2101PosRbDppu0204 eEnum : ER2101PosRbDppu0204.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2101PosRbDppu0204.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2101PosRbDppu0204.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
