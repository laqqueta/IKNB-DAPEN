package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.ValidationFileName3;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ValidationFileNameLktb3 extends ValidationFileName3 {

    private final Logger logger = LoggerFactory.getLogger(ValidationFileNameLktb3.class);

    public ValidationFileNameLktb3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
                                   List<SubmissionFormat> listSubmissionFormat) {
        super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat);
    }

    public ValidationFileNameLktb3(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
                                   List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending mainProgress,
                                   ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
        super(files, reportInfo, memberCode, memberTypeCode, listSubmissionFormat, mainProgress, childProgress,
                readDirModel);
    }

    @Override
    public boolean validate() {
        logger.info("Validator=" + this.getClass().getName());
        if (listSubmissionFormat != null && !listSubmissionFormat.isEmpty()) {
            String firstPeriodReport = files.get(0).getPart(4);
            String reportTypeCode = reportInfo.getReportTypeCode();
            int menuCode = reportInfo.getReportGroup().getMenuCode();
            String jenisProgram = JenisProgramState.selectedKey.replaceAll("[^a-zA-Z0-9]", "");
            for (int i = 0; i < listSubmissionFormat.size(); i++) {
                SubmissionFormat submissionFormat = listSubmissionFormat.get(i);
                submissionFormat.setReportFormGroupCode(menuCode);
                String reportCodeFromMeta = (submissionFormat.getReportCode() == null ? ""
                        : submissionFormat.getReportCode());
                if (reportCodeFromMeta.equals(jenisProgram)) {
//                    submissionFormat.setReportCode(reportCodeFromMeta);
                    List<ValidFile> listSegmentFile = listValidFileName(submissionFormat, firstPeriodReport);
                    if (validateFormCode(listSegmentFile, submissionFormat)) {
                        addToSegment(submissionFormat, listSegmentFile);
                    }
                } else {
                    logger.warn("reportGroupCode=" + menuCode + ">(reportCodeFromMeta=" + reportCodeFromMeta
                            + ")!=(reportCodeSector=" + reportTypeCode + ")");
                }
            }
            if (validateFileName()) {
                setSubmissionFtp(firstPeriodReport);
            }
        }
        boolean res = getListValidationError().isEmpty();
        if (!res) {
            logger.error("Validation failed!!!");
        }
        return res;
    }

    @Override
    protected List<ValidFile> listValidFileName(SubmissionFormat submissionFormat, String firstPeriodReport) {
        List<ValidFile> res = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            String firstPeriodType = files.get(0).getPart(3);
            String formattedFileName = reportInfo.getReportTypeCode() + "-" + submissionFormat.getCode() + "-"
                    + reportInfo.getReportGroup().getDeliveryCode() + "-" + firstPeriodType + "-" + firstPeriodReport
                    + "-" + memberCode + "-" + memberTypeCode;
            for (int i = 0; i < files.size(); i++) {
                ValidFile file = files.get(i);
                if (file.getFileName().equals(formattedFileName)) {
                    if (!file.getExtension().equals(submissionFormat.getExtention())) {
                        logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
                                "Ekstensi file '" + file.getFullFileName() + "' tidak sesuai"));
                    } else {
                        listFile.add(file);
                        res.add(file);
                        break;
                    }
                } else {
                    logger.error(file.getFileName() + "!=" +  formattedFileName);
                }
            }
        }
        return res;
    }
}
