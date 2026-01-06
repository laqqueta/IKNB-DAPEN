package id.go.ojk.asrjk.client.builder.field.apu.reference;

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
public enum ER5002PosApuAsrjk03 implements IObject<KeyValueString> {
	R_0301000000 ("0301000000", "1. Struktur Kepemilikan"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5002PosApuAsrjk03 eEnum : ER5002PosApuAsrjk03.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5002PosApuAsrjk03.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5002PosApuAsrjk03.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidationKepemilikan() {
		return UtilFieldValidation.genEqualsFixedValue("1|2|3|4|5");
	}
}
