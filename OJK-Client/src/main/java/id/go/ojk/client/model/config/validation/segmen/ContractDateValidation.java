package id.go.ojk.client.model.config.validation.segmen;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("contractDateValidation")
public class ContractDateValidation extends MapParamSegmentValidation {

	private int initialContractNoField;		//No. Akad Awal
	private int initialContractDateField;	//Tanggal Akad Awal
	private int lastContractNoField;		//No. Akad Akhir
	private int lastContractDateField;		//Tanggal Akad Akhir

	private int newFlagField;				//Baru Perpanjangan
	private int creditStartDateField;		//Tanggal Awal Kredit
	private int startDateField;				//Tanggal Mulai
	
	private int newOrExtensionField;		//Baru / Perpanjangan
	
	private int restructureFreqField;		//FREKUENSI RESTRUKTURISASI
	private int restructureStartDateField;		//Tanggal Restrukturisasi Awal
	private int restructureEndDateField;		//Tanggal Restrukturisasi Akhir

	public ContractDateValidation(){
		super();
	}

	public ContractDateValidation(String parameter){
		super(parameter);
	}

	@Override
	public ContractDateValidation initialized() {
		this.initialContractNoField 	= getIntParameter("initialContractNoField");
		this.initialContractDateField 	= getIntParameter("initialContractDateField");
		this.lastContractNoField 		= getIntParameter("lastContractNoField");
		this.lastContractDateField 		= getIntParameter("lastContractDateField");

		//~ optional

		this.newFlagField 				= getIntParameter("newFlagField");
		this.creditStartDateField 		= getIntParameter("creditStartDateField");
		this.startDateField 			= getIntParameter("startDateField");
		
		this.newOrExtensionField 		= getIntParameter("newOrExtensionField");
		
		this.restructureFreqField 		= getIntParameter("restructureFreqField");
		this.restructureStartDateField 	= getIntParameter("restructureStartDateField");
		this.restructureEndDateField 	= getIntParameter("restructureEndDateField");

		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String initialContractNo 	= validationResult.getColumn(initialContractNoField);
		String initialContractDate 	= validationResult.getColumn(initialContractDateField);
		String lastContractNo 		= validationResult.getColumn(lastContractNoField);
		String lastContractDate 	= validationResult.getColumn(lastContractDateField);

//		- Jika tanggal akad awal = tanggal akad akhir, maka nomor akad awal harus=nomor akad akhir.
//		- Jika tanggal akad awal <> tanggal akad akhir, maka nomor akad awal harus <> nomor akad akhir

		if ( StringUtils.isNotEmpty(initialContractDate) ) {
			if ( StringUtils.equals(initialContractDate, lastContractDate) && !StringUtils.equals(initialContractNo, lastContractNo) ) {
				validationResult.errors.add(
					new ValidationError(
						fields.get(lastContractNoField),
						ValidationErrorCode.E20_04_CONTRACT_DATE,
						String.format(
							"%1$s harus sama dengan %2$s, karena tanggal akad awal sama dengan tanggal akad akhir", 
							fields.get(initialContractNoField).getName(), fields.get(lastContractNoField).getName()
						)
					)
				);
			} else if ( !StringUtils.equals(initialContractDate, lastContractDate) && StringUtils.equals(initialContractNo, lastContractNo) ){
				validationResult.errors.add(
					new ValidationError(
						fields.get(lastContractNoField),
						ValidationErrorCode.E20_04_CONTRACT_DATE,
						String.format(
							"%1$s tidak boleh sama dengan %2$s, karena tanggal akad awal tidak sama dengan tanggal akad akhir", 
							fields.get(initialContractNoField).getName(), fields.get(lastContractNoField).getName())
					)
				);
			}

			if ( newFlagField != 0 && creditStartDateField != 0 && startDateField != 0 ){

				//Integer newFlag					= ValidationUtil.validateInteger(rowSplited[newFlagField], validationResult.errors);
				Integer newFlag					= ValidationUtil.validateInteger(validationResult.getColumn(newFlagField), null);
				
				LocalDate creditStartDate		= (LocalDate) validationResult.cacheParseObject.get(creditStartDateField);
				LocalDate startDate				= (LocalDate) validationResult.cacheParseObject.get(startDateField);

				if ( creditStartDate != null && startDate != null ){

					//- Jika tgl mulai > tgl awal kredit, harus >0
					if ( startDate.isAfter(creditStartDate) ){
						if ( newFlag != null && newFlag == 0 ){
							SubmissionField field = fields.get(newFlagField);
							validationResult.errors.add(
								new ValidationError(
									field, 
									ValidationErrorCode.E20_04_CONTRACT_DATE, 
									field.getName() + " harus > 0, karena tgl mulai > tgl awal kredit"
								)
							);
						}
					}

					if ( StringUtils.equals(initialContractDate, lastContractDate) ) {
						//- Jika nomor akad awal = nomor akad akhir, maka tanggal  awal kredit harus=tanggal mulai.
						if (!creditStartDate.equals(startDate)){
							validationResult.errors.add(
								new ValidationError(
									fields.get(creditStartDateField),
									ValidationErrorCode.E20_04_CONTRACT_DATE,
									String.format(
										"%1$s harus sama dengan %2$s, karena nomor akad awal sama dengan nomor akad akhir", 
										fields.get(creditStartDateField).getName(), fields.get(startDateField).getName()
									)
								)
							);
						}
					} else {
						//- Jika nomor akad awal <> nomor akad akhir, maka tanggal awal kredit harus<>tanggal mulai
						if (creditStartDate.equals(startDate)){
							validationResult.errors.add(
								new ValidationError(
									fields.get(creditStartDateField),
									ValidationErrorCode.E20_04_CONTRACT_DATE,
									String.format(
										"%1$s tidak boleh sama dengan %2$s, karena nomor akad awal tidak sama dengan nomor akad akhir", 
										fields.get(creditStartDateField).getName(), fields.get(startDateField).getName()
									)
								)
							);
						}
					}
				}
			}
		}
		
		//~ Tambahan DPIP UAT
		if ( newOrExtensionField != 0 || restructureFreqField != 0){
			validateNewExtensionAndRetructure(submissionData, submissionFormat, validationResult);
		}
	}
	
