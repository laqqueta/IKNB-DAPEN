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
public enum ER7004PosLtlbDppkLphu implements IObject<KeyValueString> {

    R_LPHU0101000000("LPHU0101000000", "Bunga/Bagi Hasil"),
    R_LPHU0102000000("LPHU0102000000", "Dividen"),
    R_LPHU0103000000("LPHU0103000000", "Sewa"),
    R_LPHU0104000000("LPHU0104000000", "Laba (Rugi) Pelepasan Investasi"),
    R_LPHU0105000000("LPHU0105000000", "Pendapatan Investasi Lain"),
    R_LPHU0106000000("LPHU0106000000", "Total Pendapatan Investasi"),
    R_LPHU0201000000("LPHU0201000000", "Beban Transaksi"),
    R_LPHU0202000000("LPHU0202000000", "Beban Pemeliharaan Tanah dan Bangunan"),
    R_LPHU0203000000("LPHU0203000000", "Beban Penyusutan Bangunan"),
    R_LPHU0204000000("LPHU0204000000", "Beban Manajer Investasi"),
    R_LPHU0205000000("LPHU0205000000", "Beban Kustodi"),
    R_LPHU0206000000("LPHU0206000000", "Beban Investasi Lain"),
    R_LPHU0300000000("LPHU0300000000", "Total Beban Investasi"),
    R_LPHU0400000000("LPHU0400000000", "HASIL USAHA INVESTASI"),
    R_LPHU0501000000("LPHU0501000000", "Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas"),
    R_LPHU0502000000("LPHU0502000000", "Beban Kantor"),
    R_LPHU0503000000("LPHU0503000000", "Beban Pemeliharaan"),
    R_LPHU0504000000("LPHU0504000000", "Beban Penyusutan"),
    R_LPHU0505000000("LPHU0505000000", "Beban Jasa Pihak Ketiga"),
    R_LPHU0506000000("LPHU0506000000", "Beban Pendidikan dan Pelatihan"),
    R_LPHU0507000000("LPHU0507000000", "Beban Operasional Lain"),
    R_LPHU0508000000("LPHU0508000000", "Total Beban Operasional"),
    R_LPHU0601000000("LPHU0601000000", "Bunga Keterlambatan Iuran"),
    R_LPHU0602000000("LPHU0602000000", "Laba (Rugi) Penjualan Aset Operasional"),
    R_LPHU0603000000("LPHU0603000000", "Laba (Rugi) Penjualan Aset Lain-Lain"),
    R_LPHU0604000000("LPHU0604000000", "Pendapatan Lain di Luar Investasi"),
    R_LPHU0605000000("LPHU0605000000", "Beban Lain di Luar Investasi dan Operasional"),
    R_LPHU0606000000("LPHU0606000000", "Total Pendapatan dan Beban Lain-Lain"),
    R_LPHU0700000000("LPHU0700000000", "HASIL USAHA SEBELUM PAJAK"),
    R_LPHU0800000000("LPHU0800000000", "PAJAK PENGHASILAN"),
    R_LPHU0900000000("LPHU0900000000", "HASIL USAHA SETELAH PAJAK"),

    ;

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7004PosLtlbDppkLphu eEnum : ER7004PosLtlbDppkLphu.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7004PosLtlbDppkLphu.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7004PosLtlbDppkLphu.class.getSimpleName().substring(2, 6));
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 12),
                        getObjects()
                );
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        }
    }
}