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
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.GuarantorRow;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("t01PostSegmentValidation")
public class T01PostSegmentValidation extends BasePostSegmentValidation {
	
	private int accountNoField;
	
	public T01PostSegmentValidation(){
		super();
	}

	public T01PostSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public T01PostSegmentValidation initialized() {
		super.initialized();
		this.accountNoField 					= getIntParameter("accountNoField");
		return this;
	}
	
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {
				
		//~ Collateral
		ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap = submissionData.getValidationRelationModel().creditJoinRefMap;
		ConcurrentMap<String, List<GuarantorRow>> guarantorRowMap = submissionData.getValidationRelationModel().guarantorRowMap;
		
		Set<String> identityNumbers = guarantorRowMap.keySet();
		for (String identityNumber : identityNumbers) {
			List<GuarantorRow> guarantorRows = guarantorRowMap.get(identityNumber);
			
			boolean isNotSame = false;
			List<GuarantorRow> guarantorMustSameList = new ArrayList<>();
			
			if ( guarantorRows.size() > 1 ){
				//cek detail must equals for same identitynumber 
				isNotSame = guarantorRows.stream().mapToInt( e -> e.getRowHashCode()).distinct().count() > 1;				
				
				//cek detail must equals for same identitynumber on credit join
				Map<String, List<GuarantorRow>> tmpMap = guarantorRows.stream()
					.filter( e -> e.isCreditJoin() )
					.collect(
						Collectors.groupingBy(
							e -> e.getAccountNumber(), 
							Collectors.toList() 
						)
					);
				
				Set<String> cjAccountSet = tmpMap.keySet();
				for (String cjAccount : cjAccountSet) {
					List<GuarantorRow> innerGuarantors = tmpMap.get(cjAccount);
					if ( innerGuarantors.size() > 0 ){
						if ( innerGuarantors.stream().map( e -> e.getCreditJoinRowHashCode()).distinct().count() > 1 ){
							innerGuarantors.stream().forEach( e -> guarantorMustSameList.add(e));
						}
					}
				}
			} 
			
			Set<String> errorCjMustExistAccountNumberSet = new HashSet<>();
			for (GuarantorRow guarantorRow : guarantorRows) {
				List<ValidationError> errors = new ArrayList<>();
				
				//~ cek detail harus sama 
				if ( isNotSame ){
					errors.add( 
						new ValidationError(
							null, ValidationErrorCode.E40_09_GUA_MUST_EQUAL,
							identityNumber
						)
					);
				}
				
				if ( guarantorMustSameList.contains(guarantorRow) ){
					errors.add( 
						new ValidationError(
							null, ValidationErrorCode.E40_09_GUA_MUST_EQUAL,
							identityNumber + "(Credit Join)"
						)
					);
				}

				//~ credit join
				if ( errorCjMustExistAccountNumberSet.add(guarantorRow.getAccountNumber()) ){
					List<CreditJoinRow> creditJoinRows = creditJoinRefMap.get(guarantorRow.getAccountNumber());
					if ( creditJoinRows != null ){
						List<String> creditJoinCifs = creditJoinRows.stream().map( e -> e.getCif() ).collect(Collectors.toList());
						
						List<String> guarantorCifs = 
							guarantorRows.stream()
							.filter(e -> e.getAccountNumber().equals(guarantorRow.getAccountNumber()))
							.map( e -> e.getCif())
							.collect(Collectors.toList());
						
						creditJoinCifs.removeAll(guarantorCifs);
						
						for (String requiredCif : creditJoinCifs) {
							errors.add( 
								new ValidationError(
									null, ValidationErrorCode.E40_12_GUA_MUST_EXIST,
									identityNumber, guarantorRow.getAccountNumber(), requiredCif
								)
							);
						}
						
						//"Harus ada penjamin No Identitas Penjamin %1$s, No. Rekening %2$s, CIF %3$s karena terdaftar di Kredit Join"		
					}
				}
				
				writeError(segmentFiles, guarantorRow.getFileSeq(), guarantorRow.getRowNum(), errors);
//				if ( errors.size() > 0 ){
//					ValidationErrorWriter validationErrorWriter = segmentFiles.get(guarantorRow.getFileSeq() - 1);
//					validationErrorWriter.writeError(guarantorRow.getRowNum(), ValidationError.errorToString(guarantorRow.getRowNum(), errors));
//				}
			}
		}
		
		//~ clear memory
		submissionData.getValidationRelationModel().creditJoinRefMap.clear();
		submissionData.getValidationRelationModel().collateralRowMap.clear();		
	}

}
