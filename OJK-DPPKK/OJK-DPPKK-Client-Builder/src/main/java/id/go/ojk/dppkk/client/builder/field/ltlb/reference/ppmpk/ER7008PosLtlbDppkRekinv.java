package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7008PosLtlbDppkRekinv implements IObject<KeyValueString> {

    R_REKINV0100000000("REKINV0100000000", "Deposito on call pada Bank"),
    R_REKINV0200000000("REKINV0200000000", "Deposito berjangka pada Bank"),
    R_REKINV0300000000("REKINV0300000000", "Sertifikat deposito pada Bank"),
    R_REKINV0400000000("REKINV0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_REKINV0500000000("REKINV0500000000", "Surat Berharga Negara"),
    R_REKINV0600000000("REKINV0600000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_REKINV0700000000("REKINV0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia"),
    R_REKINV0800000000("REKINV0800000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
    R_REKINV0900000000("REKINV0900000000", "Obligasi/Sukuk Daerah"),
    R_REKINV1000000000("REKINV1000000000", "Reksa Dana"),
    R_REKINV1100000000("REKINV1100000000", "MTN"),
    R_REKINV1200000000("REKINV1200000000", "Efek beragun aset"),
    R_REKINV1300000000("REKINV1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_REKINV1400000000("REKINV1400000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_REKINV1500000000("REKINV1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_REKINV1600000000("REKINV1600000000", "REPO"),
    R_REKINV1700000000("REKINV1700000000", "Penyertaan langsung di Indonesia"),
    R_REKINV1800000000("REKINV1800000000", "Tanah di Indonesia"),
    R_REKINV1900000000("REKINV1900000000", "Bangunan di Indonesia"),
    R_REKINV2000000000("REKINV2000000000", "Tanah dan Bangunan di Indonesia"),
    R_REKINV2100000000("REKINV2100000000", "TOTAL INVESTASI"),
    R_REKINV2200000000("REKINV2200000000", "Aset Tersedia Gabungan"),
    R_REKINV1994967296("REKINV1994967296", "Aset Tersedia Manfaat Lain"),
    R_REKINV1894967296("REKINV1894967296", "Aset Tersedia Manfaat Pensiun Lain");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7008PosLtlbDppkRekinv eEnum : ER7008PosLtlbDppkRekinv.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
    }

    public static String getName() {
        return ER7008PosLtlbDppkRekinv.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7008PosLtlbDppkRekinv.class.getSimpleName().substring(2, 6));
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    public static String genFieldFormSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
    }


    private static final String plusRowValidation = UtilMetadata.genPlusRow(getObjects(), 0, 19);

    public static SegmentValidation genValidationSumPosColEqual() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_REKINV2100000000.key,
                plusRowValidation,
                UtilMetadata.genMessage(R_REKINV2100000000.value, plusRowValidation));
    }
}
