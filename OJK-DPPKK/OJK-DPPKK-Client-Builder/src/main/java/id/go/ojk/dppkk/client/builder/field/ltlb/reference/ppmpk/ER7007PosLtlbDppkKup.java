package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7007PosLtlbDppkKup implements IObject<KeyValueString> {

    R_KUP0100000000("KUP0100000000", "Nilai Aset Neto"),
    R_KUP0201010000("KUP0201010000", "Detail - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang"),
    R_KUP0201020000("KUP0201020000", "Total - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang"),
    R_KUP0202010000("KUP0202010000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - a. Iuran Peserta"),
    R_KUP0202020000("KUP0202020000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - b. Iuran Pemberi Kerja"),
    R_KUP0202030000("KUP0202030000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - c. Iuran Tambahan"),
    R_KUP0202040000("KUP0202040000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - Total"),
    R_KUP0203010000("KUP0203010000", "Piutang Lain-Lain - Detail"),
    R_KUP0203020000("KUP0203020000", "Piutang Lain-Lain - Total"),
    R_KUP0204010000("KUP0204010000", "Aset Lain-Lain -Detail"),
    R_KUP0204020000("KUP0204020000", "Aset Lain-Lain - Total"),
    R_KUP0205010000("KUP0205010000", "Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun - Detail"),
    R_KUP0205040000("KUP0205040000", "Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun - Total"),
    R_KUP0205020000("KUP0205020000", "Total Pengurang"),
    R_KUP0205030000("KUP0205030000", "Nilai Kekayaan Untuk Pendanaan"),
    R_KUP0206000000("KUP0206000000", "Liabilitas Solvabilitas"),
    R_KUP0207000000("KUP0207000000", "Nilai Kini Aktuaria"),
    R_KUP0208000000("KUP0208000000", "Tingkat bunga aktuaria (%)"),
    R_KUP0209000000("KUP0209000000", "Proyeksi Tingkat Pendanaan"),
    R_KUP0210000000("KUP0210000000", "Metode Pendanaan");


    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7007PosLtlbDppkKup eEnum : ER7007PosLtlbDppkKup.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7007PosLtlbDppkKup.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7007PosLtlbDppkKup.class.getSimpleName().substring(2, 6));
    }
}
