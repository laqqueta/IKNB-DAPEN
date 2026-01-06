package id.go.ojk.client.model.config.validation.segmen;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import id.go.ojk.lib.client.service.validation.DebtorRow;

/**
 * 
 * debtorStorageNumber=?&cifField=?
 *
 */
@XStreamAlias("debtorCreateCollector")
public class DebtorCreateCollector extends MapParamSegmentValidation {

	private int debtorStorageNumber;
	private int cifField;

	public DebtorCreateCollector(){
		super();
	}

	public DebtorCreateCollector(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public DebtorCreateCollector initialized() {
		this.cifField 				= getIntParameter("cifField");
		this.debtorStorageNumber 	= getIntParameter("debtorStorageNumber");
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}
		
		String cif = validationResult.getColumn(cifField);
		String operation = validationResult.getColumn(submissionFormat.getFields().size() - 1);
		
		if ( StringUtils.isNotEmpty(cif) && "C".equals(operation) ){
			DebtorRow debtorRow = DebtorRow.builder().fileSeq(validationResult.fileSeq).lineNumber(validationResult.lineNumber).build();
			submissionData.getValidationRelationModel().debtorCreateStorage.get(debtorStorageNumber).put(cif, debtorRow);
		}
	}

}
