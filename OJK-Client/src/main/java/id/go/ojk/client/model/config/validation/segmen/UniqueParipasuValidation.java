package id.go.ojk.client.model.config.validation.segmen;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("uniqueParipasuValidation")
public class UniqueParipasuValidation extends MapParamSegmentValidation {

	private int registerCodeField;
	private int paripasuFlagField;
	
	@XStreamOmitField
	private HashSet<String> registerCodes; 

	public UniqueParipasuValidation(){
		super();
	}

	public UniqueParipasuValidation(String parameter){
		super(parameter);
	}

	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if( appCtx != null ){
			registerCodes = new HashSet<>();
		}
	}

	@Override
	public UniqueParipasuValidation initialized() {
		this.registerCodeField 	= getIntParameter("registerCodeField");
		this.paripasuFlagField 	= getIntParameter("paripasuFlagField");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String registerCode = validationResult.getColumn(registerCodeField);
		String paripasuFlag = validationResult.getColumn(paripasuFlagField);
		
		if (StringUtils.isNoneEmpty(registerCode, paripasuFlag) ){
			boolean contain = put(registerCode);			
			if ( contain && !paripasuFlag.equals("Y") ){
				SubmissionField field = submissionFormat.getFields().get(registerCodeField);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E40_03_PARIPASU_UNIQUE));
			}
		}
	}
	
	private synchronized boolean put(String registerCode){
		boolean contain = registerCodes.contains(registerCode);
		if( !contain ){
			registerCodes.add(registerCode);
		}
		return contain;
	}
	
	@Override
	public void cleanUp(){
		if ( registerCodes != null ){
			registerCodes.clear();
			registerCodes = null;
			registerCodes = new HashSet<>();
		}
	}

}
