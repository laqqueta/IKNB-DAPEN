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

public class DbConditionalPosAndComparatorNotEmpty extends BaseDbConditional {

	public DbConditionalPosAndComparatorNotEmpty(JdbcService db, SubmissionFormat submissionFormat) {
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
		String comparatorField = getMapValue(params, ValidatorParams.COMPARATOR_FIELD_NUMBER);
		RequiredCondition trueCondition = getRequiredConditionParameter(params, ValidatorParams.TRUE_CONDITION);
		RequiredCondition falseCondition = getRequiredConditionParameter(params, ValidatorParams.FALSE_CONDITION);

		String tableName = db.getTableName(submissionFormat);
		String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
		String comparatorColumn = db.getColumnName(submissionFormat.getCode(), Integer.valueOf(comparatorField));
		List<String> allColumns = db.getAllColumnName(submissionFormat);

		if (!trueCondition.equals(RequiredCondition.O)) {
			StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
					.append(" WHERE ").append(getInFilter(false, refPosCodeColumn, refPosCode))
					.append(getIsNotNullFilter(true, comparatorColumn));
			if (trueCondition == RequiredCondition.M) {
				sql.append(getIsNullFilter(true, columnName));
			} else if (trueCondition == RequiredCondition.N) {
				sql.append(getIsNotNullFilter(true, columnName));
			}
			sql.append(getLimit());
 			Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
			if (!errors.isEmpty()) {
				errors.entrySet().forEach(entry -> {
					int comparatorFieldInt = Integer.parseInt(comparatorField);
					ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
					ValidationError error = null;
					String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), CSV_SEPARATOR);
					if (StringUtils.isEmpty(entryArr[field.getNumber()]) && trueCondition == RequiredCondition.M) {
						error = new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, "kolom '"
								+ (comparatorFieldInt + 1) + "' terisi ");
					} else if (!StringUtils.isEmpty(entryArr[field.getNumber()])
							&& trueCondition == RequiredCondition.N) {
						error = new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, "karena kolom '"
								+ (comparatorFieldInt + 1) + "' kosong ");
					}
					if (error != null) {
						result.errors.add(error);
					}
					validationResults.add(result);
				});
			}
		}

		if (!falseCondition.equals(RequiredCondition.O)) {
			StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
					.append(" WHERE ").append(getInFilter(false, refPosCodeColumn, refPosCode))
					.append(getIsNullFilter(true, comparatorColumn));
			if (falseCondition == RequiredCondition.M) {
				sql.append(getIsNullFilter(true, columnName));
			} else if (falseCondition == RequiredCondition.N) {
				sql.append(getIsNotNullFilter(true, columnName));
			}
			sql.append(getLimit());

			Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
			if (!errors.isEmpty()) {
				errors.entrySet().forEach(entry -> {
					int comparatorFieldInt = Integer.parseInt(comparatorField);
					ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
					ValidationError error = null;
					String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), CSV_SEPARATOR);
					if (StringUtils.isEmpty(entryArr[field.getNumber()]) && falseCondition == RequiredCondition.M) {
						error = new ValidationError(field, ValidationErrorCode.E20_01_MANDATORY, "kolom '"
								+ (comparatorFieldInt + 1) + "' terisi ");
					} else if (!StringUtils.isEmpty(entryArr[field.getNumber()])
							&& falseCondition == RequiredCondition.N) {
						error = new ValidationError(field, ValidationErrorCode.E20_02_MUSTEMPTY, "karena kolom '"
								+ (comparatorFieldInt + 1) + "' kosong ");
					}
					if (error != null) {
						result.errors.add(error);
					}
					validationResults.add(result);
				});
			}
		}

		List<ValidationResult> results = validateExistPosConditional(fileSequence, conditional, field, ValidatorParams.POS_FALSE_CONDITION);
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
}
