package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.SaveMapValueForm;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.validation.BaseReadDirectory;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.lib.client.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class ReadDirectoryLktb extends BaseReadDirectory {

    @Override
    protected IValidationFile<ValidFile> initValidationFileName(List<File> files,
                                                                List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending childProgress) {
        ValidationFileNameLktb res = new ValidationFileNameLktb(files, getReportInfo(), getReadDirModel());
        res.setChildProgress(childProgress);
        res.setListSubmissionFormat(listSubmissionFormat);
        res.setMainProgress(getMainProgress());
        res.setMemberCode(getMemberCode());
        res.setMemberTypeCode(getMemberTypeCode());
        return res;
    }

    @Override
    protected void saveFormData(ProgressSegment progressSegment, File file) {
        SaveMapValueForm smv = new SaveMapValueForm(progressSegment, file);
        SubmissionFormat.treeMapPosValueForm.putAll(smv.getMapping());
        SubmissionFormat.reportPeriod = getReportPeriod(file);
    }

    @Override
    protected void clearFormData() {
        super.clearFormData();
        SubmissionFormat.treeMapPosValueForm.clear();
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
