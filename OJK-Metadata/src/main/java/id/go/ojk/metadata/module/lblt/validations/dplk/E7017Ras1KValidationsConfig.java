package id.go.ojk.metadata.module.lblt.validations.dplk;

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

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.conf.client.UtilMetadata.genFormulaParserColumnMapped;
import static id.go.ojk.metadata.module.lblt.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1KValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6+7-12", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6-12", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6-12", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10101000000.key, operationForm, operationFormErr);
    }),

    SG_RAS10102000000_A(programs(DPLK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7010PosLtlbDppkRoiml.R_ROIML2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROIML";
        return UtilSegmentValidationV2.genEqualsForm("4", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI_ML.getCode(), "10", comparatorPosCode.getKey(), errMsg);
    }),

    SG_RAS10102000000_B(programs(DPLK), () -> {
        KeyValueString selectPosCode = R_RAS10102000000.getObject();
        KeyValueString comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject();
        String errMsg = selectPosCode.getValue() + "|" + comparatorPosCode.getValue() + " pada form ROI";
        return UtilSegmentValidationV2.genEqualsForm("5", selectPosCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), "11", comparatorPosCode.getKey(), errMsg);
    }),

    SG_MULTI_SUM_RAS10201000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "6+7+9", "2+11", comparatorForm),
                genFormulaParser(formObject, "12+13+14", "2+11", comparatorForm)
        }, "-");

        FormulaParserData operation3 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+8", "3+4+5", comparatorForm),
                genFormulaParser(formObject, "12+13+14", "3+4+5", comparatorForm)
        }, "-");

        FormulaParserData operation4 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "5+6+8", "6+7+8+9+10+11", comparatorForm),
                genFormulaParser(formObject, "12+13+14", "6+7+8+9+10+11", comparatorForm)
        }, "-");

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun dan Manfaat Lain - Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10201000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10301000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "12", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "12", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "12", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10301000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+8", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+8", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+9", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10302000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10401000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "12", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "12", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "12", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10401000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10402000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "28", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "28", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "28", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10402000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10601000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10601000000.key, operationForm, operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10602000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "37", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "37", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "37", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10602000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "23+24", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "23+24", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "23+24", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10701000000.key, operationForm, operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "20", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "20", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10702000000.key, operationForm, operationFormErr, 2);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        String comparatorFormRas = EFormLaporanBulananTahunan.LTLB_RAS_1.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);
        List<KeyValueString> formObjectRas1 = ER7017PosLtlbDppkRas1.getObjects(DPLK);

        FormulaParserData operation2 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "20", "3", comparatorForm),
                genFormulaParser(formObjectRas1, "22", "2", comparatorFormRas)
        }, "-");


        FormulaParserData operation3 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "20", "4+5+6", comparatorForm),
                genFormulaParser(formObjectRas1, "22", "3", comparatorFormRas)
        }, "-");

        FormulaParserData operation4 = multiFormulaFormatter(new FormulaParserData[]{
                genFormulaParser(formObject, "20", "7+8+9+10+11+12", comparatorForm),
                genFormulaParser(formObjectRas1, "22", "4", comparatorFormRas)
        }, "-");

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage().replaceAll("[()]", "") + " Manfaat Pensiun pada form LAN dan RAS1" + "|" +
                "sama dengan Total Baris " + operation3.getErrMessage().replaceAll("[()]", "") + " Manfaat Pensiun Lainnya pada form LAN dan RAS1" + "|" +
                "sama dengan Total Baris " + operation4.getErrMessage().replaceAll("[()]", "") + " Manfaat Lain pada form LAN dan RAS1";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10801000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10901000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS10902000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11001000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "22", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "22", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "22", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form NRC" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form NRC" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form NRC";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11001000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11002000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "37", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "37", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "37", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11002000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11101000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+21", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+21", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+21", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11101000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11102000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "12+13+14", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "12+13+14", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "12+13+14", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya * Periode bulan berjalan pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain * Periode bulan berjalan pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2PeriodePelaporan("2|3|4", R_RAS11102000000.key, operationForm, operationFormErr, 2);
    }),

    //
    SG_MULTI_SUM_RAS11201000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(DPLK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{0, 1, 2, 3, 4, 9, 13, 14});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11201000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11202000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(DPLK);

        String rowOperation = UtilMetadata.genPlusColumn(new int[]{5, 6, 8, 10, 11, 15, 16, 17, 18});

        FormulaParserData operation2 = genFormulaParser(formObject, rowOperation, "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, rowOperation, "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, rowOperation, "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11202000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11302000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "37", "3", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "37", "4+5+6", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "37", "7+8+9+10+11+12", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11302000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11501000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "38", "7+10+13", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11501000000.key, operationForm.getFormula(), operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11502000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String fields = "1 tahun kurang lebih atau sama dengan jatuh tempo < 5 tahun - Total|5 tahun kurang lebih atau sama dengan jatuh tempo < 10 tahun - Total|Jatuh Tempo lebih dari atau sama dengan 10 Tahun - Total";
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "39", "7+10+13", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11502000000.key, operationForm.getFormula(), operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11601000000(programs(DPLK), () -> {
        String comparatorFormLak = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObjectLak = ER7005PosLtlbDppkLak.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObjectLak, "6+8+16", "2", comparatorFormLak);
        FormulaParserData operation3 = genFormulaParser(formObjectLak, "6+8+16", "3+4+5", comparatorFormLak);
        FormulaParserData operation4 = genFormulaParser(formObjectLak, "6+8+16", "6+7+8+9+10+11", comparatorFormLak);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11601000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11602000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "0+1+2+3+4+8", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "0+1+2+3+4+8", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "0+1+2+3+4+8", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LAK" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LAK" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LAK";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11602000000.key, operationForm, operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11701000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_RAS_1.getCode();
        List<KeyValueString> formObject = ER7017PosLtlbDppkRas1.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "2", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "2", "3", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "2", "4", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11701000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS11703000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_RAS_1.getCode();
        List<KeyValueString> formObject = ER7017PosLtlbDppkRas1.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "48-49", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "48-49", "3", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "48-49", "4", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + "|" +
                "sama dengan Baris " + operation4.getErrMessage();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS11703000000.key, operationForm, operationFormErr,2);
    }),

    //
    SG_MULTI_SUM_RAS11801000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "27", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11801000000.key, operationForm.getFormula(), operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11802000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "27", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11802000000.key, operationForm.getFormula(), operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11901000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "39", "4", "Jatuh tempo < 1 tahun - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11901000000.key, operationForm.getFormula(), operationFormErr);
    }),

    //
    SG_MULTI_SUM_RAS11902000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        FormulaParserData operationForm = genFormulaParser(ER7012PosLtlbDppkAlm.getObjects(DPLK), "39", "16", "Total - Total", comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ALM";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("2", R_RAS11902000000.key, operationForm.getFormula(), operationFormErr);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "12+13", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "12+13", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "12+13", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS12010000000.key, operationForm, operationFormErr);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();
        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(DPLK);

        FormulaParserData operation2 = genFormulaParser(formObject, "5+6", "2", comparatorForm);
        FormulaParserData operation3 = genFormulaParser(formObject, "5+6", "3+4+5", comparatorForm);
        FormulaParserData operation4 = genFormulaParser(formObject, "5+6", "6+7+8+9+10+11", comparatorForm);

        String operationForm = operation2.getFormula() + "|" + operation3.getFormula() + "|" + operation4.getFormula();
        String operationFormErr = "sama dengan Baris " + operation2.getErrMessage() + " Manfaat Pensiun pada form LPAN" + "|" +
                "sama dengan Baris " + operation3.getErrMessage() + " Manfaat Pensiun Lainnya pada form LPAN" + "|" +
                "sama dengan Baris " + operation4.getErrMessage() + " Manfaat Lain pada form LPAN";

        return UtilSegmentValidationV2.genFormulaParserValidationV2("2|3|4", R_RAS12020000000.key, operationForm, operationFormErr);
    }),

    /* Update Pak Yahya :: Segment Validation */

    SG_NUMERIC_DOT_POSITIVE_ALL_COLS(programs(DPLK), () -> {
        int[] rows = {14, 17, 20, 23, 29, 35, 38, 41, 44};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_DOT_POSITIVE_PARTIAL_COLS(programs(DPLK), () -> {
        int[] rows = {53, 56};

        return UtilSegmentValidation.genRegexNumericDot("2|3|4",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_DOT_NEGATIVE_ALL_COLS(programs(DPLK), () -> {
        int[] rows = {2, 5, 8, 11, 26, 32, 47, 59};

        return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_DOT_NEGATIVE_PARTIAL_COLS(programs(DPLK), () -> {
        int[] rows = {48, 50};

        return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_POSITIVE_ALL_COLS(programs(DPLK), () -> {
        int[] rows = {10, 12, 13, 15, 16, 18, 19, 21, 22, 27, 28, 30, 33, 34, 36, 37,
                39, 40, 42, 43, 46, 51, 52, 54, 55};

        return UtilSegmentValidation.genRegexNumeric("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_POSITIVE_PARTIAL_COLS(programs(DPLK), () -> {
        int[] rows = { 49 };

        return UtilSegmentValidation.genRegexNumeric("2|3|4",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_NUMERIC_NEGATIVE_ALL_COLS(programs(DPLK), () -> {
        int[] rows = {0, 3, 6, 7, 9, 24, 25, 31, 45, 57, 58};

        return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5",
                UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    SG_RAS10102000000_DECIMAL_POSITIVE(programs(DPLK), () ->
            UtilSegmentValidation.genRegexNumericDotNegative("2",
                    UtilMetadata.genPipeRow(getObjects(DPLK), new int[] { 1 }))),

    SG_RAS10102000000_DECIMAL_NEGATIVE(programs(DPLK), () ->
            UtilSegmentValidation.genRegexNumericDot("5",
                    UtilMetadata.genPipeRow(getObjects(DPLK), new int[] { 1 }))),

    SG_RAS10102000000_NUMERIC_POSITIVE(programs(DPLK), () ->
            UtilSegmentValidation.genRegexNumeric("3|4",
                    UtilMetadata.genPipeRow(getObjects(DPLK), new int[] { 1 }))),

    SG_RAS10202000000_NUMERIC_POSITIVE(programs(DPLK), () ->
            UtilSegmentValidation.genRegexNumeric("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(DPLK), new int[] { 4 }))),

    SG_RAS10202000000_NUMERIC_NEGATIVE(programs(DPLK), () ->
            UtilSegmentValidation.genRegexNumericNegative("2",
                    UtilMetadata.genPipeRow(getObjects(DPLK), new int[] { 4 }))),



    /* Update Pak Yahya :: Field Validation */

    FV_MANFAAT_PENSIUN(programs(DPLK), validationFields(Dppk0017Ras1.MANFAAT_PENSIUN), () -> {
        String formula = UtilMetadata.genMinusColumn(new int[]{5, 3, 4});
        int[] rows = {1, 4};
        return UtilFieldValidation.genEqualsPosFormula3(formula, 2, UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    FV_TOTAL_EQUAL(programs(DPLK), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String formula = UtilMetadata.genPlusColumn(2, 4);
        int[] rows = {0, 3, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25,
                33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 51, 52, 54, 55, 57, 58};
        return UtilFieldValidation.genEqualsPosFormula(formula, UtilMetadata.genPipeRow(getObjects(DPLK), rows));
    }),

    CR_TOTAL_EMPTY(programs(DPLK), validationFields(Dppk0017Ras1.TOTAL_PPMP), () -> {
        String refPosCode = UtilMetadata.genPipeRow(getObjects(DPLK), new int[]{48, 49, 50, 53, 56});
        return UtilFieldConditional.genExistPos("N", "M", refPosCode);
    });

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

    public static final BaseMetadataValidation<E7017Ras1KValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7017Ras1KValidationsConfig.class, DPLK);

    private static SegmentValidation genValidationRatioAB(KeyValueString posCode, int rowA, int rowB, String cols) {
        String errMsg = "Rasio (A:B)|'" + getObjects(DPLK).get(rowA).getValue() + "' : '"
                + getObjects(DPLK).get(rowB).getValue() + "'";
        return UtilSegmentValidation.genEqualsRatio(cols, posCode.getKey(),
                UtilMetadata.genPipeRow(getObjects(DPLK), new int[]{rowA, rowB}), errMsg);
    }

    public static List<SegmentValidation> genAllValidationRatioAB_DPLK() {
        List<SegmentValidation> validations = new ArrayList<>();
        int[] ratioRow = {2, 5, 8, 11, 14, 20, 23, 26, 32, 35, 38, 41, 44, 47, 53, 56, 59};
        List<KeyValueString> formObject = ER7017PosLtlbDppkRas1.getObjects(DPLK);

        int rowA = 0, rowB = 0;

        for (int j : ratioRow) {
            rowA = j - 2;
            rowB = j - 1;
            if (j == 53 || j == 56) {
                validations.add(genValidationRatioAB(formObject.get(j), rowA, rowB, UtilMetadata.genPipeColumn(2, 4)));
            } else {
                validations.add(genValidationRatioAB(formObject.get(j), rowA, rowB, UtilMetadata.genPipeColumn(2, 5)));
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

    public static void main(String[] args) {
        String comparatorFormLak = EFormLaporanBulananTahunan.LTLB_LAK.getCode();
        List<KeyValueString> formObjectLak = ER7005PosLtlbDppkLak.getObjects();

        FormulaParserData operation2 = genFormulaParser(formObjectLak, "6+8+16", "2", comparatorFormLak);
        FormulaParserData operation3 = genFormulaParser(formObjectLak, "6+8+16", "3+4+5", comparatorFormLak);
        FormulaParserData operation4 = genFormulaParser(formObjectLak, "6+8+16", "6+7+8+9+10+11", comparatorFormLak);

        System.out.println(operation2.getFormula());
    }
}
