package id.go.ojk.metadata.module.lblt.dppk.validations.ppipik;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.field.Dppk0002Lpan;
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
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7002LpanKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_PPIN(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0103000000.getObject().getKey(), "4", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_IUR(programs(PPIPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidation.genSumIf(
                        UtilMetadata.genPipeColumnExcept(2, 15, new int[] { 12 }), UtilMetadata.genPipeRow(ER7002PosLtlbDppkLpan.getObjects(ProgramType.PPIPK), 7, 9),
                        EFormLaporanBulananTahunan.LTLB_IUR.getCode(),
                        ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                        "6|5|7", "13", "2", criteriaCondition, sumCriteriaCondition,
                        "IUR|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja %|Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah|Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah");
            }
    ),

    SG_SUMIF_PDIN(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0105000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                    "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PDPL(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0106000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                    "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BINV(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0201000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                    "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BOPR(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0202000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                    "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_BIPR(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0203000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                    "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PPH(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0205000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                    "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_SUMIF_PKPL(programs(PPIPK),
            () -> genSumIfValidation(R_LPAN0206000000.getObject().getKey(), "3", "4",
                    EFormLaporanBulananTahunan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                    "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain")),

    SG_EQUAL_FORMULA_1(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    R_LPAN0102000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPIPK), 0, 4),
                    UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPIPK), 0, 4)))),

    SG_EQUAL_FORMULA_2(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    R_LPAN0107000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPIPK), 6, 11),
                    UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPIPK), 6, 11)))),

    SG_EQUAL_FORMULA_3(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    R_LPAN0208000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPIPK), 13, 19),
                    UtilMetadata.genMessage(R_LPAN0208000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPIPK), 13, 19)))),

    SG_EQUAL_FORMULA_4(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    R_LPAN0300000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(ProgramType.PPIPK), new int[]{5, 12}) + "-LPAN0208000000",
                    UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(ProgramType.PPIPK), new int[]{5, 12}) + "-LPAN0208000000"))),

    SG_EQUAL_FORMULA_5(programs(PPIPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    R_LPAN0500000000.getObject().getKey(), UtilMetadata.genMinusRow(getObjects(ProgramType.PPIPK), new int[]{21, 20}),
                    UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(ProgramType.PPIPK), new int[]{21, 20})))),

    SG_EQUAL_FORMULA_ROI_1(programs(PPIPK),
            () -> genRowValidation(R_LPAN0101010000.getObject().getKey(), "2")),

    SG_EQUAL_FORMULA_ROI_2(programs(PPIPK),
            () -> genRowValidation(R_LPAN0101020000.getObject().getKey(), "3")),

    SG_EQUAL_FORMULA_ROI_3(programs(PPIPK),
            () -> genRowValidation(R_LPAN0101030000.getObject().getKey(), "4")),

    SG_EQUAL_FORMULA_ROI_4(programs(PPIPK),
            () -> genRowValidation(R_LPAN0101040000.getObject().getKey(), "5")),

    SG_EQUAL_FORMULA_ROI_5(programs(PPIPK),
            () -> genRowValidation(R_LPAN0101050000.getObject().getKey(), "6")),

    /* Update pak Yahya */

    SG_LPAN0103000000(programs(PPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0103000000.getObject();
                String selectColumn = "16";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_PPIN.getCode();
                String comparatorColumn = "4";
                String comparatorPosCode = comparatorForm + ER7060PosLtlbDppkPpin.R_PPIN000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Peningkatan / Penurunan pada form " + comparatorForm;
                return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, errMsg, 2);
            }),

    SG_LPAN0201000000(programs(PPIPK),
            () -> {
                KeyValueString selectPosCode = R_LPAN0201000000.getObject();
                String selectColumn = "16";
                String comparatorForm = EFormLaporanBulananTahunan.LTLB_ROI.getCode();
                String comparatorColumn = "8";
                String comparatorPosCode = comparatorForm + ER7009PosLtlbDppkRoi.R_ROI2100000000.key;
                String errMsg = selectPosCode.getValue() + " | Total Beban Investasi pada form " + comparatorForm;
                return UtilSegmentValidation.genEqualsFormColumCalculation(selectColumn, selectPosCode.getKey(), comparatorColumn,
                        comparatorPosCode, errMsg, 2);
            }),


    FV_EQUAL_FORMULA_EXCEPT_1(programs(PPIPK), validationFields(Dppk0002Lpan.GABUNGAN),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPIPK), new int[]{5, 12, 20, 21, 23}), 2)),

    FV_EQUAL_FORMULA_EXCEPT_2(programs(PPIPK), validationFields(Dppk0002Lpan.TOTAL),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(12, 15),
            UtilMetadata.genPipeRow(getObjects(ProgramType.PPIPK), new int[]{5, 12, 20, 21, 23}), 2))

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

    public static final BaseMetadataValidation<E7002LpanKValidationsConfig> VALIDATION_METADATA_PPIPK =
            new LbltMetadataValidation<>(E7002LpanKValidationsConfig.class, PPIPK);

    private static SegmentValidation genSumIfValidation(String posCode, String rangeField, String criteriaField, String formCode,
                                                        String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6|UUS1|UUS2|UUS3");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumnExcept(2, 15, new int[] { 12 }), posCode,
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
