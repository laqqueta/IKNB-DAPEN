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
public enum ER7010PosLtlbDppkRoiml implements IObject<KeyValueString> {

    R_ROIML0100000000("ROIML0100000000", "Deposito on call pada Bank"),
    R_ROIML0200000000("ROIML0200000000", "Deposito berjangka pada Bank"),
    R_ROIML0300000000("ROIML0300000000", "Sertifikat deposito pada Bank"),
    R_ROIML0400000000("ROIML0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ROIML0500000000("ROIML0500000000", "Surat Berharga Negara"),
    R_ROIML0600000000("ROIML0600000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ROIML0700000000("ROIML0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROIML0800000000("ROIML0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROIML0900000000("ROIML0900000000", "Obligasi/Sukuk Daerah"),
    R_ROIML1000000000("ROIML1000000000", "Reksa Dana"),
    R_ROIML1100000000("ROIML1100000000", "MTN"),
    R_ROIML1200000000("ROIML1200000000", "Efek beragun aset"),
    R_ROIML1300000000("ROIML1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ROIML1400000000("ROIML1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif"),
    R_ROIML1500000000("ROIML1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ROIML1600000000("ROIML1600000000", "REPO"),
    R_ROIML1700000000("ROIML1700000000", "Penyertaan langsung di Indonesia"),
    R_ROIML1800000000("ROIML1800000000", "Tanah di Indonesia"),
    R_ROIML1900000000("ROIML1900000000", "Bangunan di Indonesia"),
    R_ROIML2000000000("ROIML2000000000", "Tanah dan Bangunan di Indonesia"),
    R_ROIML2100000000("ROIML2100000000", "Total");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7010PosLtlbDppkRoiml eEnum : ER7010PosLtlbDppkRoiml.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7010PosLtlbDppkRoiml.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 11),
                        getObjects()
                );
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        }
    }
}