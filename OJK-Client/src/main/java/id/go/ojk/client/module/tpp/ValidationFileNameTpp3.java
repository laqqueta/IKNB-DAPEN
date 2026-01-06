package id.go.ojk.client.module.tpp;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.vc.ReadSubmissionDirController;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ValidationFileNameTpp3 extends ValidationFileName3 {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(ValidationFileNameTpp3.class);

    public ValidationFileNameTpp3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode, List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending mainProgress, ProgressPreparationAndSending childProgress, ReadSubmissionDirController.ReadSubmissionDirModel readDirModel) {
        super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat, mainProgress, childProgress, readDirModel);
    }

    @Override
    protected List<ValidFile> listValidFileName(SubmissionFormat submissionFormat, String firstPeriodReport) {
        List<ValidFile> res = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            files.forEach(file -> {
                String firstPeriodType = file.getPart(3);
                String formattedFileName = submissionFormat.getReportCode() + "-" + submissionFormat.getCode() + "-"
                        + reportInfo.getReportGroup().getDeliveryCode() + "-" + firstPeriodType + "-" + firstPeriodReport
                        + "-" + memberCode + "-" + memberTypeCode;

                if (file.getFileName().equals(formattedFileName)) {
                    if (!file.getExtension().equals(submissionFormat.getExtention())) {
                        logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
                                "Ekstensi file '" + file.getFullFileName() + "' tidak sesuai"));
                    } else {
                        listFile.add(file);
                        res.add(file);
                    }
                } else {
                    logger.error("{}!={}", file.getFileName(), formattedFileName);
                }
            });
        }
        return res;
    }
}
