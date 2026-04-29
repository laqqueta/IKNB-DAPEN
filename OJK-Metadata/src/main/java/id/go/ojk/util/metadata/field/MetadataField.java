package id.go.ojk.util.metadata.field;

import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;

import java.util.List;

public class MetadataField<T extends Enum<T> & IFieldMetadata> extends BaseMetadataField<T> {

    public MetadataField(Class<T> enumClass, List<SectorType> sectorType) {
        super(enumClass, sectorType);
    }

}
