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
public enum ER7005PosLtlbDppkLak implements IObject<KeyValueString> {

//    R_LAK0101000000("LAK0101000000", "Penerimaan Bunga/Bagi Hasil", EnumSet.of(ProgramType.ALL)),
//    R_LAK0102000000("LAK0102000000", "Penerimaan Dividen", EnumSet.of(ProgramType.ALL)),
//    R_LAK0103000000("LAK0103000000", "Penerimaan Sewa", EnumSet.of(ProgramType.ALL)),
//    R_LAK0104000000("LAK0104000000", "Pendapatan Investasi Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0105000000("LAK0105000000", "Pelepasan Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LAK0106000000("LAK0106000000", "Penempatan Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LAK0107000000("LAK0107000000", "Pembayaran Beban Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LAK0200000000("LAK0200000000", "Arus Kas Bersih dari Aktivitas Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LAK0301000000("LAK0301000000", "Pembayaran Beban Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LAK0302000000("LAK0302000000", "Penjualan Aset Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LAK0303000000("LAK0303000000", "Pembelian Aset Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LAK0304000000("LAK0304000000", "Penjualan Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0305000000("LAK0305000000", "Pembelian Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0306000000("LAK0306000000", "Penerimaan Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
//    R_LAK0307000000("LAK0307000000", "Pengeluaran Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
//    R_LAK0308000000("LAK0308000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.ALL)),
//    R_LAK0309000000("LAK0309000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LAK0310000000("LAK0310000000", "Pajak Penghasilan", EnumSet.of(ProgramType.ALL)),
//    R_LAK0400000000("LAK0400000000", "Arus Kas Bersih dari Aktivitas Operasional", EnumSet.of(ProgramType.ALL)),
//    R_LAK0501000000("LAK0501000000", "Penerimaan Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
//    R_LAK0502000000("LAK0502000000", "Penerimaan Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
//    R_LAK0503000000("LAK0503000000", "Penerimaan Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
//    R_LAK0504000000("LAK0504000000", "Penerimaan Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
//    R_LAK0505000000("LAK0505000000", "Penerimaan Pengalihan Dana dari Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0506000000("LAK0506000000", "Pembayaran Pengalihan Dana ke Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0507000000("LAK0507000000", "Pembayaran Manfaat Pensiun dan Manfaat Lain", EnumSet.of(ProgramType.ALL)),
//    R_LAK0508000000("LAK0508000000", "Pembayaran Pengalihan Dana ke Balai Harta Peninggalan", EnumSet.of(ProgramType.ALL)),
//    R_LAK0600000000("LAK0600000000", "Arus Kas Bersih dari Aktivitas Pendanaan", EnumSet.of(ProgramType.ALL)),
//    R_LAK0700000000("LAK0700000000", "KENAIKAN (PENURUNAN) KAS BERSIH", EnumSet.of(ProgramType.ALL)),
//    R_LAK0800000000("LAK0800000000", "KAS PADA AWAL PERIODE", EnumSet.of(ProgramType.ALL)),
//    R_LAK0900000000("LAK0900000000", "KAS PADA AKHIR PERIODE", EnumSet.of(ProgramType.ALL));

