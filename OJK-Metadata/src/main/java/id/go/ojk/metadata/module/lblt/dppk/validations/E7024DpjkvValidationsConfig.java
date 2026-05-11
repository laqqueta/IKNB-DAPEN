package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1252Pengelolaan;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7023PosLtlbDppkDpjka.R_DPJKA010000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7024PosLtlbDppkDpjkv.R_DPJKV000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7024PosLtlbDppkDpjkv.R_DPJKV010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7024DpjkvValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_DPJKV000000_DPJKV010000(programs(PPMPK, PPMPM),
            () -> UtilSegmentValidation.genEqualsFormula("6|7|8", R_DPJKV000000.key, R_DPJKV010000.key,
                    UtilMetadata.genMessageTotal(R_DPJKV000000.value, R_DPJKV010000.value))),

    FV_EQUAL_NILAI_INVESATSI(programs(PPMPK, PPMPM), validationFields(8),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("7-6", R_DPJKV000000.key)),

    FV_EQUAL_PERSENTASE_INVESTASI(programs(PPMPK, PPMPM), validationFields(9),
            () -> UtilFieldValidation.genEqualsPercentageExceptPosFormula("8/7", R_DPJKV000000.key)),

    CR_EXISTS_DPJKA000000_M(programs(PPMPK, PPMPM), validationFields(2, 5, 9, 10, 11, 12, 13, 15),
            () -> UtilFieldConditional.genExistPos("N", "M", R_DPJKV000000.key)),

    CR_EXISTS_DPJKA000000_O(programs(PPMPK, PPMPM), validationFields(3, 4, 16),
            () -> UtilFieldConditional.genExistPos("N", "O", R_DPJKV000000.key)),

    CR_EQUAL_NAMA_PENGELOLA(programs(PPMPK, PPMPM), validationFields(14),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("O", "M", "N",
                    R_DPJKV010000.key, "13", ER1252Pengelolaan.getReferenceIndex(0))),

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

    public static final BaseMetadataValidation<E7024DpjkvValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7024DpjkvValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7024DpjkvValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7024DpjkvValidationsConfig.class, PPMPM);

}
