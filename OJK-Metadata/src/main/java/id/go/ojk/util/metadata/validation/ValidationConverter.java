package id.go.ojk.util.metadata.validation;

import id.go.ojk.util.metadata.validation.base.IBaseMetadataValidation;

public class ValidationConverter {

    public static <T extends IBaseMetadataValidation, R> boolean isValidation(T validation, Class<R> validationType) {
        return validationType.isInstance(validation);
    }

    public static <T extends IBaseMetadataValidation, R> R toValidation(T validation, Class<R> validationType) {
        Object validationInstance = validation.getSupplier().get();
        String className = validationInstance.getClass().getSimpleName();

        if (!isValidation(validation, validationType)) {
            throw new IllegalStateException(String
                    .format("%s is not type of %s Validation", className, validationType.getSimpleName()));
        }

        return validationType.cast(validationInstance);
    }

}
