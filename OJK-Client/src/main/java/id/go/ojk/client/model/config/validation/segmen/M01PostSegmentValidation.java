package id.go.ojk.client.model.config.validation.segmen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.config.validation.segmen.model.ManagementRow;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

/**
 * identityNumberField=XX&shareOwnershipField=XX
 *
 */
@XStreamAlias("m01PostSegmentValidation")
public class M01PostSegmentValidation extends BasePostSegmentValidation {
	
	private int identityNumberField;
	private int shareOwnershipField;
	
	public M01PostSegmentValidation(){
		super();
	}

	public M01PostSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	@Override
	public M01PostSegmentValidation initialized() {
		super.initialized();
		this.identityNumberField 			= getIntParameter("identityNumberField");		
		this.shareOwnershipField 			= getIntParameter("shareOwnershipField");
		return this;
	}
	
	@Override
	protected void validatePostReal(List<ProgressSegmentFile> segmentFiles, SubmissionData submissionData, SubmissionFormat submissionFormat) throws IOException {		
		SubmissionField identityNumberSf = submissionFormat.getFields().get(identityNumberField);
		SubmissionField shareOwnershipSf = submissionFormat.getFields().get(shareOwnershipField);
		
		ConcurrentMap<String, List<ManagementRow>> managementRowRefMap = submissionData.getValidationRelationModel().managementRowRefMap;
		
		//~ cifManRowRefMap, untuk menghitung pangsa 100%
		Map<String, List<ManagementRow>> cifManRowRefMap = new HashMap<>();
		Set<String> identityNumbers = managementRowRefMap.keySet();
		for (String identityNumber : identityNumbers) {
			List<ManagementRow> managementRows = managementRowRefMap.get(identityNumber);
			managementRows.stream().filter( e -> e.isActive() && e.getShareOwnership() != null )
				.forEach( e -> {
					List<ManagementRow> managementRowsByCif = cifManRowRefMap.get(e.getCif());
					if ( managementRowsByCif == null) {
						managementRowsByCif = new ArrayList<>();
						cifManRowRefMap.put(e.getCif(), managementRowsByCif);
					}
					managementRowsByCif.add(e);
				});
		}
		
		for (String identityNumber : identityNumbers) {
			List<ManagementRow> managementRows = managementRowRefMap.get(identityNumber);
			
			boolean isNotSame = false;
			if ( managementRows.size() > 1 ){
				isNotSame = managementRows.stream().mapToInt( e -> e.getRowHashCode()).distinct().count() > 1;
			}
			
			for (ManagementRow managementRow : managementRows) {
				List<ValidationError> errors = new ArrayList<>();
				
				//~ cek detail harus sama 
				if ( isNotSame ){
					errors.add( 
						new ValidationError(
							null, ValidationErrorCode.E40_13_MAN_MUST_EQUAL,
							identityNumber
						)
					);
				}
				
				//sum of shareOwnership must 100%, hanya pemilik dan both
				if ( managementRow.getShareOwnership() != null ){
					List<ManagementRow> managementRowsByCif = cifManRowRefMap.get(managementRow.getCif());
					if ( managementRowsByCif != null ){
						//double shareOwnSum = managementRowsByCif.stream().mapToDouble( e -> e.getShareOwnership() ).sum();
						double shareOwnSum = ValidationUtil.sumToDouble(managementRowsByCif.stream().map(e -> e.getShareOwnership()).collect(Collectors.toList()));
						if ( shareOwnSum != 100 ){
							errors.add( 
								new ValidationError(
									shareOwnershipSf, ValidationErrorCode.E40_14_MAN_SHARE_MUST_100,
									managementRow.getCif(), shareOwnSum + ""
								)
							);
							
						}					
					}					
				}
												
				writeError(segmentFiles, managementRow.getFileSeq(), managementRow.getRowNum(), errors);
			}			
		}
		
		//~ clear memory
		submissionData.getValidationRelationModel().managementRowRefMap.clear();		
	}

}

