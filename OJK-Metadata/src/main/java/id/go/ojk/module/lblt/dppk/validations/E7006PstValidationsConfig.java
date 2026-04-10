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

import static id.go.ojk.module.lblt.dppk.reference.ER7006PosLtlbDppkPst.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7006PstValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_SUM_ROW(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 4))),

    SG_SEGMENT_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4",
                    R_PST0100000000.key, UtilMetadata.genPlusRow(getObjects(), new int[]{1, 2}),
                    UtilMetadata.genMessage(R_PST0100000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{1, 2})))),

    SG_SEGMENT_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4", R_PST0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{4, 9}),
                    UtilMetadata.genMessage(R_PST0200000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{4, 9})))),

    SG_SEGMENT_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4", R_PST0201000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 5, 8),
                    UtilMetadata.genMessage(R_PST0201000000.value, UtilMetadata.genPlusDesc(getObjects(), 5, 8)))),

    SG_SEGMENT_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4", R_PST0202000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 10, 13),
                    UtilMetadata.genMessage(R_PST0202000000.value, UtilMetadata.genPlusDesc(getObjects(), 10, 13)))),

    SG_SEGMENT_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4", R_PST0300000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{15, 16}),
                    UtilMetadata.genMessage(R_PST0300000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{15, 16})))),

    SG_SEGMENT_6(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("2|3|4", R_PST0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{0, 3, 14}),
                    UtilMetadata.genMessage(R_PST0400000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{0, 3, 14})))),

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

    public static final BaseMetadataValidation<E7006PstValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7006PstValidationsConfig.class, PPMPK);

}
