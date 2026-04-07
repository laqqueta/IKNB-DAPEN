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

import static id.go.ojk.module.lblt.dppk.reference.ER7042PosLtlbDppkPiut.R_PIUT000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7042PosLtlbDppkPiut.R_PIUT010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7042PiutValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 12), R_PIUT000000.key, R_PIUT010000.key,
                    UtilMetadata.genMessageTotal(R_PIUT000000.value, R_PIUT010000.value))),

    FV_EQUAL_PEMBERI_KERJA(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+4", R_PIUT000000.key)),

    FV_EQUAL_PESERTA(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("6+7", R_PIUT000000.key)),

    FV_EQUAL_TAMBAHAN(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("9+10", R_PIUT000000.key)),

    CR_EXISTS_POS_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PIUT000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_PIUT000000.key)),

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

    public static final BaseMetadataValidation<E7042PiutValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7042PiutValidationsConfig.class, PPMPK);

}
