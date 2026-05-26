package id.go.ojk.metadata.module.lblt.dppk.validations.ppmpm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.constant.MessageType;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
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

import java.util.*;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.*;
import static id.go.ojk.conf.client.UtilMetadata.genFormulaParserFormatter;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1MValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);
        FormulaParserData operation = genFormulaParserFormatter(formObject, "5|6|14", "2",
                "+|-", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage() + " pada Form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10101000000.key, operation.getFormula(), err);
    }),

    SG_RAS10102000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
        FormulaParserData operation = genFormulaParserFormatterDetailed(ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject(), "10",
                "Rata-Rata Investasi", comparatorForm);

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10102000000.key,
                operation.getFormula(),
                "sama dengan baris " + operation.getErrMessage() + " pada Form ROI");
    }),

    SG_MULTI_SUM_RAS10201000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData ops = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParserFormatter(formObject, "5|6|11", "2", "+|+", "", comparatorForm),
                genFormulaParserFormatter(formObject, "14|15|16", "2", "+|+", "", comparatorForm)
        }, "-");

        String formatted = ops.getErrMessage().replaceAll("Kolom 3 |Kolom 3", "");
        String err = "sama dengan Total perhitungan baris " + formatted.replace(" )", ")") + " pada kolom 'Persentase Investasi' Form " + comparatorForm;

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10201000000.key, ops.getFormula(), err);
    }),

    SG_AVG_REKINV_RAS10202000000(programs(PPMPM), () -> {
        KeyValueString comparator = ER7008PosLtlbDppkRekinv.R_REKINV2200000000.getObject();
        String comparatorField = UtilMetadata.genPipeColumn(2, 13);
        String comparatorOperands = comparatorField.replaceAll("[0-9]+", "+");
        String form = EFormLaporanBulananTahunan.LTLB_REKINV.getCode();
        FormulaParserData ops = genFormulaParserFormatter(comparator, comparatorField, comparatorOperands.substring(0, comparatorOperands.length() - 2), form);
        String errMsg = "'" + R_RAS10202000000.value + "' harus sama dengan total rata-rata '" + comparator.getValue() + "' pada form " + form;

        return UtilSegmentValidation.genFormulaParserAvgValidation("2", R_RAS10202000000.key, ops.getFormula(), errMsg, 12, 2);
    }),


    SG_MULTI_SUM_RAS10301000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7002PosLtlbDppkLpan.R_LPAN0202000000.getObject(), "2", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LPAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10301000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData ops = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParserFormatterDetailed(formObject, "5", "2", "", "", "Manfaat Pensiun", comparatorForm),
                genFormulaParserFormatterDetailed(formObject, "11", "2", "", "", "Manfaat Pensiun", comparatorForm)
        }, "+");

        String err = "sama dengan Total perhitungan baris " + ops.getErrMessage()
                .replaceAll("[()]", "") + " pada form LPAN";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10302000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10401000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParserFormatterDetailed(formObject, "14", "3", "", "", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParserFormatterDetailed(formObject, "14", "4", "", "", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParserFormatterDetailed(formObject, "14", "5", "", "", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidation.genFormulaParserValidationV2("2|3|4", R_RAS10401000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10402000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParserFormatterDetailed(formObject, "16", "3", "", "", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParserFormatterDetailed(formObject, "16", "4", "", "", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParserFormatterDetailed(formObject, "16", "5", "", "", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidation.genFormulaParserValidationV2("2|3|4", R_RAS10402000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10601000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParserFormatterDetailed(formObject, "14", "3", "", "", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParserFormatterDetailed(formObject, "14", "4", "", "", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParserFormatterDetailed(formObject, "14", "5", "", "", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";

        return UtilSegmentValidation.genFormulaParserValidationV2("2|3|4", R_RAS10601000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10602000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPM);

        FormulaParserData field2 = genFormulaParserFormatterDetailed(formObject, "15", "3", "", "", "Nilai Program Manfaat Pensiun", comparatorForm);
        FormulaParserData field3 = genFormulaParserFormatterDetailed(formObject, "15", "4", "", "", "Nilai Program Manfaat Pensiun Lainnya", comparatorForm);
        FormulaParserData field4 = genFormulaParserFormatterDetailed(formObject, "15", "5", "", "", "Nilai Program Manfaat Pensiun Lain", comparatorForm);

        String operationForm = field2.getFormula() + "|" + field3.getFormula() + "|" + field4.getFormula();
        String errs = "sama dengan baris " + field2.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field3.getFormula() + " pada Form KUP" + "|" +
                "sama dengan baris " + field4.getFormula() + " pada Form KUP";
        return UtilSegmentValidation.genFormulaParserValidationV2("2|3|4", R_RAS10602000000.key, operationForm, errs);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "22|23|24", "3",
                "+|+", "", comparatorForm);
        String err = "sama dengan Total baris (" + operation.getErrMessage()
                .replaceAll("Kolom 4 | Kolom 4", "") + ") pada Form LAN kolom 'Manfaat Pensiun' * Bulan Tanggal Audit form DTUM";

        return UtilSegmentValidation.genFormulaParserValidationV2PeriodeAudit("2", R_RAS10701000000.key, operation.getFormula(), err,
                ER7000PosLtlbDppkDtum.R_DTUM080700.key, "2", "DTUM", 0);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "7|8|9|10", "2",
                "+|+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LPAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10702000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10801000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10802000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0111000000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10802000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "27|28", "3",
                "+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 4 | Kolom 4", "") + " pada Form LAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10901000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS10902000000.key, ops.getFormula(), err);
    }),

    // RAS11001000000
    SG_MULTI_SUM_RAS11001000000(programs(PPMPM), () -> {
        FormulaParserData ops = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0102000000.getObject(), "2", "Manfaat Pensiun", "LAN"),
                genFormulaParserFormatterDetailed(ER7017PosLtlbDppkRas1.R_RAS10901000000.getObject(), "2", "Manfaat Pensiun", "RAS1")
        }, "-");

        String formatted = ops.getErrMessage().replaceAll("[()]|Kolom ", "");
        int idx = formatted.indexOf("' - '");
        String err = "sama dengan Total penjumlahan " +  (formatted.substring(0, idx+1) + " pada Form LAN" + formatted.substring(idx+1) + " pada Form RAS1")
                .replace("'Manfaat Pensiun'", "Manfaat Pensiun");

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11001000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11101000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7002PosLtlbDppkLpan.R_LPAN0103000000.getObject(), "2", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LPAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11101000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11102000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "5|6", "2",
                "+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LPAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11102000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11201000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject(), "2", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form NRC";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11201000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11202000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0111000000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11202000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11301000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "0|1|2|48", "3",
                "+|+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 4 | Kolom 4", "") + " pada Form LAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11301000000.key, operation.getFormula(), err);
    }),

    // RAS11302000000
    SG_MULTI_SUM_RAS11302000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "14|15|17", "3",
                "+|+", "", comparatorForm);
        String err = "sama dengan Total baris (" + operation.getErrMessage()
                .replaceAll("Kolom 4 | Kolom 4", "") + ") * Periode Laporan Berjalan; pada Form LAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2PeriodePelaporan("2", R_RAS11302000000.key, operation.getFormula(), err, 0);
    }),

    // RAS11401000000 --> LAK
    SG_MULTI_SUM_RAS11401000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        FormulaParserData operation = genFormulaParserFormatter(formObject, "0|1|2|3|4|9|11|13|15|19|20|21|22|23", "2",
                "+|+|+|+|+|+|+|+|+|+|+|+|+", "", comparatorForm);
        int idx = operation.getErrMessage().indexOf("'Pendapatan Lain di Luar Investasi'");
        String formatted = (operation.getErrMessage().substring(0, idx) + "\n" + operation.getErrMessage().substring(idx))
                .replaceAll("Kolom 3 | Kolom 3", "");
        String err = "sama dengan Total baris " + formatted + " pada Form LAK kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11401000000.key, operation.getFormula(), err);
    }),

    // RAS11402000000 --> LAK
    SG_MULTI_SUM_RAS11402000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();
        // SUM(LAK!E15:E16)+LAK!E19+LAK!E21+LAK!E23+LAK!E25+SUM(LAK!E27:E28)+SUM(LAK!E36:E38)
        FormulaParserData operation = genFormulaParserFormatter(formObject, "5|6|8|10|12|14|16|17|24|25|26", "2",
                "+|+|+|+|+|+|+|+|+|+", "", comparatorForm);
        int idx = operation.getErrMessage().indexOf("'Pajak Penghasilan'");
        String formatted = (operation.getErrMessage().substring(0, idx) + "\n" + operation.getErrMessage().substring(idx))
                .replaceAll("Kolom 3 | Kolom 3", "");
        String err = "sama dengan Total baris " + formatted + " pada Form LAK kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11402000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11501000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "22|23|24", "3",
                "+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 4 | Kolom 4", "") + " pada Form LAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11501000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11502000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0111000000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11502000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11601000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7001PosLtlbDppkLan.R_LAN0103030000.getObject(), "3", "Manfaat Pensiun", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form LAN";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11601000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11701000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();

        FormulaParserData operation = genFormulaParserFormatter(ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject(), "4|10|13",
                "+|+", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("[()]", "")+ " pada Form ALM";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11701000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11702000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation = genFormulaParserFormatter(formObject, "0|1|2|3|15", "2",
                "+|+|+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LAK kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11702000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11801000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation = genFormulaParserFormatter(formObject, "6|8|25", "2",
                "+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LAK kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11801000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS11802000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation = genFormulaParserFormatter(formObject, "0|1|2|3|15", "2",
                "+|+|+|+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LAK kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS11802000000.key, operation.getFormula(), err);
    }),

    SG_RASIO_RAS11903000000(programs(PPMPM), () -> {
        String errMsg = "Rasio (A:B)|'" + getObjects(PPMPM).get(51).getValue() + "' : '"
                + getObjects(PPMPM).get(52).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio(UtilMetadata.genPipeColumn(3, 4), R_RAS11903000000.getObject().getKey(),
                UtilMetadata.genPipeRow(getObjects(PPMPM), new int[]{51, 52}), errMsg);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject(), "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS12010000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject(), "16", "Total - Total", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS12020000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS13010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject(), "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS13010000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS13020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData ops = genFormulaParserFormatterDetailed(ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject(), "16", "Total - Total", comparatorForm);
        String err = "sama dengan baris " + ops.getErrMessage() + " pada form ALM";
        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS13020000000.key, ops.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS14010000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "14|15", "2",
                "+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LPAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS14010000000.key, operation.getFormula(), err);
    }),

    SG_MULTI_SUM_RAS14020000000(programs(PPMPM), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPM);

        FormulaParserData operation = genFormulaParserFormatter(formObject, "5|6", "2",
                "+", "", comparatorForm);
        String err = "sama dengan Total baris " + operation.getErrMessage()
                .replaceAll("Kolom 3 | Kolom 3", "") + " pada Form LPAN kolom 'Manfaat Pensiun'";

        return UtilSegmentValidation.genFormulaParserValidationV2("2", R_RAS14020000000.key, operation.getFormula(), err);
    }),


    /* Update Pak Yahya :: Segment Validation */

    SG_NUMERIC(programs(PPMPM), () -> {
        int[] EXCEPT_ROW = { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 36, 37, 38, 41, 44, 46, 48, 47, 50, 53, 56,
                59, 62 };

        return UtilSegmentValidation.genRegexNumeric("2|3|4|5",
                UtilMetadata.genPipeRowExcept(getObjects(PPMPM), EXCEPT_ROW));
    }),

    SG_NUMERIC_2(programs(PPMPM), () -> {
        int[] EXCEPT_ROW = { 36, 37, 46, 48 };

        return UtilSegmentValidation.genRegexNumeric("3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), EXCEPT_ROW));
    }),

    SG_NUMERIC_DOT(programs(PPMPM), () -> {
        int[] PERCENT_ROWS = { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56,
                59, 62 };

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(PPMPM), PERCENT_ROWS));
    }),

    SG_NUMERIC_NEGATIVE(programs(PPMPM), () -> {
        int[] PERCENT_ROWS = { 36, 37, 46, 48 };

        return UtilSegmentValidation.genRegexNumericNegative("2",
                UtilMetadata.genPipeRow(getObjects(PPMPM), PERCENT_ROWS));
    }),

    /* Update Pak Yahya :: Field Validation */

    FV_TOTAL_EQUAL_1(programs(PPMPM), validationFields(Dppk0017Ras1.TOTAL), () -> {
        String formula = UtilMetadata.genPlusColumn(2, 4);
        int[] rows = {0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40,
                42, 43, 48, 49, 54, 55};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPMPM), rows));
    }),

    FV_TOTAL_EQUAL_2(programs(PPMPM), validationFields(Dppk0017Ras1.TOTAL), () -> {
        String formula = UtilMetadata.genPlusColumn(3, 4);
        int[] rows = {45, 46, 57, 58};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(PPMPM), rows));
    }),

    CR_EMPTY_COL_POS(programs(PPMPM), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN_PPMPM, Dppk0017Ras1.TOTAL),
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

    public static List<SegmentValidation> genAllValidationRatioAB() {
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
