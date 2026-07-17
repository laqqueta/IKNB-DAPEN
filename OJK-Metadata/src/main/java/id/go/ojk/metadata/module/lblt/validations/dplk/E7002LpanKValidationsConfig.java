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
import id.go.ojk.conf.client.dto.FormulaParserData;
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

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.reference.ER7002PosLtlbDppkLpan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7002LpanKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_PPIN(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0103000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_IUR(programs(DPLK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidationV2.genSumIfOffset(
                        UtilMetadata.genPipeColumn(2, 12), R_LPAN0104000000.getObject().getKey(),
                        EFormLaporanBulananTahunan.LTLB_IUR.getCode(),
                        ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                        "4|5|6", "7", "2", criteriaCondition, sumCriteriaCondition,
                        "IUR|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Penerimaan Iuran - Iuran Normal Peserta|Penerimaan Iuran - Iuran Normal Pemberi|Penerimaan Iuran - Iuran Sukarela Peserta");
            }
    ),

    SG_SUMIF_PDIN(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0105000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDPL(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0106000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                    "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BINV(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0201000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BIPR(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0203000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PPH(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0205000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PKPL(programs(DPLK),
            () -> genSumIfValidation(R_LPAN0206000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                    "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_EQUAL_FORMULA_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    R_LPAN0102000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.DPLK), 0, 4),
                    UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.DPLK), 0, 4)))),

    SG_EQUAL_FORMULA_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    R_LPAN0107000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.DPLK), 6, 11),
                    UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.DPLK), 6, 11)))),

    SG_EQUAL_FORMULA_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    R_LPAN0209000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.DPLK), 13, 19),
                    UtilMetadata.genMessage(R_LPAN0209000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.DPLK), 13, 19)))),

    SG_EQUAL_FORMULA_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    R_LPAN0300000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.DPLK), new int[]{5, 12}) + "-LPAN0208000000",
                    UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.DPLK), new int[]{5, 12}) + "-LPAN0208000000"))),

    SG_EQUAL_FORMULA_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
                    R_LPAN0500000000.getObject().getKey(), UtilMetadata.genMinusRow(getObjects(ProgramType.DPLK), new int[]{22, 21}),
                    UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(ProgramType.DPLK), new int[]{22, 21})))),

    SG_EQUAL_FORMULA_ROI_1(programs(DPLK),
            () -> genRowValidation(R_LPAN0101010000.getObject(), "2")),

    SG_EQUAL_FORMULA_ROI_2(programs(DPLK),
            () -> genRowValidation(R_LPAN0101020000.getObject(), "3")),

    SG_EQUAL_FORMULA_ROI_3(programs(DPLK),
            () -> genRowValidation(R_LPAN0101030000.getObject(), "4")),

    SG_EQUAL_FORMULA_ROI_4(programs(DPLK),
            () -> genRowValidation(R_LPAN0101040000.getObject(), "5")),

    SG_EQUAL_FORMULA_ROI_5(programs(DPLK),
            () -> genRowValidation(R_LPAN0101050000.getObject(), "6")),

    /* Update pak Yahya */

    SG_LPAN0103000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
        String fields = "Hasil Investasi yang Belum Terealisasi";
        FormulaParserData operationForm = genFormulaParser(ER7009PosLtlbDppkRoi.getObjects(DPLK), "20", "7", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ROI";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("12", R_LPAN0103000000.getObject().getKey(), operationForm.getFormula(), operationFormErr);
    }),

    SG_LPAN0201000000(programs(DPLK), () -> {
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
        String fields = "Beban Investasi";
        FormulaParserData operationForm = genFormulaParser(ER7009PosLtlbDppkRoi.getObjects(DPLK), "20", "8", fields, comparatorForm);
        String operationFormErr = "sama dengan Baris " + operationForm.getErrMessage() + " pada form ROI";
        return UtilSegmentValidationV2.genFormulaParserValidationV2("12", R_LPAN0201000000.getObject().getKey(), operationForm.getFormula(), operationFormErr);
    }),


    FV_EQUAL_FORMULA_EXCEPT_1(programs(DPLK), validationFields(Dppk0002Lpan.GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.DPLK), new int[]{5, 12, 20, 21, 23}), 2)),

    FV_EQUAL_FORMULA_EXCEPT_2(programs(DPLK), validationFields(Dppk0002Lpan.TOTAL),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(12, 15),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.DPLK), new int[]{5, 12, 20, 21, 23}), 2));

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

    public static final BaseMetadataValidation<E7002LpanKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7002LpanKValidationsConfig.class, DPLK);

    private static SegmentValidation genSumIfValidation(String posCode, String rangeField, String criteriaField, String formCode,
                                                        String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidationV2.genSumIf(UtilMetadata.genPipeColumn(2, 12), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genRowValidation(KeyValueString posCode, String comparatorField) {
        String msg = UtilMetadata.genMessage(posCode.getValue(),
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getValue());

        return UtilSegmentValidationV2.genEqualsForm("2", posCode.getKey(),
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey(), msg + " pada form ROI");
    }

}
