package id.go.ojk.client.db.validation.field;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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

@XStreamAlias("EqualsComparePosFormValidation")
public class EqualsComparePosFormValidation extends EqualsValidation implements IFieldValidation {
	private String selectPosCode;
	private String selectField;
	private String fieldComparator2;
	private String comparatorForm;
	private String comparatorPosCode;

	public EqualsComparePosFormValidation(String params) {
		super(params);
	}

	@Override
	public EqualsComparePosFormValidation initialized() {
		super.initialized();
		selectField = getStringParameter("selectField");
		selectPosCode = getStringParameter("selectPosCode");
		fieldComparator2 = getStringParameter("fieldComparator2");
		comparatorForm = getStringParameter("comparatorForm");
		comparatorPosCode = getStringParameter("comparatorPosCode", "0010010000");
		return this;
	}

	@Override
	@SneakyThrows
	public List<ValidationResult> validate(int fileSequence, SubmissionFormat submissionFormat,
			SubmissionField submissionField) {
		JdbcService db = ApplicationContextClient.getInstance().getService(JdbcService.class);
		long errorLimit = ConfigService.maxErrorCount.getDefauldValue() + 1;

		int selectFieldInt = Integer.parseInt(selectField);
		int fieldComparator1Int = Integer.parseInt(fieldComparator);
		int fieldComparator2Int = Integer.parseInt(fieldComparator2);

		String columnPrefixA = "a";
		String columnPrefixB = "b";

		List<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		String tableA = db.getTableName(submissionFormat, comparatorForm, columnPrefixA);
		String tableB = db.getTableName(submissionFormat, submissionFormat.getCode(), columnPrefixB);
		List<String> allColumnsB = db.getAllColumnName(submissionFormat, columnPrefixB);

		String selectPosCodeColumn = db.getColumnName(submissionFormat.getCode(), 1, columnPrefixB);
		String columnB = db.getColumnName(submissionFormat, submissionField.getNumber(), columnPrefixB);
		String columnA = db.getColumnName(submissionFormat, fieldComparator1Int, columnPrefixA);
		String comparatorColumnA = db.getColumnName(comparatorForm, fieldComparator2Int, columnPrefixA);
		String comparatorColumnB = db.getColumnName(submissionFormat, selectFieldInt, columnPrefixB);

		final String SELECT = "SELECT DISTINCT ";
		final String FROM = " FROM ";
		StringBuilder sqlA = new StringBuilder(SELECT).append(columnA).append(FROM).append(tableA)
				.append(" WHERE a.column1 = ").append(StringUtils.wrap(comparatorPosCode, "'"));
		StringBuilder sqlB = new StringBuilder(SELECT).append(comparatorColumnA).append(FROM).append(tableA)
				.append(" WHERE a.column1 = ").append(StringUtils.wrap(comparatorPosCode, "'"));
		StringBuilder sql = new StringBuilder(SELECT).append(columnPrefixB).append(".row_id,")
				.append(String.join(",", allColumnsB)).append(FROM).append(tableB).append(" WHERE ")
				.append(selectPosCodeColumn).append(" = '").append(selectPosCode).append("' AND ")
				.append(columnB).append(" IS NOT NULL AND ").append(comparatorColumnB).append(" IS NOT NULL AND (")
				.append(columnB).append(" NOT IN (").append(sqlA).append(")").append(" OR (").append(columnB)
				.append(" IN (").append(sqlA).append(") AND ").append(comparatorColumnB).append(" NOT IN (")
				.append(sqlB).append(")").append("))").append(" LIMIT ").append(errorLimit).append(";");
		Map<Integer, String> errors = ResultSetUtil.sqlToCsv(db, sql.toString());
		if (!errors.isEmpty()) {
			String errString = genErrorMessage(submissionField, selectFieldInt, fieldComparator1Int,
					fieldComparator2Int, comparatorForm);
			ValidationError validationError = new ValidationError(submissionField, ValidationErrorCode.E99_00_OTHER,
					errString);
			errors.entrySet().forEach(e -> {
				ValidationResult validationResult = new ValidationResult(fileSequence, e.getKey(), e.getValue());
				validationResult.errors.add(validationError);
				validationResults.add(validationResult);
			});
		}

		return validationResults;
	}

	private String genErrorMessage(SubmissionField submissionField, int selectField, int fieldComparator,
			int fieldComparator2, String comparatorForm) {
		StringBuilder sb = new StringBuilder().append("Isian kolom ").append((submissionField.getNumber() + 1))
				.append(" dan ").append((selectField + 1)).append(" tidak sesuai dengan isian kolom ")
				.append((fieldComparator + 1)).append(" dan ").append((fieldComparator2 + 1)).append(" pada form ")
				.append(comparatorForm);
		return sb.toString();
	}
}
