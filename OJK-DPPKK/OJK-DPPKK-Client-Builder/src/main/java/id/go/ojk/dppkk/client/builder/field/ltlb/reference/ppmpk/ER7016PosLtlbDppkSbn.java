package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7016PosLtlbDppkSbn implements IObject<KeyValueString> {
    
    R_SBN010000("SBN010000", "Detail"),
    R_SBN000000("SBN000000", "Total"),
    R_SBN020000("SBN020000", "% SBN");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7016PosLtlbDppkSbn eEnum : ER7016PosLtlbDppkSbn.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7016PosLtlbDppkSbn.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7016PosLtlbDppkSbn.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("9|10", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 });
    }

    public static ConditionalRequired genConditionForSaldo() {
        return UtilFieldConditional.genExistPos("N", "M", R_SBN000000.key);
    }

    public static ConditionalRequired genConditionForSbn() {
        return UtilFieldConditional.genExistPos("N", "M", R_SBN020000.key);
    }

    public static ConditionalRequired genConditionForTotal() {
        return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 }));
    }

    public static SegmentValidation genValidation() {
        return UtilSegmentValidation.genEqualsFormula("10", R_SBN000000.key, R_SBN010000.key,
                UtilMetadata.genMessageTotal(R_SBN000000.value, R_SBN010000.value));
    }

    public static SegmentValidation genRowValidation() {
        return UtilSegmentValidation.genEqualsSbnRatio("9", R_SBN020000.key,
                R_SBN000000.key, "10", EFormLaporanTahunanLaporanBulanan.LTLB_LAN.getCode(),
                ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "13",
                UtilMetadata.genMessage(R_SBN020000.value, R_SBN020000.value + "/Total Investasi (Gabungan) pada form LAN"), 2);
    }
}
