package id.go.ojk.metadata.module.lblt.dppk.validations;

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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7037PosLtlbDppkKokb.R_KOKB010000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7038PosLtlbDppkRepo.R_REPO000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7038PosLtlbDppkRepo.R_REPO010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7038RepoValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("5|10|11|13|14|15", R_REPO000000.key, R_REPO010000.key,
                    UtilMetadata.genMessageTotal(R_REPO000000.value, R_REPO010000.value))),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK, PPMPM), validationFields(15),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14-10", R_REPO000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM), validationFields(16),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("15/10", R_REPO000000.key)),

    CR_NAMA_PENGELOLA(programs(PPMPK, PPMPM), validationFields(19),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue2("N", "M", "N",
                    R_REPO010000.key, "18", ER1252Pengelolaan.getReferenceIndex(0), ER1252Pengelolaan.getReferenceValueIndex(0))),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM), validationFields(2, 3, 4, 6, 7, 8, 9, 12, 16, 17, 18),
            () -> UtilFieldConditional.genExistPos("N", "M", R_REPO000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM), validationFields(20),
            () -> UtilFieldConditional.genExistPos("N", "O", R_REPO000000.key)),

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

    public static final BaseMetadataValidation<E7038RepoValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7038RepoValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7038RepoValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7038RepoValidationsConfig.class, PPMPM);

}
