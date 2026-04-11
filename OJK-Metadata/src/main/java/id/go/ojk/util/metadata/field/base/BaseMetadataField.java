package id.go.ojk.util.metadata.field.base;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.util.FieldUtil;
import id.go.ojk.util.constants.SectorType;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseMetadataField<T extends Enum<T> & IBaseFieldMetadata> {

    private final Class<T> enumClass;

    private final SectorType sectorType;

    public BaseMetadataField(Class<T> enumClass, SectorType sectorType) {
        this.enumClass = enumClass;
        this.sectorType = sectorType;
    }

    protected List<T> enumValues() {
        return new ArrayList<>(EnumSet.allOf(enumClass));
    }

    protected List<SubmissionField> reindex(List<T> filtered, Map<Integer, Integer> reindexNumber) {
        if (reindexNumber.size() != filtered.size()) {
            throw new IllegalArgumentException("reindexNumber size must equal of enum entries");
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

    public List<SubmissionField> getFields() {
        return enumValues().stream()
                .filter(f -> f.getSectorTypes().contains(sectorType))
                .map(IBaseFieldMetadata::getField)
                .sorted(Comparator.comparingInt(SubmissionField::getNumber))
                .collect(Collectors.toList());
    }


    public List<SubmissionField> getReindexFields(List<Integer> selectedFields, Map<Integer, Integer> reindexNumber) {
        return reindex(enumValues().stream()
                        .filter(f -> selectedFields.contains(f.getField().getNumber()))
                        .collect(Collectors.toList()), reindexNumber);
    }


    public List<SubmissionField> getReindexFields(SectorType filterSectorType, Map<Integer, Integer> reindexNumber) {
        return reindex(enumValues().stream()
                        .filter(f -> f.getSectorTypes().contains(filterSectorType))
                        .collect(Collectors.toList()), reindexNumber);
    }

    protected Class<T> getEnumClass() {
        return enumClass;
    }
}
