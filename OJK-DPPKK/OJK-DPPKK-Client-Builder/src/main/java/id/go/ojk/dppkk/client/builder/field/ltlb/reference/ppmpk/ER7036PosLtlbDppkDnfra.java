package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7036PosLtlbDppkDnfra implements IObject<KeyValueString> {

    R_DNFRA010000("DNFRA010000", "Detail"),
    R_DNFRA000000("DNFRA000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7036PosLtlbDppkDnfra eEnum : ER7036PosLtlbDppkDnfra.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7036PosLtlbDppkDnfra.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7036PosLtlbDppkDnfra.class.getSimpleName().substring(2, 6));
    }
}
