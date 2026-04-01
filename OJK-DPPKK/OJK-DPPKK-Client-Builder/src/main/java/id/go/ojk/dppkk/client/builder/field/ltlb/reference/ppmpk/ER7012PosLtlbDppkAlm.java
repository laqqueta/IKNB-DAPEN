package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.EAlmValidationsConfig;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.ELpanValidationsConfig;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7012PosLtlbDppkAlm implements IObject<KeyValueString> {

    R_ALM0101000000("ALM0101000000", "Deposito on call pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_ALM0102000000("ALM0102000000", "Deposito berjangka pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_ALM0103000000("ALM0103000000", "Sertifikat deposito pada Bank", EnumSet.of(JenisProgram.ALL)),
    R_ALM0104000000("ALM0104000000", "Surat berharga yang diterbitkan oleh Bank Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0105000000("ALM0105000000", "Surat Berharga Negara", EnumSet.of(JenisProgram.ALL)),
    R_ALM0106000000("ALM0106000000", "Saham yang tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0107000000("ALM0107000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0108000000("ALM0108000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0109000000("ALM0109000000", "Obligasi/Sukuk Daerah", EnumSet.of(JenisProgram.ALL)),
    R_ALM0110000000("ALM0110000000", "Reksa Dana", EnumSet.of(JenisProgram.ALL)),
    R_ALM0111000000("ALM0111000000", "MTN", EnumSet.of(JenisProgram.ALL)),
    R_ALM0112000000("ALM0112000000", "Efek beragun aset", EnumSet.of(JenisProgram.ALL)),
    R_ALM0113000000("ALM0113000000", "Dana investasi real estat berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_ALM0114000000("ALM0114000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif", EnumSet.of(JenisProgram.ALL)),
    R_ALM0115000000("ALM0115000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0116000000("ALM0116000000", "REPO", EnumSet.of(JenisProgram.ALL)),
    R_ALM0117000000("ALM0117000000", "Penyertaan Langsung di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0118000000("ALM0118000000", "Tanah di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0119000000("ALM0119000000", "Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0120000000("ALM0120000000", "Tanah dan Bangunan di Indonesia", EnumSet.of(JenisProgram.ALL)),
    R_ALM0121000000("ALM0121000000", "Total Investasi", EnumSet.of(JenisProgram.ALL)),
    R_ALM0201000000("ALM0201000000", "Kas & Bank", EnumSet.of(JenisProgram.ALL)),
    R_ALM0202000000("ALM0202000000", "Piutang Iuran", EnumSet.of(JenisProgram.ALL)),
    R_ALM0203000000("ALM0203000000", "Iuran Normal Pemberi Kerja", EnumSet.of(JenisProgram.ALL)),
    R_ALM0204000000("ALM0204000000", "Iuran Normal Peserta", EnumSet.of(JenisProgram.ALL)),
    R_ALM0205000000("ALM0205000000", "Iuran Sukarela Peserta", EnumSet.of(JenisProgram.ALL)),
    R_ALM0206000000("ALM0206000000", "Piutang Bunga Keterlambatan Iuran", EnumSet.of(JenisProgram.ALL)),
    R_ALM0207000000("ALM0207000000", "Beban Dibayar di Muka", EnumSet.of(JenisProgram.ALL)),
    R_ALM0208000000("ALM0208000000", "Piutang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_ALM0209000000("ALM0209000000", "Piutang Hasil Investasi", EnumSet.of(JenisProgram.ALL)),
    R_ALM0210000000("ALM0210000000", "Piutang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_ALM0211000000("ALM0211000000", "Total Aset Lancar di Luar Investasi", EnumSet.of(JenisProgram.ALL)),
    R_ALM0301000000("ALM0301000000", "Tanah dan Bangunan", EnumSet.of(JenisProgram.ALL)),
    R_ALM0302000000("ALM0302000000", "Kendaraan", EnumSet.of(JenisProgram.ALL)),
    R_ALM0303000000("ALM0303000000", "Peralatan Komputer", EnumSet.of(JenisProgram.ALL)),
    R_ALM0304000000("ALM0304000000", "Peralatan Kantor", EnumSet.of(JenisProgram.ALL)),
    R_ALM0305000000("ALM0305000000", "Aset Operasional Lain", EnumSet.of(JenisProgram.ALL)),
    R_ALM0306000000("ALM0306000000", "Total Aset Operasional", EnumSet.of(JenisProgram.ALL)),
    R_ALM0400000000("ALM0400000000", "D. Aset Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_ALM0500000000("ALM0500000000", "E. Total Aset (A+B+C+D)", EnumSet.of(JenisProgram.ALL)),
    R_ALM0600000000("ALM0600000000", "F. Nilai Kini Aktuarial",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    R_ALM0700000000("ALM0700000000", "F. Liabilitas Manfaat Pensiun",
            EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK)),
    R_ALM0900000000("ALM0900000000", "G. Liabilitas di Luar Liabilitas Manfaat Pensiun",
            EnumSet.of(JenisProgram.PPIPM, JenisProgram.PPIPK, JenisProgram.PPMPPPIPK)),
    R_ALM0901000000("ALM0901000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo", EnumSet.of(JenisProgram.ALL)),
    R_ALM0902000000("ALM0902000000", "Utang Manfaat Sukarela", EnumSet.of(JenisProgram.ALL)),
    R_ALM0903000000("ALM0903000000", "Utang Investasi", EnumSet.of(JenisProgram.ALL)),
    R_ALM0904000000("ALM0904000000", "Pendapatan Diterima di Muka", EnumSet.of(JenisProgram.ALL)),
    R_ALM0905000000("ALM0905000000", "Beban yang Masih Harus Dibayar", EnumSet.of(JenisProgram.ALL)),
    R_ALM0906000000("ALM0906000000", "Utang Lain-Lain", EnumSet.of(JenisProgram.ALL)),
    R_ALM0907000000("ALM0907000000", "Utang Dana Ta'zir (bagi syariah)", EnumSet.of(JenisProgram.ALL)),
    R_ALM0908000000("ALM0908000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun", EnumSet.of(JenisProgram.ALL)),
    R_ALM1000000000("ALM1000000000", "H. Total Liabilitas (F+G)", EnumSet.of(JenisProgram.ALL)),
    R_ALM1100000000("ALM1100000000", "I. Selisih Total Aset dan Total Liabilitas (E-H)", EnumSet.of(JenisProgram.ALL)),
    R_ALM1200000000("ALM1200000000", "J. Persentase (%) Rasio Kecukupan Dana", EnumSet.of(JenisProgram.ALL)),

    ;

    private String key;
    private String value;
    private EnumSet<JenisProgram> jenisPrograms;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(JenisProgram jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7012PosLtlbDppkAlm eEnum : ER7012PosLtlbDppkAlm.values()) {
            if (eEnum.jenisPrograms.contains(jenisProgram) || eEnum.jenisPrograms.contains(JenisProgram.ALL) ) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7012PosLtlbDppkAlm.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7012PosLtlbDppkAlm.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave(JenisProgram jenisProgram) {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects(jenisProgram));
    }

    public static String getRequiredPos(JenisProgram jenisProgram) {
        return UtilMetadata.genPipeRow(getObjects(jenisProgram));
    }

    public static List<SegmentValidation> getPpmpkSegmentValidations() {
        return Arrays.stream(EAlmValidationsConfig.values())
                .filter(EAlmValidationsConfig::isSegment)
                .map(EAlmValidationsConfig::toSegmentValidation)
                .collect(Collectors.toList());
    }

    public static FieldValidation genFieldTotal1Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldTotal2Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldTotal3Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("14+15", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtdValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("11+12", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtcValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("8+9", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtbValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("5+6", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtaValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("2+3", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static ConditionalRequired genConditionForPersentase() {
        return UtilFieldConditional.genExistPos("N", "M", R_ALM1000000000.key);
    }
}
