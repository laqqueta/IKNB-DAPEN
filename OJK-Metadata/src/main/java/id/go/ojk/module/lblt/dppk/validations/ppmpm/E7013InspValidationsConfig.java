package id.go.ojk.module.lblt.dppk.validations.ppmpm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7013PosLtlbDppkInsp.R_INSP000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7013PosLtlbDppkInsp.R_INSP010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7013InspValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("4", R_INSP000000.key, R_INSP010000.key,
                    UtilMetadata.genMessageTotal(R_INSP000000.value, R_INSP010000.value))),

    SG_EQUAL_INVESTASI_RATIO(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsInvestasiRatio("5", R_INSP010000.key,
                    R_INSP010000.key, "4", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "13",
                    UtilMetadata.genMessage(R_INSP010000.value, R_INSP010000.value + "/ Total Investasi (Gabungan) pada form LAN"), 2)),

    CR_EXIST_POS_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_INSP000000.key)),

    CR_EXIST_POS_O(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_INSP000000.key)),

    ;

    private final EnumSet<ProgramType> programTypes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
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

    public static final BaseMetadataValidation<E7013InspValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7013InspValidationsConfig.class, PPMPK);

}
