package id.go.ojk.client.model.config.validation.segmen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.db.util.Formatter;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;

@XStreamAlias("IsExistsFormValidationDb")
@Slf4j
public class IsExistsFormValidationJdbc extends MapParamSegmentValidation {
  protected String rowCode;
  protected String column;
  private String comparatorForm;
  private String comparatorCode;
  private int comparatorColumn;
  private final List<Integer> notExistIds = new ArrayList<>();

  public IsExistsFormValidationJdbc() {
    super();
  }

  public IsExistsFormValidationJdbc(String parameter) {
    super(parameter);
  }

  @Override
  public IsExistsFormValidationJdbc initialized() {
    rowCode = getStringParameter("rowCode");
    column = getStringParameter("column");
    comparatorForm = getStringParameter("comparatorForm");
    comparatorCode = getStringParameter("comparatorCode");
    comparatorColumn = getIntParameter("comparatorColumn");
    return this;
  }

  @Override
  public void load(SubmissionFormat submissionFormat) {

  }

  @Override
  public void cleanUp() {
    notExistIds.clear();
  }

  @Override
  public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
      ValidationResult validationResult) {
    List<String> rowCodes = Arrays.asList(StringUtils.split(rowCode, "|"));
    if (!rowCodes.contains(validationResult.getColumn(1))) {
      return;
    }

    if (notExistIds.indexOf(validationResult.lineNumber) != -1) {
      SubmissionField submissionField = submissionFormat.getFields().get(Integer.valueOf(column));
      String value = validationResult.getColumn(Integer.parseInt(column));
      validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_06_VALUE_NOT_FOUND,
          value, comparatorForm, comparatorColumn));
    }
  }

  private void validateOnce(SubmissionFormat submissionFormat) {
    JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
    String table = db.getTableName(submissionFormat);
    String comparatorTable = db.getTableName(submissionFormat, comparatorForm);
    String columnName = db.getColumnName(submissionFormat, Integer.valueOf(this.column));
    String comparatorColumnName = db.getColumnName(comparatorForm, Integer.valueOf(this.comparatorColumn));
    long limit = ConfigService.maxErrorCount.getDefauldValue() + 1;

    StringBuilder sql = new StringBuilder("SELECT t2.row_id FROM ").append(table).append(" t2")
        .append(" WHERE (t2.column1 = '").append(rowCode).append("' AND t2.").append(columnName)
        .append(" IS NOT NULL AND t2.").append(columnName).append(" NOT IN (")
        .append(" SELECT t1.").append(comparatorColumnName).append(" FROM ").append(comparatorTable)
        .append(" t1 WHERE t1.column1 = '").append(comparatorCode).append("'))").append(" OR (t2.column1 = '")
        .append(rowCode).append("' AND t2.").append(columnName).append(" IS NULL)").append(" ORDER BY t2.row_id LIMIT ")
        .append(limit).append(";");
    log.info(sql.toString());
    StopWatch sw = new StopWatch();
    sw.start();
    try (Connection conn = db.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString())) {
      while (rs.next()) {
        notExistIds.add(rs.getInt(1));
      }
      sw.stop();
      log.info("Validation completed in {}", Formatter.formatMillis(sw.getTime()));
    } catch (SQLException e) {
      log.error(e.getMessage(), e);
      throw new SlikException(JdbcService.SQL_EXCEPTION_MESSAGE);
    }
  }
}