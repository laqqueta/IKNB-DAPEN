package id.go.ojk.util.metadata.validation.base;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseMetadataValidation<T extends Enum<T> & IBaseMetadataValidation> {

    private final Class<T> enumClazz;

    public BaseMetadataValidation(Class<T> enumClazz) {
        this.enumClazz = enumClazz;
    }

    protected List<T> enumValues() {
        return new ArrayList<>(EnumSet.allOf(enumClazz));
    }

    public List<SegmentValidation> getSegmentValidations() {
        return enumValues().stream()
                .filter(this::isSegmentValidation)
                .map(this::toSegmentValidation)
                .collect(Collectors.toList());
    }

    public SegmentValidation toSegmentValidation(T referenceValidationEnum) {
        if (referenceValidationEnum.getSupplier().get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }

        if (!isSegmentValidation(referenceValidationEnum)) {
            throw new UnsupportedOperationException(String.format("%s is not type of SegmentValidation Validation", referenceValidationEnum.getSupplier()
                    .get().getClass().getSimpleName()));
        }

        return (SegmentValidation) referenceValidationEnum.getSupplier().get();
    }

    public FieldValidation toFieldValidation(T referenceValidationEnum) {
        if (referenceValidationEnum.getSupplier().get() == null) {
            throw new UnsupportedOperationException("Field Validation is null");
        }

        if (!isFieldValidation(referenceValidationEnum)) {
            throw new UnsupportedOperationException(String.format("%s is not type of FieldValidation Validation", referenceValidationEnum.getSupplier()
                    .get().getClass().getSimpleName()));
        }

        return (FieldValidation) referenceValidationEnum.getSupplier().get();
    }

    public ConditionalRequired toFieldConditional(T referenceValidationEnum) {
        if (referenceValidationEnum.getSupplier().get() == null) {
            throw new UnsupportedOperationException("Conditional Required Validation is null");
        }

        if (!isFieldConditional(referenceValidationEnum)) {
            throw new UnsupportedOperationException(String.format("%s is not type of ConditionalRequired Validation", referenceValidationEnum.getSupplier()
                    .get().getClass().getSimpleName()));
        }

        return (ConditionalRequired) referenceValidationEnum.getSupplier().get();
   }

    public boolean isSegmentValidation(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof SegmentValidation;
    }

    public boolean isFieldValidation(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof FieldValidation;
    }

    public boolean isFieldConditional(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof ConditionalRequired;
    }

}
