package id.go.ojk.client.module.bpjs;

import java.io.File;
import java.util.List;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.ValidationFileName1;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.util.FileUtil;
import id.go.ojk.lib.client.util.UtilPdf;

public class ValidationFileNameBpjs1 extends ValidationFileName1 {
  private List<SubmissionFormat> listSubmissionFormats;

  public ValidationFileNameBpjs1(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel,
      List<SubmissionFormat> listSubmissionFormats) {
    super(files, reportInfo, readDirModel);
    this.listSubmissionFormats = listSubmissionFormats;
  }

  /*
   * Periksa apakah ekstensi file = ekstensi pada metadata.
   */
  private boolean isFileExtensionEqualsWithMetadata(ValidFile file) {
    int menuCode = reportInfo.getReportGroup().getMenuCode();
    String reportTypeCode = reportInfo.getReportTypeCode();
    for (SubmissionFormat submissionFormat : listSubmissionFormats) {
      submissionFormat.setReportFormGroupCode(menuCode);
      String reportCodeFromMeta = (submissionFormat.getReportCode() == null ? "" : submissionFormat.getReportCode());
      if (reportCodeFromMeta.equals(reportTypeCode)) {
        String formCode1 = submissionFormat.getCode();
        String formCode2 = file.getPart(1);
        if(formCode1.equalsIgnoreCase(formCode2)) {
          return submissionFormat.getExtention().equalsIgnoreCase(file.getExtension());
        }
      }
    }
    return false;
  }

  @Override
  protected boolean validateFileSize(ValidFile validFile, List<String> listError) {
    long fileSize = validFile.getFile().length();
    boolean res = (fileSize != 0);
    if (!res) {
      listError.add("File '" + validFile.getFullFileName() + "' tidak berisi data");
    } else {
      if (EValidExtension.PDF.validExtension(validFile.getExtension())) {
        if(isFileExtensionEqualsWithMetadata(validFile)) {
          if (!UtilPdf.isPdf(validFile.getFile().getAbsolutePath())) {
            listError.add("File '" + validFile.getFullFileName() + "' bukan file PDF");
          }
          res = (fileSize <= 20971520);
          if (!res) {
            listError.add("File '" + validFile.getFullFileName() + "' ukuran file tidak boleh lebih dari 20 MB");
          }
        }
      } else if (EValidExtension.ZIP.validExtension(validFile.getExtension())) {
        if(isFileExtensionEqualsWithMetadata(validFile)) {
          boolean isZipFile = FileUtil.isZipFile(validFile.getFile());
          if (!isZipFile) {
            listError.add("File '" + validFile.getFullFileName() + "' bukan file ZIP");
          }
          res = (fileSize <= 20971520);
          if (!res) {
            listError.add("File '" + validFile.getFullFileName() + "' ukuran file tidak boleh lebih dari 20 MB");
          }
        }
      }
    }
    return res;
  }
}
