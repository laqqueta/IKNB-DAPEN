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
public enum ER7021PosLtlbDppkTbdsp implements IObject<KeyValueString> {

//    R_TBDSP0100000000("TBDSP0100000000", "A. Saldo Awal", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0200000000("TBDSP0200000000", "B. Penambahan Tahun Berjalan", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0201000000("TBDSP0201000000", "1. Transaksi tidak sesuai dengan prinsip syariah yang tidak dapat dihindarkan, termasuk pendapatan bunga (riba)", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0202010000("TBDSP0202010000", "Rincian - Mitra Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0202020000("TBDSP0202020000", "Total dana sanksi (dana ta'zir)", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0203000000("TBDSP0203000000", "3. Transaksi syariah yang tidak terpenuhi ketentuan dan batasannya", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0204000000("TBDSP0204000000", "4. Dana yang tidak diketahui pemiliknya, diketahui pemiliknya tetapi tidak ditemukan, atau diketahui pemiliknya tetapi biaya pengembaliannya lebih besar dari jumlah dana tersebut", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0205000000("TBDSP0205000000", "5. Transaksi lainnya yang tidak sesuai dengan Prinsip Syariah", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0301000000("TBDSP0301000000", "Rincian - Nama Penerima", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0303000000("TBDSP0303000000", "Total Pengguna Tahun Berjalan", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0400000000("TBDSP0400000000", "D. Saldo Akhir (A+B-C)", EnumSet.of(ProgramType.ALL));

    R_TBDSP0100000000("TBDSP0100000000", "A. Saldo Awal", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_TBDSP0200000000("TBDSP0200000000", "B. Penambahan Tahun Berjalan", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_TBDSP0201000000("TBDSP0201000000", "1. Transaksi tidak sesuai dengan prinsip syariah yang tidak dapat dihindarkan, termasuk pendapatan bunga (riba)", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_TBDSP0202000000("TBDSP0202000000", "2. Transaksi syariah yang tidak terpenuhi ketentuan dan batasannya", EnumSet.of(ProgramType.DPLK)),
    R_TBDSP0202010000("TBDSP0202010000", "Rincian - Mitra Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_TBDSP0202020000("TBDSP0202020000", "Total dana sanksi (dana ta'zir)", EnumSet.of(ProgramType.ALL)),
    R_TBDSP0203000000("TBDSP0203000000", "3. Transaksi syariah yang tidak terpenuhi ketentuan dan batasannya", EnumSet.of(ProgramType.ALL)),
    R_TBDSP0203000000_DPLK("TBDSP0203000000", "3. Dana yang tidak diketahui pemiliknya, diketahui pemiliknya tetapi tidak ditemukan, atau diketahui pemiliknya tetapi biaya pengembaliannya lebih besar dari jumlah dana tersebut", EnumSet.of(ProgramType.DPLK)),
    R_TBDSP0204000000("TBDSP0204000000", "4. Dana yang tidak diketahui pemiliknya, diketahui pemiliknya tetapi tidak ditemukan, atau diketahui pemiliknya tetapi biaya pengembaliannya lebih besar dari jumlah dana tersebut", EnumSet.of(ProgramType.ALL)),
    R_TBDSP0204000000_DPLK("TBDSP0204000000", "4. Transaksi lainnya yang tidak sesuai dengan Prinsip Syariah", EnumSet.of(ProgramType.DPLK)),
    R_TBDSP0205000000("TBDSP0205000000", "5. Transaksi lainnya yang tidak sesuai dengan Prinsip Syariah", EnumSet.of(ProgramType.ALL)),
//    R_TBDSP0300000000("TBDSP0300000000", "C. Penggunaan Tahun Berjalan", EnumSet.of(ProgramType.DPLK)),
    R_TBDSP0301000000("TBDSP0301000000", "Rincian - Nama Penerima", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_TBDSP0302000000("TBDSP0302000000", "Total Pengguna Tahun Berjalan", EnumSet.of(ProgramType.DPLK)),
    R_TBDSP0303000000("TBDSP0303000000", "Total Pengguna Tahun Berjalan", EnumSet.of(ProgramType.ALL)),
    R_TBDSP0400000000("TBDSP0400000000", "D. Saldo Akhir (A+B-C)", EnumSet.of(ProgramType.ALL, ProgramType.DPLK))

    ;

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7021PosLtlbDppkTbdsp eEnum : ER7021PosLtlbDppkTbdsp.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7021PosLtlbDppkTbdsp eEnum : ER7021PosLtlbDppkTbdsp.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7021PosLtlbDppkTbdsp.class.getSimpleName().substring(6);
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
                return UtilMetadata.genFieldSave("3", getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRowExcept(getObjects(), new int[]{3, 7});
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave("3", getObjects());
//            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRowExcept(getObjects(programType), new int[]{3, 7});
            }
        }
    }
}