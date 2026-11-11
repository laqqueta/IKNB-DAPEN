package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1268JenisInvestasi;
import id.go.ojk.metadata.module.lblt.reference.ER7039PosLtlbDppkPnyl;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7016PosLtlbDppkSbn.R_SBN010000;
import static id.go.ojk.metadata.module.lblt.reference.ER7016PosLtlbDppkSbn.R_SBN020000;
import static id.go.ojk.metadata.module.lblt.reference.ER7039PosLtlbDppkPnyl.R_PNYL000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7039PosLtlbDppkPnyl.R_PNYL010000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7039PnylValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("9|11|15|16|21|30", R_PNYL000000.key, R_PNYL010000.key,
                    UtilMetadata.genMessageTotal(R_PNYL000000.value, R_PNYL010000.value))),

    SG_EQUAL_FORMULA_GABUNGAN(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN("10|12|16|17|22|31", R_PNYL000000.key, R_PNYL010000.key,
                    UtilMetadata.genMessageTotal(R_PNYL000000.value, R_PNYL010000.value))),

    FV_EQUAL_NILAI(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(16),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("15-11", R_PNYL000000.key)),

    FV_EQUAL_NILAI_GABUNGAN(programs(PPMPPPIPK), validationFields(16),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("16-12", R_PNYL000000.key)),

    FV_EQUAL_RATIO(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(17),
            () -> UtilFieldValidation.genEqualsPosRatio("16|11", R_PNYL010000.key)),

    FV_EQUAL_RATIO_GABUNGAN(programs(PPMPPPIPK), validationFields(17),
            () -> UtilFieldValidation.genEqualsPosRatio("17|12", R_PNYL010000.key)),

    FV_FIXED_PERSENTASE_V(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(28),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(22, 28), R_PNYL010000.key, "100.00")),

    FV_FIXED_PERSENTASE_V_GABUNGAN(programs(PPMPPPIPK), validationFields(28),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(23, 29), R_PNYL010000.key, "100.00")),

    FV_FIXED_PERSENTASE_E1(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(36),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(31, 36), R_PNYL010000.key, "100.00")),

    FV_FIXED_PERSENTASE_E1_GABUNGAN(programs(PPMPPPIPK), validationFields(36),
            () -> UtilFieldValidation.genEqualsPosFormulaFixedValue(
                    UtilMetadata.genPlusColumn(32, 37), R_PNYL010000.key, "100.00")),

    CR_EXISTS_POS_TOTAL(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            validationFields(UtilMetadata.genDelimitedColumnExcept(2, 37, new int[] { 9,11,15,16,21 }, ",")),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PNYL000000.key)),

    CR_EXISTS_POS_TOTAL_GABUNGAN(programs(PPMPPPIPK),
            validationFields(UtilMetadata.genDelimitedColumnExcept(2, 37, new int[] { 10,12,16,17,22 }, ",")),
            () -> UtilFieldConditional.genExistPos("N", "M", R_PNYL000000.key)),

    CR_HAS_VALUE_NAMA_PERUSAHAAN(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(29),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmpty("O", "N", "N",
                    R_PNYL010000.key, "2")),

    CR_HAS_VALUE_ANAK_PERUSAHAAN_DETIL(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(31,32,33,34,35,36,37),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "N", "N",
                    R_PNYL010000.key, "29")),

    CR_HAS_VALUE_ANAK_PERUSAHAAN_DETIL_TOTAL(programs(PPMPK, PPMPM, PPIPK, PPIPM), validationFields(30),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDapenVer2(
                    "M", "N", R_PNYL010000.key,
                    "M", R_PNYL000000.key, "N",
                    "29")),

    CR_HAS_VALUE_NAMA_PERUSAHAAN_GABUNGAN(programs(PPMPPPIPK), validationFields(29),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmpty("O", "N", "N",
                    R_PNYL010000.key, "3")),

    CR_HAS_VALUE_ANAK_PERUSAHAAN_DETIL_GABUNGAN(programs(PPMPPPIPK), validationFields(31,32,33,34,35,36,37),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmpty("M", "N", "N",
                    R_PNYL010000.key, "30")),

    CR_HAS_VALUE_ANAK_PERUSAHAAN_DETIL_TOTAL_GABUNGAN(programs(PPMPPPIPK), validationFields(30),
            () -> UtilFieldConditional.genExistPosAndComparatorNotEmptyDapenVer2(
                    "M", "N", R_PNYL010000.key,
                    "M", R_PNYL000000.key, "N",
                    "30")),

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

    public static BaseMetadataValidation<E7039PnylValidationsConfig> getValidationMetadata(ProgramType programType) {
        return new LbltMetadataValidation<>(E7039PnylValidationsConfig.class, programType);
    }


}
