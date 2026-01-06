package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3023PosLbPnjs2900 implements IObject<KeyValueString> {
	R_2900010000 ("2900010000", "Detail"),
    R_2900000000 ("2900000000", "Total")
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3023PosLbPnjs2900 eEnum : ER3023PosLbPnjs2900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3023PosLbPnjs2900.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3023PosLbPnjs2900.class.getSimpleName().substring(2, 6));
	}

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("3|4", getObjects());
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_2900000000.key);
    }

    public static SegmentValidation genValidation1() {
        return UtilSegmentValidation.genEqualsFormula("3", R_2900000000.key, R_2900010000.key,
                UtilMetadata.genMessageTotal(R_2900000000.value, R_2900010000.value));
    }

    public static SegmentValidation genValidation2() {
        return UtilSegmentValidation.genEqualsFormula("4", R_2900000000.key, R_2900010000.key,
                UtilMetadata.genMessageTotal(R_2900000000.value, R_2900010000.value));
    }
}
