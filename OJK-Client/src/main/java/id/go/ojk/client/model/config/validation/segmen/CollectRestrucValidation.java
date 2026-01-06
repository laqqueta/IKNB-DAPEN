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
 * collectibilityTypeCodeField=XX&collectibilityRefCode=XX&restructureFreqField=XX&nonPerformingDateField=XX&creditStartDateField=XX&startDateField=XX
 *
 */
@XStreamAlias("collectRestrucValidation")
public class CollectRestrucValidation extends MapParamSegmentValidation {

	//Tambahan DPIP 2016 09 09
	//"Catatan DPIP : untuk Kolektibilitas=5 dan Freq. Restruk>0, maka :
	//Tgl macet > tgl awal kredit
	//Tgl macet > Tgl Mulai
	//Tgl Mulai > Tgl Awal Kredit"

	private int collectibilityTypeCodeField;		//Kode Kolektibilitas
	private String collectibilityRefCode;			//Ref Kode Kolektibilitas, default 5
	private int restructureFreqField;				//Frekuensi Restrukturisasi
	private int nonPerformingDateField;				//Tanggal Macet
	private int creditStartDateField;				//Tanggal Awal Kredit
	private int startDateField;						//Tanggal Mulai
	
	public CollectRestrucValidation(){
		super();
	}

	public CollectRestrucValidation(String parameter){
		super(parameter);
	}

	@Override
	public CollectRestrucValidation initialized() {
		this.collectibilityTypeCodeField 	= getIntParameter("collectibilityTypeCodeField");
		this.collectibilityRefCode 			= getStringParameter("collectibilityRefCode", "5");
		this.restructureFreqField 			= getIntParameter("restructureFreqField");
		this.nonPerformingDateField 		= getIntParameter("nonPerformingDateField");
		this.creditStartDateField 			= getIntParameter("creditStartDateField");
		this.startDateField 				= getIntParameter("startDateField");

		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String collectibilityTypeCode 	= validationResult.getColumn(collectibilityTypeCodeField);
		Integer restructureFreq			= ValidationUtil.validateInteger(validationResult.getColumn(restructureFreqField), null) ;

		//"Catatan DPIP : untuk Kolektibilitas=5 dan Freq. Restruk>0, maka :
		if ( restructureFreq != null && collectibilityRefCode.equals(collectibilityTypeCode) && restructureFreq.intValue() > 0) {

			SubmissionField collectibilityTypeCodeSf 	= fields.get(collectibilityTypeCodeField);
			SubmissionField restructureFreqSf 			= fields.get(restructureFreqField);
			SubmissionField nonPerformingDateSf 		= fields.get(nonPerformingDateField);
			SubmissionField creditStartDateSf 			= fields.get(creditStartDateField);
			SubmissionField startDateSf 				= fields.get(startDateField);

			String reason = String.format(
				"%1$s = %2$s dan %3$s > 0", 
				collectibilityTypeCodeSf.getName(), collectibilityRefCode, restructureFreqSf.getName()
			);

			LocalDate nonPerformingDate			= (LocalDate) validationResult.cacheParseObject.get(nonPerformingDateField);
			LocalDate creditStartDate			= (LocalDate) validationResult.cacheParseObject.get(creditStartDateField);
			LocalDate startDate					= (LocalDate) validationResult.cacheParseObject.get(startDateField);
						
			//Tgl macet > tgl awal kredit
			if ( nonPerformingDate != null && creditStartDate != null && !nonPerformingDate.isAfter(creditStartDate) ){
				validationResult.errors.add(
					new ValidationError(
						nonPerformingDateSf,
						ValidationErrorCode.E20_09_DATE_MATRIX_REASON,
						nonPerformingDateSf.getName(), "lebih besar", creditStartDateSf.getName(), reason
					)
				);
			}
			
			//Tgl macet > Tgl Mulai
			if ( nonPerformingDate != null && startDate != null && !nonPerformingDate.isAfter(startDate) ){
				validationResult.errors.add(
					new ValidationError(
						nonPerformingDateSf,
						ValidationErrorCode.E20_09_DATE_MATRIX_REASON,
						nonPerformingDateSf.getName(), "lebih besar", startDateSf.getName(), reason
					)
				);
			}
									
			//Tgl Mulai > Tgl Awal Kredit"
			if ( startDate != null && creditStartDate != null && !startDate.isAfter(creditStartDate) ){
				validationResult.errors.add(
					new ValidationError(
						startDateSf,
						ValidationErrorCode.E20_09_DATE_MATRIX_REASON,
						startDateSf.getName(), "lebih besar", creditStartDateSf.getName(), reason
					)
				);				
			}			
		}
	}
}
