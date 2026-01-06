package id.go.ojk.client.db.validation.conditional;

import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.validation.ValidationResult;

public interface IDbConditional {
	List<ValidationResult> validate(int fileSequence, ConditionalRequired conditional, SubmissionField field);
}
