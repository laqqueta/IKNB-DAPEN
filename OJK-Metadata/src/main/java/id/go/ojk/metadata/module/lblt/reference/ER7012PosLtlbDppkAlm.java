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
public enum ER7012PosLtlbDppkAlm implements IObject<KeyValueString> {

//    R_ALM0101000000("ALM0101000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ALM0102000000("ALM0102000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ALM0103000000("ALM0103000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL)),
//    R_ALM0104000000("ALM0104000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0105000000("ALM0105000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL)),
//    R_ALM0106000000("ALM0106000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0107000000("ALM0107000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0108000000("ALM0108000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0109000000("ALM0109000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL)),
//    R_ALM0110000000("ALM0110000000", "Reksa Dana", EnumSet.of(ProgramType.ALL)),
//    R_ALM0111000000("ALM0111000000", "MTN", EnumSet.of(ProgramType.ALL)),
//    R_ALM0112000000("ALM0112000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL)),
//    R_ALM0113000000("ALM0113000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_ALM0114000000("ALM0114000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
//    R_ALM0115000000("ALM0115000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0116000000("ALM0116000000", "REPO", EnumSet.of(ProgramType.ALL)),
//    R_ALM0117000000("ALM0117000000", "Penyertaan Langsung di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0118000000("ALM0118000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0119000000("ALM0119000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0120000000("ALM0120000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
//    R_ALM0121000000("ALM0121000000", "Total Investasi", EnumSet.of(ProgramType.ALL)),
//    R_ALM0201000000("ALM0201000000", "Kas dan Bank", EnumSet.of(ProgramType.ALL)),
//    R_ALM0202000000("ALM0202000000", "Piutang Iuran", EnumSet.of(ProgramType.ALL)),
//    R_ALM0203000000("ALM0203000000", "Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
//    R_ALM0204000000("ALM0204000000", "Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
//    R_ALM0205000000("ALM0205000000", "Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
//    R_ALM0206000000("ALM0206000000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
//    R_ALM0207000000("ALM0207000000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL)),
//    R_ALM0208000000("ALM0208000000", "Piutang Investasi", EnumSet.of(ProgramType.ALL)),
//    R_ALM0209000000("ALM0209000000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
//    R_ALM0210000000("ALM0210000000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_ALM0211000000("ALM0211000000", "Total Aset Lancar di Luar Investasi", EnumSet.of(ProgramType.ALL)),
//    R_ALM0301000000("ALM0301000000", "Tanah dan Bangunan", EnumSet.of(ProgramType.ALL)),
//    R_ALM0302000000("ALM0302000000", "Kendaraan", EnumSet.of(ProgramType.ALL)),
//    R_ALM0303000000("ALM0303000000", "Peralatan Komputer", EnumSet.of(ProgramType.ALL)),
//    R_ALM0304000000("ALM0304000000", "Peralatan Kantor", EnumSet.of(ProgramType.ALL)),
//    R_ALM0305000000("ALM0305000000", "Aset Operasional Lain", EnumSet.of(ProgramType.ALL)),
//    R_ALM0306000000("ALM0306000000", "Total Aset Operasional", EnumSet.of(ProgramType.ALL)),
//    R_ALM0400000000("ALM0400000000", "D. Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_ALM0500000000("ALM0500000000", "E. Total Aset (A+B+C+D)", EnumSet.of(ProgramType.ALL)),
//    R_ALM0600000000("ALM0600000000", "F. Nilai Kini Aktuarial", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
//    R_ALM0700000000("ALM0700000000", "F. Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK)),
//    R_ALM0901000000("ALM0901000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL)),
//    R_ALM0902000000("ALM0902000000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL)),
//    R_ALM0903000000("ALM0903000000", "Utang Investasi", EnumSet.of(ProgramType.ALL)),
//    R_ALM0904000000("ALM0904000000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL)),
//    R_ALM0905000000("ALM0905000000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL)),
//    R_ALM0906000000("ALM0906000000", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_ALM0907000000("ALM0907000000", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
//    R_ALM0908000000("ALM0908000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.ALL)),
//    R_ALM1000000000("ALM1000000000", "H. Total Liabilitas (F+G)", EnumSet.of(ProgramType.ALL)),
//    R_ALM1100000000("ALM1100000000", "I. Selisih Total Aset dan Total Liabilitas (E-H)", EnumSet.of(ProgramType.ALL)),
//    R_ALM1200000000("ALM1200000000", "J. Persentase (%) Rasio Kecukupan Dana", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),

