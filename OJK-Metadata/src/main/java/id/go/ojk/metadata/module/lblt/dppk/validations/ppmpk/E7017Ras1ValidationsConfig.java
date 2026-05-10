package id.go.ojk.metadata.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.constant.MessageType;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.reference.*;
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

import static id.go.ojk.conf.client.UtilMetadata.genFormulaFormatter;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7017PosLtlbDppkRas1.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7017Ras1ValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_MULTI_SUM_RAS10101000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10101000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);
        String formula1Op1 = genFormulaFormatter(formObject, new int[] {5, 6}, new int[] {3,4,5});
        String formula1Op2 = genFormulaFormatter(formObject, new int[] {14}, new int[] {3,4,5});
        String formula2Op1 = genFormulaFormatter(formObject, new int[] {5, 6}, new int[] {6,7,8,9,10,11});
        String formula2Op2 = genFormulaFormatter(formObject, new int[] {14}, new int[] {6,7,8,9,10,11});

        String operationForm = formula1Op1 + "-" + formula1Op2 + "|" +
                formula2Op1 + "-" + formula2Op2;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10201000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10201000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formula1Op1 = genFormulaFormatter(formObject, new int[] {5, 6}, new int[] {3,4,5});
        String formula1Op2 = genFormulaFormatter(formObject, new int[] {11}, new int[] {3,4,5});
        String formula1Op3 = genFormulaFormatter(formObject, new int[] {14,15,16}, new int[] {3,4,5});
        String formula2Op1 = genFormulaFormatter(formObject, new int[] {5, 6}, new int[] {6,7,8,9,10,11});
        String formula2Op2 = genFormulaFormatter(formObject, new int[] {11}, new int[] {6,7,8,9,10,11});
        String formula2Op3 = genFormulaFormatter(formObject, new int[] {14,15,16}, new int[] {6,7,8,9,10,11});

        String operationForm = formula1Op1 + "+" + formula1Op2 + "-" + formula1Op3 + "|" +
                formula2Op1 + "+" + formula2Op2 + "-" + formula2Op3;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10301000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10301000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {15}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {15}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField3 + "|" + formulaField4;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10302000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10302000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formula1Op1 = genFormulaFormatter(formObject, new int[] {5}, new int[] {3,4,5});
        String formula1Op2 = genFormulaFormatter(formObject, new int[] {11}, new int[] {3,4,5});
        String formula2Op1 = genFormulaFormatter(formObject, new int[] {5}, new int[] {6,7,8,9,10,11});
        String formula2Op2 = genFormulaFormatter(formObject, new int[] {11}, new int[] {6,7,8,9,10,11});

        String operationForm = formula1Op1 + "+" + formula1Op2 + "|" +
                formula2Op1 + "+" + formula2Op2 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10501000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10501000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {15}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {15}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField3 + "|" + formulaField4;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10502000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10502000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {38}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {38}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10701000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS10701000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "22|23|24", "3");
        String formulaField3 = genFormulaFormatter(formObject, "22|23|24", "4|5|6");
        String formulaField4 = genFormulaFormatter(formObject, "22|23|24", "7|8|9|10|11|12");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4;

        return UtilSegmentValidation.genSumEqualPeriodePelaporan(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10702000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10702000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {7,8,9}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {7,8,9,10}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10801000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10801000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {20}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {20}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10802000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10802000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {48}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {48}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10901000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10901000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {27, 28}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {27, 28}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS10902000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS10902000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {20}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {20}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11001000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS11001000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {20}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {20}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11101000000(programs(PPMPK), () -> {
        String selectField = "3|4";
        String selectPosCode = R_RAS11101000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField3 = genFormulaFormatter(formObject, new int[] {6}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {6}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11102000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11102000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, new int[] {5,6}, new int[] {2});
        String formulaField3 = genFormulaFormatter(formObject, new int[] {5,6}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {5,6}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11201000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11201000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();

        List<KeyValueString> formObject = ER7003PosLtlbDppkNrc.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, new int[] {22}, new int[] {2}); // ??
        String formulaField3 = genFormulaFormatter(formObject, new int[] {22}, new int[] {3,4,5});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {22}, new int[] {6,7,8,9,10,11});

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11202000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11202000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, new int[] {48}, new int[] {3}); // ??
        String formulaField3 = genFormulaFormatter(formObject, new int[] {48}, new int[] {4,5,6});
        String formulaField4 = genFormulaFormatter(formObject, new int[] {48}, new int[] {7,8,9,10,11,12});

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11301000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11301000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "0|1|2", "3")
                + "+" + genFormulaFormatter(formObject, "21", "3");
        String formulaField3 = genFormulaFormatter(formObject, "0|1|2", "4|5|6")
                + "+" + genFormulaFormatter(formObject, "21", "4|5|6");
        String formulaField4 = genFormulaFormatter(formObject, "0|1|2", "7|8|9|10|11|12")
                + "+" + genFormulaFormatter(formObject, "21", "7|8|9|10|11|12");;

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    //RAS11302000000
    SG_MULTI_SUM_RAS11302000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11302000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "14|15|17", "2");
        String formulaField3 = genFormulaFormatter(formObject, "14|15", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "17", "3|4|5");
        String formulaField4 = genFormulaFormatter(formObject, "14|15", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "17", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genSumEqualPeriodePelaporan(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    //RAS11401000000
    SG_MULTI_SUM_RAS11401000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11401000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();

        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String formulaField2 = genFormulaFormatter(formObject, "0|1|2|3|4", "2") + "+" +
                genFormulaFormatter(formObject, "9", "2") + "+" +
                genFormulaFormatter(formObject, "11", "2") + "+" +
                genFormulaFormatter(formObject, "13", "2") + "+" +
                genFormulaFormatter(formObject, "15", "2") + "+" +
                genFormulaFormatter(formObject, "19|20|21|22|23", "2");

        String formulaField3 = genFormulaFormatter(formObject, "0|1|2|3|4", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "9", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "11", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "13", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "15", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "19|20|21|22|23", "3|4|5");

        String formulaField4 = genFormulaFormatter(formObject, "0|1|2|3|4", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "9", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "11", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "13", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "15", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "19|20|21|22|23", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    //RAS11402000000
    SG_MULTI_SUM_RAS11402000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11402000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();

        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String formulaField2 = genFormulaFormatter(formObject, "5|6", "2") + "+" +
                genFormulaFormatter(formObject, "8", "2") + "+" +
                genFormulaFormatter(formObject, "10", "2") + "+" +
                genFormulaFormatter(formObject, "12", "2") + "+" +
                genFormulaFormatter(formObject, "14", "2") + "+" +
                genFormulaFormatter(formObject, "16|17", "2") + "+" +
                genFormulaFormatter(formObject, "24|25|26", "2");

        String formulaField3 = genFormulaFormatter(formObject, "5|6", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "8", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "10", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "12", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "14", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "16|17", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "24|25|26", "3|4|5");

        String formulaField4 = genFormulaFormatter(formObject, "5|6", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "8", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "10", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "12", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "14", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "16|17", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "24|25|26", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11501000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11501000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "22|23|24", "3");
        String formulaField3 = genFormulaFormatter(formObject, "22|23|24", "4|5|6");
        String formulaField4 = genFormulaFormatter(formObject, "22|23|24", "7|8|9|10|11|12");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11502000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11502000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "48", "3");
        String formulaField3 = genFormulaFormatter(formObject, "48", "4|5|6");
        String formulaField4 = genFormulaFormatter(formObject, "48", "7|8|9|10|11|12");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11601000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11601000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();

        List<KeyValueString> formObject = ER7001PosLtlbDppkLan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "22", "3");
        String formulaField3 = genFormulaFormatter(formObject, "22", "4|5|6");
        String formulaField4 = genFormulaFormatter(formObject, "22", "7|8|9|10|11|12");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    // RAS11701000000
    SG_MULTI_SUM_RAS11701000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS11701000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String operationForm = genFormulaFormatter(ER7012PosLtlbDppkAlm.getObjects(PPMPK), "49", "7|10|13");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    // RAS11702000000
    SG_MULTI_SUM_RAS11702000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS11702000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();

        String operationForm = genFormulaFormatter(ER7005PosLtlbDppkLak.getObjects(), "0|1|2|3", "2") + "+" +
                genFormulaFormatter(ER7005PosLtlbDppkLak.getObjects(), "15", "2");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11801000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11801000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();

        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String formulaField2 = genFormulaFormatter(formObject, "6", "2") + "+" +
                genFormulaFormatter(formObject, "8", "2") + "+" +
                genFormulaFormatter(formObject, "25", "2");
        String formulaField3 = genFormulaFormatter(formObject, "6", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "8", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "25", "3|4|5");
        String formulaField4 = genFormulaFormatter(formObject, "6", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "8", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "25", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11802000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11802000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAK.getCode();

        List<KeyValueString> formObject = ER7005PosLtlbDppkLak.getObjects();

        String formulaField2 = genFormulaFormatter(formObject, "0|1|2|3", "2") + "+" +
                genFormulaFormatter(formObject, "15", "2");
        String formulaField3 = genFormulaFormatter(formObject, "0|1|2|3", "3|4|5") + "+" +
                genFormulaFormatter(formObject, "15", "3|4|5");
        String formulaField4 = genFormulaFormatter(formObject, "0|1|2|3", "6|7|8|9|10|11") + "+" +
                genFormulaFormatter(formObject, "15", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS11902000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS11902000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_KUP.getCode();

        List<KeyValueString> formObject = ER7007PosLtlbDppkKup.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "17", "3");
        String formulaField3 = genFormulaFormatter(formObject, "17", "4");
        String formulaField4 = genFormulaFormatter(formObject, "17", "5");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS12010000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS12010000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String operationForm = genFormulaFormatter(ER7012PosLtlbDppkAlm.getObjects(PPMPK), "39", "4");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS12020000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS12020000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String operationForm = genFormulaFormatter(ER7012PosLtlbDppkAlm.getObjects(PPMPK), "39", "16");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS13010000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS13010000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String operationForm = genFormulaFormatter(ER7012PosLtlbDppkAlm.getObjects(PPMPK), "49", "4");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS13020000000(programs(PPMPK), () -> {
        String selectField = "2";
        String selectPosCode = R_RAS13020000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ALM.getCode();
        String operationForm = genFormulaFormatter(ER7012PosLtlbDppkAlm.getObjects(PPMPK), "49", "16");

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS14010000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS14010000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "14|15", "2");
        String formulaField3 = genFormulaFormatter(formObject, "14|15", "3|4|5");
        String formulaField4 = genFormulaFormatter(formObject, "14|15", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
    }),

    SG_MULTI_SUM_RAS14020000000(programs(PPMPK), () -> {
        String selectField = "2|3|4";
        String selectPosCode = R_RAS14020000000.key;
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LPAN.getCode();

        List<KeyValueString> formObject = ER7002PosLtlbDppkLpan.getObjects(PPMPK);

        String formulaField2 = genFormulaFormatter(formObject, "5|6", "2");
        String formulaField3 = genFormulaFormatter(formObject, "5|6", "3|4|5");
        String formulaField4 = genFormulaFormatter(formObject, "5|6", "6|7|8|9|10|11");

        String operationForm = formulaField2 + "|" + formulaField3 + "|" + formulaField4 ;

        return UtilSegmentValidation.genRas1ComparationValidation(selectField, selectPosCode, comparatorForm, operationForm, MessageType.DETAIL);
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

    public static final BaseMetadataValidation<E7017Ras1ValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7017Ras1ValidationsConfig.class, PPMPK);

}
