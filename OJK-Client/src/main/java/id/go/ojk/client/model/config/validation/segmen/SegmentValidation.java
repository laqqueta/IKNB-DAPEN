package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.Map;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.constant.FormatCategoryFlag;
import id.go.ojk.lib.client.model.constant.SegmentValidationType;
import id.go.ojk.lib.client.service.context.ApplicationContext;

public interface SegmentValidation {
	
	void setApplicationContext(ApplicationContext appCtx);

	SegmentValidation setParameter(String parameter);
	
	String getParameter();

	SegmentValidation initialized();

	/**
	 * row validation
	 * 
	 * @param submissionData
	 * @param submissionFormat
	 * @param validationResult
	 */
	void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult);
	
	/**
	 * post validation, execute after all row on same segment validated
	 * 
	 * @param submissionData
	 * @param submissionFormat
	 * @param validationErrorWriter
	 */
	void validatePost(Map<String, ProgressSegment> progressSegmentMap, SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationErrorWriter validationErrorWriter) throws IOException;

	FormatCategoryFlag getFormatCategoryFlag();
	
	SegmentValidationType getSegmentValidationType();
	
	void cleanUp();

	// Load initial data before executing row validations
	void load(SubmissionFormat submissionFormat);
}
