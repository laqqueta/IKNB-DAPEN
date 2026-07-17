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

import static id.go.ojk.metadata.module.lblt.reference.ER7048PosLtlbDppkTnbg.R_TNBG000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7048PosLtlbDppkTnbg.R_TNBG010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7048TnbgValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM, PPIPK, PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(6, 9), R_TNBG000000.key, R_TNBG010000.key,
                    UtilMetadata.genMessageTotal(R_TNBG000000.value, R_TNBG010000.value))),

    FV_EQUAL_NILAI_BUKU(programs(PPMPK, PPMPM, PPIPK, PPIPM), validationFields(8),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("6-7", R_TNBG000000.key)),

    CR_EXISTS_POS_M(programs(PPMPK, PPMPM, PPIPK, PPIPM), validationFields(2, 3, 4, 5),
            () -> UtilFieldConditional.genExistPos("N", "M", R_TNBG000000.key)),

    CR_EXISTS_POS_O(programs(PPMPK, PPMPM, PPIPK, PPIPM), validationFields(10),
            () -> UtilFieldConditional.genExistPos("N", "O", R_TNBG000000.key)),

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

    public static final BaseMetadataValidation<E7048TnbgValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7048TnbgValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7048TnbgValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7048TnbgValidationsConfig.class, PPMPM);

    public static final BaseMetadataValidation<E7048TnbgValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7048TnbgValidationsConfig.class, PPIPK);

    public static final BaseMetadataValidation<E7048TnbgValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7048TnbgValidationsConfig.class, PPIPM);


}
