package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ERas1ValidationsConfig {


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

    public static boolean isSegment(ERas1ValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(ERas1ValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

}
