package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.ReportGroup;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.validation.BaseValidationFileName;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

import java.io.File;
import java.util.List;

public class ValidationFileNameLktb extends BaseValidationFileName {

  public ValidationFileNameLktb(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
    super(files, reportInfo, readDirModel);
  }

  @Override
  public IValidationFile<ValidFile> initValidation1() {
    return new ValidationFileNameLktb1(files, reportInfo, readDirModel, listSubmissionFormat);
  }

  @Override
  public IValidationFile<ValidFile> initValidation2() {
    return new ValidationFileNameLktb2(getListFile(), reportInfo, memberCode, memberTypeCode, childProgress,
        readDirModel);
  }

  @Override
  public IValidationFile<ValidFile> initValidation3() {
    return new ValidationFileNameLktb3(getListFile(), reportInfo, memberCode, memberTypeCode, listSubmissionFormat,
        mainProgress, childProgress, readDirModel);
  }

  @Override
  protected ReportGroup getReportGroup(int reportFormGroupCode) {
    return EReportGroupLktb.getObjectByCode(reportFormGroupCode);
  }

  @Override
  public boolean validate() {
    if (files == null)
      return false;

    boolean res1 = validation1();
    boolean res2 = false;
    boolean res3 = false;
    boolean hasValidation3 = false;

    if (res1) {
      res2 = validation2();
      if (res2) {
        res3 = validation3();
        hasValidation3 = true;
      }
    }

    // Kalau validation3 belum jalan, coba tampilkan error di validation 3
    if (!hasValidation3) {
      logInvalidFileError();
    }
    return res1 && res2 && res3;
  }

  private void logInvalidFileError() {
    int menuCode = reportInfo.getReportGroup().getMenuCode();
    String reportTypeCode = reportInfo.getReportTypeCode();
    for (SubmissionFormat submissionFormat : listSubmissionFormat) {
      submissionFormat.setReportFormGroupCode(menuCode);
      String reportCodeFromMeta = (submissionFormat.getReportCode() == null ? "" : submissionFormat.getReportCode());
      if (reportCodeFromMeta.equals(reportTypeCode)) {
        String formCode1 = submissionFormat.getCode();
        List<ValidFile> validFiles = getListFile();
        boolean exist = false;
        for (ValidFile file : validFiles) {
          String formCode2 = file.getPart(1);
          if (formCode2.equalsIgnoreCase(formCode1)) {
            exist = true;
            break;
          }
        }

        if (!exist) {
          ValidationError error = new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
              "Form '" + formCode1 + "' tidak ditemukan / tidak sesuai format.");
          getListValidationError().add(error);
          if (readDirModel != null) {
            readDirModel.logError(error);
          }
        }
      }
    }
  }
}
