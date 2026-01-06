package id.go.ojk.client.model.config.validation.segmen;

import java.time.LocalDate;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

/**
 * restructureFreqField=0&restructureStartDateField=0&restructureEndDateField=0&lastContractDateField=0
 *
 */
@XStreamAlias("restructContractDateValidation")
public class RestructContractDateValidation extends MapParamSegmentValidation {
	
	private int restructureFreqField;			//RESTRUCTURE_FREQ
	private int restructureStartDateField;		//RESTRUCTURE_START_DATE
	private int restructureEndDateField;		//RESTRUCTURE_END_DATE
//	private int initialContractDateField;		//INITIAL_CONTRACT_DATE
	private int lastContractDateField;			//LAST_CONTRACT_DATE

	public RestructContractDateValidation(){
		super();
	}

	public RestructContractDateValidation(String parameter){
		super(parameter);
	}

	@Override
	public RestructContractDateValidation initialized() {
		this.restructureFreqField 			= getIntParameter("restructureFreqField");
		this.restructureStartDateField 		= getIntParameter("restructureStartDateField");
		this.restructureEndDateField 		= getIntParameter("restructureEndDateField");
//		this.initialContractDateField 		= getIntParameter("initialContractDateField");
		this.lastContractDateField 			= getIntParameter("lastContractDateField");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		Integer restructureFreq			= ValidationUtil.validateInteger(validationResult.getColumn(restructureFreqField), null);
		if ( restructureFreq != null ){
			if ( restructureFreq >= 1 ){
				SubmissionField restructureFreqSf = fields.get(restructureFreqField);
				SubmissionField lastContractDateSf = fields.get(lastContractDateField);
				SubmissionField restructureEndDateSf = fields.get(restructureEndDateField);
				
				LocalDate lastContractDate = ValidationUtil.validateDate(lastContractDateSf, validationResult, false);
				LocalDate restructureEndDate = ValidationUtil.validateDate(restructureEndDateSf, validationResult, false);
				
				if ( lastContractDate != null && restructureEndDate != null && lastContractDate.isAfter(restructureEndDate) ){
					//Tanggal akad akhir <= tanggal restrukturisasi akhir
					
					validationResult.errors.add(
						new ValidationError(
							lastContractDateSf,
							ValidationErrorCode.E20_09_DATE_MATRIX_REASON,
							lastContractDateSf.getName(), " lebih kecil atau sama dengan ", restructureEndDateSf.getName(), restructureFreqSf.getName() + " >= 1"
						)
					);
					
				}
				
				if ( restructureFreq > 1 ){
					SubmissionField restructureStartDateSf = fields.get(restructureStartDateField);
					LocalDate restructureStartDate = ValidationUtil.validateDate(restructureStartDateSf, validationResult, false);
					
					if ( restructureStartDate != null &&  restructureEndDate != null && !restructureStartDate.isBefore(restructureEndDate)){
						//Tanggal restrukturisasi awal < tanggal restrukturisasi akhir
						
						validationResult.errors.add(
							new ValidationError(
								restructureStartDateSf,
								ValidationErrorCode.E20_09_DATE_MATRIX_REASON,
								restructureStartDateSf.getName(), " lebih kecil ", restructureEndDateSf.getName(), restructureFreqSf.getName() + " > 1"
							)
						);

					}
					
				}
			}
		}		
	}
}
