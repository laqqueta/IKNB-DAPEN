package id.go.ojk.client.model.config.validation.segmen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;

/**
 *	accountNumberField=XX&cifField=XX&debtorSequenceField=XX&conditionCodeField=XX
 */
@XStreamAlias("f02SegmentValidation")
public class F02SegmentValidation extends MapParamSegmentValidation {
		
	private int accountNumberField;
	private int cifField;
	private int debtorSequenceField;
	private int conditionCodeField;
	@Getter private int[] compareFields;
		
	public F02SegmentValidation(){
		super();
	}
	
	public F02SegmentValidation(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService;
	
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		if( appCtx != null ){
			referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public F02SegmentValidation initialized() {
		this.accountNumberField 		= getIntParameter("accountNumberField");
		this.cifField 					= getIntParameter("cifField");
		this.debtorSequenceField		= getIntParameter("debtorSequenceField");
		this.conditionCodeField			= getIntParameter("conditionCodeField");
		
		this.compareFields				= getIntParameters("compareFields");
		
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}
		
		String accountNumber = validationResult.getColumn(accountNumberField);
		String cif = validationResult.getColumn(cifField);
		Integer debtorSequence = ValidationUtil.validateInteger(validationResult.getColumn(debtorSequenceField), null);
		String conditionCode = validationResult.getColumn(conditionCodeField);
		
		if ( StringUtils.isNotEmpty(accountNumber) && StringUtils.isNotEmpty(cif) && debtorSequence != null && conditionCode != null){
			ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap = submissionData.getValidationRelationModel().creditJoinRefMap;
			int rowHashCode = ValidationUtil.createHashCode(compareFields, validationResult.rowSplited);
			
//			String label = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, conditionCode);
//			boolean activeAccount = ReferenceMetadata.R24_Category_Y.equals(label);
			
			validate(validationResult, creditJoinRefMap, accountNumber, cif, rowHashCode, debtorSequence, conditionCode);
		}		
	}

	protected synchronized void validate(
		ValidationResult validationResult, ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap, String accountNumber, 
		String cif, int rowHashCode, Integer debtorSequence, String conditionCode
	) {
		List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(accountNumber);
		if ( creditJoinRows == null ){
			creditJoinRows = new ArrayList<>();
			creditJoinRefMap.put(accountNumber, creditJoinRows);
		}

		creditJoinRows.add(
			CreditJoinRow.builder()
			.cif(cif)
			.sequence(debtorSequence)
			.conditionCode(conditionCode)
			.rowHashCode(rowHashCode)
			.fileSeq(validationResult.fileSeq)
			.rowNum(validationResult.lineNumber)
			.build()
		);
	}

}

