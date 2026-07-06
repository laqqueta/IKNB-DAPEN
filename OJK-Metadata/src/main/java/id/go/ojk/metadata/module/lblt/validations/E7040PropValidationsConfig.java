package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7040PosLtlbDppkProp.R_PROP000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7040PosLtlbDppkProp.R_PROP010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7040PropValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("8|9|10|11|15", R_PROP000000.key, R_PROP010000.key,
                    UtilMetadata.genMessageTotal(R_PROP000000.value, R_PROP010000.value))),

    FV_EQUAL_NILAI_BUKU(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(10),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8-9", R_PROP000000.key)),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(15),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11-10", R_PROP000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(16),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("15/10", R_PROP000000.key)),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(2, 3, 4, 5, 6, 7, 12, 13, 14, 16, 17, 18),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PROP000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(19),
            () -> UtilFieldConditional.genExistPos("N", "O", R_PROP000000.key)),

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

    public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, PPMPM);

    public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, PPIPK);

        public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, PPIPM);

    public static final BaseMetadataValidation<E7040PropValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7040PropValidationsConfig.class, DPLK);

}
