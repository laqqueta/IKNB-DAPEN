package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7048PosLtlbDppkTnbg implements IObject<KeyValueString> {

    R_TNBG010000("TNBG010000", "Detail"),
    R_TNBG000000("TNBG000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7048PosLtlbDppkTnbg eEnum : ER7048PosLtlbDppkTnbg.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7048PosLtlbDppkTnbg.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7048PosLtlbDppkTnbg.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(6, 9), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_TNBG000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_TNBG000000.key);
    }

    public static FieldValidation genFieldValidationNilaiBuku() {
        return UtilFieldValidation.genEqualsExceptPosFormula("6-7", R_TNBG000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(6, 9), R_TNBG000000.key, R_TNBG010000.key,
                UtilMetadata.genMessageTotal(R_TNBG000000.value, R_TNBG010000.value));

    }
}
