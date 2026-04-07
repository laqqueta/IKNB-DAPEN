package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7049PosLtlbDppkKndr.R_KNDR000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7049PosLtlbDppkKndr.R_KNDR010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7049KndrValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(5, 7), R_KNDR000000.key, R_KNDR010000.key,
                    UtilMetadata.genMessageTotal(R_KNDR000000.value, R_KNDR010000.value))),

    FV_EQUAL_NILAI_BUKU(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5-6", R_KNDR000000.key)),

    CR_EXISTS_POS_1(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_KNDR000000.key)),

    CR_EXISTS_POS_2(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_KNDR000000.key)),

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

    public static final BaseMetadataValidation<E7049KndrValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7049KndrValidationsConfig.class, PPMPK);

}
