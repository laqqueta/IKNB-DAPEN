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
public enum ER7042PosLtlbDppkPiut implements IObject<KeyValueString> {

    R_PIUT010000("PIUT010000", "Detail"),
    R_PIUT000000("PIUT000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7042PosLtlbDppkPiut eEnum : ER7042PosLtlbDppkPiut.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7042PosLtlbDppkPiut.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7042PosLtlbDppkPiut.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 12), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_PIUT000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_PIUT000000.key);
    }

    public static FieldValidation genFieldValidationPemberiKerja() {
        return UtilFieldValidation.genEqualsExceptPosFormula("3+4", R_PIUT000000.key);
    }
    public static FieldValidation genFieldValidationPeserta() {
        return UtilFieldValidation.genEqualsExceptPosFormula("6+7", R_PIUT000000.key);
    }

    public static FieldValidation genFieldValidationTambahan() {
        return UtilFieldValidation.genEqualsExceptPosFormula("9+10", R_PIUT000000.key);
    }


    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_PIUT000000.key, R_PIUT010000.key,
                UtilMetadata.genMessageTotal(R_PIUT000000.value, R_PIUT010000.value));

    }
}
