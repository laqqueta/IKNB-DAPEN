package id.go.ojk.metadata.module.lblt.dppk.reference;

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
public enum ER7002PosLtlbDppkLpan implements IObject<KeyValueString> {

    R_LPAN0101010000("LPAN0101010000", "Bunga/Bagi Hasil", EnumSet.of(ProgramType.ALL)),
    R_LPAN0101020000("LPAN0101020000", "Dividen", EnumSet.of(ProgramType.ALL)),
    R_LPAN0101030000("LPAN0101030000", "Sewa", EnumSet.of(ProgramType.ALL)),
    R_LPAN0101040000("LPAN0101040000", "Laba (Rugi) Pelepasan Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPAN0101050000("LPAN0101050000", "Pendapatan Investasi Lain", EnumSet.of(ProgramType.ALL)),
    R_LPAN0102000000("LPAN0102000000", "Total Pendapatan Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPAN0103000000("LPAN0103000000", "Peningkatan (Penurunan) Nilai Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPAN0104010000("LPAN0104010000", "- Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_LPAN0104020000("LPAN0104020000", "- Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
    R_LPAN0104030000("LPAN0104030000", "- Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
    R_LPAN0104040000("LPAN0104040000", "- Iuran Tambahan", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK)),
    R_LPAN0105000000("LPAN0105000000", "Pendapatan di Luar Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPAN0106000000("LPAN0106000000", "Pengalihan Dana dari Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
    R_LPAN0107000000("LPAN0107000000", "Jumlah Penambahan", EnumSet.of(ProgramType.ALL)),
    R_LPAN0201000000("LPAN0201000000", "Beban Investasi", EnumSet.of(ProgramType.ALL)),
    R_LPAN0202000000("LPAN0202000000", "Beban Operasional", EnumSet.of(ProgramType.ALL)),
    R_LPAN0203000000("LPAN0203000000", "Beban di Luar Investasi dan Operasional", EnumSet.of(ProgramType.ALL)),
    R_LPAN0204000000("LPAN0204000000", "Manfaat Pensiun dan Manfaat Lain", EnumSet.of(ProgramType.ALL)),
    R_LPAN0205000000("LPAN0205000000", "Pajak Penghasilan", EnumSet.of(ProgramType.ALL)),
    R_LPAN0206000000("LPAN0206000000", "Pengalihan Dana ke Dana Pensiun Lain", EnumSet.of(ProgramType.ALL)),
    R_LPAN0207000000("LPAN0207000000", "Pengalihan Dana ke Balai Harta Peninggalan", EnumSet.of(ProgramType.ALL)),
    R_LPAN0208000000("LPAN0208000000", "Jumlah Pengurangan", EnumSet.of(ProgramType.ALL)),
    R_LPAN0300000000("LPAN0300000000", "KENAIKAN (PENURUNAN) ASET NETO", EnumSet.of(ProgramType.ALL)),
    R_LPAN0400000000("LPAN0400000000", "ASET NETO AWAL PERIODE", EnumSet.of(ProgramType.ALL)),
    R_LPAN0500000000("LPAN0500000000", "ASET NETO AKHIR PERIODE", EnumSet.of(ProgramType.ALL)),

    ;

    private final String key;
    private final String value;
    private final EnumSet<ProgramType> jenisProgram;

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7002PosLtlbDppkLpan eEnum : ER7002PosLtlbDppkLpan.values()) {
            if (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(ProgramType.ALL)) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7002PosLtlbDppkLpan.class.getSimpleName().substring(6);
    }

    public static int getRefNumber(int referenceNumber) {
        return referenceNumber;
    }

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public enum Configs implements ReferenceConfig {
        REF_CONFIG_PPMPK {
            @Override
            public String savePos() {
                ProgramType programType = ProgramType.PPMPK;
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 12),
                        getObjects(programType)
                );
            }

            @Override
            public String savePosForm() {
                ProgramType programType = ProgramType.PPMPK;
                return UtilMetadata.genFieldSave(
                        UtilMetadata.genPipeColumn(2, 12),
                        getObjects(programType)
                );
            }

            @Override
            public String requiredPos() {
                ProgramType programType = ProgramType.PPMPK;
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        },

        REF_CONFIG_PPMPM {
            @Override
            public String savePos() {
                ProgramType programType = ProgramType.PPMPM;
                return UtilMetadata.genFieldSave("2",
                        getObjects(programType)
                );
            }

            @Override
            public String savePosForm() {
                ProgramType programType = ProgramType.PPMPM;
                return UtilMetadata.genFieldSave("2",
                        getObjects(programType)
                );
            }

            @Override
            public String requiredPos() {
                ProgramType programType = ProgramType.PPMPM;
                return UtilMetadata.genPipeRow(getObjects(programType));
            }
        }
    }
}