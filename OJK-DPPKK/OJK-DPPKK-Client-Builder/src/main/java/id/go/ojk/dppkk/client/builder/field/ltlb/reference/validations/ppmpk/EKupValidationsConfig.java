package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7001PosLtlbDppkLan;
import id.go.ojk.dppkk.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

import static id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7007PosLtlbDppkKup.*;

// DONE

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EKupValidationsConfig {

    SG_EQUAL_SUM_POS_1(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0201020000.getObject().getKey(), R_KUP0201010000.getObject().getKey(),
            UtilMetadata.genMessageTotal(R_KUP0201020000.getObject().getValue(), R_KUP0201010000.getObject().getValue())), () -> null),
    SG_EQUAL_SUM_POS_2(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0203020000.getObject().getKey(), R_KUP0203010000.getObject().getKey(),
            UtilMetadata.genMessageTotal(R_KUP0203020000.getObject().getValue(), R_KUP0203010000.getObject().getValue())), () -> null),
    SG_EQUAL_SUM_POS_3(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0204020000.getObject().getKey(), R_KUP0204010000.getObject().getKey(),
            UtilMetadata.genMessageTotal(R_KUP0204020000.getObject().getValue(), R_KUP0204010000.getObject().getValue())), () -> null),
    SG_EQUAL_SUM_POS_4(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0205020000.getObject().getKey(), R_KUP0205010000.getObject().getKey(),
            UtilMetadata.genMessageTotal(R_KUP0205020000.getObject().getValue(), R_KUP0205010000.getObject().getValue())), () -> null),

    SG_EQUAL_ROW_PLUS_1(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0202040000.getObject().getKey(),
            UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 3, 5),
            UtilMetadata.genMessage(R_KUP0202040000.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), 3, 5))), () -> null),
    SG_EQUAL_ROW_PLUS_2(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0200000100.getObject().getKey(),
            UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), new int[] { 2, 6, 8, 10, 12}),
            UtilMetadata.genMessage(R_KUP0200000100.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), new int[] { 2, 6, 8, 10, 12 }))), () -> null),
    SG_EQUAL_ROW_MINUS_3(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5), R_KUP0200000200.getObject().getKey(),
            UtilMetadata.genMinusRow(getObjects(JenisProgram.PPMPK), new int[] { 0, 13 }),
            UtilMetadata.genMessage(R_KUP0200000200.getObject().getValue(), UtilMetadata.genPlusDesc(getObjects(JenisProgram.PPMPK), new int[] { 0, 13 }))), () -> null),
    
    
    SG_EQUAL_FORM_LAN(() -> UtilSegmentValidation.genEqualsForm("3|4|5", R_KUP0100000000.getObject().getKey(),
            EFormLaporanTahunanLaporanBulanan.LTLB_LAN.getCode(), "3",
            ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getKey()),() -> null),

    SG_REF_KODE_PENDANAAN(() -> UtilSegmentValidation.genReference("3|4|5", UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 19 }),
            EHeaderMetadataShared.R023.getNumber()), () -> null),
    
    SG_VALIDATION_PROYEKSI_PENDANAAN(() -> UtilSegmentValidation.genOperatorProyeksi("3|4|5", R_KUP0209000000.getObject().getKey(),
            String.format("%1$s<%2$s|%1$s>%3$s", R_KUP0200000200.getObject().getKey(), R_KUP0206000000.getObject().getKey(), R_KUP0207000000.getObject().getKey()),
            "III|I", "II"),() -> null)
    
    
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

    public static boolean isSegment(EKupValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(EKupValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

    public static ConditionalRequired genConditionForUraian() {
        return UtilFieldConditional.genExistPos("M", "N",
                UtilMetadata.genPipeRow(getObjects(JenisProgram.PPMPK), new int[] { 1,7,9,11 }));
    }

}
