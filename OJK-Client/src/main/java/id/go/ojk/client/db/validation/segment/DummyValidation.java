package id.go.ojk.client.db.validation.segment;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.MapParamSegmentValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationResult;

public class DummyValidation extends MapParamSegmentValidation {
  @Override
  public SegmentValidation initialized() {
    return null;
  }

  @Override
  public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
  }
}
