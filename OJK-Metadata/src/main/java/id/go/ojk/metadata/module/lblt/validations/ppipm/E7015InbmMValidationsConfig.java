package id.go.ojk.metadata.module.lblt.validations.ppipm;

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

import static id.go.ojk.metadata.module.lblt.reference.ER7015PosLtlbDppkInbm.R_INBM000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7015PosLtlbDppkInbm.R_INBM010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7015InbmMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("4", R_INBM000000.key, R_INBM010000.key,
                    UtilMetadata.genMessageTotal(R_INBM000000.value, R_INBM010000.value))),

    SG_ROW_VALIDATION(programs(PPIPM),
            () -> UtilSegmentValidationV2.genEqualsInvestasiRatio("5", R_INBM010000.key,
                    R_INBM010000.key, "4", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "3",
                    UtilMetadata.genMessage(R_INBM010000.value, R_INBM010000.value + " / Baris 'TOTAL INVESTASI' (Piutang Investasi) pada form LAN"), 2)),

    CR_EXIST_POS_M(programs(PPIPM), validationFields(2,3,5,6),
            () -> UtilFieldConditional.genExistPos("N", "M", R_INBM000000.key)),

    CR_EXIST_POS_O(programs(PPIPM), validationFields(7),
            () -> UtilFieldConditional.genExistPos("N", "O", R_INBM000000.key)),

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

    public static final BaseMetadataValidation<E7015InbmMValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7015InbmMValidationsConfig.class, PPIPM);

}
