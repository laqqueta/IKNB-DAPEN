package id.go.ojk.client.service.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.Builder;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
public class RowValidatorDefault implements RowValidator {
	
	@Setter protected SubmissionFormat submissionFormat;
	@Setter protected List<ValidationRelation> validationRelations;
	@Setter protected ReferenceService referenceService;

	protected List<SubmissionField> fields;
	protected Set<Integer> keysColumn;
	protected List<SegmentValidation> segmentValidations;

	protected LocalDate minAllDate;
	protected LocalDate maxAllDate;

	@Tolerate
	public RowValidatorDefault(){
	}

	@Override
	public void initilized(){
		if ( fields == null ){
			fields = submissionFormat.getFields();			
		}
		
		if (keysColumn == null){
			keysColumn = new HashSet<>();
			for (SubmissionField field : fields) {
				if ( field.isUnique() ){
					keysColumn.add(field.getNumber());
				}
			}			
		}
		
		if ( segmentValidations == null ){
			segmentValidations = new ArrayList<>();
			for (SegmentValidation segmentValidation : submissionFormat.getSegmentValidations()) {
				switch (segmentValidation.getSegmentValidationType()) {
				case R:
					segmentValidations.add(segmentValidation);
					break;
				case P:
					break;
				default:
					throw new SlikException("Unsuported SegmentValidationType " + segmentValidation.getSegmentValidationType());
				}
				segmentValidation.load(submissionFormat);
			}			
		}
		
		minAllDate = referenceService.getConfig(ReferenceService.minAllDate );
		maxAllDate = referenceService.getConfig(ReferenceService.maxAllDate );		
	}
	
	@Override
	public void cleanUp() {
		for (SegmentValidation segmentValidation : segmentValidations) {
			segmentValidation.cleanUp();
		}		
	}

	
	@Override
	public SubmissionFormat getSubmissionFormat(){
		return submissionFormat;
	}

	@Override
	public void validateRow(SubmissionData submissionData, ValidationResult validationResult) {
		//If operation N (Not Change) skip validation
		String cekOperation = null;
		if ( submissionFormat.isSkipValidationIfNotChange()  ){
			cekOperation = validationResult.getColumn(fields.size()-1);
			if ( "N".equals(cekOperation) )
				return;
		}

		//validate reference
		if ( validationRelations != null ){
			for (ValidationRelation validationRelation : validationRelations) {
				validationRelation.validate(validationResult);
			}			
		}

		//prepare ref conditional
		List<ConditionalRequired> conditionalRequireds = submissionFormat.getConditionalRequireds();
		if ( !CollectionUtil.isEmpty(conditionalRequireds) ){
			for (ConditionalRequired conditionalRequired : conditionalRequireds) {
				validationResult.refRequiredConditions.add(conditionalRequired.analizeRequiredCondition(submissionFormat, validationResult));
			}
		}
		
		for(int i=0; i < fields.size(); i++){
			if ( submissionData.isValidateBetweenRow() ){
				if ( !keysColumn.contains(i) ){		//jika ada di keysColumn, artinya sudah di validasi
					validateSimpleValidation(fields.get(i), validationResult);				
				}				
			} else {
				validateSimpleValidation(fields.get(i), validationResult);
			}
		}

		for (SegmentValidation segmentValidation : segmentValidations) {
			segmentValidation.validate(submissionData, submissionFormat, validationResult);
		}
	}
	
