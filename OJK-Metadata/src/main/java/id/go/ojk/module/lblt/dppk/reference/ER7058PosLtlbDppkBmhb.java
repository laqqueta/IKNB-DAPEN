package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7058PosLtlbDppkBmhb implements IObject<KeyValueString> {

    R_BMHB010000("BMHB010000", "Detail"),
    R_BMHB000000("BMHB000000", "Total");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7058PosLtlbDppkBmhb eEnum : ER7058PosLtlbDppkBmhb.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7058PosLtlbDppkBmhb.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMP {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("4", getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(), new int[]{1});
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("4|5", getObjects());
            }
        }
    }
}
