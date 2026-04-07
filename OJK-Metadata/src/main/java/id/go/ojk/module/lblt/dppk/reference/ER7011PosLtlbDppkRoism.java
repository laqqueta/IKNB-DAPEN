package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7011PosLtlbDppkRoism implements IObject<KeyValueString> {

    R_ROISM0100000000("ROISM0100000000", "Deposito on call pada Bank"),
    R_ROISM0200000000("ROISM0200000000", "Deposito berjangka pada Bank"),
    R_ROISM0300000000("ROISM0300000000", "Sertifikat deposito pada Bank"),
    R_ROISM0400000000("ROISM0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ROISM0500000000("ROISM0500000000", "Surat Berharga Negara"),
    R_ROISM0600000000("ROISM0600000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ROISM0700000000("ROISM0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROISM0800000000("ROISM0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROISM0900000000("ROISM0900000000", "Obligasi/Sukuk Daerah"),
    R_ROISM1000000000("ROISM1000000000", "Reksa Dana"),
    R_ROISM1100000000("ROISM1100000000", "MTN"),
    R_ROISM1200000000("ROISM1200000000", "Efek beragun aset"),
    R_ROISM1300000000("ROISM1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ROISM1400000000("ROISM1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif"),
    R_ROISM1500000000("ROISM1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ROISM1600000000("ROISM1600000000", "REPO"),
    R_ROISM1700000000("ROISM1700000000", "Penyertaan langsung di Indonesia"),
    R_ROISM1800000000("ROISM1800000000", "Tanah di Indonesia"),
    R_ROISM1900000000("ROISM1900000000", "Bangunan di Indonesia"),
    R_ROISM2000000000("ROISM2000000000", "Tanah dan Bangunan di Indonesia"),
    R_ROISM2100000000("ROISM2100000000", "Total");

    public final String key;
    public final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7011PosLtlbDppkRoism eEnum : ER7011PosLtlbDppkRoism.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7011PosLtlbDppkRoism.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7011PosLtlbDppkRoism.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }
}
