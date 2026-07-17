package id.go.ojk.conf.client;

import id.go.ojk.client.model.config.validation.segmen.v2.*;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import org.apache.commons.lang3.StringUtils;

public class UtilSegmentValidationV2 {

    public static SegmentValidation genEqualsFormColumCalculation(String selectField, String selectPosCode,
                                                                  String comparatorColumn, String comparatorRowCode, String comparatorForm, String message, int scale) {

        String builder = "selectField=" + selectField + "&selectPosCode=" + selectPosCode +
                "&comparatorColumn=" + comparatorColumn +
                "&comparatorRowCode=" + comparatorRowCode +
                "&comparatorForm=" + comparatorForm +
                "&scale=" + scale +
                "&message=" + message;

        return new EqualsFormColumnCalculate(builder);
    }

    public static SegmentValidation genEqualsFormConditionalExpression2(String selectField, String selectPosCode, String selectExpr,
                                                                        String comparatorForm, String comparatorField, String comparatorPosCode, String comparatorExpr, String operator,
                                                                        int scale, String msgError) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=").append(selectPosCode);
        builder.append("&selectExpr=").append(selectExpr);
        builder.append("&comparatorForm=").append(comparatorForm);
        builder.append("&comparatorField=").append(comparatorField);
        builder.append("&comparatorPosCode=").append(comparatorPosCode);
        builder.append("&comparatorExpr=").append(comparatorExpr);
        builder.append("&operator=").append(operator);
        builder.append("&scale=").append(scale);
        if (StringUtils.isNotBlank(msgError)) {
            builder.append("&msgError=").append(msgError);
        }
        return new ComparisonFormConditionalExpressionValidationDppk(builder.toString());
    }

    public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
                                                  String comparatorField, String comparatorPosCode, String msgError, int scale) {

        String builder = "selectField=" + selectField + "&selectPosCode=" + selectPosCode +
                "&comparatorForm=" + comparatorForm +
                "&comparatorField=" + comparatorField +
                "&comparatorPosCode=" + comparatorPosCode +
                "&operator=e" +
                "&scale=" + scale +
                "&msgError=" + msgError;

        return new ComparisonFormValidationV2(builder);
    }

    public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
                                                  String comparatorField, String comparatorPosCode) {
        return genEqualsForm(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, "", 2);
    }

    public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
                                                  String comparatorField, String comparatorPosCode, String msgError) {
        return genEqualsForm(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, msgError, 2);
    }

    public static SegmentValidation genEqualsFormExpression(String selectField, String selectPosCode, String selectExpr,
                                                            String comparatorForm, String comparatorField, String comparatorPosCode, String comparatorExpr, String operator,
                                                            int scale, String msgError) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        if (StringUtils.isNotBlank(selectExpr)) {
            builder.append("&selectExpr=" + selectExpr);
        }
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorField=" + comparatorField);
        builder.append("&comparatorPosCode=" + comparatorPosCode);
        if (StringUtils.isNotBlank(comparatorExpr)) {
            builder.append("&comparatorExpr=" + comparatorExpr);
        }
        builder.append("&operator=" + operator);
        builder.append("&scale=" + scale);
        if (StringUtils.isNotBlank(msgError)) {
            builder.append("&msgError=" + msgError);
        }
        return new ComparisonFormExpressionValidation(builder.toString());
    }

    public static SegmentValidation genEqualsFormulaFormV2(String selectField, String selectPosCode, String comparatorForm,
                                                           String comparatorField, String comparatorPosCode, String msgError, int scale) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorField=" + comparatorField);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorPosCode=" + comparatorPosCode);
        builder.append("&operator=e");
        builder.append("&scale=" + scale);
        builder.append("&msgError=" + msgError);
        return new ComparisonFormulaFormValidationV2(builder.toString());
    }

    public static SegmentValidation genEqualsInvestasiRatio(String selectField, String selectPosCode,
                                                            String comparator1RowCode, String comparator1FieldRow,
                                                            String comparator2Form, String comparator2RowCode, String comparator2FieldRow,
                                                            String message, int scale) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparator1RowCode=" + comparator1RowCode);
        builder.append("&comparator1FieldRow=" + comparator1FieldRow);
        builder.append("&comparator2Form=" + comparator2Form);
        builder.append("&comparator2RowCode=" + comparator2RowCode);
        builder.append("&comparator2FieldRow=" + comparator2FieldRow);
        builder.append("&scale=" + scale);
        builder.append("&message=" + message);
        return new EqualsInvestasiRatioValidation(builder.toString());
    }

    public static SegmentValidation genEqualsSbnRatio(String selectField, String selectPosCode,
                                                      String comparator1RowCode, String comparator1FieldRow,
                                                      String comparator2Form, String comparator2RowCode, String comparator2FieldRow,
                                                      String message, int scale) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparator1RowCode=" + comparator1RowCode);
        builder.append("&comparator1Field=" + comparator1FieldRow);
        builder.append("&comparator2Form=" + comparator2Form);
        builder.append("&comparator2RowCode=" + comparator2RowCode);
        builder.append("&comparator2Field=" + comparator2FieldRow);
        builder.append("&scale=" + scale);
        builder.append("&message=" + message);
        return new EqualsRatioFormSbnValidation(builder.toString());
    }

    public static SegmentValidation genFormulaParserValidationV2(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr, int scale) {

        String sb = "selectField=" + selectFields +
                "&selectPosCode=" + selectPosCodes +
                "&formulaOperation=" + formulaOperation +
                "&formulaOperationErr=" + formulaOperationErr +
                "&scale=" + scale;

        return new FormulaParserValidation(sb);
    }

    public static SegmentValidation genFormulaParserValidationV2PeriodePelaporan(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr, int scale) {

        String sb = "selectField=" + selectFields +
                "&selectPosCode=" + selectPosCodes +
                "&formulaOperation=" + formulaOperation +
                "&formulaOperationErr=" + formulaOperationErr +
                "&scale=" + scale;

        return new FormulaParserPeriodePelaporanValidation(sb);
    }

    public static SegmentValidation genFormulaParserValidationV2PeriodeAudit(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr, String auditRow, String auditCol, String comparatorForm, int scale) {

        String sb = "selectField=" + selectFields +
                "&selectPosCode=" + selectPosCodes +
                "&formulaOperation=" + formulaOperation +
                "&auditRow=" + auditRow +
                "&auditCol=" + auditCol +
                "&formComparator=" + comparatorForm +
                "&formulaOperationErr=" + formulaOperationErr +
                "&scale=" + scale;

        return new FormulaParserTanggalAuditValidation(sb);
    }

    public static SegmentValidation genFormulaParserAvgValidation(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr, int division, int scale) {

        String sb = "selectField=" + selectFields +
                "&selectPosCode=" + selectPosCodes +
                "&formulaOperation=" + formulaOperation +
                "&formulaOperationErr=" + formulaOperationErr +
                "&avgDivision=" + division +
                "&scale=" + scale;

        return new FormulaParserAvgValidation(sb);
    }

    public static SegmentValidation genFormulaParserValidationV2(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr) {
        return genFormulaParserValidationV2(selectFields, selectPosCodes, formulaOperation, formulaOperationErr, 2);
    }

    public static SegmentValidation genFormulaParserlRekinvPeriodePelaporan(String selectFields, String selectPosCodes, String formulaOperation, String formulaOperationErr, int scale) {
        String sb = "selectField=" + selectFields +
                "&selectPosCode=" + selectPosCodes +
                "&formulaOperation=" + formulaOperation +
                "&formulaOperationErr=" + formulaOperationErr +
                "&scale=" + scale;

        return new FormulaParserRekinvPeriodPelaporanValidation(sb);
    }

    public static SegmentValidation genSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                             String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                             String msgError, String conditionError, String sumConditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        return new SumIfFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                             String formRangeField, String formCriteriaField, String criteriaCondition,
                                             String msgError, String conditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        return new SumIfFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                             String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                             String msgError, String conditionError, String sumConditionError, String multiRangeFieldErr) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        builder.append("&multiRangeFieldErr=" + multiRangeFieldErr);
        return new SumIfFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIfOffset(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                             String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                             String msgError, String conditionError, String sumConditionError, String multiRangeFieldErr) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        builder.append("&multiRangeFieldErr=" + multiRangeFieldErr);
        return new SumIfOffsetFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIfMultiField(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                       String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                                       String msgError, String conditionError, String sumConditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        return new SumIfMultiFieldFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIfSpecField(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                      String formRangeField, String formCriteriaField, String sumField, String specField, String condSpec, String criteriaCondition, String sumCriteriaCondition,
                                                      String msgError, String conditionError, String sumConditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&fieldSpec=" + specField);
        builder.append("&conditionSpec=" + condSpec);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        return new SumIfMultiSpecFieldFormValidation(builder.toString());
    }

    public static SegmentValidation genSumIfSpecForm(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                     String formRangeField, String formCriteriaField, String sumField, String specField, String condSpec,
                                                     String criteriaSpecField, String formSpec, String formRowSpec, String criteriaCondition, String sumCriteriaCondition,
                                                     String msgError, String conditionError, String sumConditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&fieldSpec=" + specField);
        builder.append("&conditionSpec=" + condSpec);
        builder.append("&criteriaSpecField=" + criteriaSpecField);
        builder.append("&formSpec=" + formSpec);
        builder.append("&formRowSpec=" + formRowSpec);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        return new SumIfMultiSpecFormFormValidation(builder.toString());
    }

    public static SegmentValidation genMultiFormSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                      String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                                      String msgError, String conditionError, String sumConditionError) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        return new MultiFormSumIfFormValidation(builder.toString());
    }

    public static SegmentValidation genMultiCriteriaSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                          String formRangeField, String formCriteriaField, String sumField, String criteriaCondition, String sumCriteriaCondition,
                                                          String msgError, String conditionError, String sumConditionError, String key) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        builder.append("&criteriaAsKey=" + key);
        return new SumIfMultiCriteriaFormValidation(builder.toString());
    }

    public static SegmentValidation genMultiSpecFieldCriteriaSumIf(String selectField, String selectPosCode, String comparatorForm, String comparatorRow,
                                                                   String formRangeField, String formCriteriaField, String sumField, String fieldSpec, String conditionSpec, String criteriaCondition, String sumCriteriaCondition,
                                                                   String msgError, String conditionError, String sumConditionError, String key) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&rangeField=" + formRangeField);
        builder.append("&criteriaField=" + formCriteriaField);
        builder.append("&sumField=" + sumField);
        builder.append("&fieldSpec=" + fieldSpec);
        builder.append("&conditionSpec=" + conditionSpec);
        builder.append("&criteriaCondition=" + criteriaCondition);
        builder.append("&sumCriteriaCondition=" + sumCriteriaCondition);
        builder.append("&msgError=" + msgError);
        builder.append("&criteriaConditionError=" + conditionError);
        builder.append("&sumConditionError=" + sumConditionError);
        builder.append("&criteriaAsKey=" + key);
        return new SumIfMultiSpecFieldCriteriaFormValidation(builder.toString());
    }

    public static SegmentValidation genGeoMeanInvestasi(String selectField, String selectPosCode,
                                                        String comparatorForm, String comparatorRow, String comparatorField,
                                                        String msgError, String msgErrorRow) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorRow=" + comparatorRow);
        builder.append("&comparatorField=" + comparatorField);
        builder.append("&msgError=" + msgError);
        builder.append("&msgErrorRow=" + msgErrorRow);
        return new GeoMeanInvestasiFormValidation(builder.toString());
    }

    public static SegmentValidation genOperatorProyeksi(String selectField, String selectPosCode,
                                                        String operatorComparation, String comparationValue, String defaultValue) {

        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&operatorComparation=" + operatorComparation);
        builder.append("&comparationValue=" + comparationValue);
        builder.append("&defaultValue=" + defaultValue);
        return new OperatorComparationValidation(builder.toString());
    }
}
