package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl.R_PNYL000000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl.R_PNYL010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7039PnylValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM, PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula("9|11|15|16|21|30", R_PNYL000000.key, R_PNYL010000.key,
                    UtilMetadata.genMessageTotal(R_PNYL000000.value, R_PNYL010000.value))),

    FV_EQUAL_NILAI(programs(PPMPK, PPMPM, PPIPK), validationFields(16),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("15-11", R_PNYL000000.key)),

    FV_EQUAL_RATIO(programs(PPMPK, PPMPM, PPIPK), validationFields(17),
            () -> UtilFieldValidation.genEqualsPosRatio("16|11", R_PNYL010000.key)),

    FV_FIXED_PERSENTASE_V(programs(PPMPK, PPMPM, PPIPK), validationFields(28),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(22, 28), R_PNYL010000.key, "100.00")),

    FV_FIXED_PERSENTASE_E1(programs(PPMPK, PPMPM, PPIPK), validationFields(36),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(31, 36), R_PNYL010000.key, "100.00")),

    CR_EXISTS_POS_TOTAL(programs(PPMPK, PPMPM, PPIPK),
            validationFields(UtilMetadata.genDelimitedColumnExcept(2, 37, new int[] { 9,11,15,16,21,30 }, ",")),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PNYL000000.key)),

//    CR_HAS_VALUE_NAMA_PERUSAHAAN_DETIL(programs(PPMPK, PPMPM, PPIPK), validationFields(3,4,5,6,7,8,10,12,13,14,17,18,19,22,23,24,25,26,27,28,29),
//            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDAPENVer("M", "N", "N",
//                    R_PNYL010000.key, "2")),
//
//    CR_HAS_VALUE_NAMA_PERUSAHAAN_TOTAL(programs(PPMPK, PPMPM, PPIPK), validationFields(9,11,15,16,21),
//            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDAPENVer("M", "N", "M",
//                    R_PNYL010000.key, "2")),
//
//    CR_HAS_VALUE_ANAK_PERUSAHAAN_DETIL(programs(PPMPK, PPMPM, PPIPK), validationFields(31,32,33,34,35,36,37),
//            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDAPENVer("M", "N", "N",
//                    R_PNYL010000.key, "29")),
//
//    CR_HAS_VALUE_ANAK_PERUSAHAAN_TOTAL(programs(PPMPK, PPMPM, PPIPK), validationFields(30),
//            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDAPENVer("M", "N", "M",
//                    R_PNYL010000.key, "29")),

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

    public static final BaseMetadataValidation<E7039PnylValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, PPMPK);

    public static final BaseMetadataValidation<E7039PnylValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, PPMPM);

    public static final BaseMetadataValidation<E7039PnylValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, PPIPK);

    public static final BaseMetadataValidation<E7039PnylValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, PPIPM);

}
