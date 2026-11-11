package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7005PosLtlbDppkLak.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7064PosLtlbDppkBinv.R_BINV000000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPPPIPK;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7005LakGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_POS_COL_EQUAL_1_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 17), R_LAK0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 0, 6),
                    "2", "PPIP",
                    UtilMetadata.genMessage(R_LAK0200000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 0, 6)), 2)),

    SG_SUM_POS_COL_EQUAL_2_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumnExcept(3, 17, new int[] { 13 }), R_LAK0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 8, 17),
                    "2", "PPIP",
                    UtilMetadata.genMessage(R_LAK0400000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 8, 17)), 2)),

    SG_SUM_POS_COL_EQUAL_3_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumnExcept(3, 17, new int[] { 13 }), R_LAK0600000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 19, 26),
                    "2", "PPIP",
                    UtilMetadata.genMessage(R_LAK0600000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 19, 26)), 2)),

    SG_SUM_POS_COL_EQUAL_4_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumnExcept(3, 17, new int[] { 13 }), R_LAK0700000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), new int[]{7, 18, 27}),
                    "2", "PPIP",
                    UtilMetadata.genMessage(R_LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), new int[]{7, 18, 27})), 2)),

    SG_SUM_POS_COL_EQUAL_5_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumnExcept(3, 17, new int[] { 13 }), R_LAK0900000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), new int[]{28, 29}),
                    "2", "PPIP",
                    UtilMetadata.genMessage(R_LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), new int[]{28, 29})), 2)),

    SG_SUM_POS_COL_EQUAL_1_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_LAK0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 0, 6),
                    "2", "PPMP",
                    UtilMetadata.genMessage(R_LAK0200000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 0, 6)), 2)),

    SG_SUM_POS_COL_EQUAL_2_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_LAK0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 8, 17),
                    "2", "PPMP",
                    UtilMetadata.genMessage(R_LAK0400000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 8, 17)), 2)),

    SG_SUM_POS_COL_EQUAL_3_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_LAK0600000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), 19, 26),
                    "2", "PPMP",
                    UtilMetadata.genMessage(R_LAK0600000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), 19, 26)), 2)),

    SG_SUM_POS_COL_EQUAL_4_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_LAK0700000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), new int[]{7, 18, 27}),
                    "2", "PPMP",
                    UtilMetadata.genMessage(R_LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), new int[]{7, 18, 27})), 2)),

    SG_SUM_POS_COL_EQUAL_5_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_LAK0900000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), new int[]{28, 29}),
                    "2", "PPMP",
                    UtilMetadata.genMessage(R_LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), new int[]{28, 29})), 2)),

    SG_NEG_NUM(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genRegexNumericNegative(
                    UtilMetadata.genPipeColumn(3, 12),
                    UtilMetadata.genDelimitedRowExcept2(getObjects(PPMPPPIPK), new int[]{7, 18, 27, 28, 29, 30}, "|"))),

    SG_POV_NUM(programs(PPMPM),
            () -> UtilSegmentValidation.genRegexNumericNegative(
                    UtilMetadata.genPipeColumn(3, 12),
                    UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), new int[]{7, 18, 27, 28, 29, 30}))),

    FV_SUM_ROW(programs(PPMPPPIPK), validationFields(12),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(3, 12), R_LAK0200000000.key)),

    FV_SUM_COL_2(programs(PPIPK), validationFields(1004),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(13, 16), R_LAK0200000000.key)),

    CR_EXISTS_POS_M(programs(PPMPPPIPK), validationFields(1001, 1002, 1003, 1004),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M",
                    UtilMetadata.genPipeRow(getObjects(PPMPPPIPK)), "2", "PPMP")),

    ;

    private final EnumSet<ProgramType> programTypes;
    private List<Integer> fieldIndexes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
    }

    @Override
    public List<Integer> getFieldsIndex() {
        return fieldIndexes;
    }

    @Override
    public EnumSet<ProgramType> getProgramTypes() {
        return programTypes;
    }

    @Override
    public SegmentValidation toSegmentValidation() {
        return ValidationConverter
                .toValidation(this, SegmentValidation.class);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return ValidationConverter
                .toValidation(this, FieldValidation.class);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return ValidationConverter
                .toValidation(this, ConditionalRequired.class);
    }

    public static final BaseMetadataValidation<E7005LakGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7005LakGabunganValidationsConfig.class, PPMPPPIPK);

}
