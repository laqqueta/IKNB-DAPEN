package id.go.ojk.metadata.module.lblt.validations.dplk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.ER7001PosLtlbDppkLan;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7013PosLtlbDppkInsp.R_INSP000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7013PosLtlbDppkInsp.R_INSP010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor

public enum E7013InspKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("4", R_INSP000000.key, R_INSP010000.key,
                    UtilMetadata.genMessageTotal(R_INSP000000.value, R_INSP010000.value))),

    SG_EQUAL_INVESTASI_RATIO(programs(DPLK),
            () -> UtilSegmentValidationV2.genEqualsInvestasiRatio("5", R_INSP010000.key,
                    R_INSP010000.key, "4", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "3",
                    UtilMetadata.genMessage(R_INSP010000.value, R_INSP010000.value + " / 'TOTAL INVESTASI' Manfaat Pensiun pada form LAN"), 2)),

    CR_EXIST_POS_M(programs(DPLK), validationFields(2,3,5,6,7),
            () -> UtilFieldConditional.genExistPos("N", "M", R_INSP000000.key)),

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

    public static final BaseMetadataValidation<E7013InspKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7013InspKValidationsConfig.class, DPLK);

}
