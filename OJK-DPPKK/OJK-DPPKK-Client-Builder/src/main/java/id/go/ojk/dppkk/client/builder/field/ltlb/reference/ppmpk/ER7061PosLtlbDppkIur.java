package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7061PosLtlbDppkIur implements IObject<KeyValueString> {

    R_IUR010000("IUR010000", "Detail"),
    R_IUR000000("IUR000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7061PosLtlbDppkIur eEnum : ER7061PosLtlbDppkIur.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7061PosLtlbDppkIur.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7061PosLtlbDppkIur.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 16), getObjects());
    }

    public static String genFieldFormSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(new int[] { 5, 6, 7, 8, 17 }), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumnExcept(5, 16, new int[] { 6 }), R_IUR000000.key, R_IUR010000.key,
                UtilMetadata.genMessageTotal(R_IUR000000.value, R_IUR010000.value));

    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_IUR000000.key);
    }
}
