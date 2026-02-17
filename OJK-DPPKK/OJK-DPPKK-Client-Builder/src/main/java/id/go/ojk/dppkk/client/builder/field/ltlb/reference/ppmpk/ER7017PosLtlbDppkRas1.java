package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7017PosLtlbDppkRas1 implements IObject<KeyValueString> {

    R_RAS10101000000("RAS10101000000", "A. Total Pendapatan Investasi – Beban Investasi"),
    R_RAS10102000000("RAS10102000000", "B. Rata-rata investasi"),
    R_RAS10103000000("RAS10103000000", "C. Rasio (A:B)"),
    R_RAS10201000000("RAS10201000000", "A. Total Pendapatan Investasi+Pendapatan di luar investasi)-(Beban investasi+Beban Operasional+Beban di luar Investasi dan operasional)"),
    R_RAS10202000000("RAS10202000000", "B.  Rata-rata aset tersedia"),
    R_RAS10203000000("RAS10203000000", "C. Rasio (A:B)"),
    R_RAS10301000000("RAS10301000000", "A. Beban Operasional"),
    R_RAS10302000000("RAS10302000000", "B. Pendapatan Investasi + Pendapatan di luar Investasi"),
    R_RAS10303000000("RAS10303000000", "C. Rasio (A:B)"),
    R_RAS10401000000("RAS10401000000", "A. Beban Operasional"),
    R_RAS10402000000("RAS10402000000", "B. Total Aset Tersedia"),
    R_RAS10403000000("RAS10403000000", "C. Rasio (A:B)"),
    R_RAS10501000000("RAS10501000000", "A. Piutang Iuran (LAN) x Jumlah Bulan Berjalan"),
    R_RAS10502000000("RAS10502000000", "B. Iuran Jatuh Tempo (LPAN)"),
    R_RAS10503000000("RAS10503000000", "C. Rasio (A:B)"),
    R_RAS10601000000("RAS10601000000", "A. Total Investasi x 100%"),
    R_RAS10602000000("RAS10602000000", "B. Total Aset Neto"),
    R_RAS10603000000("RAS10603000000", "C. Rasio (A:B)"),
    R_RAS10701000000("RAS10701000000", "A. Piutang Investasi + Piutang Hasil Investasi"),
    R_RAS10702000000("RAS10702000000", "B. Total Investasi"),
    R_RAS10703000000("RAS10703000000", "C. Rasio (A:B)"),
    R_RAS10801000000("RAS10801000000", "A. (Total Investasi t1 - Total Investasi t0) x 100%"),
    R_RAS10802000000("RAS10802000000", "B. Total Investasi t0"),
    R_RAS10803000000("RAS10803000000", "C. Rasio (A:B)"),
    R_RAS10901000000("RAS10901000000", "A. (SPIn-SPIn-1) x 100%"),
    R_RAS10902000000("RAS10902000000", "B. Pendapatan Investasi"),
    R_RAS10903000000("RAS10903000000", "C. Rasio (A:B)"),
    R_RAS11001000000("RAS11001000000", "A. SPI"),
    R_RAS11002000000("RAS11002000000", "B. Aset Neto"),
    R_RAS11003000000("RAS11003000000", "C. Rasio (A:B)"),
    R_RAS11101000000("RAS11101000000", "A. Aset lancar atau investasi untuk pemenuhan likuiditas minimum"),
    R_RAS11102000000("RAS11102000000", "B. Biaya Operasional + Biaya Investasi + Manfaat Pensiun dan Manfaat Lain Jatuh Tempo setahun"),
    R_RAS11103000000("RAS11103000000", "C. Rasio (A:B)"),
    R_RAS11201000000("RAS11201000000", "A. Arus Kas Masuk dari Aktivitas Investasi, Operasional, dan Pendanaan"),
    R_RAS11202000000("RAS11202000000", "B. Arus Kas Keluar dari Aktivitas Investasi, Operasional, dan Pendanaan"),
    R_RAS11203000000("RAS11203000000", "C. Rasio (A:B)"),
    R_RAS11301000000("RAS11301000000", "A. Piutang Iuran"),
    R_RAS11302000000("RAS11302000000", "B. Aset Neto"),
    R_RAS11303000000("RAS11303000000", "C. Rasio (A:B)"),
    R_RAS11401000000("RAS11401000000", "A. (Total Piutang Iuran Pendiri t1 - total Piutang Iuran Pendiri t0) X 100%"),
    R_RAS11402000000("RAS11402000000", "B. Total Piutang Iuran Pendiri t0"),
    R_RAS11403000000("RAS11403000000", "C. Rasio (A:B)"),
    R_RAS11501000000("RAS11501000000", "A. Total Aset jangka Panjang x 100%"),
    R_RAS11502000000("RAS11502000000", "B. Total Liabilitas Jangka Panjang"),
    R_RAS11503000000("RAS11503000000", "C. Rasio (A:B)"),
    R_RAS11601000000("RAS11601000000", "A. Beban Operasional + Beban Investasi + Pembayaran Manfaat Pensiun"),
    R_RAS11602000000("RAS11602000000", "B. Total Pendapatan"),
    R_RAS11603000000("RAS11603000000", "C. Rasio (A:B)"),
    R_RAS11701000000("RAS11701000000", "A. Rasio Pendapatan Investasi  (ROI)"),
    R_RAS11702000000("RAS11702000000", "B. Tingkat Bunga Aktuaria"),
    R_RAS11703000000("RAS11703000000", "C. Rasio (A-B)"),
    R_RAS11801000000("RAS11801000000", "A. Aset Lancar"),
    R_RAS11802000000("RAS11802000000", "B. Total Aset"),
    R_RAS11803000000("RAS11803000000", "C. Rasio (A:B)"),
    R_RAS11901000000("RAS11901000000", "A. Kewajiban Lancar"),
    R_RAS11902000000("RAS11902000000", "B. Total Liabilitas"),
    R_RAS11903000000("RAS11903000000", "C. Rasio (A:B)"),
    R_RAS12010000000("RAS12010000000", "A. Beban Operasional + Beban Investasi"),
    R_RAS12020000000("RAS12020000000", "B. Pendapatan Investasi"),
    R_RAS12030000000("RAS12030000000", "C. Rasio (A:B)");

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
