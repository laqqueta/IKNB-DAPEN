package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7003PosLtlbDppkNrc implements IObject<KeyValueString> {

    R_NRC0101010000("NRC0101010000", "Deposito on call pada Bank"),
    R_NRC0101020000("NRC0101020000", "Deposito Berjangka pada Bank"),
    R_NRC0101030000("NRC0101030000", "Sertifikat Deposito pada Bank"),
    R_NRC0101040000("NRC0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
    R_NRC0101050000("NRC0101050000", "Surat Berharga Negara"),
    R_NRC0101060000("NRC0101060000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_NRC0101070000("NRC0101070000", "Obligasi Korporasi yang tercatat di Bursa Efek di indonesia"),
    R_NRC0101080000("NRC0101080000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_NRC0101090000("NRC0101090000", "Obligasi/Sukuk Daerah"),
    R_NRC0101100000("NRC0101100000", "Reksa Dana"),
    R_NRC0101110000("NRC0101110000", "MTN"),
    R_NRC0101120000("NRC0101120000", "Efek Beragun Aset"),
    R_NRC0101130000("NRC0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_NRC0101140000("NRC0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_NRC0101150000("NRC0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_NRC0101160000("NRC0101160000", "REPO"),
    R_NRC0101170000("NRC0101170000", "Penyertaan langsung di Indonesia"),
    R_NRC0101180000("NRC0101180000", "Tanah di Indonesia"),
    R_NRC0101190000("NRC0101190000", "Bangunan di Indonesia"),
    R_NRC0101200000("NRC0101200000", "Tanah dan Bangunan di Indonesia"),
    R_NRC0101210000("NRC0101210000", "Akumulasi Penyusutan Bangunan"),
    R_NRC0102000000("NRC0102000000", "TOTAL INVESTASI"),
    R_NRC0103000000("NRC0103000000", "SELISIH PENILAIAN INVESTASI"),
    R_NRC0104010000("NRC0104010000", "Kas dan Bank"),
    R_NRC0104030000("NRC0104030000", "- Iuran Normal Pemberi Kerja"),
    R_NRC0104040000("NRC0104040000", "- Iuran Normal Peserta"),
    R_NRC0104050000("NRC0104050000", "- Iuran Sukarela Peserta"),
    R_NRC0104060000("NRC0104060000", "- Iuran Tambahan"),
    R_NRC0104070000("NRC0104070000", "Piutang Bunga Keterlambatan Iuran"),
    R_NRC0104080000("NRC0104080000", "Beban Dibayar di Muka"),
    R_NRC0104090000("NRC0104090000", "Piutang Investasi"),
    R_NRC0104100000("NRC0104100000", "Piutang Hasil Investasi"),
    R_NRC0104110000("NRC0104110000", "Piutang Lain-Lain"),
    R_NRC0106000000("NRC0106000000", "TOTAL ASET LANCAR DI LUAR INVESTASI"),
    R_NRC0107010000("NRC0107010000", "Tanah dan Bangunan"),
    R_NRC0107020000("NRC0107020000", "Kendaraan"),
    R_NRC0107030000("NRC0107030000", "Peralatan Komputer"),
    R_NRC0107040000("NRC0107040000", "Peralatan Kantor"),
    R_NRC0107050000("NRC0107050000", "Aset Operasional Lain"),
    R_NRC0107060000("NRC0107060000", "Akumulasi Penyusutan"),
    R_NRC0108000000("NRC0108000000", "TOTAL ASET OPERASIONAL"),
    R_NRC0109000000("NRC0109000000", "ASET LAIN-LAIN"),
    R_NRC0110000000("NRC0110000000", "TOTAL ASET"),
    R_NRC0112000000("NRC0112000000", "NILAI KINI AKTUARIAL"),
    R_NRC0113000000("NRC0113000000", "SELISIH NILAI KINI AKTUARIAL"),
    R_NRC0114010000("NRC0114010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
    R_NRC0114020000("NRC0114020000", "Utang Manfaat Sukarela"),
    R_NRC0114030000("NRC0114030000", "Utang Investasi"),
    R_NRC0114040000("NRC0114040000", "Pendapatan Diterima di Muka"),
    R_NRC0114050000("NRC0114050000", "Beban yang Masih Harus Dibayar"),
    R_NRC0114060000("NRC0114060000", "Utang Lain-Lain"),
    R_NRC0114070000("NRC0114070000", "Utang Dana Ta'zir (bagi syariah)"),
    R_NRC0115000000("NRC0115000000", "TOTAL LIABILITAS DI LUAR NILAI KINI AKTUARIAL"),
    R_NRC0116000000("NRC0116000000", "TOTAL LIABILITAS");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7003PosLtlbDppkNrc eEnum : ER7003PosLtlbDppkNrc.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7003PosLtlbDppkNrc.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7003PosLtlbDppkNrc.class.getSimpleName().substring(2, 6));
    }
}
