package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

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
}
