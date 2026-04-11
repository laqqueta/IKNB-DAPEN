package id.go.ojk.util.metadata.field.base;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.util.constants.SectorType;

import java.util.EnumSet;

public interface IBaseFieldMetadata {
    SubmissionField getField();
    EnumSet<SectorType> getSectorTypes();
}
