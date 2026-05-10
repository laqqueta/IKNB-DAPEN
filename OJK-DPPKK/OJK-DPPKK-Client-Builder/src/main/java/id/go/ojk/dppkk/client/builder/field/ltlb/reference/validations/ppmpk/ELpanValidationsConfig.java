package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

import static id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7002PosLtlbDppkLpan.*;

// DONE

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ELpanValidationsConfig {

    SG_SUMIF_PPIN(() -> genSumIfValidation(R_LPAN0103000000.getObject().getKey(), "4", "5",
            EFormLaporanTahunanLaporanBulanan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
            "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_IUR(() -> genSumIfValidation(UtilMetadata.genPipeRow(ER7002PosLtlbDppkLpan.getObjects(JenisProgram.PPMPK), 7, 10), "6|5|7|8", "17",
            EFormLaporanTahunanLaporanBulanan.LTLB_IUR.getCode(), ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
            "IUR|Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_PDIN(() -> genSumIfValidation(R_LPAN0105000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
            "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_PDPL(() -> genSumIfValidation(R_LPAN0106000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
            "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_BINV(() -> genSumIfValidation(R_LPAN0201000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
            "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_BOPR(() -> genSumIfValidation(R_LPAN0202000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
            "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_BIPR(() -> genSumIfValidation(R_LPAN0203000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
            "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_PPH(() -> genSumIfValidation(R_LPAN0205000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
            "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_SUMIF_PKPL(() -> genSumIfValidation(R_LPAN0206000000.getObject().getKey(), "3", "4",
            EFormLaporanTahunanLaporanBulanan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
            "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"),
            () -> null),

    SG_EQUAL_FORMULA_1(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
            R_LPAN0102000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 0, 4),
            UtilMetadata.genMessage(R_LPAN0102000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), 0, 4))),
            () -> null),

    SG_EQUAL_FORMULA_2(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
            R_LPAN0107000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 6, 12),
            UtilMetadata.genMessage(R_LPAN0107000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), 6, 12))),
            () -> null),

    SG_EQUAL_FORMULA_3(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
            R_LPAN0208000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 14, 20),
            UtilMetadata.genMessage(R_LPAN0208000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), 14, 20))),
            () -> null),

    SG_EQUAL_FORMULA_4(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
            R_LPAN0300000000.getObject().getKey(), UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), new int[] { 5, 13 }) + "-LPAN0208000000",
            UtilMetadata.genMessage(R_LPAN0300000000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), new int[] { 5, 13 }) + "-LPAN0208000000")),
            () -> null),

    SG_EQUAL_FORMULA_5(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
            R_LPAN0500000000.getObject().getKey(), UtilMetadata.genMinusRow(getObjects(JenisProgram.PPMPK), new int[] { 23, 22 }),
            UtilMetadata.genMessage(R_LPAN0500000000.getObject().getValue(), UtilMetadata.genMinusDesc(getObjects(JenisProgram.PPMPK), new int[] { 23, 22 }))),
            () -> null),

    SG_EQUAL_FORMULA_ROI_1(() -> genRowValidation(R_LPAN0101010000.getObject().getKey(), "2"), () -> null),

    SG_EQUAL_FORMULA_ROI_2(() -> genRowValidation(R_LPAN0101020000.getObject().getKey(), "3"), () -> null),

    SG_EQUAL_FORMULA_ROI_3(() -> genRowValidation(R_LPAN0101030000.getObject().getKey(), "4"), () -> null),

    SG_EQUAL_FORMULA_ROI_4(() -> genRowValidation(R_LPAN0101040000.getObject().getKey(), "5"), () -> null),

    SG_EQUAL_FORMULA_ROI_5(() -> genRowValidation(R_LPAN0101050000.getObject().getKey(), "6"), () -> null),

    FV_EQUAL_FORMULA_EXCEPT(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
            UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[]{5, 13, 22, 24}), 2))

    ;

    private final Supplier<SegmentValidation> segmentSupplier;
    private final Supplier<FieldValidation> fieldSupplier;

    public SegmentValidation toSegmentValidation() {
        if (segmentSupplier.get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }
        return segmentSupplier.get();
    }

    public FieldValidation toFieldValidation() {
        if (fieldSupplier.get() == null) {
            throw new UnsupportedOperationException("Field Validation is null");
        }
        return fieldSupplier.get();
    }

    public static boolean isSegment(ELpanValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(ELpanValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

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
                EFormLaporanTahunanLaporanBulanan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey());
    }


}
