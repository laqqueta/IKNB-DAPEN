package id.go.ojk.metadata.validation.base;

import id.go.ojk.client.model.validation.IValidation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface IBaseMetadataValidation extends Serializable {

    Supplier<? extends IValidation> getSupplier();

    default List<Integer> getFieldsIndex() {
        return new ArrayList<>();
    }

}
