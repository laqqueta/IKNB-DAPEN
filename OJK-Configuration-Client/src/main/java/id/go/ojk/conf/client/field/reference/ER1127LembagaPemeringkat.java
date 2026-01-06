package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1127LembagaPemeringkat implements IObject<KeyValueString> {
	R_1 ("EN:eMIS", "Moody’s Investor Service"),
	R_2 ("EN:eSNP", "Standard and Poor’s"),
	R_3 ("EN:eFIN", "Fitch Rating Internasional"),
	R_4 ("EN:ePEF", "Pemeringkat Efek Indonesia (Pefindo)"),
	R_5 ("EN:eFID", "Fitch Rating Indonesia"),
	R_6 ("EN:eKRI", "Kredit Rating Indonesia"),
	R_7 ("EN:eBAP", "Belum Ada Pemeringkat"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1127LembagaPemeringkat eEnum : ER1127LembagaPemeringkat.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1127LembagaPemeringkat.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1127LembagaPemeringkat.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1127LembagaPemeringkat[] eEnums = ER1127LembagaPemeringkat.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1127LembagaPemeringkat eEnum = ER1127LembagaPemeringkat.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
