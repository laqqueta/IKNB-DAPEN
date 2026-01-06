package id.go.ojk.client.module.apu;

import java.io.File;
import java.util.List;

import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.module.ValidationFileName1;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.module.rb.EReportGroupRb;
import id.go.ojk.client.validation.BaseValidationFileName;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

public class ValidationFileNameApu extends BaseValidationFileName {

	public ValidationFileNameApu(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation1() {
		return new ValidationFileName1(files, reportInfo, readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation2() {
		return new ValidationFileNameApu2(getListFile(), reportInfo, memberCode, memberTypeCode, childProgress,
				readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation3() {
		return new ValidationFileName3(getListFile(), reportInfo, memberCode, memberTypeCode, 
				listSubmissionFormat, mainProgress, childProgress, readDirModel);
	}

	@Override
	protected ReportGroup getReportGroup(int reportFormGroupCode) {
		return EReportGroupRb.getObjectByCode(reportFormGroupCode);
	}

}
