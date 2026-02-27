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
public enum ER7044PosLtlbDppkBbmk implements IObject<KeyValueString> {

    R_BBMK010000("BBMK010000", "Detail"),
    R_BBMK000000("BBMK000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7044PosLtlbDppkBbmk eEnum : ER7044PosLtlbDppkBbmk.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7044PosLtlbDppkBbmk.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7044PosLtlbDppkBbmk.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("3", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", R_BBMK000000.key);
    }

    public static ConditionalRequired genConditionForTotalOptional() {
        return UtilFieldConditional.genExistPos("N", "O", R_BBMK000000.key);
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("3", R_BBMK000000.key, R_BBMK010000.key,
                UtilMetadata.genMessageTotal(R_BBMK000000.value, R_BBMK010000.value));

    }
}
