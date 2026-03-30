package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7007PosLtlbDppkKup implements IObject<KeyValueString> {

    R_KUP0100000000("KUP0100000000", "Nilai Aset Neto"),
    R_KUP0201010000("KUP0201010000", "Detail - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang"),
    R_KUP0201020000("KUP0201020000", "Total - Kekayaan dalam sengketa di pengadilan, atau yang dikuasai atau disita oleh pihak yang berwenang"),
    R_KUP0202010000("KUP0202010000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - a. Iuran Peserta"),
    R_KUP0202020000("KUP0202020000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - b. Iuran Pemberi Kerja"),
    R_KUP0202030000("KUP0202030000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - c. Iuran Tambahan"),
    R_KUP0202040000("KUP0202040000", "Iuran, yang pada tanggal valuasi aktuaria belum disetor lebih dari 3 (tiga) bulan sejak tanggal jatuh temponya - Total"),
    R_KUP0203010000("KUP0203010000", "Piutang Lain-Lain - Detail"),
    R_KUP0203020000("KUP0203020000", "Piutang Lain-Lain - Total"),
    R_KUP0204010000("KUP0204010000", "Aset Lain-Lain -Detail"),
    R_KUP0204020000("KUP0204020000", "Aset Lain-Lain - Total"),
    R_KUP0205010000("KUP0205010000", "Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun - Detail"),
    R_KUP0205040000("KUP0205040000", "Investasi yang tidak sesuai dengan ketentuan mengenai investasi Dana Pensiun - Total"),
    R_KUP0205020000("KUP0205020000", "Total Pengurang"),
    R_KUP0205030000("KUP0205030000", "Nilai Kekayaan Untuk Pendanaan"),
    R_KUP0206000000("KUP0206000000", "Liabilitas Solvabilitas"),
    R_KUP0207000000("KUP0207000000", "Nilai Kini Aktuaria"),
    R_KUP0208000000("KUP0208000000", "Tingkat bunga aktuaria (%)"),
    R_KUP0209000000("KUP0209000000", "Proyeksi Tingkat Pendanaan"),
    R_KUP0210000000("KUP0210000000", "Metode Pendanaan");


    private final String key;
    private final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7007PosLtlbDppkKup eEnum : ER7007PosLtlbDppkKup.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7007PosLtlbDppkKup.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7007PosLtlbDppkKup.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 1,7,9,11 });
    }

    public static final List<SegmentValidation> SEGMENT_VALIDATIONS = Arrays.asList(
            genRowValidation(),

            genValidationSumPos1(),
            genValidationSumPos2(),
            genValidationSumPos3(),
            genValidationSumPos4(),

            genValidationSegment1(),
            genValidationSegment2(),
            genValidationSegment3(),

            genValidationReferenceKodePendanaan(),

            genValidationProyeksiPendanaan()
    );

    public static ConditionalRequired genConditionForUraian() {
        return UtilFieldConditional.genExistPos("M", "N",
                UtilMetadata.genPipeRow(getObjects(), new int[] { 1,7,9,11 }));
    }

    private static SegmentValidation genRowValidation() {
        return UtilSegmentValidation.genEqualsForm("3|4|5", R_KUP0100000000.key,
                EFormLaporanTahunanLaporanBulanan.LTLB_LAN.getCode(), "3",
                ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getKey());
    }

    private static SegmentValidation genValidationSumPos1() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0201020000.key, R_KUP0201010000.key,
                UtilMetadata.genMessageTotal(R_KUP0201020000.value, R_KUP0201010000.value));
    }

    private static SegmentValidation genValidationSumPos2() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0203020000.key, R_KUP0203010000.key,
                UtilMetadata.genMessageTotal(R_KUP0203020000.value, R_KUP0203010000.value));
    }

    private static SegmentValidation genValidationSumPos3() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0204020000.key, R_KUP0204010000.key,
                UtilMetadata.genMessageTotal(R_KUP0204020000.value, R_KUP0204010000.value));
    }

    private static SegmentValidation genValidationSumPos4() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0205040000.key, R_KUP0205010000.key,
                UtilMetadata.genMessageTotal(R_KUP0205040000.value, R_KUP0205010000.value));
    }

    private static SegmentValidation genValidationSegment1() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0202040000.key,
                UtilMetadata.genPlusRow(getObjects(), 3, 5),
                UtilMetadata.genMessage(R_KUP0202040000.value, UtilMetadata.genPlusDesc(getObjects(), 3, 5)));
    }

    private static SegmentValidation genValidationSegment2() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0205020000.key,
                UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 6, 8, 10, 12}),
                UtilMetadata.genMessage(R_KUP0205020000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 2, 6, 8, 10, 12 })));
    }

    private static SegmentValidation genValidationSegment3() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0205030000.key,
                UtilMetadata.genMinusRow(getObjects(), new int[] { 0, 13 }),
                UtilMetadata.genMessage(R_KUP0205030000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 0, 13 })));
    }

    private static SegmentValidation genValidationReferenceKodePendanaan() {
        return UtilSegmentValidation.genReference("3|4|5", UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }),
                EHeaderMetadataShared.R023.getNumber());
    }

    private static SegmentValidation genValidationProyeksiPendanaan() {
        return UtilSegmentValidation.genOperatorProyeksi("3|4|5", R_KUP0209000000.key,
                String.format("%1$s<%2$s|%1$s>%3$s", R_KUP0205030000.key, R_KUP0206000000.key, R_KUP0207000000.key),
                "III|I", "II",
                "msgErr", "defaultValueErr");
    }

}
