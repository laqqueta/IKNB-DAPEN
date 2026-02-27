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
public enum ER7029PosLtlbDppkObli implements IObject<KeyValueString> {

    R_OBLI010000("OBLI010000", "Detail"),
    R_OBLI000000("OBLI000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7029PosLtlbDppkObli eEnum : ER7029PosLtlbDppkObli.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7029PosLtlbDppkObli.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7029PosLtlbDppkObli.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("6|11|12|13", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_OBLI000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_OBLI000000.key);
    }

    public static FieldValidation genFieldValidationNilaiInvestasi() {
        return UtilFieldValidation.genEqualsExceptPosFormula("12-11", R_OBLI000000.key);
    }

    public static FieldValidation genFieldValidationPersentaseInvestasi() {
        return UtilFieldValidation.genEqualsPercentageExceptPosFormula("13/11", R_OBLI000000.key);
    }

    public static ConditionalRequired genConditionNamaPengelola() {
        return UtilFieldConditional.genEqualsExceptPos("O", "M", "18",
                ER1252Pengelolaan.getReferenceIndex(0), R_OBLI000000.key);
    }

    public static FieldValidation genDateGreaterFieldValidation() {
        return UtilFieldValidation.genDateGreaterEquals("5");
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("6|11|12|13", R_OBLI000000.key, R_OBLI010000.key,
                UtilMetadata.genMessageTotal(R_OBLI000000.value, R_OBLI010000.value));

    }
}
