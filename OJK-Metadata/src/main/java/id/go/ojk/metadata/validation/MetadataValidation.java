package id.go.ojk.metadata.validation;

import id.go.ojk.metadata.validation.base.BaseMetadataValidation;

public class MetadataValidation<T extends Enum<T> & IMetadataValidation> extends BaseMetadataValidation<T> {

    public MetadataValidation(Class<T> clazz) {
        super(clazz);
    }

}
