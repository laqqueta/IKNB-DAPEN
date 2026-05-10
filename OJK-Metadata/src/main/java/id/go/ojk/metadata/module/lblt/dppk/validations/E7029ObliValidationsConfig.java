package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7029PosLtlbDppkObli.R_OBLI000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7029PosLtlbDppkObli.R_OBLI010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7029ObliValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM), () -> UtilSegmentValidation.genEqualsFormula("6|11|12|13", R_OBLI000000.key, R_OBLI010000.key,
            UtilMetadata.genMessageTotal(R_OBLI000000.value, R_OBLI010000.value))),

    FV_EQUAL_NILAI_INVESTASI(programs(PPMPK, PPMPM), validationFields(13),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("12-11", R_OBLI000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM), validationFields(14),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("13/11", R_OBLI000000.key)),

    FV_DATE_GREATER(programs(PPMPK, PPMPM), validationFields(8),
            () -> UtilFieldValidation.genDateGreaterEquals("5")),

    CR_NAMA_PENGELOLA(programs(PPMPK, PPMPM), validationFields(19),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("O", "M", "N",
                    R_OBLI010000.key, "18", ER1252Pengelolaan.getReferenceIndex(0))),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM), validationFields(2,3,4,5,7,8,9,10,14,15,16,17,18),
            () -> UtilFieldConditional.genExistPos("N", "M", R_OBLI000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM), validationFields(20),
            () -> UtilFieldConditional.genExistPos("N", "O", R_OBLI000000.key)),

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

    public static final BaseMetadataValidation<E7029ObliValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7029ObliValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7029ObliValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7029ObliValidationsConfig.class, PPMPM);

}
