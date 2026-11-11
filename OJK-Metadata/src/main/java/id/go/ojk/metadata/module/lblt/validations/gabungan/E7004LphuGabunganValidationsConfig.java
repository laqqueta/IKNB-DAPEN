package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.*;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.conf.client.field.reference.ER1263BebanInvestasi;
import id.go.ojk.conf.client.field.reference.ER1264BebanOperasinal;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.field.Dppk0004Lphu;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7004PosLtlbDppkLphu.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPPPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7004LphuGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

//    SG_SUM_IF_MULTI_BINV_PPMP_1A(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 6),
//                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
//                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
//                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPMP")),
//
//    SG_SUM_IF_MULTI_BINV_PPIP_1B(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 6),
//                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
//                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
//                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPIP")),
//
//    SG_SUM_IF_MULTI_BINV_PPMP_2A(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria2(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 7, 7),
//                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
//                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
//                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPMP")),
//
//    SG_SUM_IF_MULTI_BINV_PPIP_2B(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria2(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 7, 7),
//                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
//                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
//                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPIP")),

    SG_SUM_IF_MULTI_BINV_PPMP_3A(programs(PPMPPPIPK),
            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11),
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPMP")),

    SG_SUM_IF_MULTI_BINV_PPIP_3B(programs(PPMPPPIPK),
            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11),
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi", "PPIP")),


