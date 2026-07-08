package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7103PosLtlbDppkPinvs implements IObject<KeyValueString> {
//    R_PINVS0101010000("PINVS0101010000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101020000("PINVS0101020000", "Deposito Berjangka pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101030000("PINVS0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101040000("PINVS0101040000", "Surat Berharga Syariah yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101050000("PINVS0101050000", "Surat Berharga Syariah Negara", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101060000("PINVS0101060000", "Saham Syariah yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101070000("PINVS0101070000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101080000("PINVS0101080000", "Sukuk Daerah", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101090000("PINVS0101090000", "Reksa Dana Syariah", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101100000("PINVS0101100000", "MTN Syariah", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101110000("PINVS0101110000", "Efek Beragun Aset Syariah", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101120000("PINVS0101120000", "Dana investasi real estat syariah berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101130000("PINVS0101130000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101140000("PINVS0101140000", "Kontrak opsi dan kontrak berjangka efek syariah yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101150000("PINVS0101150000", "REPO", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101160000("PINVS0101160000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101170000("PINVS0101170000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101180000("PINVS0101180000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101190000("PINVS0101190000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0101200000("PINVS0101200000", "Total Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102010000("PINVS0102010000", "Kas dan Bank", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102020000("PINVS0102020000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102030000("PINVS0102030000", "Piutang Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102040000("PINVS0102040000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102050000("PINVS0102050000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0102060000("PINVS0102060000", "Total Aset Lancar", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103010000("PINVS0103010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103020000("PINVS0103020000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103030000("PINVS0103030000", "Utang Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103040000("PINVS0103040000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103050000("PINVS0103050000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103060000("PINVS0103060000", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103070000("PINVS0103070000", "Utang Dana Ta'zir", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0103080000("PINVS0103080000", "Total Liabilitas Di Luar Kewajiban Manfaat Pensiun", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0104000000("PINVS0104000000", "Aset Neto", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0105000000("PINVS0105000000", "Hasil Usaha Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0106000000("PINVS0106000000", "Peningkatan (Penurunan) Nilai Investasi", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0107000000("PINVS0107000000", "ROI", EnumSet.of(ProgramType.ALL)),
//    R_PINVS0108000000("PINVS0108000000", "Jumlah peserta", EnumSet.of(ProgramType.ALL)),

    R_PINVS0101010000("PINVS0101010000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101020000("PINVS0101020000", "Deposito Berjangka pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101030000("PINVS0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101040000("PINVS0101040000", "Surat Berharga Syariah yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101050000("PINVS0101050000", "Surat Berharga Syariah Negara", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101060000("PINVS0101060000", "Saham Syariah yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101070000("PINVS0101070000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101080000("PINVS0101080000", "Sukuk Daerah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101090000("PINVS0101090000", "Reksa Dana Syariah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101100000("PINVS0101100000", "MTN Syariah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101110000("PINVS0101110000", "Efek Beragun Aset Syariah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101120000("PINVS0101120000", "Dana investasi real estat syariah berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101130000("PINVS0101130000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101140000("PINVS0101140000", "Kontrak opsi dan kontrak berjangka efek syariah yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101150000("PINVS0101150000", "REPO", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101160000("PINVS0101160000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101170000("PINVS0101170000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101180000("PINVS0101180000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101190000("PINVS0101190000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0101200000("PINVS0101200000", "Total Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

//    R_PINVS0102000000("PINVS0102000000", "Aset Lancar", EnumSet.of(ProgramType.DPLK)),

    R_PINVS0102010000("PINVS0102010000", "Kas dan Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0102020000("PINVS0102020000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0102030000("PINVS0102030000", "Piutang Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0102040000("PINVS0102040000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0102050000("PINVS0102050000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0102060000("PINVS0102060000", "Total Aset Lancar", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

//    R_PINVS0103000000("PINVS0103000000", "Liabilitas Di Luar Kewajiban Manfaat Pensiun", EnumSet.of(ProgramType.DPLK)),

    R_PINVS0103010000("PINVS0103010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103020000("PINVS0103020000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103030000("PINVS0103030000", "Utang Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103040000("PINVS0103040000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103050000("PINVS0103050000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103060000("PINVS0103060000", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103070000("PINVS0103070000", "Utang Dana Ta'zir", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0103080000("PINVS0103080000", "Total Liabilitas Di Luar Kewajiban Manfaat Pensiun", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_PINVS0104000000("PINVS0104000000", "Aset Neto", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0105000000("PINVS0105000000", "Hasil Usaha Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0106000000("PINVS0106000000", "Peningkatan (Penurunan) Nilai Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0107000000("PINVS0107000000", "ROI", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_PINVS0108000000("PINVS0108000000", "Jumlah peserta", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    ;

    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7103PosLtlbDppkPinvs eEnum : ER7103PosLtlbDppkPinvs.values()) {
            if (eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static List<KeyValueString> getObjects(ProgramType programType) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7103PosLtlbDppkPinvs eEnum : ER7103PosLtlbDppkPinvs.values()) {
            if (programType.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7103PosLtlbDppkPinvs.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static int getRowSize(ProgramType programType) {
        return programType.equals(ProgramType.DPLK) ? getObjects(programType).size() : getObjects().size();
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG {
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects());
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

//            @Override
//            public String savePos() {
//                return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
//            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getRowSize(ProgramType.DPLK));

        getObjects(ProgramType.DPLK).forEach(v -> {
            System.out.println(v.getKey() + "|" + v.getValue());
        });
    }
}
