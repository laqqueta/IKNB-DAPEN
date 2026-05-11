package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7010PosLtlbDppkRoiml;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7010PosLtlbDppkRoiml.R_ROIML2100000000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7010RoimlValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_FIELD_VALIDATION_1(programs(PPMPK), validationFields(9),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7) + "-8")),

    FV_FIELD_VALIDATION_2(programs(PPMPK), validationFields(11),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("9/10", R_ROIML2100000000.key)),

    SG_SUM_POS_COL_EQUAL(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 6, 7, 8, 10, 11}), R_ROIML2100000000.key,
                    UtilMetadata.genPlusRow(ER7010PosLtlbDppkRoiml.getObjects(), 0, 19),
                    UtilMetadata.genMessage(R_ROIML2100000000.value,
                            UtilMetadata.genPlusDesc(ER7010PosLtlbDppkRoiml.getObjects(), 0, 19)))),

    SG_SUM_POS_COL_EQUAL_PPMPM(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 6, 7, 8, 10, 11}), R_ROIML2100000000.key,
                    UtilMetadata.genPlusRow(ER7010PosLtlbDppkRoiml.getObjects(), 0, 19),
                    UtilMetadata.genMessage(R_ROIML2100000000.value,
                            UtilMetadata.genPlusDesc(ER7010PosLtlbDppkRoiml.getObjects(), 0, 19)))),

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

    public static final BaseMetadataValidation<E7010RoimlValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7010RoimlValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7010RoimlValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7010RoimlValidationsConfig.class, PPMPM);

}
