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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7025PosLtlbDppkSrdp.R_SRDP010000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7026PosLtlbDppkSbi.R_SBI000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7026PosLtlbDppkSbi.R_SBI010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7026SbiValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("4|7|8|9", R_SBI000000.key, R_SBI010000.key,
                    UtilMetadata.genMessageTotal(R_SBI000000.value, R_SBI010000.value))),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK, PPMPM), validationFields(9),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8-7", R_SBI000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM), validationFields(10),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("9/7", R_SBI000000.key)),

    FV_DATE_GREATER(programs(PPMPK, PPMPM), validationFields(6),
            () -> UtilFieldValidation.genDateGreaterEquals("3")),

    CR_NAMA_PENGELOLA(programs(PPMPK, PPMPM), validationFields(13),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue2("N", "M", "N",
                    R_SBI010000.key, "12", ER1252Pengelolaan.getReferenceIndex(0), ER1252Pengelolaan.getReferenceValueIndex(0))),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM), validationFields(2, 3, 5, 6, 10, 11, 12),
            () -> UtilFieldConditional.genExistPos("N", "M", R_SBI000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM), validationFields(14),
            () -> UtilFieldConditional.genExistPos("N", "O", R_SBI000000.key)),
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

    public static final BaseMetadataValidation<E7026SbiValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7026SbiValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7026SbiValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7026SbiValidationsConfig.class, PPMPM);

}
