package id.go.ojk.client.model.config.validation.segmen;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.service.validation.DebtorRow;

/**
 * 
 * debtorStorageNumbers=?&cifField=?
 *
 */
@XStreamAlias("debtorCreateFacilityCheck")
public class DebtorCreateFacilityCheck extends MapParamSegmentValidation {

	private int[] debtorStorageNumbers;
	private int cifField;

	public DebtorCreateFacilityCheck(){
		super();
	}

	public DebtorCreateFacilityCheck(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public DebtorCreateFacilityCheck initialized() {
		this.debtorStorageNumbers		= getIntParameters("debtorStorageNumbers");
		this.cifField 					= getIntParameter("cifField");
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
				ConcurrentMap<String, DebtorRow> debtorRows = submissionData.getValidationRelationModel().debtorCreateStorage.get(debtorStorageNumber);
				DebtorRow debtorRow = debtorRows.get(cif);
				if ( debtorRow != null ){
					//jika debtor C maka fasilitas juga harus C	
					List<SubmissionField> fields = submissionFormat.getFields();
					int dataOperationField = fields.size()-1;
					String dataOperation = validationResult.getColumn(dataOperationField);
					if ( !"C".equals(dataOperation) ){
						SubmissionField dataOperationSf = fields.get(dataOperationField);
						validationResult.errors.add(
							new ValidationError(
								dataOperationSf, ValidationErrorCode.E40_30_D01C_F_MUST_C, submissionFormat.getName()
							)
						);						
					}
					
					debtorRow.setHasF(true);
					break;					
				}
			}
		}
	}

}
