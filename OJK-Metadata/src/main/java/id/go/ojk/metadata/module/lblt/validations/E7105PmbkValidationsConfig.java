package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.metadata.module.lblt.field.Dppk0105Pmbk;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7105PosLtlbDppkPmbk.R_PMBK010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7105PmbkValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_EQUAL_NILAI_INVESTASI(programs(PPIPK, PPIPM, DPLK), validationFields(Dppk0105Pmbk.AKUMULASI_DANA_TOTAL),
            () -> UtilFieldValidation.genEqualsPosFormula("4+5", R_PMBK010000.key)),

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

    public static final BaseMetadataValidation<E7105PmbkValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7105PmbkValidationsConfig.class, PPIPK);

    public static final BaseMetadataValidation<E7105PmbkValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7105PmbkValidationsConfig.class, PPIPM);

    public static final BaseMetadataValidation<E7105PmbkValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7105PmbkValidationsConfig.class, DPLK);

}
