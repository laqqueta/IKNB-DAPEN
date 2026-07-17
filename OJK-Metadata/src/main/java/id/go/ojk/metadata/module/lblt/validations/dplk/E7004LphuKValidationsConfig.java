package id.go.ojk.metadata.module.lblt.validations.dplk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
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

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7004PosLtlbDppkLphu.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7004LphuKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_IF_MULTI_BINV(programs(DPLK),
            () -> genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects(), 6, 11),
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi")),

    SG_SUM_IF_PDIN(programs(DPLK),
            () -> genValidationSumIf(R_LPHU0601000000.key,
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUM_IF_BIPR(programs(DPLK),
            () -> genValidationSumIf(R_LPHU0602000000.key,
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUM_IF_PPH(programs(DPLK),
            () -> genValidationSumIf(R_LPHU0800000000.key,
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_ADDITION_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0106000000.key,
                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 0, 4),
                    UtilMetadata.genMessage(R_LPHU0106000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 0, 4)))),

    SG_ADDITION_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0300000000.key,
                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), 6, 11),
                    UtilMetadata.genMessage(R_LPHU0300000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), 6, 11)))),

    SG_SUBSTRACTION_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0400000000.key,
                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{5, 12}),
                    UtilMetadata.genMessage(R_LPHU0400000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[]{5, 12})))),

    SG_EQUAL_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0502000000.key,
                    UtilMetadata.genPlusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[] { 14 }),
                    UtilMetadata.genMessage(R_LPHU0502000000.value, UtilMetadata.genPlusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[] { 14 })))),

    SG_SUBSTRACTION_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0603000000.key,
                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{16, 17}),
                    UtilMetadata.genMessage(R_LPHU0603000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[]{16, 17})))),

    SG_MIX_ADD_SUB(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0700000000.key,
                    UtilMetadata.genMinusRow(getObjects(), new int[]{13, 15}) + "+LPHU0603000000",
                    UtilMetadata.genMessage(R_LPHU0700000000.value,
                            UtilMetadata.genMinusDesc(getObjects(), new int[]{13, 15}) + "+Total Pendapatan dan Beban Lain-Lain"))),

    SG_SUBSTRACTION_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 16), R_LPHU0900000000.key,
                    UtilMetadata.genMinusRow(ER7004PosLtlbDppkLphu.getObjects(), new int[]{28, 29}),
                    UtilMetadata.genMessage(R_LPHU0900000000.value, UtilMetadata.genMinusDesc(ER7004PosLtlbDppkLphu.getObjects(), new int[]{28, 29})))),


    SG_ROW_VALIDATION_8A(programs(DPLK),
            () -> genRowValidation(R_LPHU0101000000.getObject(), "2")),

    SG_ROW_VALIDATION_8B(programs(DPLK),
            () -> genRowValidation(R_LPHU0102000000.getObject(), "3")),

    SG_ROW_VALIDATION_8C(programs(DPLK),
            () -> genRowValidation(R_LPHU0103000000.getObject(), "4")),

    SG_ROW_VALIDATION_8D(programs(DPLK),
            () -> genRowValidation(R_LPHU0104000000.getObject(), "5")),

    SG_ROW_VALIDATION_8E(programs(DPLK),
            () -> genRowValidation(R_LPHU0105000000.getObject(), "6")),

    FV_EQUALS(programs(DPLK), validationFields(Dppk0004Lphu.AKUMULASI_GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7004PosLtlbDppkLphu.getObjects()), 2))

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

    public static final BaseMetadataValidation<E7004LphuKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7004LphuKValidationsConfig.class, DPLK);

    private static SegmentValidation genValidationSumIfMultiCriteria(String row, String formComparator, String comparatorRow, String additionalCriteria, String additionalCriteriaErr, String errMsg) {
        String sumField = "2";
        String comparatorRangeField = "3";
        String comparatorCriteriaField = "4|2";
        String criteriaKey = "0";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteria;
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteriaErr;
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genMultiCriteriaSumIf(UtilMetadata.genPipeColumn(2, 11), row,
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

        return UtilSegmentValidationV2.genSumIf(UtilMetadata.genPipeColumn(2, 11), row,
                comparatorForm, comparatorRow,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation  genRowValidation(KeyValueString posCode, String comparatorField) {

        String msg = UtilMetadata.genMessage(posCode.getValue(),
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getValue());

        return UtilSegmentValidationV2.genEqualsForm("2", posCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey(), msg + " pada form ROI");
    }

}
