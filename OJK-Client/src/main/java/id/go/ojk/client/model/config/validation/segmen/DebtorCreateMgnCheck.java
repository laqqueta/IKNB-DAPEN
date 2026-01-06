package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.service.validation.DebtorRow;

/**
 * 
 * debtorStorageNumbers=?&cifField=?
 *
 */
@XStreamAlias("debtorCreateMgnCheck")
public class DebtorCreateMgnCheck extends MapParamSegmentValidation {

	private int[] debtorStorageNumbers;
	private int cifField;

	public DebtorCreateMgnCheck(){
		super();
	}

	public DebtorCreateMgnCheck(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public DebtorCreateMgnCheck initialized() {
		this.debtorStorageNumbers	= getIntParameters("debtorStorageNumbers");
		this.cifField 				= getIntParameter("cifField");				
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}
		
		String cif = validationResult.getColumn(cifField);
		
		if ( StringUtils.isNotEmpty(cif) ){
			for (Integer debtorStorageNumber : debtorStorageNumbers) {
				ConcurrentMap<String, DebtorRow> debtorRowMap = submissionData.getValidationRelationModel().debtorCreateStorage.get(debtorStorageNumber);
				DebtorRow debtorRow = debtorRowMap.get(cif);
				if ( debtorRow != null ){
					
					//jika debtor C maka M01 juga harus C
					List<SubmissionField> fields = submissionFormat.getFields();
					int dataOperationField = fields.size()-1;
					String dataOperation = validationResult.getColumn(dataOperationField);
					if ( !"C".equals(dataOperation) ){
						SubmissionField dataOperationSf = fields.get(dataOperationField);
						validationResult.errors.add( 
							new ValidationError(
								dataOperationSf, ValidationErrorCode.E40_31_D02C_M_MUST_C
							)
						);				
					}
					
					debtorRow.setHasM(true);
										
					break;					
				}
			}
		}
	}

}
