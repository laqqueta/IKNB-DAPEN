package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.dppk.field.Dppk0101Roimpl;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7011PosLtlbDppkRoism;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7101PosLtlbDppkRoimpl;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7011PosLtlbDppkRoism.R_ROISM2100000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7101PosLtlbDppkRoimpl.R_ROIMPL1200000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7101PosLtlbDppkRoimpl.R_ROIMPL2100000000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7101RoimplValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_FIELD_VALIDATION_1(programs(PPIPK),
            validationFields(Dppk0101Roimpl.HASIL_INVESTASI_BERSIH),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7) + "-8")),

    FV_FIELD_VALIDATION_2(programs(PPIPK),
            validationFields(Dppk0101Roimpl.ROI),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("9/10", R_ROIMPL2100000000.key)),

    SG_SUM_POS_COL_EQUAL(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 11), R_ROIMPL2100000000.key,
                    UtilMetadata.genPlusRow(ER7101PosLtlbDppkRoimpl.getObjects(), 0, 19),
                    UtilMetadata.genMessage(R_ROIMPL2100000000.value,
                            UtilMetadata.genPlusDesc(ER7101PosLtlbDppkRoimpl.getObjects(), 0, 19)))),

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

    public static final BaseMetadataValidation<E7101RoimplValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7101RoimplValidationsConfig.class, PPIPK);

}
