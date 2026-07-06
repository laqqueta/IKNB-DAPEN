package id.go.ojk.metadata.module.lblt.validations.ppipik;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1KValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6-13", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6-13", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6-13", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10101000000.key, operationForm, operationFormErr);
    }),

    SG_RAS10102000000_A(programs(PPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7010PosLtlbDppkRoiml.R_ROIML2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROIML";
        return UtilSegmentValidationV2.genEqualsForm("4", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI_ML.getCode(), "10", comparatorPosCode.getKey(), errMsg);
    }),

    SG_RAS10102000000_B(programs(PPIPK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROI";
        return UtilSegmentValidationV2.genEqualsForm("5", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "10", comparatorPosCode.getKey(), errMsg);
    }),

    SG_MULTI_SUM_RAS10201000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+10", "2", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "2", comparatorForm)
        }, "-");

        FormulaParserData operation3 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "3+4+5", comparatorForm),
                genFormulaParser(formObject, "10", "3+4+5", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "3+4+5", comparatorForm)
        }, "+#-");

        FormulaParserData operation4 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6", "6+7+8+9+10+11", comparatorForm),
                genFormulaParser(formObject, "10", "6+7+8+9+10+11", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "6+7+8+9+10+11", comparatorForm)
        }, "+#-");

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10201000000.key, operationForm, operationFormErr);
    }),

    SG_AVG_REKINV_RAS10202000000_A(programs(PPIPK), () -> {
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2400000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorExpr = "/12";
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("3", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_B(programs(PPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2300000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorExpr = "/12";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("4", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),

    SG_AVG_REKINV_RAS10202000000_C(programs(PPIPK), () -> {
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorExpr = "/12";
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("5", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),

    SG_MULTI_SUM_RAS10301000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10301000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+10", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+10", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+10", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10302000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10501000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "14", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "14", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "14", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10501000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10502000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "38", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "38", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "38", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10502000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode Bulan Berjalan pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode Bulan Berjalan pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("2|3|4", R_RAS10701000000.key, operationForm, operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "7+8+9", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "7+8+9", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "7+8+9", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10702000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10802000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10802000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "27+28", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "27+28", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "27+28", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10901000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10902000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11001000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11001000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11101000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11101000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11102000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11102000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11201000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form NRC" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form NRC";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11201000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11202000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11202000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11301000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+21", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+21", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11301000000.key, operationForm, operationFormErr);
    }),

    //RAS11302000000
    SG_MULTI_SUM_RAS11302000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "13+14+16", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "13+14+16", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "13+14+16", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode bulan berjalan pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("2|3|4", R_RAS11302000000.key, operationForm, operationFormErr, 2);
    }),

    //RAS11401000000
    SG_MULTI_SUM_RAS11401000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 11, 13, 15, 19, 20, 21, 22, 23});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11401000000.key, operationForm, operationFormErr);
    }),

    //RAS11402000000
    SG_MULTI_SUM_RAS11402000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 12, 14, 16, 17, 24, 25, 26});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11402000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11501000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22+23+24", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22+23+24", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11501000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11502000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11502000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11601000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11601000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11701000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPK), "49", "7+10+13", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11701000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11702000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7005PosLtlbDppkLak.getObjects(), "0+1+2+3+15", "2", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11702000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11801000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation2 = genFormulaParser(formObject, "6+8+25", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6+8+25", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6+8+25", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11802000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+15", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+3+15", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+3+15", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11802000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11901000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_RAS_1.getCode();
        List<KeyValueString> formObject = ER7017PosLtlbDppkRas1.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "2", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "2", "3", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "2", "4", comparatorForm);
        FormulaParserData operation5 = genFormulaParser(formObject, "2", "5", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula() + "|" + operation5.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain" + "|" +
                "sama dengan Baris " + operation5.getErrMessage() + " Total";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4|5", R_RAS11901000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPK), "39", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS12010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPK), "39", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS12020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13010000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPK), "49", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS13010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13020000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPK), "49", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS13020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS14010000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "13+14", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "13+14", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "13+14", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS14010000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS14020000000(programs(PPIPK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS14020000000.key, operationForm, operationFormErr);
    }),

    /* Update Pak Yahya :: Segment Validation */

    SG_NUMERIC_DOT_NEGATIVE_RASIO(programs(PPIPK), () -> {
        int[] negativeRasio = {2, 5, 8, 11, 14, 26, 32, 35, 47, 50, 59};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), negativeRasio));
    }),

    SG_NUMERIC_DOT_POSITIVE_RASIO(programs(PPIPK), () -> {
        int[] positiveRasio = {17, 20, 23, 29, 38, 41, 53, 56};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), positiveRasio));
    }),


    SG_NUMERIC_POSITIVE_NON_RASIO(programs(PPIPK), () -> {
        int[] row = {10, 12, 15, 16, 18, 19, 21, 22, 27, 28, 30, 36, 37, 39, 40, 42, 49, 51, 52, 54, 55};

        return UtilSegmentValidation.genRegexNumeric("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_NEGATIVE_NON_RASIO(programs(PPIPK), () -> {
        int[] row = {0, 3, 6, 7, 9, 13, 24, 25, 31, 33, 34, 45, 46, 57, 58};

        return UtilSegmentValidation.genRegexNumeric("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    // Row specific regex
    SG_NUMERIC_DOT_NEGATIVE_RAS10102000000(programs(PPIPK), () -> {
        int[] row = {1};

        return UtilSegmentValidation.genRegexNumericDotNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_RAS10102000000(programs(PPIPK), () -> {
        int[] row = {1};

        return UtilSegmentValidation.genRegexNumeric("3|4",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_DOT_POSITIVE_RAS10102000000(programs(PPIPK), () -> {
        int[] row = {1};

        return UtilSegmentValidation.genRegexNumericDot("5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),


    SG_NUMERIC_POSITIVE_RAS10202000000(programs(PPIPK), () -> {
        int[] row = {4};

        return UtilSegmentValidation.genRegexNumeric("3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_NEGATIVE_RAS10202000000(programs(PPIPK), () -> {
        int[] row = {4};

        return UtilSegmentValidation.genRegexNumericNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_POSITIVE_RAS11702000000(programs(PPIPK), () -> {
        int[] row = {43};

        return UtilSegmentValidation.genRegexNumeric("3|4",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_NEGATIVE_DOT_RAS11702000000(programs(PPIPK), () -> {
        int[] row = {43};

        return UtilSegmentValidation.genRegexNumericNegative("2|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_DOT_POSITIVE_RAS11703000000(programs(PPIPK), () -> {
        int[] row = {44};

        return UtilSegmentValidation.genRegexNumericDot("3|4",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_DOT_NEGATIVE_RAS11703000000(programs(PPIPK), () -> {
        int[] row = {44};

        return UtilSegmentValidation.genRegexNumericDot("2|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    SG_NUMERIC_DOT_NEGATIVE_RAS11901000000(programs(PPIPK), () -> {
        int[] row = {48};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPIPK), row));
    }),

    /* Update Pak Yahya :: Field Validation */

    FV_MANFAAT_PENSIUN(programs(PPIPK), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN), () -> {
        String formula = UtilMetadata.genMinusColumn(new int[]{5, 3, 4});
        int[] rows = {1, 4};
        return UtilFieldValidation.genEqualsPosFormula3(formula, 2, UtilMetadata.genPipeRow(getObjects(PPIPK), rows));
    }),

    FV_TOTAL_EQUAL(programs(PPIPK), validationFields(Dppk0017Ras1.TOTAL_PPIP), () -> {
        String formula = UtilMetadata.genPlusColumn(2, 4);
        int[] rows = {0, 3, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40,
                42, 43, 45, 46, 49, 51, 52, 54, 55, 57, 58};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPIPK), rows));
    }),

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

    public static final BaseMetadataValidation<E7017Ras1KValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7017Ras1KValidationsConfig.class, PPIPK);

    private static SegmentValidation genValidationRatioAB(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPIPK).get(rowA).getValue() + "' : '"
                + getObjects(PPIPK).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPIPK), new int[]{rowA, rowB}), errMsg);
    }

    private static SegmentValidation genValidationRatioAB2(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPIPK).get(rowA).getValue() + "' : '"
                + getObjects(PPIPK).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatioByRatio(UtilMetadata.genPipeColumn(2, 5), posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPIPK), new int[]{rowA, rowB}), errMsg);
    }


    public static List<SegmentValidation> genAllValidationRatioAB_PPIPK() {
        List<SegmentValidation> validations = new ArrayList<>();
        List<IObject<KeyValueString>> ratios = Arrays.asList(R_RAS10103000000, R_RAS10203000000, R_RAS10303000000, R_RAS10503000000, R_RAS10703000000, R_RAS10803000000,
                R_RAS10903000000, R_RAS11003000000, R_RAS11103000000, R_RAS11203000000, R_RAS11303000000, R_RAS11403000000, R_RAS11503000000,
                R_RAS11603000000, R_RAS11703000000, R_RAS11803000000, R_RAS11903000000, R_RAS12030000000, R_RAS13030000000, R_RAS14030000000);

        for (int i = 0, rowA = 0, rowB = 1; i < ratios.size(); i++, rowA += 3, rowB += 3) {
            if (ratios.get(i).equals(R_RAS11903000000)) {
                validations.add(genValidationRatioAB2(ratios.get(i), rowA, rowB));
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
