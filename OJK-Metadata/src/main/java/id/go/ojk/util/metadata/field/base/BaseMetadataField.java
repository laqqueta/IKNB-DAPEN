package id.go.ojk.util.metadata.field.base;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.util.FieldUtil;
import id.go.ojk.util.constants.SectorType;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseMetadataField<T extends Enum<T> & IBaseFieldMetadata> {

    private final Class<T> enumClass;

    public BaseMetadataField(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    protected List<T> enumValues() {
        return new ArrayList<>(EnumSet.allOf(enumClass));
    }

    protected List<SubmissionField> reindex(List<T> filtered, Map<Integer, Integer> reindexNumber) {
        if (reindexNumber.size() != filtered.size()) {
            throw new IllegalArgumentException("reindexNumber size must equal total of enum entries");
        }

        return filtered.stream()
                .filter(e -> reindexNumber.containsKey(e.getField().getNumber()))
                .map(e -> {
                    int newNumber = reindexNumber.get(e.getField().getNumber());
                    SubmissionField f = e.getField();
                    return FieldUtil.sf(newNumber, f.getCode(), f.getName(), f.getSimpleValidation());
                })
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }

    public List<SubmissionField> getFields(SectorType filterSectorType) {
        return enumValues().stream()
                .filter(f -> f.getSectorType().contains(filterSectorType))
                .map(IBaseFieldMetadata::getField)
                .collect(Collectors.toList());
    }

    /**
     * @deprecated Use {@link #getReindexFields(List, Map)} instead.
     *
     * @implNote Use this with cautions because of how the fields are not reindex, use
     *           {@link #getReindexFields(List, Map)} instead if want to filter for specific fields and reindex them
     *
     */
    @Deprecated
    public List<SubmissionField> getFields(List<Integer> selectedFields) {
        return enumValues().stream()
                .map(IBaseFieldMetadata::getField)
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
}
