package id.go.ojk.util;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.util.constants.SectorType;

import java.util.*;
import java.util.stream.Collectors;

public class MetadataField<T extends Enum<T> & IFieldMetadata> {

    private final Class<T> enumClass;

    public MetadataField(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    private List<T> enumValues() {
        return new ArrayList<>(EnumSet.allOf(enumClass));
    }

    public List<SubmissionField> getFields(SectorType filterSectorType) {
        return enumValues().stream()
                .filter(f -> f.getSectorType().contains(filterSectorType))
                .map(IFieldMetadata::getField)
                .collect(Collectors.toList());
    }

    /**
     * @deprecated Use {@link #getReindexFields(List, Map)} instead.
     *
     * @implNote Use this with cautions because of how the fields are not reindex, use
     *           {@link #getReindexFields(List, Map)} instead if want to filter specific fields and then reindex them
     *
     */
    @Deprecated
    public List<SubmissionField> getFields(List<Integer> selectedFields) {
        return enumValues().stream()
                .map(IFieldMetadata::getField)
                .filter(field -> selectedFields.contains(field.getNumber()))
                .collect(Collectors.toList());
    }


    public List<SubmissionField> getReindexFields(List<Integer> selectedFields, Map<Integer, Integer> reindexNumber) {
        return reindex(enumValues().stream()
                        .filter(f -> selectedFields.contains(f.getField().getNumber()))
                        .collect(Collectors.toList()), reindexNumber);
    }


    public List<SubmissionField> getReindexFields(SectorType filterSectorType, Map<Integer, Integer> reindexNumber) {
        return reindex(enumValues().stream()
                        .filter(f -> f.getSectorType().contains(filterSectorType))
                        .collect(Collectors.toList()), reindexNumber);
    }

    private List<SubmissionField> reindex(List<T> filtered, Map<Integer, Integer> reindexNumber) {
        if (reindexNumber.size() != enumValues().size()) {
            throw new IllegalArgumentException("reindexNumber size must match total of enum entries");
        }

        return filtered.stream()
                .filter(e -> reindexNumber.containsKey(e.getField().getNumber()))
                .map(e -> {
                    int newNumber = reindexNumber.get(e.getField().getNumber());
                    SubmissionField f = e.getField();
                    return FieldBuilder.sf(newNumber, f.getCode(), f.getName(), f.getSimpleValidation());
                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }
}
