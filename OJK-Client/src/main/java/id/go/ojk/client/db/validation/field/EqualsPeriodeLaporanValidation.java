package id.go.ojk.client.db.validation.field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.db.util.ResultSetUtil;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.field.EqualsValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.SneakyThrows;

@XStreamAlias("EqualsPeriodeLaporanValidation")
public class EqualsPeriodeLaporanValidation extends EqualsValidation implements IFieldValidation {
  private String selectPosCode;
  private Comparation comparation;
  
  public EqualsPeriodeLaporanValidation(String params) {
    super(params);
    selectPosCode = getStringParameter("selectPosCode");
    comparation = Comparation.valueOf(getStringParameter("operator", "lte"));
  }

  @Override
  @SneakyThrows
  public List<ValidationResult> validate(int fileSequence, SubmissionFormat submissionFormat, SubmissionField submissionField) {
    JdbcService db = appCtx.getService(JdbcService.class);
    LocalDate reportDate = SubmissionFormat.reportPeriod;

    long errorLimit = ConfigService.maxErrorCount.getDefauldValue() + 1;

    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String selectPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String selectFieldColumn = db.getColumnName(submissionFormat.getCode(), submissionField.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);
    String operator = reverseOperator(comparation);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append("try_strptime(").append(selectFieldColumn).append(",'%Y%m%d') IS NOT NULL")
        .append(" AND try_strptime(").append(selectFieldColumn).append(",'%Y%m%d') ").append(operator)
        .append(" try_strptime('").append(reportDate.toString()).append("','%Y-%m-%d')")
        .append(" AND ").append(selectPosCodeColumn).append(" = '").append(selectPosCode).append("'")
        .append(" LIMIT ").append(errorLimit).append(";");
    ;

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if(!errors.isEmpty()) {
      ValidationError validationError = new ValidationError(submissionField, 
          ValidationErrorCode.E50_16_COLUMNCONDITION2, "harus " + comparation.getDesc() + " periode pelaporan");
      errors.entrySet().forEach(e -> {
        ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
        validationResult.errors.add(validationError);
        validationResults.add(validationResult);
      });
    }

    return validationResults;
  }

  private static String reverseOperator(Comparation comparation) {
    switch (comparation) {
      case lt:
        return ">=";
      case lte:
        return ">";
      default:
        return comparation.getCode();
    }
  }
}
