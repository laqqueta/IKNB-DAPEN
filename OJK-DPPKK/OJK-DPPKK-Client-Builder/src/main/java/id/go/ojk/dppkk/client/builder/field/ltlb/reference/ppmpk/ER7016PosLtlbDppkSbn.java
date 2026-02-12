package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7016PosLtlbDppkSbn implements IObject<KeyValueString> {
    
    R_SBN010000("SBN010000", "Detail"),
    R_SBN000000("SBN000000", "Total Saldo"),
    R_SBN020000("SBN020000", "Total % SBN");

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
}