    R_ALM0101000000("ALM0101000000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0102000000("ALM0102000000", "Deposito berjangka pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0103000000("ALM0103000000", "Sertifikat deposito pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0104000000("ALM0104000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0105000000("ALM0105000000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0106000000("ALM0106000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0107000000("ALM0107000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0108000000("ALM0108000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0109000000("ALM0109000000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0110000000("ALM0110000000", "Reksa Dana", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0111000000("ALM0111000000", "MTN", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0112000000("ALM0112000000", "Efek beragun aset", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0113000000("ALM0113000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0114000000("ALM0114000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0115000000("ALM0115000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0116000000("ALM0116000000", "REPO", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0117000000("ALM0117000000", "Penyertaan Langsung di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0118000000("ALM0118000000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0119000000("ALM0119000000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0120000000("ALM0120000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_ALM0121000000("ALM0121000000", "Total Investasi", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),

    R_ALM0201000000("ALM0201000000", "Kas dan Bank", EnumSet.of(ProgramType.ALL)),
    R_ALM0201000000_DPLK("ALM0201000000", "Kas & Bank", EnumSet.of(ProgramType.DPLK)),

    R_ALM0202000000("ALM0202000000", "Piutang Iuran", EnumSet.of(ProgramType.ALL)),
    R_ALM0202000000_DPLK("ALM0202000000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.DPLK)),

    R_ALM0203000000("ALM0203000000", "Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_ALM0203000000_DPLK("ALM0203000000", "Piutang Investasi", EnumSet.of(ProgramType.DPLK)),

    R_ALM0204000000("ALM0204000000", "Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
    R_ALM0204000000_DPLK("ALM0204000000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.DPLK)),

    R_ALM0205000000("ALM0205000000", "Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
    R_ALM0205000000_DPLK("ALM0205000000", "Piutang Lain-Lain", EnumSet.of(ProgramType.DPLK)),

    R_ALM0206000000("ALM0206000000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
    R_ALM0206000000_DPLK("ALM0206000000", "Total Aset Lancar di Luar Investasi", EnumSet.of(ProgramType.DPLK)),

    R_ALM0207000000("ALM0207000000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL)),
    R_ALM0208000000("ALM0208000000", "Piutang Investasi", EnumSet.of(ProgramType.ALL)),
    R_ALM0209000000("ALM0209000000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
    R_ALM0210000000("ALM0210000000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_ALM0211000000("ALM0211000000", "Total Aset Lancar di Luar Investasi", EnumSet.of(ProgramType.ALL)),

    R_ALM0300000000("ALM0300000000", "C. Total Aset (A+B)", EnumSet.of(ProgramType.DPLK)),

    R_ALM0301000000("ALM0301000000", "Tanah dan Bangunan", EnumSet.of(ProgramType.ALL)),
    R_ALM0302000000("ALM0302000000", "Kendaraan", EnumSet.of(ProgramType.ALL)),
    R_ALM0303000000("ALM0303000000", "Peralatan Komputer", EnumSet.of(ProgramType.ALL)),
    R_ALM0304000000("ALM0304000000", "Peralatan Kantor", EnumSet.of(ProgramType.ALL)),
    R_ALM0305000000("ALM0305000000", "Aset Operasional Lain", EnumSet.of(ProgramType.ALL)),
    R_ALM0306000000("ALM0306000000", "Total Aset Operasional", EnumSet.of(ProgramType.ALL)),

    R_ALM0400000000("ALM0400000000", "D. Aset Lain-Lain", EnumSet.of(ProgramType.ALL)),
//    R_ALM0400000000_DPLK("ALM0400000000", "D. Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.DPLK)),

    R_ALM0401000000("ALM0401000000", "Akumulasi Iuran", EnumSet.of(ProgramType.DPLK)),
    R_ALM0402000000("ALM0402000000", "Hasil Usaha", EnumSet.of(ProgramType.DPLK)),
    R_ALM0403000000("ALM0403000000", "Pengalihan Dana dari Dana Pensiun Lain", EnumSet.of(ProgramType.DPLK)),
    R_ALM0404000000("ALM0404000000", "Total Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.DPLK)),

    R_ALM0500000000("ALM0500000000", "E. Total Aset (A+B+C+D)", EnumSet.of(ProgramType.ALL)),

    R_ALM0501000000("ALM0501000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.DPLK)),
    R_ALM0502000000("ALM0502000000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.DPLK)),
    R_ALM0503000000("ALM0503000000", "Utang Investasi", EnumSet.of(ProgramType.DPLK)),
    R_ALM0504000000("ALM0504000000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.DPLK)),
    R_ALM0505000000("ALM0505000000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.DPLK)),
    R_ALM0506000000("ALM0506000000", "Utang Lain-Lain", EnumSet.of(ProgramType.DPLK)),
    R_ALM0507000000("ALM0507000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.DPLK)),

    R_ALM0600000000("ALM0600000000", "F. Nilai Kini Aktuarial", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),
    R_ALM0600000000_DPLK("ALM0600000000", "F. Total Liabilitas (D+E)", EnumSet.of(ProgramType.DPLK)),

    R_ALM0700000000("ALM0700000000", "F. Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK)),
    R_ALM0700000000_DPLK("ALM0700000000", "G. Selisih Total Aset dan Total Liabilitas (C-F)", EnumSet.of(ProgramType.DPLK)),

    R_ALM0800000000("ALM0800000000", "G. Persentase (%) Rasio Kecukupan Dana", EnumSet.of(ProgramType.DPLK)),

    R_ALM0901000000("ALM0901000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL)),
    R_ALM0902000000("ALM0902000000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL)),
    R_ALM0903000000("ALM0903000000", "Utang Investasi", EnumSet.of(ProgramType.ALL)),
    R_ALM0904000000("ALM0904000000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL)),
    R_ALM0905000000("ALM0905000000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL)),
    R_ALM0906000000("ALM0906000000", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_ALM0907000000("ALM0907000000", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
    R_ALM0908000000("ALM0908000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.ALL)),

    R_ALM1000000000("ALM1000000000", "H. Total Liabilitas (F+G)", EnumSet.of(ProgramType.ALL)),
    R_ALM1100000000("ALM1100000000", "I. Selisih Total Aset dan Total Liabilitas (E-H)", EnumSet.of(ProgramType.ALL)),
    R_ALM1200000000("ALM1200000000", "J. Persentase (%) Rasio Kecukupan Dana", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK, ProgramType.PPMPPPIPK)),

    ;

    public final String key;
    public final String value;
    private final EnumSet<ProgramType> jenisPrograms;

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7012PosLtlbDppkAlm eEnum : ER7012PosLtlbDppkAlm.values()) {
            if (!jenisProgram.equals(ProgramType.DPLK) && (eEnum.jenisPrograms.contains(jenisProgram) || eEnum.jenisPrograms.contains(ProgramType.ALL))) {
                res.add(eEnum.getObject());
            } else if (jenisProgram.equals(ProgramType.DPLK) && eEnum.jenisPrograms.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7012PosLtlbDppkAlm.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static int getRowSize(ProgramType programType) {
        return getObjects(programType).size();
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            private final ProgramType programType = ProgramType.PPMPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPMPM {
            private final ProgramType programType = ProgramType.PPMPM;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16),getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPIPK {
            private final ProgramType programType = ProgramType.PPIPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPIPM {
            private final ProgramType programType = ProgramType.PPIPM;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_DPLK {
            private final ProgramType programType = ProgramType.DPLK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },
    }

    public static void main(String[] args) {
        System.out.println(getRowSize(ProgramType.DPLK));

        getObjects(ProgramType.DPLK).forEach(v -> {
            System.out.println(v.getKey() + "|" + v.getValue());
        });
    }
}