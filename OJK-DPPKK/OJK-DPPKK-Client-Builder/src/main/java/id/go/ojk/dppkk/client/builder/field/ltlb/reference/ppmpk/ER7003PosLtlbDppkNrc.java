package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.ENrcValidationsConfig;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ER7003PosLtlbDppkNrc implements IObject<KeyValueString> {

    R_NRC0101010000("NRC0101010000", "Deposito on call pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101020000("NRC0101020000", "Deposito Berjangka pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101030000("NRC0101030000", "Sertifikat Deposito pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101040000("NRC0101040000", "Surat Berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101050000("NRC0101050000", "Surat Berharga Negara", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101060000("NRC0101060000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101070000("NRC0101070000", "Obligasi Korporasi yang tercatat di Bursa Efek di indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101080000("NRC0101080000", "Sukuk Korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101090000("NRC0101090000", "Obligasi/Sukuk Daerah", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101100000("NRC0101100000", "Reksa Dana", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101110000("NRC0101110000", "MTN", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101120000("NRC0101120000", "Efek Beragun Aset", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101130000("NRC0101130000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101140000("NRC0101140000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101150000("NRC0101150000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101160000("NRC0101160000", "REPO", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101170000("NRC0101170000", "Penyertaan langsung di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101180000("NRC0101180000", "Tanah di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101190000("NRC0101190000", "Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101200000("NRC0101200000", "Tanah dan Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_NRC0101210000("NRC0101210000", "Akumulasi Penyusutan Bangunan", EnumSet.of(JenisProgram.ALL)),
    R_NRC0102000000("NRC0102000000", "TOTAL INVESTASI", EnumSet.of(JenisProgram.ALL)),
    R_NRC0103000000("NRC0103000000", "SELISIH PENILAIAN INVESTASI", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104010000("NRC0104010000", "Kas dan Bank", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104020100("NRC0104020100", "- Iuran Normal Pemberi Kerja", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104020200("NRC0104020200", "- Iuran Normal Peserta", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104020300("NRC0104020300", "- Iuran Sukarela Peserta", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104020400("NRC0104020400", "- Iuran Tambahan", EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK)),
    R_NRC0104030000("NRC0104030000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104040000("NRC0104040000", "Beban Dibayar di Muka", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104050000("NRC0104050000", "Piutang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104060000("NRC0104060000", "Piutang Hasil Investasi", EnumSet.of(JenisProgram.ALL)),
    R_NRC0104070000("NRC0104070000", "Piutang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_NRC0105000000("NRC0105000000", "TOTAL ASET LANCAR DI LUAR INVESTASI", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106010000("NRC0106010000", "Tanah dan Bangunan", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106020000("NRC0106020000", "Kendaraan", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106030000("NRC0106030000", "Peralatan Komputer", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106040000("NRC0106040000", "Peralatan Kantor", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106050000("NRC0106050000", "Aset Operasional Lain", EnumSet.of(JenisProgram.ALL)),
    R_NRC0106060000("NRC0106060000", "Akumulasi Penyusutan", EnumSet.of(JenisProgram.ALL)),
    R_NRC0107000000("NRC0107000000", "TOTAL ASET OPERASIONAL", EnumSet.of(JenisProgram.ALL)),
    R_NRC0108000000("NRC0108000000", "ASET LAIN-LAIN", EnumSet.of(JenisProgram.ALL)),
    R_NRC0109000000("NRC0109000000", "TOTAL ASET", EnumSet.of(JenisProgram.ALL)),
    R_NRC0111000000("NRC0111000000", "NILAI KINI AKTUARIAL", EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK)),
    R_NRC0112000000("NRC0112000000", "SELISIH NILAI KINI AKTUARIAL", EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK)),
    R_NRC0113000000("NRC0113000000", "LIABILITAS MANFAAT PENSIUN", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPPPIPK)),
    R_NRC0115000000("NRC0115000000", "LIABILITAS DI LUAR LIABILITAS MANFAAT PENSIUN", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPPPIPK)),
    R_NRC0115010000("NRC0115010000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115020000("NRC0115020000", "Utang Manfaat Sukarela", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115030000("NRC0115030000", "Utang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115040000("NRC0115040000", "Pendapatan Diterima di Muka", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115050000("NRC0115050000", "Beban yang Masih Harus Dibayar", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115060000("NRC0115060000", "Utang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_NRC0115070000("NRC0115070000", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(JenisProgram.ALL)),
    R_NRC0116000000("NRC0116000000", "TOTAL LIABILITAS DI LUAR NILAI KINI AKTUARIA", EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK)),
    R_NRC0117000000("NRC0117000000", "TOTAL LIABILITAS DI LUAR LIABILITAS MANFAAT PENSIUN", EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPPPIPK)),
    R_NRC0118000000("NRC0118000000", "TOTAL LIABILITAS", EnumSet.of(JenisProgram.ALL))

    ;

    private final String key;
    private final String value;
    private final EnumSet<JenisProgram> jenisProgram;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public KeyValueString getObjectForm() {
      return new KeyValueString(getKeyForm(), getValue(), new String[] {});
    }

    public static List<KeyValueString> getObjectsForm() {
      List<KeyValueString> res = new ArrayList<>();
      for (ER7003PosLtlbDppkNrc eEnum : ER7003PosLtlbDppkNrc.values()) {
        res.add(eEnum.getObjectForm());
      }
      return res;
    }

    public String getKeyForm() {
      return "NRC" + key;
    }

    public static List<KeyValueString> getObjects(JenisProgram jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7003PosLtlbDppkNrc eEnum : ER7003PosLtlbDppkNrc.values()) {
            if (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(JenisProgram.ALL) ) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String genFieldSave(JenisProgram jenisProgram) {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12), getObjects(jenisProgram));
    }

    public static String genFieldSaveForm(JenisProgram jenisProgram) {
      return UtilMetadata.genFieldSave("12", getObjects(jenisProgram));
    }

    public static String getRequiredPos(JenisProgram jenisProgram) {
        return UtilMetadata.genPipeRow(getObjects(jenisProgram));
    }

    public static String getName() {
        return ER7003PosLtlbDppkNrc.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7003PosLtlbDppkNrc.class.getSimpleName().substring(2, 6));
    }

    public static List<SegmentValidation> getPpmpkSegmentValidations() {
        return Arrays.stream(ENrcValidationsConfig.values())
                .filter(ENrcValidationsConfig::isSegment)
                .map(ENrcValidationsConfig::toSegmentValidation)
                .collect(Collectors.toList());
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

    public static FieldValidation genFieldValidation1() {
        return ENrcValidationsConfig.FV_EQUALS_EXCEPT.toFieldValidation();
    }

}
