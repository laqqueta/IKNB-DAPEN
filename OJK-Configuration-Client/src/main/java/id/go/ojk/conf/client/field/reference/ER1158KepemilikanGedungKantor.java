package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1158KepemilikanGedungKantor implements IObject<KeyValueString> {
	R_1 ("ST:e1", "Sewa"),
	R_2 ("ST:e2", "Milik Sendiri"),
	R_3 ("ST:e3", "Jenis Kepemilikan Lainnya"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1158KepemilikanGedungKantor eEnum : ER1158KepemilikanGedungKantor.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1158KepemilikanGedungKantor.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1158KepemilikanGedungKantor.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1158KepemilikanGedungKantor[] eEnums = ER1158KepemilikanGedungKantor.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1158KepemilikanGedungKantor eEnum = ER1158KepemilikanGedungKantor.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
