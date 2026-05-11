package id.go.ojk.metadata.field.base;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.metadata.util.constants.SectorType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public interface IBaseFieldMetadata {
    SubmissionField getField();
    EnumSet<SectorType> getSectorTypes();

    default List<Integer> getFieldsIndex() {
        return new ArrayList<>();
    }
}
