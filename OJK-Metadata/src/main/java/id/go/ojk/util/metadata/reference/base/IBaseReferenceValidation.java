package id.go.ojk.util.metadata.reference.base;

import id.go.ojk.client.model.validation.IValidation;

import java.util.function.Supplier;

public interface IBaseReferenceValidation {

    Supplier<? extends IValidation> getSupplier();

}
