package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7012PosLtlbDppkAlm;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

//DONE

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EAlmValidationsConfig {

    SG_EQUAL_FORMULA_1(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
            ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 0, 19),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 0, 19))),
            () -> null),

    SG_EQUAL_FORMULA_2(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
            ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 21, 30),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 21, 30))),
            () -> null),

    SG_EQUAL_FORMULA_3(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
            ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 32, 36),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 32, 36))),
            () -> null),

    SG_EQUAL_FORMULA_4(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
            ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 41, 47),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), 41, 47))),
            () -> null),

    SG_EQUAL_FORMULA_5(() -> UtilSegmentValidation.genEqualsFormula("16",
            ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38 }),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38 }))),
            () -> null),

    SG_EQUAL_FORMULA_6(() -> UtilSegmentValidation.genEqualsFormula("16",
            ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getKey(), UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 40, 48 }),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getValue(), UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 40, 48 }))),
            () -> null),

    SG_EQUAL_FORMULA_7(() -> UtilSegmentValidation.genEqualsFormula("16",
            ER7012PosLtlbDppkAlm.R_ALM1100000000.getObject().getKey(), UtilMetadata.genMinusRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 39, 49 }),
            UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM1100000000.getObject().getValue(), UtilMetadata.genMinusDesc(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 39, 49 }))),
            () -> null),

    FV_TOTAL1_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_TOTAL2_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_TOTAL3_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14+15", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_JTD_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11+12", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_JTC_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8+9", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_JTB_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5+6", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),

    FV_JTA_EQUAL(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+3", UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(JenisProgram.PPMPK), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }))),
    ;

    private final Supplier<SegmentValidation> segmentSupplier;
    private final Supplier<FieldValidation> fieldSupplier;

    public SegmentValidation toSegmentValidation() {
        if (segmentSupplier.get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }
        return segmentSupplier.get();
    }

    public FieldValidation toFieldValidation() {
        if (fieldSupplier.get() == null) {
            throw new UnsupportedOperationException("Field Validation is null");
        }
        return fieldSupplier.get();
    }

    public static boolean isSegment(EAlmValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(EAlmValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

    public static ConditionalRequired genConditionForPersentase() {
        return UtilFieldConditional.genExistPos("N", "M", ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getKey());
    }

}
