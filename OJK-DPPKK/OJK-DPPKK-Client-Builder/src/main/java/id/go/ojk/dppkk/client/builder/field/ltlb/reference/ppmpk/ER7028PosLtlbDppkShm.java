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
public enum ER7028PosLtlbDppkShm implements IObject<KeyValueString> {

    R_SHM010000("SHM010000", "Detail"),
    R_SHM000000("SHM000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7028PosLtlbDppkShm eEnum : ER7028PosLtlbDppkShm.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7028PosLtlbDppkShm.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7028PosLtlbDppkShm.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("5|6|7|8|12", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_SHM000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_SHM000000.key);
    }

    public static FieldValidation genFieldValidationNilaiInvestasi() {
        return UtilFieldValidation.genEqualsExceptPosFormula("7-6", R_SHM000000.key);
    }

    public static FieldValidation genFieldValidationPersentaseInvestasi() {
        return UtilFieldValidation.genEqualsPercentageExceptPosFormula("8/6", R_SHM000000.key);
    }

    public static ConditionalRequired genConditionNamaPengelola() {
        return UtilFieldConditional.genEqualsExceptPos("O", "M", "12",
                ER1252Pengelolaan.getReferenceIndex(0), R_SHM000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("5|6|7|8", R_SHM000000.key, R_SHM010000.key,
                UtilMetadata.genMessageTotal(R_SHM000000.value, R_SHM010000.value));

    }
}
