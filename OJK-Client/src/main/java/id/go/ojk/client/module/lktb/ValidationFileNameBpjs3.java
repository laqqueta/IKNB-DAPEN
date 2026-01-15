package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;

import java.util.List;

public class ValidationFileNameBpjs3 extends ValidationFileName3 {

  public ValidationFileNameBpjs3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
      List<SubmissionFormat> listSubmissionFormat) {
    super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat);
  }

  public ValidationFileNameBpjs3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
      List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending mainProgress,
      ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
    super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat, mainProgress, childProgress,
        readDirModel);
  }
}
