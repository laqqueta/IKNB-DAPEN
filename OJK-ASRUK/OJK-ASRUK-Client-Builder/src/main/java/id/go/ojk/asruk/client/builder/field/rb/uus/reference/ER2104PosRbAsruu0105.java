package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2104PosRbAsruu0105 implements IObject<KeyValueString> {
	R_0105010000 ("0105010000", "Rasio Pencapaian Solvabilitas "),
	R_0105020000 ("0105020000", "Rasio Kecukupan Investasi "),
	R_0105030000 ("0105030000", "Rasio Likuiditas"),
	R_0105040000 ("0105040000", "Rasio Beban Klaim (Netto)"),
	R_0105050000 ("0105050000", "Return on Investment (ROI)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2104PosRbAsruu0105 eEnum : ER2104PosRbAsruu0105.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2104PosRbAsruu0105.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2104PosRbAsruu0105.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
