package id.go.ojk.client.module.tpp;

import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.module.ValidationFileName1;
import id.go.ojk.client.module.rb.EReportGroupRb;
import id.go.ojk.client.validation.BaseValidationFileName;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

import java.io.File;
import java.util.List;

public class ValidationFileNameTpp extends BaseValidationFileName {

	public ValidationFileNameTpp(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation1() {
		return new ValidationFileName1(files, reportInfo, readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation2() {
		return new ValidationFileNameTpp2(getListFile(), reportInfo, memberCode, memberTypeCode, childProgress,
				readDirModel);
	}

	@Override
	public IValidationFile<ValidFile> initValidation3() {
		return new ValidationFileNameTpp3(getListFile(), reportInfo, memberCode, memberTypeCode,
				listSubmissionFormat, mainProgress, childProgress, readDirModel);
	}

	@Override
	protected ReportGroup getReportGroup(int reportFormGroupCode) {
		return EReportGroupTpp.getObjectByCode(reportFormGroupCode);
	}

}
