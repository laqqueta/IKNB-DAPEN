package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

import static id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7008PosLtlbDppkRekinv.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ERekinvValidationsConfig {

    SG_SUM_POS_EQUAL(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
            R_REKINV2100000000.getObject().getKey(),
            UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 0, 19),
            UtilMetadata.genMessage(R_REKINV2100000000.getObject().getValue(),
                    UtilMetadata.genPlusRow(getObjects(JenisProgram.PPMPK), 0, 19))),
            () -> null)

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

    public static boolean isSegment(ERekinvValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(ERekinvValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

}
