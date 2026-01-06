package id.go.ojk.asrjk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4014PosSaAsrjk0501 implements IObject<KeyValueString> {
//	R_0501010000 ("0501010000", "A.       Laporan Hasil Penilaian Tingkat Kesehatan Perusahaan"),
	R_0501010100 ("0501010100", "1 Tata kelola perusahaan yang baik bagi Perusahaan"),
	R_0501010200 ("0501010200", "2 Profil risiko"),
	R_0501010300 ("0501010300", "3 Rentabilitas"),
	R_0501010400 ("0501010400", "4 Permodalan"),
	R_0501010500 ("0501010500", "Peringkat Tingkat Kesehatan Perusahaan "),
//	R_0501020000 ("0501020000", "B.       Penilaian Faktor Tata Kelola Perusahaan yang Baik bagi Perusahaan"),
	R_0501020100 ("0501020100", "Peringkat Tata Kelola Perusahaan yang Baik bagi Perusahaan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4014PosSaAsrjk0501 eEnum : ER4014PosSaAsrjk0501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4014PosSaAsrjk0501.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4014PosSaAsrjk0501.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}
}
