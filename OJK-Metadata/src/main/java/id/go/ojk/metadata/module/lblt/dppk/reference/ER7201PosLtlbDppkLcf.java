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

    R_LCF0100000000("LCF0100000000", "Jumlah Peserta"),
    R_LCF0200000000("LCF0200000000", "Deposito on call pada Bank"),
    R_LCF0300000000("LCF0300000000", "Deposito berjangka pada Bank"),
    R_LCF0400000000("LCF0400000000", "Sertifikat deposito pada Bank"),
    R_LCF0500000000("LCF0500000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_LCF0600000000("LCF0600000000", "Surat Berharga Negara"),
    R_LCF0700000000("LCF0700000000", "Total"),

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
        REF_CONFIG {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 8), getObjects());
            }
        }
    }
}
