package id.go.ojk.util.metadata.reference.base;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseMetadataReference<T extends Enum<T> & IBaseReferenceValidation> {

    private final Class<T> enumClazz;

    public BaseMetadataReference(Class<T> enumClazz) {
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

        if (!(referenceValidationEnum.getSupplier().get() instanceof SegmentValidation)) {
            throw new UnsupportedOperationException(String.format("%s is not of type SegmentValidation", referenceValidationEnum.getSupplier()
                    .get().getClass().getTypeName()));
        }

        return (SegmentValidation) referenceValidationEnum.getSupplier().get();
    }

    public FieldValidation toFieldValidation(T referenceValidationEnum) {
        if (referenceValidationEnum.getSupplier().get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }

        if (!(referenceValidationEnum.getSupplier().get() instanceof FieldValidation)) {
            throw new UnsupportedOperationException(String.format("%s is not of type SegmentValidation", referenceValidationEnum.getSupplier()
                    .get().getClass().getTypeName()));
        }

        return (FieldValidation) referenceValidationEnum.getSupplier().get();
    }

    public ConditionalRequired toConditionalRequired(T referenceValidationEnum) {
        if (referenceValidationEnum.getSupplier().get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }

        if (!(referenceValidationEnum.getSupplier().get() instanceof ConditionalRequired)) {
            throw new UnsupportedOperationException(String.format("%s is not of type SegmentValidation", referenceValidationEnum.getSupplier()
                    .get().getClass().getTypeName()));
        }

        return (ConditionalRequired) referenceValidationEnum.getSupplier().get();
    }

    public boolean isSegmentValidation(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof SegmentValidation;
    }

    public boolean isFieldValidation(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof FieldValidation;
    }

    public boolean isConditionalRequiredValidation(T referenceValidationEnum) {
        return referenceValidationEnum.getSupplier().get() instanceof ConditionalRequired;
    }

}
