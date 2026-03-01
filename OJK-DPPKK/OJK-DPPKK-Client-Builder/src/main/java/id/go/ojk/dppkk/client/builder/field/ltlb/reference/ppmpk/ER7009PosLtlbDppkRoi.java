package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7009PosLtlbDppkRoi implements IObject<KeyValueString> {

    R_ROI0100000000("ROI0100000000", "Deposito on call pada Bank"),
    R_ROI0200000000("ROI0200000000", "Deposito berjangka pada Bank"),
    R_ROI0300000000("ROI0300000000", "Sertifikat deposito pada Bank"),
    R_ROI0400000000("ROI0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ROI0500000000("ROI0500000000", "Surat Berharga Negara"),
    R_ROI0600000000("ROI0600000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ROI0700000000("ROI0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROI0800000000("ROI0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ROI0900000000("ROI0900000000", "Obligasi/Sukuk Daerah"),
    R_ROI1000000000("ROI1000000000", "Reksa Dana"),
    R_ROI1100000000("ROI1100000000", "MTN"),
    R_ROI1200000000("ROI1200000000", "Efek beragun aset"),
    R_ROI1300000000("ROI1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ROI1400000000("ROI1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif"),
    R_ROI1500000000("ROI1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ROI1600000000("ROI1600000000", "REPO"),
    R_ROI1700000000("ROI1700000000", "Penyertaan langsung di Indonesia"),
    R_ROI1800000000("ROI1800000000", "Tanah di Indonesia"),
    R_ROI1900000000("ROI1900000000", "Bangunan di Indonesia"),
    R_ROI2000000000("ROI2000000000", "Tanah dan Bangunan di Indonesia"),
    R_ROI2100000000("ROI2100000000", "Total");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7009PosLtlbDppkRoi eEnum : ER7009PosLtlbDppkRoi.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    public static String getName() {
        return ER7009PosLtlbDppkRoi.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7009PosLtlbDppkRoi.class.getSimpleName().substring(2, 6));
    }

    public static FieldValidation genFieldValidation1() {
        return UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7) + "-8");
    }

    public static FieldValidation genFieldValidation2() {
        return UtilFieldValidation.genEqualsExceptPosFormula("9/10", R_ROI2100000000.key);
    }

    public static SegmentValidation genGeoMean() {
        String errMsg = UtilMetadata.genDelimitedColumn(2, 13, "*") + "|3|14|" + "REKINV kode baris ";
        String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(), 0, 19);

        return UtilSegmentValidation.genGeoMeanInvestasi("10", UtilMetadata.genPipeRow(getObjects(), 0, 19),
                EFormLaporanTahunanLaporanBulanan.LTLB_REKINV.getCode(), formRow,
                UtilMetadata.genPipeColumn(2, 13), errMsg, formRow);
    }
}
