package id.go.ojk.metadata.module.lblt.reference;

import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7001PosLtlbDppkLan implements IObject<KeyValueString> {
    R_LAN0101010000("LAN0101010000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101020000("LAN0101020000", "Deposito Berjangka pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101030000("LAN0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101040000("LAN0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101050000("LAN0101050000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101060000("LAN0101060000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101070000("LAN0101070000", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101080000("LAN0101080000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101090000("LAN0101090000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101100000("LAN0101100000", "Reksa Dana", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101110000("LAN0101110000", "MTN", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101120000("LAN0101120000", "Efek Beragun Aset", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101130000("LAN0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101140000("LAN0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101150000("LAN0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101160000("LAN0101160000", "REPO", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101170000("LAN0101170000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101180000("LAN0101180000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101190000("LAN0101190000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0101200000("LAN0101200000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0102000000("LAN0102000000", "TOTAL INVESTASI", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0103010000("LAN0103010000", "Kas dan Bank", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0103020000("LAN0103020000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.DPLK)),
    R_LAN0103030000("LAN0103030000", "- Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_LAN0103030000_DPLK("LAN0103030000", "Piutang Investasi", EnumSet.of(ProgramType.DPLK)),
    R_LAN0103040000("LAN0103040000", "- Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
    R_LAN0103040000_DPLK("LAN0103040000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.DPLK)),
    R_LAN0103050000("LAN0103050000", "- Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
    R_LAN0103050000_DPLK("LAN0103050000", "Piutang Lain-Lain", EnumSet.of(ProgramType.DPLK)),
    R_LAN0103060000("LAN0103060000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
    R_LAN0103070000("LAN0103070000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL)),
    R_LAN0103080000("LAN0103080000", "Piutang Investasi", EnumSet.of(ProgramType.ALL)),
    R_LAN0103090000("LAN0103090000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
    R_LAN0103100000("LAN0103100000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_LAN0104000000("LAN0104000000", "TOTAL ASET LANCAR DI LUAR INVESTASI", EnumSet.of(ProgramType.ALL, ProgramType.DPLK)),
    R_LAN0104020000("LAN0104020000", "Tanah dan Bangunan", EnumSet.of(ProgramType.ALL)),
    R_LAN0104030000("LAN0104030000", "Kendaraan", EnumSet.of(ProgramType.ALL)),
    R_LAN0104040000("LAN0104040000", "Peralatan Komputer", EnumSet.of(ProgramType.ALL)),
    R_LAN0104050000("LAN0104050000", "Peralatan Kantor", EnumSet.of(ProgramType.ALL)),
    R_LAN0104060000("LAN0104060000", "Aset Operasional Lain", EnumSet.of(ProgramType.ALL)),
    R_LAN0105000000("LAN0105000000", "TOTAL ASET OPERASIONAL", EnumSet.of(ProgramType.ALL)),
    R_LAN0105000000_DPLK("LAN0105000000", "ASET LAIN-LAIN", EnumSet.of(ProgramType.DPLK)),
    R_LAN0106000000("LAN0106000000", "ASET LAIN-LAIN", EnumSet.of(ProgramType.ALL)),
    R_LAN0106000000_DPLK("LAN0106000000", "ASET TERSEDIA", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107000000("LAN0107000000", "ASET TERSEDIA", EnumSet.of(ProgramType.ALL)),
    R_LAN0107010100("LAN0107010100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107010200("LAN0107010200", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107010300("LAN0107010300", "Utang Investasi", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107010400("LAN0107010400", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107010500("LAN0107010500", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.DPLK)),
    R_LAN0107010600("LAN0107010600", "Utang Lain-Lain", EnumSet.of(ProgramType.DPLK)),
    R_LAN0108000000("LAN0108000000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.DPLK)),
    R_LAN0108020100("LAN0108020100", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020200("LAN0108020200", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020300("LAN0108020300", "Utang Investasi", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020400("LAN0108020400", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020500("LAN0108020500", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020600("LAN0108020600", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_LAN0108020700("LAN0108020700", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
    R_LAN0109000000("LAN0109000000", "Total Liabilitas di luar Liabilitas Manfaat Pensiun", EnumSet.of(ProgramType.ALL)),
    R_LAN0109000000_DPLK("LAN0109000000", "TOTAL LIABILITAS", EnumSet.of(ProgramType.DPLK)),
    R_LAN0110000000("LAN0110000000", "TOTAL LIABILITAS", EnumSet.of(ProgramType.ALL)),
    R_LAN0110000000_DPLK("LAN0110000000", "ASET NETO", EnumSet.of(ProgramType.DPLK)),
    R_LAN0111000000("LAN0111000000", "ASET NETO", EnumSet.of(ProgramType.ALL));



    public final String key;
    public final String value;
    public final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        if (!jenisProgram.equals(ProgramType.PPMPPPIPK)) return getNonGabunganObjects(jenisProgram);

        ER7001PosLtlbDppkLan[] eVals = ER7001PosLtlbDppkLan.values();

        List<KeyValueString> res = Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPMPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7001PosLtlbDppkLan::getObject).collect(Collectors.toList());

        res.addAll(Arrays.stream(eVals)
                .filter(eEnum -> eEnum.jenisProgram.contains(ProgramType.PPIPK) || eEnum.jenisProgram.contains(ProgramType.ALL))
                .map(ER7001PosLtlbDppkLan::getObject)
                .collect(Collectors.toList()));

        return res;
    }

    private static List<KeyValueString> getNonGabunganObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7001PosLtlbDppkLan eEnum : ER7001PosLtlbDppkLan.values()) {
            if (!jenisProgram.equals(ProgramType.DPLK) && (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(ProgramType.ALL))) {
                res.add(eEnum.getObject());
            } else if (jenisProgram.equals(ProgramType.DPLK) && eEnum.jenisProgram.contains(ProgramType.DPLK)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7001PosLtlbDppkLan.class.getSimpleName().substring(6);
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

    public static ReferenceConfig getRefConfig(ProgramType programType) {
        switch (programType) {
            case PPMPK:
                return Configs.REF_CONFIG_PPMPK;
            case PPMPM:
                return Configs.REF_CONFIG_PPMPM;
            case PPIPK:
                return Configs.REF_CONFIG_PPIPK;
            case PPIPM:
                return Configs.REF_CONFIG_PPIPM;
            case DPLK:
                return Configs.REF_CONFIG_DPLK;
            case PPMPPPIPK:
                return Configs.REF_CONFIG_PPMPKPPIPK;
            default:
                throw new IllegalStateException();
        }
    }

    enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            private final ProgramType programType = ProgramType.PPMPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13),getObjects(programType));
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3),getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPIPK {
            private final ProgramType programType = ProgramType.PPMPK;
            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 17), getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 17), getObjects(programType));
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects(programType));
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
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPMPKPPIPK {
            private final ProgramType programType = ProgramType.PPMPPPIPK;

            @Override
            public String savePos() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 18),getObjects(programType));
            }

            @Override
            public String savePosForm() {
                return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 18), getObjects(programType));
            }

            @Override
            public String requiredPos() {
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },


    }
}