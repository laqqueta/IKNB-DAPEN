package id.go.ojk.ppik.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3200PosSaPpik060100 implements IObject<KeyValueString> {
	R_0101000000("0101000000", "Tata kelola perusahaan yang baik"),
	R_0102000000("0102000000", "Profil Risiko"),
	R_0103000000("0103000000", "Rentabilitas"),
	R_0104000000("0104000000", "Permodalan"),
	R_0105000000("0105000000", "Peringkat Tingkat Kesehatan Perusahaan");

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3200PosSaPpik060100 eEnum : ER3200PosSaPpik060100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3200PosSaPpik060100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3200PosSaPpik060100.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 4);
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects(), 0, 4);
	}
}
