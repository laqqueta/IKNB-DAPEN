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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7002PosLtlbDppkLpan.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7002LpanValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_PPIN(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0103000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_IUR(programs(PPMPK),
            () -> genSumIfValidation(UtilMetadata.genPipeRow(ER7002PosLtlbDppkLpan.getObjects(ProgramType.PPMPK), 7, 10), "6|5|7|8", "17",
                    EFormLaporanBulananTahunan.LTLB_IUR.getCode(), ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                    "IUR|Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDIN(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0105000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDPL(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0106000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                    "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BINV(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0201000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BOPR(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0202000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BIPR(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0203000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PPH(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0205000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PKPL(programs(PPMPK),
            () -> genSumIfValidation(R_LPAN0206000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                    "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_EQUAL_FORMULA_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    R_LPAN0102000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), 0, 4),
                    UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), 0, 4)))),

    SG_EQUAL_FORMULA_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    R_LPAN0107000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), 6, 12),
                    UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), 6, 12)))),

    SG_EQUAL_FORMULA_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    R_LPAN0208000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), 14, 20),
                    UtilMetadata.genMessage(R_LPAN0208000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), 14, 20)))),

    SG_EQUAL_FORMULA_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    R_LPAN0300000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), new int[] { 5, 13 }) + "-LPAN0208000000",
                    UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), new int[] { 5, 13 }) + "-LPAN0208000000"))),

    SG_EQUAL_FORMULA_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    R_LPAN0500000000.getObject().getKey(), UtilMetadata.genMinusRow(getObjects(ProgramType.PPMPK), new int[] { 23, 22 }),
                    UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(ProgramType.PPMPK), new int[] { 23, 22 })))),

    SG_EQUAL_FORMULA_ROI_1(programs(PPMPK),
            () -> genRowValidation(R_LPAN0101010000.getObject().getKey(), "2")),

    SG_EQUAL_FORMULA_ROI_2(programs(PPMPK),
            () -> genRowValidation(R_LPAN0101020000.getObject().getKey(), "3")),

    SG_EQUAL_FORMULA_ROI_3(programs(PPMPK),
            () -> genRowValidation(R_LPAN0101030000.getObject().getKey(), "4")),

    SG_EQUAL_FORMULA_ROI_4(programs(PPMPK),
            () -> genRowValidation(R_LPAN0101040000.getObject().getKey(), "5")),

    SG_EQUAL_FORMULA_ROI_5(programs(PPMPK),
            () -> genRowValidation(R_LPAN0101050000.getObject().getKey(), "6")),

    FV_EQUAL_FORMULA_EXCEPT(programs(PPMPK), validationFields(12),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPK), new int[]{5, 13, 22, 24}), 2))
    
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

    public static final BaseMetadataValidation<E7002LpanValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7002LpanValidationsConfig.class, PPMPK);

    private static SegmentValidation genSumIfValidation(String posCode, String rangeField, String criteriaField, String formCode,
                                                        String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genRowValidation(String posCode, String comparatorField) {
        return UtilSegmentValidation.genEqualsForm("2", posCode,
                EFormLaporanBulananTahunan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey());
    }
    
}
