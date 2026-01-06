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
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.lib.client.CollectionUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseDbConditional implements IDbConditional {
	protected static final long ERROR_LIMIT = ConfigService.maxErrorCount.getDefauldValue() + 1;
	protected static final String CSV_SEPARATOR = "|";
	protected JdbcService db;
	protected SubmissionFormat submissionFormat;
	
	protected String getInParam(String param) {
		return "'" + StringUtils.replace(param, "|", "','") + "'";
	}
	
	protected String getSelectSql(String alias, String table, String fields) {
		return "SELECT " + "row_id," + fields + " FROM " + table + " " + alias;
	}
	
	protected String getInFilter(boolean isAnd, String field, String param) {
		String res = getAnd(isAnd);
		return res + field + " IN (" + getInParam(param) + ")";
	}
	
	protected String getNotInFilter(boolean isAnd, String field, String param) {
		String res = getAnd(isAnd);
		return res + field + " NOT IN (" + getInParam(param) + ")";
	}
	
	protected String getIsNullFilter(boolean isAnd, String field) {
		String res = getAnd(isAnd);
		return res + field + " IS NULL";
	}
	
	protected String getIsNotNullFilter(boolean isAnd, String field) {
		String res = getAnd(isAnd);
		return res + field + " IS NOT NULL";
	}
	
	protected String getAnd(boolean isAnd) {
		return isAnd ? " AND " : " ";
	}
	
	protected String getLimit() {
		return " LIMIT " + ERROR_LIMIT;
	}

	protected String getMapValue(Map<String, String> params, String key) {
		if (!params.containsKey(key)) {
			log.warn("Validation parameter {} not found", key);
			return null;
		}
		return params.get(key);
	}

	protected RequiredCondition getRequiredConditionParameter(Map<String, String> params, String name) {
		String value = getMapValue(params, name);
		if (StringUtils.isEmpty(value))
			return null;
		return RequiredCondition.valueOf(value);
	}

	@SneakyThrows
	protected List<ValidationResult> validateExistPosConditional(int fileSequence, ConditionalRequired conditional,
			SubmissionField field, String conditionParam) {
		List<ValidationResult> validationResults = new ArrayList<>();
		Map<String, String> params = CollectionUtil.toMap(conditional.getParameter());

		String refPosCode = getMapValue(params, ValidatorParams.REF_POSCODE);
		String refPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1);
		String tableName = db.getTableName(submissionFormat);
		String columnName = db.getColumnName(submissionFormat.getCode(), field.getNumber());
		RequiredCondition falseCondition = getRequiredConditionParameter(params, conditionParam);
		List<String> allColumns = db.getAllColumnName(submissionFormat);

		// TODO: REMOVE HARD-CODED VALUES
		StringBuilder sql = new StringBuilder(getSelectSql("", tableName, String.join(",", allColumns)))
				.append(" WHERE ").append(getNotInFilter(false, refPosCodeColumn, refPosCode));
		if (falseCondition.equals(RequiredCondition.M)) {
			sql.append(getIsNullFilter(true, columnName));
		} else if (falseCondition.equals(RequiredCondition.N)) {
			sql.append(getIsNotNullFilter(true, columnName));
		}
		sql.append(getLimit());

		Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
		errors.entrySet().forEach(entry -> {
			ValidationResult result = new ValidationResult(fileSequence, entry.getKey(), entry.getValue());
			ValidationError error = null;
			String[] entryArr = StringUtils.splitPreserveAllTokens(entry.getValue(), "|");
			if (StringUtils.isEmpty(entryArr[field.getNumber()]) && falseCondition == RequiredCondition.M) {
				error = new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY);
			} else if (!StringUtils.isEmpty(entryArr[field.getNumber()])
					&& falseCondition == RequiredCondition.N) {
				error = new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY);
			}
			if (error != null) {
				result.errors.add(error);
			}
			validationResults.add(result);
		});
		return validationResults;
	}
}
