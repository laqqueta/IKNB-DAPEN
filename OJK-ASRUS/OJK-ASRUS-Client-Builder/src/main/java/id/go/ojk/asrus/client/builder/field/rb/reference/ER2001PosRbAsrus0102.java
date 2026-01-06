package id.go.ojk.asrus.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2001PosRbAsrus0102 implements IObject<KeyValueString> {
	R_0102010000 ("0102010000", "Aset"),
	R_0102020000 ("0102020000", "Investasi"),
	R_0102030000 ("0102030000", "Liabilitas"),
	R_0102040000 ("0102040000", "Penyisihan Teknis"),
	R_0102050000 ("0102050000", "Qardh"),
	R_0102060000 ("0102060000", "Akumulasi Dana"),
	R_0102070000 ("0102070000", "Kontribusi Tabarru & Tanahud"),
	R_0102080000 ("0102080000", "Klaim Bruto"),
	R_0102090000 ("0102090000", "Surplus (defisit) Underwriting"),
	R_0102100000 ("0102100000", "Hasil Investasi"),
	;
	
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2001PosRbAsrus0102 eEnum : ER2001PosRbAsrus0102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2001PosRbAsrus0102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2001PosRbAsrus0102.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
