package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7012PosLtlbDppkAlmppmp implements IObject<KeyValueString> {

    R_ALMPPMP0101000000("ALMPPMP0101000000", "Deposito on call pada Bank"),
    R_ALMPPMP0102000000("ALMPPMP0102000000", "Deposito berjangka pada Bank"),
    R_ALMPPMP0103000000("ALMPPMP0103000000", "Sertifikat deposito pada Bank"),
    R_ALMPPMP0104000000("ALMPPMP0104000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ALMPPMP0105000000("ALMPPMP0105000000", "Surat Berharga Negara"),
    R_ALMPPMP0106000000("ALMPPMP0106000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ALMPPMP0107000000("ALMPPMP0107000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ALMPPMP0108000000("ALMPPMP0108000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
    R_ALMPPMP0109000000("ALMPPMP0109000000", "Obligasi/Sukuk Daerah"),
    R_ALMPPMP0110000000("ALMPPMP0110000000", "Reksa Dana"),
    R_ALMPPMP0111000000("ALMPPMP0111000000", "MTN"),
    R_ALMPPMP0112000000("ALMPPMP0112000000", "Efek beragun aset"),
    R_ALMPPMP0113000000("ALMPPMP0113000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ALMPPMP0114000000("ALMPPMP0114000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_ALMPPMP0115000000("ALMPPMP0115000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ALMPPMP0116000000("ALMPPMP0116000000", "REPO"),
    R_ALMPPMP0117000000("ALMPPMP0117000000", "Penyertaan Langsung di Indonesia"),
    R_ALMPPMP0118000000("ALMPPMP0118000000", "Tanah di Indonesia"),
    R_ALMPPMP0119000000("ALMPPMP0119000000", "Bangunan di Indonesia"),
    R_ALMPPMP0120000000("ALMPPMP0120000000", "Tanah dan Bangunan di Indonesia"),
    R_ALMPPMP0121000000("ALMPPMP0121000000", "Total Investasi"),
    R_ALMPPMP0201000000("ALMPPMP0201000000", "Kas & Bank"),
    R_ALMPPMP0202000000("ALMPPMP0202000000", "Piutang Iuran"),
    R_ALMPPMP0203000000("ALMPPMP0203000000", "Iuran Normal Pemberi Kerja"),
    R_ALMPPMP0204000000("ALMPPMP0204000000", "Iuran Normal Peserta"),
    R_ALMPPMP0205000000("ALMPPMP0205000000", "Iuran Sukarela Peserta"),
    R_ALMPPMP0206000000("ALMPPMP0206000000", "Piutang Bunga Keterlambatan Iuran"),
    R_ALMPPMP0207000000("ALMPPMP0207000000", "Beban Dibayar di Muka"),
    R_ALMPPMP0208000000("ALMPPMP0208000000", "Piutang Investasi"),
    R_ALMPPMP0209000000("ALMPPMP0209000000", "Piutang Hasil Investasi"),
    R_ALMPPMP0210000000("ALMPPMP0210000000", "Piutang Lain-Lain"),
    R_ALMPPMP0211000000("ALMPPMP0211000000", "Total Aset Lancar di Luar Investasi"),
    R_ALMPPMP0301000000("ALMPPMP0301000000", "Tanah dan Bangunan"),
    R_ALMPPMP0302000000("ALMPPMP0302000000", "Kendaraan"),
    R_ALMPPMP0303000000("ALMPPMP0303000000", "Peralatan Komputer"),
    R_ALMPPMP0304000000("ALMPPMP0304000000", "Peralatan Kantor"),
    R_ALMPPMP0305000000("ALMPPMP0305000000", "Aset Operasional Lain"),
    R_ALMPPMP0306000000("ALMPPMP0306000000", "Total Aset Operasional"),
    R_ALMPPMP0400000000("ALMPPMP0400000000", "D. Aset  Lain-Lain"),
    R_ALMPPMP0500000000("ALMPPMP0500000000", "E. Total Aset  (A+B+C+D)"),
    R_ALMPPMP0600000000("ALMPPMP0600000000", "F. Nilai Kini Aktuarial"),
    R_ALMPPMP0701000000("ALMPPMP0701000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
    R_ALMPPMP0702000000("ALMPPMP0702000000", "Utang Manfaat Sukarela"),
    R_ALMPPMP0703000000("ALMPPMP0703000000", "Utang Investasi"),
    R_ALMPPMP0704000000("ALMPPMP0704000000", "Pendapatan Diterima di Muka"),
    R_ALMPPMP0705000000("ALMPPMP0705000000", "Beban yang Masih Harus Dibayar"),
    R_ALMPPMP0706000000("ALMPPMP0706000000", "Utang Lain-Lain"),
    R_ALMPPMP0707000000("ALMPPMP0707000000", "Utang Dana Ta'zir (bagi syariah)"),
    R_ALMPPMP0708000000("ALMPPMP0708000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun"),
    R_ALMPPMP0800000000("ALMPPMP0800000000", "H. Total Liabilitas (F+G)"),
    R_ALMPPMP0900000000("ALMPPMP0900000000", "I. Selisih Total Aset dan Total Liabilitas  (E-H)"),
    R_ALMPPMP1000000000("ALMPPMP1000000000", "J. Persentase (%) Rasio Kecukupan Dana");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7012PosLtlbDppkAlmppmp eEnum : ER7012PosLtlbDppkAlmppmp.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7012PosLtlbDppkAlmppmp.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7012PosLtlbDppkAlmppmp.class.getSimpleName().substring(2, 6));
    }
}
