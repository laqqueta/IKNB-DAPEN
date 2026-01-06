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
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

/**
 * estCertNoField=0&estCertDateField=0&latestAddCertNoField=0&latestAddCertDateField=0
 * @author PC
 *
 */
@XStreamAlias("establismentDateValidation")
public class EstablismentDateValidation extends MapParamSegmentValidation {

	private int estCertNoField;					//No. Akte Pendirian
	private int estCertDateField;				//Tanggal Akte Pendirian
	private int latestAddCertNoField;			//No. Akte Perubahan Terakhir
	private int latestAddCertDateField;			//Tanggal Akte Perubahan Terakhir

	public EstablismentDateValidation(){
		super();
	}

	public EstablismentDateValidation(String parameter){
		super(parameter);
	}

	@Override
	public EstablismentDateValidation initialized() {
		this.estCertNoField 			= getIntParameter("estCertNoField");
		this.estCertDateField 			= getIntParameter("estCertDateField");
		this.latestAddCertNoField 		= getIntParameter("latestAddCertNoField");
		this.latestAddCertDateField 	= getIntParameter("latestAddCertDateField");
		
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String estCertNo				= validationResult.getColumn(estCertNoField);
		LocalDate estCertDate 			= ValidationUtil.validateDate(fields.get(estCertDateField), validationResult, false);
		String latestAddCertNo 			= validationResult.getColumn(latestAddCertNoField);
		LocalDate latestAddCertDate 	= ValidationUtil.validateDate(fields.get(latestAddCertDateField), validationResult, false);

		//Validasi D02 kolom No. Akte Pendirian: Jika tanggal akte pendirian = tanggal akte perubahan terakhir, maka no akte pendirian harus = no akte perubahan terakhir
		
		if ( CollectionUtil.isAllNotNull(estCertNo, estCertDate, latestAddCertNo, latestAddCertDate) ){
			if ( estCertDate.isEqual(latestAddCertDate) && !estCertNo.equals(latestAddCertNo) ){
				validationResult.errors.add(
					new ValidationError(
						fields.get(latestAddCertNoField),
						ValidationErrorCode.E20_30_EST_DATE,
						submissionFormat.getFieldName(estCertNoField), submissionFormat.getFieldName(latestAddCertNoField), 
						submissionFormat.getFieldName(estCertDateField), submissionFormat.getFieldName(latestAddCertDateField)
					)
				);
			}
			
		}
	}
}
