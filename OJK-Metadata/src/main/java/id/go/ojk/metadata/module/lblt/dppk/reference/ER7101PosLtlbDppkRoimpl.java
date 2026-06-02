package id.go.ojk.metadata.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.dppk.field.Dppk0101Roimpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7101PosLtlbDppkRoimpl implements IObject<KeyValueString> {
    
    R_ROIMPL0100000000("ROIMPL0100000000", "Deposito on call pada Bank"),
    R_ROIMPL0200000000("ROIMPL0200000000", "Deposito berjangka pada Bank"),
    R_ROIMPL0300000000("ROIMPL0300000000", "Sertifikat deposito pada Bank"),
    R_ROIMPL0400000000("ROIMPL0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ROIMPL0500000000("ROIMPL0500000000", "Surat Berharga Negara"),
    R_ROIMPL0600000000("ROIMPL0600000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ROIMPL0700000000("ROIMPL0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROIMPL0800000000("ROIMPL0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROIMPL0900000000("ROIMPL0900000000", "Obligasi/Sukuk Daerah"),
    R_ROIMPL1000000000("ROIMPL1000000000", "Reksa Dana"),
    R_ROIMPL1100000000("ROIMPL1100000000", "MTN"),
    R_ROIMPL1200000000("ROIMPL1200000000", "Efek beragun aset"),
    R_ROIMPL1300000000("ROIMPL1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ROIMPL1400000000("ROIMPL1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif"),
    R_ROIMPL1500000000("ROIMPL1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ROIMPL1600000000("ROIMPL1600000000", "REPO"),
    R_ROIMPL1700000000("ROIMPL1700000000", "Penyertaan langsung di Indonesia"),
    R_ROIMPL1800000000("ROIMPL1800000000", "Tanah di Indonesia"),
    R_ROIMPL1900000000("ROIMPL1900000000", "Bangunan di Indonesia"),
    R_ROIMPL2000000000("ROIMPL2000000000", "Tanah dan Bangunan di Indonesia"),
    R_ROIMPL2100000000("ROIMPL2100000000", "Total"),

    ;

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7101PosLtlbDppkRoimpl eEnum : ER7101PosLtlbDppkRoimpl.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7101PosLtlbDppkRoimpl.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPIP {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 11), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        }
    }
}
