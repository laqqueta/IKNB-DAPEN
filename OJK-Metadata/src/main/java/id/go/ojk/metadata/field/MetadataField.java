package id.go.ojk.metadata.field;

import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.base.BaseMetadataField;

import java.util.List;

public class MetadataField<T extends Enum<T> & IFieldMetadata> extends BaseMetadataField<T> {

    public MetadataField(Class<T> enumClass, List<SectorType> sectorType) {
        super(enumClass, sectorType);
    }

}
