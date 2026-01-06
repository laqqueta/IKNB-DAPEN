package id.go.ojk.reass.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2002PosRbReass0103 implements IObject<KeyValueString> {
	R_0104010000 ("0104010000", "Rasio Pencapaian Solvabilitas "),
	R_0104020000 ("0104020000", "Rasio Likuiditas"),
	R_0104030000 ("0104030000", "Rasio Beban Usaha (Beban Usaha/Kontribusi Dana Perusahaan atau Ujroh)"),
	R_0104040000 ("0104040000", "Rasio Beban Komisi "),
	R_0104050000 ("0104050000", "Return on Investment (ROI)"),
	R_0104060000 ("0104060000", "Return on Equity (ROE)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbReass0103 eEnum : ER2002PosRbReass0103.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbReass0103.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbReass0103.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