	protected void validateNewExtensionAndRetructure(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		SubmissionField initialContractDateSf 		= fields.get(initialContractDateField);
		SubmissionField lastContractDateSf 			= fields.get(lastContractDateField);
		SubmissionField startDateSf 				= fields.get(startDateField);

		LocalDate initialContractDateObj	= ValidationUtil.validateDate(initialContractDateSf, validationResult, false);
		LocalDate lastContractDateObj		= ValidationUtil.validateDate(lastContractDateSf, validationResult, false);
		LocalDate startDateObj				= ValidationUtil.validateDate(startDateSf, validationResult, false);

		//"Baru Perpanjangan > 0
		//- Tanggal Akad Awal < Tanggal Akad Akhir
		//- Tanggal Akad Awal < Tanggal Mulai"
		
		if ( newOrExtensionField != 0 ){
			SubmissionField newOrExtensionSf 		= fields.get(newOrExtensionField);
			Integer newOrExtension 					= ValidationUtil.validateInteger(validationResult.getColumn(newOrExtensionField), null);
			
			//"Baru Perpanjangan > 0
			if ( newOrExtension != null && newOrExtension.intValue() > 0){

				//- Tanggal Akad Awal < Tanggal Akad Akhir
				if ( initialContractDateObj != null && lastContractDateObj != null && !initialContractDateObj.isBefore(lastContractDateObj) ){
					validationResult.errors.add(
						new ValidationError(
							initialContractDateSf,
							ValidationErrorCode.E20_04_CONTRACT_DATE,
							String.format(
								"%1$s harus lebih kecil %2$s karena %3$s lebih besar dari 0", 
								initialContractDateSf.getName(), lastContractDateSf.getName(), newOrExtensionSf.getName()
							)
						)
					);
				}
				
				//- Tanggal Akad Awal < Tanggal Mulai"
				if ( initialContractDateObj != null && startDateObj != null && !initialContractDateObj.isBefore(startDateObj) ){
					validationResult.errors.add(
						new ValidationError(
							initialContractDateSf,
							ValidationErrorCode.E20_04_CONTRACT_DATE,
							String.format(
								"%1$s harus lebih kecil %2$s karena %3$s lebih besar dari 0", 
								initialContractDateSf.getName(), startDateSf.getName(), newOrExtensionSf.getName()
							)
						)
					);					
				}
			}	
		}
					
		//"Frekwensi Restrukturisasi > 0
		//- Tanggal Akad Akhir <= Tanggal Restrukturisasi Awal
		//- Tanggal mulai <= Tanggal Restrukturisasi Awal RALAT Tanggal mulai >= Tanggal Restrukturisasi Awal 
		//- Tanggal Restrukturisasi Akhir >= Tanggal Restrukturisasi Awal"

		if ( restructureFreqField != 0 ){						
			SubmissionField restructureFreqSf 		= fields.get(restructureFreqField);
			Integer restructureFreq 				= ValidationUtil.validateInteger(validationResult.getColumn(restructureFreqField), null);
			
			//"Frekwensi Restrukturisasi > 0
			if ( restructureFreq != null && restructureFreq.intValue() > 0){
				
				SubmissionField restructureStartDateSf 		= fields.get(restructureStartDateField);
				SubmissionField restructureEndDateSf 		= fields.get(restructureEndDateField);
				
				LocalDate restructureStartDateObj	= ValidationUtil.validateDate(restructureStartDateSf, validationResult, false);
				LocalDate restructureEndDateObj		= ValidationUtil.validateDate(restructureEndDateSf, validationResult, false);
				
				//- Tanggal Akad Akhir <= Tanggal Restrukturisasi Awal
				if ( lastContractDateObj != null &&  restructureStartDateObj != null && lastContractDateObj.isAfter(restructureStartDateObj) ){
					//Menurut Analisa Pak Slamet dari hasil UAT tidak valid
//					validationResult.errors.add(
//						new ValidationError(
//								lastContractDateSf,
//							ValidationErrorCode.E20_04_CONTRACT_DATE,
//							String.format(
//								"%1$s harus lebih kecil atau sama dengan %2$s karena %3$s lebih besar dari 0", 
//								lastContractDateSf.getName(), restructureStartDateSf.getName(), restructureFreqSf.getName()
//							)
//						)
//					);
				}

				//- Tanggal mulai <= Tanggal Restrukturisasi Awal RALAT Tanggal mulai >= Tanggal Restrukturisasi Awal
				if ( startDateObj != null &&  restructureStartDateObj != null && startDateObj.isBefore(restructureStartDateObj) ){
					//Menurut Analisa Pak Slamet dari hasil UAT tidak valid
//					validationResult.errors.add(
//						new ValidationError(
//							startDateSf,
//							ValidationErrorCode.E20_04_CONTRACT_DATE,
//							String.format(
//								"%1$s harus lebih besar atau sama dengan %2$s karena %3$s lebih besar dari 0", 
//								startDateSf.getName(), restructureStartDateSf.getName(), restructureFreqSf.getName()
//							)
//						)
//					);
				}

				//- Tanggal Restrukturisasi Akhir >= Tanggal Restrukturisasi Awal"
				if ( restructureEndDateObj != null &&  restructureStartDateObj != null && restructureEndDateObj.isBefore(restructureStartDateObj) ){
					validationResult.errors.add(
						new ValidationError(
							restructureEndDateSf,
							ValidationErrorCode.E20_04_CONTRACT_DATE,
							String.format(
								"%1$s harus lebih besar atau sama dengan %2$s karena %3$s lebih besar dari 0", 
								restructureEndDateSf.getName(), restructureStartDateSf.getName(), restructureFreqSf.getName()
							)
						)
					);
				}
			}
		}
	
	}

}
