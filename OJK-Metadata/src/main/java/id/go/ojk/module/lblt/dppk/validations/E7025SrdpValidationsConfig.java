package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7025PosLtlbDppkSrdp.R_SRDP000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7025PosLtlbDppkSrdp.R_SRDP010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7025SrdpValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_SRDP000000_SRDP010000(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("6", R_SRDP000000.key, R_SRDP010000.key,
                    UtilMetadata.genMessageTotal(R_SRDP000000.value, R_SRDP010000.value))),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("9/7", R_SRDP000000.key)),

    FV_EQUAL_PERSENTASE_NILAI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8-7", R_SRDP000000.key)),

    CR_EXISTS_SRDP000000_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_SRDP000000.key)),

    CR_EXISTS_SRDP000000_O(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_SRDP000000.key)),

    CR_EQUAL_NAMA_PENGGUNA(programs(PPMPK),
            () -> UtilFieldConditional.genEqualsExceptPos("O", "M", "12",
                    ER1252Pengelolaan.getReferenceIndex(0), R_SRDP000000.key)),

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

    public static final BaseMetadataValidation<E7025SrdpValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, PPMPK);

}
