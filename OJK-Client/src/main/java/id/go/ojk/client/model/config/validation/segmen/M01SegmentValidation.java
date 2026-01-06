package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
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
import id.go.ojk.lib.client.model.config.validation.segmen.model.ManagementRow;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import lombok.Getter;

/**
 *	identityNumberField=XX&cifField=XX&jobPositionCode=XX&shareOwnershipField=XX&shareholderStatusCodeField=XX&compareFields=XX
 */
@XStreamAlias("m01SegmentValidation")
public class M01SegmentValidation extends MapParamSegmentValidation {
			
	private int identityNumberField;				//Nomor Identitas
	private int cifField;							//CIF
	private int jobPositionCodeField;				//Kode Jabatan
	private int shareOwnershipField;				//Pangsa Kepemilikan
	private int shareholderStatusCodeField;			//Status Pengurus/Pemilik
	
	@Getter private int[] compareFields;
		
	public M01SegmentValidation(){
		super();
	}
	
	public M01SegmentValidation(String parameter){
		super(parameter);
	}
	
	@XStreamOmitField
	private ReferenceService referenceService;

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		if ( appCtx != null ){
			referenceService = appCtx.getService(ReferenceService.class);			
		}
	}

	@Override
	public M01SegmentValidation initialized() {
		this.identityNumberField			= getIntParameter("identityNumberField");
		this.cifField						= getIntParameter("cifField");
		this.jobPositionCodeField 			= getIntParameter("jobPositionCodeField");
		this.shareOwnershipField 			= getIntParameter("shareOwnershipField");
		this.shareholderStatusCodeField 	= getIntParameter("shareholderStatusCodeField");
		
		this.compareFields					= getIntParameters("compareFields");
		
		return this;
	}
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		String identityNumber 				= validationResult.getColumn(identityNumberField);
		String cif		 					= validationResult.getColumn(cifField);
		String jobPositionCode 				= validationResult.getColumn(jobPositionCodeField);
		//Double shareOwnership 				= ValidationUtil.validateDouble(null, validationResult.rowSplited[shareOwnershipField], null) ;		
		BigDecimal shareOwnership 			= ValidationUtil.validateBigDecimal(null, validationResult.getColumn(shareOwnershipField), null) ;
		String shareholderStatusCode 		= validationResult.getColumn(shareholderStatusCodeField);
		
		if ( StringUtils.isEmpty(identityNumber) || StringUtils.isEmpty(cif) ){
			return;
		}
		
		int rowHashCode = ValidationUtil.createHashCode(compareFields, validationResult.rowSplited);
		
		ConcurrentMap<String, List<ManagementRow>> managementRowRefMap = submissionData.getValidationRelationModel().managementRowRefMap;
		ManagementRow managementRow = putManagementRow(
			validationResult, managementRowRefMap, identityNumber, cif,
			ReferenceMetadata.R43_ACTIVE_1.equals(shareholderStatusCode),
			rowHashCode
		);

		if ( StringUtils.isNotEmpty(jobPositionCode) ){
			String refLabel = referenceService.getLabel(ReferenceMetadata.R13JobPosition.getNumber(), 0, jobPositionCode);
			if ( ReferenceMetadata.R13_Category_O.equals(refLabel) || ReferenceMetadata.R13_Category_B.equals(refLabel) ){
				if ( shareOwnership == null ){
					//shareOwnership = 0d;
					shareOwnership = BigDecimal.ZERO;
				}
				managementRow.setShareOwnership(shareOwnership);
			}			
		}
	}
	
	protected synchronized ManagementRow putManagementRow(
			ValidationResult validationResult, 
			ConcurrentMap<String, List<ManagementRow>> managementRowMap, 
			String identityNumber, 
			String cif,
			boolean active,
			int rowHashCode
		) {
		
		List<ManagementRow> managementRows = managementRowMap.get(identityNumber);
		if ( managementRows == null ){
			managementRows= new ArrayList<>();
			managementRowMap.put(identityNumber, managementRows);
		}
		
		ManagementRow managementRow = 
				ManagementRow.builder()
				.rowHashCode(rowHashCode)
				.cif(cif)
				.active(active)
				.fileSeq(validationResult.fileSeq)
				.rowNum(validationResult.lineNumber)
				.build();

		managementRows.add(managementRow);
		return managementRow;
	}

}

