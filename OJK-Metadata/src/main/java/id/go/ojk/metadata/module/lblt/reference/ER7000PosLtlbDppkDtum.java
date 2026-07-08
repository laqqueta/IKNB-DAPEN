package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7000PosLtlbDppkDtum implements IObject<KeyValueString> {

    R_DTUM010000("DTUM010000", "Alamat Dana Pensiun", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM020000("DTUM020000", "Program Pensiun", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM030000("DTUM030000", "Nama Pengurus", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM040000("DTUM040000", "Jabatan Pengurus", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM050000("DTUM050000", "Nomor SID", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM060000("DTUM060000", "Status Kepesertaan (Open/Close)", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM070000("DTUM070000", "Tanggal Efektif Close Kepesertaan (Jika status kepesertaan telah close)", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_DTUM080100("DTUM080100", "SK Izin Auditor", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080200("DTUM080200", "Jenis Audit", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080300("DTUM080300", "Kode Auditor", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080400("DTUM080400", "Nama Auditor", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080500("DTUM080500", "Opini", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080600("DTUM080600", "Pelaksana Audit", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM080700("DTUM080700", "Tanggal Audit", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_DTUM090100("DTUM090100", "Nama Petugas", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM090200("DTUM090200", "Divisi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM090300("DTUM090300", "Telepon", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM090400("DTUM090400", "Fax", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM090500("DTUM090500", "E-mail", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_DTUM100100("DTUM100100", "Nama Penanggung Jawab", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM100200("DTUM100200", "Jabatan", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM100300("DTUM100300", "Telepon", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM100400("DTUM100400", "Fax", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM100500("DTUM100500", "E-mail", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM100600("DTUM100600", "Rincian - Susunan Pengurus", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM110100("DTUM110100", "Rincian - Susunan Dewan Pengawas", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_DTUM120100("DTUM120100", "Rincian - Susunan Dewan Pengawas Syariah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK));

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7000PosLtlbDppkDtum eEnum : ER7000PosLtlbDppkDtum.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7000PosLtlbDppkDtum eEnum : ER7000PosLtlbDppkDtum.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }

        }
        return res;
    }


    public static String getName() {
        return ER7000PosLtlbDppkDtum.class.getSimpleName().substring(6);
    }

    public static String getNameDplk() {
        return ER7000PosLtlbDppkDtum.class.getSimpleName().substring(7);
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

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_ALL {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRowExcept(getObjects(), new int[]{24, 25, 26});
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("0", getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2", Collections.singletonList(R_DTUM080700.getObject()));
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String requiredPos() {
//                return UtilMetadata.genPipeRowExcept(getObjects(), new int[]{24, 25, 26});

                return UtilMetadata.genPipeRow(getObjects(programType));
            }

//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave("0", getObjects());
//            }
//
//            @Override
//            public String savePosForm() {
//                return UtilMetadata.genFieldSave("2", Collections.singletonList(R_DTUM080700.getObject()));
//            }
        }
    }
}