package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7002PosLtlbDppkLpan implements IObject<KeyValueString> {

    R_LPAN0101010000("LPAN0101010000", "Bunga/Bagi Hasil"),
    R_LPAN0101020000("LPAN0101020000", "Dividen"),
    R_LPAN0101030000("LPAN0101030000", "Sewa"),
    R_LPAN0101040000("LPAN0101040000", "Laba (Rugi) Pelepasan Investasi"),
    R_LPAN0101050000("LPAN0101050000", "Pendapatan Investasi Lain"),
    R_LPAN0102000000("LPAN0102000000", "Total Pendapatan Investasi"),
    R_LPAN0103000000("LPAN0103000000", "Peningkatan (Penurunan) Nilai Investasi"),
    R_LPAN0104010000("LPAN0104010000", "- Iuran Normal Pemberi Kerja"),
    R_LPAN0104020000("LPAN0104020000", "- Iuran Normal Peserta"),
    R_LPAN0104030000("LPAN0104030000", "- Iuran Sukarela Peserta"),
    R_LPAN0104040000("LPAN0104040000", "- Iuran Tambahan"),
    R_LPAN0105000000("LPAN0105000000", "Pendapatan di Luar Investasi"),
    R_LPAN0106000000("LPAN0106000000", "Pengalihan Dana dari Dana Pensiun Lain"),
    R_LPAN0107000000("LPAN0107000000", "Jumlah Penambahan"),
    R_LPAN0201000000("LPAN0201000000", "Beban Investasi"),
    R_LPAN0202000000("LPAN0202000000", "Beban Operasional"),
    R_LPAN0203000000("LPAN0203000000", "Beban di Luar Investasi dan Operasional"),
    R_LPAN0204000000("LPAN0204000000", "Manfaat Pensiun dan Manfaat Lain"),
    R_LPAN0205000000("LPAN0205000000", "Pajak Penghasilan"),
    R_LPAN0206000000("LPAN0206000000", "Pengalihan Dana ke Dana Pensiun Lain"),
    R_LPAN0207000000("LPAN0207000000", "Pengalihan Dana ke Balai Harta Peninggalan"),
    R_LPAN0208000000("LPAN0208000000", "Jumlah Pengurangan"),
    R_LPAN0300000000("LPAN0300000000", "KENAIKAN (PENURUNAN) ASET NETO"),
    R_LPAN0400000000("LPAN0400000000", "ASET NETO AWAL PERIODE"),
    R_LPAN0500000000("LPAN0500000000", "ASET NETO AKHIR PERIODE");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7002PosLtlbDppkLpan eEnum : ER7002PosLtlbDppkLpan.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7002PosLtlbDppkLpan.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7002PosLtlbDppkLpan.class.getSimpleName().substring(2, 6));
    }
}
