package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

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

    R_DTUM010000("DTUM010000", "Alamat Dana Pensiun"), // 0
    R_DTUM020000("DTUM020000", "Program Pensiun"), // 1
    R_DTUM030000("DTUM030000", "Nama Pengurus"), // 2
    R_DTUM040000("DTUM040000", "Jabatan Pengurus"), // 3
    R_DTUM050000("DTUM050000", "Nomor SID"), // 4
    R_DTUM060000("DTUM060000", "Status Kepesertaan (Open/Close)"), // 5
    R_DTUM070000("DTUM070000", "Tanggal Efektif Close Kepesertaan (Jika status kepesertaan telah close)"), // 6
    R_DTUM090000("DTUM090000", "SK Izin Auditor"), // 7
    R_DTUM100000("DTUM100000", "Jenis Audit"), // 8
    R_DTUM110000("DTUM110000", "Kode Auditor"), // 9
    R_DTUM120000("DTUM120000", "Nama Auditor"), // 10
    R_DTUM130000("DTUM130000", "Opini"), // 11
    R_DTUM140000("DTUM140000", "Pelaksana Audit"), // 12
    R_DTUM150000("DTUM150000", "Tanggal Audit"), // 13
    R_DTUM170000("DTUM170000", "Nama Petugas"), // 14
    R_DTUM180000("DTUM180000", "Divisi"), // 15
    R_DTUM190000("DTUM190000", "Telepon"), // 16
    R_DTUM200000("DTUM200000", "Fax"), // 17
    R_DTUM210000("DTUM210000", "E-mail"), // 18
    R_DTUM230000("DTUM230000", "Nama Penanggung Jawab"), // 19
    R_DTUM240000("DTUM240000", "Jabatan"), // 20
    R_DTUM250000("DTUM250000", "Telepon"), // 21
    R_DTUM260000("DTUM260000", "Fax"), // 22
    R_DTUM270000("DTUM270000", "E-mail"), // 23
    R_DTUM280000("DTUM280000", "Susunan Pengurus ke-1"), // 24
    R_DTUM290000("DTUM290000", "Susunan Pengurus ke-2"), // 25
    R_DTUM300000("DTUM300000", "Susunan Pengurus ke-3"), // 26
    R_DTUM310000("DTUM310000", "Susunan Pengurus ke-4"), // 27
    R_DTUM320000("DTUM320000", "Susunan Pengurus ke-5"), // 28
    R_DTUM330000("DTUM330000", "Susunan Pengurus ke-6"), // 29
    R_DTUM340000("DTUM340000", "Susunan Pengurus ke-7"), // 30
    R_DTUM350000("DTUM350000", "Susunan Pengurus ke-8"), // 31
    R_DTUM360000("DTUM360000", "Susunan Pengurus ke-9"), // 32
    R_DTUM370000("DTUM370000", "Susunan Pengurus ke-10"), // 33
    R_DTUM390000("DTUM390000", "Susunan Dewan Pengawas ke -1"), // 34
    R_DTUM400000("DTUM400000", "Susunan Dewan Pengawas ke -2"), // 35
    R_DTUM410000("DTUM410000", "Susunan Dewan Pengawas ke -3"), // 36
    R_DTUM420000("DTUM420000", "Susunan Dewan Pengawas ke -4"), // 37
    R_DTUM430000("DTUM430000", "Susunan Dewan Pengawas ke -5"), // 38
    R_DTUM440000("DTUM440000", "Susunan Dewan Pengawas ke -6"), // 39
    R_DTUM450000("DTUM450000", "Susunan Dewan Pengawas ke -7"), // 40
    R_DTUM460000("DTUM460000", "Susunan Dewan Pengawas ke -8"), // 41
    R_DTUM470000("DTUM470000", "Susunan Dewan Pengawas ke -9"), // 42
    R_DTUM480000("DTUM480000", "Susunan Dewan Pengawas ke -10"), // 43
    R_DTUM490000("DTUM490000", "Susunan Dewan Pengawas ke -11"), // 44
    R_DTUM500000("DTUM500000", "Susunan Dewan Pengawas ke -12"), // 45
    R_DTUM510000("DTUM510000", "Susunan Dewan Pengawas ke -13"), // 46
    R_DTUM520000("DTUM520000", "Susunan Dewan Pengawas ke -14"), // 47
    R_DTUM530000("DTUM530000", "Susunan Dewan Pengawas ke -15"), // 48
    R_DTUM540000("DTUM540000", "Susunan Dewan Pengawas ke -16"), // 49
    R_DTUM560000("DTUM560000", "Susunan Dewan Pengawas Syariah ke-1"), // 50
    R_DTUM570000("DTUM570000", "Susunan Dewan Pengawas Syariah ke-2"), // 51
    R_DTUM580000("DTUM580000", "Susunan Dewan Pengawas Syariah ke-3"), // 52
    R_DTUM590000("DTUM590000", "Susunan Dewan Pengawas Syariah ke-4"), // 53
    R_DTUM600000("DTUM600000", "Susunan Dewan Pengawas Syariah ke-5"); // 54


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

    public static final List<SegmentValidation> SEGMENT_VALIDATIONS = Arrays.asList(
            genValidationAll(),
            genValidationDate()
    );

    private static SegmentValidation genValidationAll() {
        return UtilSegmentValidation.genRegexAll("4",
                UtilMetadata.genPipeRowExcept(getObjects(), new int[] {6, 14}));
    }

    private static SegmentValidation genValidationDate() {
        return UtilSegmentValidation.genRegexDate("4",
                UtilMetadata.genPipeRow(getObjects(), new int[] {6, 14}));
    }
}
