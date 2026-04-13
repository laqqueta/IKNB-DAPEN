package id.go.ojk.util.metadata.validation.base;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.util.metadata.validation.ValidationConverter;

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
                .filter(v -> ValidationConverter.isValidation(v, SegmentValidation.class))
                .map(v -> ValidationConverter.toValidation(v, SegmentValidation.class))
                .collect(Collectors.toList());
    }

}
