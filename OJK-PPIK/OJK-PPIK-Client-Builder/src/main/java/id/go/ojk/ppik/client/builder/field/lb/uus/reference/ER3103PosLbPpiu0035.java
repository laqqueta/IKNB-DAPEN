 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.field.reference.ER1105JabatanKepengurusan;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3103PosLbPpiu0035 implements IObject<KeyValueString> {
	R_0035010000 ("0035010000", "Detail"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3103PosLbPpiu0035 eEnum : ER3103PosLbPpiu0035.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3103PosLbPpiu0035.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3103PosLbPpiu0035.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static ConditionalRequired genFieldCondition() {
		return UtilFieldConditional.genEquals("M", "O", "5",
				ER1105JabatanKepengurusan.getPiped(Arrays.asList(4, 5)));
	}

	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genIfEqualThen("5", ER1105JabatanKepengurusan.R_3.getKey(),
				ER1126Negara.R_1.getKey());
	}

	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genDateGreaterEquals("11");
	}
}
