package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7005PosLtlbDppkLak.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7005LakValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_POS_COL_EQUAL_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_LAK0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 0, 6),
                    UtilMetadata.genMessage(R_LAK0200000000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 6)))),

    SG_SUM_POS_COL_EQUAL_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_LAK0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 8, 17),
                    UtilMetadata.genMessage(R_LAK0400000000.value, UtilMetadata.genPlusDesc(getObjects(), 8, 17)))),

    SG_SUM_POS_COL_EQUAL_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_LAK0600000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 19, 26),
                    UtilMetadata.genMessage(R_LAK0600000000.value, UtilMetadata.genPlusDesc(getObjects(), 19, 26)))),

    SG_SUM_POS_COL_EQUAL_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_LAK0700000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{7, 18, 27}),
                    UtilMetadata.genMessage(R_LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{7, 18, 27})))),

    SG_SUM_POS_COL_EQUAL_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_LAK0900000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{28, 29}),
                    UtilMetadata.genMessage(R_LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{28, 29})))),

    SG_NEG_NUM(programs(PPMPK),
            () -> UtilSegmentValidation.genRegexNumericNegative(
                    UtilMetadata.genPipeColumn(2, 11),
                    UtilMetadata.genPipeRowExcept(getObjects(), new int[]{7, 18, 27, 28, 29, 30}))),

    FV_SUM_ROW(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(2, 11), R_LAK0200000000.key)),

    ;

    private final EnumSet<ProgramType> programTypes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
    }

    @Override
    public EnumSet<ProgramType> getProgramTypes() {
        return programTypes;
    }

    @Override
    public SegmentValidation toSegmentValidation() {
        return METADATA.toSegmentValidation(this);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return METADATA.toFieldValidation(this);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return METADATA.toFieldConditional(this);
    }

    public static final BaseMetadataValidation<E7005LakValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7005LakValidationsConfig.class, PPMPK);

}
