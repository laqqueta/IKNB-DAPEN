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
public enum ER7004PosLtlbDppkLphu implements IObject<KeyValueString> {

//    R_LPHU0101000000("LPHU0101000000", "Bunga/Bagi Hasil", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0102000000("LPHU0102000000", "Dividen", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0103000000("LPHU0103000000", "Sewa", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0104000000("LPHU0104000000", "Laba (Rugi) Pelepasan Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0105000000("LPHU0105000000", "Pendapatan Investasi Lain", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0106000000("LPHU0106000000", "Total Pendapatan Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0201000000("LPHU0201000000", "Beban Transaksi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0202000000("LPHU0202000000", "Beban Pemeliharaan Tanah dan Bangunan", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0203000000("LPHU0203000000", "Beban Penyusutan Bangunan", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0204000000("LPHU0204000000", "Beban Manajer Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0205000000("LPHU0205000000", "Beban Kustodi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0206000000("LPHU0206000000", "Beban Investasi Lain", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0300000000("LPHU0300000000", "Total Beban Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0400000000("LPHU0400000000", "HASIL USAHA INVESTASI", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0501000000("LPHU0501000000", "Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0502000000("LPHU0502000000", "Beban Kantor", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0503000000("LPHU0503000000", "Beban Pemeliharaan", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0504000000("LPHU0504000000", "Beban Penyusutan", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0505000000("LPHU0505000000", "Beban Jasa Pihak Ketiga", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0506000000("LPHU0506000000", "Beban Pendidikan dan Pelatihan", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0507000000("LPHU0507000000", "Beban Operasional Lain", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0508000000("LPHU0508000000", "Total Beban Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0601000000("LPHU0601000000", "Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0602000000("LPHU0602000000", "Laba (Rugi) Penjualan Aset Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0603000000("LPHU0603000000", "Laba (Rugi) Penjualan Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0604000000("LPHU0604000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0605000000("LPHU0605000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0606000000("LPHU0606000000", "Total Pendapatan dan Beban Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0700000000("LPHU0700000000", "HASIL USAHA SEBELUM PAJAK", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0800000000("LPHU0800000000", "PAJAK PENGHASILAN", EnumSet.of(ProgramType.ALL)),
//    R_LPHU0900000000("LPHU0900000000", "HASIL USAHA SETELAH PAJAK", EnumSet.of(ProgramType.ALL)),

    R_LPHU0101000000("LPHU0101000000", "Bunga/Bagi Hasil", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0102000000("LPHU0102000000", "Dividen", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0103000000("LPHU0103000000", "Sewa", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0104000000("LPHU0104000000", "Laba (Rugi) Pelepasan Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0105000000("LPHU0105000000", "Pendapatan Investasi Lain", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0106000000("LPHU0106000000", "Total Pendapatan Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

//    R_LPHU0200000000("LPHU0200000000", "BEBAN INVESTASI", EnumSet.of(ProgramType.DPLK)),
    R_LPHU0201000000("LPHU0201000000", "Beban Transaksi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0202000000("LPHU0202000000", "Beban Pemeliharaan Tanah dan Bangunan", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0203000000("LPHU0203000000", "Beban Penyusutan Bangunan", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0204000000("LPHU0204000000", "Beban Manajer Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0205000000("LPHU0205000000", "Beban Kustodi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0206000000("LPHU0206000000", "Beban Investasi Lain", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0300000000("LPHU0300000000", "Total Beban Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0400000000("LPHU0400000000", "HASIL USAHA INVESTASI", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

//    R_LPHU0500000000("LPHU0500000000", "BEBAN OPERASIONAL", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0501000000("LPHU0501000000", "Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas", EnumSet.of(ProgramType.ALL)),
    R_LPHU0501000000_DPLK("LPHU0501000000", "Fee Kepada Pendiri", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0502000000("LPHU0502000000", "Beban Kantor", EnumSet.of(ProgramType.ALL)),
    R_LPHU0502000000_DPLK("LPHU0502000000", "Total Beban Operasional", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0503000000("LPHU0503000000", "Beban Pemeliharaan", EnumSet.of(ProgramType.ALL)),
    R_LPHU0504000000("LPHU0504000000", "Beban Penyusutan", EnumSet.of(ProgramType.ALL)),
    R_LPHU0505000000("LPHU0505000000", "Beban Jasa Pihak Ketiga", EnumSet.of(ProgramType.ALL)),
    R_LPHU0506000000("LPHU0506000000", "Beban Pendidikan dan Pelatihan", EnumSet.of(ProgramType.ALL)),
    R_LPHU0507000000("LPHU0507000000", "Beban Operasional Lain", EnumSet.of(ProgramType.ALL)),
    R_LPHU0508000000("LPHU0508000000", "Total Beban Operasional", EnumSet.of(ProgramType.ALL)),

//    R_LPHU0600000000("LPHU0600000000", "PENDAPATAN DAN BEBAN LAIN-LAIN", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0601000000("LPHU0601000000", "Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
    R_LPHU0601000000_DPLK("LPHU0601000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0602000000("LPHU0602000000", "Laba (Rugi) Penjualan Aset Operasional", EnumSet.of(ProgramType.ALL)),
    R_LPHU0602000000_DPLK("LPHU0602000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0603000000("LPHU0603000000", "Laba (Rugi) Penjualan Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_LPHU0603000000_DPLK("LPHU0603000000", "Total Pendapatan dan Beban Lain-Lain", EnumSet.of(ProgramType.DPLK)),

    R_LPHU0604000000("LPHU0604000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPHU0605000000("LPHU0605000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.ALL)),
    R_LPHU0606000000("LPHU0606000000", "Total Pendapatan dan Beban Lain-Lain", EnumSet.of(ProgramType.ALL)),

    R_LPHU0700000000("LPHU0700000000", "HASIL USAHA SEBELUM PAJAK", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0800000000("LPHU0800000000", "PAJAK PENGHASILAN", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LPHU0900000000("LPHU0900000000", "HASIL USAHA SETELAH PAJAK", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    ;

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7004PosLtlbDppkLphu eEnum : ER7004PosLtlbDppkLphu.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7004PosLtlbDppkLphu eEnum : ER7004PosLtlbDppkLphu.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7004PosLtlbDppkLphu.class.getSimpleName().substring(6);
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
            default:
                throw new IllegalStateException();
        }
    }

    enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12),getObjects());}

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        },

        REF_CONFIG_PPMPM {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2",getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        },

        REF_CONFIG_PPIPK {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16),getObjects());}

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        },

        REF_CONFIG_PPIPM {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2",getObjects());
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12),getObjects(programType));}

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },
    }
}