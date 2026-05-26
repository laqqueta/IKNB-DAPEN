package id.go.ojk.metadata.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.conf.client.field.reference.ER1263BebanInvestasi;
import id.go.ojk.conf.client.field.reference.ER1264BebanOperasinal;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7004PosLtlbDppkLphu.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7004LphuKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_IF_MULTI_BINV(programs(PPMPK),
            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(), 6, 11),
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi")),

    SG_SUM_IF_MULTI_BOPR(programs(PPMPK),
            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(), 14, 20),
                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                    ER1264BebanOperasinal.getPipedReferenceKeys(), ER1264BebanOperasinal.getPipedReferenceKeyValues(),
                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Operasional")),

    SG_SUM_IF_PDIN(programs(PPMPK),
            () -> genValidationSumIf(R_LPHU0604000000.key,
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUM_IF_BIPR(programs(PPMPK),
            () -> genValidationSumIf(R_LPHU0605000000.key,
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUM_IF_PPH(programs(PPMPK),
            () -> genValidationSumIf(R_LPHU0800000000.key,
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),
    
    SG_ADDITION_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0106000000.key, UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 0, 4),
                    UtilMetadata.genMessage(R_LPHU0106000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 0, 4)))),

    SG_ADDITION_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0300000000.key, UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 6, 11),
                    UtilMetadata.genMessage(R_LPHU0300000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 6, 11)))),

    SG_ADDITION_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0508000000.key, UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 14, 20),
                    UtilMetadata.genMessage(R_LPHU0508000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 14, 20)))),

    SG_ADDITION_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0606000000.key, UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 22, 25) + "-LPHU0605000000",
                    UtilMetadata.genMessage(R_LPHU0606000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 22, 25) + "-LPHU0605000000"))),

    SG_SUBSTRACTION_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0400000000.key, UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{5, 12}),
                    UtilMetadata.genMessage(R_LPHU0400000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[]{5, 12})))),
    
    SG_SUBSTRACTION_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0900000000.key, UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{28, 29}),
                    UtilMetadata.genMessage(R_LPHU0900000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[]{28, 29})))),
    
    SG_MIX_ADD_SUB(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0700000000.key, UtilMetadata.genMinusRow(getObjects(), new int[] {13, 21}) + "+LPHU0606000000",
                    UtilMetadata.genMessage(R_LPHU0700000000.value, UtilMetadata.genMinusRow(getObjects(), new int[] {13, 21}) + "+LPHU0606000000"))),
    
    SG_ROW_VALIDATION_8A(programs(PPMPK),
            () -> genRowValidation(R_LPHU0101000000.key, "2")),

    SG_ROW_VALIDATION_8B(programs(PPMPK),
            () -> genRowValidation(R_LPHU0102000000.key, "3")),

    SG_ROW_VALIDATION_8C(programs(PPMPK),
            () -> genRowValidation(R_LPHU0103000000.key, "4")),

    SG_ROW_VALIDATION_8D(programs(PPMPK),
            () -> genRowValidation(R_LPHU0104000000.key, "5")),

    SG_ROW_VALIDATION_8E(programs(PPMPK),
            () -> genRowValidation(R_LPHU0105000000.key, "6")),
    
    FV_EQUALS(programs(PPMPK), validationFields(12),
            () ->  UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{5, 12, 13, 21, 27, 28, 30}), 2))

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

    public static final BaseMetadataValidation<E7004LphuKValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7004LphuKValidationsConfig.class, PPMPK);

    private static SegmentValidation genValidationSumIfMultiCriteria(String row, String formComparator, String comparatorRow, String additionalCriteria, String additionalCriteriaErr, String errMsg) {
        String sumField = "2";
        String comparatorRangeField = "3";
        String comparatorCriteriaField = "4|2";
        String criteriaKey = "0";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteria;
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteriaErr;
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genMultiCriteriaSumIf(UtilMetadata.genPipeColumn(2, 11), row,
                formComparator, comparatorRow,
                comparatorRangeField, comparatorCriteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr, criteriaKey);
    }

    private static SegmentValidation genValidationSumIf(String row, String comparatorForm, String comparatorRow, String errMsg) {
        String sumField = "2";
        String rangeField = "3";
        String criteriaField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), row,
                comparatorForm, comparatorRow,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genRowValidation(String posCode, String comparatorField) {
        return UtilSegmentValidation.genEqualsForm("2", posCode,
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey());
    }

}