    R_LAK0101000000("LAK0101000000", "Penerimaan Bunga/Bagi Hasil", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0102000000("LAK0102000000", "Penerimaan Dividen", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0103000000("LAK0103000000", "Penerimaan Sewa", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0104000000("LAK0104000000", "Pendapatan Investasi Lain", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0105000000("LAK0105000000", "Pelepasan Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0106000000("LAK0106000000", "Penempatan Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0107000000("LAK0107000000", "Pembayaran Beban Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0200000000("LAK0200000000", "Arus Kas Bersih dari Aktivitas Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_LAK0301000000("LAK0301000000", "Pembayaran Beban Operasional", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_LAK0302000000("LAK0302000000", "Penjualan Aset Operasional", EnumSet.of(ProgramType.ALL)),
    R_LAK0302000000_DPLK("LAK0302000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.DPLK)),

    R_LAK0303000000("LAK0303000000", "Pembelian Aset Operasional", EnumSet.of(ProgramType.ALL)),
    R_LAK0303000000_DPLK("LAK0303000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.DPLK)),

    R_LAK0304000000("LAK0304000000", "Penjualan Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_LAK0304000000_DPLK("LAK0304000000", "Pajak Penghasilan", EnumSet.of(ProgramType.DPLK)),

    R_LAK0305000000("LAK0305000000", "Pembelian Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_LAK0306000000("LAK0306000000", "Penerimaan Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
    R_LAK0307000000("LAK0307000000", "Pengeluaran Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
    R_LAK0308000000("LAK0308000000", "Pendapatan Lain di Luar Investasi", EnumSet.of(ProgramType.ALL)),
    R_LAK0309000000("LAK0309000000", "Beban Lain di Luar Investasi dan Operasional", EnumSet.of(ProgramType.ALL)),
    R_LAK0310000000("LAK0310000000", "Pajak Penghasilan", EnumSet.of(ProgramType.ALL)),

    R_LAK0400000000("LAK0400000000", "Arus Kas Bersih dari Aktivitas Operasional", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_LAK0501000000("LAK0501000000", "Penerimaan Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_LAK0501000000_DPLK("LAK0501000000", "Penerimaan Iuran", EnumSet.of(ProgramType.DPLK)),

    R_LAK0502000000("LAK0502000000", "Penerimaan Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
    R_LAK0502000000_DPLK("LAK0502000000", "Penerimaan Pengalihan Dana dari Dana Pensiun Lain", EnumSet.of(ProgramType.DPLK)),

    R_LAK0503000000("LAK0503000000", "Penerimaan Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
    R_LAK0503000000_DPLK("LAK0503000000", "Pembayaran Pengalihan Dana ke Dana Pensiun Lain", EnumSet.of(ProgramType.DPLK)),

    R_LAK0504000000("LAK0504000000", "Penerimaan Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
    R_LAK0504000000_DPLK("LAK0504000000", "Pembayaran Manfaat Pensiun & Manfaat Lain", EnumSet.of(ProgramType.DPLK)),

    R_LAK0505000000("LAK0505000000", "Penerimaan Pengalihan Dana dari Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
    R_LAK0505000000_DPLK("LAK0505000000", "Penarikan Iuran", EnumSet.of(ProgramType.DPLK)),

    R_LAK0506000000("LAK0506000000", "Pembayaran Pengalihan Dana ke Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
    R_LAK0506000000_DPLK("LAK0506000000", "Pembayaran Pengalihan Dana ke Balai Harta Peninggalan", EnumSet.of(ProgramType.DPLK)),

    R_LAK0507000000("LAK0507000000", "Pembayaran Manfaat Pensiun dan Manfaat Lain", EnumSet.of(ProgramType.ALL)),
    R_LAK0508000000("LAK0508000000", "Pembayaran Pengalihan Dana ke Balai Harta Peninggalan", EnumSet.of(ProgramType.ALL)),

    R_LAK0600000000("LAK0600000000", "Arus Kas Bersih dari Aktivitas Pendanaan", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0700000000("LAK0700000000", "KENAIKAN (PENURUNAN) KAS BERSIH", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0800000000("LAK0800000000", "KAS PADA AWAL PERIODE", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAK0900000000("LAK0900000000", "KAS PADA AKHIR PERIODE", EnumSet.of(ProgramType.ALL, ProgramType.DPLK));

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7005PosLtlbDppkLak eEnum : ER7005PosLtlbDppkLak.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7005PosLtlbDppkLak eEnum : ER7005PosLtlbDppkLak.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7005PosLtlbDppkLak.class.getSimpleName().substring(6);
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
        REF_CONFIG_PPMPK {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12), getObjects());
            }
        },

        REF_CONFIG_PPMPM {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2", getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2", getObjects());
            }
        },

        REF_CONFIG_PPIPK {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects());
            }
        },

        REF_CONFIG_PPIPM {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2", getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("2", getObjects());
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }

//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave("2", getObjects());
//            }
//
//            @Override
//            public String savePosForm() {
//                return UtilMetadata.genFieldSave("2", getObjects());
//            }
        },
    }
}