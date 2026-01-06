package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.config.validation.segmen.model.SummaryRefRaw;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("refAccnumCifSegfactype")
public class RefAccnumCifSegfactype extends MapParamSegmentValidation {
	
	private int cifField;
	private int accountNumberField;
	private int facilityTypeField;
	
	public RefAccnumCifSegfactype(){
		super();
	}
	
	public RefAccnumCifSegfactype(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if ( appCtx != null ){
			this.referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public RefAccnumCifSegfactype initialized() {
		this.cifField 					= getIntParameter("cifField");
		this.accountNumberField 		= getIntParameter("accountNumberField");
		this.facilityTypeField			= getIntParameter("facilityTypeField");
		
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}
		
		List<SubmissionField> fields = submissionFormat.getFields();
		String accountNumber = validationResult.getColumn(accountNumberField);
		String cif = validationResult.getColumn(cifField);
		
		if ( StringUtils.isEmpty(cif) && StringUtils.isEmpty(cif) ) {
			return;
		}
		
		SummaryRefRaw summaryRefRaw = getSummaryRefRaw(submissionData, accountNumber, cif);
		if ( summaryRefRaw != null ){
						
			String facilityType = validationResult.getColumn(facilityTypeField);
			if ( StringUtils.isNotEmpty(facilityType) && !StringUtils.equals(facilityType, summaryRefRaw.getFacilityType())){
				validationResult.errors.add(
					new ValidationError(
						fields.get(facilityTypeField), 
						ValidationErrorCode.E40_01_RELATION_MULTI, String.format("referensi Kode jenis fasilitas '%1$s' tidak valid, seharusnya '%2$s'", facilityType, summaryRefRaw.getFacilityType()) 
					)
				);
			}
			
			if ( StringUtils.isNotEmpty(summaryRefRaw.getEndYearMonth()) ){			//Fasilitas close ada end year month
				if ( "C".equals(summaryRefRaw.getOperation()) ){
					int dataOperationField = fields.size()-1;
					SubmissionField dataOperationSf = fields.get(dataOperationField);
					validationResult.errors.add( 
						new ValidationError(
							dataOperationSf, ValidationErrorCode.E40_26_COL_GUA_MUST_NOTSEND, submissionFormat.getName()
						)
					);
				} else {
					int dataOperationField = fields.size()-1;
					String dataOperation = validationResult.getColumn(dataOperationField);
					if ( !"D".equals(dataOperation) ){
						SubmissionField dataOperationSf = fields.get(dataOperationField);
						validationResult.errors.add(
							new ValidationError(
								dataOperationSf, 
								ValidationErrorCode.E40_25_COL_GUA_MUST_DELETE
							)
						);
					}					
				}
			} else {
				if ( "C".equals(summaryRefRaw.getOperation()) ){
					int dataOperationField = fields.size()-1;
					String dataOperation = validationResult.getColumn(dataOperationField);
					if ( !"C".equals(dataOperation) ){
						SubmissionField dataOperationSf = fields.get(dataOperationField);
						validationResult.errors.add( 
							new ValidationError(
								dataOperationSf, ValidationErrorCode.E40_32_FC_AP_MUST_C, submissionFormat.getName()
							)
						);						
					}
				}
			}
			

			
//			if ( StringUtils.isNotEmpty(summaryRefRaw.getEndYearMonth()) ){			//Fasilitas close ada end year month
//				int dataOperationField = fields.size()-1;
//				String dataOperation = validationResult.rowSplited[dataOperationField];
//				if ( !"D".equals(dataOperation) ){
//					SubmissionField dataOperationSf = fields.get(dataOperationField);
//					validationResult.errors.add(
//						new ValidationError(
//							dataOperationSf, 
//							ValidationErrorCode.E40_25_COL_GUA_MUST_DELETE
//						)
//					);
//				}
//			}
//			
//			if ( "C".equals(summaryRefRaw.getOperation()) ){
//				int dataOperationField = fields.size()-1;
//				String dataOperation = validationResult.rowSplited[dataOperationField];
//				if ( !"C".equals(dataOperation) ){
//					SubmissionField dataOperationSf = fields.get(dataOperationField);
//					validationResult.errors.add( 
//						new ValidationError(
//							dataOperationSf, ValidationErrorCode.E40_32_FC_AP_MUST_C, submissionFormat.getName()
//						)
//					);						
//				}
//			}
			
		} else {
			validationResult.errors.add(
				new ValidationError(
					fields.get(accountNumberField), 
					ValidationErrorCode.E40_01_RELATION_MULTI, String.format("referensi nomor rekening '%1$s' dan CIF '%2$s' tidak ditemukan di fasilitas", accountNumber, cif) 
				)
			);			
		}
		
	}

	private SummaryRefRaw getSummaryRefRaw(SubmissionData submissionData, String accountNumber, String cif){
		String key = accountNumber + "#" + cif;
		SummaryRefRaw summaryRefRaw = submissionData.getValidationRelationModel().summaryRefRawMap.get(key);
		return summaryRefRaw;
	}

}

