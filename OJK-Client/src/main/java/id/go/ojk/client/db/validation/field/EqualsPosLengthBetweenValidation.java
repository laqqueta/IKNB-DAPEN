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

@XStreamAlias("EqualsPosLengthBetweenValidation")
public class EqualsPosLengthBetweenValidation extends EqualsValidation implements IFieldValidation {
  private String selectPosCode;
  private String comparatorValue;
  private int minLength;
  private int maxLength;

  public EqualsPosLengthBetweenValidation(String params) {
    super(params);
    selectPosCode = getStringParameter("selectPosCode");
    comparatorValue = getStringParameter("comparatorValue");
    minLength = getIntParameter("minLength");
    maxLength = getIntParameter("maxLength");
  }

  @Override
  @SneakyThrows
  public List<ValidationResult> validate(int fileSequence, SubmissionFormat submissionFormat, SubmissionField submissionField) {
    JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
    long errorLimit = ConfigService.maxErrorCount.getDefauldValue() + 1;
    int fieldComparatorInt = Integer.parseInt(fieldComparator);

    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String selectPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String selectFieldColumn = db.getColumnName(submissionFormat.getCode(), submissionField.getNumber());
    String comparatorColumn = db.getColumnName(submissionFormat.getCode(), fieldComparatorInt);
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(selectPosCodeColumn).append(" = '").append(selectPosCode)
        .append("' AND ").append(comparatorColumn).append(" = '").append(comparatorValue).append("'")
        .append(" AND ").append("(LENGTH(").append(selectFieldColumn).append(") < ").append(minLength)
        .append(" OR ").append("LENGTH(").append(selectFieldColumn).append(") > ").append(maxLength).append(")")
        .append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if(!errors.isEmpty()) {
      ValidationError validationError = new ValidationError(submissionField, 
          ValidationErrorCode.E99_00_OTHER, genErrorMessage(fieldComparatorInt, comparatorValue));
      errors.entrySet().forEach(e -> {
        ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
        validationResult.errors.add(validationError);
        validationResults.add(validationResult);
      });
    }

    return validationResults;
  }
  
  private String genErrorMessage(int fieldComparatorInt, String comparatorValue) {
    StringBuilder sb = new StringBuilder()
        .append("Panjang karakter harus antara ")
        .append(minLength).append("-").append(maxLength)
        .append(" karena kolom ").append( (fieldComparatorInt + 1))
        .append(" bernilai ").append(comparatorValue);
    return sb.toString();
  }
}
