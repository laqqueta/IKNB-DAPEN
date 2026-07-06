package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7032PosLtlbDppkRksd.R_RKSD000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7032PosLtlbDppkRksd.R_RKSD010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7032RksdValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("7|8|9|10", R_RKSD000000.key, R_RKSD010000.key,
                    UtilMetadata.genMessageTotal(R_RKSD000000.value, R_RKSD010000.value))),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(10),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("9-8", R_RKSD000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(11),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("10/8", R_RKSD000000.key)),

    CR_NAMA_PENGELOLA(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(14),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue2("N", "M", "N",
                    R_RKSD010000.key, "13", ER1252Pengelolaan.getReferenceIndex(0), ER1252Pengelolaan.getReferenceValueIndex(0))),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(2, 3, 4, 5, 6, 11, 12, 13),
            () -> UtilFieldConditional.genExistPos("N", "M", R_RKSD000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(15),
            () -> UtilFieldConditional.genExistPos("N", "O", R_RKSD000000.key)),

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

    public static final BaseMetadataValidation<E7032RksdValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7032RksdValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7032RksdValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7032RksdValidationsConfig.class, PPMPM);

    public static final BaseMetadataValidation<E7032RksdValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7032RksdValidationsConfig.class, PPIPK);

        public static final BaseMetadataValidation<E7032RksdValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7032RksdValidationsConfig.class, PPIPM);

    public static final BaseMetadataValidation<E7032RksdValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7032RksdValidationsConfig.class, DPLK);

}
