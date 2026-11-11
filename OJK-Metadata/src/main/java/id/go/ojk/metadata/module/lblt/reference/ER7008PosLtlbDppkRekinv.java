package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7008PosLtlbDppkRekinv implements IObject<KeyValueString> {
    R_REKINV0100000000("REKINV0100000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0200000000("REKINV0200000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0300000000("REKINV0300000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0400000000("REKINV0400000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0500000000("REKINV0500000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0600000000("REKINV0600000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0700000000("REKINV0700000000", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0800000000("REKINV0800000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV0900000000("REKINV0900000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1000000000("REKINV1000000000", "Reksa Dana", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1100000000("REKINV1100000000", "MTN", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1200000000("REKINV1200000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1300000000("REKINV1300000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1400000000("REKINV1400000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1500000000("REKINV1500000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1600000000("REKINV1600000000", "REPO", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1700000000("REKINV1700000000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1800000000("REKINV1800000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV1900000000("REKINV1900000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV2000000000("REKINV2000000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_REKINV2100000000("REKINV2100000000", "TOTAL INVESTASI", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_REKINV2200000000("REKINV2200000000", "Aset Tersedia Gabungan", EnumSet.of(ProgramType.ALL)),
    R_REKINV2300000000("REKINV2300000000", "Aset Tersedia Manfaat Lain",
            EnumSet.of(ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_REKINV2400000000("REKINV2400000000", "Aset Tersedia Manfaat Pensiun Lain",
            EnumSet.of(ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),

    ;

    private final String key;
    private final String value;
    private final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        if (!jenisProgram.equals(ProgramType.PPMPPPIPK)) return getNonGabunganObjects(jenisProgram);

        ER7008PosLtlbDppkRekinv[] eVals = ER7008PosLtlbDppkRekinv.values();

        List<KeyValueString> res = Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPMPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7008PosLtlbDppkRekinv::getObject).collect(Collectors.toList());

        res.addAll(Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPIPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7008PosLtlbDppkRekinv::getObject)
                .collect(Collectors.toList()));

        return res;
    }

    private static List<KeyValueString> getNonGabunganObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7008PosLtlbDppkRekinv eEnum : ER7008PosLtlbDppkRekinv.values()) {
            if (!jenisProgram.equals(ProgramType.DPLK) && (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(ProgramType.ALL))) {
                res.add(eEnum.getObject());
            } else if (jenisProgram.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7008PosLtlbDppkRekinv.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static int getRowSize(ProgramType programType) {
        return getObjects(programType).size();
    }

    public static ReferenceConfig getRefConfig(ProgramType programType) {
        switch (programType) {
            case PPMPK:
                return Configs.REF_CONFIG_PPMPK;
            case PPMPM:
                return Configs.REF_CONFIG_PPMPM;
            case PPIPK:
                return Configs.REF_CONFIG_PPIPK;
            case PPIPM:
                return Configs.REF_CONFIG_PPIPM;
            case DPLK:
                return Configs.REF_CONFIG_DPLK;
            case PPMPPPIPK:
                return Configs.REF_CONFIG_GABUNGAN;
            default:
                throw new IllegalStateException();
        }
    }

    enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            private final ProgramType programType = ProgramType.PPMPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPMPM {
            private final ProgramType programType = ProgramType.PPMPM;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPIPK {
            private final ProgramType programType = ProgramType.PPIPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPIPM {
            private final ProgramType programType = ProgramType.PPIPM;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_GABUNGAN {
            private final ProgramType programType = ProgramType.PPMPPPIPK;
            private final String rowPPMP = UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPK));
            private final String rowPPIP = UtilMetadata.genPipeRow(getObjects(ProgramType.PPIPK));

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 14),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 14), getObjects(programType));
            }

            @Override
            public Integer segmentRequireColumnLink() {
                return 2;
            }

            @Override
            public String segmentColumnValue() {
                return "PPMP|PPIP";
            }

            @Override
            public String segmentReqiurePosCode() {
                return rowPPMP + "#" + rowPPIP;
            }

            @Override
            public String segmentUniquePos() {
                return rowPPMP + "#" + rowPPIP;
            }
        }    }
}