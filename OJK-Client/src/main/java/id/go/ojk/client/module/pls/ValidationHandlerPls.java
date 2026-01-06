package id.go.ojk.client.module.pls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.db.util.FileUtil;
import id.go.ojk.client.db.util.ResultSetUtil;
import id.go.ojk.client.db.validation.ValidationContentHandler;
import id.go.ojk.client.db.validation.ValidationResultComparator;
import id.go.ojk.client.db.validation.conditional.DbConditionalPosAndComparatorHasValue;
import id.go.ojk.client.db.validation.conditional.DbConditionalPosAndComparatorNotEmpty;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.conditional.ConditionalPosAndComparatorHasValue;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.conditional.ExistPosAndComparatorNotEmptyConditional;
import id.go.ojk.client.model.config.validation.conditional.ExistPosConditional;
import id.go.ojk.client.model.config.validation.segmen.ComparisonFormValidation;
import id.go.ojk.client.model.config.validation.segmen.ComparisonFormulaValidation;
import id.go.ojk.client.model.config.validation.segmen.IsExistsFormValidation;
import id.go.ojk.client.model.config.validation.segmen.IsExistsFormValidationJdbc;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationHandler;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.validation.IValidationContent;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.CrLfType;
import id.go.ojk.lib.client.util.CustomBufferedReader;
import javafx.application.Platform;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("restriction")
@Slf4j
public class ValidationHandlerPls extends ValidationHandler {
  private final JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
  private final long errorLimit = ConfigService.maxErrorCount.getDefauldValue();
  private int totalRow = 0;
  private final ValidationContentHandler handler;

  public ValidationHandlerPls(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
      ThreadPoolExecutor executor) {
    super(progressModel, progressSegment, executor);
    handler = new ValidationContentHandler(submissionFormat);
  }

