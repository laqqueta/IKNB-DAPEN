package id.go.ojk.metadata.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7000PosLtlbDppkDtum implements IObject<KeyValueString> {

    R_DTUM010000("DTUM010000", "Alamat Dana Pensiun"),
    R_DTUM020000("DTUM020000", "Program Pensiun"),
    R_DTUM030000("DTUM030000", "Nama Pengurus"),
    R_DTUM040000("DTUM040000", "Jabatan Pengurus"),
    R_DTUM050000("DTUM050000", "Nomor SID"),
    R_DTUM060000("DTUM060000", "Status Kepesertaan (Open/Close)"),
    R_DTUM070000("DTUM070000", "Tanggal Efektif Close Kepesertaan (Jika status kepesertaan telah close)"),
    R_DTUM080100("DTUM080100", "SK Izin Auditor"),
    R_DTUM080200("DTUM080200", "Jenis Audit"),
    R_DTUM080300("DTUM080300", "Kode Auditor"),
    R_DTUM080400("DTUM080400", "Nama Auditor"),
    R_DTUM080500("DTUM080500", "Opini"),
    R_DTUM080600("DTUM080600", "Pelaksana Audit"),
    R_DTUM080700("DTUM080700", "Tanggal Audit"),
    R_DTUM090100("DTUM090100", "Nama Petugas"),
    R_DTUM090200("DTUM090200", "Divisi"),
    R_DTUM090300("DTUM090300", "Telepon"),
    R_DTUM090400("DTUM090400", "Fax"),
    R_DTUM090500("DTUM090500", "E-mail"),
    R_DTUM100100("DTUM100100", "Nama Penanggung Jawab"),
    R_DTUM100200("DTUM100200", "Jabatan"),
    R_DTUM100300("DTUM100300", "Telepon"),
    R_DTUM100400("DTUM100400", "Fax"),
    R_DTUM100500("DTUM100500", "E-mail"),
    R_DTUM100600("DTUM100600", "Susunan Pengurus"),
    R_DTUM110100("DTUM110100", "Susunan Dewan Pengawas"),
    R_DTUM120100("DTUM120100", "Susunan Dewan Pengawas Syariah");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7000PosLtlbDppkDtum eEnum : ER7000PosLtlbDppkDtum.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7000PosLtlbDppkDtum.class.getSimpleName().substring(6);
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
        }
    }
}