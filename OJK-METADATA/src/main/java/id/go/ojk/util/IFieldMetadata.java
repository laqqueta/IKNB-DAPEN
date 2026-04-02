package id.go.ojk.util;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.util.constants.SectorType;

import java.util.List;

public interface IFieldMetadata {
    SubmissionField getField();
    List<SectorType> getSectorType(); // rename from sectorType field
}
