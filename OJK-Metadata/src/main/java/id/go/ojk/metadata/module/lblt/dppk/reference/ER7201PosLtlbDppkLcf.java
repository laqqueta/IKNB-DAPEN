package id.go.ojk.metadata.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7201PosLtlbDppkLcf implements IObject<KeyValueString> {

//    R_LCF0100000000("LCF0100000000", "a"),
    R_LCF0200000000("LCF0200000000", "b"),
    R_LCF0300000000("LCF0300000000", "c"),
    R_LCF0400000000("LCF0400000000", "d"),
    R_LCF0500000000("LCF0500000000", "e"),
    R_LCF0600000000("LCF0600000000", "f"),
    R_LCF0000000000("LCF0000000000", "Total"),

    ;

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7201PosLtlbDppkLcf eEnum : ER7201PosLtlbDppkLcf.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7201PosLtlbDppkLcf.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPIPM {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 8), getObjects());
            }
        }
    }
}
