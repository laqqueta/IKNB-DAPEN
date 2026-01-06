package id.go.ojk.client.module.tpp;

import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.validation.BaseReadDirectory;
import id.go.ojk.client.validation.IValidationFile;

import java.io.File;
import java.util.List;

public class ReadDirectoryTpp extends BaseReadDirectory {

	@Override
	protected IValidationFile<ValidFile> initValidationFileName(List<File> files,
			List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending childProgress) {
		ValidationFileNameTpp res = new ValidationFileNameTpp(files, getReportInfo(), getReadDirModel());
		res.setChildProgress(childProgress);
		res.setListSubmissionFormat(listSubmissionFormat);
		res.setMainProgress(getMainProgress());
		res.setMemberCode(getMemberCode());
		res.setMemberTypeCode(getMemberTypeCode());
		return res;
	}
}
