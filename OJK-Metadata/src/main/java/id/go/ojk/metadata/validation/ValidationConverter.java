package id.go.ojk.metadata.validation;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.metadata.validation.base.IBaseMetadataValidation;

public class ValidationConverter {

    public static <R, T extends IBaseMetadataValidation> boolean isValidation(T validation, Class<R> validationType) {
        return validationType.isInstance(validation.getSupplier().get());
    }

    public static <T extends IBaseMetadataValidation, R> R toValidation(T validation, Class<R> validationType) {

        boolean typeCheck = validationType == SegmentValidation.class |
                validationType == FieldValidation.class | validationType == ConditionalRequired.class;

        if (!typeCheck) {
            throw new IllegalStateException("ValidationType must be SegmentValidation or FieldValidation or ConditionalRequired");
        }

        String className = validation.getSupplier().get()
                .getClass().getSimpleName();

        if (!isValidation(validation, validationType)) {
            throw new IllegalStateException(String
                    .format("%s is not type of %s Validation", className, validationType.getSimpleName()));
        }

        return validationType.cast(validation.getSupplier().get());
    }

}
