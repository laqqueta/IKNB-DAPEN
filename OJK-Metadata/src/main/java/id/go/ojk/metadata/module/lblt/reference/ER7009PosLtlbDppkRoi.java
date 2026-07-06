package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7009PosLtlbDppkRoi implements IObject<KeyValueString> {

    R_ROI0100000000("ROI0100000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL)),
    R_ROI0200000000("ROI0200000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL)),
    R_ROI0300000000("ROI0300000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL)),
    R_ROI0400000000("ROI0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI0500000000("ROI0500000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL)),
    R_ROI0600000000("ROI0600000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI0700000000("ROI0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI0800000000("ROI0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI0900000000("ROI0900000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL)),
    R_ROI1000000000("ROI1000000000", "Reksa Dana", EnumSet.of(ProgramType.ALL)),
    R_ROI1100000000("ROI1100000000", "MTN", EnumSet.of(ProgramType.ALL)),
    R_ROI1200000000("ROI1200000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL)),
    R_ROI1300000000("ROI1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
    R_ROI1400000000("ROI1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
    R_ROI1500000000("ROI1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI1600000000("ROI1600000000", "REPO", EnumSet.of(ProgramType.ALL)),
    R_ROI1700000000("ROI1700000000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI1800000000("ROI1800000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI1900000000("ROI1900000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI2000000000("ROI2000000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_ROI2100000000("ROI2100000000", "Total", EnumSet.of(ProgramType.ALL));

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7009PosLtlbDppkRoi eEnum : ER7009PosLtlbDppkRoi.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7009PosLtlbDppkRoi eEnum : ER7009PosLtlbDppkRoi.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7009PosLtlbDppkRoi.class.getSimpleName().substring(6);
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
//            }
//
//            @Override
//            public String savePosForm() {
//                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
//            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        }
    }
}