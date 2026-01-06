package id.go.ojk.client.module.pls;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.client.validation.BaseReadDirectory;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadDirectoryPls extends BaseReadDirectory {
  private JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
  private static final int IMPORT_THREAD_SIZE = 2;

  @Override
  protected IValidationFile<ValidFile> initValidationFileName(List<File> files,
      List<SubmissionFormat> listSubmissionFormat, ProgressPreparationAndSending childProgress) {
    ValidationFileNamePls res = new ValidationFileNamePls(files, getReportInfo(), getReadDirModel());
    res.setChildProgress(childProgress);
    res.setListSubmissionFormat(listSubmissionFormat);
    res.setMainProgress(getMainProgress());
    res.setMemberCode(getMemberCode());
    res.setMemberTypeCode(getMemberTypeCode());
    return res;
  }

  @Override
  protected void clearFormData() {
    super.clearFormData();
    db.delete();
  }

  @Override
  protected void readDirAndChecksum(ProgressPreparationAndSending childProgress) {
    for (ProgressSegment progressSegment : childProgress.getSegments()) {
      for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
        if (readDirModel.isStop()) {
          break;
        }
        FileIntegrity fileIntegrity = progressSegmentFile.getFileIntegrity();
        if (runOnClient) {
          readDirModel.writeProcessLog("Baca file " + fileIntegrity.getFile());
          setFileChecksum(readDirModel, 0.8, fileIntegrity);
        }
        saveFormData(progressSegment, fileIntegrity.getFile());
        SubmissionFormat.reportPeriod = getReportPeriod(fileIntegrity);
      }
    }

    importTxt(childProgress);
  }

  @Override
  protected void saveFormData(ProgressSegment progressSegment, File file) {
    db.updateIndexToColumnMapping(progressSegment.getSubmissionFormat());
  }

  private LocalDate getReportPeriod(FileIntegrity fileIntegrity) {
    String[] fileNameSplit = StringUtils.splitPreserveAllTokens(fileIntegrity.getFileName(), "-");
    try {
      String dateAsString = fileNameSplit[4];
      LocalDate date = LocalDate.parse(dateAsString, DateUtil.dateTimeFormatterYYYYmmss);
      return date;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return ReferenceServiceClient.minAllDate.getMinValue();
    }
  }

  private void importTxt(ProgressPreparationAndSending childProgress) {
    ExecutorService executor = Executors.newFixedThreadPool(IMPORT_THREAD_SIZE);
    for (ProgressSegment progressSegment : childProgress.getSegments()) {
      for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {
        if (progressSegmentFile.getFileIntegrity().getFileName().endsWith(".txt")) {
          executor.execute(new Runnable() {
            @Override
            public void run() {
              try {
                Path path = Paths.get(progressSegmentFile.getFileIntegrity().getFile().getPath());
                readDirModel.writeProcessLog("Import file " + path.toString());
                db.importTxt(path);
              } catch (SQLException | IOException e) {
                log.error(e.getMessage(), e);
                throw new SlikException(JdbcService.SQL_EXCEPTION_MESSAGE);
              }
            }
          });
        }
      }
    }

    executor.shutdown();

    while (!executor.isTerminated()) {
      // The progress value are estimated / dummy
      try {
        if (readDirModel.getProgress() <= 0.95) {
          Thread.sleep(1000);
          readDirModel.setProgress(readDirModel.getProgress() + 0.0001);
        }
      } catch (InterruptedException e) {
        log.error(e.getMessage(), e);
        Thread.currentThread().interrupt();
      }
    }
    readDirModel.setProgress(1);
  }
}
