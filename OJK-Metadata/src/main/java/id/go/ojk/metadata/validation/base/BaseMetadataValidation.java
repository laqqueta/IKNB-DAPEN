package id.go.ojk.metadata.validation.base;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.metadata.validation.ValidationConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    private <V extends IValidation> List<T> getValidationsOf(Class<V> vClass) {
        return enumValues().stream()
                .filter(v -> ValidationConverter.isValidation(v, vClass))
                .collect(Collectors.toList());
    }

    public Map<Integer, List<T>> getFieldValidations() {
        Map<Integer, List<T>> validationsMap = new HashMap<>();

        List<T> flatValidations = Stream
                .of(getValidationsOf(FieldValidation.class), getValidationsOf(ConditionalRequired.class))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        flatValidations.stream().map(IBaseMetadataValidation::getFieldsIndex)
                .flatMap(Collection::stream)
                .distinct()
                .forEach(key -> validationsMap.putIfAbsent(key, new ArrayList<>()));

        flatValidations.forEach(validations -> {
            for (int idx : validations.getFieldsIndex()) {
                if (!validationsMap.containsKey(idx)) continue;

                validationsMap.computeIfPresent(idx, (k, v) -> {
                    v.add(validations);
                    return v;
                });
            }
        });

        return validationsMap;
    }

    public List<SegmentValidation> testSegmentValidations(EnumSet<T> filters) {
        return enumValues().stream()
                .filter(filters::contains)
                .filter(v -> ValidationConverter.isValidation(v, SegmentValidation.class))
                .map(v -> ValidationConverter.toValidation(v, SegmentValidation.class))
                .collect(Collectors.toList());
    }

}
