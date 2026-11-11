package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.*;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.field.Dppk0002Lpan;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7002PosLtlbDppkLpan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7002LpanGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_PPIN_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0103000000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain#3")),

    SG_SUMIF_PPIN_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0103000000.getObject().getKey(), "5", "6",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain#3")),

    SG_SUMIF_IUR_PPMP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumn(3, 12), UtilMetadata.genPipeRow(ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK), 7, 10),
                        EFormLaporanBulananTahunan.LTLB_IUR.getCode(),
                        ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                        "8|6|9|10", "18", "3", criteriaCondition, sumCriteriaCondition, /*7|5|8|9 8 6 9 10*/
                        "2", "PPMP",
                        "IUR|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah|" +
                                "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah|" +
                                "Iuran Jatuh Tempo - Iuran Sukarela Peserta|" +
                                "Iuran Jatuh Tempo - Iuran Tambahan");
            }),

    SG_SUMIF_IUR_PPIP(programs(PPMPPPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfFilter(
                        UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), UtilMetadata.genPipeRow(ER7002PosLtlbDppkLpan.getObjects(PPMPPPIPK), 7, 10),
                        EFormLaporanBulananTahunan.LTLB_IUR.getCode(),
                        ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                        "8|6|9|10", "18", "3", criteriaCondition, sumCriteriaCondition,
                        "2", "PPIP",
                        "IUR|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah|" +
                                "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah|" +
                                "Iuran Jatuh Tempo - Iuran Sukarela Peserta|" +
                                "Iuran Jatuh Tempo - Iuran Tambahan");
            }),

    SG_SUMIF_PDIN_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0105000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDIN_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0105000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDPL_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0106000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                    "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDPL_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0106000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                    "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BINV_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0201000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain#2")),

    SG_SUMIF_BINV_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0201000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain#2")),

    SG_SUMIF_BOPR_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0202000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BOPR_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0202000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BIPR_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0203000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BIPR_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0203000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PPH_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0205000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PPH_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0205000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PKPL_PPMP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPMP(R_LPAN0206000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                    "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PKPL_PPIP(programs(PPMPPPIPK),
            () -> genSumIfValidation_PPIP(R_LPAN0206000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                    "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    // SUM FORMULA PPMP SEGMENT
    SG_EQUAL_FORMULA_1_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPAN0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 0, 4),
                    UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 0, 4)))),

    SG_EQUAL_FORMULA_2_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPAN0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 5, 12),
                    UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 5, 12)))),

    SG_EQUAL_FORMULA_3_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPAN0208000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 14, 20),
                    UtilMetadata.genMessage(R_LPAN0208000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 14, 20)))),

    SG_EQUAL_FORMULA_4_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPAN0300000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(getObjects(ProgramType.PPMPPPIPK), new int[]{13, 21}),
                    UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(getObjects(ProgramType.PPMPPPIPK), new int[]{13, 21})))),

    SG_EQUAL_FORMULA_5_PPMP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPMP(UtilMetadata.genPipeColumn(3, 13), R_LPAN0500000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), new int[]{23, 22}),
                    UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), new int[]{23, 22})))),

    // SUM FORMULA PPIP SEGMENT
    SG_EQUAL_FORMULA_1_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 16),
                    R_LPAN0102000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 0, 4),
                    UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 0, 4)))),

    SG_EQUAL_FORMULA_2_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 16),
                    R_LPAN0107000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 5, 12),
                    UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 5, 12)))),

    SG_EQUAL_FORMULA_3_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 16),
                    R_LPAN0208000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), 14, 20),
                    UtilMetadata.genMessage(R_LPAN0208000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), 14, 20)))),

    SG_EQUAL_FORMULA_4_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 16),
                    R_LPAN0300000000.getObject().getKey(), UtilMetadata.genMinusRow(getObjects(ProgramType.PPMPPPIPK), new int[]{13, 21}),
                    UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(ProgramType.PPMPPPIPK), new int[]{13, 21})))),

    SG_EQUAL_FORMULA_5_PPIP(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula_DAPEN_PPIP(UtilMetadata.genPipeColumn(3, 16),
                    R_LPAN0500000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPPPIPK), new int[]{23, 22}),
                    UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPPPIPK), new int[]{23, 22})))),

