package id.go.ojk.util.metadata.validation;

import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;

public class MetadataValidation<T extends Enum<T> & IMetadataValidation> extends BaseMetadataValidation<T> {

    public MetadataValidation(Class<T> clazz) {
        super(clazz);
    }

}
