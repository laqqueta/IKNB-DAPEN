package id.go.ojk.client.model.config.validation.segmen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CollateralRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;

/**
 *	collateralRegNoField=XX&accountNumberField=XX&cifField=XX&sharedCollStatFlagField=XX
 */
@XStreamAlias("a01SegmentValidation")
public class A01SegmentValidation extends MapParamSegmentValidation {
			
	private int collateralRegNoField;
	private int accountNumberField;
	private int cifField;
	private int sharedCollStatFlagField;
	private int joinedCreditStatusFlagField;
	
	@Getter private int[] compareFields;
	@Getter private int[] compareCreditJoinFields;
		
	public A01SegmentValidation(){
		super();
	}
	
	public A01SegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
	}

	@Override
	public A01SegmentValidation initialized() {
		this.collateralRegNoField			= getIntParameter("collateralRegNoField");
		this.accountNumberField 			= getIntParameter("accountNumberField");
		this.cifField 						= getIntParameter("cifField");
		this.sharedCollStatFlagField 		= getIntParameter("sharedCollStatFlagField");
		this.joinedCreditStatusFlagField	= getIntParameter("joinedCreditStatusFlagField");
		
		this.compareFields					= getIntParameters("compareFields");
		this.compareCreditJoinFields		= getIntParameters("compareCreditJoinFields");
		
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		String collateralRegNo 				= validationResult.getColumn(collateralRegNoField);
		String accountNumber 				= validationResult.getColumn(accountNumberField);
		String cif 							= validationResult.getColumn(cifField);
		String sharedCollStatFlag			= validationResult.getColumn(sharedCollStatFlagField);
		String joinedCreditStatusFlag		= validationResult.getColumn(joinedCreditStatusFlagField);
		
		SubmissionField accountNumberSf 			= submissionFormat.getFields().get(accountNumberField);
		SubmissionField joinedCreditStatusFlagSf 	= submissionFormat.getFields().get(joinedCreditStatusFlagField);
		
		if ( !StringUtils.isAnyEmpty(collateralRegNo, accountNumber, cif, sharedCollStatFlag, joinedCreditStatusFlag) ){
			ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap = submissionData.getValidationRelationModel().creditJoinRefMap;
			
			
			//~ credit join
			if ("Y".equals(joinedCreditStatusFlag)){
				List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(accountNumber);
				if ( creditJoinRows != null ){
//					for (CreditJoinRow creditJoinRow : creditJoinRows) {
//						if ( cif.equals(creditJoinRow.getCif()) ){
//							creditJoinRow.addCollateral(validationResult, collateralRegNo, accountNumber);
//						}
//					}
				} else {
					ValidationError validationError = new ValidationError(
						accountNumberSf, ValidationErrorCode.E40_05_COLL_JOIN_CRE_1,
						collateralRegNo
					);
					validationResult.errors.add(validationError);
				}
			} else {
				List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(accountNumber);
				if ( creditJoinRows != null ){
					ValidationError validationError = new ValidationError(
						joinedCreditStatusFlagSf, ValidationErrorCode.E40_06_COLL_JOIN_CRE_2,
						collateralRegNo
					);
					validationResult.errors.add(validationError);
				} 
			}
			
			int rowHashCode = ValidationUtil.createHashCode(compareFields, validationResult.rowSplited);
			int creditJoinRowHashCode = ValidationUtil.createHashCode(compareCreditJoinFields, validationResult.rowSplited);
			
			String dataOperation = validationResult.getColumn(submissionFormat.getFields().size()-1);
			
			//~ collateral 
			if ( submissionData.isValidateBetweenRow() ){
				ConcurrentMap<String, List<CollateralRow>> collateralRowMap = submissionData.getValidationRelationModel().collateralRowMap;
				putCollateralRow(
					validationResult, collateralRowMap, collateralRegNo, accountNumber, cif, sharedCollStatFlag, joinedCreditStatusFlag,
					!"D".equals(dataOperation),
					rowHashCode, creditJoinRowHashCode
				);
			}
		}
	}
	
	protected synchronized void putCollateralRow(
			ValidationResult validationResult, 
			ConcurrentMap<String, List<CollateralRow>> collateralRowMap, 
			String collateralRegNo, 
			String accountNumber, 
			String cif,
			String sharedCollStatFlag,
			String joinedCreditStatusFlag,
			boolean active,
			int rowHashCode,
			int creditJoinRowHashCode
		) {
		
		List<CollateralRow> collateralRows = collateralRowMap.get(collateralRegNo);
		if ( collateralRows == null ){
			collateralRows = new ArrayList<>();
			collateralRowMap.put(collateralRegNo, collateralRows);
		}

		collateralRows.add(
			CollateralRow.builder()
			.accountNumber(accountNumber)
			.cif(cif)
			.sharedCollStatFlag(sharedCollStatFlag)
			.joinedCreditStatusFlag(joinedCreditStatusFlag)
			.active(active)
			.rowHashCode(rowHashCode)
			.creditJoinRowHashCode(creditJoinRowHashCode)
			.fileSeq(validationResult.fileSeq)
			.rowNum(validationResult.lineNumber)
			.build()
		);
	}

}

