package id.go.ojk.client.db.validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.db.ERe2Regex;
import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.db.util.ResultSetUtil;
import id.go.ojk.client.db.validation.field.IFieldValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.DateGreaterValidation;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.field.GreaterValueValidation;
import id.go.ojk.client.model.config.validation.field.IfComparatorEqualsValidation;
import id.go.ojk.client.model.config.validation.field.IfComparatorEqualsValidation2;
import id.go.ojk.client.model.config.validation.field.NotEqualsPosFixedValueValidation;
import id.go.ojk.client.model.config.validation.segmen.ComparisonFormValidation;
import id.go.ojk.client.model.config.validation.segmen.ComparisonFormulaValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.impl.ReferenceServiceClient;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.ConfigLocalDate;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationContentHandler {
  private final SubmissionFormat submissionFormat;
  private static JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
  private final long errorLimit = ConfigService.maxErrorCount.getDefauldValue() + 1;
  private static final String defaultCsvSeparator = "|";
  private ReferenceServiceClient referenceService = ApplicationContextClient.getInstance()
      .getService(ReferenceServiceClient.class);
  private final ConfigLocalDate minDateValue = ReferenceServiceClient.minAllDate;
  private final ConfigLocalDate maxDateValue = ReferenceServiceClient.maxAllDate;

  public ValidationContentHandler(SubmissionFormat submissionFormat) {
    this.submissionFormat = submissionFormat;
  }

  @SneakyThrows
  public List<ValidationResult> validateConstant(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String constantValue = field.getSimpleValidation().getConstant();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(columnName).append(" != '").append(constantValue).append("'")
        .append(" LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E11_06_EQUAL, field.getName(), constantValue), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateMandatoryField(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE (t.").append(columnName).append(" IS NULL or t.").append(columnName)
        .append(" = '') LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateMustEmptyField(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE t.").append(columnName).append(" IS NOT NULL").append(" LIMIT ")
        .append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateOptionalField(int fileSequence, SubmissionField field) {
    throw new SlikException("Optional field validation is not implemented");
  }

  @SneakyThrows
  public List<ValidationResult> validateReference(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(columnName).append(" NOT IN (");

    List<Integer> referenceTableNumbers = field.getSimpleValidation().getReferenceTableNumbers();
    log.error("'{}' has reference table numbers {}", field.getName(), referenceTableNumbers);

    List<String> descriptions = new ArrayList<String>();
    referenceTableNumbers.forEach(referenceNumber -> {
      List<String> references = referenceService.getReferenceDataList().get(referenceNumber);
      ReferenceMetadata metadata = referenceService.getReferenceMetadatas().get(referenceNumber);
      descriptions.add(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(metadata.getName()), ' '));
      if (references == null) {
        throw new SlikException("'" + field.getName() + "' is a reference but the value is not found");
      }
      sql.append(references.stream().collect(Collectors.joining("\','", "'", "'")));
    });
    sql.append(") LIMIT ").append(errorLimit);

    // Custom message untuk referensi kode komponen
    if(field.getNumber() == 1) {
      descriptions.clear();
      descriptions.add("Pos Form " + submissionFormat.getCode());
    }

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty()) {
      ValidationError validationError = new ValidationError(field, ValidationErrorCode.E12_01_REFERENCE,
          String.join(", ", descriptions));
      validationResults.addAll(createValidationResults(fileSequence, validationError, errors));
    }
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDataTypeAndRegex(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    ERe2Regex regex = ERe2Regex.getRegex(field.getSimpleValidation().getRegex());

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE regexp_full_match (t.").append(columnName).append(", '")
        .append(regex.getPattern()).append("') == FALSE").append(" LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence, new ValidationError(field,
          ValidationErrorCode.E11_00_FORMAT, field.getSimpleValidation().getRegex().getDesc()), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDateMinMax(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    int minValue = Integer.valueOf(minDateValue.getDefaultValueAsString());
    int maxValue = Integer.valueOf(maxDateValue.getDefaultValueAsString());

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE TRY_CAST(").append(columnName).append(" AS INTEGER) < ").append(minValue)
        .append(" OR TRY_CAST(").append(columnName).append(" AS INTEGER) > ").append(maxValue).append(" LIMIT ")
        .append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E12_21_ALL_DATE_MIN_MAX,
              minDateValue.getDefauldValue().format(DateUtil.dateTimeFormatterYYYYmmss),
              maxDateValue.getDefauldValue().format(DateUtil.dateTimeFormatterYYYYmmss)),
          errors));
    return validationResults;
  }

  /*
   * Validasi tanggal invalid, contohnya: 20243233 atau 20240231
   */
  @SneakyThrows
  public List<ValidationResult> validateDateValidity(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(columnName).append(" IS NOT NULL AND ")
        .append(" TRY_STRPTIME(").append(columnName).append(", '%Y%m%d') IS NULL")
        .append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence, new ValidationError(field, ValidationErrorCode.E12_03_DATE), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDataLengthMin(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    int minLength = field.getSimpleValidation().getMinLength();

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE (LENGTH (t.").append(columnName).append(") < ").append(minLength).append(") == TRUE LIMIT ")
        .append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E11_01_MIN_LENGTH, minLength), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDataLengthMax(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    int maxLength = field.getSimpleValidation().getMaxLength();

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE (LENGTH (t.").append(columnName).append(") > ").append(maxLength).append(") == TRUE LIMIT ")
        .append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E11_02_MAX_LENGTH, maxLength), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDataLength(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    int minLength = field.getSimpleValidation().getMinLength();
    int maxLength = field.getSimpleValidation().getMaxLength();

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t WHERE (LENGTH (t.").append(columnName).append(") BETWEEN ").append(minLength)
        .append(" AND ").append(maxLength).append(") == FALSE LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E12_19_VALUE_BETWEEN, minLength, maxLength), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateExistPosConditional(int fileSequence, ConditionalRequired conditional,
      SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<>();
    Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());

    String refPosCode = getMapValue(params, ValidatorParams.REF_POSCODE);
    String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);
    String trueCondition = params.getOrDefault(ValidatorParams.TRUE_CONDITION, "");

    if (trueCondition.equals(RequiredCondition.O.name())) {
    	return validationResults;
    }
    //TODO: REMOVE HARD-CODED VALUES
    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" p WHERE (p.").append(refPosCodeColumn).append(" = '").append(refPosCode).append("'")
        .append(" AND p.").append(columnName).append(" IS NULL) OR (").append("p.").append(refPosCodeColumn)
        .append(" != '").append(refPosCode).append("'").append(" AND p.").append(columnName)
        .append(" IS NOT NULL) AND p.").append(refPosCodeColumn).append(" IN ('0010010000', '0010020000', '0020010000', '0020020000') ")
        .append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(entry -> {
      ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
      ValidationError error;
      String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), "|");
      if(entryArr[1].equals(refPosCode)) {
        error = new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY);
      } else {
        error = new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY);
      }
      result.errors.add(error);
      validationResults.add(result);
    });
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateConditionalPosAndComparatorHasValue(int fileSequence,
      ConditionalRequired conditional, SubmissionField field) {
    Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());
    String falseCondition = params.getOrDefault(ValidatorParams.FALSE_CONDITION, "");
    if (falseCondition.equals(RequiredCondition.O.toString())) {
      return validateConditionalPosAndComparatorHasValueA(fileSequence, conditional, field);
    } else {
      return validateConditionalPosAndComparatorHasValueB(fileSequence, conditional, field);
    }
  }

  @SneakyThrows
  private List<ValidationResult> validateConditionalPosAndComparatorHasValueA(int fileSequence,
      ConditionalRequired conditional, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());

    String refPosCode = getMapValue(params, ValidatorParams.REF_POSCODE);
    String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String comparatorField = getMapValue(params, ValidatorParams.COMPARATOR_FIELD);
    String comparatorValue = getMapValue(params, ValidatorParams.COMPARATOR_VALUE);

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    String comparatorColumn = db.getColumnName(submissionFormat.getCode(), Integer.valueOf(comparatorField));
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" p WHERE p.").append(refPosCodeColumn).append(" = '").append(refPosCode)
        .append("' AND (p.").append(comparatorColumn).append(" = '").append(comparatorValue).append("' AND p.")
        .append(columnName).append(" IS NULL)").append("AND (p.").append(refPosCodeColumn)
        .append(" IN ('").append(refPosCode).append("'))")
        .append(" LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty()) {
      int comparatorFieldInt = Integer.valueOf(comparatorField);
      validationResults.addAll(createValidationResults(fileSequence, new ValidationError(field,
          ValidationErrorCode.E20_01_MANDATORY, "kolom '" + (comparatorFieldInt + 1) + "' berisi '" + comparatorValue + "'"), errors));
    }

    List<ValidationResult> results = validateExistPosConditional(fileSequence, conditional, field);
    for (int i = 0; i < results.size(); i++) {
      ValidationResult result = results.get(i);
      String[] entryArr = StringUtils.splitPreserveAllTokens(result.row, defaultCsvSeparator);
      String posCode = entryArr[1];
      if(!posCode.equals(refPosCode)) {
        validationResults.add(result);
      }
    }

    return validationResults;
  }
  
  @SneakyThrows
  private List<ValidationResult> validateConditionalPosAndComparatorHasValueB(int fileSequence, ConditionalRequired conditional, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<>();
    Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());

    String refPosCode = getMapValue(params, ValidatorParams.REF_POSCODE);
    String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String comparatorField = getMapValue(params, ValidatorParams.COMPARATOR_FIELD);
    String comparatorValue = getMapValue(params, ValidatorParams.COMPARATOR_VALUE);

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    String comparatorColumn = db.getColumnName(submissionFormat.getCode(), Integer.valueOf(comparatorField));
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(refPosCodeColumn).append(" = '").append(refPosCode)
        .append("' AND ((").append(comparatorColumn).append(" == '").append(comparatorValue).append("' AND ").append(columnName).append(" IS NULL )")
        .append(" OR (").append(comparatorColumn).append(" != '").append(comparatorValue).append("' AND ").append(columnName).append(" IS NOT NULL ))")
        .append(" AND ").append(refPosCodeColumn).append(" IN ('").append(refPosCode).append("')")
        .append(" LIMIT ").append(errorLimit);

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(entry -> {
      int comparatorFieldInt = Integer.parseInt(comparatorField);
      ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
      ValidationError error;
      String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), defaultCsvSeparator);
      if(StringUtils.isEmpty(entryArr[field.getNumber()])) {
        error = new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, "kolom '" + (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
      } else {
        error = new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, "karena kolom '" + (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
      }
      result.errors.add(error);
      validationResults.add(result);
    });

    List<ValidationResult> results = validateExistPosConditional(fileSequence, conditional, field);
    for (int i = 0; i < results.size(); i++) {
      ValidationResult result = results.get(i);
      String[] entryArr = StringUtils.splitPreserveAllTokens(result.row, defaultCsvSeparator);
      String posCode = entryArr[1];
      if(!posCode.equals(refPosCode)) {
        String formCode = submissionFormat.getCode();
        // Hard-coded to exclude nilai klaim di form 0200
        // TODO: harus buat validasi baru untuk conditional nilai klaim di total
        // tidak bisa menggunakan metadata yang ada.
        // 8 = Nilai Klaim / Nilai Klaim Disetujui - Dana Tabarru'
        // 9 = Nilai Klaim Disetujui - Dana Tanahud
        // 10 = Nilai Klaim Disetujui - DIP'
        if(formCode.equals("0200") && (field.getNumber() == 8 || field.getNumber() == 9 || field.getNumber() == 10)) {
          String value = entryArr[field.getNumber()];
          if(value.isEmpty()) {
            ValidationError error = new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY);
            result.errors.clear();
            result.errors.add(error);
            validationResults.add(result);
          }
          continue;
        }
        validationResults.add(result);
      }
    }

    return validationResults;
  }

  public List<ValidationResult> validateCustomFields(int fileSequence, SubmissionField field) {
    List<ValidationResult> validationResults = new ArrayList<>();
    field.getFieldValidations().forEach(validation -> {
      String className = validation.getClass().getSimpleName();
      if (className.equals(DateGreaterValidation.class.getSimpleName())) {
        validationResults.addAll(validateDateComparison(fileSequence, field, ">", validation));
      } else if (className.equals(GreaterValueValidation.class.getSimpleName())) {
        validationResults.addAll(validateDecimalComparison(fileSequence, field, "<", validation));
      } else if (className.equals(IfComparatorEqualsValidation.class.getSimpleName())) {
        validationResults.addAll(validateIfComparatorEquals(fileSequence, field, validation, "!="));
      } else if (className.equals(IfComparatorEqualsValidation2.class.getSimpleName())) {
        validationResults.addAll(validateIfComparatorEquals(fileSequence, field, validation, "<="));
      } else if (className.equals(NotEqualsPosFixedValueValidation.class.getSimpleName())) {
        validationResults.addAll(validateNotEqualsPosFixedValueValidation(fileSequence, field, validation));
      } else {
        if(validation instanceof IFieldValidation) {
          validationResults.addAll(((IFieldValidation) validation).validate(fileSequence, submissionFormat, field));
        } else {
          String err = String.format("Field validation '%s' is not implemented.", className);
          log.error(err);
          throw new SlikException(err);
        }
      }
    });
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDateComparison(int fileSequence, SubmissionField field, String operator,
      FieldValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());

    String fieldComparator = getMapValue(params, ValidatorParams.FIELD_COMPARATOR);
    String fieldComparatorColumn = db.getColumnName(submissionFormat.getCode(), Integer.valueOf(fieldComparator));

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE (").append(fieldComparatorColumn).append(" != NULL OR ")
        .append(fieldComparatorColumn).append(" != '') AND ").append(" try_strptime(").append(fieldComparatorColumn)
        .append(",'%Y%m%d') ").append(operator).append(" try_strptime(").append(columnName).append(",'%Y%m%d') LIMIT ")
        .append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E12_20_DATE_GREATER, field.getNumber() + 1, Integer.valueOf(fieldComparator)+1),
          errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateDecimalComparison(int fileSequence, SubmissionField field, String operator,
      FieldValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());

    BigDecimal valueComparator = new BigDecimal(getMapValue(params, ValidatorParams.VALUE_COMPARATOR));
    String value = valueComparator.toString();
    if (operator.equals("<")) {
      valueComparator = valueComparator.add(BigDecimal.ONE);
    }

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE TRY_CAST(").append(columnName).append(" as BIGINT) ").append(operator)
        .append(valueComparator).append(" OR TRY_CAST(").append(columnName).append(" as BIGINT) IS NULL")
        .append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    if (!errors.isEmpty())
      validationResults.addAll(createValidationResults(fileSequence,
          new ValidationError(field, ValidationErrorCode.E11_13_GREATER, value), errors));
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateIfComparatorEquals(int fileSequence, SubmissionField field,
      FieldValidation validation, String operator) {
    List<ValidationResult> validationResults = new ArrayList<>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());

    int fieldComparator = Integer.parseInt(getMapValue(params, ValidatorParams.FIELD_COMPARATOR));
    String comparatorValue = getMapValue(params, ValidatorParams.COMPARATOR_VALUE);
    String trueValue = getMapValue(params, ValidatorParams.TRUE_VALUE);

    String fieldComparatorColumn = db.getColumnName(submissionFormat.getCode(), fieldComparator);

    String tableName = db.getTableName(submissionFormat);
    String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(fieldComparatorColumn).append(" in ('")
        .append(StringUtils.replace(comparatorValue, "|", "','")).append("') AND TRY_CAST(").append(columnName).append(" AS BIGINT) ")
        .append(operator).append(trueValue).append(" LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(entry -> {
      ValidationResult validationResult = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
      ValidationErrorCode errorCode = (validation instanceof IfComparatorEqualsValidation)
          ? ValidationErrorCode.E50_15_COLUMNCONDITION
          : ValidationErrorCode.E50_19_COLUMNCONDITION;
      ValidationError validationError = new ValidationError(field, errorCode, trueValue.replace("|", " atau "),
          fieldComparator + 1, StringUtils.splitPreserveAllTokens(entry.getValue(), "|")[fieldComparator]);
      validationResult.errors.add(validationError);
      validationResults.add(validationResult);
    });
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateComparisonFormula(int fileSequence, ComparisonFormulaValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());
    String selectField = getMapValue(params, ValidatorParams.SELECT_FIELD);
    String selectPosCode = getMapValue(params, ValidatorParams.SELECT_POSCODE);
    String comparatorPosCode = getMapValue(params, ValidatorParams.COMPARATOR_POSCODE);

    String tableName = db.getTableName(submissionFormat);
    String posCodeColumn = db.getColumnName(submissionFormat, 1);

    StringBuilder sql = new StringBuilder("SELECT 0 as row_id,").append(posCodeColumn).append(",");
    List<String> queryColumns = new ArrayList<>();
    Arrays.stream(StringUtils.split(selectField, "|")).forEach(idx -> {
      queryColumns.add(" SUM(TRY_CAST(column" + idx + " AS BIGINT))");
    });
    sql.append(String.join("+", queryColumns));

    sql.append(" AS total ").append(" FROM ").append(tableName).append(" WHERE ").append(posCodeColumn).append(" = '")
        .append(comparatorPosCode).append("'").append(" GROUP BY ").append(posCodeColumn).append(" UNION ");

    // -- UNION --
    sql.append("SELECT 1 as row_id,").append(posCodeColumn).append(",");
    queryColumns.clear();
    Arrays.stream(StringUtils.split(selectField, "|")).forEach(idx -> {
      queryColumns.add(" SUM(TRY_CAST(column" + idx + " AS BIGINT))");
    });
    sql.append(String.join("+", queryColumns));

    sql.append(" AS total ").append(" FROM ").append(tableName).append(" WHERE ").append(posCodeColumn).append(" = '")
        .append(selectPosCode).append("'").append(" GROUP BY ").append(posCodeColumn);

    Map<Integer, String> result = ResultSetUtil.sqlToCsv(db, sql.toString());
    String total1AsString = StringUtils.splitPreserveAllTokens(result.getOrDefault(0, "0|0"), defaultCsvSeparator)[1];
    String total2AsString = StringUtils.splitPreserveAllTokens(result.getOrDefault(1, "0|0"), defaultCsvSeparator)[1];
    BigDecimal total1 = new BigDecimal(StringUtils.isEmpty(total1AsString) ? "0" : total1AsString);
    BigDecimal total2 = new BigDecimal(StringUtils.isEmpty(total2AsString) ? "0" : total2AsString);

    log.info("{} = {} ? {}", total1.toString(), total2.toString(), total1.equals(total2));

    if (!total1.equals(total2)) {
      String msgError = getMapValue(params, ValidatorParams.MSG_ERROR);
      String operator = getMapValue(params, ValidatorParams.OPERATOR);

      List<String> allColumns = db.getAllColumnName(submissionFormat);
      Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db,
          new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ").append(tableName)
              .append(" WHERE ").append(posCodeColumn).append(" = '").append(selectPosCode).append("'")
              .append(" ORDER BY row_id ASC LIMIT 1").toString());

      ValidationError validationError = new ValidationError(null, ValidationErrorCode.E50_02_FORMULA, "1234",
          StringUtils.replace(msgError, "|", " " + operator.replace("e", "=") + " "));
      validationResults.addAll(createValidationResults(fileSequence, validationError, errors));
    }
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateIsExistsFormValidation(int fileSequence, SegmentValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());

    String tableName = db.getTableName(submissionFormat);
    String rowCode = getMapValue(params, ValidatorParams.ROW_CODE);
    String comparatorTable = db.getTableName(submissionFormat, getMapValue(params, ValidatorParams.COMPARATOR_FORM));
    String comparatorCode = getMapValue(params, ValidatorParams.COMPARATOR_CODE);
    String column = db.getColumnName(submissionFormat, Integer.valueOf(getMapValue(params, ValidatorParams.COLUMN)));
    String comparatorColumn = db.getColumnName(getMapValue(params, ValidatorParams.COMPARATOR_FORM),
        Integer.valueOf(getMapValue(params, ValidatorParams.COMPARATOR_COLUMN)));
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT t2.row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" t2").append(" WHERE (t2.column1 = '").append(rowCode)
        .append("' AND t2.").append(column).append(" IS NOT NULL AND t2.")
        .append(column).append(" NOT IN (").append(" SELECT t1.").append(comparatorColumn).append(" FROM ")
        .append(comparatorTable).append(" t1 WHERE t1.column1 = '").append(comparatorCode).append("'))")
        .append("LIMIT ").append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(e -> {
      SubmissionField submissionField = submissionFormat.getFields()
          .get(Integer.valueOf(getMapValue(params, ValidatorParams.COLUMN)));
      ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
      String[] values = StringUtils.splitPreserveAllTokens(validationResult.row, defaultCsvSeparator);
      String value = values[Integer.parseInt(getMapValue(params, ValidatorParams.COLUMN))];
      int comparatorColumnInt = Integer.valueOf(getMapValue(params, ValidatorParams.COMPARATOR_COLUMN)) + 1;
      validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_06_VALUE_NOT_FOUND,
          value, getMapValue(params, ValidatorParams.COMPARATOR_FORM), comparatorColumnInt));
      validationResults.add(validationResult);
    });
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateNotEqualsPosFixedValueValidation(int fileSequence, SubmissionField field,
      FieldValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());
    String posCodeValue = getMapValue(params, ValidatorParams.POS_CODE);
    String posCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String value = getMapValue(params, ValidatorParams.VALUE);
    String valueColumn = db.getColumnName(submissionFormat, field.getNumber());
    String tableName = db.getTableName(submissionFormat);
    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(posCodeColumn).append(" = '").append(posCodeValue).append("'")
        .append(" AND ").append(valueColumn).append(" = '").append(value).append("'").append(" LIMIT ")
        .append(errorLimit).append(";");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(e -> {
      ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
      validationResult.errors.add(
          new ValidationError(field, ValidationErrorCode.E11_08_NOT_EQUAL, StringUtils.replace(value, "|", " atau ")));
      validationResults.add(validationResult);
    });
    return validationResults;
  }

  @SneakyThrows
  public List<ValidationResult> validateComparisonFormValidation(int fileSequence, SegmentValidation validation) {
    List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    Map<String, String> params = CollectionUtil.toMap(validation.getParameter());

    String tableName = db.getTableName(submissionFormat);
    int selectField = Integer.valueOf(getMapValue(params, ValidatorParams.SELECT_FIELD));
    String selectPosCode = getMapValue(params, ValidatorParams.SELECT_POSCODE);
    String selectColumn = db.getColumnName(submissionFormat, selectField);
    String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
    String comparatorForm = getMapValue(params, ValidatorParams.COMPARATOR_FORM);
    String comparatorTable = db.getTableName(submissionFormat, comparatorForm);
    String comparatorCode = getMapValue(params, ValidatorParams.COMPARATOR_POSCODE);
    String comparatorColumn = db.getColumnName(comparatorForm,
        Integer.valueOf(getMapValue(params, ValidatorParams.COMPARATOR_FIELD)));
    String operator = reverseOperator(getMapValue(params, ValidatorParams.OPERATOR));

    List<String> allColumns = db.getAllColumnName(submissionFormat);

    StringBuilder sql = new StringBuilder("SELECT row_id,").append(String.join(",", allColumns)).append(" FROM ")
        .append(tableName).append(" WHERE ").append(refPosCodeColumn).append(" = '").append(selectPosCode).append("'")
        .append(" AND TRY_CAST (").append(selectColumn).append(" AS BIGINT) ").append(Comparation.valueOf(operator).getCode())
        .append(" TRY_CAST(( SELECT ").append(comparatorColumn).append(" FROM ").append(comparatorTable)
        .append(" WHERE ").append(refPosCodeColumn).append(" = ").append("'").append(comparatorCode)
        .append("') AS BIGINT);");

    Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
    errors.entrySet().forEach(e -> {
      SubmissionField submissionField = submissionFormat.getFields().get(selectField);
      ComparisonFormValidation comparisonFormValidation = (ComparisonFormValidation) validation;
      ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
      String[] values = StringUtils.splitPreserveAllTokens(validationResult.row, defaultCsvSeparator);
      String value = values[selectField];
      validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA, value, comparisonFormValidation.genMessage()));
      validationResults.add(validationResult);
    });
    return validationResults;
  }

  private String getMapValue(Map<String, String> params, String key) {
    if (!params.containsKey(key)) {
      throw new SlikException("Validation parameter not found '" + key + "'");
    }
    return params.get(key);
  }

  private List<ValidationResult> createValidationResults(int fileSequence, ValidationError validationError,
      Map<Integer, String> errorMap) {
    List<ValidationResult> errors = new ArrayList<ValidationResult>();
    errorMap.entrySet().forEach(entry -> {
      ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
      result.errors.add(validationError);
      errors.add(result);
    });
    return errors;
  }

  @SuppressWarnings("unused")
  private void logDebug(String message, Object... args) {
    if(log.isDebugEnabled())
      log.debug(message, args);
  }

  //TODO: Sesuaikan query dengan operator
  private String reverseOperator(String operator) {
    switch (operator) {
      case "lt":
        return "gt";
      case "lte":
        return "gte";
      case "gt":
        return "lt";
      case "gte":
        return "lte";
      default:
        return operator;
    }
  }
}
