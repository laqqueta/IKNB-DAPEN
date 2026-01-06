package id.go.ojk.dppks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;

public enum ER2001PosRbDppks0204 implements IObject<KeyValueString> {
	R_0204010000 ("0204010000", "Aset Neto"),
	R_0204020000 ("0204020000", "Aset Investasi"),
	R_0204030000 ("0204030000", "Pendapatan Investasi"),
	R_0204040000 ("0204040000", "Beban Investasi"),
	R_0204050000 ("0204050000", "Beban Operasional"),
	;

	private String key;
	private String value;

	private ER2001PosRbDppks0204(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2001PosRbDppks0204 eEnum : ER2001PosRbDppks0204.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2001PosRbDppks0204.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2001PosRbDppks0204.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
