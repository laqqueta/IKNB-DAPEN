package id.go.ojk.metadata.module.lblt.dppk.validations.ppipm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.field.Dppk0017Ras1;
import id.go.ojk.metadata.module.lblt.dppk.reference.*;
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
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1MValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+6-13", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10101000000.key, operationForm, operationFormErr);
    }),

    SG_RAS10102000000_B(programs(PPIPM), () -> {
        String selectPosCode = R_RAS10102000000.key;
        String comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.key;
        return UtilSegmentValidation.genEqualsForm("2", selectPosCode,
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "10", comparatorPosCode);
    }),

    SG_MULTI_SUM_RAS10201000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+10", "2", comparatorForm),
                genFormulaParser(formObject, "13+14+15", "2", comparatorForm)
        }, "-");

        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10201000000.key, operationForm, operationFormErr);
    }),

    SG_AVG_REKINV_RAS10202000000_A(programs(PPIPM), () -> {
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorExpr = "/12";
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidation.genEqualsFormExpression("2", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),

    SG_MULTI_SUM_RAS10301000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "14", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10301000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+10", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10302000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10501000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "14", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10501000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10502000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "38", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10502000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode Bulan Berjalan pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2PeriodePelaporan("2", R_RAS10701000000.key, operationForm, operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "7+8+9", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10702000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10802000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10802000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "27+28", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10901000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10902000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11001000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11001000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11101000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "6", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11101000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11102000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11102000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11201000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11201000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11202000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11202000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11301000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11301000000.key, operationForm, operationFormErr);
    }),

    //RAS11302000000
    SG_MULTI_SUM_RAS11302000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "13+14+16", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode bulan berjalan pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2PeriodePelaporan("2", R_RAS11302000000.key, operationForm, operationFormErr, 2);
    }),

    //RAS11401000000
    SG_MULTI_SUM_RAS11401000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 11, 13, 15, 19, 20, 21, 22, 23});
        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11401000000.key, operationForm, operationFormErr);
    }),

    //RAS11402000000
    SG_MULTI_SUM_RAS11402000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 12, 14, 16, 17, 24, 25, 26});
        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11402000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11501000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11501000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11502000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11502000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11601000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11601000000.key, operationForm, operationFormErr);
    }),

    // test error validasi
    SG_MULTI_SUM_RAS11701000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPM), "49", "7+10+13", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11701000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11702000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7005PosLtlbDppkLak.getObjects(), "0+1+2+3+15", "2", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11702000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11801000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        FormulaParserData operation2 = genFormulaParser(formObject, "6+8+25", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11802000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+15", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11802000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPM), "39", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS12010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPM), "39", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS12020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13010000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPM), "49", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS13010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13020000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPIPM), "49", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS13020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS14010000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "13+14", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS14010000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS14020000000(programs(PPIPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPIPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS14020000000.key, operationForm, operationFormErr);
    }),

    /* Update Pak Yahya :: Segment Validation */

    SG_NUMERIC_DOT_NEGATIVE_RASIO(programs(PPIPM), () -> {
        int[] negativeRasio = {2, 5, 8, 11, 14, 26, 32, 35, 47, 50, 59};

        return UtilSegmentValidation.genRegexNumericDot("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), negativeRasio));
    }),

    SG_NUMERIC_DOT_POSITIVE_RASIO(programs(PPIPM), () -> {
        int[] positiveRasio = {17, 20, 23, 29, 38, 41, 53, 56};

        return UtilSegmentValidation.genRegexNumericDot("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), positiveRasio));
    }),


    SG_NUMERIC_POSITIVE_NON_RASIO(programs(PPIPM), () -> {
        int[] row = {10, 12, 15, 16, 18, 19, 21, 22, 27, 28, 30, 36, 37, 39, 40, 42, 49, 51, 52, 54, 55};

        return UtilSegmentValidation.genRegexNumeric("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    SG_NUMERIC_NEGATIVE_NON_RASIO(programs(PPIPM), () -> {
        int[] row = {0, 3, 6, 7, 9, 13, 24, 25, 31, 33, 34, 45, 46, 57, 58};

        return UtilSegmentValidation.genRegexNumeric("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    // Row specific regex
    SG_NUMERIC_DOT_NEGATIVE_RAS10102000000(programs(PPIPM), () -> {
        int[] row = {1};

        return UtilSegmentValidation.genRegexNumericDotNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    SG_NUMERIC_NEGATIVE_RAS10202000000(programs(PPIPM), () -> {
        int[] row = {4};

        return UtilSegmentValidation.genRegexNumericNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    SG_NUMERIC_NEGATIVE_DOT_RAS11702000000(programs(PPIPM), () -> {
        int[] row = {43};

        return UtilSegmentValidation.genRegexNumericNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    SG_NUMERIC_DOT_NEGATIVE_RAS11703000000(programs(PPIPM), () -> {
        int[] row = {44};

        return UtilSegmentValidation.genRegexNumericDotNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPIPM), row));
    }),

    CR_EMPTY_COL_POS(programs(PPIPM), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN_PPMPM_PPIPM),
            () -> {
                String refPosCode = UtilMetadata.genPipeRow(getObjects(PPIPM), new int[]{48, 49, 50});
                return UtilFieldConditional.genExistPos("N", "M", refPosCode);
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

    public static final BaseMetadataValidation<E7017Ras1MValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7017Ras1MValidationsConfig.class, PPIPM);

    private static SegmentValidation genValidationRatioAB(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPIPM).get(rowA).getValue() + "' : '"
                + getObjects(PPIPM).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio("2", posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPIPM), new int[]{rowA, rowB}), errMsg);
    }

    private static SegmentValidation genValidationRatioAB2(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPIPM).get(rowA).getValue() + "' : '"
                + getObjects(PPIPM).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatioByRatio("2", posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPIPM), new int[]{rowA, rowB}), errMsg);
    }


    public static List<SegmentValidation> genAllValidationRatioAB_PPIPM() {
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
