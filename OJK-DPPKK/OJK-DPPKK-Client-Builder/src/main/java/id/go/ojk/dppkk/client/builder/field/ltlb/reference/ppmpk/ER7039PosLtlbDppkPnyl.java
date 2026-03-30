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
public enum ER7039PosLtlbDppkPnyl implements IObject<KeyValueString> {

    R_PNYL010000("PNYL010000", "Detail"),
    R_PNYL000000("PNYL000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7039PosLtlbDppkPnyl eEnum : ER7039PosLtlbDppkPnyl.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7039PosLtlbDppkPnyl.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7039PosLtlbDppkPnyl.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("2|9|11|15|16|21|30", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static String getFieldFormSave() {
        return UtilMetadata.genFieldSave("11|19", getObjects());
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_PNYL000000.key);
    }

    public static ConditionalRequired genConditionValidationNamaPerusahaan() {
        return UtilFieldConditional.genHasValue("2", "N", "M");
    }

    public static ConditionalRequired genConditionValidationAnakPerushaan() {
        return UtilFieldConditional.genHasValue("29", "N", "M");
    }

    public static ConditionalRequired genConditionValidationAnakPerushaan2() {
        return UtilFieldConditional.genHasValueExceptPos("29", "N", "M", R_PNYL000000.key);
    }

    public static FieldValidation genFieldValidationRatio() {
        return UtilFieldValidation.genEqualsPosRatio("16|11", R_PNYL010000.key);
    }

    public static FieldValidation genFieldValidationNilai() {
        return UtilFieldValidation.genEqualsExceptPosFormula("15-11", R_PNYL000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("9|11|15|16|21|30", R_PNYL000000.key, R_PNYL010000.key,
                UtilMetadata.genMessageTotal(R_PNYL000000.value, R_PNYL010000.value));
    }

    public static FieldValidation genValidationFixedPersentaseV() {
        return UtilFieldValidation.genEqualsPosFormulaFixedValue(
                UtilMetadata.genPlusColumn(22, 28), R_PNYL010000.key,
                "100");
    }

    public static FieldValidation genValidationFixedPersentaseE1() {
        return UtilFieldValidation.genEqualsPosFormulaFixedValue(
                UtilMetadata.genPlusColumn(31, 36), R_PNYL010000.key,
                "100");
    }
}
