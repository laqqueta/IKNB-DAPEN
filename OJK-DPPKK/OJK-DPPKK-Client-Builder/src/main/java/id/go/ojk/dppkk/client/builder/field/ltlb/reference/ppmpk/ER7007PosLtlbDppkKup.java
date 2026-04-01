package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.EKupValidationsConfig;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk.ENrcValidationsConfig;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;
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
public enum ER7007PosLtlbDppkKup implements IObject<KeyValueString> {

    R_KUP0100000000("KUP0100000000", "Nilai Aset Neto",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0201010000("KUP0201010000", "Uraian - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0201020000("KUP0201020000", "Total - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0202010000("KUP0202010000", "a.Iuran Peserta",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0202020000("KUP0202020000", "b.Iuran Pemberi Kerja",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0202030000("KUP0202030000", "c.Iuran Tambahan",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0202040000("KUP0202040000", "Total - Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0203010000("KUP0203010000", "Uraian - Piutang Lain-Lain",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0203020000("KUP0203020000", "Total - Piutang Lain-Lain",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0204010000("KUP0204010000", "Uraian - Aset Lain-Lain",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0204020000("KUP0204020000", "Total - Aset Lain-Lain",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0205010000("KUP0205010000", "Uraian - Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0205020000("KUP0205020000", "Total - Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0200000100("KUP0200000100", "Total Pengurang",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0200000200("KUP0200000200", "Nilai Kekayaan Untuk Pendanaan",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0206000000("KUP0206000000", "Liabilitas Solvabilitas",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0207000000("KUP0207000000", "Nilai Kini Aktuaria",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0208000000("KUP0208000000", "Tingkat bunga aktuaria (%)",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0209000000("KUP0209000000", "Proyeksi Tingkat Pendanaan",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),

    R_KUP0210000000("KUP0210000000", "Metode Pendanaan",
            EnumSet.of(JenisProgram.PPMPM, JenisProgram.PPMPK, JenisProgram.PPMPPPIPK)),
    ;


    private final String key;
    private final String value;
    private final EnumSet<JenisProgram> jenisProgram;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects(JenisProgram jenisProgram) {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7007PosLtlbDppkKup eEnum : ER7007PosLtlbDppkKup.values()) {
            if (eEnum.jenisProgram.contains(jenisProgram) || eEnum.jenisProgram.contains(JenisProgram.ALL) ) {
                res.add(eEnum.getObject());
            }
        }
        return res;
    }

    public static String getName() {
        return ER7007PosLtlbDppkKup.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7007PosLtlbDppkKup.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave(JenisProgram jenisProgram) {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects(jenisProgram));
    }

    public static String getRequiredPos(JenisProgram jenisProgram) {
        return UtilMetadata.genPipeRowExcept(getObjects(jenisProgram), new int[] { 1,7,9,11 });
    }

    public static List<SegmentValidation> getPpmpkSegmentValidations() {
        return Arrays.stream(EKupValidationsConfig.values())
                .filter(EKupValidationsConfig::isSegment)
                .map(EKupValidationsConfig::toSegmentValidation)
                .collect(Collectors.toList());
    }

}
