package id.go.ojk.metadata.module.lblt.validations.dplk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.*;
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

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.field.Dppk0012Alm.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7012PosLtlbDppkAlm.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7012AlmKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 0, 19),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 0, 19)))),

    SG_EQUAL_FORMULA_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0206000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 21, 25),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0206000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 21, 25)))),

    SG_EQUAL_FORMULA_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0300000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[] {20, 26}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0300000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[] {20, 26})))),

    SG_EQUAL_FORMULA_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0404000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 28, 30),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0404000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 28, 30)))),

    SG_EQUAL_FORMULA_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0507000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 32, 37),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0507000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 32, 37)))),

    SG_EQUAL_FORMULA_6(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{31, 38}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{31, 38})))),

    SG_EQUAL_FORMULA_7(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0700000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{27, 39}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0700000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{27, 39})))),

    FV_TOTAL1_EQUAL(programs(DPLK), validationFields(JT_LT_1_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+3",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL2_EQUAL(programs(DPLK), validationFields(JT_1_5_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5+6",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL3_EQUAL(programs(DPLK), validationFields(JT_5_10_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8+9",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL4_EQUAL(programs(DPLK), validationFields(JT_GTE_10_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL5_EQUAL(programs(DPLK), validationFields(TOTAL_RUPIAH),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL6_EQUAL(programs(DPLK), validationFields(TOTAL_NON_RUPIAH),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

    FV_TOTAL7_EQUAL(programs(DPLK), validationFields(TOTAL_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14+15",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40}))),

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

    public static final BaseMetadataValidation<E7012AlmKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7012AlmKValidationsConfig.class, DPLK);

    private static SegmentValidation genTotalValidation(String selectPosCode,
                                                        EFormLaporanBulananTahunan comparatorForm,
                                                        List<KeyValueString> formObject,
                                                        String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "1", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total'" + " Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("16", selectPosCode, operation2.getFormula(),
                errMsg);
    }

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg, String keys) {

        String criteriaCondition = ER1250Properti.getKey(keys);
        String criteriaConditionErr = ER1250Properti.getKeyValue(keys)
                .replace("&", "dan");

        return UtilSegmentValidationV2.genSumIf("16", posCode,
                formCode, formObjects,
                rangeField, criteriaField, criteriaCondition,
                errMsg, criteriaConditionErr);
    }
}
