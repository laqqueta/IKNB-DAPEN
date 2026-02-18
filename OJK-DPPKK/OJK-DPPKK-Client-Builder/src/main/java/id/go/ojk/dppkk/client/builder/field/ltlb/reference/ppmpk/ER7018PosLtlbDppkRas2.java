package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7018PosLtlbDppkRas2 implements IObject<KeyValueString> {

    R_RAS20100000000("RAS20100000000", "Biaya Pegawai, Pengurus, Dewan Pengawas, dan/atau Dewas Pengawas Syariah"),
    R_RAS20101010000("RAS20101010000", "a. Diklat Pegawai"),
    R_RAS20101020000("RAS20101020000", "b. Diklat Pengurus"),
    R_RAS20101030000("RAS20101030000", "c. Diklat Dewan Pengawas"),
    R_RAS20101040000("RAS20101040000", "d. Diklat Dewan Pengawas Syariah (jika ada)"),
    R_RAS20102000000("RAS20102000000", "Total Biaya Diklat"),
    R_RAS20103000000("RAS20103000000", "Rasio Biaya Diklat");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7018PosLtlbDppkRas2 eEnum : ER7018PosLtlbDppkRas2.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7018PosLtlbDppkRas2.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7018PosLtlbDppkRas2.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave("2|3|4", getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    public static final List<SegmentValidation> SEGMENTS_VALIDATIONS = Arrays.asList(
            genValidationNumeric(),
            genValidationNumericDot(),
            genValidationSumCol(),
            genValidationRasio()
    );

    private static SegmentValidation genValidationNumericDot() {
        return UtilSegmentValidation.genRegexNumericDot("3|4",
                UtilMetadata.genPipeRow(getObjects(), new int[] {6}));
    }

    private static SegmentValidation genValidationNumeric() {
        return UtilSegmentValidation.genRegexNumeric("3|4",
                UtilMetadata.genPipeRowExcept(getObjects(), new int[] {6}));
    }

    private static SegmentValidation genValidationSumCol() {
        return UtilSegmentValidation.genEqualsFormula("3|4", R_RAS20102000000.key, UtilMetadata.genPlusRow(getObjects(), 1, 4),
                UtilMetadata.genMessageTotal(R_RAS20102000000.value, UtilMetadata.genPlusDesc(getObjects(), 1, 4)));
    }

    private static SegmentValidation genValidationRasio() {
        int[] field = new int[] { 5, 0 };
        return UtilSegmentValidation.genEqualsRatio2("3|4", R_RAS20103000000.key, R_RAS20102000000.key, "3|4", R_RAS20100000000.key, "2",
                UtilMetadata.genMessage(R_RAS20103000000.value, UtilMetadata.genDevideDesc(getObjects(), field)), 2);
    }

    public static ConditionalRequired genConditionEmpty1() {
        return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 1, 6));
    }

    public static ConditionalRequired genConditionEmpty2() {
        return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 0 }));
    }

}
