package id.go.ojk.metadata.module.lblt.validations.ppmpm;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1MValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation = genFormulaParser(formObject, "5+6-14", "2", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage() + " Manfaat Pensiun pada Form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10101000000.key, operation.getFormula(), err);
    }),

    SG_RAS10102000000(programs(PPMPM), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " Rata-rata Investasi pada form ROI";
        return UtilSegmentValidationV2.genEqualsForm("2", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "10", comparatorPosCode.getKey(), errMsg);
    }),

    SG_MULTI_SUM_RAS10201000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+11", "2", comparatorForm),
                genFormulaParser(formObject, "14+15+16", "2", comparatorForm)
        }, "-");

        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10201000000.key, operationForm, operationFormErr);
    }),

    SG_AVG_REKINV_RAS10202000000(programs(PPMPM), () -> {

        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorExpr = "/12";
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan rata-rata '" + comparator.getValue() + "' pada form " + form;
        return UtilSegmentValidationV2.genEqualsFormExpression("2", R_RAS10202000000.key, null, form, comparatorField,
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),


    SG_MULTI_SUM_RAS10301000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "15", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10301000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+11", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10302000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10401000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParser(formObject, "14", "3", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParser(formObject, "14", "4", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParser(formObject, "14", "5", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10401000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10402000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParser(formObject, "16", "3", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParser(formObject, "16", "4", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParser(formObject, "16", "5", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10402000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10601000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParser(formObject, "14", "3", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParser(formObject, "14", "4", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParser(formObject, "14", "5", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10601000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10602000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParser(formObject, "15", "3", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParser(formObject, "15", "4", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParser(formObject, "15", "5", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10602000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        String err = "sama dengan baris" + operation.getErrMessage() + "'Manfaat Pensiun' pada Form LAN * Bulan Audit form DTUM";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodeAudit("2", R_RAS10701000000.key, operation.getFormula(), err,
                ER7000PosLtlbDppkDtum.R_DTUM080700.key, "2", "DTUM", 0);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(PPMPM), () -> {String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "7+8+9+10", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10702000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParser(ER7001PosLtlbDppkLan.getObjects(PPMPM), "20", "3", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " Manfaat Pensiun pada form LAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10801000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10802000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParser(ER7001PosLtlbDppkLan.getObjects(PPMPM), "48", "3", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " Manfaat Pensiun pada form LAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10802000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation = genFormulaParser(formObject, "27+28", "3", comparatorForm);
        String err = "sama dengan baris " + operation.getErrMessage() + " 'Manfaat Pensiun' pada Form LAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10901000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParser(ER7001PosLtlbDppkLan.getObjects(PPMPM), "20", "3", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " 'Manfaat Pensiun' pada form LAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS10902000000.key, ops.getFormula(), err);
    }),

    // RAS11001000000
    SG_MULTI_SUM_RAS11001000000(programs(PPMPM), () -> {
        FormulaParserData ops = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(ER7001PosLtlbDppkLan.getObjects(PPMPM), "20", "3", "LAN"),
                genFormulaParser(ER7017PosLtlbDppkRas1.getObjects(PPMPM), "21", "2", "RAS1")
        }, "-");

        String msg = ops.getErrMessage();
        int idx = msg.indexOf(") - (");
        String err = ("sama dengan Total " + (msg.substring(0, idx + 1) + " Manfaat Pensiun pada Form LAN" + msg.substring(idx + 1) + " Manfaat Pensiun pada Form RAS1"))
                .replace("(", "")
                .replace(") ", "");

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11001000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11101000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        FormulaParserData ops = genFormulaParser(ER7002PosLtlbDppkLpan.getObjects(PPMPM), "6", "2", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " 'Manfaat Pensiun' pada form LPAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11101000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11102000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage() + " 'Manfaat Pensiun' pada Form LPAN";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11102000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11201000000(programs(PPMPM), () -> {String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11201000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11202000000(programs(PPMPM), () -> {String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11202000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11301000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11301000000.key, operationForm, operationFormErr);
    }),

    // RAS11302000000
    SG_MULTI_SUM_RAS11302000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "14+15+17", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode bulan berjalan pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("2", R_RAS11302000000.key, operationForm, operationFormErr, 2);
    }),

    // RAS11401000000 --> LAK
    SG_MULTI_SUM_RAS11401000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 11, 13, 15, 19, 20, 21, 22, 23});
        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11401000000.key, operationForm, operationFormErr);
    }),

    // RAS11402000000 --> LAK
    SG_MULTI_SUM_RAS11402000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 12, 14, 16, 17, 24, 25, 26});
        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11402000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11501000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22+23+24", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11501000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11502000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "48", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11502000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11601000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "22", "3", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11601000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11701000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "Jatuh tempo < 1 tahun - Total|1 Tahun kurang lebih atau sama dengan Jatuh Tempo < 5 Tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPM), "49", "4+10+13", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11701000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11702000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7005PosLtlbDppkLak.getObjects(), "0+1+2+3+15", "2", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11702000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS11801000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        FormulaParserData operation2 = genFormulaParser(formObject, "6+8+25", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11802000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+15", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11802000000.key, operationForm, operationFormErr);
    }),

    SG_RASIO_RAS11903000000(programs(PPMPM), () -> {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPMPM).get(51).getValue() + "' : '"
                + getObjects(PPMPM).get(52).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(3, 4), R_RAS11903000000.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPMPM), new int[]{51, 52}), errMsg);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPM), "39", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS12010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPM), "39", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS12020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPM), "49", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS13010000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS13020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(PPMPM), "49", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS13020000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS14010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "14+15", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS14010000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS14020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        String operationForm = operation2.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS14020000000.key, operationForm, operationFormErr);
    }),


    /* Update Pak Yahya :: Segment Validation */

    SG_RASIO_NUMERIC_DOT_NEGATIVE_1A(programs(PPMPM), () -> {
        int[] row = {2, 5, 8, 17, 29, 35, 38, 47, 50, 62};

        return UtilSegmentValidation.genRegexNumericDotNegative("2|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_RASIO_NUMERIC_DOT_POSITIVE_1A(programs(PPMPM), () -> {
        int[] row = {2, 5, 8, 17, 29, 35, 38, 47, 50, 62};

        return UtilSegmentValidation.genRegexNumericDot("3|4",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_RASIO_NUMERIC_DOT_POSITIVE_1B(programs(PPMPM), () -> {
        int[] row = {11, 14, 20, 23, 26, 32, 41, 44, 56, 59};

        return UtilSegmentValidation.genRegexNumericDot("3|4",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_NON_RASIO_NUMERIC_NEGATIVE(programs(PPMPM), () -> {
        int[] row = {0, 6, 7, 16, 27, 28, 34, 36, 37, 46, 48, 49, 60, 61};

        return UtilSegmentValidation.genRegexNumericNegative("2|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_NON_RASIO_NUMERIC_POSITIVE(programs(PPMPM), () -> {
        int[] row = {4, 15, 18, 19, 21, 22, 24, 25, 30, 31, 33, 39, 40, 42, 43, 45, 54, 55, 57, 58};

        return UtilSegmentValidation.genRegexNumeric("2|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_NON_RASIO_NUMERIC_DOT_1A(programs(PPMPM), () -> {
        int[] row = {9, 10, 12, 13};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_NON_RASIO_NUMERIC_DOT_1B(programs(PPMPM), () -> {
        int[] row = { 1 };

        return UtilSegmentValidation.genRegexNumericDot("2|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_FREE_NUMERIC_1A(programs(PPMPM), () -> {
        int[] row = {0, 1, 3, 4, 6, 7, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36,
                37, 39, 40, 42, 43, 45, 46, 48, 49, 51, 52, 54, 55, 57, 58, 60, 61};

        return UtilSegmentValidation.genRegexNumeric("3|4",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    SG_FREE_NUMERIC_1B(programs(PPMPM), () -> {
        int[] row = {51, 52, 53};

        return UtilSegmentValidation.genRegexNumeric("2",
                UtilMetadata.genPipeRow(getObjects(PPMPM), row));
    }),

    /* Update Pak Yahya :: Field Validation */

    FV_TOTAL_EQUAL_1(programs(PPMPM), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String formula = UtilMetadata.genPlusColumn(2, 4);
        int[] rows = {0, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40,
                42, 43, 45, 46, 57, 58, 48, 49, 54, 55};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPMPM), rows));
    }),

    FV_TOTAL_EQUAL_1A(programs(PPMPM), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String formula = UtilMetadata.genPlusColumn(2, 4);
        int[] rows = {1};
        return UtilFieldValidation.genEqualsPosFormula(formula, 2, UtilMetadata.genPipeRow(getObjects(PPMPM), rows));
    }),

    CR_EMPTY_COL_POS(programs(PPMPM), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN_PPMPM_PPIPM, Dppk0017Ras1.TOTAL_PPMP),
            () -> {
                String refPosCode = UtilMetadata.genPipeRow(getObjects(PPMPM), new int[]{51, 52, 53});
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

    public static final BaseMetadataValidation<E7017Ras1MValidationsConfig> VALIDATION_METADATA_PPMPM =
            new LbltMetadataValidation<>(E7017Ras1MValidationsConfig.class, PPMPM);

    private static SegmentValidation genValidationRatioAB(IObject<KeyValueString> posCode, int rowA, int rowB) {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPMPM).get(rowA).getValue() + "' : '"
                + getObjects(PPMPM).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(2, 5), posCode.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPMPM), new int[]{rowA, rowB}), errMsg);
    }

    public static List<SegmentValidation> genAllValidationRatioAB_PPMPM() {
        List<SegmentValidation> validations = new ArrayList<>();
        List<IObject<KeyValueString>> ratios = Arrays.asList(R_RAS10103000000, R_RAS10203000000, R_RAS10303000000, R_RAS10403000000, R_RAS10603000000,
                R_RAS10703000000, R_RAS10803000000, R_RAS10903000000, R_RAS11003000000, R_RAS11103000000, R_RAS11203000000, R_RAS11303000000,
                R_RAS11403000000, R_RAS11503000000, R_RAS11603000000, R_RAS11703000000, R_RAS11803000000, R_RAS12030000000, R_RAS13030000000,
                R_RAS14030000000);

        EnumSet<? extends IObject<KeyValueString>> filter = EnumSet.of(R_RAS12030000000, R_RAS13030000000, R_RAS14030000000);

        for (int i = 0, rowA, rowB; i < ratios.size(); i++) {
            if (filter.contains(ratios.get(i))) {
                rowA = (i * 3) + 3;
                rowB = rowA + 1;
            } else {
                rowA = i * 3;
                rowB = rowA + 1;
            }

            validations.add(genValidationRatioAB(ratios.get(i), rowA, rowB));
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
