package id.go.ojk.client.validation;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;

public interface IValidationConverter {
    SegmentValidation toSegmentValidation();

    FieldValidation toFieldValidation();

    ConditionalRequired toFieldConditional();
}
