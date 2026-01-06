package id.go.ojk.client.model.config.validation.segmen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.config.validation.segmen.model.GuarantorRow;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;

/**
 *	identityNumberField=XX&accountNumberField=XX&cifField=XX&segmentCodeField=XX&joinedCreditSegmentCode=XX&compareFields=XX&compareCreditJoinFields=XX
 */
@XStreamAlias("p01SegmentValidation")
public class P01SegmentValidation extends MapParamSegmentValidation {
			
	private int identityNumberField;
	private int accountNumberField;
	private int cifField;
	
	private int segmentCodeField;
	private String joinedCreditSegmentCode;
	
	@Getter private int[] compareFields;
	@Getter private int[] compareCreditJoinFields;
	
	public P01SegmentValidation(){
		super();
	}
	
	public P01SegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
	}

	@Override
	public P01SegmentValidation initialized() {
		this.identityNumberField			= getIntParameter("identityNumberField");
		this.accountNumberField 			= getIntParameter("accountNumberField");
		this.cifField 						= getIntParameter("cifField");
		
		this.segmentCodeField				= getIntParameter("segmentCodeField");
		this.joinedCreditSegmentCode		= getStringParameter("joinedCreditSegmentCode", "F02");
		
		this.compareFields					= getIntParameters("compareFields");
		this.compareCreditJoinFields		= getIntParameters("compareCreditJoinFields");

		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {		
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		String identityNumber 				= validationResult.getColumn(identityNumberField);
		String accountNumber 				= validationResult.getColumn(accountNumberField);
		String cif 							= validationResult.getColumn(cifField);
		String segmentCode 					= validationResult.getColumn(segmentCodeField);
		
		if ( !StringUtils.isAnyEmpty(identityNumber, accountNumber, cif) ){
			ConcurrentMap<String, List<GuarantorRow>> guarantorRowMap = submissionData.getValidationRelationModel().guarantorRowMap;
			
			boolean creditJoin = joinedCreditSegmentCode.equals(segmentCode);
			int rowHashCode = ValidationUtil.createHashCode(compareFields, validationResult.rowSplited);
			int creditJoinRowHashCode = ValidationUtil.createHashCode(compareCreditJoinFields, validationResult.rowSplited);

			putGuarantorRow(validationResult, guarantorRowMap, identityNumber, accountNumber, cif, creditJoin, rowHashCode, creditJoinRowHashCode);
		}
	}
	
	protected synchronized void putGuarantorRow(
			ValidationResult validationResult, 
			ConcurrentMap<String, List<GuarantorRow>> guarantorRowMap, 
			String identityNumber, 
			String accountNumber, 
			String cif,
			boolean creditJoin,
			int rowHashCode,
			int creditJoinRowHashCode
		) {
		
		List<GuarantorRow> guarantorRows = guarantorRowMap.get(identityNumber);
		if ( guarantorRows == null ){
			guarantorRows = new ArrayList<>();
			guarantorRowMap.put(identityNumber, guarantorRows);
		}

		guarantorRows.add(
			GuarantorRow.builder()
			.accountNumber(accountNumber)
			.cif(cif)
			.creditJoin(creditJoin)
			.rowHashCode(rowHashCode)
			.creditJoinRowHashCode(creditJoinRowHashCode)
			.fileSeq(validationResult.fileSeq)
			.rowNum(validationResult.lineNumber)
			.build()
		);
	}

}

