package id.go.ojk.client.db.validation.conditional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.db.JdbcService;
import id.go.ojk.client.db.util.ResultSetUtil;
import id.go.ojk.client.db.validation.ValidatorParams;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.SneakyThrows;

public class DbConditionalPosAndComparatorHasValue extends BaseDbConditional {

	public DbConditionalPosAndComparatorHasValue(JdbcService db, SubmissionFormat submissionFormat) {
		super(db, submissionFormat);
	}

	@Override
	public List<ValidationResult> validate(int fileSequence, ConditionalRequired conditional, SubmissionField field) {
		return doValidate(fileSequence, conditional, field);
	}

	@SneakyThrows
	private List<ValidationResult> doValidate(int fileSequence, ConditionalRequired conditional,
			SubmissionField field) {
		List<ValidationResult> validationResults = new ArrayList<>();
		Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());

		String refPosCode = getMapValue(params, ValidatorParams.REF_POSCODE);
		String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
		String comparatorField = getMapValue(params, ValidatorParams.COMPARATOR_FIELD);
		String comparatorValue = getMapValue(params, ValidatorParams.COMPARATOR_VALUE);
		String comparatorValue2 = getMapValue(params, ValidatorParams.COMPARATOR_VALUE2);
		RequiredCondition trueCondition = getRequiredConditionParameter(params, ValidatorParams.TRUE_CONDITION);
		RequiredCondition trueCondition2 = getRequiredConditionParameter(params, ValidatorParams.TRUE_CONDITION2);
		RequiredCondition falseCondition = getRequiredConditionParameter(params, ValidatorParams.FALSE_CONDITION);

		String tableName = db.getTableName(submissionFormat);
		String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
		String comparatorColumn = db.getColumnName(submissionFormat.getCode(), Integer.valueOf(comparatorField));
		List<String> allColumns = db.getAllColumnName(submissionFormat);

		if (!trueCondition.equals(RequiredCondition.O)) {
			StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
					.append(" WHERE ").append(getInFilter(false, refPosCodeColumn, refPosCode))
					.append(getInFilter(true, comparatorColumn, comparatorValue));
			if (trueCondition == RequiredCondition.M) {
				sql.append(getIsNullFilter(true, columnName));
			} else if (trueCondition == RequiredCondition.N) {
				sql.append(getIsNotNullFilter(true, columnName));
			}
			sql.append(getLimit());
			getValidationResult(fileSequence, field, comparatorField, sql.toString(), validationResults);
		}

		if (trueCondition2 != null && !trueCondition2.equals(RequiredCondition.O)) {
			StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
					.append(" WHERE ").append(getInFilter(false, refPosCodeColumn, refPosCode))
					.append(getInFilter(true, comparatorColumn, comparatorValue2));
			if (trueCondition2 == RequiredCondition.M) {
				sql.append(getIsNullFilter(true, columnName));
			} else if (trueCondition2 == RequiredCondition.N) {
				sql.append(getIsNotNullFilter(true, columnName));
			}
			sql.append(getLimit());
			getValidationResult(fileSequence, field, comparatorField, sql.toString(), validationResults);
		}

		if (!falseCondition.equals(RequiredCondition.O)) {
			StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
					.append(" WHERE ").append(getInFilter(false, refPosCodeColumn, refPosCode))
					.append(getNotInFilter(true, comparatorColumn, comparatorValue));
			if (falseCondition == RequiredCondition.M) {
				sql.append(getIsNullFilter(true, columnName));
			} else if (falseCondition == RequiredCondition.N) {
				sql.append(getIsNotNullFilter(true, columnName));
			}
			sql.append(getLimit());
			getValidationResult(fileSequence, field, comparatorField, sql.toString(), validationResults);

//			Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
//			if (!errors.isEmpty()) {
//				errors.entrySet().forEach(entry -> {
//					int comparatorFieldInt = Integer.parseInt(comparatorField);
//					ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
//					ValidationError error;
//					String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), CSV_SEPARATOR);
//					if (StringUtils.isEmpty(entryArr[field.getNumber()])) {
//						error = new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, "kolom '"
//								+ (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
//					} else {
//						error = new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, "karena kolom '"
//								+ (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
//					}
//					result.errors.add(error);
//					validationResults.add(result);
//				});
//			}
		}

		List<ValidationResult> results = validateExistPosConditional(fileSequence, conditional, field,
				ValidatorParams.POS_FALSE_CONDITION);
		for (int i = 0; i < results.size(); i++) {
			ValidationResult result = results.get(i);
			String[] entryArr = StringUtils.splitPreserveAllTokens(result.row, CSV_SEPARATOR);
			String posCode = entryArr[1];
			if (!posCode.equals(refPosCode)) {
				validationResults.add(result);
			}
		}

		return validationResults;
	}
	
	@SneakyThrows
	private void getValidationResult(int fileSequence, SubmissionField field, String comparatorField, String sql, List<ValidationResult> validationResults) {
		Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql);
		if (!errors.isEmpty()) {
			errors.entrySet().forEach(entry -> {
				int comparatorFieldInt = Integer.parseInt(comparatorField);
				ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
				ValidationError error;
				String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), CSV_SEPARATOR);
				if (StringUtils.isEmpty(entryArr[field.getNumber()])) {
					error = new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, "kolom '"
							+ (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
				} else {
					error = new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, "karena kolom '"
							+ (comparatorFieldInt + 1) + "' berisi '" + entryArr[comparatorFieldInt] + "'");
				}
				result.errors.add(error);
				validationResults.add(result);
			});
		}
		
	}
}
