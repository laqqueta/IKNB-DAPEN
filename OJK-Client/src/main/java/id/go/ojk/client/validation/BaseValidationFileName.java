package id.go.ojk.client.validation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

public abstract class BaseValidationFileName implements IValidationFile<ValidFile> {
	protected List<File> files;
	protected String memberCode;
	protected String memberTypeCode;
	protected ReportInfo reportInfo;
//	protected ReportGroup reportGroup;
	protected ReadSubmissionDirModel readDirModel;
//	protected String sectorCode;
//	protected String sectorReportCode;
//	protected String reportCode;
	protected List<SubmissionFormat> listSubmissionFormat;
	protected ProgressPreparationAndSending mainProgress; 
	protected ProgressPreparationAndSending childProgress;
	private List<ValidationError> listValidationError = new ArrayList<>();
	private List<ValidFile> listFile = new ArrayList<>();

	protected BaseValidationFileName(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
		this.files = files;
		this.readDirModel = readDirModel;
		this.reportInfo = reportInfo;
	}
	
	protected abstract ReportGroup getReportGroup(int reportFormGroupCode);
	
	@Override
	public boolean validate() {
		boolean res = false;
		if (files != null) {
			if (res = validation1()) {
				if (res = validation2()) {
					res = validation3();
				}
			}
		}
		return res;
	}

	public List<ValidationError> getListValidationError() {
		return listValidationError;
	}

	public List<ValidFile> getListFile() {
		return listFile;
	}
	
	public abstract IValidationFile<ValidFile> initValidation1();
	
	public abstract IValidationFile<ValidFile> initValidation2();
	
	public abstract IValidationFile<ValidFile> initValidation3();
	
	protected boolean validation1() {
		return validation(initValidation1());
	}
	
	protected boolean validation2() {
		return validation(initValidation2());
	}
	
	protected boolean validation3() {
		return validation(initValidation3());
	}

	protected boolean validation(IValidationFile<ValidFile> validationImpl) {
		boolean res = false;
		if (validationImpl != null) {
			res = validationImpl.validate();
			listFile = validationImpl.getListFile();
			getListValidationError().addAll(validationImpl.getListValidationError());
		}
		return res;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public void setMemberTypeCode(String memberTypeCode) {
		this.memberTypeCode = memberTypeCode;
	}

//	public void setSectorCode(String sectorCode) {
//		this.sectorCode = sectorCode;
//	}
//
//	public void setSectorReportCode(String sectorReportCode) {
//		this.sectorReportCode = sectorReportCode;
//	}

	public void setListSubmissionFormat(List<SubmissionFormat> listSubmissionFormat) {
		this.listSubmissionFormat = listSubmissionFormat;
	}

	public void setMainProgress(ProgressPreparationAndSending mainProgress) {
		this.mainProgress = mainProgress;
	}

	public void setChildProgress(ProgressPreparationAndSending childProgress) {
		this.childProgress = childProgress;
	}
	
//	public void setReportCode(String reportCode) {
//		this.reportCode = reportCode;
//	}
}
