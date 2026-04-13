package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.reference.ER7018PosLtlbDppkRas2;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7018PosLtlbDppkRas2.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7018Ras2ValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_NUMERIC_DOT(programs(PPMPK),
            () -> UtilSegmentValidation.genRegexNumericDot("3|4",
                    UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(), new int[]{6}))),

    SG_NUMERIC(programs(PPMPK),
            () -> UtilSegmentValidation.genRegexNumeric("3|4",
                    UtilMetadata.genPipeRowExcept(ER7018PosLtlbDppkRas2.getObjects(), new int[]{6}))),

    SG_SUM_COL(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("3|4", R_RAS20102000000.key, UtilMetadata.genPlusRow(ER7018PosLtlbDppkRas2.getObjects(), 1, 4),
                    UtilMetadata.genMessageTotal(R_RAS20102000000.value, UtilMetadata.genPlusDesc(ER7018PosLtlbDppkRas2.getObjects(), 1, 4)))),

    SG_RASIO(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsRatio2(
                    "3|4", R_RAS20103000000.key, R_RAS20102000000.key,
                    "3|4", R_RAS20100000000.key, "2",
                    UtilMetadata.genMessage(R_RAS20103000000.value,
                            UtilMetadata.genDevideDesc(ER7018PosLtlbDppkRas2.getObjects(), new int[]{5, 0})), 2)),

    CR_EMPTY_1(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(), 1, 6))),

    CR_EMPTY_2(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(), new int[]{0}))),

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

    public static final BaseMetadataValidation<E7018Ras2ValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7018Ras2ValidationsConfig.class, PPMPK);

}
