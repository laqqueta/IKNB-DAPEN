package id.go.ojk.client.db.validation.field;

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
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.SneakyThrows;

@XStreamAlias("EqualsNoRepeatValidation")
public class EqualsNoRepeatValidation extends EqualsValidation implements IFieldValidation {
  private String selectPosCode;
  
  public EqualsNoRepeatValidation(String params) {
    super(params);
    selectPosCode = getStringParameter("selectPosCode");
  }

  @Override
  @SneakyThrows
  public List<ValidationResult> validate(int fileSequence, SubmissionFormat submissionFormat, SubmissionField submissionField) {
    JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
    long errorLimit = ConfigService.maxErrorCount.getDefauldValue() + 1;

    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String selectPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String selectFieldColumn = db.getColumnName(submissionFormat.getCode(), submissionField.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(selectPosCodeColumn).append(" IN ('")
        .append(selectPosCode).append("') AND ").append("LENGTH (").append(selectFieldColumn).append(") > 1 AND REPLACE(")
        .append(selectFieldColumn).append(", LEFT(").append(selectFieldColumn).append(",1),'') = ''")
        .append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if(!errors.isEmpty()) {
      ValidationError validationError = new ValidationError(submissionField, 
          ValidationErrorCode.E50_16_COLUMNCONDITION2, "tidak boleh huruf atau angka yang sama berturut-turut");
      errors.entrySet().forEach(e -> {
        ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
        validationResult.errors.add(validationError);
        validationResults.add(validationResult);
      });
    }
    return validationResults;
  }
}
