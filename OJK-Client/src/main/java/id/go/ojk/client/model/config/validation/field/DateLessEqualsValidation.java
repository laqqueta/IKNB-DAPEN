package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("DateLessEqualsValidation")
public class DateLessEqualsValidation extends MapParamFieldValidation {
	protected String fieldComparator;

	public DateLessEqualsValidation() { }

	public DateLessEqualsValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public DateLessEqualsValidation initialized() {
		fieldComparator = getStringParameter("fieldComparator");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(DateLessEqualsValidation.class);
		try {
			int currentColumn = field.getNumber();
			String currentValue = validationResult.getColumn(currentColumn);
			if (StringUtils.isEmpty(currentValue)) {
				return;
			}
			LocalDate realValue = LocalDate.parse(currentValue, DateUtil.dateTimeFormatterYYYYmmss);
			int comparatorColumn = Integer.parseInt(fieldComparator);
			LocalDate comparatorValue = LocalDate.parse(validationResult.getColumn(comparatorColumn), DateUtil.dateTimeFormatterYYYYmmss);
			if (comparatorValue.isBefore(realValue)) {
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_18_DATE_LESS_EQUALS,
						currentColumn + 1, comparatorColumn + 1));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
