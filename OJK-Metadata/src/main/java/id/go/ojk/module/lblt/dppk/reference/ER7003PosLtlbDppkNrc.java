package id.go.ojk.module.lblt.dppk.reference;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.util.constants.ProgramType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7003PosLtlbDppkNrc implements IObject<KeyValueString> {

    R_NRC0101010000("NRC0101010000", "Deposito on call pada Bank", EnumSet.of(ProgramType.ALL)),
    R_NRC0101020000("NRC0101020000", "Deposito Berjangka pada Bank", EnumSet.of(ProgramType.ALL)),
    R_NRC0101030000("NRC0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(ProgramType.ALL)),
    R_NRC0101040000("NRC0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101050000("NRC0101050000", "Surat Berharga Negara", EnumSet.of(ProgramType.ALL)),
    R_NRC0101060000("NRC0101060000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101070000("NRC0101070000", "Obligasi Korporasi yang tercatat di Bursa Efek di indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101080000("NRC0101080000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101090000("NRC0101090000", "Obligasi/Sukuk Daerah", EnumSet.of(ProgramType.ALL)),
    R_NRC0101100000("NRC0101100000", "Reksa Dana", EnumSet.of(ProgramType.ALL)),
    R_NRC0101110000("NRC0101110000", "MTN", EnumSet.of(ProgramType.ALL)),
    R_NRC0101120000("NRC0101120000", "Efek Beragun Aset", EnumSet.of(ProgramType.ALL)),
    R_NRC0101130000("NRC0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
    R_NRC0101140000("NRC0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(ProgramType.ALL)),
    R_NRC0101150000("NRC0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101160000("NRC0101160000", "REPO", EnumSet.of(ProgramType.ALL)),
    R_NRC0101170000("NRC0101170000", "Penyertaan langsung di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101180000("NRC0101180000", "Tanah di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101190000("NRC0101190000", "Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101200000("NRC0101200000", "Tanah dan Bangunan di Indonesia", EnumSet.of(ProgramType.ALL)),
    R_NRC0101210000("NRC0101210000", "Akumulasi Penyusutan Bangunan", EnumSet.of(ProgramType.ALL)),
    R_NRC0102000000("NRC0102000000", "TOTAL INVESTASI", EnumSet.of(ProgramType.ALL)),
    R_NRC0103000000("NRC0103000000", "SELISIH PENILAIAN INVESTASI", EnumSet.of(ProgramType.ALL)),
    R_NRC0104010000("NRC0104010000", "Kas dan Bank", EnumSet.of(ProgramType.ALL)),
    R_NRC0104020100("NRC0104020100", "- Iuran Normal Pemberi Kerja", EnumSet.of(ProgramType.ALL)),
    R_NRC0104020200("NRC0104020200", "- Iuran Normal Peserta", EnumSet.of(ProgramType.ALL)),
    R_NRC0104020300("NRC0104020300", "- Iuran Sukarela Peserta", EnumSet.of(ProgramType.ALL)),
    R_NRC0104020400("NRC0104020400", "- Iuran Tambahan", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK)),
    R_NRC0104030000("NRC0104030000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(ProgramType.ALL)),
    R_NRC0104040000("NRC0104040000", "Beban Dibayar di Muka", EnumSet.of(ProgramType.ALL)),
    R_NRC0104050000("NRC0104050000", "Piutang Investasi", EnumSet.of(ProgramType.ALL)),
    R_NRC0104060000("NRC0104060000", "Piutang Hasil Investasi", EnumSet.of(ProgramType.ALL)),
    R_NRC0104070000("NRC0104070000", "Piutang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_NRC0105000000("NRC0105000000", "TOTAL ASET LANCAR DI LUAR INVESTASI", EnumSet.of(ProgramType.ALL)),
    R_NRC0106010000("NRC0106010000", "Tanah dan Bangunan", EnumSet.of(ProgramType.ALL)),
    R_NRC0106020000("NRC0106020000", "Kendaraan", EnumSet.of(ProgramType.ALL)),
    R_NRC0106030000("NRC0106030000", "Peralatan Komputer", EnumSet.of(ProgramType.ALL)),
    R_NRC0106040000("NRC0106040000", "Peralatan Kantor", EnumSet.of(ProgramType.ALL)),
    R_NRC0106050000("NRC0106050000", "Aset Operasional Lain", EnumSet.of(ProgramType.ALL)),
    R_NRC0106060000("NRC0106060000", "Akumulasi Penyusutan", EnumSet.of(ProgramType.ALL)),
    R_NRC0107000000("NRC0107000000", "TOTAL ASET OPERASIONAL", EnumSet.of(ProgramType.ALL)),
    R_NRC0108000000("NRC0108000000", "ASET LAIN-LAIN", EnumSet.of(ProgramType.ALL)),
    R_NRC0109000000("NRC0109000000", "TOTAL ASET", EnumSet.of(ProgramType.ALL)),
    R_NRC0111000000("NRC0111000000", "NILAI KINI AKTUARIAL", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK)),
    R_NRC0112000000("NRC0112000000", "SELISIH NILAI KINI AKTUARIAL", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK)),
    R_NRC0113000000("NRC0113000000", "LIABILITAS MANFAAT PENSIUN", EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPPPIPK)),
    R_NRC0115000000("NRC0115000000", "LIABILITAS DI LUAR LIABILITAS MANFAAT PENSIUN", EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPPPIPK)),
    R_NRC0115010000("NRC0115010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(ProgramType.ALL)),
    R_NRC0115020000("NRC0115020000", "Utang Manfaat Sukarela", EnumSet.of(ProgramType.ALL)),
    R_NRC0115030000("NRC0115030000", "Utang Investasi", EnumSet.of(ProgramType.ALL)),
    R_NRC0115040000("NRC0115040000", "Pendapatan Diterima di Muka", EnumSet.of(ProgramType.ALL)),
    R_NRC0115050000("NRC0115050000", "Beban yang Masih Harus Dibayar", EnumSet.of(ProgramType.ALL)),
    R_NRC0115060000("NRC0115060000", "Utang Lain-Lain", EnumSet.of(ProgramType.ALL)),
    R_NRC0115070000("NRC0115070000", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(ProgramType.ALL)),
    R_NRC0116000000("NRC0116000000", "TOTAL LIABILITAS DI LUAR NILAI KINI AKTUARIA", EnumSet.of(ProgramType.PPMPM, ProgramType.PPMPK)),
    R_NRC0117000000("NRC0117000000", "TOTAL LIABILITAS DI LUAR LIABILITAS MANFAAT PENSIUN", EnumSet.of(ProgramType.PPIPM, ProgramType.PPIPK, ProgramType.PPMPPPIPK)),
    R_NRC0118000000("NRC0118000000", "TOTAL LIABILITAS", EnumSet.of(ProgramType.ALL))

    ;

    private final String key;
    private final String value;
    private final EnumSet<ProgramType> jenisProgram;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(ProgramType jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7003PosLtlbDppkNrc eEnum : ER7003PosLtlbDppkNrc.values()) {
            if (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(ProgramType.ALL) ) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String genFieldSave(ProgramType jenisProgram) {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12), getObjects(jenisProgram));
    }

    public static String getRequiredPos(ProgramType jenisProgram) {
        return UtilMetadata.genPipeRow(getObjects(jenisProgram));
    }

    public static String getName() {
        return ER7003PosLtlbDppkNrc.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7003PosLtlbDppkNrc.class.getSimpleName().substring(2, 6));
    }

    public static SegmentValidation genSumIfValidation(String posCode, String rangeField, String criteriaField, String formCode,
                                                       String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

}
