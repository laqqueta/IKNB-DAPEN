package id.go.ojk.util.metadata.reference;

import id.go.ojk.util.metadata.reference.base.BaseMetadataReference;

public class MetadataReference<T extends Enum<T> & IReferenceValidation> extends BaseMetadataReference<T> {


    public MetadataReference(Class<T> clazz) {
        super(clazz);
    }
}
