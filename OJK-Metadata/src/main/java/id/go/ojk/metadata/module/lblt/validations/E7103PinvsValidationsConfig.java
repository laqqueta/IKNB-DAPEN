package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.reference.ER7012PosLtlbDppkAlm;
import id.go.ojk.metadata.module.lblt.reference.ER7102PosLtlbDppkPinv;
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

import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7103PinvsValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUALS_FORMULA_1(programs(PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5),
                    ER7102PosLtlbDppkPinv.R_PINV0101200000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7102PosLtlbDppkPinv.getObjects(), 0, 18),
                    UtilMetadata.genMessage(ER7102PosLtlbDppkPinv.R_PINV0101200000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7102PosLtlbDppkPinv.getObjects(), 0, 18)))),


    SG_EQUALS_FORMULA_2(programs(PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5),
                    ER7102PosLtlbDppkPinv.R_PINV0102060000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7102PosLtlbDppkPinv.getObjects(), 20, 24),
                    UtilMetadata.genMessage(ER7102PosLtlbDppkPinv.R_PINV0102060000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7102PosLtlbDppkPinv.getObjects(), 20, 24)))),

    SG_EQUALS_FORMULA_3(programs(PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5),
                    ER7102PosLtlbDppkPinv.R_PINV0103070000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7102PosLtlbDppkPinv.getObjects(), 26, 31),
                    UtilMetadata.genMessage(ER7102PosLtlbDppkPinv.R_PINV0103070000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7102PosLtlbDppkPinv.getObjects(), 26, 31)))),

    SG_EQUALS_FORMULA_4(programs(PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5),
                    ER7102PosLtlbDppkPinv.R_PINV0104000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7102PosLtlbDppkPinv.getObjects(), new int[] {19, 25}) + "-PINVS0103080000",
                    UtilMetadata.genMessage(ER7102PosLtlbDppkPinv.R_PINV0104000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7102PosLtlbDppkPinv.getObjects(), new int[] {19, 25})) + "-'Total Liabilitas Di Luar Kewajiban Manfaat Pensiun '")),

    SG_ROW_DATA_TYPE_NUMERIC(programs(PPIPK, PPIPM),
            () -> UtilSegmentValidation.genRegexNumeric(UtilMetadata.genPipeColumn(2, 5),
                    UtilMetadata.genPipeRowExcept(ER7102PosLtlbDppkPinv.getObjects(), new int[] { 33 }))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(PPIPK, PPIPM),
            () -> UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 5),
                    UtilMetadata.genPipeRow(ER7102PosLtlbDppkPinv.getObjects(), new int[] { 33 }))),

    SG_ROW_DATA_TYPE_NUMERIC_DPLK(programs(DPLK),
            () -> UtilSegmentValidation.genRegexNumeric(UtilMetadata.genPipeColumn(2, 5),
                    UtilMetadata.genPipeRowExcept(ER7102PosLtlbDppkPinv.getObjects(DPLK), new int[] { 33 }))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE_DPLK(programs(DPLK),
            () -> UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 5),
                    UtilMetadata.genPipeRow(ER7102PosLtlbDppkPinv.getObjects(DPLK), new int[] { 33 }))),


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

    public static final BaseMetadataValidation<E7103PinvsValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7103PinvsValidationsConfig.class, PPIPK);

    public static final BaseMetadataValidation<E7103PinvsValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7103PinvsValidationsConfig.class, PPIPM);

    public static final BaseMetadataValidation<E7103PinvsValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7103PinvsValidationsConfig.class, DPLK);

}
