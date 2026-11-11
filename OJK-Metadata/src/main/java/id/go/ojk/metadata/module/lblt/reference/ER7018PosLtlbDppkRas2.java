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
public enum ER7018PosLtlbDppkRas2 implements IObject<KeyValueString> {

//    R_RAS20100000000("RAS20100000000", "Biaya Pegawai, Pengurus, Dewan Pengawas, dan/atau Dewas Pengawas Syariah", EnumSet.of(ProgramType.ALL)),
//    R_RAS20101010000("RAS20101010000", "a. Diklat Pegawai", EnumSet.of(ProgramType.ALL)),
//    R_RAS20101020000("RAS20101020000", "b. Diklat Pengurus", EnumSet.of(ProgramType.ALL)),
//    R_RAS20101030000("RAS20101030000", "c. Diklat Dewan Pengawas", EnumSet.of(ProgramType.ALL)),
//    R_RAS20101040000("RAS20101040000", "d. Diklat Dewan Pengawas Syariah (jika ada)", EnumSet.of(ProgramType.ALL)),
//    R_RAS20102000000("RAS20102000000", "Total Biaya Diklat", EnumSet.of(ProgramType.ALL)),
//    R_RAS20103000000("RAS20103000000", "Rasio Biaya Diklat", EnumSet.of(ProgramType.ALL));

    R_RAS20100000000("RAS20100000000", "Biaya Pegawai, Pengurus, Dewan Pengawas, dan/atau Dewas Pengawas Syariah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

//    R_RAS20101000000("RAS20101000000", "Biaya Pendidikan dan Latihan (Diklat)", EnumSet.of(ProgramType.DPLK)),

    R_RAS20101010000("RAS20101010000", "a. Diklat Pegawai", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_RAS20101020000("RAS20101020000", "b. Diklat Pengurus", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_RAS20101030000("RAS20101030000", "c. Diklat Dewan Pengawas", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_RAS20101040000("RAS20101040000", "d. Diklat Dewan Pengawas Syariah (jika ada)", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_RAS20102000000("RAS20102000000", "Total Biaya Diklat", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_RAS20103000000("RAS20103000000", "Rasio Biaya Diklat", EnumSet.of(ProgramType.ALL, ProgramType.DPLK));
    

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7018PosLtlbDppkRas2 eEnum : ER7018PosLtlbDppkRas2.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        if (!jenisProgram.equals(ProgramType.PPMPPPIPK)) return getNonGabunganObjects(jenisProgram);

        ER7018PosLtlbDppkRas2[] eVals = ER7018PosLtlbDppkRas2.values();

        List<KeyValueString> res = Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPMPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7018PosLtlbDppkRas2::getObject).collect(Collectors.toList());

        res.addAll(Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPIPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7018PosLtlbDppkRas2::getObject)
                .collect(Collectors.toList()));

        return res;
    }

    private static List<KeyValueString> getNonGabunganObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7018PosLtlbDppkRas2 eEnum : ER7018PosLtlbDppkRas2.values()) {
            if (!jenisProgram.equals(ProgramType.DPLK) && (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(ProgramType.ALL))) {
                res.add(eEnum.getObject());
            } else if (jenisProgram.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
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

    public static int getRowSize(ProgramType programType) {
                if (programType.equals(ProgramType.DPLK) || programType.equals(ProgramType.PPMPPPIPK)) {
            return getObjects(programType).size();
        }

        return getObjects().size();
    }

    public static ReferenceConfig getRefConfig(ProgramType programType) {
        switch (programType) {
            case PPMPK:
            case PPMPM:
            case PPIPK:
            case PPIPM:
                return Configs.REF_CONFIG;
            case DPLK:
                return Configs.REF_CONFIG_DPLK;
            case PPMPPPIPK:
                return Configs.REF_CONFIG_GABUNGAN;
            default:
                throw new IllegalStateException();
        }
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
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2|3|4", getObjects(programType));
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects(programType));
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