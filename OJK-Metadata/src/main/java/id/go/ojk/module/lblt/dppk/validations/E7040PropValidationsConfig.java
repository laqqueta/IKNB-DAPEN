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
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7040PosLtlbDppkProp.R_PROP000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7040PosLtlbDppkProp.R_PROP010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7040PropValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("8|9|10|11|15", R_PROP000000.key, R_PROP010000.key,
                    UtilMetadata.genMessageTotal(R_PROP000000.value, R_PROP010000.value))),

    FV_EQUAL_NILAI_BUKU(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8-9", R_PROP000000.key)),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11-10", R_PROP000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("15/10", R_PROP000000.key)),

    CR_EXISTS_POS_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PROP000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_PROP000000.key)),

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

    public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, PPMPK);

}
