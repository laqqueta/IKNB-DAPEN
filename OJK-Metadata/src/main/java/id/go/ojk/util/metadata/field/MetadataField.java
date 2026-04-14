package id.go.ojk.util.metadata.field;

import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;

public class MetadataField<T extends Enum<T> & IFieldMetadata> extends BaseMetadataField<T> {

    public MetadataField(Class<T> enumClass, SectorType sectorType) {
        super(enumClass, sectorType);
    }

}
