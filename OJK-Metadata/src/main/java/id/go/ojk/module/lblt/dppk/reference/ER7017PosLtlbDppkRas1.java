package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7017PosLtlbDppkRas1 implements IObject<KeyValueString> {

    R_RAS10100000000("RAS10100000000", "Rasio Pendapatan investasi (ROI)", EnumSet.of(ProgramType.ALL)),
    R_RAS10101000000("RAS10101000000", "A. Total Pendapatan Investasi – Beban Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10102000000("RAS10102000000", "B. Rata-rata investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10103000000("RAS10103000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS10200000000("RAS10200000000", "Rasio Pendapatan investasi terhadap Aset (ROA)", EnumSet.of(ProgramType.ALL)),
    R_RAS10201000000("RAS10201000000", "A. Total Pendapatan Investasi+Pendapatan di luar investasi)-(Beban investasi+Beban Operasional+Beban di luar Investasi dan operasional)", EnumSet.of(ProgramType.ALL)),
    R_RAS10202000000("RAS10202000000", "B. Rata-rata aset tersedia", EnumSet.of(ProgramType.ALL)),
    R_RAS10203000000("RAS10203000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS10300000000("RAS10300000000", "Rasio Beban Operasional (BOPO)", EnumSet.of(ProgramType.ALL)),
    R_RAS10301000000("RAS10301000000", "A. Beban Operasional", EnumSet.of(ProgramType.ALL)),
    R_RAS10302000000("RAS10302000000", "B. Pendapatan Investasi + Pendapatan di luar Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10303000000("RAS10303000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS10400000000("RAS10400000000", "Rasio Kecukupan Dana (RKD)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10401000000("RAS10401000000", "A. Kekayaan Untuk Pendanaan (KUP)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10402000000("RAS10402000000", "B. Nilai Kini Aktuarial (NKA)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10403000000("RAS10403000000", "C. Rasio (A:B)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10500000000("RAS10500000000", "Rasio beban operasional terhadap aset tersedia",
            EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_RAS10501000000("RAS10501000000", "A. Beban Operasional",
            EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_RAS10502000000("RAS10502000000", "B. Total Aset Tersedia",
            EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_RAS10503000000("RAS10503000000", "C. Rasio (A:B)",
            EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_RAS10600000000("RAS10600000000", "Rasio Kekayaan Untuk Pendanaan terhadap Liabilitas Solvabilitas (Rasio Solvabilitas)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10601000000("RAS10601000000", "A. Kekayaan Untuk Pendanaan (KUP)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10602000000("RAS10602000000", "B. Liabilitas Solvabilitas",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10603000000("RAS10603000000", "C. Rasio (A:B)",
            EnumSet.of(ProgramType.PPMPM)),
    R_RAS10700000000("RAS10700000000", "Rasio Umur Piutang Iuran (RUPI)", EnumSet.of(ProgramType.ALL)),
    R_RAS10701000000("RAS10701000000", "A. Piutang Iuran (LAN) x Jumlah Bulan Berjalan", EnumSet.of(ProgramType.ALL)),
    R_RAS10702000000("RAS10702000000", "B. Iuran Jatuh Tempo (LPAN)", EnumSet.of(ProgramType.ALL)),
    R_RAS10703000000("RAS10703000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS10800000000("RAS10800000000", "Rasio Investasi terhadap Aset Neto (RITA)", EnumSet.of(ProgramType.ALL)),
    R_RAS10801000000("RAS10801000000", "A. Total Investasi x 100%", EnumSet.of(ProgramType.ALL)),
    R_RAS10802000000("RAS10802000000", "B. Total Aset Neto", EnumSet.of(ProgramType.ALL)),
    R_RAS10803000000("RAS10803000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS10900000000("RAS10900000000", "Piutang Investasi dan Piutang Hasil Investasi terhadap Total Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10901000000("RAS10901000000", "A. Piutang Investasi + Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10902000000("RAS10902000000", "B. Total Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS10903000000("RAS10903000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11000000000("RAS11000000000", "Rasio Pertumbuhan Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS11001000000("RAS11001000000", "A. (Total Investasi t1 - Total Investasi t0) x 100%", EnumSet.of(ProgramType.ALL)),
    R_RAS11002000000("RAS11002000000", "B. Total Investasi t0", EnumSet.of(ProgramType.ALL)),
    R_RAS11003000000("RAS11003000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11100000000("RAS11100000000", "Perubahan harga pasar atas total pendapatan", EnumSet.of(ProgramType.ALL)),
    R_RAS11101000000("RAS11101000000", "A. (SPIn-SPIn-1) x 100%", EnumSet.of(ProgramType.ALL)),
    R_RAS11102000000("RAS11102000000", "B. Pendapatan Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS11103000000("RAS11103000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11200000000("RAS11200000000", "SPI dibandingkan dengan aset neto", EnumSet.of(ProgramType.ALL)),
    R_RAS11201000000("RAS11201000000", "A. SPI", EnumSet.of(ProgramType.ALL)),
    R_RAS11202000000("RAS11202000000", "B. Aset Neto", EnumSet.of(ProgramType.ALL)),
    R_RAS11203000000("RAS11203000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11300000000("RAS11300000000", "Rasio Likuiditas minimum/cash ratio", EnumSet.of(ProgramType.ALL)),
    R_RAS11301000000("RAS11301000000", "A. Aset lancar atau investasi untuk pemenuhan likuiditas minimum", EnumSet.of(ProgramType.ALL)),
    R_RAS11302000000("RAS11302000000", "B. Biaya Operasional + Biaya Investasi + Manfaat Pensiun dan Manfaat Lain Jatuh Tempo setahun", EnumSet.of(ProgramType.ALL)),
    R_RAS11303000000("RAS11303000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11400000000("RAS11400000000", "Arus Kas Masuk dibandingkan dengan Arus Kas Keluar", EnumSet.of(ProgramType.ALL)),
    R_RAS11401000000("RAS11401000000", "A. Arus Kas Masuk dari Aktivitas Investasi, Operasional, dan Pendanaan", EnumSet.of(ProgramType.ALL)),
    R_RAS11402000000("RAS11402000000", "B. Arus Kas Keluar dari Aktivitas Investasi, Operasional, dan Pendanaan", EnumSet.of(ProgramType.ALL)),
    R_RAS11403000000("RAS11403000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11500000000("RAS11500000000", "Rasio Piutang Iuran terhadap Aset Neto", EnumSet.of(ProgramType.ALL)),
    R_RAS11501000000("RAS11501000000", "A. Piutang Iuran", EnumSet.of(ProgramType.ALL)),
    R_RAS11502000000("RAS11502000000", "B. Aset Neto", EnumSet.of(ProgramType.ALL)),
    R_RAS11503000000("RAS11503000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11600000000("RAS11600000000", "Rasio Pertumbuhan Piutang Iuran Pendiri (Piutang Iuran Pemberi Kerja + Iuran Tambahan)", EnumSet.of(ProgramType.ALL)),
    R_RAS11601000000("RAS11601000000", "A. (Total Piutang Iuran Pendiri t1 - total Piutang Iuran Pendiri t0) X 100%", EnumSet.of(ProgramType.ALL)),
    R_RAS11602000000("RAS11602000000", "B. Total Piutang Iuran Pendiri t0", EnumSet.of(ProgramType.ALL)),
    R_RAS11603000000("RAS11603000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11700000000("RAS11700000000", "Rasio Total Aset Jangka Panjang terhadap Total Liabilitas Jangka Panjang", EnumSet.of(ProgramType.ALL)),
    R_RAS11701000000("RAS11701000000", "A. Total Aset jangka Panjang x 100%", EnumSet.of(ProgramType.ALL)),
    R_RAS11702000000("RAS11702000000", "B. Total Liabilitas Jangka Panjang", EnumSet.of(ProgramType.ALL)),
    R_RAS11703000000("RAS11703000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11800000000("RAS11800000000", "Rasio Pendapatan terhadap Pengeluaran", EnumSet.of(ProgramType.ALL)),
    R_RAS11801000000("RAS11801000000", "A. Beban Operasional + Beban Investasi + Pembayaran Manfaat Pensiun", EnumSet.of(ProgramType.ALL)),
    R_RAS11802000000("RAS11802000000", "B. Total Pendapatan", EnumSet.of(ProgramType.ALL)),
    R_RAS11803000000("RAS11803000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS11900000000("RAS11900000000", "Interest rate spread", EnumSet.of(ProgramType.ALL)),
    R_RAS11901000000("RAS11901000000", "A. Rasio Pendapatan Investasi (ROI)", EnumSet.of(ProgramType.ALL)),
    R_RAS11902000000("RAS11902000000", "B. Tingkat Bunga Aktuaria", EnumSet.of(ProgramType.ALL)),
    R_RAS11903000000("RAS11903000000", "C. Rasio (A-B)", EnumSet.of(ProgramType.ALL)),
    R_RAS12000000000("RAS12000000000", "Rasio Aset Lancar terhadap Total Aset", EnumSet.of(ProgramType.ALL)),
    R_RAS12010000000("RAS12010000000", "A. Aset Lancar", EnumSet.of(ProgramType.ALL)),
    R_RAS12020000000("RAS12020000000", "B. Total Aset", EnumSet.of(ProgramType.ALL)),
    R_RAS12030000000("RAS12030000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS13000000000("RAS13000000000", "Rasio Kewajiban Lancar terhadap Total Liabilitas", EnumSet.of(ProgramType.ALL)),
    R_RAS13010000000("RAS13010000000", "A. Kewajiban Lancar", EnumSet.of(ProgramType.ALL)),
    R_RAS13020000000("RAS13020000000", "B. Total Liabilitas", EnumSet.of(ProgramType.ALL)),
    R_RAS13030000000("RAS13030000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),
    R_RAS14000000000("RAS14000000000", "Rasio Beban Usaha", EnumSet.of(ProgramType.ALL)),
    R_RAS14010000000("RAS14010000000", "A. Beban Operasional + Beban Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS14020000000("RAS14020000000", "B. Pendapatan Investasi", EnumSet.of(ProgramType.ALL)),
    R_RAS14030000000("RAS14030000000", "C. Rasio (A:B)", EnumSet.of(ProgramType.ALL)),

    ;

    public final String key;
    public final String value;
    private final EnumSet<ProgramType> jenisPrograms;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7017PosLtlbDppkRas1 eEnum : ER7017PosLtlbDppkRas1.values()) {
            if (eEnum.jenisPrograms.contains(jenisProgram) || eEnum.jenisPrograms.contains(ProgramType.ALL) ) {
                res.add(eEnum.getObject());
            }
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
