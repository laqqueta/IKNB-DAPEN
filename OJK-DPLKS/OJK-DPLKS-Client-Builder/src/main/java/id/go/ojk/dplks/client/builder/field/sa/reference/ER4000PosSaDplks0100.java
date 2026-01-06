package id.go.ojk.dplks.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4000PosSaDplks0100 implements IObject<KeyValueString> {
	R_0101000000 ("0101000000", "Tata kelola perusahaan yang baik bagi Dana Pensiun"),
	R_0102000000 ("0102000000", "Profil Risiko"),
	R_0103000000 ("0103000000", "Rentabilitas"),
	R_0104000000 ("0104000000", "Peringkat Tingkat Kesehatan Dana Pensiun"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4000PosSaDplks0100 eEnum : ER4000PosSaDplks0100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPeringkat() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
