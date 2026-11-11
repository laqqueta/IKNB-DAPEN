package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.*;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.field.Dppk0017Ras1;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1GabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    // PPMP VALIDATIONS

    SG_MULTI_SUM_RAS10101000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6-14", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6-14", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6-14", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10101000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_RAS10102000000_A_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7010PosLtlbDppkRoiml.R_ROIML2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROIML";
        return UtilSegmentValidationV2.genEqualsForm("5", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI_ML.getCode(), "11", comparatorPosCode.getKey(),
                "2", "PPMP",
                errMsg, 2);
    }),

    SG_RAS10102000000_B_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROI";
        return UtilSegmentValidationV2.genEqualsForm("6", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "11", comparatorPosCode.getKey(),
                "2", "PPMP",
                errMsg, 2);
    }),

    SG_MULTI_SUM_RAS10201000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+11", "3", comparatorForm),
                genFormulaParser(formObject, "14+15+16", "3", comparatorForm)
        }, "-");

        FormulaParserData operation3 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "4+5+6", comparatorForm),
                genFormulaParser(formObject, "11", "4+5+6", comparatorForm),
                genFormulaParser(formObject, "14+15+16", "4+5+6", comparatorForm)
        }, "+#-");

        FormulaParserData operation4 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "7+8+9+10+11+12", comparatorForm),
                genFormulaParser(formObject, "11", "7+8+9+10+11+12", comparatorForm),
                genFormulaParser(formObject, "14+15+16", "7+8+9+10+11+12", comparatorForm)
        }, "+#-");

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10201000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_AVG_REKINV_RAS10202000000_A_PPMP(programs(PPMPPPIPK), () -> {
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2400000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("4", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPMP",
                2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_B_PPMP(programs(PPMPPPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2300000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("5", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPMP",
                2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_C_PPMP(programs(PPMPPPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("6", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPMP",
                2, errMsg);
    }),

    SG_MULTI_SUM_RAS10301000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "15", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "15", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "15", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10301000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+11", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+11", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+11", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10302000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10501000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "15", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "15", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "15", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10501000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10502000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "38", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "38", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "38", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10502000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10701000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24+25", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24+25", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24+25", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode Bulan Berjalan pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("3|4|5", R_RAS10701000000.key, operationForm,
                "2", "PPMP",
                operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10702000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "7+8+9+10", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "7+8+9", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "7+8+9+10", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10702000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10801000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10801000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10802000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10802000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10901000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "27+28", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "27+28", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "27+28", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10901000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10902000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10902000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11001000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11001000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11101000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11101000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11102000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11102000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11201000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form NRC" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form NRC";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11201000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11202000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11202000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11301000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+21", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+21", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11301000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    //RAS11302000000
    SG_MULTI_SUM_RAS11302000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14+15+17", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14+15+17", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14+15+17", "7+8+9+10+11+12", comparatorForm);
        String addMsg = " * Periode laporan bulan berjalan";
        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun" + addMsg + " pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya" + addMsg + " pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain" + addMsg + " pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("3|4|5", R_RAS11302000000.key, operationForm,
                "2", "PPMP",
                operationFormErr, 2);
    }),

    //RAS11401000000
    SG_MULTI_SUM_RAS11401000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 11, 13, 15, 19, 20, 21, 22, 23});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11401000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    //RAS11402000000
    SG_MULTI_SUM_RAS11402000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 12, 14, 16, 17, 24, 25, 26});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11402000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11501000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24+25", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24+25", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24+25", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11501000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11502000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11502000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11601000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "5+6+7", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "8+9+10+11+12+13", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11601000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),
    
    SG_MULTI_SUM_RAS11701000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "8+11+14", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS11701000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11702000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK), "0+1+2+3+15", "3", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS11702000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11801000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6+8+25", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6+8+25", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6+8+25", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11801000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11802000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+15", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+3+15", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+3+15", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11802000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11902000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();
        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "17", "4", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "17", "5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "17", "6", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Nilai Program Manfaat Pensiun pada form KUP" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Nilai Program Manfaat Pensiun Lainnya pada form KUP" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Nilai Program Manfaat Lain pada form KUP";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11902000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS12010000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "39", "5", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS12010000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "39", "17", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS12020000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS13010000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "5", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS13010000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS13020000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "17", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS13020000000.key, operationForm.getFormula(),
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS14010000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14+15", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14+15", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14+15", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS14010000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS14020000000_PPMP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS14020000000.key, operationForm,
                "2", "PPMP",
                operationFormErr);
    }),

    // PPIP VALIDATIONS

    SG_MULTI_SUM_RAS10101000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6-13", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6-13", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6-13", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10101000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_RAS10102000000_A_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7010PosLtlbDppkRoiml.R_ROIML2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROIML";
        return UtilSegmentValidationV2.genEqualsForm("5", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI_ML.getCode(), "11", comparatorPosCode.getKey(),
                "2", "PPIP",
                errMsg, 2);
    }),

    SG_RAS10102000000_B_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROI";
        return UtilSegmentValidationV2.genEqualsForm("6", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "11", comparatorPosCode.getKey(),
                "2", "PPIP",
                errMsg, 2);
    }),

    SG_MULTI_SUM_RAS10201000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+10", "3+14", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "3+14", comparatorForm)
        }, "-");

        FormulaParserData operation3 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "4+5+6+15", comparatorForm),
                genFormulaParser(formObject, "10", "4+5+6+15", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "4+5+6+15", comparatorForm)
        }, "+#-");

        FormulaParserData operation4 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "7+8+9+10+11+12+16", comparatorForm),
                genFormulaParser(formObject, "10", "7+8+9+10+11+12+16", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "7+8+9+10+11+12+16", comparatorForm)
        }, "+#-");

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10201000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_AVG_REKINV_RAS10202000000_A_PPIP(programs(PPMPPPIPK), () -> {
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2400000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("4", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPIP",
                2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_B_PPIP(programs(PPMPPPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2300000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("5", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPIP",
                2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_C_PPIP(programs(PPMPPPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(3, 14);
        String comparatorExpr = "/13";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("6", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e",
                "2", "PPIP",
                2, errMsg);
    }),

    SG_MULTI_SUM_RAS10301000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10301000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+10", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+10", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+10", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10302000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10501000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10501000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10502000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "38", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "38", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "38", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10502000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10701000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24+25", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24+25", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24+25", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode Bulan Berjalan pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("3|4|5", R_RAS10701000000.key, operationForm,
                "2", "PPIP",
                operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10702000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "7+8+9", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "7+8+9", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "7+8+9", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10702000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10801000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10801000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10802000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10802000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10901000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "27+28", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "27+28", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "27+28", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10901000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS10902000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS10902000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11001000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11001000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11101000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11101000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11102000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11102000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11201000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form NRC" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form NRC";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11201000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11202000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11202000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11301000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+21", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+21", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11301000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    //RAS11302000000
    SG_MULTI_SUM_RAS11302000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "13+14+16", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "13+14+16", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "13+14+16", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode bulan berjalan pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("3|4|5", R_RAS11302000000.key, operationForm,
                "2", "PPIP",
                operationFormErr, 2);
    }),

    //RAS11401000000
    SG_MULTI_SUM_RAS11401000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 11, 13, 15, 19, 20, 21, 22, 23});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11401000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    //RAS11402000000
    SG_MULTI_SUM_RAS11402000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 12, 14, 16, 17, 24, 25, 26});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11402000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11501000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24+25", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24+25", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24+25", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11501000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11502000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11502000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11601000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "4+15", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "5+6+7+16", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "8+9+10+11+12+13+17", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11601000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11701000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "8+11+14", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS11701000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11702000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK), "0+1+2+3+15", "3+14", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS11702000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11801000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6+8+25", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6+8+25", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6+8+25", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11801000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11802000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+15", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+3+15", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+3+15", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS11802000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS11901000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_RAS_1.getCode();
        List<KeyValueString> formObject = ER7017PosLtlbDppkRas1.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "2", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "2", "4", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "2", "5", comparatorForm);
        FormulaParserData operation5 = genFormulaParser(formObject, "2", "6", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula() + "|" + operation5.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain" + "|" +
                "sama dengan Baris " + operation5.getErrMessage() + " Total";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5|6", R_RAS11901000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS12010000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "39", "5", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS12010000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "39", "17", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS12020000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS13010000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "5", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS13010000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS13020000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPPPIPK), "49", "17", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("3", R_RAS13020000000.key, operationForm.getFormula(),
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS14010000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "13+14", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "13+14", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "13+14", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS14010000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),

    SG_MULTI_SUM_RAS14020000000_PPIP(programs(PPMPPPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "3+14", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "4+5+6+15", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "7+8+9+10+11+12+16", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("3|4|5", R_RAS14020000000.key, operationForm,
                "2", "PPIP",
                operationFormErr);
    }),


    /* Update Pak Yahya :: Segment Validation */

    SG_RASIO_NUMERIC_DOT_POSITIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = {17, 20, 23, 29, 38, 41, 50, 53, 56};

        return UtilSegmentValidation.genRegexNumericDot("3|4|5|6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RASIO_NUMERIC_DOT_NEGATIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = {2, 5, 8, 11, 14, 26, 32, 35, 44, 47, 59};

        return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_NON_RASIO_NUMERIC_POSITIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = {10, 12, 15, 16, 18, 19, 21, 22, 27, 28, 30,
                36, 37, 39, 40, 42, 48, 51, 52, 54, 55};

        return UtilSegmentValidation.genRegexNumeric("3|4|5|6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_NON_RASIO_NUMERIC_NEGATIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = {0, 3, 6, 7, 9, 13, 24, 25, 31, 33, 34, 43, 45, 46, 57, 58};

        return UtilSegmentValidation.genRegexNumericNegative("3|4|5|6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    // Row Specific

    SG_RAS10102000000_NUMERIC_DOT_POSITIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 1 };

        return UtilSegmentValidation.genRegexNumericDot("6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RAS10102000000_NUMERIC_DOT_NEGATIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 1 };

        return UtilSegmentValidation.genRegexNumericDotNegative("3",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RAS10102000000_NUMERIC(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 1 };

        return UtilSegmentValidation.genRegexNumeric("4|5",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RAS10202000000_NUMERIC_DOT_NEGATIVE(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 4 };

        return UtilSegmentValidation.genRegexNumericNegative("3",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RAS10202000000_NUMERIC(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 4 };

        return UtilSegmentValidation.genRegexNumeric("4|5|6",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    SG_RAS11902000000_NUMERIC_DOT(programs(PPMPPPIPK), () -> {
        int[] INT_ROWS = { 49 };

        return UtilSegmentValidation.genRegexNumericDot("3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), INT_ROWS));
    }),

    /* Update Pak Yahya :: Field Validation */

    FV_MANFAAT_PENSIUN_1(programs(PPMPPPIPK), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN), () -> {
        String formula = UtilMetadata.genMinusColumn(new int[]{6, 4, 5});
        int[] rows = {4};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), rows));
    }),

    FV_MANFAAT_PENSIUN_2(programs(PPMPPPIPK), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN), () -> {
        String formula = UtilMetadata.genMinusColumn(new int[]{6, 4, 5});
        int[] rows = {1};
        return UtilFieldValidation.genEqualsPosFormula(formula, 2, UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), rows));
    }),

    FV_TOTAL_EQUAL(programs(PPMPPPIPK), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String formula = UtilMetadata.genPlusColumn(3, 5);
        int[] rows = {0, 3, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40,
                42, 43, 45, 46, 51, 52, 54, 55, 57, 58};

        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), rows));
    }),

    CR_TOTAL_EMPTY(programs(PPMPPPIPK), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String refPosCode = UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), new int[]{53, 57});
        return UtilFieldConditional.genExistPos("N", "M", refPosCode);
    })

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

    public static final BaseMetadataValidation<E7017Ras1GabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7017Ras1GabunganValidationsConfig.class, PPMPPPIPK);

    private static SegmentValidation genValidationRatioAB(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPMPPPIPK).get(rowA).getValue() + "' : '"
                + getObjects(PPMPPPIPK).get(rowB).getValue() + "'";

        String col = UtilMetadata.genPipeColumn(3, 6);

        if (posCode.equals(R_RAS12030000000) || posCode.equals(R_RAS13030000000)) {
            col = UtilMetadata.genPipeColumn(3, 5);
        }

        return UtilSegmentValidation.genEqualsRatioDapen(col, posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPMPPPIPK), new int[]{rowA, rowB}),
                "2", "PPMP|PPIP",
                errMsg);
    }

    public static List<SegmentValidation> genAllValidationRatioAB_GABUNGAN() {
        List<SegmentValidation> validations = new ArrayList<>();
        List<IObject<KeyValueString>> ratios = Arrays.asList(R_RAS10103000000, R_RAS10203000000, R_RAS10303000000,
                R_RAS10503000000, R_RAS10703000000, R_RAS10803000000, R_RAS10903000000, R_RAS11003000000, R_RAS11103000000,
                R_RAS11203000000, R_RAS11303000000, R_RAS11403000000, R_RAS11503000000, R_RAS11603000000, R_RAS11703000000,
                R_RAS11803000000, R_RAS11903000000, R_RAS12030000000, R_RAS13030000000, R_RAS14030000000);

        List<String> kvsRas = getObjects(PPMPK)
                .stream()
                .map(KeyValueString::getKey)
                .collect(Collectors.toList());

        for (int i = 0, rowA = 0, rowB = 1; i < ratios.size(); i++) {
            String key = ratios.get(i).getObject().getKey();
            int idx = kvsRas.indexOf(key);
            rowA = idx - 2;
            rowB = idx - 1;

            if (ratios.get(i).equals(R_RAS11903000000)) {
                validations.add(UtilSegmentValidation.genFilterEqualsFormula_DAPEN(UtilMetadata.genPipeColumn(3, 6),
                        R_RAS11903000000.getObject().getKey(),
                        R_RAS11901000000.getObject().getKey() + "-" + R_RAS11902000000.getObject().getKey(),
                        "'" + R_RAS11901000000.getObject().getValue() + "' - '" + R_RAS11902000000.getObject().getValue() + "'"));
            } else {
                validations.add(genValidationRatioAB(ratios.get(i), rowA, rowB));
            }

        }
        return validations;
    }

    private static FormulaParserData multiFormulaFormatter(FormulaParserData[] formulas, String operand) {
        StringBuilder sbFormula = new StringBuilder();
        StringBuilder sbFormulaErr = new StringBuilder();
        String[] operands = StringUtils.split(operand, "#");

        if (formulas.length != operands.length + 1) throw new IllegalStateException();

        for (int i = 0; i < formulas.length; i++) {
            sbFormula.append(formulas[i].getFormula());
            sbFormulaErr.append("(").append(formulas[i].getErrMessage());
            if (i < formulas.length - 1) {
                sbFormula.append(operands[i]);
                sbFormulaErr.append(") ").append(operands[i]).append(" ");
            }
        }

        sbFormulaErr.append(")");

        return new FormulaParserData(sbFormula.toString(), sbFormulaErr.toString());
    }
}
