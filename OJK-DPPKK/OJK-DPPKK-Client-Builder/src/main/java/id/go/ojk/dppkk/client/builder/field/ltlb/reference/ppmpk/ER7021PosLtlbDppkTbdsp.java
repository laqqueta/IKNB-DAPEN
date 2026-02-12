package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7021PosLtlbDppkTbdsp implements IObject<KeyValueString> {

    R_TBDSP0100000000("TBDSP0100000000", "A. Saldo Awal"),
    R_TBDSP0200000000("TBDSP0200000000", "B. Penambahan Tahun Berjalan"),
    R_TBDSP0201000000("TBDSP0201000000", "1. Transaksi tidak sesuai dengan prinsip syariah yang tidak dapat dihindarkan, termasuk pendapatan bunga (riba)"),
    R_TBDSP0202010000("TBDSP0202010000", "Detail - Mitra Pemberi Kerja"),
    R_TBDSP0202030000("TBDSP0202030000", "Total dana sanksi (dana ta'zir)"),
    R_TBDSP0203000000("TBDSP0203000000", "3. Transaksi syariah yang tidak terpenuhi ketentuan dan batasannya"),
    R_TBDSP0204000000("TBDSP0204000000", "4. Dana yang tidak diketahui pemiliknya, diketahui pemiliknya tetapi tidak ditemukan, atau diketahui pemiliknya tetapi biaya pengembaliannya lebih besar dari jumlah dana tersebut"),
    R_TBDSP0205000000("TBDSP0205000000", "5. Transaksi lainnya yang tidak sesuai dengan Prinsip Syariah"),
    R_TBDSP0301000000("TBDSP0301000000", "Detail - Nama Penerima"),
    R_TBDSP0303000000("TBDSP0303000000", "Total Pengguna Tahun Berjalan"),
    R_TBDSP0400000000("TBDSP0400000000", "D. Saldo Akhir (A+B-C)");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7021PosLtlbDppkTbdsp eEnum : ER7021PosLtlbDppkTbdsp.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7021PosLtlbDppkTbdsp.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7021PosLtlbDppkTbdsp.class.getSimpleName().substring(2, 6));
    }
}
