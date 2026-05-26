package id.go.ojk.metadata.module.lblt.dppk.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7102PosLtlbDppkPinv implements IObject<KeyValueString> {

    R_PINV0101010000("PINV0101010000", "Deposito on call pada Bank"),
    R_PINV0101020000("PINV0101020000", "Deposito Berjangka pada Bank"),
    R_PINV0101030000("PINV0101030000", "Sertifikat Deposito pada Bank"),
    R_PINV0101040000("PINV0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
    R_PINV0101050000("PINV0101050000", "Surat Berharga Negara"),
    R_PINV0101060000("PINV0101060000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_PINV0101070000("PINV0101070000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
    R_PINV0101080000("PINV0101080000", "Sukuk Daerah"),
    R_PINV0101090000("PINV0101090000", "Reksa Dana"),
    R_PINV0101100000("PINV0101100000", "MTN"),
    R_PINV0101110000("PINV0101110000", "Efek Beragun Aset"),
    R_PINV0101120000("PINV0101120000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_PINV0101130000("PINV0101130000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_PINV0101140000("PINV0101140000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_PINV0101150000("PINV0101150000", "REPO"),
    R_PINV0101160000("PINV0101160000", "Penyertaan langsung di Indonesia"),
    R_PINV0101170000("PINV0101170000", "Tanah di Indonesia"),
    R_PINV0101180000("PINV0101180000", "Bangunan di Indonesia"),
    R_PINV0101190000("PINV0101190000", "Tanah dan Bangunan di Indonesia"),
    R_PINV0101200000("PINV0101200000", "Total Investasi"),
    R_PINV0102010000("PINV0102010000", "Kas dan Bank"),
    R_PINV0102020000("PINV0102020000", "Beban Dibayar di Muka"),
    R_PINV0102030000("PINV0102030000", "Piutang Investasi"),
    R_PINV0102040000("PINV0102040000", "Piutang Hasil Investasi"),
    R_PINV0102050000("PINV0102050000", "Piutang Lain-Lain"),
    R_PINV0102060000("PINV0102060000", "Total Aset Lancar"),
    R_PINV0103010000("PINV0103010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
    R_PINV0103020000("PINV0103020000", "Utang Manfaat Sukarela"),
    R_PINV0103030000("PINV0103030000", "Utang Investasi"),
    R_PINV0103040000("PINV0103040000", "Pendapatan Diterima di Muka"),
    R_PINV0103050000("PINV0103050000", "Beban yang Masih Harus Dibayar"),
    R_PINV0103060000("PINV0103060000", "Utang Lain-Lain"),
    R_PINV0103070000("PINV0103070000", "Total Liabilitas Di Luar Kewajiban Manfaat Pensiun"),
    R_PINV0104000000("PINV0104000000", "Aset Neto"),
    R_PINV0105000000("PINV0105000000", "Hasil Usaha Investasi"),
    R_PINV0106000000("PINV0106000000", "Peningkatan (Penurunan) Nilai Investasi"),
    R_PINV0107000000("PINV0107000000", "ROI"),
    R_PINV0108000000("PINV0108000000", "Jumlah peserta"),

    ;

    public final String key;
    public final String value;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7102PosLtlbDppkPinv eEnum : ER7102PosLtlbDppkPinv.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7102PosLtlbDppkPinv.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPIP {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("3", getObjects());
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave("3|4", getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(), new int[]{1});
            }
        }
    }
}
