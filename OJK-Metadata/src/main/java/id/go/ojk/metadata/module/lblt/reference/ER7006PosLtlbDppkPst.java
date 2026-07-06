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
public enum ER7006PosLtlbDppkPst implements IObject<KeyValueString> {

    R_PST0100000000("PST0100000000", "(1) Peserta Aktif", EnumSet.of(ProgramType.ALL)),
    R_PST0101000000("PST0101000000", "a. Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0102000000("PST0102000000", "b. Mitra Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0200000000("PST0200000000", "(2) Peserta Pasif", EnumSet.of(ProgramType.ALL)),
    R_PST0201000000("PST0201000000", "a. Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0201010000("PST0201010000", "- Pensiunan", EnumSet.of(ProgramType.ALL)),
    R_PST0201020000("PST0201020000", "- Janda/Duda", EnumSet.of(ProgramType.ALL)),
    R_PST0201030000("PST0201030000", "- Anak", EnumSet.of(ProgramType.ALL)),
    R_PST0201040000("PST0201040000", "- Pensiun Ditunda", EnumSet.of(ProgramType.ALL)),
    R_PST0202000000("PST0202000000", "b. Mitra Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0202010000("PST0202010000", "- Pensiunan", EnumSet.of(ProgramType.ALL)),
    R_PST0202020000("PST0202020000", "- Janda/Duda", EnumSet.of(ProgramType.ALL)),
    R_PST0202030000("PST0202030000", "- Anak", EnumSet.of(ProgramType.ALL)),
    R_PST0202040000("PST0202040000", "- Pensiun Ditunda", EnumSet.of(ProgramType.ALL)),
    R_PST0300000000("PST0300000000", "(3) Peserta Dana Tidak Aktif", EnumSet.of(ProgramType.ALL)),
    R_PST0301000000("PST0301000000", "a. Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0302000000("PST0302000000", "b. Mitra Pendiri", EnumSet.of(ProgramType.ALL)),
    R_PST0400000000("PST0400000000", "(4) Jumlah Peserta DPPK (1) + (2) + (3)", EnumSet.of(ProgramType.ALL)),
    R_PST0500000000("PST0500000000", "(5) Jumlah Perusahaan Mitra Pendiri Dana Pensiun", EnumSet.of(ProgramType.ALL));

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7006PosLtlbDppkPst eEnum : ER7006PosLtlbDppkPst.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7006PosLtlbDppkPst eEnum : ER7006PosLtlbDppkPst.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7006PosLtlbDppkPst.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK_PPIPK {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4),getObjects());
            }
        },

        REF_CONFIG_PPMPM_PPIPM {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2", getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2",getObjects());
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }

//            @Override
//            public String savePosForm() {
//                return UtilMetadata.genFieldSave("2", getObjects());
//            }
//
//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave("2",getObjects());
//            }
        },
    }
}