package id.go.ojk.client.db.validation.field;

import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.validation.ValidationResult;

public interface IFieldValidation extends FieldValidation {
  List<ValidationResult> validate(int fileSequence, SubmissionFormat submissionFormat, SubmissionField submissionField);
}
