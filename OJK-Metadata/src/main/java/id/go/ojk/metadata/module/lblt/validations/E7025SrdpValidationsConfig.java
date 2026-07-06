package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7025PosLtlbDppkSrdp.R_SRDP000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7025PosLtlbDppkSrdp.R_SRDP010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7025SrdpValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_SRDP000000_SRDP010000(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("6", R_SRDP000000.key, R_SRDP010000.key,
                    UtilMetadata.genMessageTotal(R_SRDP000000.value, R_SRDP010000.value))),

    CR_EXISTS_SRDP000000_M(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(2, 5, 7, 8, 9, 10),
            () -> UtilFieldConditional.genExistPos("N", "M", R_SRDP000000.key)),

    CR_EXISTS_SRDP000000_O(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(3, 4, 12),
            () -> UtilFieldConditional.genExistPos("N", "O", R_SRDP000000.key)),

    CR_EQUAL_NAMA_PENGGUNA(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(11),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue2("N", "M", "N",
                    R_SRDP010000.key, "10", ER1252Pengelolaan.getReferenceIndex(0), ER1252Pengelolaan.getReferenceValueIndex(0))),

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

    public static final BaseMetadataValidation<E7025SrdpValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7025SrdpValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, PPMPM);

    public static final BaseMetadataValidation<E7025SrdpValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, PPIPK);

        public static final BaseMetadataValidation<E7025SrdpValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, PPIPM);

    public static final BaseMetadataValidation<E7025SrdpValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7025SrdpValidationsConfig.class, DPLK);

}
