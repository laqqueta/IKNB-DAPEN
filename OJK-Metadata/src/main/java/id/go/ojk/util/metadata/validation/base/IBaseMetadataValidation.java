package id.go.ojk.util.metadata.validation.base;

import id.go.ojk.client.model.validation.IValidation;

import java.util.function.Supplier;

public interface IBaseMetadataValidation {

    Supplier<? extends IValidation> getSupplier();

}
