package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CollateralRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("a01PostSegmentValidation")
public class A01PostSegmentValidation extends BasePostSegmentValidation {
	
	private int sharedCollStatFlagField;
	private int accountNoField;
	
	public A01PostSegmentValidation(){
		super();
	}

	public A01PostSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public A01PostSegmentValidation initialized() {
		super.initialized();
		this.sharedCollStatFlagField 			= getIntParameter("sharedCollStatFlagField");		
		this.accountNoField 					= getIntParameter("accountNoField");
		return this;
	}
	
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {
		//~ Collateral
		
		SubmissionField sharedCollStatFlagSf = submissionFormat.getFields().get(sharedCollStatFlagField);
		
		ConcurrentMap<String, List<CollateralRow>> collateralRowMap = submissionData.getValidationRelationModel().collateralRowMap;
		ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap = submissionData.getValidationRelationModel().creditJoinRefMap;
		
		Set<String> collateralRegNos = collateralRowMap.keySet();
		for (String collateralRegNo : collateralRegNos) {
			List<CollateralRow> collateralRows = collateralRowMap.get(collateralRegNo);
			
			boolean checkParipasu = false;
			boolean isNotSame = false;
			
			List<CollateralRow> collateralMustSameList = new ArrayList<>();
						
			if ( collateralRows.size() > 1 ){
				checkParipasu = collateralRows.stream().filter( e -> e.isActive() ).map( e -> e.getAccountNumber() ).distinct().count() > 1;
				
				//D boleh beda taidak wajib sama
				isNotSame = collateralRows.stream().filter( e -> e.isActive() ).mapToInt( e -> e.getRowHashCode()).distinct().count() > 1;				
				
				//cek detail must equals for same identitynumber on credit join
				Map<String, List<CollateralRow>> tmpMap = collateralRows.stream()
					.filter( e -> "Y".equals(e.getJoinedCreditStatusFlag()) )
					.collect(
						Collectors.groupingBy(
							e -> e.getAccountNumber(), 
							Collectors.toList() 
						)
					);
				
				Set<String> cjAccountSet = tmpMap.keySet();
				for (String cjAccount : cjAccountSet) {
					List<CollateralRow> innerCollaterals = tmpMap.get(cjAccount);
					if ( innerCollaterals.size() > 0 ){
						if ( innerCollaterals.stream().filter( e -> e.isActive() ).map( e -> e.getCreditJoinRowHashCode()).distinct().count() > 1 ){
							innerCollaterals.stream().forEach( e -> collateralMustSameList.add(e));
						}
					}
				}
			}
			
			Set<String> errorCjMustExistAccountNumberSet = new HashSet<>();

			for (CollateralRow collateralRow : collateralRows) {
				List<ValidationError> errors = new ArrayList<>();

				if ( collateralRow.isActive() ){
					
					//~ cek apakah harus paripasu
					if( checkParipasu ){
						if ( "T".equals(collateralRow.getSharedCollStatFlag()) ){
							errors.add( 
								new ValidationError(
									sharedCollStatFlagSf, ValidationErrorCode.E40_04_MUST_PARIPASU,
									collateralRegNo
								)
							);
						}
					} else {
						if ( "Y".equals(collateralRow.getSharedCollStatFlag()) ){
							errors.add( 
								new ValidationError(
									sharedCollStatFlagSf, ValidationErrorCode.E40_15_MUST_NOT_PARIPASU,
									collateralRegNo
								)
							);
						}
					}
					
					//~ cek detail harus sama (cek data credit join)
					if ( "Y".equals(collateralRow.getJoinedCreditStatusFlag()) ){
						//Credit Join
						if ( collateralMustSameList.contains(collateralRow) ){
							errors.add( 
								new ValidationError(
									null, ValidationErrorCode.E40_08_COLL_MUST_EQUAL,
									collateralRegNo + " (Credit Join) "
								)
							);
						}										
					} 
					
					//~ harus sama (cek data paripasu) 
					if ( isNotSame ){
						errors.add( 
							new ValidationError(
								null, ValidationErrorCode.E40_08_COLL_MUST_EQUAL,
								collateralRegNo 
							)
						);
					}
					
				}
				
				//~ credit join
				if ( errorCjMustExistAccountNumberSet.add(collateralRow.getAccountNumber()) ){
					List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(collateralRow.getAccountNumber());
					if ( creditJoinRows != null ){
						List<String> creditJoinCifs = creditJoinRows.stream().map( e -> e.getCif() ).collect(Collectors.toList());
						
						List<String> collateralCifs = 
							collateralRows.stream()
							.filter(e -> e.getAccountNumber().equals(collateralRow.getAccountNumber()))
							.map( e -> e.getCif())
							.collect(Collectors.toList());
						
						creditJoinCifs.removeAll(collateralCifs);
						
						for (String requiredCif : creditJoinCifs) {
							errors.add( 
								new ValidationError(
									null, ValidationErrorCode.E40_07_COLL_MUST_EXIST,
									collateralRegNo, collateralRow.getAccountNumber(), requiredCif
								)
							);
						}					
					}
				}
								
				writeError(segmentFiles, collateralRow.getFileSeq(), collateralRow.getRowNum(), errors);
			}			
		}
		
		//~ clear memory
		submissionData.getValidationRelationModel().collateralRowMap.clear();		
	}

}