//    SG_EQUAL_FORMULA_ROI_1(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPAN0101010000.getObject(), "3")),
//
//    SG_EQUAL_FORMULA_ROI_2(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPAN0101020000.getObject(), "4")),
//
//    SG_EQUAL_FORMULA_ROI_3(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPAN0101030000.getObject(), "5")),
//
//    SG_EQUAL_FORMULA_ROI_4(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPAN0101040000.getObject(), "6")),
//
//    SG_EQUAL_FORMULA_ROI_5(programs(PPMPPPIPK),
//            () -> genRowValidation(R_LPAN0101050000.getObject(), "7")),

    /* Update pak Yahya */

    SG_LPAN0103000000_PPMP(programs(PPMPPPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0103000000.getObject();
                String selectColumn = "13";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_PPIN.getCode();
                String comparatorColumn = "5";
                String comparatorPosCode = ER7060PosLtlbDppkPpin.R_PPIN000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Peningkatan / Penurunan pada form " + comparatorForm;
                return UtilSegmentValidationV2.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, comparatorForm,
                        "2", "PPMP",
                        errMsg, 2);
            }),

    SG_LPAN0103000000_PPIP(programs(PPMPPPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0103000000.getObject();
                String selectColumn = "17";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_PPIN.getCode();
                String comparatorColumn = "5";
                String comparatorPosCode = ER7060PosLtlbDppkPpin.R_PPIN000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Peningkatan / Penurunan pada form " + comparatorForm;
                return UtilSegmentValidationV2.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, comparatorForm,
                        "2", "PPIP",
                        errMsg, 2);
            }),

    SG_LPAN0201000000_PPMP(programs(PPMPPPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0201000000.getObject();
                String selectColumn = "13";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
                String comparatorColumn = "9";
                String comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Beban Investasi pada form " + comparatorForm;
                return UtilSegmentValidationV2.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, comparatorForm,
                        "2", "PPMP",
                        errMsg, 2);
            }),

    SG_LPAN0201000000_PPIP(programs(PPMPPPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0201000000.getObject();
                String selectColumn = "17";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
                String comparatorColumn = "9";
                String comparatorPosCode = ER7009PosLtlbDppkRoi.R_ROI2100000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Beban Investasi pada form " + comparatorForm;
                return UtilSegmentValidationV2.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, comparatorForm,
                        "2", "PPIP",
                        errMsg, 2);
            }),


    FV_EQUAL_FORMULA_EXCEPT_1(programs(PPMPPPIPK), validationFields(12),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(3, 12),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPPPIPK), new int[]{5, 13, 21, 22, 24}), 2)),

    FV_EQUAL_FORMULA_EXCEPT_2(programs(PPIPK), validationFields(1004),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(13, 16),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPPPIPK), new int[]{5, 13, 21, 22, 24}), 2)),

    CR_EXISTS_POS_M(programs(PPMPPPIPK), validationFields(1001, 1002, 1003, 1004),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValue("N", "M",
                    UtilMetadata.genPipeRow(getObjects(PPMPPPIPK)), "2", "PPMP")),
    
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

    public static final BaseMetadataValidation<E7002LpanGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7002LpanGabunganValidationsConfig.class, PPMPPPIPK);

    private static SegmentValidation genSumIfValidation_PPMP(String posCode, String rangeField, String criteriaField, String formCode,
                                                             String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumn(3, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPMP",
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genSumIfValidation_PPIP(String posCode, String rangeField, String criteriaField, String formCode,
                                                             String formObjects, String errMsg) {
        String sumField = "3";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIfFilter(UtilMetadata.genPipeColumnExcept(3, 16, new int[]{13}), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                "2", "PPIP",
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

}
