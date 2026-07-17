package id.go.ojk.metadata.module.lblt.validations.dplk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7006PosLtlbDppkPst.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7006PstKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SEGMENT_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_PST0100000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{1, 2}),
                    UtilMetadata.genMessage(R_PST0100000000.value,
                            UtilMetadata.genPlusDesc(getObjects(), new int[]{1, 2})))),

    SG_SEGMENT_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_PST0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{4, 5}),
                    UtilMetadata.genMessage(R_PST0200000000.value,
                            UtilMetadata.genPlusDesc(getObjects(), new int[]{4, 5})))),

    SG_SEGMENT_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_PST0300000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{7, 8}),
                    UtilMetadata.genMessage(R_PST0300000000.value,
                            UtilMetadata.genPlusDesc(getObjects(), new int[]{7, 8})))),
    
    SG_SEGMENT_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_PST0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{10, 11}),
                    UtilMetadata.genMessage(R_PST0400000000.value,
                            UtilMetadata.genPlusDesc(getObjects(), new int[]{10, 11})))),

    SG_SEGMENT_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_PST0500000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{0, 3, 6, 9}),
                    UtilMetadata.genMessage(R_PST0500000000.value,
                            UtilMetadata.genPlusDesc(getObjects(), new int[]{0, 3, 6, 9})))),

    FV_SUM_ROW(programs(DPLK), validationFields(5),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 4))),

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

    public static final BaseMetadataValidation<E7006PstKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7006PstKValidationsConfig.class, DPLK);

}
