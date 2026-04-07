package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7023PosLtlbDppkDpjka.R_DPJKA000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7024PosLtlbDppkDpjkv.R_DPJKV000000;
import static id.go.ojk.module.lblt.dppk.reference.ER7024PosLtlbDppkDpjkv.R_DPJKV010000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7024DpjkvValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_DPJKV000000_DPJKV010000(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("6|7|8", R_DPJKV000000.key, R_DPJKV010000.key,
                    UtilMetadata.genMessageTotal(R_DPJKV000000.value, R_DPJKV010000.value))),

    FV_EQUAL_NILAI_INVESATSI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("7-6", R_DPJKV000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("8/7", R_DPJKV000000.key)),

    CR_EXISTS_DPJKA000000_M(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_DPJKA000000.key)),

    CR_EXISTS_DPJKA000000_O(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "O", R_DPJKA000000.key)),

    CR_EQUAL_NAMA_PENGELOLA(programs(PPMPK),
            () -> UtilFieldConditional.genEqualsExceptPos("O", "M", "13",
                    ER1252Pengelolaan.getReferenceIndex(0), R_DPJKV000000.key)),

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

    public static final BaseMetadataValidation<E7024DpjkvValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7024DpjkvValidationsConfig.class, PPMPK);

}
