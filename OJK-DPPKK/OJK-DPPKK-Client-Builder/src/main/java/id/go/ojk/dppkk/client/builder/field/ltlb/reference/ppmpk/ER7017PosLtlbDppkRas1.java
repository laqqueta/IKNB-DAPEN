package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7017PosLtlbDppkRas1 implements IObject<KeyValueString> {

    R_RAS1K0101000000("RAS1K0101000000", "A. Total Pendapatan Investasi – Beban Investasi"),
    R_RAS1K0102000000("RAS1K0102000000", "B. Rata-rata investasi"),
    R_RAS1K0103000000("RAS1K0103000000", "C. Rasio (A:B)"),
    R_RAS1K0201000000("RAS1K0201000000", "A. Total Pendapatan Investasi+Pendapatan di luar investasi)-(Beban investasi+Beban Operasional+Beban di luar Investasi dan operasional)"),
    R_RAS1K0202000000("RAS1K0202000000", "B.  Rata-rata aset tersedia"),
    R_RAS1K0203000000("RAS1K0203000000", "C. Rasio (A:B)"),
    R_RAS1K0301000000("RAS1K0301000000", "A. Beban Operasional"),
    R_RAS1K0302000000("RAS1K0302000000", "B. Pendapatan Investasi + Pendapatan di luar Investasi"),
    R_RAS1K0303000000("RAS1K0303000000", "C. Rasio (A:B)"),
    R_RAS1K0401000000("RAS1K0401000000", "A. Beban Operasional"),
    R_RAS1K0402000000("RAS1K0402000000", "B. Total Aset Tersedia"),
    R_RAS1K0403000000("RAS1K0403000000", "C. Rasio (A:B)"),
    R_RAS1K0501000000("RAS1K0501000000", "A. Piutang Iuran (LAN) x Jumlah Bulan Berjalan"),
    R_RAS1K0502000000("RAS1K0502000000", "B. Iuran Jatuh Tempo (LPAN)"),
    R_RAS1K0503000000("RAS1K0503000000", "C. Rasio (A:B)"),
    R_RAS1K0601000000("RAS1K0601000000", "A. Total Investasi x 100%"),
    R_RAS1K0602000000("RAS1K0602000000", "B. Total Aset Neto"),
    R_RAS1K0603000000("RAS1K0603000000", "C. Rasio (A:B)"),
    R_RAS1K0701000000("RAS1K0701000000", "A. Piutang Investasi + Piutang Hasil Investasi"),
    R_RAS1K0702000000("RAS1K0702000000", "B. Total Investasi"),
    R_RAS1K0703000000("RAS1K0703000000", "C. Rasio (A:B)"),
    R_RAS1K0801000000("RAS1K0801000000", "A. (Total Investasi t1 - Total Investasi t0) x 100%"),
    R_RAS1K0802000000("RAS1K0802000000", "B. Total Investasi t0"),
    R_RAS1K0803000000("RAS1K0803000000", "C. Rasio (A:B)"),
    R_RAS1K0901000000("RAS1K0901000000", "A. (SPIn-SPIn-1) x 100%"),
    R_RAS1K0902000000("RAS1K0902000000", "B. Pendapatan Investasi"),
    R_RAS1K0903000000("RAS1K0903000000", "C. Rasio (A:B)"),
    R_RAS1K1001000000("RAS1K1001000000", "A. SPI"),
    R_RAS1K1002000000("RAS1K1002000000", "B. Aset Neto"),
    R_RAS1K1003000000("RAS1K1003000000", "C. Rasio (A:B)"),
    R_RAS1K1101000000("RAS1K1101000000", "A. Aset lancar atau investasi untuk pemenuhan likuiditas minimum"),
    R_RAS1K1102000000("RAS1K1102000000", "B. Biaya Operasional + Biaya Investasi + Manfaat Pensiun dan Manfaat Lain Jatuh Tempo setahun"),
    R_RAS1K1103000000("RAS1K1103000000", "C. Rasio (A:B)"),
    R_RAS1K1201000000("RAS1K1201000000", "A. Arus Kas Masuk dari Aktivitas Investasi, Operasional, dan Pendanaan"),
    R_RAS1K1202000000("RAS1K1202000000", "B. Arus Kas Keluar dari Aktivitas Investasi, Operasional, dan Pendanaan"),
    R_RAS1K1203000000("RAS1K1203000000", "C. Rasio (A:B)"),
    R_RAS1K1301000000("RAS1K1301000000", "A. Piutang Iuran"),
    R_RAS1K1302000000("RAS1K1302000000", "B. Aset Neto"),
    R_RAS1K1303000000("RAS1K1303000000", "C. Rasio (A:B)"),
    R_RAS1K1401000000("RAS1K1401000000", "A. (Total Piutang Iuran Pendiri t1 - total Piutang Iuran Pendiri t0) X 100%"),
    R_RAS1K1402000000("RAS1K1402000000", "B. Total Piutang Iuran Pendiri t0"),
    R_RAS1K1403000000("RAS1K1403000000", "C. Rasio (A:B)"),
    R_RAS1K1501000000("RAS1K1501000000", "A. Total Aset jangka Panjang x 100%"),
    R_RAS1K1502000000("RAS1K1502000000", "B. Total Liabilitas Jangka Panjang"),
    R_RAS1K1503000000("RAS1K1503000000", "C. Rasio (A:B)"),
    R_RAS1K1601000000("RAS1K1601000000", "A. Beban Operasional + Beban Investasi + Pembayaran Manfaat Pensiun"),
    R_RAS1K1602000000("RAS1K1602000000", "B. Total Pendapatan"),
    R_RAS1K1603000000("RAS1K1603000000", "C. Rasio (A:B)"),
    R_RAS1K1701000000("RAS1K1701000000", "A. Rasio Pendapatan Investasi  (ROI)"),
    R_RAS1K1702000000("RAS1K1702000000", "B. Tingkat Bunga Aktuaria"),
    R_RAS1K1703000000("RAS1K1703000000", "C. Rasio (A-B)"),
    R_RAS1K1801000000("RAS1K1801000000", "A. Aset Lancar"),
    R_RAS1K1802000000("RAS1K1802000000", "B. Total Aset"),
    R_RAS1K1803000000("RAS1K1803000000", "C. Rasio (A:B)"),
    R_RAS1K1901000000("RAS1K1901000000", "A. Kewajiban Lancar"),
    R_RAS1K1902000000("RAS1K1902000000", "B. Total Liabilitas"),
    R_RAS1K1903000000("RAS1K1903000000", "C. Rasio (A:B)"),
    R_RAS1K2010000000("RAS1K2010000000", "A. Beban Operasional + Beban Investasi"),
    R_RAS1K2020000000("RAS1K2020000000", "B. Pendapatan Investasi"),
    R_RAS1K2030000000("RAS1K2030000000", "C. Rasio (A:B)");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7017PosLtlbDppkRas1 eEnum : ER7017PosLtlbDppkRas1.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7017PosLtlbDppkRas1.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7017PosLtlbDppkRas1.class.getSimpleName().substring(2, 6));
    }
}
