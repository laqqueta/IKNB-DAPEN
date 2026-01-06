package id.go.ojk.ppk.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5002PosApuPpk03 implements IObject<KeyValueString> {
	R_0301000000 ("0301000000", "I. STRUKTUR PERUSAHAAN"),
	R_0302000000 ("0302000000", "II. STRUKTUR KEPEMILIKAN"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5002PosApuPpk03 eEnum : ER5002PosApuPpk03.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5002PosApuPpk03.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5002PosApuPpk03.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationPerusahaan() {
		return UtilFieldValidation.genPosEqualsFixedValue("1|2|3|4|5", R_0301000000.key);
	}

	public static FieldValidation genValidationKepemilikan() {
		return UtilFieldValidation.genPosEqualsFixedValue("1|2|3|4|5|6|7|8", R_0302000000.key);
	}
}
