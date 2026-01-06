package id.go.ojk.client.model.config.validation.segmen;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("IsExistsFormValidation")
public class IsExistsFormValidation extends MapParamSegmentValidation {
	protected String rowCode;
	protected String column;
	private String comparatorForm;
	private String comparatorColumn;

	public IsExistsFormValidation() {
		super();
	}

	public IsExistsFormValidation(String parameter) {
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;

	@Override
	public IsExistsFormValidation initialized() {
		rowCode = getStringParameter("rowCode");
		column = getStringParameter("column");
		comparatorForm = getStringParameter("comparatorForm");
		comparatorColumn = getStringParameter("comparatorColumn");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<String> rowCodes = Arrays.asList(StringUtils.split(rowCode, "|"));
		if (!rowCodes.contains(validationResult.getColumn(1))) {
			return;
		}
		List<SubmissionField> fields = submissionFormat.getFields();
		String[] arrColumn = StringUtils.split(column, "|");
		for (String field : arrColumn) {
			String fieldValueString = validationResult.getColumn(Integer.parseInt(field));
			if (!isExists(fieldValueString)) {
				SubmissionField submissionField = fields.get(Integer.parseInt(field));
				validationResult.errors
						.add(new ValidationError(submissionField, ValidationErrorCode.E50_06_VALUE_NOT_FOUND,
								fieldValueString, comparatorForm, comparatorColumn));
			}
		}
	}

	private boolean isExists(String value) {
		for (Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValueForm.entrySet()) {
			if (entry.getKey().startsWith(comparatorForm)) {
				String colValue = entry.getValue().get(comparatorColumn);
				if (value.equals(colValue)) {
					return true;
				}
			}
		}
		return false;
	}
}