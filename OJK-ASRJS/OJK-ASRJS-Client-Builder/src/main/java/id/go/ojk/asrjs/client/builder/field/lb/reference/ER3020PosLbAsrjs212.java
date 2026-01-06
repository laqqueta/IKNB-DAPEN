package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3020PosLbAsrjs212 implements IObject<KeyValueString> {
	R_6101000000 ("6101000000", "Rincian"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3020PosLbAsrjs212 eEnum : ER3020PosLbAsrjs212.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static FieldValidation genValidation6() {
		return UtilFieldValidation.genEqualsFormula("4-5");
	}

	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genReferenceCondition4("2", String.valueOf(EHeaderMetadataShared.R029.getNumber()), "0.00");
	}

	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genPercentage("6|7", 0);
	}
}
