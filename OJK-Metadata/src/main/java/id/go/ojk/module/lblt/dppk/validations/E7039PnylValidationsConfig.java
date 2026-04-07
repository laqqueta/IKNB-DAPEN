package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl.R_PNYL000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl.R_PNYL010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7039PnylValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("9|11|15|16|21|30", R_PNYL000000.key, R_PNYL010000.key,
                    UtilMetadata.genMessageTotal(R_PNYL000000.value, R_PNYL010000.value))),

    FV_EQUAL_NILAI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("15-11", R_PNYL000000.key)),

    FV_EQUAL_RATIO(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPosRatio("16|11", R_PNYL010000.key)),

    FV_FIXED_PERSENTASE_V(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(22, 28), R_PNYL010000.key,
                    "100")),

    FV_FIXED_PERSENTASE_E1(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(31, 36), R_PNYL010000.key,
                    "100")),

    CR_EXISTS_POS_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PNYL000000.key)),

    CR_HAS_VALUE_NAMA_PERUSAHAAN(programs(PPMPK),
            () -> UtilFieldConditional.genHasValue("2", "N", "M")),

    CR_HAS_VALUE_ANAK_PERUSAHAAN(programs(PPMPK),
            () -> UtilFieldConditional.genHasValue("29", "N", "M")),

    CR_HAS_VALUE_EXCEPT_POS_ANAK_PERUSAHAAN(programs(PPMPK),
            () -> UtilFieldConditional.genHasValueExceptPos("29", "N", "M", R_PNYL000000.key)),

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
        return METADATA.toSegmentValidation(this);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return METADATA.toFieldValidation(this);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return METADATA.toFieldConditional(this);
    }

    public static final BaseMetadataValidation<E7039PnylValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, PPMPK);

}
