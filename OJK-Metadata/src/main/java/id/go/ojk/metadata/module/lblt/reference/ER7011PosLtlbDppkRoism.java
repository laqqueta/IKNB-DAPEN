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
public enum ER7011PosLtlbDppkRoism implements IObject<KeyValueString> {

//    R_ROISM0100000000("ROISM0100000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0200000000("ROISM0200000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0300000000("ROISM0300000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0400000000("ROISM0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0500000000("ROISM0500000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0600000000("ROISM0600000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0700000000("ROISM0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0800000000("ROISM0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM0900000000("ROISM0900000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1000000000("ROISM1000000000", "Reksa Dana", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1100000000("ROISM1100000000", "MTN", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1200000000("ROISM1200000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1300000000("ROISM1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1400000000("ROISM1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1500000000("ROISM1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1600000000("ROISM1600000000", "REPO", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1700000000("ROISM1700000000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1800000000("ROISM1800000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM1900000000("ROISM1900000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM2000000000("ROISM2000000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ROISM2100000000("ROISM2100000000", "Total", EnumSet.of(ProgramType.ALL))

    R_ROISM0100000000("ROISM0100000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0200000000("ROISM0200000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0300000000("ROISM0300000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0400000000("ROISM0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0500000000("ROISM0500000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0600000000("ROISM0600000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0700000000("ROISM0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0800000000("ROISM0800000000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM0900000000("ROISM0900000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1000000000("ROISM1000000000", "Reksa Dana", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1100000000("ROISM1100000000", "MTN", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1200000000("ROISM1200000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1300000000("ROISM1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1400000000("ROISM1400000000", "Dana investasi infrastruktur berbetuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1500000000("ROISM1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1600000000("ROISM1600000000", "REPO", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1700000000("ROISM1700000000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1800000000("ROISM1800000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM1900000000("ROISM1900000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM2000000000("ROISM2000000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ROISM2100000000("ROISM2100000000", "Total", EnumSet.of(ProgramType.ALL, ProgramType.DPLK));

    ;

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7011PosLtlbDppkRoism eEnum : ER7011PosLtlbDppkRoism.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7011PosLtlbDppkRoism eEnum : ER7011PosLtlbDppkRoism.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7011PosLtlbDppkRoism.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static int getRowSize(ProgramType programType) {
        return programType.equals(ProgramType.DPLK) ? getObjects(programType).size() : getObjects().size();
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11),getObjects());
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
//                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11),getObjects());
//            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },
    }
}