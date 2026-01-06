package id.go.ojk.asrjk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2001PosRbAsrjk0105 implements IObject<KeyValueString> {
	R_7000000099 ("7000000099", "Rasio Pencapaian Solvabilitas"),
	R_7002000000 ("7002000000", "Rasio Kecukupan Investasi"),
	R_7001000000 ("7001000000", "Rasio Likuiditas"),
	R_7004050000 ("7004050000", "Rasio Beban Klaim"),
	R_7004060000 ("7004060000", "Rasio Beban Usaha"),
	R_7004070000 ("7004070000", "Rasio Komisi"),
	R_7004000000 ("7004000000", "Rasio Beban Klaim, Beban Usaha dan Komisi"),
	R_7003000000 ("7003000000", "Rasio Perimbangan Hasil Investasi dengan Pendapatan Premi Neto"),
	R_7005000000 ("7005000000", "Return on Investment (ROI)"),
	R_7006000000 ("7006000000", "Return on Equity (ROE)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2001PosRbAsrjk0105 eEnum : ER2001PosRbAsrjk0105.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2001PosRbAsrjk0105.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2001PosRbAsrjk0105.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
