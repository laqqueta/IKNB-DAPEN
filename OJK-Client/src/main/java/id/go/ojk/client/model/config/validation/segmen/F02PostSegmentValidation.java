package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationErrorWriter;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("f02PostSegmentValidation")
public class F02PostSegmentValidation extends BasePostSegmentValidation {
	
	private int acccountNumberField;
	private int debtorSequenceField;
	private List<String> exitConditionCodes;
	
	public F02PostSegmentValidation(){
		super();
	}

	public F02PostSegmentValidation(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService;

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if( appCtx != null ){
			referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public F02PostSegmentValidation initialized() {
		super.initialized();
		this.acccountNumberField 					= getIntParameter("acccountNumberField");
		this.debtorSequenceField 					= getIntParameter("debtorSequenceField");
		this.exitConditionCodes						= getStringListParameter("exitConditionCodes");
		
		return this;
	}
	
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {
		ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap = submissionData.getValidationRelationModel().creditJoinRefMap;
		
		SubmissionField acccountNumberSf = submissionFormat.getFields().get(acccountNumberField);
		SubmissionField debtorSequenceSf = submissionFormat.getFields().get(debtorSequenceField);
		
		Set<String> accountNumbers = creditJoinRefMap.keySet();
		List<String> removeAccountNumbers = new ArrayList<>();
		
		for (String accountNumber : accountNumbers) {
			List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(accountNumber);
			
			//cek hanya yang status account aktif
			//List<CreditJoinRow> creditJoinRowsFiltered = creditJoinRows.stream().filter( e -> e.isActiveAccount() ).collect(Collectors.toList());
			List<CreditJoinRow> creditJoinRowsFiltered = 
				creditJoinRows.stream()
				.filter( e -> {
					String label = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, e.getConditionCode());
					boolean activeAccount = ReferenceMetadata.R24_Category_Y.equals(label);
					return activeAccount;
				})
				.collect(Collectors.toList());
			if ( creditJoinRowsFiltered.size() == 1 ){
				//Credit JOIN Tapi hanya keluar sekali
				removeAccountNumbers.add(accountNumber);
				CreditJoinRow creditJoinRow = creditJoinRows.get(0);
				ValidationError validationError = new ValidationError(
					acccountNumberSf, ValidationErrorCode.E40_10_CREDIT_JOIN_1,
					accountNumber
				);
				
				ValidationErrorWriter validationErrorWriter = segmentFiles.get(creditJoinRow.getFileSeq() - 1);
				validationErrorWriter.writeError(creditJoinRow.getRowNum(), validationError.toSinggleErrorString(creditJoinRow.getRowNum()));					
			} else {
				boolean isNotSame = 
					creditJoinRows.stream()
					.filter(e -> !exitConditionCodes.contains(e.getConditionCode()))
					.mapToInt( e -> e.getRowHashCode())
					.distinct().count() > 1;

				List<Integer> sequences = creditJoinRows.stream().map( e -> e.getSequence() ).sorted().collect(Collectors.toList());
				int sequenceSize = sequences.size();
				boolean isNotUrut = sequences.get(sequenceSize-1).intValue() != sequenceSize;

				for (CreditJoinRow creditJoinRow : creditJoinRows) {
					List<ValidationError> errors = new ArrayList<>();
					
					if (isNotSame && !exitConditionCodes.contains(creditJoinRow.getConditionCode())){
						ValidationError validationError = new ValidationError(
							debtorSequenceSf, ValidationErrorCode.E40_22_CREDIT_JOIN_MUST_EQUAL, accountNumber
						);
						errors.add(validationError);
					}
					
					if (isNotUrut){
						ValidationError validationError = new ValidationError(
							debtorSequenceSf, ValidationErrorCode.E40_11_CREDIT_JOIN_2
						);
						errors.add(validationError);
					}
					
					writeError(segmentFiles, creditJoinRow.getFileSeq(), creditJoinRow.getRowNum(), errors);					
				}
			}
		}
		
		for (String removeAccountNumber : removeAccountNumbers) {
			creditJoinRefMap.remove(removeAccountNumber);	
		}
	}

}

