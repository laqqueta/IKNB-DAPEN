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
public enum ER7018PosLtlbDppkRas2 implements IObject<KeyValueString> {

    R_RAS20100000000("RAS20100000000", "Biaya Pegawai, Pengurus, Dewan Pengawas, dan/atau Dewas Pengawas Syariah"),
    R_RAS20101010000("RAS20101010000", "a. Diklat Pegawai"),
    R_RAS20101020000("RAS20101020000", "b. Diklat Pengurus"),
    R_RAS20101030000("RAS20101030000", "c. Diklat Dewan Pengawas"),
    R_RAS20101040000("RAS20101040000", "d. Diklat Dewan Pengawas Syariah (jika ada)"),
    R_RAS20102000000("RAS20102000000", "Total Biaya Diklat"),
    R_RAS20103000000("RAS20103000000", "Rasio Biaya Diklat");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7018PosLtlbDppkRas2 eEnum : ER7018PosLtlbDppkRas2.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7018PosLtlbDppkRas2.class.getSimpleName().substring(6);
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
                return UtilMetadata.genFieldSave("2|3|4", getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        }
    }
}