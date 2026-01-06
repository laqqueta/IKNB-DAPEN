package id.go.ojk.reask.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2102PosRbReasu0103 implements IObject<KeyValueString> {
	R_0103010000 ("0103010000", "Rasio Pencapaian Solvabilitas"),
	R_0103020000 ("0103020000", "Rasio Likuiditas"),
	R_0103030000 ("0103030000", "Rasio Beban Usaha (Beban Usaha/Kontribusi Dana Perusahaan atau Ujroh)"),
	R_0103040000 ("0103040000", "Rasio Beban Komisi"),
	R_0103050000 ("0103050000", "Return on Investment (ROI)"),
	R_0103060000 ("0103060000", "Return on Equity (ROE)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2102PosRbReasu0103 eEnum : ER2102PosRbReasu0103.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2102PosRbReasu0103.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2102PosRbReasu0103.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