//    SG_SUM_IF_MULTI_BOPR_PPMP(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20),
//                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
//                    ER1264BebanOperasinal.getPipedReferenceKeys(), ER1264BebanOperasinal.getPipedReferenceKeyValues(),
//                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Operasional", "PPMP")),
//
//    SG_SUM_IF_MULTI_BOPR_PPIP(programs(PPMPPPIPK),
//            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20),
//                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
//                    ER1264BebanOperasinal.getPipedReferenceKeys(), ER1264BebanOperasinal.getPipedReferenceKeyValues(),
//                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Operasional", "PPIP")),
//
//    SG_SUM_IF_PDIN_PPMP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0604000000.key,
//                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
//                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPMP")),
//
//    SG_SUM_IF_PDIN_PPIP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0604000000.key,
//                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
//                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPIP")),
//
//    SG_SUM_IF_BIPR_PPMP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0605000000.key,
//                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
//                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPMP")),
//
//    SG_SUM_IF_BIPR_PPIP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0605000000.key,
//                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
//                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPIP")),
//
//    SG_SUM_IF_PPH_PPMP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0800000000.key,
//                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
//                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPMP")),
//
//    SG_SUM_IF_PPH_PPIP(programs(PPMPPPIPK),
//            () -> genValidationSumIf(R_LPHU0800000000.key,
//                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
//                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", "PPIP")),
//
//    SG_ADDITION_1A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0106000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 0, 4),
//                    UtilMetadata.genMessage(R_LPHU0106000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 0, 4)))),
//
//    SG_ADDITION_1B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0106000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 0, 4),
//                    UtilMetadata.genMessage(R_LPHU0106000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 0, 4)))),
//
//    SG_ADDITION_2A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0300000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11),
//                    UtilMetadata.genMessage(R_LPHU0300000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11)))),
//
//    SG_ADDITION_2B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0300000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11),
//                    UtilMetadata.genMessage(R_LPHU0300000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 6, 11)))),
//
//    SG_ADDITION_3A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0508000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20),
//                    UtilMetadata.genMessage(R_LPHU0508000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20)))),
//
//    SG_ADDITION_3B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0508000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20),
//                    UtilMetadata.genMessage(R_LPHU0508000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 14, 20)))),
//
//    SG_ADDITION_4A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0606000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 22, 25) + "-LPHU0605000000",
//                    UtilMetadata.genMessage(R_LPHU0606000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 22, 25) + "-Beban Lain di Luar Investasi dan Operasional"))),
//
//    SG_ADDITION_4B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0606000000.key,
//                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 22, 25) + "-LPHU0605000000",
//                    UtilMetadata.genMessage(R_LPHU0606000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), 22, 25) + "-Beban Lain di Luar Investasi dan Operasional"))),
//
//    SG_SUBSTRACTION_1A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0400000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12}),
//                    UtilMetadata.genMessage(R_LPHU0400000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12})))),
//
//    SG_SUBSTRACTION_1B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0400000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12}),
//                    UtilMetadata.genMessage(R_LPHU0400000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12})))),
//
//    SG_SUBSTRACTION_2A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0900000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{28, 29}),
//                    UtilMetadata.genMessage(R_LPHU0900000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{28, 29})))),
//
//    SG_SUBSTRACTION_2B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0900000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{28, 29}),
//                    UtilMetadata.genMessage(R_LPHU0900000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{28, 29})))),
//
//    SG_MIX_ADD_SUB_A(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 17), R_LPHU0700000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{13, 21}) + "+LPHU0606000000",
//                    UtilMetadata.genMessage(R_LPHU0700000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{13, 21}) + "+'Total Pendapatan dan Beban Lain-Lain'"))),
//
//    SG_MIX_ADD_SUB_B(programs(PPMPPPIPK),
//            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPHU0700000000.key,
//                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{13, 21}) + "+LPHU0606000000",
//                    UtilMetadata.genMessage(R_LPHU0700000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{13, 21}) + "+'Total Pendapatan dan Beban Lain-Lain'"))),
//
//    SG_ROW_VALIDATION_8A(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPHU0101000000.getObject(), "3")),
//
//    SG_ROW_VALIDATION_8B(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPHU0102000000.getObject(), "4")),
//
//    SG_ROW_VALIDATION_8C(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPHU0103000000.getObject(), "5")),
//
//    SG_ROW_VALIDATION_8D(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPHU0104000000.getObject(), "6")),
//
//    SG_ROW_VALIDATION_8E(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPHU0105000000.getObject(), "7")),

    FV_EQUALS(programs(PPMPPPIPK), validationFields(Dppk0004Lphu.AKUMULASI_GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(3, 12),
                    UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12, 13, 21, 27, 28, 30}), 2)),

    FV_EQUAL_FORMULA_EXCEPT_2(programs(PPMPPPIPK), validationFields(Dppk0004Lphu.TOTAL),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(14, 16),
                    UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK), new int[]{5, 12, 13, 21, 27, 28, 30}), 2)),

    CR_EXISTS_POS_M(programs(PPMPPPIPK), validationFields(1001, 1002, 1003, 1004),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M",
                    UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(PPMPPPIPK)), "2", "PPMP")),

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

    public static final BaseMetadataValidation<E7004LphuGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7004LphuGabunganValidationsConfig.class, PPMPPPIPK);

    private static SegmentValidation genValidationSumIfMultiCriteria(String row, String formComparator, String comparatorRow, String additionalCriteria, String additionalCriteriaErr, String errMsg, String jenisProgram) {
        String sumField = "3";
        String comparatorRangeField = "4";
        String comparatorCriteriaField = "5|3";
        String criteriaKey = "0";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String column = UtilMetadata.genPipeColumn(3, 12);

        if (jenisProgram.equals("PPIP")) {
            column = UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13});
            criteriaCondition += "|" + ER1255JenisManfaat.getPipedReferenceKeys("UUS1|UUS2|UUS3");
            criteriaConditionErr += "|" + ER1255JenisManfaat.getPipedReferenceKeyValues("UUS1|UUS2|UUS3");
        }

        criteriaCondition += "$" + additionalCriteria;
        criteriaConditionErr += "$" + additionalCriteriaErr;

        return UtilSegmentValidationV2.genMultiCriteriaSumIf(column, row,
                formComparator, comparatorRow,
                comparatorRangeField, comparatorCriteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", jenisProgram,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr, criteriaKey);
    }

    private static SegmentValidation genValidationSumIfMultiCriteria2(String row, String formComparator, String comparatorRow, String additionalCriteria, String additionalCriteriaErr, String errMsg, String jenisProgram) {
        String sumField = "3";
        String comparatorRangeField = "4";
        String comparatorCriteriaField = "5|3";
        String criteriaKey = "0";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        String column = UtilMetadata.genPipeColumn(3, 12);

        if (jenisProgram.equals("PPIP")) {
            column = UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13});
            criteriaCondition += "|" + ER1255JenisManfaat.getPipedReferenceKeys("UUS1|UUS2|UUS3");
            criteriaConditionErr += "|" + ER1255JenisManfaat.getPipedReferenceKeyValues("UUS1|UUS2|UUS3");
        }

        criteriaCondition += "$" + additionalCriteria;
        criteriaConditionErr += "$" + additionalCriteriaErr;

        return UtilSegmentValidationV2.genMultiCriteriaSumIf(column, row,
                formComparator, comparatorRow,
                comparatorRangeField, comparatorCriteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", jenisProgram,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr, criteriaKey);
    }

    private static SegmentValidation genValidationSumIf(String row, String comparatorForm, String comparatorRow, String errMsg, String jenisProgram) {
        String sumField = "3";
        String rangeField = "4";
        String criteriaField = "5";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        String column = UtilMetadata.genPipeColumn(3, 12);

        if (jenisProgram.equals("PPIP")) {
            column = UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13});
            criteriaCondition += "|" + ER1255JenisManfaat.getPipedReferenceKeys("UUS1|UUS2|UUS3");
            criteriaConditionErr += "|" + ER1255JenisManfaat.getPipedReferenceKeyValues("UUS1|UUS2|UUS3");
        }

        return UtilSegmentValidationV2.genSumIfFilter(column, row,
                comparatorForm, comparatorRow,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", jenisProgram,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genRowValidation(KeyValueString posCode, String comparatorField) {

        String msg = UtilMetadata.genMessage(posCode.getValue(),
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getValue());

        return UtilSegmentValidationV2.genEqualsForm("3", posCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey(),
                "2", "PPMP|PPIP",
                msg + " pada form ROI", 2);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}).split("\\|")).size());
        ;
    }

}
