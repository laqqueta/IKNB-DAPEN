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
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ER7052PosLtlbDppkAsol implements IObject<KeyValueString> {

    R_ASOL010000("ASOL010000", "Detail"),
    R_ASOL000000("ASOL000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7052PosLtlbDppkAsol eEnum : ER7052PosLtlbDppkAsol.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7052PosLtlbDppkAsol.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7052PosLtlbDppkAsol.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(4, 6), getObjects());
    }

    public static String genFieldSaveForm() {
      return UtilMetadata.genFieldSave("6", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_ASOL000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_ASOL000000.key);
    }

    public static FieldValidation genFieldValidationNilaiBuku() {
        return UtilFieldValidation.genEqualsExceptPosFormula("4-5", R_ASOL000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(4, 6), R_ASOL000000.key, R_ASOL010000.key,
                UtilMetadata.genMessageTotal(R_ASOL000000.value, R_ASOL010000.value));

    }
}