  @Override
  @SneakyThrows
  protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
      int reportFormGroupCode) throws IOException {
    totalRow = db.getRowCount(progressSegment.getSubmissionFormat()) + 1;
    IValidationContent validation = new ValidationPreHeaderPls(progressSegmentFile.getFileIntegrity().getFile(),
        totalRow, reportFormGroupCode, submissionFormat, validationResult);
    validation.validate();
  }

  @Override
  public int getSumRow() {
    return totalRow;
  }

  private void openErrorFile(ProgressSegmentFile progressSegmentFile) throws IOException {
    String errorFileNamePath = progressModel.getValidationErrorDir().getAbsolutePath() + "/"
        + progressSegmentFile.getFileIntegrity().getFile().getName()
        + (progressModel.getSubmissionData().isRunInJavaFx() ? ".err" : ".valerr");

    File errorFile = new File(errorFileNamePath);
    progressSegmentFile.setErrorFile(errorFile);
    errorFile.getParentFile().mkdirs();

    progressSegmentFile.openErrorFile(false);
    progressSegmentFile.writeReserveErrorHeader();
  }

  private void closeErrorFile(ProgressSegmentFile progressSegmentFile) {
    progressSegmentFile.closeErrorFile();
  }

  @Override
  @SneakyThrows
  public void startValidation(int reportFormGroupCode) {
    List<ProgressSegmentFile> progressSegmentFiles = this.progressSegment.getSegmentFiles();

    for (int i = 0; i < progressSegmentFiles.size(); i++) {
      ProgressSegmentFile progressSegmentFile = progressSegmentFiles.get(i);
      if (progressSegmentFile.getFileIntegrity().getFileName().endsWith(".txt")) {
        try {
          openErrorFile(progressSegmentFile);

          log.info("Validating '{}' ({})", progressSegmentFile.getFileIntegrity().getFileName(),
              FileUtil.getFileSizeAsString(progressSegmentFile.getFileIntegrity().getFile()));
          if (progressModel.isRequestStop())
            break;

          submissionFormat.setTotalRow(totalRow);

          List<ValidationResult> allErrors = new ArrayList<ValidationResult>();
          ValidationResult headerErrors = validateHeader(i, progressSegmentFile, reportFormGroupCode);
          if (headerErrors != null && headerErrors.isError()) {
            allErrors.add(headerErrors);
          }
          
          if(!headerErrors.stopValidation ) {
            logDebug("***** Validate Column Count *****");
            allErrors.addAll(validateColumnCount(i, progressSegmentFile));

            logDebug("***** Validate CRLF *****");
            if(allErrors.size() < errorLimit)
              allErrors.addAll(validateCrlf(i, progressSegmentFile));

            logDebug("***** Validate Fields *****");
            if(allErrors.size() < errorLimit)
              allErrors.addAll(validateFields(i, progressSegmentFile));
  
            logDebug("***** Validate Forms *****");
            if(allErrors.size() < errorLimit)
              allErrors.addAll(validateForms(i, progressSegmentFile));
          }
          allErrors = allErrors.stream().limit(errorLimit).collect(Collectors.toList());
          allErrors.sort(ValidationResultComparator.createOrderByLineNumber());
          allErrors.forEach(error -> {
            try {
              progressSegmentFile.writeErrorSort(error);
            } catch (IOException e) {
              log.error(e.getMessage(), e);
              throw new SlikException(e.getMessage(), e);
            }
          });

          progressSegmentFile.setTotalRow(totalRow);
          progressSegmentFile.setTotal(totalRow - 1);
          progressSegmentFile.setTotalError(allErrors.size());
          progressModel.recalcTotalErrorString();
        } finally {
          closeErrorFile(progressSegmentFile);
        }
      }
      updateProgressBar(progressSegmentFile, true);
      progressModel.writeProcessLogFile(progressSegment.getSubmissionFormat().getCode(), progressSegmentFile);
    }
  }

  @SneakyThrows
  private ValidationResult validateHeader(int fileSequence, ProgressSegmentFile progressSegmentFile,
      int reportFormGroupCode) {
    ValidationResult headerValidationResult = null;

    try (CustomBufferedReader reader = new CustomBufferedReader(
        new InputStreamReader(new FileInputStream(progressSegmentFile.getFileIntegrity().getFile())))) {
      headerValidationResult = new ValidationResult(fileSequence, 0, reader.readLineWithStartPosition());
      validatePreHeader(progressSegmentFile, headerValidationResult, reportFormGroupCode);
    }

    if (validateRequiredRows(submissionFormat, headerValidationResult, 1)) {
      validateUniqueRows(submissionFormat, headerValidationResult, 1);
    }

    return headerValidationResult;
  }

  private boolean validateRequiredRows(SubmissionFormat submissionFormat, ValidationResult validationResult,
      int columnIndex) {
    String requiredPos = submissionFormat.getRequiredPos();
    if (StringUtils.isEmpty(requiredPos))
      return true;

    boolean res = true;
    String[] requiredRows = StringUtils.split(requiredPos, "|");
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), columnIndex);

    if (StringUtils.isEmpty(columnName))
      return true;

    for (int i = 0; i < requiredRows.length; i++) {
      String code = requiredRows[i];
      StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ").append(tableName).append(" t WHERE t.")
          .append(columnName).append(" = '").append(code).append("'");
      log.debug(sql.toString());
      try (Connection conn = db.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql.toString());) {
        rs.next();
        long count = rs.getLong(1);
        if (count < 1) {
          validationResult.errors
              .add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST, false, code));
          res = false;
        }
      } catch (SQLException e) {
        log.error(e.getMessage(), e);
        throw new SlikException(JdbcService.SQL_EXCEPTION_MESSAGE);
      }
    }
    return res;
  }

  private void validateUniqueRows(SubmissionFormat submissionFormat, ValidationResult validationResult,
      int columnIndex) {
    String uniquePos = submissionFormat.getUniquePos();
    if (StringUtils.isEmpty(uniquePos))
      return;

    String[] requiredRows = StringUtils.split(uniquePos, "|");
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), columnIndex);

    if (StringUtils.isEmpty(columnName))
      return;

    for (int i = 0; i < requiredRows.length; i++) {
      String code = requiredRows[i];
      StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM ").append(tableName).append(" t WHERE t.")
          .append(columnName).append(" = '").append(code).append("'");
      log.debug(sql.toString());
      try (Connection conn = db.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql.toString());) {
        rs.next();
        long count = rs.getLong(1);
        if (count != 1) {
          validationResult.errors
              .add(new ValidationError(null, ValidationErrorCode.E14_02_UNIQUE_POS_NOT_COMBINE, code));
        }
      } catch (SQLException e) {
        log.error(e.getMessage(), e);
        throw new SlikException(JdbcService.SQL_EXCEPTION_MESSAGE);
      }
    }
  }

  @SneakyThrows
  private List<ValidationResult> validateColumnCount(int fileSequence, ProgressSegmentFile progressSegmentFile) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    List<String> allColumns = db.getAllColumnName(submissionFormat);
    int fieldCount = submissionFormat.getFields().size();

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE column_count != ").append(fieldCount).append(" LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(entry -> {
      ValidationResult validationResult = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
      ValidationError validationError = new ValidationError(null, ValidationErrorCode.E04_02_DETAIL_COLUMN_AMOUNT,
          fieldCount);
      validationResult.errors.add(validationError);
      validationResults.add(validationResult);
    });
    return validationResults;
  }

  @SneakyThrows
  private List<ValidationResult> validateCrlf(int fileSequence, ProgressSegmentFile progressSegmentFile) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();

    int lineNum = 1;
    try (CustomBufferedReader reader = new CustomBufferedReader(
        new InputStreamReader(new FileInputStream(progressSegmentFile.getFileIntegrity().getFile())))) {
      Tupple3<Long, String, CrLfType> lineInfo = null;
      while ((lineInfo = reader.readLineWithStartPosition()) != null) {
        if(lineInfo.getA() < 1) {
          continue;
        }
        if(lineInfo.getC() != CrLfType.crLf) {
          ValidationResult validationResult = new ValidationResult(fileSequence, lineNum, lineInfo);
          validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
          validationResults.add(validationResult);
        }

        if (lineNum > errorLimit)
          break;
        lineNum++;
      }
    }

    return validationResults;
  }

  private List<ValidationResult> validateFields(int fileSequence, ProgressSegmentFile progressSegmentFile) {
    long fileSize = progressSegmentFile.getFileIntegrity().getFile().length();
    long progressPercentEach = fileSize / (submissionFormat.getFields().size() - 1);

    List<ValidationResult> errors = new ArrayList<ValidationResult>();
    for (SubmissionField field : submissionFormat.getFields()) {
      log.info("{}", field.getName());
      errors.addAll(validateRequiredCondition(fileSequence, field));
      updateProgressBar(progressPercentEach, progressSegmentFile, false);
      if (errors.size() >= errorLimit)
        return errors.stream().limit(errorLimit).collect(Collectors.toList());
//      progressPercentEach = +progressPercentEach;
    }
    return errors;
  }

  @SneakyThrows
  private List<ValidationResult> validateRequiredCondition(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    SimpleValidation simpleValidation = field.getSimpleValidation();
    switch (simpleValidation.getRequiredCondition()) {
      case M:
        List<ValidationResult> errors = handler.validateMandatoryField(fileSequence, field);
        if (errors.isEmpty()) {
          validationResults.addAll(validateField(fileSequence, field));
          validationResults.addAll(handler.validateCustomFields(fileSequence, field));
        } else {
          validationResults.addAll(errors);
//        return validationResults if validationResults.size > errorLimit
          if (validationResults.size() >= errorLimit)
            return validationResults;

          validationResults.addAll(handler.validateCustomFields(fileSequence, field));
        }
        break;
      case N:
        validationResults.addAll(handler.validateMustEmptyField(fileSequence, field));
        break;
      case C:
        List<ValidationResult> conditionalErrors = new ArrayList<>();
        ConditionalRequired conditional = simpleValidation.getConditionalRequired();
        if (conditional instanceof ExistPosConditional) {
          conditionalErrors.addAll(handler.validateExistPosConditional(fileSequence, conditional, field));
        } else if (conditional instanceof ConditionalPosAndComparatorHasValue) {
        	conditionalErrors.addAll(new DbConditionalPosAndComparatorHasValue(db, submissionFormat).validate(fileSequence, conditional, field));
//          conditionalErrors.addAll(handler.validateConditionalPosAndComparatorHasValue(fileSequence, conditional, field));
        } else if (conditional instanceof ExistPosAndComparatorNotEmptyConditional) {
            conditionalErrors.addAll(new DbConditionalPosAndComparatorNotEmpty(db, submissionFormat).validate(fileSequence, conditional, field));
        } else {
          String err = String.format("Conditional validation '%s' is not implemented.",
              conditional.getClass().getName());
          log.error(err);
          throw new SlikException(err);
        }
        if (conditionalErrors.isEmpty()) {
          validationResults.addAll(validateField(fileSequence, field));
        } else {
          validationResults.addAll(conditionalErrors);
//        return validationResults if validationResults.size > errorLimit
          if (validationResults.size() >= errorLimit)
            return validationResults;
          validationResults.addAll(validateField(fileSequence, field, conditionalErrors));
        }
        
//      return validationResults if validationResults.size > errorLimit
        if (validationResults.size() >= errorLimit)
          return validationResults;
        validationResults.addAll(handler.validateCustomFields(fileSequence, field));
        break;
      case O:
        validationResults.addAll(handler.validateOptionalField(fileSequence, field));
        break;
      default:
        break;
    }
    return validationResults;
  }
  
  private List<ValidationResult> validateField(int fileSequence, SubmissionField field) {
    return validateField(fileSequence, field, new ArrayList<ValidationResult>());
  }

  private List<ValidationResult> validateField(int fileSequence, SubmissionField field, List<ValidationResult> conditionalErrors) {
    List<ValidationResult> errors = new ArrayList<ValidationResult>();
    DataType dataType = field.getSimpleValidation().getDataType();

    if (StringUtils.isNotEmpty(field.getSimpleValidation().getConstant())) {
      errors.addAll(handler.validateConstant(fileSequence, field));
    }
    if (dataType.equals(DataType.refTable)) {
      errors.addAll(handler.validateReference(fileSequence, field));
    }
    errors.addAll(handler.validateDataTypeAndRegex(fileSequence, field));

    /*
    List<ValidationResult> dataLengthErrors = handler.validateDataLength(fileSequence, field);
    errors.addAll(dataLengthErrors);
    */
    List<ValidationResult> dataLengthErrors = handler.validateDataLengthMin(fileSequence, field);
    dataLengthErrors.addAll(handler.validateDataLengthMax(fileSequence, field));
    errors.addAll(dataLengthErrors);

    if(dataType.equals(DataType.date)) {
      if(dataLengthErrors.isEmpty()) {
        errors.addAll(handler.validateDateMinMax(fileSequence, field));
        errors.addAll(handler.validateDateValidity(fileSequence, field));
      }
    }

    /*
     * Jika conditional error harus diisi, maka jangan tampilkan error validasi selanjutnya,
     * seperti validasi tipe data, regex, data length min max.
     */
    List<Integer> removedIndexes = new ArrayList<Integer>();
    for (int i = 0; i < conditionalErrors.size(); i++) {
      ValidationResult conditionalError = conditionalErrors.get(i);
      String ce = StringUtils.splitPreserveAllTokens(conditionalError.row, "|")[1];
      for (int j = 0; j < errors.size(); j++) {
        ValidationResult fieldError = errors.get(j);
        String fe = StringUtils.splitPreserveAllTokens(fieldError.row, "|")[1];
        if(fe.equals(ce)) {
          ValidationErrorCode errorCode = conditionalError.errors.stream().findFirst().get().errorCode;
          if(errorCode.code.equals(ValidationErrorCode.E13_01_MUSTEMPTY.code) && 
              errorCode.subCode.equals(ValidationErrorCode.E13_01_MUSTEMPTY.subCode)) {
            removedIndexes.add(j);
          }
        }
      }
    }

    for(int x = errors.size() - 1; x >= 0; x--) {
      if(removedIndexes.contains(x)) {
        errors.remove(x);
      }
    }

    return errors;
  }

  private List<ValidationResult> validateForms(int fileSequence, ProgressSegmentFile progressSegmentFile) {
    long fileSize = progressSegmentFile.getFileIntegrity().getFile().length();
    long progressPercentEach = fileSize / submissionFormat.getSegmentValidations().size();

    List<ValidationResult> errors = new ArrayList<ValidationResult>();
    for (SegmentValidation segment : submissionFormat.getSegmentValidations()) {
      log.info("{}", segment.getClass().getSimpleName());

      if (errors.size() >= errorLimit)
        return errors.stream().limit(errorLimit).collect(Collectors.toList());

      if (segment instanceof ComparisonFormulaValidation) {
        errors.addAll(handler.validateComparisonFormula(fileSequence, (ComparisonFormulaValidation) segment));
      } else if (segment instanceof IsExistsFormValidation || segment instanceof IsExistsFormValidationJdbc) {
        errors.addAll(handler.validateIsExistsFormValidation(fileSequence, segment));
      } else if (segment instanceof ComparisonFormValidation) {
        errors.addAll(handler.validateComparisonFormValidation(fileSequence, segment));
      }
      else {
        String err = String.format("Segment validation '%s' is not implemented.", segment.getClass().getSimpleName());
        log.error(err);
        throw new SlikException(err);
      }

//      updateProgressBar(progressPercentEach, progressSegmentFile, false);
//      progressPercentEach = +progressPercentEach;
    }

    return errors;
  }

  private void updateProgressBar(ProgressSegmentFile progressSegmentFile, boolean finish) {
//    progressSegmentFile.synchTotalError();
//    progressModel.recalcTotalErrorString();
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        progressSegmentFile.addProcessedSize(progressSegmentFile.getFileSize(), finish, false);
      }
    });
  }

  private void updateProgressBar(long size, ProgressSegmentFile progressSegmentFile, boolean finish) {
//    progressSegmentFile.synchTotalError();
//    progressModel.recalcTotalErrorString();
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        progressSegmentFile.addProcessedSize(size, finish, false);
      }
    });
  }

  private void logDebug(String message, Object... args) {
    if(log.isDebugEnabled())
      log.debug(message, args);
  }
}