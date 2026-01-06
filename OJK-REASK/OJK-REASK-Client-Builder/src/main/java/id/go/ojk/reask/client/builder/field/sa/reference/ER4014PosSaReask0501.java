package id.go.ojk.reask.client.builder.field.sa.reference;

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
public enum ER4014PosSaReask0501 implements IObject<KeyValueString> {
//	R_0501010000 ("0501010000", "A.       Laporan Hasil Penilaian Tingkat Kesehatan Perusahaan"),
	R_0501010100 ("0501010100", "1"),
	R_0501010200 ("0501010200", "2"),
	R_0501010300 ("0501010300", "3"),
	R_0501010400 ("0501010400", "4"),
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
		for (ER4014PosSaReask0501 eEnum : ER4014PosSaReask0501.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue(ER1099Peringkat.getPipedKey());
	}
}
