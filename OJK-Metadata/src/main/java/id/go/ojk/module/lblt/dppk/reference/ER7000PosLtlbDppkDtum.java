package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
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
    R_DTUM120100("DTUM120100", "Susunan Dewan Pengawas Syariah")

    ;


    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

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

    public static int getRefNumber() {
        return Integer.parseInt(ER7000PosLtlbDppkDtum.class.getSimpleName().substring(2, 6));
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 24, 25, 26 });
    }

    public static final List<SegmentValidation> SEGMENT_VALIDATIONS = Arrays.asList(
            genValidationAll(),
            genValidationDate(),
            genValidationLength1(),
            genValidationLength2(),
            genValidationLength3(),
            genValidationLength4()
    );

    private static SegmentValidation genValidationAll() {
        return UtilSegmentValidation.genRegexAll("2",
                UtilMetadata.genPipeRowExcept(getObjects(), new int[] {6, 13}));
    }

    private static SegmentValidation genValidationDate() {
        return UtilSegmentValidation.genRegexDate("2",
                UtilMetadata.genPipeRow(getObjects(), new int[] {6, 13}));
    }

    private static SegmentValidation genValidationLength1() {
        return UtilSegmentValidation.genLength("2",
                UtilMetadata.genPipeRow(getObjects(), new int[] {4, 5}), 1, 20);
    }

    private static SegmentValidation genValidationLength2() {
        return UtilSegmentValidation.genLength("2",
                UtilMetadata.genPipeRow(getObjects(), new int[] {0}),1, 500);
    }

    private static SegmentValidation genValidationLength3() {
        return UtilSegmentValidation.genLength("2",
                UtilMetadata.genPipeRow(getObjects(), new int[] {6, 13}), 8, 10);
    }

    private static SegmentValidation genValidationLength4() {
        return UtilSegmentValidation.genLength("2",
                UtilMetadata.genPipeRowExcept(getObjects(), new int[] {0, 4, 5, 6, 13}),1, 100);
    }

    /*public static ConditionalRequired genConditionalExist16() {
        return UtilFieldConditional.genAllExistPosAndInReference("N", "M", "16", INVDEP0100000000.key, getRefNumber());
    }

    public static ConditionalRequired genConditionalExist17() {
        return UtilFieldConditional.genAllExistPos("N", "M", "15", INVDEP0100000000.key);
    }

    public static ConditionalRequired genConditionalExistA() {
        return UtilFieldConditional.genExistPosAndHasReference("M", "N", INVDEP0100000000.key, getRefNumber(), "O");
    }*/


}
