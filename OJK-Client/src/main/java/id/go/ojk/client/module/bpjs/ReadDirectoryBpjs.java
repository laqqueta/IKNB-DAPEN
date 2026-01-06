package id.go.ojk.client.module.bpjs;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.validation.BaseReadDirectory;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.lib.client.DateUtil;

public class ReadDirectoryBpjs extends BaseReadDirectory {

  @Override
  protected IValidationFile<ValidFile> initValidationFileName(List<File> files,
      List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending childProgress) {
    ValidationFileNameBpjs res = new ValidationFileNameBpjs(files, getReportInfo(), getReadDirModel());
    res.setChildProgress(childProgress);
    res.setListSubmissionFormat(listSubmissionFormat);
    res.setMainProgress(getMainProgress());
    res.setMemberCode(getMemberCode());
    res.setMemberTypeCode(getMemberTypeCode());
    return res;
  }

  @Override
  protected void saveFormData(ProgressSegment progressSegment, File file) {
    super.saveFormData(progressSegment, file);
    SubmissionFormat.reportPeriod = getReportPeriod(file);
  }

  private LocalDate getReportPeriod(File file) {
    String[] fileNameSplit = StringUtils.splitPreserveAllTokens(file.getName(), "-");
    try {
      String dateAsString = fileNameSplit[4];
      LocalDate date = LocalDate.parse(dateAsString, DateUtil.dateTimeFormatterYYYYmmss);
      return date;
    } catch (Exception e) {
      return null;
    }
  }
}
