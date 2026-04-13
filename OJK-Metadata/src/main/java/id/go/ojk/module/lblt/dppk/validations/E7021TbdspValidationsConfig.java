package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7021PosLtlbDppkTbdsp.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7021TbdspValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_MITRA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("3", R_TBDSP0202020000.key, R_TBDSP0202010000.key,
                    UtilMetadata.genMessageTotal(R_TBDSP0202020000.value, R_TBDSP0202010000.value))),

    SG_SUM_PENERIMA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("3", R_TBDSP0303000000.key, R_TBDSP0301000000.key,
                    UtilMetadata.genMessageTotal(R_TBDSP0303000000.value, R_TBDSP0301000000.value))),

    SG_SALDO_AKHIR(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("3", R_TBDSP0400000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 3, 8 }),
                    UtilMetadata.genMessageTotal(R_TBDSP0400000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 0, 3, 8 })))),

    CR_EMPTY(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 8 }))),

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

    public static final BaseMetadataValidation<E7021TbdspValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7021TbdspValidationsConfig.class, PPMPK);

}
