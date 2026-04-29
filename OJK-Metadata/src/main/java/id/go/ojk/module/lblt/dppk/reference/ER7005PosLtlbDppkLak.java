package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7005PosLtlbDppkLak implements IObject<KeyValueString> {

    R_LAK0101000000("LAK0101000000", "Penerimaan Bunga/Bagi Hasil"),
    R_LAK0102000000("LAK0102000000", "Penerimaan Dividen"),
    R_LAK0103000000("LAK0103000000", "Penerimaan Sewa"),
    R_LAK0104000000("LAK0104000000", "Pendapatan Investasi Lain"),
    R_LAK0105000000("LAK0105000000", "Pelepasan Investasi"),
    R_LAK0106000000("LAK0106000000", "Penempatan Investasi"),
    R_LAK0107000000("LAK0107000000", "Pembayaran Beban Investasi"),
    R_LAK0200000000("LAK0200000000", "Arus Kas Bersih dari Aktivitas Investasi"),
    R_LAK0301000000("LAK0301000000", "Pembayaran Beban Operasional"),
    R_LAK0302000000("LAK0302000000", "Penjualan Aset Operasional"),
    R_LAK0303000000("LAK0303000000", "Pembelian Aset Operasional"),
    R_LAK0304000000("LAK0304000000", "Penjualan Aset Lain-Lain"),
    R_LAK0305000000("LAK0305000000", "Pembelian Aset Lain-Lain"),
    R_LAK0306000000("LAK0306000000", "Penerimaan Dana Ta'zir (bagi syariah)"),
    R_LAK0307000000("LAK0307000000", "Pengeluaran Dana Ta'zir (bagi syariah)"),
    R_LAK0308000000("LAK0308000000", "Pendapatan Lain di Luar Investasi"),
    R_LAK0309000000("LAK0309000000", "Beban Lain di Luar Investasi dan Operasional"),
    R_LAK0310000000("LAK0310000000", "Pajak Penghasilan"),
    R_LAK0400000000("LAK0400000000", "Arus Kas Bersih dari Aktivitas Operasional"),
    R_LAK0501000000("LAK0501000000", "Penerimaan Iuran Normal Pemberi Kerja"),
    R_LAK0502000000("LAK0502000000", "Penerimaan Iuran Normal Peserta"),
    R_LAK0503000000("LAK0503000000", "Penerimaan Iuran Sukarela Peserta"),
    R_LAK0504000000("LAK0504000000", "Penerimaan Bunga Keterlambatan Iuran"),
    R_LAK0505000000("LAK0505000000", "Penerimaan Pengalihan Dana dari Dana Pensiun Lain"),
    R_LAK0506000000("LAK0506000000", "Pembayaran Pengalihan Dana ke Dana Pensiun Lain"),
    R_LAK0507000000("LAK0507000000", "Pembayaran Manfaat Pensiun & Manfaat Lain"),
    R_LAK0508000000("LAK0508000000", "Pembayaran Pengalihan Dana ke Balai Harta Peninggalan"),
    R_LAK0600000000("LAK0600000000", "Arus Kas Bersih dari Aktivitas Pendanaan"),
    R_LAK0700000000("LAK0700000000", "KENAIKAN (PENURUNAN) KAS BERSIH"),
    R_LAK0800000000("LAK0800000000", "KAS PADA AWAL PERIODE"),
    R_LAK0900000000("LAK0900000000", "KAS PADA AKHIR PERIODE");

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7005PosLtlbDppkLak eEnum : ER7005PosLtlbDppkLak.values()) {
            res.add(eEnum.getObject());
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

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 11),
                        getObjects()
                );
            }
        }
    }
}