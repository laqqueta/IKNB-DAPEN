package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3026PosLbAsrjs218 implements IObject<KeyValueString> {
	R_2183010100 ("2183010100", "I. Total max ((PK* - PK), 0)"),
	R_2183010101 ("2183010101", "II. Total ((PAKYBMPi - ARi)fpki"),
	R_2183010102 ("2183010102", "III. Total ((PKli - ARi)fpkli)"),
	R_2183010103 ("2183010103", "IV. Total ((PRBi - ARi)fpbi)"),
	R_2183010104 ("2183010104", "Total Deviasi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3026PosLbAsrjs218 eEnum : ER3026PosLbAsrjs218.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
