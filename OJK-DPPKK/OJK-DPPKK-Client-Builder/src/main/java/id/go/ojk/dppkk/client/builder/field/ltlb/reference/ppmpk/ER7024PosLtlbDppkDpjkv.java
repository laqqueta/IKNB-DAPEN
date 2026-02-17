package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7024PosLtlbDppkDpjkv implements IObject<KeyValueString> {

    R_DPJKV010000("DPJKV010000", "Detail"),
    R_DPJKV000000("DPJKV000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7024PosLtlbDppkDpjkv eEnum : ER7024PosLtlbDppkDpjkv.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7024PosLtlbDppkDpjkv.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7024PosLtlbDppkDpjkv.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("6|7|8|13", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static FieldValidation genFieldValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("7-6", R_DPJKV000000.key);
    }

    public static FieldValidation genFieldValidationPercentage() {
        return UtilFieldValidation.genEqualsPercentageExceptPosFormula("8/7", R_DPJKV000000.key);
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_DPJKV000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_DPJKV000000.key);
    }

    public static FieldValidation genFieldValidationNilaiInvestasi() {
        return UtilFieldValidation.genEqualsExceptPosFormula("7-6", R_DPJKV000000.key);
    }

    public static FieldValidation genFieldValidationPersentaseInvestasi() {
        return UtilFieldValidation.genEqualsPercentageExceptPosFormula("8/7", R_DPJKV000000.key);
    }

    public static ConditionalRequired genConditionOptional() {
        return UtilFieldConditional.genEqualsExceptPos("O", "M", "13",
                ER1252Pengelolaan.getReferenceIndex(0), R_DPJKV000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("6|7|8", R_DPJKV000000.key, R_DPJKV010000.key,
                UtilMetadata.genMessageTotal(R_DPJKV000000.value, R_DPJKV010000.value));

    }
}
