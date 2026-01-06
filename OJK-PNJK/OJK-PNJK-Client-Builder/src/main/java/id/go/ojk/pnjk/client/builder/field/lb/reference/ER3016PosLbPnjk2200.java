package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3016PosLbPnjk2200 implements IObject<KeyValueString> {
	R_2200010000 ("2200010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3016PosLbPnjk2200 eEnum : ER3016PosLbPnjk2200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("11", getObjects());
    }

	public static String getName() {
		return ER3016PosLbPnjk2200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3016PosLbPnjk2200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

    public static FieldValidation genFieldValidation() {
        return UtilFieldValidation.genEqualsPosFormula("9-10",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
    }
}