	@Override
	public void validateSimpleValidation(SubmissionField field, ValidationResult validationResult){
		String value = validationResult.getColumn(field.getNumber());
		
		switch (field.getSimpleValidation().getRequiredCondition()) {
		case M:
			if ( StringUtils.isEmpty(value) ){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY));
				customFieldValidation(field, validationResult);
			} else {
				validateField(field, validationResult, value);
			}
			break;
		case N:
			if ( StringUtils.isNotEmpty(value) ){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY));
			}
			break;
		case C:
			Tupple2<RequiredCondition, String> analizeResultrequiredCondition = analizeRequiredCondition(field, validationResult);
			switch (analizeResultrequiredCondition.getA()) {
			case M:
				if ( StringUtils.isEmpty(value) ){
					String message = analizeResultrequiredCondition.getB();
					ValidationError validationError = StringUtils.isBlank(message) ? new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY) : new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, message);
					validationResult.errors.add(validationError);
					customFieldValidation(field, validationResult);
				} else {
					validateField(field, validationResult, value);
				}
				break;
			case N:
				if ( StringUtils.isNotEmpty(value) ){
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, analizeResultrequiredCondition.getB()));
//					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, field.getName()));
				}
				break;
			default:
				if ( StringUtils.isNotEmpty(value) ){
					validateField(field, validationResult, value);
				}
				break;
			}
			break;
		default:
			//Optional
			if ( StringUtils.isNotEmpty(value) ){
				validateField(field, validationResult, value);
			}
			break;
		}
	}
	
	@Override
	public boolean validateField(SubmissionField field, ValidationResult validationResult){
		int preErrorSize = validationResult.errors.size();
		String value = validationResult.getColumn(field.getNumber());
		
		if(submissionFormat.getUniqueCombineFields() == null) { // Arnol modif : lewati validasi yang unique combine
			validateField(field, validationResult, value);
		}
		return validationResult.errors.size() == preErrorSize;
	}

	@Override
	public boolean validateFields(Map<Integer, Boolean> validationResultCache, int[] fieldNumbers, ValidationResult validationResult){
		int preErrorSize = validationResult.errors.size();
		for (int fieldNumber : fieldNumbers) {
			Boolean valid = validationResultCache.get(fieldNumber);
			if ( valid == null ){
//				valid = validateField(fields.get(fieldNumber), validationResult);
//				validationResultCache.put(fieldNumber, valid);
			}
		}
		return validationResult.errors.size() == preErrorSize;
	}
	
	@Override // Nisa modif
	public boolean validateFields(Map<Integer, Boolean> validationResultCache, int fieldNumber, ValidationResult validationResult){
		int preErrorSize = validationResult.errors.size();		
			Boolean valid = validationResultCache.get(fieldNumber);
			if ( valid == null ){
				valid = validateField(fields.get(fieldNumber), validationResult);
				validationResultCache.put(fieldNumber, valid);
			}
		
		return validationResult.errors.size() == preErrorSize;
	}

	@Override
	public void validateField(SubmissionField field, ValidationResult validationResult, String value){
		
		SimpleValidation simpleValidation = field.getSimpleValidation();
		int length = value.length();
		
		DataType dataType = simpleValidation.getDataType();
		if ( dataType == DataType.refTable ){
			validateReference(field, value, field.getSimpleValidation().getReferenceTableNumbers(), validationResult.errors);
		} 
		else if ( dataType == DataType.refTablePerSegment ) {
			validateReferencePerSegment(field, value, field.getSimpleValidation().getReferenceTableNumbers(), validationResult.errors);
		}

		if ( length < simpleValidation.getMinLength() ) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_01_MIN_LENGTH, simpleValidation.getMinLength()));
		}

		if ( length > simpleValidation.getMaxLength() ) {
			validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_02_MAX_LENGTH, simpleValidation.getMaxLength()));
		}

		if ( !StringUtils.isEmpty(value) && simpleValidation.getRegex() != null ) {
			if (!simpleValidation.getRegex().matches(value)){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_00_FORMAT, simpleValidation.getRegex().getDesc()));
			} else {
				//validate special format that not handle by regular expression
				switch (simpleValidation.getDataType()) {
				case date:
					ValidationUtil.validateDate(field, validationResult, minAllDate, maxAllDate, true);
					break;
				case yearMonth:
					ValidationUtil.validateYearMonth(field, validationResult, minAllDate, maxAllDate, true);
					break;
				case year:
					ValidationUtil.validateYear(field, validationResult, minAllDate, maxAllDate, true);
					break;
				default:
					break;
				}
			}
		}
		
		if ( StringUtils.isNotEmpty(simpleValidation.getConstant()) ){
			if( !simpleValidation.getConstant().equals(value)){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_06_EQUAL, field.getName(), simpleValidation.getConstant()));
			}
		}
		
		//field validation
		customFieldValidation(field, validationResult);
//		List<FieldValidation> fieldValidations = field.getFieldValidations();
//		if ( fieldValidations != null ){
//			for (FieldValidation fieldValidation : fieldValidations) {
//				fieldValidation.validate(submissionFormat, field, validationResult);
//			}
//		}
	}
	
	@Override
	public void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors){
		referenceService.validate(field, code, referenceNumbers, errors);	
	}
	
	@Override
	public void validateReferencePerSegment(SubmissionField field, String code, List<Integer> referenceNumbers, List<ValidationError> errors){
		referenceService.validatePerSegment(field, code, submissionFormat.getCode(), referenceNumbers, errors);	
	}
	
	@Override
	public Tupple2<RequiredCondition, String>  analizeRequiredCondition(SubmissionField field, ValidationResult validationResult){
		SimpleValidation simpleValidation = field.getSimpleValidation();
		RequiredCondition tmpRequiredCondition = simpleValidation.getRequiredCondition() == null ? RequiredCondition.O : simpleValidation.getRequiredCondition();
		switch (tmpRequiredCondition) {
		case M:
		case O:
		case N:
			return Tupple2.<RequiredCondition, String>builder().a(tmpRequiredCondition).b("").build();
		default:
			ConditionalRequired conditionalRequired = simpleValidation.getConditionalRequired();
			return conditionalRequired.analizeRequiredCondition(submissionFormat, validationResult);
		}
	}

	private void customFieldValidation(SubmissionField field, ValidationResult validationResult) {
		List<FieldValidation> fieldValidations = field.getFieldValidations();
		if ( fieldValidations != null ){
			for (FieldValidation fieldValidation : fieldValidations) {
				fieldValidation.validate(submissionFormat, field, validationResult);
			}
		}
	}
}
